package com.ktdsuniversity.edu.members.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.ktdsuniversity.edu.members.service.MembersService;
import com.ktdsuniversity.edu.members.vo.request.MembersVO;

@Controller
public class MembersController {
	
	@Autowired
	private MembersService membersService;
	
	@GetMapping("/regist")
	public String getMember() {
		return "members/regist";
	}
	
	@PostMapping("/regist")
	public String postMember(MembersVO membersVO) {
		System.out.println(membersVO.getEmail());
		System.out.println(membersVO.getName());
		System.out.println(membersVO.getPassword());
		
		// 회원을 등록
		boolean createMember = this.membersService.createNewMember(membersVO);
		
		
		return"redirect:/login";
	}

}
