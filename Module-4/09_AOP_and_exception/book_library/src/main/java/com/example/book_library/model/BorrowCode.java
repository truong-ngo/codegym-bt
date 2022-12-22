package com.example.book_library.model;

import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "borrow_code")
public class BorrowCode {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String code;
    @Column(name = "date_borrow", columnDefinition = "timestamp")
    private LocalDateTime dateBorrow;
    @Column(name = "date_return", columnDefinition = "timestamp")
    private LocalDateTime dateReturn;
    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;

    public BorrowCode() {
    }

    public BorrowCode(String code, LocalDateTime dateBorrow, LocalDateTime dateReturn, Book book) {
        this.code = code;
        this.dateBorrow = dateBorrow;
        this.dateReturn = dateReturn;
        this.book = book;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public LocalDateTime getDateBorrow() {
        return dateBorrow;
    }

    public void setDateBorrow(LocalDateTime dateBorrow) {
        this.dateBorrow = dateBorrow;
    }

    public LocalDateTime getDateReturn() {
        return dateReturn;
    }

    public void setDateReturn(LocalDateTime dateReturn) {
        this.dateReturn = dateReturn;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public static String generateCode() {
        StringBuilder rand = new StringBuilder();
        for (int i = 0; i < 5; i++) {
            rand.append((int) (Math.random() * 10));
        }
        return rand.toString();
    }
}
