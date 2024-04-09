package com.example.book.repository;

import java.util.stream.IntStream;
import java.util.stream.LongStream;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.book.entity.Book;
import com.example.book.entity.Category;
import com.example.book.entity.Publisher;

public class BookRepositoryTest {

    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private PublisherRepository publisherRepository;

    @Test
    public void insertCategoryTest() {
        Category category = Category.builder().name("컴퓨터").build();
        categoryRepository.save(category);
        Category category2 = Category.builder().name("경제/경영").build();
        categoryRepository.save(category2);
        Category category3 = Category.builder().name("인문").build();
        categoryRepository.save(category3);
        Category category4 = Category.builder().name("소설").build();
        categoryRepository.save(category4);
        Category category5 = Category.builder().name("자기계발").build();
        categoryRepository.save(category5);

        // categoryRepository.save(Category.builder().name("컴퓨터").build());
        // categoryRepository.save(Category.builder().name("경제/경영").build());
        // categoryRepository.save(Category.builder().name("인문").build());
        // categoryRepository.save(Category.builder().name("소설").build());
        // categoryRepository.save(Category.builder().name("자기계발").build());

    }

    @Test
    public void insertPublisherTest() {
        Publisher publisher = Publisher.builder().name("로드북").build();
        publisherRepository.save(publisher);
        Publisher publisher2 = Publisher.builder().name("다산").build();
        publisherRepository.save(publisher2);
        Publisher publisher3 = Publisher.builder().name("웅진지식하우스").build();
        publisherRepository.save(publisher3);
        Publisher publisher4 = Publisher.builder().name("비룡소").build();
        publisherRepository.save(publisher4);
        Publisher publisher5 = Publisher.builder().name("을유문화사").build();
        publisherRepository.save(publisher5);
        // publisherRepository.save(Publisher.builder().name("로드북").build());
        // publisherRepository.save(Publisher.builder().name("다산").build());
        // publisherRepository.save(Publisher.builder().name("웅진지식하우스").build());
        // publisherRepository.save(Publisher.builder().name("비룡소").build());
        // publisherRepository.save(Publisher.builder().name("을유문화사").build());
    }

    @Test
    public void testBookCreate() {
        LongStream.rangeClosed(1, 20).forEach(i -> {
            Book book = Book.builder().price(25000).salePrice(22000)
                    .title("쥬시쿨" + i)
                    .writer("빙그레" + i)
                    .category(Category.builder().id((i % 5) + i).build())
                    .publisher(Publisher.builder().id((i % 5) + i).build())
                    .build();
        });
    }
}
