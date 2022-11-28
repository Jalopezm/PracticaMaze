package com.esliceu.practicaMaze.DAO;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionMysql {
    static Connection connection;

    public static Connection getConnection() {
        if (connection != null) return connection;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://mysql:3307/MazeDB", "root", "root");
            return connection;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

