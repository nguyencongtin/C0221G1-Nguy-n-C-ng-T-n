package com.bai4.bai_tap;

import java.util.Scanner;

public class XayDungLopQuadraticEquation {

    private double a;
    private double b;
    private double c;

    public double getA() {
        return a;
    }

    public void setA(double a) {
        this.a = a;
    }

    public double getB() {
        return b;
    }

    public void setB(double b) {
        this.b = b;
    }

    public double getC() {
        return c;
    }

    public void setC(double c) {
        this.c = c;
    }

    public XayDungLopQuadraticEquation(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;

    }

    public double getDiscriminant() {
        return (this.b * this.b - 4 * this.a * this.c);

    }

    public double getRoot1() {
        return ((-this.b + Math.pow(this.b * this.b - 4 * this.a * this.c, 0.5)) / 2 * this.a);

    }

    public double getRoot2() {
        return ((-this.b - Math.pow(this.b * this.b - 4 * this.a * this.c, 0.5)) / 2 * this.a);
    }
    public double getRoot(){
        return (-this.b/(2*this.a));
    }
    public String hienThi() {
        if (getDiscriminant() > 0) {
            return("Có 2 nghiệm là " + getRoot1()+" và "+getRoot2());
        } else if (getDiscriminant() == 0) {
            return ("Có 1 nghiệm là " + getRoot() );
        } else {
            return("The equation has no roots");
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập a: ");
        double a = scanner.nextDouble();
        System.out.println("Nhập b: ");
        double b = scanner.nextDouble();
        System.out.println("Nhập c : ");
        double c = scanner.nextDouble();
        XayDungLopQuadraticEquation s=new XayDungLopQuadraticEquation(a,b,c);
        System.out.println(s.hienThi());
    }
}