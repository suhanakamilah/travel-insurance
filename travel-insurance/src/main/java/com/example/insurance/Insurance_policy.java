package com.example.insurance;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;

import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;
import java.util.UUID;

@Entity
public class Insurance_policy {
    @Id
    private UUID policy_id;
    @Enumerated(EnumType.STRING)
    private Plan plan;
    @Enumerated(EnumType.STRING)
    private Coverage coverage;
    @Enumerated(EnumType.STRING)
    private Area area;
    private LocalDate start_date;
    private LocalDate end_date;
    private String name;
    private String nric;
    private String dob;
    private String gender;
    private String email;
    private String mobile_no;
    private String address_line1;
    private String address_line2;
    private String postcode;
    private double price;
    private ZonedDateTime created_time;

    public UUID getPolicy_id() {
        return policy_id;
    }

    public void setPolicyId(UUID policy_id) {this.policy_id =policy_id;}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getNric() {
        return nric;
    }

    public void setNric(String nric) {
        this.nric = nric;
    }
    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public String getMobile_no() {
        return mobile_no;
    }

    public void setMobile_no(String mobile_no) {
        this.mobile_no = mobile_no;
    }
    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }
    public String getAddress_line1() {
        return address_line1;
    }

    public void setAddress_line1(String address_line1) {
        this.address_line1 = address_line1;
    }

    public String getAddress_line2() {
        return address_line2;
    }

    public void setAddress_line2(String address_line2) {
        this.address_line2 = address_line2;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public Coverage getCoverage() {
        return coverage;
    }

    public void setCoverageType(Coverage coverage) {
        this.coverage = coverage;
    }
    public Plan getPlan() {
        return plan;
    }

    public void setPlan(Plan plan) {
        this.plan = plan;
    }

    public Area getArea() {
        return area;
    }

    public void setArea(Area area) {
        this.area = area;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {this.price =price;}
    public ZonedDateTime getCreated_time() { return created_time;}

    public void setCreated_time(ZonedDateTime created_time) {
        this.created_time = created_time;
    }

    public LocalDate getStart_date() {
        return start_date;
    }

    public void setStart_date(LocalDate start_date) {
        this.start_date = start_date;
    }

    public LocalDate getEnd_date() {
        return end_date;
    }

    public void setEndDate(LocalDate end_date) {
        this.end_date
                = end_date;
    }

    public long getDurationDays() {
        return ChronoUnit.DAYS.between(start_date, end_date);
    }

}
