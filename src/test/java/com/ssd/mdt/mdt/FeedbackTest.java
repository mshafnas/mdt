package com.ssd.mdt.mdt;

import com.ssd.mdt.mdt.model.Customer;
import com.ssd.mdt.mdt.model.Feedback;
import com.ssd.mdt.mdt.model.Tour;
import com.ssd.mdt.mdt.repository.FeedbackRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Transactional(propagation = Propagation.NOT_SUPPORTED)
public class FeedbackTest {

    @Autowired
    private FeedbackRepository feedbackRepository;

    @Test
    public void testSaveFeedback(){
        Feedback feedback = new Feedback();
        feedback.setMessage("Test Feedback");

        Tour tour = new Tour();
        tour.setId((long) 7);
        feedback.setTour_id(tour);

        Customer customer = new Customer();
        customer.setCus_id((long) 3);
        feedback.setCustomer_id(customer);

        feedbackRepository.save(feedback);
        System.out.println("success");

    }
}
