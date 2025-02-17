package com.java.service;

import com.java.dto.MemberDto;

public interface MemberService {

	MemberDto login(MemberDto mdto);
	
	// 메일발송 text
	String sendEmail(String email);

	// 메일발송 html
	String sendEmail2(String email);

}
