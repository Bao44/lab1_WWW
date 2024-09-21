package vn.edu.iuh.fit.lab_01.reponsitories;

import vn.edu.iuh.fit.lab_01.connection.ConnectDB;
import vn.edu.iuh.fit.lab_01.entyties.Account;
import vn.edu.iuh.fit.lab_01.entyties.Role;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RoleRepository {
    public List<Role> getListRoleForAccount(String id) throws SQLException, ClassNotFoundException {
        List<Role> roles = new ArrayList<>();
        Role role = new Role();
        Connection connection = ConnectDB.getInstance().getConnection();
        String sql = "SELECT * FROM account a INNER JOIN grant_access ga ON ga.account_id = a.account_id  INNER JOIN role r ON ga.role_id = r.role_id WHERE a.account_id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            role.setRoleId(resultSet.getString("role_id"));
            role.setRoleName(resultSet.getString("role_name"));
            role.setDescription(resultSet.getString("description"));
            role.setStatus(resultSet.getByte("status"));
            roles.add(role);
        }
        return roles;
    }
}
