package com.example.insurance;
public enum Area {
    //Single rate : Area A = B
    //Annual rate : Area != B
    Area_1(1.0, 1.5),
    Area_2(1.5, 2.0),
    Area_3(2.0, 2.5),
    Area_4(0.5, 0);

    private final double areaA;
    private final double areaB;

    Area(double areaA, double areaB) {
        this.areaA = areaA;
        this.areaB = areaB;
    }

    public double getAreaA() {
        return areaA;
    }

    public double getAreaB() {
        return areaB;
    }

}