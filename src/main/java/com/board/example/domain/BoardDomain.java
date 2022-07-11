package com.board.example.domain;

import com.board.example.util.Paging;
import lombok.Data;
import org.apache.ibatis.type.Alias;

import java.util.Date;
import java.util.List;

@Data
@Alias("boardDTO")
public class BoardDomain {
	private int bno;
	private String btitle;
	private String bcontent;
	private String bowner;
	private Date bregdate;

	private Paging paging;
	private int pageIndex;
	private int startRow;
	private int endRow;
	private int pageSize;
	private int totalCount;

}