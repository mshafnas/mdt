package com.ssd.mdt.mdt.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "customers")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"createdAt", "updatedAt"}, allowGetters = true)
public class Customer {

    @Id
    @Column(name = "cus_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cus_id;

    @Column(name = "name")
    @NotBlank
    public String name;

    @Column(name = "address")
    @NotBlank
    public String address;

    @Column(name = "phone")
    @NotBlank
    public String phone;

    @Column(name = "email", unique = true)
    @NotBlank
    public String email;

    @Column(name = "password")
    @NotBlank

    public String password;

    @OneToMany(mappedBy = "customer")
    private Set<TourBooking> tourBookings;

    @OneToMany(mappedBy = "customer_id")
    private Set<Feedback> feedbacks;

    @Column(nullable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    private Date createdAt;

    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate
    private Date updatedAt;



    public Customer() {
    }

    public Customer(@NotBlank String name, @NotBlank String address, @NotBlank String phone, @NotBlank String email, @NotBlank String password, Set<TourBooking> tourBookings, Set<Feedback> feedbacks, Date createdAt, Date updatedAt) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.password = password;
        this.tourBookings = tourBookings;
        this.feedbacks = feedbacks;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }


    public Long getCus_id() {
        return cus_id;
    }

    public void setCus_id(Long cus_id) {
        this.cus_id = cus_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

