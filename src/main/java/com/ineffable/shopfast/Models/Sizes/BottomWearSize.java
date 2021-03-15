package com.ineffable.shopfast.Models.Sizes;

public class BottomWearSize extends Size {
    private double waist;

    public BottomWearSize(double length, double waist) {
        super(length);
        this.waist = waist;
    }

    public BottomWearSize(double length, String unit, double waist) {
        super(length, unit);
        this.waist = waist;
    }

    public BottomWearSize(double waist) {
        this.waist = waist;
    }

    public BottomWearSize(double length, String unit) {
        super(length, unit);
    }

    public BottomWearSize() {
    }

    public double getWaist() {
        return waist;
    }

    public void setWaist(double waist) {
        this.waist = waist;
    }
}
