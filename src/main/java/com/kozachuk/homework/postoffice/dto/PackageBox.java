package com.kozachuk.homework.postoffice.dto;

import java.util.ArrayList;
import java.util.List;

public class PackageBox {
    private List<Double> sizes = null;
    private double length;
    private double width;
    private double depth;

    private PackageBox(double length, double width, double depth){
        this.length = length;
        this.width = width;
        this.depth = depth;
    }

    public static BoxBuilder getBuilder() {
        return new PackageBox.BoxBuilder();
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
        if(sizes == null) sizes = new ArrayList(){{
                                        add(getWidth());
                                        add(getLength());
                                        add(getDepth());
                                    }};

        return sizes;
    }

    public static class BoxBuilder {
        private double length;
        private double width;
        private double depth;

        private BoxBuilder(){}

        public BoxBuilder length(double length) {
            if(length <= 0) throw new IllegalArgumentException(String.format("Illegal Argument value '%s'", length));
            this.length = length;
            return this;
        }

        public BoxBuilder width(double width) {
            if(width <= 0) throw new IllegalArgumentException(String.format("Illegal Argument value '%s'", width));
            this.width = width;
            return this;
        }

        public BoxBuilder depth(double depth) {
            if(depth <= 0) throw new IllegalArgumentException(String.format("Illegal Argument value '%s'", depth));
            this.depth = depth;
            return this;
        }

        public PackageBox build() {
            return new PackageBox(length, width, depth);
        }
    }
}
