package com.java.service;

import java.util.List;

import org.hibernate.metamodel.internal.MemberResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.dto.MemberDto;
import com.java.repository.MemberRepository;

@Service
public class MemberServiceImpl implements MemberService {
	
	@Autowired MemberRepository memberRepository;

	@Override // 회원가입
	public void save(MemberDto mdto) {
		memberRepository.save(mdto); //  자동으로 저장, mapper.xml 이 필요없다.
		
	}

	@Override // 전체 회원 리스트
	public List<MemberDto> findAll() {
		List<MemberDto> list = memberRepository.findAll();
		return list;
	}

	@Override
	public MemberDto findById(String id) {
		// findById > 검색이 없을 경우 에러처리를 해야함 (.orElseThrow())
		// select * from memberdto where id = #{id} 한거랑 동일
		// findByIdAndPw
		// select * from memberdto where id=#{id} and pw=#{pw}
		MemberDto member = memberRepository.findById(id)
				.orElseThrow(()->{
			return new IllegalArgumentException("데이터 처리시 에러!");
		});
		return member;
	}

	@Override // 멤삭
	public void deleteById(String id) {
		memberRepository.deleteById(id);
		
	}

	@Override // 로그인
	public MemberDto findByIdAndPw(String id, String pw) {
		MemberDto memberDto = memberRepository.findByIdAndPw(id,pw);
		return memberDto;
	}

}
