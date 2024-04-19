package com.ihfms.healthfinancehub.entities.datasource;

import lombok.Getter;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


// implements singleton

@Getter
public class DBConfig {
    private static DBConfig instance;
    private Connection connection;

    private DBConfig() {
        // Initialize database connection
        try {
            Class.forName("org.postgresql.Driver");
            String url = "jdbc:postgresql://localhost:5432/healthhub";
            String username = "postgres";
            String password = "postgres";
            connection = DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public static DBConfig getInstance() {
        if (instance == null) {
            instance = new DBConfig();
        }
        return instance;
    }

}

