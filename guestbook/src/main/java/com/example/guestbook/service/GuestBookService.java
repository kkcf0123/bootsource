package com.example.guestbook.service;

import java.util.List;

import com.example.guestbook.dto.GuestBookDto;
import com.example.guestbook.dto.PageRequestDto;
import com.example.guestbook.dto.PageResultDto;
import com.example.guestbook.entity.GuestBook;

public interface GuestBookService {
    // paging 전
    // public List<GuestBookDto> getList();

    // PageResultDto<DTO, EN>
    PageResultDto<GuestBookDto, GuestBook> getList(PageRequestDto requestDto);

    public GuestBookDto getRow(Long gno);

    public Long updateRow(GuestBookDto updateDto);

    public void deleteRow(Long gno);

    public Long createRow(GuestBookDto createDto);

    public default GuestBookDto entityToDto(GuestBook guestBook) {
        return GuestBookDto.builder()
                .gno(guestBook.getGno())
                .title(guestBook.getTitle())
                .content(guestBook.getContent())
                .writer(guestBook.getWriter())
                .createdDate(guestBook.getCreatedDate())
                .lastModifiedDate(guestBook.getLastModifiedDate())
                .build();
    }

    public default GuestBook dtoToEntity(GuestBookDto dto) {
        return GuestBook.builder()
                .gno(dto.getGno())
                .title(dto.getTitle())
                .content(dto.getContent())
                .writer(dto.getWriter())
                .build();
    }
}
