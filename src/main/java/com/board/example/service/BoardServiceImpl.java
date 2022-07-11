package com.board.example.service;

import com.board.example.dto.BoardDTO;
import com.board.example.mapper.BoardMapper;
import com.board.example.util.Paging;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;

@Service("boardService")
public class BoardServiceImpl implements BoardService {

	@Autowired
	private BoardMapper boardMapper;

	@Override
	@Cacheable(cacheNames = "translationCache", key = "#paging.pageIndex")
	public List<BoardDTO> boardList(Paging paging) throws Exception {
		return boardMapper.boardList(paging);
	}

	@Override
	@Cacheable(cacheNames = "translationCache2", key = "#paging.bno")
	public BoardDTO boardView(Paging paging) throws Exception {
		return boardMapper.boardView(paging);
	}

	@Override
	@Cacheable(cacheNames = "translationCacheCount", key = "#paging.pageIndex")
	public int boardCount(Paging paging) throws Exception {
		return boardMapper.boardCount(paging);
	}

	@Override
	public int updateBoardHit(Paging paging) throws Exception {
		return boardMapper.updateBoardHit(paging);
	}
}
