package com.bai6.bai_tap.Bai1;

public class Cylinder extends Circle {
    private double height;

    public Cylinder() {
    }
    public Cylinder(double radius, String color,double height) {
        super(radius, color);
        this.height=height;
    }

    public double volume(){
        return (super.aRea()*this.height);
    }
    @Override
    public String toString() {
        return "Cylinder{" +
                "height= " + height +
                "color= " + getColor() +
                "area= " + aRea() +
                "volume= " + volume()+
                '}';
    }

}
