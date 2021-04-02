package com.bai2.bai_tap;

import java.util.Scanner;

public class HienThiCacSoNguyenToNhoHon100 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num=0;
        while (num < 100) {
            boolean check = true;
            if (num < 2) {
                check = false;
            } else {
                for (int i = 2; i < num; i++) {
                    if (num%i == 0) {
                        check = false;
                        break;
                    }
                }
                if (check) {
                    System.out.print(" " + num);
                }
            }
            num++;
        }
    }
}