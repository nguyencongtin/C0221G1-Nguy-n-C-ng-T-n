package bai7_AbstractClassInterface.bai_tap.TrienKhaiInterfaceResizeableChoCacLopHinhHoc;

import bai6_Inheritance.thuc_hanh.Circle;
import bai6_Inheritance.thuc_hanh.Rectangle;
import bai6_Inheritance.thuc_hanh.Shape;
import bai6_Inheritance.thuc_hanh.Square;

public class MainResize {
    public static void main(String[] args) {
        int x=(int) Math.random()*100;
        Shape [] shapes= new Shape[3];
        shapes[0]=new Circle(x,"red",true);
        shapes[1]=new Square(x,"blue",true);
        shapes[2]=new Rectangle(x,x,"black",true);
        for (Shape i: shapes) {
            System.out.println(i);
        }
        System.out.println("\n");
        for (Shape i: shapes) {
            i.resize(Math.random()*100);
            System.out.println(i.toString());
        }
    }
}