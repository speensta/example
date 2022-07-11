package com.board.example.service;

import com.board.example.domain.BoardDomain;
import com.board.example.dto.BoardDTO;
import com.board.example.util.Paging;
import org.springframework.stereotype.Service;

import java.util.List;


public interface BoardService {
	// 게시물 목록 조회
	List<BoardDTO> boardList(Paging paging) throws Exception;

	BoardDTO boardView(Paging paging) throws Exception;

	int boardCount(Paging paging) throws Exception;

	int updateBoardHit(Paging paging) throws Exception;

}
