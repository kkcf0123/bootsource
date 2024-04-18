package com.example.board.service;

import java.util.function.Function;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.board.dto.BoardDto;
import com.example.board.dto.PageRequestDto;
import com.example.board.dto.PageResultDto;
import com.example.board.entity.Board;
import com.example.board.entity.Member;
import com.example.board.repository.BoardRepository;
import com.example.board.repository.ReplyRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class BoardServiceImpl implements BoardService {

    private final BoardRepository boardRepository;

    private final ReplyRepository replyRepository;

    @Override
    public PageResultDto<BoardDto, Object[]> getList(PageRequestDto requestDto) {
        // Pageable pageable = PageRequest.of(0, 10, Sort.by("bno").descending());
        Page<Object[]> result = boardRepository.list(PageRequest.of(0, 10, Sort.by("bno").descending()));

        Function<Object[], BoardDto> fn = (entity -> entityToDto((Board) entity[0],
                (Member) entity[1],
                (Long) entity[2]));

        // return result.stream().map(fn).collect(Collectors.toList());
        return new PageResultDto<>(result, fn);

    }

    @Override
    public BoardDto getRow(Long bno) {
        Object[] row = boardRepository.getRow(bno);
        return entityToDto((Board) row[0], (Member) row[1], (Long) row[2]);

    }

    @Override
    public void updateRow(BoardDto updateDto) {
        Board entity = boardRepository.findById(updateDto.getBno()).get();
        entity.setTitle(updateDto.getTitle());
        entity.setContent(updateDto.getContent());
        boardRepository.save(entity);
    }

    @Transactional
    @Override
    public void removeWithReplies(Long bno) {
        // 자식(댓글) 삭제
        replyRepository.deleteByBno(bno);
        // 부모(원본글) 삭제
        boardRepository.deleteById(bno);
    }

}
