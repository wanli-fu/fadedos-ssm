package com.fadedos.factorybean;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @Description:静态工厂
 * @author: pengcheng
 * @date: 2021/1/20
 */
/*
    实例工厂:  ConnectionFactory cf = new ConnectionFactory();
              cf.getConnection();  --->这两步通过xml配置文件完成的

    静态工厂: StaticConnectionFactory.getConnection();
 */
public class StaticConnectionFactory {
    public static Connection getConnection(){
        Connection conn = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/fadedos?useSSL=false",
                    "root", "password");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }
}
