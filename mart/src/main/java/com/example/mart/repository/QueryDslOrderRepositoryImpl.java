package com.example.mart.repository;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

import com.example.mart.entity.Item;
import com.example.mart.entity.Member;
import com.example.mart.entity.Order;
import com.example.mart.entity.QItem;
import com.example.mart.entity.QMember;
import com.example.mart.entity.QOrder;
import com.example.mart.entity.QOrderItem;
import com.querydsl.core.Tuple;
import com.querydsl.jpa.JPQLQuery;

public class QueryDslOrderRepositoryImpl extends QuerydslRepositorySupport implements QueryDslOrderRepository {

    public QueryDslOrderRepositoryImpl() {
        super(Order.class);
    }

    @Override
    public List<Object[]> joinList() {
        QOrder order = QOrder.order;
        QMember member = QMember.member;
        QOrderItem orderItem = QOrderItem.orderItem;

        JPQLQuery<Order> query = from(order);
        query.innerJoin(order.member, member);
        JPQLQuery<Tuple> tuple = query.select(order, member);

        List<Tuple> result = tuple.fetch();

        List<Object[]> list = result.stream().map(t -> t.toArray()).collect(Collectors.toList());
        return null;
    }

    @Override
    public List<Member> members() {
        QMember member = QMember.member;
        JPQLQuery<Member> query = from(member);
        query.where(member.name.eq("user1")).orderBy(member.name.desc());

        JPQLQuery<Member> tuple = query.select(member);
        List<Member> list = tuple.fetch();
        return list;

    }

    @Override
    public List<Item> items() {
        QItem item = QItem.item;

        JPQLQuery<Item> query = from(item);
        query.where(item.name.eq("바지").and(item.price.gt(20000)));
        JPQLQuery<Item> tuple = query.select(item);
        List<Item> list = tuple.fetch();
        return list;
    }

}
