package com.ssd.mdt.mdt;

import com.ssd.mdt.mdt.model.Tour;
import com.ssd.mdt.mdt.repository.TourRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


import java.util.Date;
import java.util.List;


@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Transactional(propagation = Propagation.NOT_SUPPORTED)
public class TourTest {

    @Autowired
    private TourRepository tourRepository;

    public Date start_date;
    public Date end_date;

    @Test
    public void testSaveTour(){
        Tour tour = new Tour();
        tour.setTitle("Test Trip");
        start_date = new Date(2020-05-27);
        tour.setStart_date(start_date);
        end_date = new Date(2020-05-29);
        tour.setEnd_date(end_date);
        tour.setStart_point("Test start point");
        tour.setEnd_point("Test end point");
        tour.setRate(1500);
        tour.setRoute("Test route");
        tourRepository.save(tour);

        System.out.println("success");

    }
}
