package com.board.example.controller;

import com.board.example.service.BoardService;
import com.board.example.util.Paging;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/onedrive/*")
public class OnedriveController {

	@Autowired
	BoardService boardService;

	@RequestMapping("list.do")
	public String list(Model model, Paging paging) throws Exception {

		return "onedrive/list";
	}
	
}