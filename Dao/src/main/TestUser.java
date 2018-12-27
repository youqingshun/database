package main;

import java.util.List;
import DaoImplment.UserDao;
import vo.User;

public class TestUser {

    public static void main(String args[]) throws Exception {
        
        List<User> list = null;
        UserDao userdao=new UserDao();      //遍历
        System.out.println("1111111111111");
        list=userdao.getUsers();   
        for(int i=0;i<list.size();i++)
        	System.out.println(list.get(i).getName());
        
        ///////////////////////////////////增 
        System.out.println("2222222222");
        User user=new User();
        user.setAddress("test");
        user.setRole("user1");
        user.setAge(25);
        user.setBirth("2018-12-15");
        user.setEmail("test");
        user.setPwd("123");
        user.setNo("user4");
        user.setTel("131590");
        user.setName("黎明");
        
        boolean flag= userdao.add(user);         
        System.out.println("插入是否成功:"+flag);
       
        list=userdao.getUsers();   
       for(int i=0;i<list.size();i++)
        	System.out.println(list.get(i).getName());
        
        /////////////////////////////////// //改
        System.out.println("33333333333333");       
        user.setName("寥寥"); 
        userdao.update(user);   
        list=userdao.getUsers();   
        for(int i=0;i<list.size();i++)
        	System.out.println(list.get(i).getName());
        
        /////////////////////////////////// //查
        System.out.println("444444444"); 
        User u=new User();
        u=userdao.search("user4");
        System.out.println("查"+u.getName());
        
        
        /////////////////////////////////// // //删
        System.out.println("555555555"); 
        userdao.remove("user4");      
        
        list=userdao.getUsers();   
        for(int i=0;i<list.size();i++)
        	System.out.println(list.get(i).getName());
        
    }
}