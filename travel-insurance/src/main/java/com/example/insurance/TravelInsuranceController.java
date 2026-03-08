package com.example.insurance;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.time.ZonedDateTime;
import java.util.UUID;

@RestController
@RequestMapping("/insurance")
public class TravelInsuranceController {

    @Autowired
    private final InsuranceService insuranceService;
    private final InsuranceCalculator insuranceCalculator;
    private final InsuranceContainer insuranceContainer;

    public TravelInsuranceController(InsuranceService insuranceService, InsuranceCalculator insuranceCalculator, InsuranceContainer insuranceContainer) {
        this.insuranceService = insuranceService;
        this.insuranceCalculator = insuranceCalculator;
        this.insuranceContainer = insuranceContainer;
    }

    @PostMapping(value = "/calculate-price" , consumes = MediaType.APPLICATION_JSON_VALUE)
    public Insurance_policy calculateInsurancePrice(
            @RequestBody Insurance_policy request) {
        final Insurance_policy policy = insuranceService.validateData(request);

        return insuranceCalculator.calculatePremium(policy);
    }
    @PostMapping("/purchase")
    public Insurance_policy purchaseInsurance(
            @RequestBody Insurance_policy request) {
        final Insurance_policy policy = insuranceService.validateData(request);
        request.setPolicyId(UUID.randomUUID());
        request.setCreated_time(ZonedDateTime.now());
        return insuranceService.purchaseInsurance(policy);
    }
}

