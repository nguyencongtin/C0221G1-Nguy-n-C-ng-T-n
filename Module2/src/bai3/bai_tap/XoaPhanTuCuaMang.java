package bai3.bai_tap;

import java.util.Scanner;

public class XoaPhanTuCuaMang {
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
        System.out.println("Enter element you want delete: ");
        int delete = scanner.nextInt();
        for (int h = 0; h < array.length; h++) {
            if (array[h] == delete) {
                for (int g = h; g < array.length - 1; g++) {
                    array[g] = array[g + 1];
                }
            }
        }
        array[array.length - 1] = 0;
        for (int k = 0; k < array.length; k++) {
            System.out.println(array[k]);
        }
    }
}
