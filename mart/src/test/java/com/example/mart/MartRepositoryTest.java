package com.example.mart;

import java.time.LocalDateTime;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.mart.entity.Delivery;
import com.example.mart.entity.DeliveryStatus;
import com.example.mart.entity.Item;
import com.example.mart.entity.Member;
import com.example.mart.entity.Order;
import com.example.mart.entity.OrderItem;
import com.example.mart.entity.OrderStatus;
import com.example.mart.repository.DeliveryRepository;
import com.example.mart.repository.ItemRepository;
import com.example.mart.repository.MemberRepository;
import com.example.mart.repository.OrderItemRepository;
import com.example.mart.repository.OrderRepository;

@SpringBootTest
public class MartRepositoryTest {
    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderItemRepository orderItemRepository;

    @Autowired
    private DeliveryRepository deliveryRepository;

    @Test
    public void insertTest() {
        memberRepository.save(Member.builder().name("서울시").street("중구").zipcode("15102").build());
        memberRepository.save(Member.builder().name("경기도").street("안양시").zipcode("35102").build());
        memberRepository.save(Member.builder().name("부산시").street("중구").zipcode("45102").build());

        itemRepository.save(Item.builder().name("티셔츠").price(12000).stockQuantity(3).build());
        itemRepository.save(Item.builder().name("티셔츠2").price(12300).stockQuantity(5).build());
        itemRepository.save(Item.builder().name("티셔츠3").price(12600).stockQuantity(6).build());
    }

    @Test
    public void orderInsertTest() {
        Member member = Member.builder().id(1L).build();
        Item item = Item.builder().id(1L).build();

        Order order = Order.builder().member(member).orderDate(LocalDateTime.now()).orderStatus(OrderStatus.ORDER)
                .build();
        OrderItem orderItem = OrderItem.builder().item(item).order(order).orderPrice(26000).count(2).build();
        orderItemRepository.save(orderItem);
    }

    public void readTest() {
        // 전체 회원 조회
        memberRepository.findAll().forEach(member -> System.out.println(member));

        // 전체 아이템 조회
        itemRepository.findAll().forEach(item -> System.out.println(item));

        // 주문아이템 조회 시 주문정보확인
        orderItemRepository.findAll().forEach(entity -> {
            System.out.println(entity);
            System.out.println("상품정보" + entity.getItem());
            System.out.println("구매자" + entity.getOrder().getMember().getName());
        });
    }

    public void readTest2() {
        // 전체 회원 조회
        // @OneToMany를 이용한 case
        // Order기준으로 orderItem 조회
        Order order = orderRepository.findById(1L).get();
        System.out.println(order);

        System.out.println(order.getOrderItems());

        // 주문아이템 조회 시 주문정보확인
        orderItemRepository.findAll().forEach(entity -> {
            System.out.println(entity);
            System.out.println("상품정보" + entity.getItem());
            System.out.println("구매자" + entity.getOrder().getMember().getName());
        });
    }

    public void readTest3() {
        // 전체 회원 조회
        Member member = memberRepository.findById(1L).get();

        // 주문아이템 조회 시 주문정보확인
    }

    public void updateTest() {
        Member member = memberRepository.findById(2L).get();
        member.setStreet("스울시");
        memberRepository.save(member);

        Item item = itemRepository.findById(2L).get();
        item.setPrice(8000);
        itemRepository.save(item);

        Order order = orderRepository.findById(1L).get();
        order.setOrderStatus(OrderStatus.ORDER);
        orderRepository.save(order);

    }

    public void deleteTest() {
        // 주문 아이템이 존재하기 때문에 에러남
        orderRepository.deleteById(1L);

        // 주문아이템 제거 후 주문제거
        orderItemRepository.delete(OrderItem.builder().id(1L).build());
        orderRepository.deleteById(1L);
    }

    public void orderInsertDeliveryTest() {
        Member member = Member.builder().id(1L).build();
        Item item = Item.builder().id(1L).build();

        Delivery delivery = Delivery.builder().city("서울시").street("123-12").zipcode("11160")
                .deliveryStatus(DeliveryStatus.READY).build();
        deliveryRepository.save(delivery);

        Order order = Order.builder().member(member).orderDate(LocalDateTime.now()).orderStatus(OrderStatus.ORDER)
                .delivery(delivery).build();
        orderRepository.save(order);
    }

    // public void deliveryOrderGet() {
    // Delivery delivery = deliveryRepository.findById(1L).get();

    // System.out.println(delivery);
    // System.out.println("관련 주문 " + delivery.getOrder());
    // }

}
