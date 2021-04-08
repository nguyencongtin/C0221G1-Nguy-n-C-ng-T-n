package com.bai6.bai_tap.Bai2;

import java.util.Arrays;

public class Point2D {
    private float x=0.0f;
    private float y=0.0f;
    public Point2D() {
    }
    public Point2D(float x, float y) {
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
        return Arrays.toString(getXY());
    }

    public static void main(String[] args) {
        Point2D a= new Point2D();
        System.out.println(a);
    }
}
