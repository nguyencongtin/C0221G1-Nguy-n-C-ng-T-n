package com.bai12.bai_tap;

import com.bai12.thuc_hanh.caiDatCayTimKiemNhiPhan.BST;

public class TestSearchBST {
    public static void main(String[] args) {
        BST<Integer> tree = new BST<>();
        tree.insert(5);
        tree.insert(6);
        tree.insert(10);
        tree.insert(8);
        tree.insert(3);
        System.out.println(tree.search(15));
    }
}