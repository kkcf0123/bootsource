package com.example.jpa.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.jpa.entity.Board;

public interface BoardRepository extends JpaRepository<Board, Long> {
    // @Query(value = "SELECT * FROM board", nativeQuery = true)
    // List<Board> findList();

    // @Query("SELECT b FROM Board b FROM b.title LIKE %?1%")
    // List<Board> findByTitle(String title);

    // @Query("SELECT b FROM Board b FROM b.writer LIKE %?1%")
    // List<Board> findByTitleLike(String title);

    // List<Board> findByTitleStartingWith(String title);

    // List<Board> findByTitleEndingWith(String title);

    // List<Board> findByTitleContaining(String title);

    // List<Board> findByWriter(String writer);

    // List<Board> findByWriterStartingWith(String writer);

    // // @Query("SELECT b FROM Board b FROM b.title LIKE %?1% or b.content = ?2")
    // @Query("SELECT b FROM Board b FROM b.title LIKE %:title% or b.content =
    // :content")
    // List<Board> findByTitleContainingOrContent(String title, String content);

    // List<Board> findByIdGreaterThanOrderByIdDesc(Long id);

    // List<Board> findByIdGreaterThanOrderByIdDesc(Long id, Pageable pageable);

}
