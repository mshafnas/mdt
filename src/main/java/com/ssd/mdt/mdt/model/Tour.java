package com.ssd.mdt.mdt.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "tours")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"createdAt", "updatedAt"}, allowGetters = true)

public class Tour {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column(name = "title")
    @NotBlank
    public String title;

    @Column(name = "start_date")
    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    public Date start_date;

    @Column(name = "end_date")
    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    public Date end_date;

    @Column(name = "start_point")
    @NotBlank
    public String start_point;

    @Column(name = "end_point")
    @NotBlank
    public String end_point;

    @Column(name = "rate")
    @NotNull
    public int rate;

    @Column(name = "route", length = 300)
    @NotBlank
    public String route;

    @OneToMany(mappedBy = "tour")
    private Set<TourBooking> tourBookings;

    @OneToMany(mappedBy = "tour_id")
    private Set<Feedback> feedbacks;

    @Column(nullable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    private Date createdAt;

    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate
    private Date updatedAt;



    public Tour() {
    }

    public Tour(@NotBlank String title, @NotNull Date start_date, @NotNull Date end_date, @NotBlank String start_point, @NotBlank String end_point, @NotNull int rate, @NotBlank String route, Set<TourBooking> tourBookings, Set<Feedback> feedbacks, Date createdAt, Date updatedAt) {
        this.title = title;
        this.start_date = start_date;
        this.end_date = end_date;
        this.start_point = start_point;
        this.end_point = end_point;
        this.rate = rate;
        this.route = route;
        this.tourBookings = tourBookings;
        this.feedbacks = feedbacks;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }


    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getStart_date() {
        return start_date;
    }

    public void setStart_date(Date start_date) {
        this.start_date = start_date;
    }

    public Date getEnd_date() {
        return end_date;
    }

    public void setEnd_date(Date end_date) {
        this.end_date = end_date;
    }

    public String getStart_point() {
        return start_point;
    }

    public void setStart_point(String start_point) {
        this.start_point = start_point;
    }

    public String getEnd_point() {
        return end_point;
    }

    public void setEnd_point(String end_point) {
        this.end_point = end_point;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    public String getRoute() {
        return route;
    }

    public void setRoute(String route) {
        this.route = route;
    }

    public Set<TourBooking> getTourBookings() {
        return tourBookings;
    }

    public void setTourBookings(Set<TourBooking> tourBookings) {
        this.tourBookings = tourBookings;
    }

    public Set<Feedback> getFeedbacks() {
        return feedbacks;
    }

    public void setFeedbacks(Set<Feedback> feedbacks) {
        this.feedbacks = feedbacks;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }
}
