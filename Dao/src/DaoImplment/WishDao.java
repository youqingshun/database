package DaoImplment;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import base.DaoBase;
import base.Vobase;
import vo.Wish;

public class WishDao extends DaoBase {

	public WishDao() throws Exception {
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
        String selectSql = " select * from t_wish ";
        
        this.state = this.con.prepareStatement(selectSql);
        rs = this.state.executeQuery();
        
        while( rs.next() ) {
        	Wish newvo = new Wish();        //实例化对象
        	newvo.setId(rs.getInt("id"));
        	newvo.setItid(rs.getInt("itid"));
        	newvo.setPrice(rs.getDouble("price"));
        	newvo.setUid(rs.getInt("uid"));
        	newvo.setUrls(rs.getString("urls"));
        	newvo.setName(rs.getString("name"));
        	
            list.add(newvo);            //加入集合
        }
        
        this.state.close();        //关闭连接
        
        return list;            //返回集合
	}
	
	public List<Wish> getWish() throws SQLException
    {
    	List list=getVos();
    	List list2=(List<Wish>)list;
    	return list2;
    }

	@Override
	public boolean add(Vobase vo) throws Exception {
		System.out.println("add");
		Wish newvo=(Wish)vo;
        //如果数据库中不存在相同id的员工，则可插入数据
        String temp="select * from t_wish where id=? ";
        this.state=this.con.prepareStatement(temp);
        this.state.setLong(1, newvo.getId());/*
        this.state.setString(2, user.getTel());
        this.state.setString(3, user.getName());*/
        ResultSet rs = state.executeQuery();        //接受查询结果
        if(rs.next())
        	return false;
        
        
        if( newvo != null ) {
            
            //定义插入的sql语句
            String insertSql = " insert into t_wish(id,urls,name,"
            		+ "price,uid,itid)"
                    + " values(?,?,?,?,?,?) ";
            
            //取得操作数据库的对象
            this.state = this.con.prepareStatement(insertSql);
            this.state.setInt(1, newvo.getId());
            this.state.setString(2, newvo.getUrls());
           
            this.state.setString(3, newvo.getName());
            this.state.setDouble(4, newvo.getPrice());
            this.state.setInt(5, newvo.getUid());

            this.state.setInt(6, newvo.getItid());
            
            
            
            if( this.state.executeUpdate() > 0 ) {        //成功插入数据
                return true;
            }

            this.state.close();        //关闭数据库操作对象
        }
        
        return false;        //返回判断标志
	}

	@Override
	public boolean remove(int id) throws Exception {
		return remove(id,"t_wish");
	}
	
	public Wish search(int id) throws Exception {
		Wish newvo = null;        //接受查询返回的对象
        ResultSet rs = null;        //接受查询结果
        
        //id不为空，且不为""
        if( id!=0 ) {        
            
            //定义用于查询的sql语句
            rs=search(id,"t_wish");
            
            //查询成功
            if( rs.next() ) {
                
            	newvo = new Wish();        //实例化Worker类对象
            	newvo.setId(rs.getInt("id"));
            	newvo.setItid(rs.getInt("itid"));
            	newvo.setPrice(rs.getDouble("price"));
            	newvo.setUid(rs.getInt("uid"));
            	newvo.setUrls(rs.getString("urls"));
            	newvo.setName(rs.getString("name"));
            
            this.state.close();        //关闭连接
            }
        }
        return newvo;
    }

	@Override
	public boolean update(Vobase vo) throws Exception {
		boolean flag = false;        //标记是否更新成功
        Wish newvo=(Wish)vo;
        if( newvo != null ) {
            
            //定义更新语句
            String updateSql = " update t_wish set id=?,urls=?,name=?,"
            		+ "price=?,uid=?,itid=?"
            		+ " where id=?";
            
            this.state = this.con.prepareStatement(updateSql);

            this.state.setInt(1, newvo.getId());
            this.state.setString(2, newvo.getUrls());
           
            this.state.setString(3, newvo.getName());
            this.state.setDouble(4, newvo.getPrice());
            this.state.setInt(5, newvo.getUid());

            this.state.setInt(6, newvo.getItid());
            this.state.setInt(7, newvo.getId());
            
            if( this.state.executeUpdate() > 0 ) {        //更新成功
                flag = true;
            }
            this.state.close();            //关闭连接
        }
        return flag;
	}
}
