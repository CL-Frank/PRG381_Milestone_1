package com.bcwellness.config;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConfig {
    private static final String URL = "jdbc:postgresql://localhost:5432/StudentDB";
    private static final String USER = "postgres";
    private static final String PASSWORD = "0618";

    public static Connection getConnection() {
        try {
            Class.forName("org.postgresql.Driver");
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
