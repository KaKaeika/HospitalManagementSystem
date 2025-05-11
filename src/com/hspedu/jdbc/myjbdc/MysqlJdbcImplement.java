package com.hspedu.jdbc.myjbdc;

public class MysqlJdbcImplement implements JDBCInterface{

    @Override
    //连接
    public Object getConnection() {
        System.out.println("得到mysql的连接");
        return null;
    }


    //crud
    @Override
    public void crud(){
        System.out.println("进行了mysql的增删改查");

    }
    //关闭连接
    @Override
    public void close(){
        System.out.println("关闭mysql的连接");
    }

}

