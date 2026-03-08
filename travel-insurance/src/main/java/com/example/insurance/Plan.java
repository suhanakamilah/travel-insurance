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
//Area
//1 100
//2 150
//3 200
