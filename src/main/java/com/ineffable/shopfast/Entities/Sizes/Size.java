package com.ineffable.shopfast.Entities.Sizes;

public class Size {
    private double length;
    //calculation unit such as cm/ inch
    private String unit;

    public Size(double length) {
        this.length = length;
    }

    public Size(double length, String unit) {
        this.length = length;
        this.unit = unit;
    }

    public Size() {
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }
}
