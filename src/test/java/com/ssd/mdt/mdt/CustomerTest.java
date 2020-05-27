package com.ssd.mdt.mdt;

import com.ssd.mdt.mdt.model.Customer;
import com.ssd.mdt.mdt.model.Tour;
import com.ssd.mdt.mdt.repository.CustomerRepository;
import com.ssd.mdt.mdt.repository.TourRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Transactional(propagation = Propagation.NOT_SUPPORTED)
public class CustomerTest {

    @Autowired
    private CustomerRepository customerRepository;

    @Test
    public void testSaveCustomer(){
        Customer customer = new Customer();
        customer.setName("Test Customer");
        customer.setAddress("Test Address");
        customer.setPhone("0777458961");
        customer.setEmail("test@test.com");

        String password = "abc123";
//        encrypt password
        String encpassword = BCrypt.hashpw(password, BCrypt.gensalt(12));
//      store encrypted password
        customer.setPassword(encpassword);
        customerRepository.save(customer);

        System.out.println("success");
    }
}
