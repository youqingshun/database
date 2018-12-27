/*
 * Description:定义DAO接口，在该接口中只是定义对员工的操作，
 *                 具体操作需要实现该接口的类完成
 * 
 * */

package dao;

import java.sql.Connection;


public interface Dao {

	public Connection getConnection() throws Exception;
	
	public void close() throws Exception;
/*    //向表中添加信息
    public boolean add(Object obj) throws Exception;
    
    //根据号删除表中对应的
    public boolean remove(int id) throws Exception;
    
    //按照号查找
    public User search(int id) throws Exception;
    
    //查找全部
    public List<Object> getWorkers() throws Exception;
    
    //更新信息
    public boolean update(Object obj) throws Exception;*/
    
}