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
            String url = "jdbc:postgresql://localhost:5432/frontv1";
            String username = "creed";
            String password = "creed";
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

