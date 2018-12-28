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
import vo.User;

public class UserDao extends DaoBase {
	
    public UserDao() throws Exception
    {
    	super();
    }
    
    //查出所有用户
    public List<Vobase> getVos()   {
        
        //保存所有对象
        List<Vobase> list = new ArrayList<Vobase>();
        //保存返回的的查询结果
        ResultSet rs = null;
        //定义用于查询的sql语句
        String selectSql = " select * from t_user ";
        
        try {
			this.state = this.con.prepareStatement(selectSql);
			rs = this.state.executeQuery();
	        
	        while( rs.next() ) {
	        	User user = new User();        //实例化对象
	            
	            user.setName(rs.getString("name"));
	            user.setPwd(rs.getString("pwd"));
	            user.setNo(rs.getString("no"));
	            user.setEmail(rs.getString("email"));
	            user.setTel(rs.getString("tel"));
	            user.setAge(rs.getInt("age"));
	            user.setAddress(rs.getString("address"));
	            user.setBirth(rs.getString("birth"));
	            user.setRole(rs.getString("role"));
	            
	            list.add(user);            //加入集合
	        }
	        
	        this.state.close();        //关闭连接
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        
        return list;            //返回集合

    }
    
    //增
	public boolean add(Vobase vo) {
		System.out.println("add");
		User user=(User)vo;
        //如果数据库中不存在相同id的员工，则可插入数据
        String temp="select * from t_user where no=? ";
        try {
			this.state=this.con.prepareStatement(temp);
			this.state.setString(1, user.getNo());/*
	        this.state.setString(2, user.getTel());
	        this.state.setString(3, user.getName());*/
	        ResultSet rs = state.executeQuery();        //接受查询结果
	        if(rs.next())
	        	return false;
	        
	        
	        if( user != null ) {
	            
	            //定义插入的sql语句
	            String insertSql = " insert into t_user(no,pwd,name,email,tel,age,birth,role,address) "
	                    + " values(?,?,?,?,?,?,?,?,?) ";
	            
	            //取得操作数据库的对象
	            this.state = this.con.prepareStatement(insertSql);
	            this.state.setString(1, user.getNo());
	            this.state.setString(2, user.getPwd());
	            this.state.setString(3, user.getName());
	            this.state.setString(4, user.getEmail());
	            this.state.setString(5, user.getTel());
	            this.state.setInt(6, user.getAge());
	            this.state.setString(7, user.getBirth());
	            this.state.setString(8, user.getRole());
	            this.state.setString(9, user.getAddress());
	            
	            
	            if( this.state.executeUpdate() > 0 ) {        //成功插入数据
	                return true;
	            }

	            this.state.close();        //关闭数据库操作对象
	        }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        
        return false;        //返回判断标志
	}

	//删
	public boolean remove(String no)  {
     
        boolean flag = false;    //判断是否删除成功
        //定义用于删除的sql语句
        String removeSql = " delete from t_user where no = ? ";
        try {
			this.state = this.con.prepareStatement(removeSql);
			this.state.setString(1, no); 
	        if( this.state.executeUpdate() > 0 ) {        //删除成功
	            flag = true;
	        }
	        this.state.close();        //关闭连接
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        return flag;
    }

	//查
	public User search(String no)  {
        User user = null;        //接受查询返回的对象
        ResultSet rs = null;        //接受查询结果
        
        //id不为空，且不为""
        if( no != null || "".equals(no) ) {        
            
            //定义用于查询的sql语句
            String selectSql = "select * from t_user where no=? ";
            
            try {
				this.state = this.con.prepareStatement(selectSql);
				 this.state.setString(1, no);
		            rs = this.state.executeQuery();
		            
		            //查询成功
		            if( rs.next() ) {
		                
		                user = new User();        //实例化Worker类对象
		                user.setName(rs.getString("name"));
		                user.setPwd(rs.getString("pwd"));
		                user.setNo(rs.getString("no"));
		                user.setEmail(rs.getString("email"));
		                user.setTel(rs.getString("tel"));
		                user.setAge(rs.getInt("age"));
		                user.setAddress(rs.getString("address"));
		                user.setBirth(rs.getString("birth"));
		                user.setRole(rs.getString("role"));
		                
		            }
		            
		            this.state.close();        //关闭连接
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
           
        }
        
        return user;
    }

	//改
    public boolean update(Vobase vo)  {
        boolean flag = false;        //标记是否更新成功
        User user=(User)vo;
        
        if( user != null ) {
            
            //定义更新语句
            String updateSql = " update t_user set pwd=?,name=?,email=?,tel=?,age=?,birth=?,role=?,address=? where no=?";
            
            //转换日期类型：util.Date -> sql.Date
            /*Date date = user.getBirth();
            java.sql.Date d = new java.sql.Date(date.getTime());*/

            try {
				this.state = this.con.prepareStatement(updateSql);
				this.state.setString(1, user.getPwd());
	            this.state.setString(2, user.getName());
	            this.state.setString(3, user.getEmail());
	            this.state.setString(4, user.getTel());
	            this.state.setInt(5, user.getAge());
	            this.state.setString(6, user.getBirth());
	            this.state.setString(7, user.getRole());
	            this.state.setString(8, user.getAddress());
	            this.state.setString(9, user.getNo());    
	            
	            if( this.state.executeUpdate() > 0 ) {        //更新成功
	                flag = true;
	            }
	            this.state.close();            //关闭连接
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

            
        }
        return flag;
    }

	@Override
	public boolean remove(int id) {
		try {
			return remove(id,"t_user");
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public ResultSet search(int id) {
		// TODO Auto-generated method stub
		try {
			return search(id,"t_user");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
}
