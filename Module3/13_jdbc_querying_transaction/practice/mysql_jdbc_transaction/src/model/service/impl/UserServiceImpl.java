package model.service.impl;

import model.bean.User;
import model.repository.UserRepository;
import model.service.IUserService;

import java.sql.SQLException;
import java.util.List;

public class UserServiceImpl implements IUserService {
    UserRepository userRepository=new UserRepository();
    @Override
    public List<User> findByAll() {
        return userRepository.findByAll();
    }

    @Override
    public User findById(int id) {
        return userRepository.findById(id);
    }

    @Override
    public boolean update(int id, User user) {
        return userRepository.update(id,user);
    }

    @Override
    public boolean add(User user) {
        return userRepository.add(user);
    }

    @Override
    public boolean remove(int id) {
        return userRepository.remove(id);
    }

    @Override
    public List<User> findByCountry(String country) {
        return userRepository.findByCountry(country);
    }

    @Override
    public List<User> sortByName() {
        return userRepository.sortByName();
    }

    @Override
    public User getUserById(int id) {
        return userRepository.getUserById(id);
    }

    @Override
    public void insertUserStore(User user) {
        try {
            userRepository.insertUserStore(user);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void addUserTransaction(User user, int[] permision) {
            userRepository.addUserTransaction(user,permision);
    }

    @Override
    public void insertUpdateWithoutTransaction() {
            userRepository.insertUpdateWithoutTransaction();
    }

    @Override
    public void insertUpdateUseTransaction() {
            userRepository.insertUpdateUseTransaction();
    }

    @Override
    public List<User>showUserStore() {
            return userRepository.showUserStore();
    }

    @Override
    public boolean updateUserStore(int id, User user) {
        return userRepository.updateUserStore(id,user);
    }

    @Override
    public boolean deleteUserStore(int id) {
        return userRepository.deleteUserStore(id);
    }


}
