package base;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import dao.Dao;

public class DaoBase implements Dao{

    //定义数据库驱动类
    private static final String DBDRIVER = "com.mysql.jdbc.Driver";
    //定义数据库URL
    private static final String DBURL = "jdbc:mysql://localhost:3306/test";
    //定义数据库连接用户名
    private static final String DBUSER = "root";
    //定义数据库连接指令
    private static final String DBPASS = "123456";
    
  //声明数据库连接对象
    protected Connection con= null;
    protected PreparedStatement state;    //当以数据库操作对象
    
    //声明数据库连接对象
    //Connection con = null;
    
    //定义构造方法，并实例化数据库连接对象
    public DaoBase() throws Exception {
        
        try {
            
            Class.forName(DBDRIVER);
            this.con = DriverManager.getConnection(DBURL,DBUSER,DBPASS);
        }catch(Exception e) {
            
            throw e;
        }
    }
      
    //取得数据库连接对象
    public Connection getConnection() throws Exception {
        
        return this.con;
    }
    
    //关闭数据库连接
    public void close() throws Exception{
        
        if( this.con != null ) {
            
            try {
                
                con.close();
            }catch(Exception e) {
                
                throw e;
            }
        }
    }
    
}