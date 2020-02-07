package com.kozachuk.homework.postoffice.dto;

import java.util.ArrayList;
import java.util.List;

public class PackageBox {
    private double length;
    private double width;
    private double depth;

    public PackageBox(double length, double width, double depth){
        this.length = length;
        this.width = width;
        this.depth = depth;
    }

    public double getLength() {
        return length;
    }

    public double getWidth() {
        return width;
    }

    public double getDepth() {
        return depth;
    }

    public List<Double> getSizes() {
        return new ArrayList(){{
            add(getWidth());
            add(getLength());
            add(getDepth());
        }};
    }
}
