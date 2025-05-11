package com.hspedu.jdbc.myjbdc;

public class OracleJdbcImplement implements JDBCInterface{

    @Override
    //连接
    public Object getConnection() {
        System.out.println("得到Oracle的连接");
        return null;
    }


    //crud
    @Override
    public void crud(){
        System.out.println("进行了Oracle的增删改查");

    }
    //关闭连接
    @Override
    public void close(){
        System.out.println("关闭Oracle的连接");
    }

}
