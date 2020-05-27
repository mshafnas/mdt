package com.ssd.mdt.mdt;

import com.ssd.mdt.mdt.model.Tour;
import com.ssd.mdt.mdt.repository.TourRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.junit.jupiter.api.Test;
import java.util.List;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Transactional(propagation = Propagation.NOT_SUPPORTED)
public class TourTest {

//    @Autowired
//    private TourRepository tourRepository;
//
//    public long id;
//
//    @Test
//    public void testSaveTour(){
//        Tour tour = new Tour("Test Trip", 2020-5-29, 2020-5-31, "Kandy", "Colomobo", 7500, "A9");
//        tourRepository.save(tour);
//
//        Tour tourGet = tourRepository.findByTitle("Test Trip");
//
//        Assertions.assertNotNull(tour);
//        Assertions.assertEquals(tourGet.getTitle(), tour.getTitle());
//        Assertions.assertEquals(tourGet.getStart_date(), tour.getStart_date());
//        Assertions.assertEquals(tourGet.getEnd_date(), tour.getEnd_date());
//
//    }
//
//    @Test
//    public void getAllTours(){
//        Tour tour = new Tour("Test Trip", 2020-5-29, 2020-5-31, "Kandy", "Colomobo", 7500, "A9");
//        tourRepository.save(tour);
//        Assertions.assertNotNull(tourRepository.findAll());
//    }

}
