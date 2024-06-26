package com.example.board.repository;

import java.util.List;
import java.util.stream.IntStream;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.board.entity.Board;
import com.example.board.entity.Member;
import com.example.board.entity.Reply;

@SpringBootTest
public class ReplyRepositoryTest {

    @Autowired
    private ReplyRepository replyRepository;

    @Test
    public void testInsert() {
        IntStream.rangeClosed(1, 100).forEach(i -> {
            long bno = (long) (Math.random() * 100) + 1;

            Board board = Board.builder().bno(bno).build();

            Reply reply = Reply.builder()
                    .text("reply" + i)
                    .replyer("guest" + i)
                    .board(board)
                    .build();

            replyRepository.save(reply);
        });
    }

    @Test
    public void getRow() {
        Reply reply = replyRepository.findById(2L).get();
        System.out.println(reply);

        System.out.println(reply.getBoard());
    }

    @Test
    public void getReplies() {
        Board board = Board.builder().bno(100L).build();
        List<Reply> replies = replyRepository.getReliesByBoardOrOrderByRno(board);

        System.out.println(replies.toString());
    }

}
