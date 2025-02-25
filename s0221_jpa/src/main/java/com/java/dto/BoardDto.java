package com.java.dto;

import java.sql.Timestamp;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class BoardDto {
	
//	@SequenceGenerator(
//			name = "board_seq_generator", // 시퀀스 이름
//			sequenceName = "boarddto_seq", // 생성된 시퀀스 이름
//			initialValue = 1, // 시작값 
//			allocationSize = 1 // 메모리를 통한 할당범위
//			) 
	@Id //primary key
	@GeneratedValue(strategy = GenerationType.IDENTITY) // 시퀀스 자동 생성
	private int bno;
	
	@Column(nullable = false, length = 100)
	private String btitle;
	
	@Lob // 대용량 데이터
	private String bcontent;
	
	// select * from boarddto, memberdto where boarddto.id = memberdto.id
	@ManyToOne(fetch = FetchType.EAGER) // 하나의 id는 many 게시글을 쓸 수 있다
	@JoinColumn(name="id") // Fk키 등록 (memberdto > id)
	private MemberDto memberDto; // memberdto 테이블 primary key - 객체타입 입력 불가
	// private String id; // db에서도 id만 저장
	
	private int bgroup; // 답변달기 그룹핑
	
	@ColumnDefault("0") // 숫자 "0", 남자 "'남자'"
	private int bstep;  // 답변달기 순서
	@ColumnDefault("0") 
	private int bindent; // 답변달기 들여쓰기
	@ColumnDefault("0") 
	private int bhit;
	@UpdateTimestamp // 자동 시간 입력
	private Timestamp bdate;
	
	@Column(nullable = true, length=100)
	private String bfile;
	
	

}
