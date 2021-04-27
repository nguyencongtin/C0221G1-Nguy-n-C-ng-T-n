package bai6.bai_tap.Bai1;

import java.util.Scanner;

public class CircleTest {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        String color= sc.nextLine();
        double radius= sc.nextDouble();
//        sc.skip("\\R"); dòng lệnh này dùng để tránh việc lệnh nextline nuốt enter của lệnh double trước nó, nếu không muốn dùng lệnh này thì đưa nextline lên đầu
        double height= sc.nextDouble();
        Cylinder cylinder= new Cylinder(radius,color,height);
        System.out.println(cylinder.toString());
    }
}
