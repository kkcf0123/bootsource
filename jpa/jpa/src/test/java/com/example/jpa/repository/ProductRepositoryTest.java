package com.example.jpa.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Sort;

import com.example.jpa.entity.Member2;
import com.example.jpa.entity.Product;
import com.example.jpa.entity.QMember;
import com.example.jpa.entity.QMember2;
import com.example.jpa.entity.QProduct;
import com.querydsl.core.BooleanBuilder;

@SpringBootTest
public class ProductRepositoryTest {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private Member2Repository member2Repository;

    @Test
    public void testQueryDsl() {
        QProduct qProduct = QProduct.product;

        Iterable<Product> products = productRepository.findAll(qProduct.name.eq("제품1"));

        products = productRepository.findAll(qProduct.name.eq("제품1").and(qProduct.price.gt(5000)));
        products = productRepository.findAll(qProduct.name.eq("제품1").and(qProduct.price.goe(5000)));

        BooleanBuilder builder = new BooleanBuilder();
        builder.and(qProduct.name.eq("제품1"));
        builder.and(qProduct.price.goe(5000));

        // products = productRepository.

        products = productRepository.findAll(qProduct.name.contains("제품"));
        products = productRepository.findAll(qProduct.name.startsWith("제품"));
        products = productRepository.findAll(qProduct.name.endsWith("제품"));
        for (Product pro : products) {
            System.out.println(pro);
        }

    }

    @Test
    public void test2() {
        QMember2 member2 = QMember2.member2;

        BooleanBuilder builder = new BooleanBuilder();
        builder.and(member2.userName.eq("User1"));

        Iterable<Member2> list = member2Repository.findAll(builder, Sort.by("id").descending());
        for (Member2 mem : list) {
            System.out.println(mem);
        }
    }
}
