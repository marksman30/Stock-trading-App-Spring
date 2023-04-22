package com.shareapp.spring.service;

import java.sql.*;

public class Jdbc {
    public static Connection JdbcConnect() throws SQLException {

        String url = "jdbc:mysql://localhost:3306/stockuser";
        String usn = "root";
        String pw="";
        return  DriverManager.getConnection(url, usn, pw);

    }
}
