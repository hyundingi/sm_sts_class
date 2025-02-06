package com.java.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor // 전체생성자
@NoArgsConstructor  // 기본생성자 
@Data               // getter setter
@Builder
public class MemDto {
	private String id;
	private String pw;
	private String name;
	private String tel;
	private String gender;
	private String hobby;
	// private String[] hobbys;
	
	public MemDto(String id, String pw) {
		this.id = id;
		this.pw = pw;
	}
}
