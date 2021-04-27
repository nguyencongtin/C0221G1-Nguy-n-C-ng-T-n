package bai2.bai_tap;

import java.util.Scanner;

public class HienThi20SoNguyenToDauTien {
    //    public static void main(String[] args) {
//         int num=0;
//         StringBuilder result= new StringBuilder(0);
//         int count=0;
//        while (count<20) {
//             boolean check = true;
//            if (num < 2) {
//                check = false;
//            } else {
//                for ( int i = 2; i <= Math.sqrt(num); i++) {
//                    if (num % i == 0) {
//                        check = false;
//                        break;
//                    }
//                }
//            }
//            if (check) {
//                count++;
//                result.append(num).append(" ");
//            }
//            num++;
//        }
//        System.out.println(result);
//    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = 0;
        int count = 0;
        while (count < 20) {
            boolean check = true;
            if (num < 2) {
                check = false;
            } else {
                for (int i = 2; i <= Math.sqrt(num); i++) {
                    if (num % i == 0) {
                        check = false;
                        break;
                    }
                }
                if (check) {
                    System.out.print(" "+num);
                    count++;
                }
            }
            num++;
        }
    }
}