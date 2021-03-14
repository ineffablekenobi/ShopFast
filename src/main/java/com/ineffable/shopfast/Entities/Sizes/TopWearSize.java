package com.ineffable.shopfast.Entities.Sizes;

public class TopWearSize extends Size {
    private double width;
    private double shoulder;
    private double sleeveLength;

    public TopWearSize(double length, double width, double shoulder, double sleeveLength) {
        super(length);
        this.width = width;
        this.shoulder = shoulder;
        this.sleeveLength = sleeveLength;
    }

    public TopWearSize(double length, String unit, double width, double shoulder, double sleeveLength) {
        super(length, unit);
        this.width = width;
        this.shoulder = shoulder;
        this.sleeveLength = sleeveLength;
    }

    public TopWearSize(double width, double shoulder, double sleeveLength) {
        this.width = width;
        this.shoulder = shoulder;
        this.sleeveLength = sleeveLength;
    }

    public TopWearSize(double length) {
        super(length);
    }

    public TopWearSize(double length, String unit) {
        super(length, unit);
    }

    public TopWearSize() {
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getShoulder() {
        return shoulder;
    }

    public void setShoulder(double shoulder) {
        this.shoulder = shoulder;
    }

    public double getSleeveLength() {
        return sleeveLength;
    }

    public void setSleeveLength(double sleeveLength) {
        this.sleeveLength = sleeveLength;
    }
}
