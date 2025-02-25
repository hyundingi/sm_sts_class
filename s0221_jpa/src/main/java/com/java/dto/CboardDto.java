package com.java.dto;

import java.sql.Timestamp;
import java.util.List;

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
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class CboardDto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // 자동시퀀스
	private int cno;

	@ManyToOne // 댓글 개수 여러개 , id 1개
	@JoinColumn(name="id") //fk키 등록
	private MemberDto memberDto;
	// private String id;
	@Column(nullable = true, length=100)
	private String cpw;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="bno")
	private BoardDto boardDto;
//	private int bno;
	
	@Lob
	private String ccontent;
	private Timestamp cdate;
	
	// boarddto를 가져올 때 cboardDto도 같이 가져올 수 있음
//	@OneToMany(mappedBy = "BoardDto") // fk는 생성하지 않고 가져오기
//	private List<CboardDto> cboadDto;

}
