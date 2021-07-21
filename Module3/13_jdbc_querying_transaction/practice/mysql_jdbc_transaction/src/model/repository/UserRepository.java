package model.repository;

import model.bean.User;

import java.math.BigDecimal;
import java.sql.*;
import java.time.LocalDateTime;
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
    final String SELECT_BY_NAME="select * from users order by `name`;";
    final String FIND_BY_COUNTRY="select* from users\n" +
            "where country like ?;";
    final String query = "{CALL get_user_by_id(?)}";
    String query1 = "{CALL get_user_by_id(?)}";
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

    public void insertUserStore(User user) throws SQLException {

        try (Connection connection = baseRepository.connectDataBase();
             CallableStatement callableStatement = connection.prepareCall(query);) {

            callableStatement.setString(1, user.getName());

            callableStatement.setString(2, user.getEmail());

            callableStatement.setString(3, user.getCountry());

            System.out.println(callableStatement);

            callableStatement.executeUpdate();

        } catch (SQLException e) {

            e.printStackTrace();
        }

    }

    public User getUserById(int id) {

        User user = null;

        try (Connection connection = baseRepository.connectDataBase();


             CallableStatement callableStatement = connection.prepareCall(query1);) {

            callableStatement.setInt(1, id);


            ResultSet rs = callableStatement.executeQuery();

            while (rs.next()) {

                String name = rs.getString("name");

                String email = rs.getString("email");

                String country = rs.getString("country");

                user = new User(id, name, email, country);

            }

        } catch (SQLException e) {

            e.printStackTrace();
        }

        return user;

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

    public List<User> sortByName() {
        List<User> users = new ArrayList<>();
        try {
            Connection connection = baseRepository.connectDataBase();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_BY_NAME);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                String country = resultSet.getString("country");
                users.add(new User(id, name, email, country));
            }
        } catch (SQLException e) { e.printStackTrace();}
        return users;
    }

    public void addUserTransaction(User user, int[] permisions) {

        Connection conn = null;


        PreparedStatement pstmt = null;


        PreparedStatement pstmtAssignment = null;

        ResultSet rs = null;

        try {

            conn = baseRepository.connectDataBase();


            conn.setAutoCommit(false);


            pstmt = conn.prepareStatement(INSERT_USER, Statement.RETURN_GENERATED_KEYS);

            pstmt.setString(1, user.getName());

            pstmt.setString(2, user.getEmail());

            pstmt.setString(3, user.getCountry());

            int rowAffected = pstmt.executeUpdate();

            // get user id

            rs = pstmt.getGeneratedKeys();

            int userId = 0;

            if (rs.next())

                userId = rs.getInt(1);

            //

            // in case the insert operation successes, assign permision to user

            //

            if (rowAffected == 1) {

                // assign permision to user

                String sqlPivot = "INSERT INTO user_permision(user_id,permision_id) "

                        + "VALUES(?,?)";

                pstmtAssignment = conn.prepareStatement(sqlPivot);

                for (int permisionId : permisions) {

                    pstmtAssignment.setInt(1, userId);

                    pstmtAssignment.setInt(2, permisionId);

                    pstmtAssignment.executeUpdate();

                }

                conn.commit();

            } else {

                conn.rollback();

            }

        } catch (SQLException ex) {

            // roll back the transaction

            try {

                if (conn != null)

                    conn.rollback();

            } catch (SQLException e) {

                System.out.println(e.getMessage());

            }

            System.out.println(ex.getMessage());

        } finally {

            try {

                if (rs != null) rs.close();

                if (pstmt != null) pstmt.close();

                if (pstmtAssignment != null) pstmtAssignment.close();

                if (conn != null) conn.close();

            } catch (SQLException e) {

                System.out.println(e.getMessage());

            }

        }

    }

    private static final String SQL_INSERT = "INSERT INTO EMPLOYEE (NAME, SALARY, CREATED_DATE) VALUES (?,?,?)";

    private static final String SQL_UPDATE = "UPDATE EMPLOYEE SET SALARY=? WHERE NAME=?";

    private static final String SQL_TABLE_CREATE = "CREATE TABLE EMPLOYEE"

            + "("

            + " ID serial,"

            + " NAME varchar(100) NOT NULL,"

            + " SALARY numeric(15, 2) NOT NULL,"

            + " CREATED_DATE timestamp,"

            + " PRIMARY KEY (ID)"

            + ")";
    private static final String SQL_TABLE_DROP = "DROP TABLE IF EXISTS EMPLOYEE";

    public void insertUpdateWithoutTransaction() {

        try (Connection conn = baseRepository.connectDataBase();

             Statement statement = conn.createStatement();

             PreparedStatement psInsert = conn.prepareStatement(SQL_INSERT);

             PreparedStatement psUpdate = conn.prepareStatement(SQL_UPDATE)) {

            statement.execute(SQL_TABLE_DROP);

            statement.execute(SQL_TABLE_CREATE);

            // Run list of insert commands

            psInsert.setString(1, "Quynh");

            psInsert.setBigDecimal(2, new BigDecimal(10));

            psInsert.setTimestamp(3, Timestamp.valueOf(LocalDateTime.now()));

            psInsert.execute();


            psInsert.setString(1, "Ngan");

            psInsert.setBigDecimal(2, new BigDecimal(20));

            psInsert.setTimestamp(3, Timestamp.valueOf(LocalDateTime.now()));

            psInsert.execute();


            // Run list of update commands

            // below line caused error, test transaction

            // org.postgresql.util.PSQLException: No value specified for parameter 1.

            psUpdate.setBigDecimal(2, new BigDecimal(999.99));

            //psUpdate.setBigDecimal(1, new BigDecimal(999.99));

            psUpdate.setString(2, "Quynh");

            psUpdate.execute();

        } catch (Exception e) {

            e.printStackTrace();

        }

    }

    public void insertUpdateUseTransaction() {

        try (Connection conn = baseRepository.connectDataBase();

             Statement statement = conn.createStatement();

             PreparedStatement psInsert = conn.prepareStatement(SQL_INSERT);

             PreparedStatement psUpdate = conn.prepareStatement(SQL_UPDATE)) {

            statement.execute(SQL_TABLE_DROP);

            statement.execute(SQL_TABLE_CREATE);

            // start transaction block

            conn.setAutoCommit(false); // default true

            // Run list of insert commands

            psInsert.setString(1, "Quynh");

            psInsert.setBigDecimal(2, new BigDecimal(10));

            psInsert.setTimestamp(3, Timestamp.valueOf(LocalDateTime.now()));

            psInsert.execute();

            psInsert.setString(1, "Ngan");

            psInsert.setBigDecimal(2, new BigDecimal(20));

            psInsert.setTimestamp(3, Timestamp.valueOf(LocalDateTime.now()));

            psInsert.execute();

            // Run list of update commands

            // below line caused error, test transaction

            // org.postgresql.util.PSQLException: No value specified for parameter 1.

//            psUpdate.setBigDecimal(2, new BigDecimal(999.99)); -- thằng ni lỗi nè
            psUpdate.setBigDecimal(1, new BigDecimal(999.99));
            //psUpdate.setBigDecimal(1, new BigDecimal(999.99));

            psUpdate.setString(2, "Quynh");

            psUpdate.execute();

            // end transaction block, commit changes

            conn.commit();

            // good practice to set it back to default true

            conn.setAutoCommit(true);

        } catch (Exception e) {

            System.out.println(e.getMessage());

            e.printStackTrace();

        }

    }

    public List<User> showUserStore(){

        List<User> userList = new ArrayList<>();
        try {
            String showUser= "{call get_information()}";
            Connection connection =baseRepository.connectDataBase();
            CallableStatement callableStatement = connection.prepareCall(showUser);
            ResultSet resultSet= callableStatement.executeQuery();// dùng cho câu lệnh select;
            while (resultSet.next()){ // duyệt trên từng hàng của bảng
                int id =resultSet.getInt("id");
                String name =resultSet.getString("name");
                String email =resultSet.getString("email");
                String country =resultSet.getString("country");
                User user = new User(id,name,email,country);
                userList.add(user);
            }

//            preparedStatement.close();
//            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userList ;
    }

    public boolean updateUserStore(int id, User user) {
        Connection connection =baseRepository.connectDataBase();
        boolean check=false;
        try {
            String updateStore = "{call sp_update(?,?,?,?)}";
            CallableStatement callableStatement = connection.prepareCall(updateStore);
            callableStatement.setString(2,user.getName());
            callableStatement.setString(3,user.getEmail());
            callableStatement.setString(4,user.getCountry());
            callableStatement.setInt(1,id);
            check =callableStatement.executeUpdate()>0;
            callableStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return check;
    }

    public boolean deleteUserStore(int id) {
        Connection connection=baseRepository.connectDataBase();
        boolean check=false;
        try {
            String deleteUser= "{call sp_delete(?)}";
            CallableStatement callableStatement = connection.prepareCall(deleteUser);
            callableStatement.setInt(1,id);
            check =callableStatement.executeUpdate()>0;
            callableStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return check;
    }
    
    public List<User> findByCountry(String country) {
        Connection connection = baseRepository.connectDataBase();
        List<User> users = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_BY_COUNTRY);
            preparedStatement.setString(1,"%"+country+"%");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                String country1 = resultSet.getString("country");
                users.add(new User(id, name, email, country1));
            }
        } catch (SQLException e) { e.printStackTrace();}
        return users;
    }
    public static void main(String[] args) {
//        UserRepository studentRepository = new UserRepository();
//        User uservv=new User("bvb","ooo","hye");
//        System.out.println(studentRepository.deleteUserStore(5));
    }
}
