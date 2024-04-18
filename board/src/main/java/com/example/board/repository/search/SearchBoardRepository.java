package com.example.board.repository.search;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface SearchBoardRepository {

    // 전체 조회를 위해서 Object[]를 사용
    Page<Object[]> list(Pageable pageable);

    Object[] getRow(Long bno);
}
