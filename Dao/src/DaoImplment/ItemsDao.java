package DaoImplment;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import base.DaoBase;
import base.Vobase;
import vo.Blog;
import vo.Items;

public class ItemsDao extends DaoBase {

	public ItemsDao() throws Exception  {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<Vobase> getVos() throws SQLException {
		//保存所有对象
        List<Vobase> list = new ArrayList<Vobase>();
        //保存返回的的查询结果
        ResultSet rs = null;
        //定义用于查询的sql语句
        String selectSql = " select * from t_items ";
        
        this.state = this.con.prepareStatement(selectSql);
        rs = this.state.executeQuery();
        
        while( rs.next() ) {
        	Items item = new Items();        //实例化对象
        	item.setId(rs.getInt("id"));
        	item.setBrand(rs.getString("brand"));
            item.setInfos(rs.getString("infos"));
            item.setName(rs.getString("name"));
            item.setNo(rs.getString("no"));
            item.setPrice(rs.getDouble("price"));
            item.setType(rs.getString("type"));
            item.setUrls(rs.getString("urls"));
        	item.setSells(rs.getInt("sells"));
        	item.setCategory(rs.getString("category"));
            
            list.add(item);            //加入集合
        }
        
        this.state.close();        //关闭连接
        
        return list;            //返回集合
	}
	
	public List<Items> getItems() throws SQLException
    {
    	List list=getVos();
    	List list2=(List<Items>)list;
    	return list2;
    }
	
	@Override
	public boolean add(Vobase vo) throws Exception {
		System.out.println("add");
		Items item=(Items)vo;
        //如果数据库中不存在相同id的员工，则可插入数据
        String temp="select * from t_items where id=? ";
        this.state=this.con.prepareStatement(temp);
        this.state.setInt(1, item.getId());/*
        this.state.setString(2, user.getTel());
        this.state.setString(3, user.getName());*/
        ResultSet rs = state.executeQuery();        //接受查询结果
        if(rs.next())
        	return false;
        
        
        if( item != null ) {
            
            //定义插入的sql语句
            String insertSql = " insert into t_items(name,urls,type,price,infos,brand,no,id,sells,category) "
                    + " values(?,?,?,?,?,?,?,?,?,?) ";
            
            //取得操作数据库的对象
            this.state = this.con.prepareStatement(insertSql);
//            this.state.setInt(1, item.getId());
            this.state.setString(1, item.getName());
            this.state.setString(2, item.getUrls());
            this.state.setString(3, item.getType());
            this.state.setDouble(4, item.getPrice());
            this.state.setString(5, item.getInfos());
            this.state.setString(6, item.getBrand());
            this.state.setString(7, item.getNo());
            this.state.setInt(8, item.getId());
            this.state.setInt(9, item.getSells());
            this.state.setString(10, item.getCategory());
            
            if( this.state.executeUpdate() > 0 ) {        //成功插入数据
                return true;
            }

            this.state.close();        //关闭数据库操作对象
        }
        
        return false;        //返回判断标志
	}

	@Override
	public boolean remove(int id) throws Exception {
		// TODO Auto-generated method stub
		return remove(id,"t_items");
	}

	//查
	public Items search(int id) throws Exception {
		Items blog = null;        //接受查询返回的对象
        ResultSet rs = null;        //接受查询结果
        
        //id不为空，且不为""
        if( id!=0 ) {        
            
            //定义用于查询的sql语句
            rs=search(id,"t_items");
            
            //查询成功
            if( rs.next() ) {
                
            	blog = new Items();        //实例化Worker类对象
                blog.setId(rs.getInt("id"));
                blog.setInfos(rs.getString("infos"));
                blog.setName(rs.getString("name"));
                blog.setType(rs.getString("type"));
                blog.setBrand(rs.getString("brand"));
                blog.setNo(rs.getString("no"));
                blog.setPrice(rs.getDouble("price"));
                blog.setUrls(rs.getString("urls"));
                blog.setSells(rs.getInt("sells"));
                blog.setCategory(rs.getString("category"));
                
            }
            
            this.state.close();        //关闭连接
        }
        
        return blog;
    }
	
	@Override
	public boolean update(Vobase vo) throws Exception {
		boolean flag = false;        //标记是否更新成功
        Items item=(Items)vo;
        if( item != null ) {
            
            //定义更新语句
            String updateSql = " update t_items set id=?,name=?,urls=?,type=?,price=?,infos=?,brand=?,no=?,sells=?,category=? where id=?";
            
            //转换日期类型：util.Date -> sql.Date
            /*Date date = user.getBirth();
            java.sql.Date d = new java.sql.Date(date.getTime());*/

            this.state = this.con.prepareStatement(updateSql);

            this.state.setInt(1, item.getId());
            this.state.setString(2, item.getName());
            this.state.setString(3, item.getUrls());
            this.state.setString(4, item.getType());
            this.state.setDouble(5, item.getPrice());
            this.state.setString(6, item.getInfos());
            this.state.setString(7, item.getBrand());
            this.state.setString(8, item.getNo());
            
            this.state.setInt(9, item.getSells());
            this.state.setString(10, item.getCategory());
            
            this.state.setInt(11, item.getId());    
            
            
            if( this.state.executeUpdate() > 0 ) {        //更新成功
                flag = true;
            }
            this.state.close();            //关闭连接
        }
        return flag;
	}

}
