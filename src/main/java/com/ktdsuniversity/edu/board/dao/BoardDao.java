package com.ktdsuniversity.edu.board.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ktdsuniversity.edu.board.vo.BoardVO;
import com.ktdsuniversity.edu.board.vo.request.WriteVO;

@Mapper
public interface BoardDao {

	int selectBoardCount();

	List<BoardVO> selectBoardList();

	
	
	BoardVO selectBoardById(String boardId);

	int updateViewCntIncreaseById(String boardId);

	int insertNewBoard(WriteVO writeVO);
	
	int deleteBoardByArticleId(String boardId);

}
