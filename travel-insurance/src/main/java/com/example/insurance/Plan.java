package com.example.insurance;

public enum Plan {
    Plan_A(10, 100),
    Plan_B(20, 100);

    private final double dailyPlan;
    private final double annualPlan;

    Plan(double dailyPlan, double annualPlan) {
        this.dailyPlan = dailyPlan;
        this.annualPlan = annualPlan;
    }

    public double getDailyPlan() {
        return dailyPlan;
    }

    public double getAnnualPlan() {
        return annualPlan;
    }
    public double getDailyMultiplier() {
        return dailyPlan;
    }
    public double getAnnualMultiplier() {
        return annualPlan;
    }

}
//single
//
//Plan
//A 1.0
//B 2.0
//
//Area
//1 - 10
//2 - 15
//3 - 20
//4 - 5
//
//Annual
//
//Plan
//A 1.0
//B 1.0 + 50
//
//Area
//1 100
//2 150
//3 200