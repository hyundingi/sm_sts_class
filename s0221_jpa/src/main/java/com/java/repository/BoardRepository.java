package com.java.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.java.dto.BoardDto;

public interface BoardRepository extends JpaRepository<BoardDto, Integer>{

//	@Query(value = "select * from boarddto where btitle like %:search%",
//			nativeQuery = true)
	List<BoardDto> findByBtitleContaining(String search);
	


//	@Query(value = "select * from boarddto order by bgroup desc, bstep asc", nativeQuery = true)
//	Page<BoardDto> findAll(pageable);
}
