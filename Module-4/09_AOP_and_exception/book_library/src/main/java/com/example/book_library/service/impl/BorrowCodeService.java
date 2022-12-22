package com.example.book_library.service.impl;

import com.example.book_library.model.BorrowCode;
import com.example.book_library.repository.IBorrowCodeRepository;
import com.example.book_library.service.core.IBorrowCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BorrowCodeService implements IBorrowCodeService {
    private final IBorrowCodeRepository borrowCodeRepository;

    @Autowired
    public BorrowCodeService(IBorrowCodeRepository borrowCodeRepository) {
        this.borrowCodeRepository = borrowCodeRepository;
    }

    @Override
    public Iterable<BorrowCode> findAll() {
        return borrowCodeRepository.findAll();
    }

    @Override
    public Optional<BorrowCode> findById(Long id) {
        return borrowCodeRepository.findById(id);
    }

    @Override
    public void save(BorrowCode borrowCode) {
        borrowCodeRepository.save(borrowCode);
    }

    @Override
    public void remove(Long id) {
        borrowCodeRepository.deleteById(id);
    }

    @Override
    public Optional<BorrowCode> findBorrowCodeByCode(String code) {
        return borrowCodeRepository.findBorrowCodeByCode(code);
    }
}
