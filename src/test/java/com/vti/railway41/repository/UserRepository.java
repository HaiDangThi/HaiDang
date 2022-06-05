package com.vti.railway41.repository;

import com.vti.railway41.config.ConnectionProvider;
import com.vti.railway41.entity.Role;
import com.vti.railway41.entity.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserRepository {
    public static List<User> findAll() {
        String sql = "select id, fullname, email, password, ProjectId, ProSkill, ExpInYear, role\n" + "from user";
        ArrayList<User> users = new ArrayList<>();
        try {
            Connection connection = ConnectionProvider.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String fullName = resultSet.getString("fullname");
                String email = resultSet.getString("email");
                String password = resultSet.getString("password");
                int projectId = Integer.parseInt(resultSet.getString("ProjectId"));
                String proSkill = String.valueOf(resultSet.getInt("ProSkill"));
                int exInYear = resultSet.getInt("ExpInYear");
                String role = resultSet.getString("role");
                User user = new User(id, fullName, email, password, projectId, proSkill, exInYear, Role.valueOf(role));
                users.add(user);
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return users;
    }

    public static User findById(int userId) {
        String sql = "select id, fullname, email, password, ProjectId, ProSkill, ExpInYear, role\n" + "from user WHERE id = ?";
        try {
            Connection connection = ConnectionProvider.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, userId);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                int id = resultSet.getInt("id");
                String fullName = resultSet.getString("fullname");
                String email = resultSet.getString("email");
                String password = resultSet.getString("password");
                int projectId = Integer.parseInt(resultSet.getString("ProjectId"));
                String proSkill = String.valueOf(resultSet.getInt("ProSkill"));
                int exInYear = resultSet.getInt("ExpInYear");
                String role = resultSet.getString("role");
                return new User(id, fullName, email, password, projectId, proSkill, exInYear, Role.valueOf(role));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static boolean deleteById(int id) {
        String sql = "delete from user where id =?";
        try {
            Connection connection = ConnectionProvider.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            int deletedRows = statement.executeUpdate();
            if (deletedRows > 0) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    public static void login() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input your email");
        String email = scanner.nextLine();
        System.out.println("Input your password");
        String password = scanner.nextLine();
        Pattern compileEmail = Pattern.compile("^[\\w\\-_.]+@[\\w\\-_]+(\\.[\\w\\-_]+){1,2}$");
        Matcher matcherEmail = compileEmail.matcher(email);
        if (!matcherEmail.find()) {
            System.out.println("Sai email");
            return;
        }
        Pattern compilePwd = Pattern.compile(".*[A-Z].*");
        Matcher matcherPwd = compilePwd.matcher(password);
        if (!matcherPwd.find() || password.length() < 6 || password.length() > 12) {
            System.out.println("Sai password");
            return;
        }
    }
    public  static boolean  createUser(User user){
        String sql = "INSERT INTO `User` (fullName, email,`password`,ProjectId, proSkill,ExpInYear,`role`) \n" +
                "VALUES (?, ?, ?, ?, ?, ?, ?)";
        try {
            Connection connection = ConnectionProvider.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1,user.getFullName());
            statement.setString(2,user.getEmail());
            statement.setString(3, user.getPassword());
            statement.setInt(4,user.getProjectId());
            statement.setString(7, user.getRole().toString());
            if (user.getRole() == Role.ADMIN){
                statement.setInt(6,user.getExpInYear());
                statement.setObject(5,null);
            }else {
                statement.setObject(6,null);
                statement.setString(5, user.getProSkill());
            }

            int update = statement.executeUpdate();

            if (update>0){
               return  true;
            }
        } catch (SQLException e) {
         e.printStackTrace();
        }
        return false;
    }

}


