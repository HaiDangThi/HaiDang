package com.vti.railway41.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionProvider {
    private static String url = "jdbc:mysql://localhost:3306/QLCB";
    private static String username = "root";
    private static String pwd = "root";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, username, pwd);
    }
}
