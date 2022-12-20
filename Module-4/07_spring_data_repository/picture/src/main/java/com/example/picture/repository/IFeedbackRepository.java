package com.example.picture.repository;

import com.example.picture.model.Feedback;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IFeedbackRepository extends PagingAndSortingRepository<Feedback, Integer> {
    Page<Feedback> findAll(Pageable pageable);
}


