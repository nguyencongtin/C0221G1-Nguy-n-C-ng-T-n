package com.bai6.bai_tap.Bai2;

import java.util.Arrays;

public class Point3D extends Point2D {
    private float z = 0.0f;

    public Point3D(float x, float y, float z) {
        super(x, y);
        this.z = z;
    }

    public Point3D() {
    }

    public float getZ() {
        return z;
    }

    public void setZ(float z) {
        this.z = z;
    }

    public void setXYZ(float x, float y, float z) {
        float[] arr = new float[3];
        arr[0] = x;
        arr[1] = y;
        arr[2] = z;

    }

    public float[] getXYZ() {
        float[] arr1 = {this.getX(), this.getY(), this.getZ()};
        return arr1;
    }

    @Override
    public String toString() {
        return "Point3D{" +
                "x=" + getX() +
                "y=" + getY() +
                "z=" + z +
                "xyz=" + Arrays.toString(getXYZ()) +
                '}';
    }

    public static void main(String[] args) {
        Point3D a = new Point3D();
        System.out.println(a);
    }
}
