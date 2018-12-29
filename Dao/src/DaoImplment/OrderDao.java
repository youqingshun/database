package DaoImplment;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import base.DaoBase;
import base.Vobase;
import vo.Order;

public class OrderDao extends DaoBase {
	public OrderDao() throws Exception {
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
        String selectSql = " select * from t_order ";
        
        this.state = this.con.prepareStatement(selectSql);
        rs = this.state.executeQuery();
        
        while( rs.next() ) {
        	Order newvo = new Order();        //实例化对象
        	newvo.setId(rs.getInt("id"));
        	newvo.setInfos(rs.getString("infos"));
        	newvo.setAddress(rs.getString("address"));
        	newvo.setCity(rs.getString("city"));
        	newvo.setItid(rs.getInt("itid"));
        	newvo.setPaytype(rs.getString("paytype"));
        	newvo.setPostno(rs.getString("postno"));
        	newvo.setPrice(rs.getDouble("price"));
        	newvo.setProvince(rs.getString("province"));
        	newvo.setState(rs.getString("state"));
        	newvo.setTel(rs.getString("tel"));
        	newvo.setUid(rs.getInt("uid"));
        	newvo.setUrls(rs.getString("urls"));
        	newvo.setUsername(rs.getString("username"));
        	
            list.add(newvo);            //加入集合
        }
        
        this.state.close();        //关闭连接
        
        return list;            //返回集合
	}
	
	public List<Order> getOrder() throws SQLException
    {
    	List list=getVos();
    	List list2=(List<Order>)list;
    	return list2;
    }

	@Override
	public boolean add(Vobase vo) throws Exception {
		System.out.println("add");
		Order newvo=(Order)vo;
        //如果数据库中不存在相同id的员工，则可插入数据
        String temp="select * from t_order where id=? ";
        this.state=this.con.prepareStatement(temp);
        this.state.setLong(1, newvo.getId());/*
        this.state.setString(2, user.getTel());
        this.state.setString(3, user.getName());*/
        ResultSet rs = state.executeQuery();        //接受查询结果
        if(rs.next())
        	return false;
        
        
        if( newvo != null ) {
            
            //定义插入的sql语句
            String insertSql = " insert into t_order(id,uid,username,"
            		+ "itid,price,address,state,postno,tel,paytype,infos,"
            		+ "urls,province,city)"
                    + " values(?,?,?,?,?,?,?,?,?,?,?,?,?,?) ";
            
            //取得操作数据库的对象
            this.state = this.con.prepareStatement(insertSql);
            this.state.setInt(1, newvo.getId());
           
            this.state.setInt(2, newvo.getUid());
            this.state.setString(3, newvo.getUsername());
            this.state.setInt(4, newvo.getItid());
            this.state.setDouble(5, newvo.getPrice());
            this.state.setString(6, newvo.getAddress());
            this.state.setString(7, newvo.getState());
            this.state.setString(8, newvo.getPostno());
            this.state.setString(9, newvo.getTel());
            this.state.setString(10, newvo.getPaytype());
            this.state.setString(11, newvo.getInfos());
            this.state.setString(12, newvo.getUrls());
            this.state.setString(13, newvo.getProvince());
            this.state.setString(14, newvo.getCity());
            
            
            if( this.state.executeUpdate() > 0 ) {        //成功插入数据
                return true;
            }

            this.state.close();        //关闭数据库操作对象
        }
        
        return false;        //返回判断标志
	}

	@Override
	public boolean remove(int id) throws Exception {
		return remove(id,"t_order");
	}
	
	public Order search(int id) throws Exception {
		Order newvo = null;        //接受查询返回的对象
        ResultSet rs = null;        //接受查询结果
        
        //id不为空，且不为""
        if( id!=0 ) {        
            
            //定义用于查询的sql语句
            rs=search(id,"t_order");
            
            //查询成功
            if( rs.next() ) {
                
            	newvo = new Order();        //实例化Worker类对象
            	newvo.setId(rs.getInt("id"));
            	newvo.setInfos(rs.getString("infos"));
            	newvo.setAddress(rs.getString("address"));
            	newvo.setCity(rs.getString("city"));
            	newvo.setItid(rs.getInt("itid"));
            	newvo.setPaytype(rs.getString("paytype"));
            	newvo.setPostno(rs.getString("postno"));
            	newvo.setPrice(rs.getDouble("price"));
            	newvo.setProvince(rs.getString("province"));
            	newvo.setState(rs.getString("state"));
            	newvo.setTel(rs.getString("tel"));
            	newvo.setUid(rs.getInt("uid"));
            	newvo.setUrls(rs.getString("urls"));
            	newvo.setUsername(rs.getString("username"));
            
            this.state.close();        //关闭连接
            }
        }
        return newvo;
    }

	@Override
	public boolean update(Vobase vo) throws Exception {
		boolean flag = false;        //标记是否更新成功
        Order newvo=(Order)vo;
        if( newvo != null ) {
            
            //定义更新语句
            String updateSql = " update t_order set id=?,uid=?,username=?,itid=?,"
            		+ "price=?,address=?,state=?,postno=?,tel=?,paytype=?,infos=?,"
            		+ "urls=?,province=?,city=?"
            		+ " where id=?";
            
            this.state = this.con.prepareStatement(updateSql);

            this.state.setInt(1, newvo.getId());
            this.state.setInt(2, newvo.getUid());
            this.state.setString(3, newvo.getUsername());
            this.state.setInt(4, newvo.getItid());
            this.state.setDouble(5, newvo.getPrice());
            this.state.setString(6, newvo.getAddress());
            this.state.setString(7,newvo.getState());
            this.state.setString(8,newvo.getPostno());
            this.state.setString(9,newvo.getTel());
            this.state.setString(10, newvo.getPaytype());
            this.state.setString(11, newvo.getInfos());
            this.state.setString(12, newvo.getUrls());
            this.state.setString(13, newvo.getProvince());
            this.state.setString(14, newvo.getCity());
            this.state.setInt(15, newvo.getId());
            
            if( this.state.executeUpdate() > 0 ) {        //更新成功
                flag = true;
            }
            this.state.close();            //关闭连接
        }
        return flag;
	}
}
