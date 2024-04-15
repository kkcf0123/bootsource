package com.example.guestbook.service;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.guestbook.dto.GuestBookDto;
import com.example.guestbook.entity.GuestBook;
import com.example.guestbook.repository.GuestBookRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class GuestBookServiceImpl implements GuestBookService {

    private final GuestBookRepository guestBookRepository;

    @Override
    public List<GuestBookDto> getList() {
        List<GuestBook> list = guestBookRepository.findAll();

        Function<GuestBook, GuestBookDto> fn = (entity -> entityToDto(entity));
        return list.stream().map(fn).collect(Collectors.toList());
    }

    @Override
    public GuestBookDto getRow(Long id) {
        GuestBook entity = guestBookRepository.findById(id).get();
        return entityToDto(entity);
    }

}
