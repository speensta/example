package com.board.example.dto;

import lombok.Data;
import org.apache.ibatis.type.Alias;

import java.util.Date;

@Data
@Alias("boardDTO")
public class BoardDTO {
	//Field
	private int bno;		//게시물번호
	private String btitle;	//게시물제목
	private String bcontent;	//게시물내용
	private String bowner;	//게시물작성자
	private Date bregdate;	//게시물작성일자

}