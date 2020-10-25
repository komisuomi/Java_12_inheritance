package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.repository.ProductRepo;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class ProductManagerTest {
    ProductRepo repository = new ProductRepo();
    ProductManager manager = new ProductManager(repository);

    Book book1 = new Book(1, "Цветы для Элджернона", 100, "Дэниел Киз");
    Smartphone smartphone1 = new Smartphone(2, "Samsung d100", 1000, "Samsung");
    Book book2 = new Book(3, "Дети Арбата", 100,"Анатолий Рыбаков");
    Smartphone smartphone2 = new Smartphone(4, "Xiaomi Redmi Plus", 1000, "Xiaomi");

    @BeforeEach
    public void setUp() {
        manager.add(book1);
        manager.add(smartphone1);
        manager.add(book2);
        manager.add(smartphone2);
    }

    @Test
    public void shouldSearchByNameBook() {
        Product[] actual = new Product[]{book2};
        Product[] expected = manager.searchBy("Дети Арбата");
        assertArrayEquals(actual, expected);
    }

    @Test
    public  void shouldSearchByManufacturer() {
        Product[] actual = new Product[]{smartphone1};
        Product[] expected = manager.searchBy("samsung");
        assertArrayEquals(actual, expected);
    }

    @Test
    public void shouldSearchByAuthor() {
        Product[] actual = new Product[]{book1};
        Product[] expected = manager.searchBy("Дэниел Киз");
        assertArrayEquals(actual, expected);
    }

    @Test
    public void shouldSearchByNameSmart() {
        Product[] actual = new Product[]{smartphone2};
        Product[] expected = manager.searchBy("Xiaomi Redmi Plus");
        assertArrayEquals(actual, expected);
    }
}