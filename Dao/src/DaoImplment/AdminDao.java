package DaoImplment;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import base.DaoBase;
import base.Vobase;
import vo.Admin;

public class AdminDao extends DaoBase{
//	private static DaoBase daobase;
	
	
    public AdminDao() throws Exception
    {
    	super();
    }
    
    //查出所有用户
    public List<Vobase> getVos() throws SQLException {
        
        //保存所有对象
        List<Vobase> list = new ArrayList<Vobase>();
        //保存返回的的查询结果
        ResultSet rs = null;
        //定义用于查询的sql语句
        String selectSql = " select * from t_admin ";
        
       
			this.state = this.con.prepareStatement(selectSql);
			 rs = this.state.executeQuery();
		        
		        while( rs.next() ) {
		        	Admin admin = new Admin();        //实例化对象
		            
		            admin.setName(rs.getString("name"));
		            admin.setPwd(rs.getString("pwd"));
		            admin.setNo(rs.getString("no"));
		            admin.setEmail(rs.getString("email"));
		            admin.setTel(rs.getString("tel"));
		            
		            list.add(admin);            //加入集合
		        }
		        
		        this.state.close();        //关闭连接
		
       
        
        return list;            //返回集合

    }
    
    //增
	public boolean add(Vobase vo) throws SQLException {
		System.out.println("add");
		Admin admin=(Admin)vo;
        //如果数据库中不存在相同id的员工，则可插入数据
        String temp="select * from t_admin where no=? ";
       
			this.state=this.con.prepareStatement(temp);
			this.state.setString(1, admin.getNo());
	        ResultSet rs = state.executeQuery();        //接受查询结果
	        if(rs.next())
	        	return false;
	        
	        
	        if( admin != null ) {
	            
	            //定义插入的sql语句
	            String insertSql = " insert into t_admin(no,pwd,name,email,tel) "
	                    + " values(?,?,?,?,?) ";
	            
	            //取得操作数据库的对象
	            this.state = this.con.prepareStatement(insertSql);
	            this.state.setString(1, admin.getNo());
	            this.state.setString(2, admin.getPwd());
	            this.state.setString(3, admin.getName());
	            this.state.setString(4, admin.getEmail());
	            this.state.setString(5, admin.getTel());
	            
	            if( this.state.executeUpdate() > 0 ) {        //成功插入数据
	                return true;
	            }

	            this.state.close();        //关闭数据库操作对象
	        }
		
        
        
        return false;        //返回判断标志
	}

	//删
	public boolean remove(String no) throws Exception {
     
        boolean flag = false;    //判断是否删除成功
        //定义用于删除的sql语句
        String removeSql = " delete from t_admin where no = ? ";
        this.state = this.con.prepareStatement(removeSql);
        this.state.setString(1, no); 
        if( this.state.executeUpdate() > 0 ) {        //删除成功
            flag = true;
        }
        this.state.close();        //关闭连接
        return flag;
    }

	//查
	public Admin search(String no) throws Exception {
		Admin admin = null;        //接受查询返回的对象
        ResultSet rs = null;        //接受查询结果
        
        //id不为空，且不为""
        if( no != null || "".equals(no) ) {        
            
            //定义用于查询的sql语句
            String selectSql = "select * from t_admin where no=? ";
            
            this.state = this.con.prepareStatement(selectSql);
            this.state.setString(1, no);
            rs = this.state.executeQuery();
            
            //查询成功
            if( rs.next() ) {
                
                admin = new Admin();        //实例化对象
                admin.setName(rs.getString("name"));
                admin.setPwd(rs.getString("pwd"));
                admin.setEmail(rs.getString("email"));
                admin.setTel(rs.getString("tel"));
                admin.setId(rs.getInt("id"));
            }
            
            this.state.close();        //关闭连接
        }
        
        return admin;
    }

	//改
    public boolean update(Vobase vo) throws SQLException {
        boolean flag = false;        //标记是否更新成功
        Admin admin=(Admin)vo;
        if( admin != null ) {
            
            //定义更新语句
            String updateSql = " update t_admin set pwd=?,name=?,email=?,tel=? where no=?";
            
            
				this.state = this.con.prepareStatement(updateSql);
				this.state.setString(1, admin.getPwd());
	            this.state.setString(2, admin.getName());
	            this.state.setString(3, admin.getEmail());
	            this.state.setString(4, admin.getTel());
	            this.state.setString(5, admin.getNo());    
	            
	            if( this.state.executeUpdate() > 0 ) {        //更新成功
	                flag = true;
	            }
	            this.state.close();            //关闭连接
			

            
        }
        return flag;
    }

	@Override
	public boolean remove(int id) throws Exception {
		// TODO Auto-generated method stub
		
		
			return remove(id,"t_admin");
		
		
	}

//	@Override
//	public ResultSet search(int id) throws Exception {
//		
//			return search(id,"t_admin");
//		
//		
//	}
	
}
