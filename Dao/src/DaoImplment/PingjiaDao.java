package DaoImplment;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import base.DaoBase;
import base.Vobase;
import vo.Pingjia;

public class PingjiaDao extends DaoBase {
	
    public PingjiaDao() throws Exception
    {
    	super();
    }
    
    //查出所有信息
    public List<Vobase> getVos() {
        
        //保存所有对象
        List<Vobase> list = new ArrayList<Vobase>();
        //保存返回的的查询结果
        ResultSet rs = null;
        //定义用于查询的sql语句
        String selectSql = " select * from t_pingjia ";
        
        try {
			this.state = this.con.prepareStatement(selectSql);
			rs = this.state.executeQuery();
	        
	        while( rs.next() ) {
	        	Pingjia pingjia = new Pingjia();        //实例化对象
	            
	        	pingjia.setInfos(rs.getString("infos"));
	        	pingjia.setId(rs.getInt("id"));
	        	pingjia.setName(rs.getString("name"));
	            pingjia.setGrade(rs.getInt("grade"));
	            pingjia.setAddtime(rs.getString("addtime"));
	            pingjia.setUid(rs.getInt("uid"));
	            pingjia.setItid(rs.getInt("itid"));
	            pingjia.setType(rs.getString("type"));
	        	
	            list.add(pingjia);            //加入集合
	        }
	        
	        this.state.close();        //关闭连接
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        
        return list;            //返回集合

    }
    
    //增（检查外键）
	public boolean add(Vobase vo) throws Exception{
		System.out.println("add");
		Pingjia pingjia=(Pingjia)vo;
        //外键约束检验
        String temp="select * from t_user where id=? ";
        this.state=this.con.prepareStatement(temp);
        this.state.setInt(1, pingjia.getUid());
        ResultSet rs = state.executeQuery();        //接受查询结果
        if(rs.next())
        	return false;
      //外键约束检验
        temp="select * from t_items where id=? ";
        this.state=this.con.prepareStatement(temp);
        this.state.setInt(1, pingjia.getItid());
        rs = state.executeQuery();        //接受查询结果
        if(rs.next())
        	return false;

        if( pingjia != null ) {
            
            //定义插入的sql语句
            String insertSql = " insert into t_pingjia(name,infos,addtime,uid,itid,type,grade) "
                    + " values(?,?,?,?,?,?,?) ";
            
            //取得操作数据库的对象
            this.state = this.con.prepareStatement(insertSql);
            this.state.setString(1, pingjia.getName());
            this.state.setString(2, pingjia.getInfos());
            this.state.setString(3, pingjia.getAddtime());
            this.state.setInt(4, pingjia.getUid());
            this.state.setInt(5, pingjia.getItid());
            this.state.setString(6, pingjia.getType());
            this.state.setInt(7, pingjia.getGrade());
            
            if( this.state.executeUpdate() > 0 ) {        //成功插入数据
                return true;
            }

            this.state.close();        //关闭数据库操作对象
        }
        return false;        //返回判断标志
	}

	//删
	public boolean remove(int id) throws Exception {
     
        
        return remove(id,"t_pingjia");
    }

	//查
	public Pingjia search(int id) throws Exception {
		Pingjia pingjia = null;        //接受查询返回的对象
        ResultSet rs = null;        //接受查询结果
        
        //id不为空，且不为""
        if( id>0 ) {        
            
            //定义用于查询的sql语句
            String selectSql = "select * from t_pingjia where id=? ";
            
            this.state = this.con.prepareStatement(selectSql);
            this.state.setInt(1, id);
            rs = this.state.executeQuery();
            
            //查询成功
            if( rs.next() ) {
                
                pingjia = new Pingjia();        //实例化对象
            	pingjia.setInfos(rs.getString("infos"));
            	pingjia.setId(rs.getInt("id"));
            	pingjia.setName(rs.getString("name"));
                pingjia.setGrade(rs.getInt("grade"));
                pingjia.setAddtime(rs.getString("addtime"));
                pingjia.setUid(rs.getInt("uid"));
                pingjia.setItid(rs.getInt("itid"));
                pingjia.setType(rs.getString("type"));
            }
            
            this.state.close();        //关闭连接
        }
        
        return pingjia;
    }

	//改(不能改外键)
    public boolean update(Vobase vo) throws Exception {
        boolean flag = false;        //标记是否更新成功
        Pingjia pingjia=(Pingjia)vo;
        if( pingjia != null ) {
            
            //定义更新语句
            String updateSql = " update t_pingjia set name=?,infos=?,addtime=?, type=?,grade=? where id=?";
            
            this.state = this.con.prepareStatement(updateSql);

            this.state.setString(1, pingjia.getName());
            this.state.setString(2, pingjia.getInfos());
            this.state.setString(3, pingjia.getAddtime());
            this.state.setString(4, pingjia.getType());
            this.state.setInt(5, pingjia.getGrade());  
            this.state.setInt(6, pingjia.getId());
            
            if( this.state.executeUpdate() > 0 ) {        //更新成功
                flag = true;
            }
            this.state.close();            //关闭连接
        }
        return flag;
    }


}
