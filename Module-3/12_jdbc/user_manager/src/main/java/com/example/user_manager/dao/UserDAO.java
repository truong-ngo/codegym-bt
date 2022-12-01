package com.example.user_manager.dao;

import com.example.user_manager.model.User;

import java.math.BigDecimal;
import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class UserDAO implements InterfaceDAO<User> {
    private String url = "jdbc:mysql://localhost:3306/jdbc_demo";
    private String username = "root";
    private String password = "123456";

    private static final String INSERT_USERS_SQL = "INSERT INTO users (name, email, country) VALUES (?, ?, ?);";
    private static final String SELECT_USER_BY_ID = "select id,name,email,country from users where id = ?";
    private static final String SELECT_ALL_USERS = "select * from users";
    private static final String DELETE_USERS_SQL = "delete from users where id = ?;";
    private static final String UPDATE_USERS_SQL = "update users set name = ?,email= ?, country =? where id = ?;";
    private static final String SORT_USERS = "select * from users order by ";
    private static final String GET_BY_ID = "{call get_user_by_id(?)}";
    private static final String INSERT_STORED = "{call insert_user(?,?,?)}";
    String sqlPivot = "INSERT INTO user_permission(user_id,permission_id) VALUES(?,?)";
    private static final String SEARCH = "select * from users where name like ?";

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
    private static final String SQL_INSERT = "INSERT INTO EMPLOYEE (NAME, SALARY, CREATED_DATE) VALUES (?,?,?)";
    private static final String SELECT_ALL_STORED = "{call display_all()}";
    private static final String DELETE_STORED = "{call delete_user(?)}";
    private static final String UPDATE_STORED = "{call update_user(?,?,?,?)}";

    public UserDAO() {
    }

    protected Connection getConnection() {
        Connection connection;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException | SQLException exception) {
            throw new RuntimeException(exception);
        }
        return connection;
    }

    @Override
    public void insert(User user) throws SQLException {
        try (Connection connection = getConnection();
            PreparedStatement statement = connection.prepareStatement(INSERT_USERS_SQL)) {
            statement.setString(1, user.getName());
            statement.setString(2, user.getEmail());
            statement.setString(3, user.getCountry());
            statement.executeUpdate();
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }

    @Override
    public User select(int id) {
        User user = null;
        try (Connection connection = getConnection();
            PreparedStatement statement = connection.prepareStatement(SELECT_USER_BY_ID)) {
            statement.setInt(1, id);
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                String name = result.getString("name");
                String email = result.getString("email");
                String country = result.getString("country");
                user = new User(id, name, email, country);
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return user;
    }

    @Override
    public List<User> selectAll() {
        List<User> users = new ArrayList<>();
        try (Connection connection = getConnection();
            PreparedStatement statement = connection.prepareStatement(SELECT_ALL_USERS)) {
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                int id = result.getInt("id");
                String name = result.getString("name");
                String email = result.getString("email");
                String country = result.getString("country");
                users.add(new User(id, name, email, country));
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return users;
    }

    @Override
    public boolean delete(int id) throws SQLException {
        boolean rowDeleted;
        try (Connection connection = getConnection();
            PreparedStatement statement = connection.prepareStatement(DELETE_USERS_SQL)) {
            statement.setInt(1, id);
            rowDeleted = statement.executeUpdate() > 0;
        }
        return rowDeleted;
    }

    @Override
    public boolean update(int id, User user) throws SQLException {
        boolean rowUpdated;
        try (Connection connection = getConnection();
            PreparedStatement statement = connection.prepareStatement(UPDATE_USERS_SQL)) {
            statement.setString(1, user.getName());
            statement.setString(2, user.getEmail());
            statement.setString(3, user.getCountry());
            statement.setInt(4, id);
            rowUpdated = statement.executeUpdate() > 0;
        }
        return rowUpdated;
    }

    @Override
    public User getById(int id) throws SQLException {
        User user = null;
        try (Connection connection = getConnection();
            CallableStatement statement = connection.prepareCall(GET_BY_ID)) {
            statement.setInt(1, id);
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                String name = result.getString("name");
                String email = result.getString("email");
                String country = result.getString("country");
                user = new User(id, name, email, country);
            }
            return user;
        }

    }

    @Override
    public void insertStored(User user) throws SQLException {
        try (Connection connection = getConnection();
            CallableStatement statement = connection.prepareCall(INSERT_STORED)) {
            statement.setString(1, user.getName());
            statement.setString(2, user.getEmail());
            statement.setString(3, user.getCountry());
            statement.executeUpdate();
        }
    }

    @Override
    public void addUserTransaction(User user, int[] permission) throws SQLException {
        PreparedStatement assignment = null;
        PreparedStatement statement = null;
        Connection connection = null;
        ResultSet result = null;
        try {
            connection = getConnection();
            connection.setAutoCommit(false);
            statement = connection.prepareStatement(INSERT_USERS_SQL, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, user.getName());
            statement.setString(2, user.getEmail());
            statement.setString(3, user.getCountry());
            int rowAffected = statement.executeUpdate();
            result = statement.getGeneratedKeys();
            int userId = 0;
            if (result.next()) {
                userId = result.getInt(1);
            }
            if (rowAffected == 1) {
                assignment = connection.prepareStatement(sqlPivot);
                for (int permissionId : permission) {
                    assignment.setInt(1, userId);
                    assignment.setInt(2, permissionId);
                    assignment.executeUpdate();
                }
                connection.commit();
            } else {
                connection.rollback();
            }
        } catch (SQLException ex) {
            try {
                if (connection != null)
                    connection.rollback();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
            System.out.println(ex.getMessage());
        } finally {
            try {
                if (result != null) result.close();
                if (statement != null) statement.close();
                if (assignment != null) assignment.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public void testTransaction(User user) throws SQLException {
        Connection connection = null;
        PreparedStatement statement = null;
        PreparedStatement assignment = null;
        try {
            connection = getConnection();
            connection.setAutoCommit(false);
            statement = connection.prepareStatement(INSERT_USERS_SQL);
            statement.setString(1, user.getName());
            statement.setString(2, user.getEmail());
            statement.setString(3, user.getCountry());
            statement.executeUpdate();

            assignment = connection.prepareStatement(UPDATE_USERS_SQL);
            assignment.setString(1, "Truong");
            assignment.setString(2, "truong@gmail.com");
            assignment.setString(3, "Viet Nam");
            assignment.setInt(4, 20);

            connection.rollback();
        } catch (SQLException e) {
            connection.rollback();
        }
    }

    @Override
    public void insertUpdateWithoutTransaction() throws SQLException {
        try (Connection connection = getConnection();
            Statement statement = connection.createStatement();
            PreparedStatement sInsert = connection.prepareStatement(SQL_INSERT);
            PreparedStatement sUpdate = connection.prepareStatement(SQL_UPDATE)) {
            statement.execute(SQL_TABLE_DROP);
            statement.execute(SQL_TABLE_CREATE);

            sInsert.setString(1, "Quynh");
            sInsert.setBigDecimal(2, new BigDecimal(10));
            sInsert.setTimestamp(3, Timestamp.valueOf(LocalDateTime.now()));
            sInsert.execute();

            sUpdate.setBigDecimal(2, new BigDecimal(999.99));
            sUpdate.setString(2, "Quynh");
            sUpdate.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void insertUpdateUseTransaction() throws SQLException {
        try (Connection connection = getConnection();
             Statement statement = connection.createStatement();
             PreparedStatement sInsert = connection.prepareStatement(SQL_INSERT);
             PreparedStatement sUpdate = connection.prepareStatement(SQL_UPDATE)) {
            statement.execute(SQL_TABLE_DROP);
            statement.execute(SQL_TABLE_CREATE);

            connection.setAutoCommit(false);

            sInsert.setString(1, "Quynh");
            sInsert.setBigDecimal(2, new BigDecimal(10));
            sInsert.setTimestamp(3, Timestamp.valueOf(LocalDateTime.now()));

            sInsert.setString(1, "Ngan");
            sInsert.setBigDecimal(2, new BigDecimal(20));
            sInsert.setTimestamp(3, Timestamp.valueOf(LocalDateTime.now()));
            sInsert.execute();

            sUpdate.setBigDecimal(2, new BigDecimal(999.99));
            sUpdate.setString(2, "Quynh");
            sUpdate.executeUpdate();

            connection.rollback();
            connection.setAutoCommit(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<User> selectAllStored() throws SQLException {
        List<User> users = new ArrayList<>();
        try (Connection connection = getConnection();
            CallableStatement statement = connection.prepareCall(SELECT_ALL_STORED)) {
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                int id = result.getInt("id");
                String name = result.getString("name");
                String email = result.getString("email");
                String country = result.getString("country");
                users.add(new User(id, name, email, country));
            }
        }
        return users;
    }

    @Override
    public boolean deleteStored(int id) throws SQLException {
        boolean rowDeleted;
        try (Connection connection = getConnection();
            PreparedStatement statement = connection.prepareStatement(DELETE_STORED)) {
            statement.setInt(1, id);
            rowDeleted = statement.executeUpdate() > 0;
        }
        return rowDeleted;
    }

    @Override
    public boolean updateStored(int id, User user) throws SQLException {
        boolean rowUpdated;
        try (Connection connection = getConnection();
            PreparedStatement statement = connection.prepareStatement(UPDATE_STORED)) {
            statement.setInt(1, id);
            statement.setString(2, user.getName());
            statement.setString(3, user.getEmail());
            statement.setString(4, user.getCountry());
            rowUpdated = statement.executeUpdate() > 0;
        }
        return rowUpdated;
    }

    public List<User> sort(String item) throws SQLException {
        List<User> sortList = new ArrayList<>();
        Connection connection = getConnection();
        String statementStr = SORT_USERS + item;
        PreparedStatement statement = connection.prepareStatement(statementStr);
        ResultSet result = statement.executeQuery();
        while (result.next()) {
            int id = result.getInt("id");
            String name = result.getString("name");
            String email = result.getString("email");
            String country = result.getString("country");
            sortList.add(new User(id, name, email, country));
        }
        connection.close();
        return sortList;
    }
}
