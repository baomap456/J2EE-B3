package com.example.demo1.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo1.model.Book;

@Service
public class BookService {
    private List<Book> books = new ArrayList<>();
    private Long nextId = 1l;

    public List<Book> getAllBooks() {
        return books;
    }

    public Optional <Book> getBookId(Long id){
        return books.stream().filter(book -> book.getId().equals(id)).findFirst();
    }

    public void addBook(Book book) {
        book.setId(nextId++);
        books.add(book);
    }

    public void updateBook(Book updatedBook) {
        books.stream()
        .filter(book-> book.getId().equals(updatedBook.getId()))
        .findFirst()
        .ifPresent(book -> {
            book.setTitle(updatedBook.getTitle());
            book.setAuthor(updatedBook.getAuthor());
        });
    }

    public void deleteBook(Long id) {
        books.removeIf(book -> book.getId().equals(id));
    }
}
