package com.example.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

public class connectTest {
    public static void main(String[] args) throws ClassNotFoundException {
        String dbFile = "D:/SQLite/DB Browser for SQLite/mission1.db";
        Class.forName("org.sqlite.JDBC");

        try {
                Connection connection = DriverManager.getConnection("jdbc:sqlite:" + dbFile);
                Statement statement = connection.createStatement();
                statement.executeUpdate("insert into locationHistory values " +
                        "(" +
                        "4," +
                        "23.23," +
                        "23.22," +
                        "'2023-03-23'" +
                        ")");
//            while (rs.next()) {
//                System.out.println(
//                        rs.getInt(1)+" "+
//                        rs.getDouble(2)+" "+
//                        rs.getDouble(3)+" "+
//                        rs.getString(4)
//                        );
//            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
