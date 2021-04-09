package com.bai6.thuc_hanh;

import com.bai7.bai_tap.TrienKhaiInterfaceColorableChoCacLopHinhHoc.Colorable;
import com.bai7.bai_tap.TrienKhaiInterfaceResizeableChoCacLopHinhHoc.Resizeable;

public class Shape implements Resizeable, Colorable {
    private String color = "green";
    private boolean filled = true;

    public Shape() {
    }

    public Shape(String color, boolean filled) {
        this.color = color;
        this.filled = filled;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean isFilled() {
        return filled;
    }

    public void setFilled(boolean filled) {
        this.filled = filled;
    }

    @Override
    public String toString() {
        return "A Shape with color of "
                + getColor()
                + " and "
                + (isFilled() ? "filled" : "not filled");
    }


    @Override
    public void resize(double percent) {
    }

    @Override
    public void howToColor() {
        System.out.println(" Color all four sides.");
    }
}