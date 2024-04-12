package com.example.mart.repository;

import java.util.List;

import com.example.mart.entity.Item;
import com.example.mart.entity.Member;
import com.example.mart.entity.QMember;
import com.example.mart.entity.QOrder;
import com.example.mart.entity.QOrderItem;
import com.querydsl.jpa.JPQLQuery;

public interface QueryDslOrderRepository {

    // @Override
    public List<Object[]> joinList();

    public List<Member> members();

    public List<Item> items();
}
