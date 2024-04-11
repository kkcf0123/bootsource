package com.example.jpa.repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.LongStream;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import com.example.jpa.entity.Board;

@SpringBootTest
public class BoardRepositoryTest {

    @Autowired
    private BoardRepository boardRepository;

    @Test
    public void insertTest() {
        // LongStream.range(1, 100); // 1~99
        LongStream.rangeClosed(1, 100).forEach(i -> {
            Board board = Board.builder()
                    .title("Title...." + i)
                    .content("Content...." + i)
                    .writer("user" + (i % 10))
                    .build();

            boardRepository.save(board);
        });

    }

    @Test
    public void readTest() {
        System.out.println(boardRepository.findById(1L));
    }

    @Test
    public void getListTest() {
        boardRepository.findAll().forEach(board -> System.out.println(board));
    }

    @Test
    public void updateTest() {
        Optional<Board> result = boardRepository.findById(26L);

        result.ifPresent(board -> {
            board.setTitle("Update Title...");
            board.setContent("Update Content");
            System.out.println(boardRepository.save(board));
        });
    }

    @Test
    public void deleteTest() {
        Optional<Board> result = boardRepository.findById(24L);
        // Board board = result.get();
        // boardRepository.delete(board);
    }

    @Test
    public void queryMethodTest() {
        // List<Board> list = boardRepository.findByTitle("Title");
        // System.out.println("findbytitle : " + list.size());
        // list = boardRepository.findByTitleLike("Title");
        // System.out.println("findbytitleLike : " + list.size());
        // list = boardRepository.findByTitleStartingWith("Title");
        // System.out.println("findbytitleStartingWith : " + list.size());
        // list = boardRepository.findByTitleEndingWith("Title");
        // System.out.println("findbytitleEndingWith : " + list.size());
        // list.forEach(System.out::println);

        // List<Board> list = boardRepository.findByWriterStartingWith("User");
        // list.forEach(System.out::println);

        // where b1_0.title like ? escape '\' or b1_0.content=?
        // List<Board> list = boardRepository.findByTitleContainingOrContent("Title",
        // "Content");
        // list.forEach(System.out::println);

        Pageable pageable = PageRequest.of(1, 10);
        List<Board> list = boardRepository.findByIdGreaterThanOrderByIdDesc(0L, pageable);
        list.forEach(System.out::println);
        // System.out.println("Greater " + list.size());
    }
}
