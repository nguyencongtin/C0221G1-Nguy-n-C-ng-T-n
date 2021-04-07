package com.bai5.bai_tap;

import com.bai5.bai_tap.Circle;

import java.util.Scanner;

class TestCircle{
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        System.out.println("enter radius: ");
        double radius=sc.nextDouble();
        Circle circle= new Circle(radius);
        System.out.println(circle.getRadius());
        System.out.println(circle.aRea());
    }
}
