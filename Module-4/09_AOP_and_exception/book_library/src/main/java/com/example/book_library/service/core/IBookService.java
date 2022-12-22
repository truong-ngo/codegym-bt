package com.example.book_library.service.core;

import com.example.book_library.model.Book;
import com.example.book_library.service.IService;
import org.springframework.stereotype.Repository;

@Repository
public interface IBookService extends IService<Book, Long> {
}
