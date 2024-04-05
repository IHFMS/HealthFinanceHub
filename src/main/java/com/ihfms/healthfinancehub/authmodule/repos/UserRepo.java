package com.ihfms.healthfinancehub.authmodule.repos;

import com.ihfms.healthfinancehub.authmodule.models.usermodels.User;
import com.ihfms.healthfinancehub.entities.datasource.DBConfig;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@Repository
public class UserRepo {

    DBConfig dbConfig = DBConfig.getInstance();
    Connection conn = dbConfig.getConnection();

    public void insertUser(User user) throws SQLException {
        String sql = "INSERT INTO users (userid, username, email, password, role) VALUES (?, ?, ?, ?, ?);";

        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setLong(1, user.getUserID());
        statement.setString(2, user.getUsername());
        statement.setString(3, user.getEmail());
        statement.setString(4, user.getPassword());
        statement.setString(5, user.getRole().toString());
        statement.executeUpdate();

    }


}
