package com.bai6.bai_tap.Bai3;

import com.bai6.bai_tap.Bai2.Point2D;

import java.util.Arrays;

public class Point {
    protected float x = 0.0f;
    protected float y = 0.0f;

    public Point(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }
    public void setXY(float x,float y){
        float[] arr=new float[2];
        arr[0]=x;
        arr[1]=y;
    }
    public float[] getXY(){
        float[] arr=new float[2];
        arr[0]=x;
        arr[1]=y;
        return arr;
    }

    @Override
    public String toString() {
        return "Point{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }

    public static void main(String[] args) {
        Point a= new Point(1,2);
        System.out.println(a);
    }

}
