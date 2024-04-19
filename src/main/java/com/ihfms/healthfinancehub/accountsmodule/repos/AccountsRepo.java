package com.ihfms.healthfinancehub.accountsmodule.repos;

import com.ihfms.healthfinancehub.entities.datasource.DBConfig;
import com.ihfms.healthfinancehub.financemodule.models.Invoice;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


@Repository
public class AccountsRepo {

    DBConfig dbConfig = DBConfig.getInstance();
    Connection connection = dbConfig.getConnection();

    public void generateInvoice(Invoice invoice){

        String sql = "INSERT INTO invoice (invoice_id, amount, issue_date, due_date, patient_id_fk, is_paid) VALUES (?,?,?,?,?,?);";

        try {
            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setLong(1, invoice.getInvoiceId());
            statement.setDouble(2, invoice.getAmount());
            statement.setDate(3, invoice.getIssueDate());
            statement.setDate(4, invoice.getDueDate());
            statement.setLong(5, invoice.getPatientId());
            statement.setBoolean(6, invoice.getIsPaid());

            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public List<Invoice> getAllTransactions(){

        List<Invoice> invoiceList = new ArrayList<>();

        String sql = "SELECT invoice.*, patient.* FROM invoice INNER JOIN patient ON invoice.patient_id_fk = patient.patient_id;";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                // create an instance of invoice to store results from db into invoice object
                Invoice invoice = new Invoice();

                // set fields of invoice object with the column data
                invoice.setInvoiceId(resultSet.getLong("invoice_id"));
                invoice.setAmount(resultSet.getDouble("amount"));
                invoice.setIssueDate(resultSet.getDate("issue_date"));
                invoice.setDueDate(resultSet.getDate("due_date"));
                invoice.setPatientId(resultSet.getLong("patient_id_fk"));
                invoice.setPatientName(resultSet.getString("patient_name"));
                invoice.setIsPaid(resultSet.getBoolean("is_paid"));

                // add the invoice to the list
                invoiceList.add(invoice);
            }
            return invoiceList;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }

    }

    public List<Invoice> getAllPending(){

        List<Invoice> invoiceList = new ArrayList<>();
        int pending = 0;

        String sql = "SELECT invoice.*, patient.* FROM invoice INNER JOIN patient ON invoice.patient_id_fk = patient.patient_id WHERE is_paid = ?;";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setBoolean(1, false);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                // create an instance of invoice to store results from db into invoice object
                Invoice invoice = new Invoice();

                // set fields of invoice object with the column data
                invoice.setInvoiceId(resultSet.getLong("invoice_id"));
                invoice.setAmount(resultSet.getDouble("amount"));
                invoice.setIssueDate(resultSet.getDate("issue_date"));
                invoice.setDueDate(resultSet.getDate("due_date"));
                invoice.setPatientId(resultSet.getLong("patient_id_fk"));
                invoice.setPatientName(resultSet.getString("patient_name"));
                invoice.setIsPaid(resultSet.getBoolean("is_paid"));

                pending++;

                // add the invoice to the list
                invoiceList.add(invoice);
            }
            System.out.println("Pending: " + pending);
            return invoiceList;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }

    }

    public List<Invoice> getNotPending(){

        List<Invoice> invoiceList = new ArrayList<>();
        int notPending = 0;

        String sql = "SELECT invoice.*, patient.* FROM invoice INNER JOIN patient ON invoice.patient_id_fk = patient.patient_id WHERE is_paid = ?;";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setBoolean(1, true);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                // create an instance of invoice to store results from db into invoice object
                Invoice invoice = new Invoice();

                // set fields of invoice object with the column data
                invoice.setInvoiceId(resultSet.getLong("invoice_id"));
                invoice.setAmount(resultSet.getDouble("amount"));
                invoice.setIssueDate(resultSet.getDate("issue_date"));
                invoice.setDueDate(resultSet.getDate("due_date"));
                invoice.setPatientId(resultSet.getLong("patient_id_fk"));
                invoice.setPatientName(resultSet.getString("patient_name"));
                invoice.setIsPaid(resultSet.getBoolean("is_paid"));

                notPending++;

                // add the invoice to the list
                invoiceList.add(invoice);
            }
            System.out.println("Not pending: " + notPending);
            return invoiceList;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }

    }


}
