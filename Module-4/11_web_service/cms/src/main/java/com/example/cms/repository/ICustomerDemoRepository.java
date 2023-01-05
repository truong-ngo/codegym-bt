package com.example.cms.repository;

import com.example.cms.model.CustomerDemo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICustomerDemoRepository extends JpaRepository<CustomerDemo, Long> {
}
