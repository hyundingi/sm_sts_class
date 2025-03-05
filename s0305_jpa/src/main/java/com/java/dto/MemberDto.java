package com.java.dto;

import java.sql.Timestamp;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity // jpa에서 데이터 를 관리한다.
public class MemberDto {
	

	@Id // primarykey 지정
	private String id;
	@Column(nullable = false, length=100) // varchar2(100) not null 오라클과 같은 설정 형태
	private String pw;
	@Column(nullable = false, length=30) // varchar2(30) not null 
	private String name;
	@Column(length=20)
	private String phone;
	@ColumnDefault("'남자'")
	private String gender;
	private String hobby;
	@UpdateTimestamp
	private Timestamp mdate;
}
