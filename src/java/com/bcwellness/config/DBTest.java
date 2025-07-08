package com.bcwellness.config;

import java.sql.Connection;

public class DBTest {
    public static void main(String[] args) {
        Connection conn = DBConfig.getConnection();
        if (conn != null) {
            System.out.println("Connected to PostgreSQL successfully!");
        } else {
            System.out.println("Failed to connect to PostgreSQL.");
        }
    }
}
