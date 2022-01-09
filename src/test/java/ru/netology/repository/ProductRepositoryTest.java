package ru.netology.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;

import static org.junit.jupiter.api.Assertions.*;

class ProductRepositoryTest {


    @Test
    public void shouldNotFoundException() {
        ProductRepository repository = new ProductRepository();

        Product firstBook = new Book(1, "Good Omens", 700, "Pratchett Terry");
        Product secondBook = new Book(2, "The Joy of JavaScript", 900, "Luis Atencio");
        Product firstSmartphone = new Smartphone(3, "Google Pixel 5 8/128Gb Black", 60000, "HTC Corporation");
        Product secondSmartphone = new Smartphone(4, "Смартфон Xiaomi Mi 11 256GB Horizon Blue", 62000, "Xiaomi Corporation");


        repository.save(firstBook);
        repository.save(secondBook);
        repository.save(firstSmartphone);
        repository.save(secondSmartphone);

        assertThrows(NotFoundException.class, () -> {
            repository.removeById(74);
        });
    }

    @Test
    public void shouldRemoveById() {

        ProductRepository repository = new ProductRepository();

        Product firstBook = new Book(1, "Good Omens", 700, "Pratchett Terry");
        Product secondBook = new Book(2, "The Joy of JavaScript", 900, "Luis Atencio");
        Product firstSmartphone = new Smartphone(3, "Google Pixel 5 8/128Gb Black", 60000, "HTC Corporation");
        Product secondSmartphone = new Smartphone(4, "Смартфон Xiaomi Mi 11 256GB Horizon Blue", 62000, "Xiaomi Corporation");


        repository.save(firstBook);
        repository.save(secondBook);
        repository.save(firstSmartphone);
        repository.save(secondSmartphone);

        repository.removeById(1);
        Product[] expected = {secondBook, firstSmartphone, secondSmartphone};
        Product[] actual = repository.findAll();
        assertArrayEquals(expected,actual);
    }
}