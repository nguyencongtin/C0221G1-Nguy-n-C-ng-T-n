package com.bai12.thuc_hanh.caiDatCayTimKiemNhiPhan;
public class TreeNode<E> {
    protected E element;
    protected TreeNode<E> left;
    protected TreeNode<E> right;

    public TreeNode(E e) {
        this.element = e;
    }
}