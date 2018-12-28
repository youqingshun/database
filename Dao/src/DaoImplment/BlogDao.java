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
import vo.Blog;
import vo.User;

public class BlogDao extends DaoBase {
	
    public BlogDao() throws Exception
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
        String selectSql = " select * from t_blog ";
        
        this.state = this.con.prepareStatement(selectSql);
        rs = this.state.executeQuery();
        
        while( rs.next() ) {
        	Blog blog = new Blog();        //实例化对象
            blog.setId(rs.getInt("id"));
        	blog.setInfos(rs.getString("infos"));
            blog.setItid(rs.getInt("itid"));
            blog.setPicurls(rs.getString("picurls"));
            blog.setTime(rs.getString("time"));
            blog.setTitle(rs.getString("title"));
            blog.setType(rs.getString("type"));
            blog.setZhaiyao(rs.getString("zhaiyao"));
            
            list.add(blog);            //加入集合
        }
        
        this.state.close();        //关闭连接
        
        return list;            //返回集合

    }
    
    public List<Blog> getBlog() throws SQLException
    {
    	List list=getVos();
    	List list2=(List<Blog>)list;
    	return list2;
    }
    //增
	public boolean add(Vobase vo) throws Exception{
		System.out.println("add");
		Blog blog=(Blog)vo;
        //如果数据库中不存在相同id的员工，则可插入数据
        String temp="select * from t_blog where id=? ";
        this.state=this.con.prepareStatement(temp);
        this.state.setLong(1, blog.getId());/*
        this.state.setString(2, user.getTel());
        this.state.setString(3, user.getName());*/
        ResultSet rs = state.executeQuery();        //接受查询结果
        if(rs.next())
        	return false;
        
        
        if( blog != null ) {
            
            //定义插入的sql语句
            String insertSql = " insert into t_blog(id,title,infos,time,itid,type,zhaiyao,picurls) "
                    + " values(?,?,?,?,?,?,?,?) ";
            
            //取得操作数据库的对象
            this.state = this.con.prepareStatement(insertSql);
            this.state.setInt(1, blog.getId());
            this.state.setString(2, blog.getTitle());
            this.state.setString(3, blog.getInfos());
            this.state.setString(4, blog.getTime());
            this.state.setInt(5, blog.getItid());
            this.state.setString(6, blog.getType());
            this.state.setString(7, blog.getZhaiyao());
            this.state.setString(8, blog.getPicurls());
            
            
            if( this.state.executeUpdate() > 0 ) {        //成功插入数据
                return true;
            }

            this.state.close();        //关闭数据库操作对象
        }
        
        return false;        //返回判断标志
	}


	
	
	//删
	public boolean remove(int id) throws Exception {
     
        return remove(id,"t_blog");
    }

	//查
	public Blog search(int id) throws Exception {
		Blog blog = null;        //接受查询返回的对象
        ResultSet rs = null;        //接受查询结果
        
        //id不为空，且不为""
        if( id!=0 ) {        
            
            //定义用于查询的sql语句
            rs=search(id,"t_blog");
            
            //查询成功
            if( rs.next() ) {
                
            	blog = new Blog();        //实例化Worker类对象
                blog.setId(rs.getInt("id"));
                blog.setInfos(rs.getString("infos"));
                blog.setItid(rs.getInt("itid"));
                blog.setPicurls(rs.getString("picurls"));
                blog.setTime(rs.getString("time"));
                blog.setTitle(rs.getString("title"));
                blog.setType(rs.getString("type"));
                blog.setZhaiyao(rs.getString("zhaiyao"));
            }
            
            this.state.close();        //关闭连接
        }
        
        return blog;
    }

	//改
    public boolean update(Vobase vo) throws Exception {
        boolean flag = false;        //标记是否更新成功
        Blog blog=(Blog)vo;
        if( blog != null ) {
            
            //定义更新语句
            String updateSql = " update t_blog set id=?,title=?,infos=?,time=?,itid=?,type=?,zhaiyao=?,picurls=? where id=?";
            
            //转换日期类型：util.Date -> sql.Date
            /*Date date = user.getBirth();
            java.sql.Date d = new java.sql.Date(date.getTime());*/

            this.state = this.con.prepareStatement(updateSql);

            this.state.setInt(1, blog.getId());
            this.state.setString(2, blog.getTitle());
            this.state.setString(3, blog.getInfos());
            this.state.setString(4, blog.getTime());
            this.state.setInt(5, blog.getItid());
            this.state.setString(6, blog.getType());
            this.state.setString(7, blog.getZhaiyao());
            this.state.setString(8, blog.getPicurls());
            this.state.setInt(9, blog.getId());    
            
            if( this.state.executeUpdate() > 0 ) {        //更新成功
                flag = true;
            }
            this.state.close();            //关闭连接
        }
        return flag;
    }





	

	
}
