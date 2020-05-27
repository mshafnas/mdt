package com.ssd.mdt.mdt.repository;

import com.ssd.mdt.mdt.model.Tour;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TourRepository extends JpaRepository<Tour, Long> {
    Tour findByTitle(String title);
}
