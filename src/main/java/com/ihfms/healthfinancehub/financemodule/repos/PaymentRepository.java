package com.ihfms.healthfinancehub.financemodule.repos;

import com.ihfms.healthfinancehub.entities.datasource.DBConfig;
import com.ihfms.healthfinancehub.financemodule.models.PaymentInfo;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@Repository
public class PaymentRepository
{
    DBConfig dbConfig = DBConfig.getInstance();
    Connection conn = dbConfig.getConnection();

    public void save(PaymentInfo paymentInfo) throws SQLException
    {
        String sql = "INSERT INTO ihfms (paymentId, patientName, amount, payFor, date) VALUES (?, ?, ?, ?, ?);";

        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setLong(1, paymentInfo.getPaymentId());
        statement.setString(2, paymentInfo.getPatientName());
        statement.setLong(3, paymentInfo.getAmount());
        statement.setString(4, paymentInfo.getPayFor());
        statement.setDate(5, (paymentInfo.getDate()));
        statement.executeUpdate();
    }
}
