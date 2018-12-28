package base;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import dao.Dao;
import vo.User;

public abstract class DaoBase implements Dao{

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
    
    
public abstract List<Vobase> getVos() ;
    //增
public abstract boolean add(Vobase vo);

	//删
public boolean remove(int id,String table,String idname) throws Exception {
     
        boolean flag = false;    //判断是否删除成功
        //定义用于删除的sql语句
        String removeSql = " delete from "+table+" where "+idname+" = ? ";
        this.state = this.con.prepareStatement(removeSql);
        this.state.setLong(1, id); 
        if( this.state.executeUpdate() > 0 ) {        //删除成功
            flag = true;
        }
        this.state.close();        //关闭连接
        return flag;
    }

public boolean remove(int id,String table) throws Exception {
 
    return remove(id,table,"id");
}

public abstract boolean remove(int id) ;

	//查
public ResultSet search(int id,String table,String idname) throws Exception {
        User user = null;        //接受查询返回的对象
        ResultSet rs = null;        //接受查询结果
        //id不为空，且不为""
        if( id !=0 ) {    
            //定义用于查询的sql语句
            String selectSql = "select * from "+table+" where "+idname+"=? ";
            this.state = this.con.prepareStatement(selectSql);
            this.state.setLong(1, id);
            rs = this.state.executeQuery();
            //查询成功
        }
        return rs;
    }
	
public ResultSet search(int id,String table) throws Exception {
		return search(id,table,"id");
	}
	
public abstract ResultSet search(int id);

	//改
   public abstract boolean update(Vobase vo) throws Exception ;
    
    
}