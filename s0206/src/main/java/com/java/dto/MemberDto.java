package com.java.dto;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor // 전체생성자
@NoArgsConstructor // 기본생성자
@Getter
@Setter
// @Data : getter setter 가 포함되어서 만들어짐
public class MemberDto {
	private String id;
	private String pw;
	private String name;
	private String tel;
	private String gender;
	private String hobby;
	
	
	public MemberDto(String id, String pw) {
		this.id = id;
		this.pw = pw;
	}



	
	
	
	
	
	

}
