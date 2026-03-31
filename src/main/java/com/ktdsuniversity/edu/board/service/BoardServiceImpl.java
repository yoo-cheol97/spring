package com.ktdsuniversity.edu.board.service;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.ktdsuniversity.edu.board.dao.BoardDao;
import com.ktdsuniversity.edu.board.enums.ReadType;
import com.ktdsuniversity.edu.board.vo.BoardVO;
import com.ktdsuniversity.edu.board.vo.request.UpdateVO;
import com.ktdsuniversity.edu.board.vo.request.WriteVO;
import com.ktdsuniversity.edu.board.vo.response.SearchResultVO;
import com.ktdsuniversity.edu.files.dao.FilesDao;
import com.ktdsuniversity.edu.files.vo.request.UploadVO;

@Service
public class BoardServiceImpl implements BoardService {

	/**
	 *  빈 컨테이너에 들어있는 객체 중 타입이 일치하는 객체를 할당 받는다
	 */

	@Autowired
	private BoardDao boardDao;
	
	@Autowired
	private FilesDao filesDao;
	
	@Override
	public SearchResultVO findAllBoard() {           
		SearchResultVO result = new SearchResultVO();
		
		// 게시글 개수 조회
		int count = this.boardDao.selectBoardCount();
		result.setCount(count);
		
		if (count == 0) {
			return result;
		}
		
		// 게시글 목록 조회
		List<BoardVO> list = this.boardDao.selectBoardList();
		
		result.setResult(list);
		
		return result;
	}
	
	@Override
	public boolean createNewBoard(WriteVO writeVO) {
		// dao => insert 요청
		// mybatis는 insert, update, delete를 수행했을 때
		// 영향을 받은 row의 수를 반환시킨다
		// 예> insert ==> insert된 row의 개수 반환
		// 예> update ==> update된 row의 개수 반환
		// 예> delete ==> delete된 row의 개수 반환
		int insertCount = this.boardDao.insertNewBoard(writeVO);
		
		// 첨부파일 업로드
		List<MultipartFile> attachFiles = writeVO.getAttachFile();
		if(attachFiles != null && attachFiles.size() > 0 ) {
			for (int i = 0; i < attachFiles.size(); i++)
//			for (MultipartFile uploadedFile: attachFiles) 
				{
				
				//업로드한 파일이 서버 컴퓨터의 파일 시스템에 저장되도록 한다
				File storeFile = new File("C:\\uploadFiles", 
							attachFiles.get(i).getOriginalFilename());
				// C:\\uploadFiles 폴더가 없으면 생성해라
				if (!storeFile.getParentFile().exists()) {
					storeFile.getParentFile().mkdirs();
				}
				try {
					attachFiles.get(i).transferTo(storeFile);
					// FIELS 테이블에 첨부파일 데이터를 INSERT
					UploadVO uploadVO = new UploadVO();
					String filename = attachFiles.get(i).getOriginalFilename();
					String ext = filename.substring(filename.lastIndexOf(".") + 1);
					uploadVO.setFileNum(i + 1);
					uploadVO.setFileGroupId(writeVO.getId());
					uploadVO.setObfuscateName(filename);
					uploadVO.setDisplayName(filename);
					uploadVO.setExtendName(ext);
					uploadVO.setFileLength(storeFile.length()); // 실제로 업로드한 파일의 크기를 구해라
					uploadVO.setFilePath(storeFile.getAbsolutePath());
					
					this.filesDao.insertAttachFile(uploadVO);
				} catch (IllegalStateException | IOException e) {
					e.printStackTrace();
				}
			}
		}
		
		System.out.println("생성된 게시글의 개수? " + insertCount);
		return insertCount == 1;
		
		
		
	}
	
	@Override
	public BoardVO findBoardByBoardId(String boardId, ReadType readType) {
		// 1. 조회수 증가
		
		if(readType == ReadType.VIEW) {
		
		int updateCount = this.boardDao.updateViewCntIncreaseById(boardId);
		System.out.println("조회수가 증가된 게시글의 수: " + updateCount);
		
		if(updateCount == 0) {
			// 존재하지 않는 게시글을 조회하려 했다
			return null;
			
//			throw new RuntimeException("존재하지 않는 게시글입니다");
		}
			
		}
		
		// 2. 게시글 조회
		BoardVO board = this.boardDao.selectBoardById(boardId);
		
		// 조회한 게시글을 반환
		return board;
	}

	@Override
	public boolean deleteBoardByArticleId(String id) {
		int deleteCount = this.boardDao.deleteBoardByArticleId(id);
		System.out.println(deleteCount);
		
		return deleteCount == 1;
	}
	
	public boolean updateBoardByBoardId(UpdateVO updateVO) {
		int updateCount = this.boardDao.updateboardById(updateVO);
		return updateCount ==1;
	}
	

}
