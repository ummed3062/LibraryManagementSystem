package com.library.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class CreatConnection {

    static Connection con;

    static Connection getConnection() {
        if (con != null) {
            return con;
        } else {
            try {
                //Driver load....
                Class.forName("com.mysql.cj.jdbc.Driver");
                //Create connection......
                String url = "jdbc:mysql://localhost:3306/library_manage";
                String root = "root";
                String password = "toor";
                con = DriverManager.getConnection(url,root,password);


            } catch (Exception ex) {
                System.out.println("Unable to connect to Database");
            }
        }
        return con;
    }
}
