package ru.netology.manager;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;

import static org.junit.jupiter.api.Assertions.*;

class ProductManagerTest {
    @Test
            public void add() {
        ProductManager manager = new ProductManager();
        Book first = new Book(1, "NameBook1", 750, "author1");
        Book second = new Book(2, "NameBook2", 750, "author1");
        Smartphone apple = new Smartphone(3, "name1", 10000, "apple");
        manager.add(first);
        manager.add(second);
        manager.add(apple);

        Product[] actual = manager.repository.findAll();
        Product[] expected = new Product[] {first, second, apple};

        assertArrayEquals(actual, expected);
    }

}

