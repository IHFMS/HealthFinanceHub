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
        String sql = "INSERT INTO payment (transaction_id, payment_date, amount, pay_for, patient_name) VALUES (?, ?, ?, ?, ?);";

        Date date = new Date(System.currentTimeMillis());
        Date current = new Date(date.getTime());

        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setLong(1, paymentInfo.getPaymentId());
        statement.setDate(2, current);
        statement.setLong(3, paymentInfo.getAmount());
        statement.setString(4, paymentInfo.getPayFor());
        statement.setString(5, paymentInfo.getPatientName());

        statement.executeUpdate();
    }
}
