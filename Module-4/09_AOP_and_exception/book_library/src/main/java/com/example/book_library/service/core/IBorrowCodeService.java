package com.example.book_library.service.core;

import com.example.book_library.model.BorrowCode;
import com.example.book_library.service.IService;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IBorrowCodeService extends IService<BorrowCode, Long> {
    Optional<BorrowCode> findBorrowCodeByCode(String code);
}
