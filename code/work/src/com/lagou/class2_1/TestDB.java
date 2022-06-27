package com.lagou.class2_1;

import java.sql.*;

public class TestDB {

    public static void main(String[] args) throws SQLException {
        Connection connection = DBUtils.getConnection();
        String sql = "SELECT id, name, gender, salary, bonus, join_date FROM employee WHERE gender = ? AND id > ?";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, "F");
        ps.setInt(2, 19);
        ResultSet resultSet = ps.executeQuery();
        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            String gender = resultSet.getString("gender");
            double salary = resultSet.getDouble("salary");
            double bonus = resultSet.getDouble("bonus");
            Date join_date = resultSet.getDate("join_date");
            System.out.println(id + "|" + name + "|" + gender + "|" + salary + "|" + bonus + "|" + join_date);
        }
        DBUtils.close(connection, ps, resultSet);
    }




}
