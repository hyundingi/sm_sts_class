package com.java.dto;

import java.sql.Timestamp;
import java.util.List;

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
import lombok.ToString;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity //jpa
@ToString(exclude = "clist") // 무한루프 방지, json데이터 호출 : @JsonIgnore
public class EventDto {
	
	@Id //primarykey
	@GeneratedValue(strategy = GenerationType.IDENTITY) // db에 있는 시퀀스 사용
	private int eno;
	
	@Column(nullable = false, length=100)
	private String etitle;
	
	@Lob // 대용량 문자형태
	private String econtent;
	
	@ManyToOne(fetch=FetchType.EAGER) // dafault = eager :: 즉시 가져옴
	@JoinColumn(name="id") // 변경가능 - 닉네임 등 :: foregin key로 id를 사용
	private MemberDto MemberDto;
	@ColumnDefault("0")
	private int ehit;
	@UpdateTimestamp
	private Timestamp edate;
	private String efile;
	private String efile2;
	private Timestamp stdate;
	private Timestamp enddate;
	private int openchk;

	// clist를 foreginkey로 사용하지 말고, eventDto(cboardDto에서 eventdto의 eno랑 연결되어있는거)
	@OneToMany(mappedBy = "eventDto", fetch=FetchType.EAGER) //default LAZY : 지연 전략 > 요청할 때 가져다줌
	private List<CboardDto> clist;
}
