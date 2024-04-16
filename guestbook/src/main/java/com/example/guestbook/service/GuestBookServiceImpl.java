package com.example.guestbook.service;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.guestbook.dto.GuestBookDto;
import com.example.guestbook.dto.PageRequestDto;
import com.example.guestbook.dto.PageResultDto;
import com.example.guestbook.entity.GuestBook;
import com.example.guestbook.repository.GuestBookRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class GuestBookServiceImpl implements GuestBookService {

    private final GuestBookRepository guestBookRepository;

    // @Override
    // public List<GuestBookDto> getList() {
    // List<GuestBook> list = guestBookRepository.findAll();

    // Function<GuestBook, GuestBookDto> fn = (entity -> entityToDto(entity));
    // return list.stream().map(fn).collect(Collectors.toList());
    // }

    @Override
    public PageResultDto<GuestBookDto, GuestBook> getList(PageRequestDto requestDto) {
        Pageable pageable = requestDto.getPageable(Sort.by("gno").descending());
        Page<GuestBook> result = guestBookRepository.findAll(pageable);
        Function<GuestBook, GuestBookDto> fn = (entity -> entityToDto(entity));

        return new PageResultDto<GuestBookDto, GuestBook>(result, fn);
    }

    @Override
    public GuestBookDto getRow(Long gno) {
        GuestBook entity = guestBookRepository.findById(gno).get();
        return entityToDto(entity);
        // return entityToDto(guestBookRepository.findById(gno).get());
    }

    @Override
    public Long updateRow(GuestBookDto updateDto) {
        GuestBook entity = guestBookRepository.findById(updateDto.getGno()).get();
        entity.setTitle(updateDto.getTitle());
        entity.setContent(updateDto.getContent());
        GuestBook updateGuestBook = guestBookRepository.save(entity);

        return updateGuestBook.getGno();
    }

    @Override
    public void deleteRow(Long gno) {
        guestBookRepository.deleteById(gno);
        // GuestBook entity = guestBookRepository.findById(gno).get();
        // guestBookRepository.delete(entity);

    }

    @Override
    public Long createRow(GuestBookDto createDto) {

        GuestBook guestBook = guestBookRepository.save(dtoToEntity(createDto));

        return guestBook.getGno();

    }

}
