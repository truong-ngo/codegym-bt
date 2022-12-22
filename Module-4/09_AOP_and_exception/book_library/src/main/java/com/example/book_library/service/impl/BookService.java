package com.example.book_library.service.impl;

import com.example.book_library.model.Book;
import com.example.book_library.repository.IBookRepository;
import com.example.book_library.service.core.IBookService;
import com.example.book_library.service.exception.BookException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BookService implements IBookService {
    private final IBookRepository bookRepository;

    @Autowired
    public BookService(IBookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public Iterable<Book> findAll() {
        return bookRepository.findAll();
    }

    @Override
    public Optional<Book> findById(Long id) {
        return bookRepository.findById(id);
    }

    @Override
    public void save(Book book) throws Exception {
        try {
            bookRepository.save(book);
        } catch (DataIntegrityViolationException exception) {
            if (book.getId() == null) {
                throw new BookException("Error occur while adding book: duplicate name");
            } else {
                throw new BookException("Error occur while editing book: duplicate name");
            }
        }
    }

    @Override
    public void remove(Long id) {
        bookRepository.deleteById(id);
    }
}
