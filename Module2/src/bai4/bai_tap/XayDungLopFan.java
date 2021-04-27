package bai4.bai_tap;

public class XayDungLopFan {
    final int SLOW=1;
    final int MEDIUM=2;
    final int FAST=3;
    private int speed=1;
    private boolean on=false;
    private double radius=5;
    private String color="blue";

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getSLOW() {
        return SLOW;
    }

    public int getMEDIUM() {
        return MEDIUM;
    }

    public int getFAST() {
        return FAST;
    }

    public boolean isOn() {
        return on;
    }

    public void setOn(boolean on) {
        this.on = on;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
    public XayDungLopFan(int speed, boolean on, double radius, String color) {
        this.speed=speed;
        this.on = on;
        this.radius = radius;
        this.color = color;
    }
    public XayDungLopFan(){
    }
    public String toString(){
        String result="";
        if(this.on){
            result+=this.speed+ " " +this.color +" "+this.radius+ " Fan is on";
        } else {
            result+=this.color+ " " +this.radius+ " Fan is off";
        }
        return result;
    }

    public static void main(String[] args) {
        XayDungLopFan Fan1= new XayDungLopFan(3,true,10,"yellow");
        XayDungLopFan Fan2= new XayDungLopFan(2,false,5,"blue");
        System.out.println(Fan1.toString());
        System.out.println(Fan2.toString());
    }
}
