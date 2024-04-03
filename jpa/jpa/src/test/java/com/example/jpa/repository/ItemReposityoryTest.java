package com.example.jpa.repository;

import java.util.stream.IntStream;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.jpa.entity.Item;
import com.example.jpa.entity.ItemStatus;

@SpringBootTest
public class ItemReposityoryTest {

    @Autowired
    private ItemRepository itemRepository;

    @Test
    public void createTest() {
        IntStream.rangeClosed(1, 10).forEach(i -> {
            Item item = Item.builder()
                    .itemNm("shoes" + i)
                    .price(95000 * i)
                    .stockNumber(30)
                    .itemSellStatus(ItemStatus.SELL)
                    .build();
            itemRepository.save(item);
        });

    }

    @Test
    public void readTest() {
        System.out.println(itemRepository.findById(2L));
        System.out.println("------------");
        itemRepository.findAll().forEach(item -> System.out.println(item));
    }

    @Test
    public void updateTest() {
        Item item = itemRepository.findById(2L).get();
        item.setItemNm(null);
        item.setPrice(null);
        item.setStockNumber(null);
        item.setItemSellStatus(null);
        item.setItemDetail(null);
        System.out.println(itemRepository.save(item));
    }

    @Test
    public void deleteTest() {
        Item item = itemRepository.findById(2L).get();

        itemRepository.delete(item);
    }

}
