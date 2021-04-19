package com.bai13.bai_tap.caiDatThuatToanTimKiemNhiPhanSuDungDeQuy;

public class BinarySearch {
    static int[] list = {0, 1, 3, 5, 7, 9, 11};

    static int binarySearch(int[] list, int key) {
        int low = 0;
        int high = list.length - 1;
        while (high >= low) {
            int mid = (low + high) / 2;
            if (key < list[mid])
                high = mid - 1;
            else if (key == list[mid])
                return mid;
            else
                low = mid + 1;
        }
        return -1;
    }
    public static void main(String[] args) {
        System.out.println(binarySearch(list, 2));
        System.out.println(binarySearch(list, 5));
        System.out.println(binarySearch(list, 1));
        System.out.println(binarySearch(list, 15));
        System.out.println(binarySearch(list, 9));
        System.out.println(binarySearch(list, 7));
    }
}