package com.example.book.repository;

import static org.junit.jupiter.api.DynamicTest.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.book.entity.Book;
import com.example.book.entity.Category;
import com.example.book.entity.Publisher;

@SpringBootTest
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

        category = Category.builder().name("경제/경영").build();
        categoryRepository.save(category);

        category = Category.builder().name("인문").build();
        categoryRepository.save(category);

        category = Category.builder().name("소설").build();
        categoryRepository.save(category);

        category = Category.builder().name("자기계발").build();
        categoryRepository.save(category);

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
                    .category(Category.builder().id((i % 5) + 1).build())
                    .publisher(Publisher.builder().id((i % 5) + 1).build())
                    .build();
            bookRepository.save(book);
        });
    }

    @Test
    public void testBookList() {
        List<Book> books = bookRepository.findAll();

        books.forEach(book -> {
            System.out.println(book);
            // System.out.println("출판사 : " + book.getPublisher().getName());
            // System.out.println("분야 : " + book.getCategory().getName());
        });
    }

    @Test
    public void testCateNameList() {
        List<Category> list = categoryRepository.findAll();

        list.forEach(category -> System.out.println(category));
        // List<String> cateList = new ArrayList<>();
        // list.forEach(category -> cateList.add(category.getName()));

        List<String> cateList = list.stream().map(entity -> entity.getName()).collect(Collectors.toList());
        cateList.forEach(System.out::println);
    }

}
