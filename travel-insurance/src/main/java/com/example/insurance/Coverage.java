package com.example.insurance;

public enum Coverage {
    SINGLE(1.0),
    ANNUAL(1.0);
    private final double multiplier;

    Coverage(double multiplier) {
        this.multiplier = multiplier;
    }

    public double getMultiplier() {
        return multiplier;
    }
}
