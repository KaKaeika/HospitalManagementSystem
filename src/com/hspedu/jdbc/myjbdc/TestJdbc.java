package com.hspedu.jdbc.myjbdc;

public class TestJdbc {
    public static void main(String[] args){
        //完成对mysql的操作
        JDBCInterface jdbcInterface = new MysqlJdbcImplement();
        jdbcInterface.getConnection();
        jdbcInterface.crud();
        jdbcInterface.close();

        System.out.println("======================");
        jdbcInterface = new OracleJdbcImplement();
        jdbcInterface.getConnection();
        jdbcInterface.crud();
        jdbcInterface.close();


    }



}
