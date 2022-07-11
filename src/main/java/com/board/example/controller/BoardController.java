package com.board.example.controller;

import com.board.example.dto.BoardDTO;
import com.board.example.service.BoardService;
import com.board.example.util.Paging;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;

@Slf4j
@Controller
@RequestMapping("/board/*")
public class BoardController {

	@Autowired
	BoardService boardService;

	@ResponseBody
	@RequestMapping("list-json.do")
	public HashMap boardMenu(Paging paging) throws Exception {
		List<BoardDTO> list = boardService.boardList(paging);
		HashMap map = new HashMap();
		map.put("list", list);
		return map;
	}
	
	@RequestMapping("list.do")
	public String boardList(Model model, Paging paging) throws Exception {

		if(paging.getPageIndex() < 1) {
			paging.setPageIndex(1);
		}
		paging.setPageSize(20);
		paging.handlePaging(paging.getPageIndex(), paging.getPageSize());
		List<BoardDTO> resultList = boardService.boardList(paging);
		int count = boardService.boardCount(paging);
		paging.handlePagingList(resultList, count);

		model.addAttribute("list", paging.getResultList());
		model.addAttribute("count", paging.getTotalCount());
		model.addAttribute("pageBlock", Math.round(paging.getTotalCount()/paging.getPageSize()));
		model.addAttribute("paging", paging);
		return "board/board_list";
	}

	@RequestMapping("view.do")
	public String boardView(Model model, Paging paging) throws Exception {
		long start = System.currentTimeMillis();
		BoardDTO BoardDTO = boardService.boardView(paging);
		int result = boardService.updateBoardHit(paging);
		model.addAttribute("view", BoardDTO);
		long end = System.currentTimeMillis();

		return "board/board_view";
	}
	
}