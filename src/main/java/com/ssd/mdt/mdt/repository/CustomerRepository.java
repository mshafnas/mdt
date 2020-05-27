package com.ssd.mdt.mdt.repository;

import com.ssd.mdt.mdt.model.Customer;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
    Customer findByName(String Name);
}
