package com.example.jpa.repository;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.jpa.entity.Memo;

@SpringBootTest // test전용 클래스
public class MemoRepositoryTest {

    @Autowired // MemoRepository memoRepository = new MemoRepositoryImpl()
    private MemoRepository memoRepository;

    @Test // test method(return type is void)
    public void insertMemo() {
        for (int i = 0; i < 101; i++) {
            Memo memo = new Memo();
            memo.setMemoText("MemoText" + i);
            memoRepository.save(memo); // == dao.insert()
        }
    }

    public void getMemo() {
        // 특정 아이디 메모 조회
        // Optional : null 체크할 수 있는 메소드 보유
        Optional<Memo> result = memoRepository.findById(21L);
        result.get();
    }

    public void getMemoList() {
        List<Memo> result = memoRepository.findAll();
        for (Memo memo : result) {
            // result.get();
        }
    }

    @Test
    public void updateMemo() {
        Optional<Memo> result = memoRepository.findById(25L);
        Memo memo = result.get();

        memo.setMemoText("Update Title....");
        System.out.println(memoRepository.save(memo));

    }

    @Test
    public void deleteMemo() {
        Optional<Memo> result = memoRepository.findById(24L);
        Memo memo = result.get();

        memoRepository.delete(memo);
    }
}
