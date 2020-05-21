package com.ssd.mdt.mdt.repository;


import com.ssd.mdt.mdt.model.TourBooking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TourBookingRepository extends JpaRepository <TourBooking, Long> {
}
