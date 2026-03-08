package com.example.insurance;

import org.springframework.stereotype.Component;

@Component
public class InsuranceCalculator {
    public Insurance_policy calculatePremium(Insurance_policy request) {

        if (request.getCoverage() == Coverage.SINGLE) {

            final double price = request.getDurationDays()
                    * request.getPlan().getDailyMultiplier()
                    * request.getCoverage().getMultiplier()
                    * request.getArea().getAreaA();
            request.setPrice(price);
            return  request;

        } if ((request.getCoverage() == Coverage.ANNUAL) && (request.getPlan() == Plan.Plan_A)){

            final double price = request.getPlan().getAnnualMultiplier()
                    * request.getCoverage().getMultiplier()
                    * request.getArea().getAreaA();
            request.setPrice(price);
            return  request;

        } else {
            final double price = request.getPlan().getAnnualMultiplier()
                    * request.getCoverage().getMultiplier()
                    * request.getArea().getAreaB();
            request.setPrice(price);
            return  request;
        }
    }
}
