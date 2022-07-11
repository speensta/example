package com.board.example.util;

import com.board.example.domain.BoardDomain;
import lombok.Data;

import java.util.List;

@Data
public class Paging extends BoardDomain {
    private int pageIndex;
    private int startRow;
    private int endRow;
    private int pageSize;
    private List<?> resultList;
    private int totalCount;

    // startRow, endRow를 계산한다.
    public void handlePaging(int pageIndex, int pageSize) {
        this.pageIndex = pageIndex < 1 ? 1 : pageIndex;
        this.pageSize = pageSize;
        this.startRow = ((pageIndex-1) * pageSize);
        this.endRow = startRow + pageSize;
    }

    // 페이징 처리된 결과값을 담는 메서드
    public void handlePagingList(List<?> resultList, int totalCount) {
        this.resultList = resultList;
        this.totalCount = totalCount;
    }

    public int getPageIndex() {
        return pageIndex;
    }

    public int getStartRow() {
        return startRow;
    }

    public int getEndRow() {
        return endRow;
    }

    public int getPageSize() {
        return pageSize;
    }

    public List<?> getResultList() {
        return resultList;
    }

    public int getTotalCount() {
        return totalCount;
    }
}
