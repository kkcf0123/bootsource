package com.example.guestbook.repository;

import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.guestbook.entity.GuestBook;

@SpringBootTest
public class GuestBookRepositoryTest {

    @Autowired
    private GuestBookRepository guestBookRepository;

    @Test
    public void testInsert() {
        IntStream.rangeClosed(1, 330).forEach(i -> {
            GuestBook guestBook = GuestBook.builder()
                    .title("쥬시쿨" + i)
                    .content("맛있다" + i)
                    .writer("빙그레" + (i % 10))
                    .build();
            guestBookRepository.save(guestBook);
        });
    }

    @Test
    public void testRead() {
        List<GuestBook> guestBooks = guestBookRepository.findAll();
        guestBooks.forEach(guestBook -> {
            System.out.println(guestBook);
        });
    }

    @Test
    public void testRow() {
        System.out.println(guestBookRepository.findById(20L));
    }

    @Test
    public void testUpdate() {
        GuestBook guestBook = guestBookRepository.findById(20L).get();
        guestBook.setTitle("modified title");
        guestBook.setContent("modified content");
        System.out.println(guestBookRepository.save(guestBook));

    }

    @Test
    public void testDelete() {
        GuestBook guestBook = guestBookRepository.findById(19L).get();
        guestBookRepository.delete(guestBook);
    }

}
