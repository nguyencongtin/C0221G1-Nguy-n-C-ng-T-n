package model.repository;

import model.bean.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
public class UserRepository {
    BaseRepository baseRepository= new BaseRepository();
    final  String SELECT_ALL_USERS="select* from users";
    final String SELECT_USER_BY_ID="select* from users\n" +
            "where id=?;";
    final String UPDATE_USER_BY_ID ="update users \n" +
            "set name =?, email=?,country=?" +
            "where id =?;";
    final String INSERT_USER="INSERT INTO users" + "  (name, email, country) VALUES " +
            " (?, ?, ?);";
    final String DELETE_USER= "delete from users\n"+
            "where id =?;";
    public List<User> findByAll() {
        // kết nối databe=> lấy lại cái danh sách
        Connection connection =baseRepository.connectDataBase();
        List<User> userList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_USERS);
            ResultSet resultSet= preparedStatement.executeQuery();// dùng cho câu lệnh select;
            while (resultSet.next()){ // duyệt trên từng hàng của bảng
                int id =resultSet.getInt("id");
                String name =resultSet.getString("name");
                String email =resultSet.getString("email");
                String country =resultSet.getString("country");
                User user = new User(id,name,email,country);
                userList.add(user);
            }
//            while (resultSet.next()){ // duyệt trên từng hàng của bảng
//                int id =resultSet.getInt(1);
//                String name =resultSet.getString(2);
//                int age =resultSet.getInt(3);
//                String email =resultSet.getString(4);
//                Student  student = new Student(id,name,age,email);
//                studentList.add(student);
//            }
//            preparedStatement.close();
//            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return userList;
    }

    public User findById(int id) {
        Connection connection =baseRepository.connectDataBase();
        User user =null;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_BY_ID);
            preparedStatement.setInt(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int id1 =resultSet.getInt("id");
                String name =resultSet.getString("name");
                String email =resultSet.getString("email");
                String country=resultSet.getString("country");
                user = new User(id1,name,email,country);
            }
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    public boolean update(int id, User user) {
        Connection connection =baseRepository.connectDataBase();
        boolean check=false;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_USER_BY_ID);
            preparedStatement.setString(1,user.getName());
            preparedStatement.setString(2,user.getEmail());
            preparedStatement.setString(3,user.getCountry());
            preparedStatement.setInt(4,id);
            check =preparedStatement.executeUpdate()>0;
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return check;
    }

    public boolean add(User user) {
        Connection connection=baseRepository.connectDataBase();
        boolean check=false;
        try{
            PreparedStatement preparedStatement=connection.prepareStatement(INSERT_USER);
            preparedStatement.setString(1,user.getName());
            preparedStatement.setString(2,user.getEmail());
            preparedStatement.setString(3,user.getCountry());
            check =preparedStatement.executeUpdate()>0;
            preparedStatement.close();
            connection.close();
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return check;
    }

    public boolean remove(int id) {
        Connection connection=baseRepository.connectDataBase();
        boolean check=false;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_USER);
            preparedStatement.setInt(1,id);
            check =preparedStatement.executeUpdate()>0;
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return check;
    }

    public static void main(String[] args) {
//        UserRepository studentRepository = new UserRepository();
//        System.out.println(studentRepository.findByAll().size());
    }
}
