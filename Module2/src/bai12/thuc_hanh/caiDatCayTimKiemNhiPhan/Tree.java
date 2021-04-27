package bai12.thuc_hanh.caiDatCayTimKiemNhiPhan;

public interface Tree<E> {
    boolean insert(E e);

    void inorder();

    int getSize();

}