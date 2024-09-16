package vn.edu.iuh.fit.lab_01.reponsitories;

import vn.edu.iuh.fit.lab_01.connection.ConnectDB;
import vn.edu.iuh.fit.lab_01.entyties.Account;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class AccountRepository {
    public Optional<Account> login(String email, String password) throws SQLException, ClassNotFoundException {
        Connection connection = ConnectDB.getInstance().getConnection();
        try {
            String sql = "Select * from account where email =? and password=?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, email);
            preparedStatement.setString(2, password);
            ResultSet resultSet = preparedStatement.executeQuery();

            // Xử lý dữ liệu từ ResultSet
            while (resultSet.next()) {
                String account_id = resultSet.getString("account_id");
                String full_name = resultSet.getString("full_name");
                String pass = resultSet.getString("password");
                String mail = resultSet.getString("email");
                String phone = resultSet.getString("phone");
                Integer status = resultSet.getInt("status");
                Account account = new Account(account_id, full_name, pass, mail, phone, status);
                return Optional.of(account);
            }

            resultSet.close();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    public boolean addAccount(Account newAccount) throws SQLException, ClassNotFoundException {
        Connection connection = ConnectDB.getInstance().getConnection();
        try {
            String sql = "INSERT into account VALUES(?,?,?,?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, newAccount.getAccountId());
            preparedStatement.setString(2, newAccount.getFullName());
            preparedStatement.setString(3, newAccount.getPassword());
            preparedStatement.setString(4, newAccount.getEmail());
            preparedStatement.setString(5, newAccount.getPhone());
            preparedStatement.setInt(6, newAccount.getStatus());
            System.out.println(newAccount.toString());
            // Thực hiện truy vấn INSERT và kiểm tra kết quả
            int rowAffected = preparedStatement.executeUpdate();
            if (rowAffected > 0) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<Account> getAllAccount() throws SQLException, ClassNotFoundException {
        List<Account> accounts = new ArrayList<>();
        Connection connection = ConnectDB.getInstance().getConnection();
        String sql = "SELECT * FROM account";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            String account_id = resultSet.getString("account_id");
            String full_name = resultSet.getString("full_name");
            String pass = resultSet.getString("password");
            String mail = resultSet.getString("email");
            String phone = resultSet.getString("phone");
            Integer status = resultSet.getInt("status");
            Account account = new Account(account_id, full_name, pass, mail, phone, status);
            accounts.add(account);
        }
        return accounts;
    }
}
