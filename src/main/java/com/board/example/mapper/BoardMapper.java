package com.board.example.mapper;

import com.board.example.domain.BoardDomain;
import com.board.example.dto.BoardDTO;
import com.board.example.util.Paging;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
public interface BoardMapper {
    List<BoardDTO> boardList(Paging paging) throws Exception;

    BoardDTO boardView(Paging paging) throws Exception;

    int boardCount(Paging paging) throws Exception;

    int updateBoardHit(Paging paging) throws Exception;
}
