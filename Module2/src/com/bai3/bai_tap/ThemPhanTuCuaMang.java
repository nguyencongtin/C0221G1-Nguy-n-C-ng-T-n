package com.bai3.bai_tap;

import java.util.Arrays;
import java.util.Scanner;

public class ThemPhanTuCuaMang {
    public static void main(String[] args) {
        int size;
        int[] array;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.print("Enter a size:");
            size = scanner.nextInt();
            if (size > 10)
                System.out.println("Size does not exceed 10");
        } while (size > 10);
        array = new int[size];
        int i = 0;
        while (i < array.length) {
            System.out.print("Enter element " + (i + 1) + ": ");
            array[i] = scanner.nextInt();
            i++;
        }
        System.out.println("Enter element you want add: ");
        int add = scanner.nextInt();
        System.out.println("Enter index you want add element: ");
        int index= scanner.nextInt();
        int arr1[]=new int[size+1];
        for (int j=0;j<arr1.length;j++){
            if(j==index){
                arr1[index]=add;
            } else if(j>index){
                arr1[j]=array[j-1];
            } else{
                arr1[j]=array[j];
            }
        }        System.out.println(Arrays.toString(arr1));

    }
}