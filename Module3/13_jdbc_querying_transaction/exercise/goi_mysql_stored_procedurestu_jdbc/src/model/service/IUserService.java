package model.service;

import model.bean.User;

import java.sql.SQLException;
import java.util.List;

public interface IUserService {
    List<User> findByAll();
    User findById(int id);
    boolean update(int id, User user);
    boolean add(User user);
    boolean remove(int id);
    List<User> findByCountry(String country);
    List<User> sortByName();
    User getUserById(int id);
    void insertUserStore(User user);
    void addUserTransaction(User user, int[] permisions);
    public void insertUpdateWithoutTransaction();
    public void insertUpdateUseTransaction();
    List<User> showUserStore();
    boolean updateUserStore(int id, User user );
    boolean deleteUserStore(int id);
}
