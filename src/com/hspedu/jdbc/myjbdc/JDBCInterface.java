package com.hspedu.jdbc.myjbdc;

public interface JDBCInterface {

    //连接
    public Object getConnection() ;
    //crud
    public void crud();
    //关闭连接
    public void close();

}
