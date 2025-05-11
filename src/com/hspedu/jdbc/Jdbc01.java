package com.hspedu.jdbc;

import com.mysql.jdbc.Driver;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class Jdbc01 {
    public static void main(String[] args) throws SQLException {
        //1.注册驱动
        Driver driver = new Driver();
        //2.得到连接
        //（1） jdbc:mysqL:// 规定好表示协议，通过jdbc的方式连接mysql
        //（2） Localhost 主机，可以是ip地址
        // (3)3306 表示mysqL监听的端口
        //（4）hsp_db02 连接到mysql dbms 的哪个数据库
        //（5）mysqL的连接本质就是前面学过的socket连接
        String url = "jdbc:mysql://localhost:3306/flora_db01";
        //将用户名和密码放进Properties对象
        Properties properties = new Properties();
        //说明 user 和 password 是规定好的,后面的值根据实际情况填写
        properties.setProperty("user","flora");//用户
        properties.setProperty("password","4y11rxia");//密码
        Connection connect = driver.connect(url, properties);

        //3.执行sql
        //String sql = "update actor (null,'荣秀恩','女','1990-2-11','119')";
        //String sql = "update actor set name = '池年' where id = 1";
        String sql = "delete from actor where id = 1";
        //statement 用于执行静态SQL语句并返回其生成的结果的对象
        Statement statement = connect.createStatement();
        int rows = statement.executeUpdate(sql);

        System.out.println(rows > 0? "成功":"失败");

        //4.关闭连接资源
        statement.close();
        connect.close();


    }

}
