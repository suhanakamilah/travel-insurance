package com.example.insurance;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface InsuranceContainer extends JpaRepository<Insurance_policy, String> {
    Insurance_policy findByEmail(String email);
}