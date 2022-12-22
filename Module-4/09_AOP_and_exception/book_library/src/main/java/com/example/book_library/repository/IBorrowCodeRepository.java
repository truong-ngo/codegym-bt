package com.example.book_library.repository;

import com.example.book_library.model.BorrowCode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IBorrowCodeRepository extends JpaRepository<BorrowCode, Long> {
    Optional<BorrowCode> findBorrowCodeByCode(String code);
}
