package bai12_CollectionFramework.thuc_hanh.caiDatCayTimKiemNhiPhan;

public interface Tree<E> {
    boolean insert(E e);

    void inorder();

    int getSize();

}