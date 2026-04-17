package com.ktdsuniversity.edu.board.vo.request;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

/**
 * 게시글 등록을 위해
 * 브라우저에서 컨트롤러(앤드포인트)로 전송되는 파라미터를 받아오기 위한 클래스
 * 
 * Spring이 파라미터를 WriteVO의 멤버변수로 할당할 때
 * setter를 이용
 */
public class WriteVO {
	
	private String id;
	
	@NotBlank(message = "제목을 입력해주세요(3글자 이상)")
	@Size(min = 3, message=" ")
	private String subject;
	
	@Email(message = "이메일 형태가 아닙니다")
	private String email;
	
	private String content;
	
	private List<MultipartFile> attachFile; // 업로드 한 건 항상 MultipartFile로 가져온다
	
	private String fileGroupId;
	
	
	public String getId() {
		return this.id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getSubject() {
		return this.subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getEmail() {
		return this.email;
	}	
	public void setEmail(String email) {
		this.email = email;
	}
	public String getContent() {
		return this.content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public List<MultipartFile> getAttachFile() {
		return this.attachFile;
	}
	public void setAttachFile(List<MultipartFile> attachFile) {
		this.attachFile = attachFile;
	}
	public String getFileGroupId() {
		return this.fileGroupId;
	}
	public void setFileGroupId(String fileGroupId) {
		this.fileGroupId = fileGroupId;
	}
	
	
	
}
