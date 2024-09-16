package vn.edu.iuh.fit.lab_01.reponsitories;

import vn.edu.iuh.fit.lab_01.connection.ConnectDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GrantAccessRepository {
    public String getRoleOfGrantAccessLoginById(String accountID) throws SQLException, ClassNotFoundException {
        String role = null;
        Connection connection = ConnectDB.getInstance().getConnection();
        String sql = "SELECT role_id FROM grant_access WHERE account_id = ? ";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, accountID);
        ResultSet rs = preparedStatement.executeQuery();
        if (rs.next()) {
            role = rs.getString("role_id");
        }
        return role;
    }
}
