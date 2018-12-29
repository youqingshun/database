package DaoImplment;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import base.DaoBase;
import base.Vobase;
import vo.Blog;
import vo.Message;

public class MessageDao extends DaoBase {

	public MessageDao() throws Exception {
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
        String selectSql = " select * from t_message ";
        
        this.state = this.con.prepareStatement(selectSql);
        rs = this.state.executeQuery();
        
        while( rs.next() ) {
        	Message newvo = new Message();        //实例化对象
        	newvo.setId(rs.getInt("id"));
        	newvo.setInfos(rs.getString("infos"));
        	newvo.setReply(rs.getString("reply"));
        	newvo.setState(rs.getString("state"));
        	newvo.setUid(rs.getInt("uid"));
        	
            list.add(newvo);            //加入集合
        }
        
        this.state.close();        //关闭连接
        
        return list;            //返回集合
	}
	
	public List<Message> getMessage() throws SQLException
    {
    	List list=getVos();
    	List list2=(List<Message>)list;
    	return list2;
    }

	@Override
	public boolean add(Vobase vo) throws Exception {
		System.out.println("add");
		Message newvo=(Message)vo;
        //如果数据库中不存在相同id的员工，则可插入数据
        String temp="select * from t_message where id=? ";
        this.state=this.con.prepareStatement(temp);
        this.state.setLong(1, newvo.getId());/*
        this.state.setString(2, user.getTel());
        this.state.setString(3, user.getName());*/
        ResultSet rs = state.executeQuery();        //接受查询结果
        if(rs.next())
        	return false;
        
        
        if( newvo != null ) {
            
            //定义插入的sql语句
            String insertSql = " insert into t_message(id,infos,state,reply,uid) "
                    + " values(?,?,?,?,?) ";
            
            //取得操作数据库的对象
            this.state = this.con.prepareStatement(insertSql);
            this.state.setInt(1, newvo.getId());
            this.state.setString(2, newvo.getInfos());
            this.state.setString(3, newvo.getState());
            this.state.setString(4, newvo.getState());
            this.state.setInt(5, newvo.getUid());
            
            
            if( this.state.executeUpdate() > 0 ) {        //成功插入数据
                return true;
            }

            this.state.close();        //关闭数据库操作对象
        }
        
        return false;        //返回判断标志
	}

	@Override
	public boolean remove(int id) throws Exception {
		return remove(id,"t_message");
	}
	
	public Message search(int id) throws Exception {
		Message newvo = null;        //接受查询返回的对象
        ResultSet rs = null;        //接受查询结果
        
        //id不为空，且不为""
        if( id!=0 ) {        
            
            //定义用于查询的sql语句
            rs=search(id,"t_message");
            
            //查询成功
            if( rs.next() ) {
                
            	newvo = new Message();        //实例化Worker类对象
            	newvo.setId(rs.getInt("id"));
            	newvo.setInfos(rs.getString("infos"));
            	newvo.setReply(rs.getString("reply"));
            	newvo.setState(rs.getString("state"));
            	newvo.setUid(rs.getInt("uid"));
            
            this.state.close();        //关闭连接
            }
        }
        return newvo;
    }

	@Override
	public boolean update(Vobase vo) throws Exception {
		boolean flag = false;        //标记是否更新成功
        Message newvo=(Message)vo;
        if( newvo != null ) {
            
            //定义更新语句
            String updateSql = " update t_message set id=?,infos=?,state=?,reply=?,uid=? where id=?";
            
            //转换日期类型：util.Date -> sql.Date
            /*Date date = user.getBirth();
            java.sql.Date d = new java.sql.Date(date.getTime());*/

            this.state = this.con.prepareStatement(updateSql);

            this.state.setInt(1, newvo.getId());
            this.state.setString(2, newvo.getInfos());
            this.state.setString(3, newvo.getState());
            this.state.setString(4, newvo.getReply());
            this.state.setInt(5, newvo.getUid());
            this.state.setInt(6, newvo.getId());
            
            if( this.state.executeUpdate() > 0 ) {        //更新成功
                flag = true;
            }
            this.state.close();            //关闭连接
        }
        return flag;
	}

}
