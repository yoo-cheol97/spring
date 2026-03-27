package com.ktdsuniversity.edu.board.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ktdsuniversity.edu.board.service.BoardService;
import com.ktdsuniversity.edu.board.vo.BoardVO;
import com.ktdsuniversity.edu.board.vo.request.WriteVO;
import com.ktdsuniversity.edu.board.vo.response.SearchResultVO;

@Controller
public class BoardController {

	/**
	 * 빈 컨테이너에 들어있는 객체 중 타입이 일치하는 객체를 할당 받는다
	 */
	@Autowired
	private BoardService boardService;

	@GetMapping("/")
	public String viewListPage(Model model) {

		SearchResultVO searchResult = this.boardService.findAllBoard();

		// 게시글의 목록 조회
		List<BoardVO> list = searchResult.getResult();
		// 게시글의 개수 조회
		int searchCount = searchResult.getCount();

		model.addAttribute("searchResult", list);
		model.addAttribute("searchCount", searchCount);

		return "board/list";

	}

	// 게시글 등록 화면 보여주는 EndPoint
	@GetMapping("/write")
	public String viewWritePage() {
		return "board/write";
	}
	
	// 게시글을 등록하는 EndPoint
	@PostMapping("/write")
	public String doWriteAction(@ModelAttribute WriteVO writeVO) {
		System.out.println(writeVO.getSubject());
		System.out.println(writeVO.getEmail());
		System.out.println(writeVO.getContent());
		// create, update, delete ==> 성공과 실패 여부를 반환시켜야함
		boolean createResult = this.boardService.createNewBoard(writeVO);
		
		System.out.println("게시글 생성 성공? " + createResult);
		// redirect: 브라우저에게 다음 EndPoint를 요청하도록 지시
		// redirect:/ ==> 브라우저에게 "/" endpoint로 이동하도록 지시
		return "redirect:/";
	}
	
	// 게시글 내용 조회
	// endpoint ==> /view/게시글 아이디 예> /view/BO-20260327-000008
	// 해야하는 역할
	// 1. 게시글 내용을 조회해서 브라우저에게 노출(제목 이메일 작성 날짜 등등)
	// 2. 조회수 1증가
	
	@GetMapping("/view/{boardId}") //view/BO-20260327-000008
	public String viewDetailPage(Model model, 
			@PathVariable String boardId) {
		
		// boardId로 데이터베이스에서 게시글을 조회한다
		// 조회할 때 조회수가 하나 증가해야 한다
		BoardVO findResult = this.boardService.findBoardByBoardId(boardId);
		
		model.addAttribute("article",findResult);
		
		return "board/view";
	}
	@GetMapping("/delete")
	
	@PostMapping("/delete")
	public String doDelectAction(@RequestParam String id) {
		boolean deleteResult = this.boardService.deleteBoardByArticleId(id);
		return "redirect:/";
	}
	
	

}