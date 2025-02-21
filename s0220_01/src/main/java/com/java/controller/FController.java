package com.java.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.server.reactive.HttpHandler;
import org.springframework.stereotype.Controller;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.java.dto.KakaoProfile;
import com.java.dto.OAuthToken;

import jakarta.servlet.http.HttpSession;

@Controller
public class FController {
	
	@Autowired HttpSession session;

	@GetMapping("/")
	public String index() {
		return "index";
	}
	
	@GetMapping("/login")
	public String login() {
		return "login";
	}
	
	@ResponseBody
	@RequestMapping("/kakao/oauth")
	public String oauth(String code) {
		System.out.println("kakao oauth code : "+code);
		// code = code;
		String grant_type = "authorization_code";
		String client_id = "5c065bc8f939d1303dc54e5a7ed2878a";
		String redirect_uri = "http://localhost:8181/kakao/oauth";
		String content_type = "application/x-www-form-urlencoded;charset=utf-8";
		// http 전송 : restTemplate
		RestTemplate rt = new RestTemplate();
		
		// header
		HttpHeaders headers = new HttpHeaders();
		headers.add("content-Type", content_type);
		
		//4개 데이터 묶기
		MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
		params.add("grant_type", grant_type);
		params.add("client_id", client_id);
		params.add("redirect_uri", redirect_uri);
		params.add("code", code);
	
		// http전송 - heade
		HttpEntity<MultiValueMap<String, String>> kakaoTokenRequest = 
				new HttpEntity<>(params, headers);
		
		// http요청 url
		String oauthUrl = "https://kauth.kakao.com/oauth/token";
		
		// http전송 - 토큰키 받기
		ResponseEntity<String> response = 
		rt.exchange(oauthUrl, HttpMethod.POST, kakaoTokenRequest, String.class);
		
		System.out.println("kakaoToken response : "+response );
		
		// response에서 받은 데이터(json)를 dto 파일에 저장
		ObjectMapper objectMapper = new ObjectMapper();
		OAuthToken oAuthToken = null;
		
		try {
			oAuthToken = objectMapper.readValue(response.getBody(), OAuthToken.class);
		} catch (Exception e) {e.printStackTrace();}
		
		System.out.println(oAuthToken.getAccess_token());
		
		// access_token 분리해서 전송하면, 회원정보 아이디 등등 받아옴
		String access_token = oAuthToken.getAccess_token();
		String authorization = "Bearer "+access_token;
		
		// http 전송 : RestTemplate
		RestTemplate rt2 = new RestTemplate(); 
		
		// header
		HttpHeaders headers2 = new HttpHeaders();
		// headers2.add("", access_token);
		headers2.add("Authorization", authorization);
		headers2.add("Content-Type", content_type);
		
		//1개로 묶기
		HttpEntity<MultiValueMap<String, String>> kakaoTokenRequest2 = 
				new HttpEntity<>(headers2);
		
		// url
		String oauthUrl2 = "https://kapi.kakao.com/v2/user/me";
		
		//http 전송
		ResponseEntity<String> response2 = 	
				rt2.exchange(oauthUrl2,HttpMethod.POST,kakaoTokenRequest2,String.class);
		
		System.out.println("데이터 출력 : "+response2.getBody());
		// response에서 받은 데이터(json)를 dto 파일에 저장
		ObjectMapper objectMapper2 = new ObjectMapper();
		KakaoProfile kakaoProfile = null;
		System.out.println("response2 : "+response2);
		System.out.println("response2 겟바디: "+response2.getBody());
		try {
			kakaoProfile = objectMapper2.readValue(response2.getBody(), KakaoProfile.class);
		} catch (Exception e) {e.printStackTrace();}
		
		System.out.println("kakaoProfile 닉네임 : "+kakaoProfile.getProperties().getNickname());
		System.out.println("kakaoProfile 닉네임 : "+kakaoProfile.getId());
		System.out.println("kakaoProfile_image"+ kakaoProfile.getProperties().getProfile_image());
		// 섹션 저장 - 로그인을 시켜주면 됨
		session.setAttribute("kakaoProfile_nickname", kakaoProfile.getProperties().getNickname());
		session.setAttribute("kakaoProfile_id", kakaoProfile.getId());
		
		return "kakaoProfile 닉네임 : "+kakaoProfile.getId();
	}
}
