package ru.netology.repository;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;

import static org.junit.jupiter.api.Assertions.*;

/// Добавлено для ДЗ Исключительные ситуации и их обработка. Тестирование исключений

class RepositoryTest {
    @Test
    public void shouldRemoveById() {
        Repository repository = new Repository();
        Book first = new Book(1, "NameBook1", 750, "author1");
        Book second = new Book(2, "NameBook2", 750, "author1");
        Smartphone apple = new Smartphone(3, "name1", 10000, "apple");

        repository.save(first);
        repository.save(second);
        repository.save(apple);

        repository.removeById(1);

        Product[] actual = repository.findAll();
        Product[] expected = new Product[] {second, apple};

        assertArrayEquals(actual, expected);
    }

    @Test
    public void shouldGenerateNotFoundException() {
        Repository repository = new Repository();
        Book first = new Book(1, "NameBook1", 750, "author1");
        Book second = new Book(2, "NameBook2", 750, "author1");
        Smartphone apple = new Smartphone(3, "name1", 10000, "apple");

        repository.save(first);
        repository.save(second);
        repository.save(apple);

        assertThrows(NotFoundException.class, () -> repository.removeById(12));
    }


}