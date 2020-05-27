package com.ssd.mdt.mdt;

import com.ssd.mdt.mdt.model.Customer;
import com.ssd.mdt.mdt.model.Tour;
import com.ssd.mdt.mdt.model.TourBooking;
import com.ssd.mdt.mdt.repository.TourBookingRepository;
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
public class tourBookingTest {

    @Autowired
    private TourBookingRepository tourBookingRepository;



    @Test
    public void testSaveTouBook(){
        Customer customer = new Customer();
        customer.setCus_id((long) 3);

        Tour tour = new Tour();
        tour.setId((long) 7);

        TourBooking tourBooking = new TourBooking();
        tourBooking.setName("Test Customer");
        tourBooking.setCustomer(customer);
        tourBooking.setTour(tour);

        tourBookingRepository.save(tourBooking);

        System.out.println("Success");

    }

}
