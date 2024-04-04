package com.example.jpa.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.jpa.Dto.MemoDto;
import com.example.jpa.entity.Memo;
import com.example.jpa.repository.MemoRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MemoServiceImpl {

    // if @Autowired doesn't exist, must create object like
    // private final MemoRepository memoRepository = new MemoRepository();
    // or
    // public MemoServiceImpl(MemoRepository memoRepository) {
    // this.memoRepository = memoRepository;
    // }

    @Autowired
    private final MemoRepository memoRepository;

    public List<MemoDto> getMemoList() {
        List<Memo> entites = memoRepository.findAll();
        List<MemoDto> list = new ArrayList<>();
        entites.forEach(entity -> list.add(entityToDto(entity)));
        return list;
    }

    public MemoDto getMemo(Long mno) {
        Memo entity = memoRepository.findById(mno).get();
        return entityToDto(entity);

    }

    public MemoDto updateMemo(MemoDto mDto) {
        // search
        Memo entity = memoRepository.findById(mDto.getMno()).get();

        // modify
        entity.setMemoText(mDto.getMemoText());

        // return
        return entityToDto(memoRepository.save(entity));
    }

    public void deleteMemo(Long mno) {
        // Memo entity = memoRepository.findById(mno).get();

        // memoRepository.delete(entity);
        memoRepository.deleteById(mno);
    }

    private MemoDto entityToDto(Memo entity) {
        MemoDto mDto = MemoDto.builder()
                .mno(entity.getMno())
                .memoText(entity.getMemoText())
                .build();

        return mDto;

    }

}
