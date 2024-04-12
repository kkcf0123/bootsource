package com.example.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.jpa.entity.Address;
import com.example.jpa.entity.Order;
import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {

    @Query("SELECT o.homeAddress FROM Order o")
    List<Address> findByHomeAddress(Address homeAddress);

    @Query("SELECT o.member2, o.product, o.homeAddress FROM Order o")
    List<Object[]> findByHomeAddress1(Address homeAddress);

}
