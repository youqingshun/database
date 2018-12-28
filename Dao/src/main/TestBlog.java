package main;

import java.util.List;

import DaoImplment.BlogDao;
import base.Vobase;
import vo.Blog;
import vo.Blog;

public class TestBlog {
	public static void main(String args[]) throws Exception {
		List<Blog> list = null;
		BlogDao blogdao = new BlogDao(); // 遍历
		System.out.println("1111111111111");
		list = blogdao.getBlog();
		for (int i = 0; i < list.size(); i++)
			System.out.println((list.get(i)).getZhaiyao());

		/////////////////////////////////// 增
		System.out.println("************************************\n下面测试增的功能");
		Blog blog = new Blog();
		blog.setId(2);
		blog.setInfos("1-infos");
		blog.setItid(1);
		blog.setPicurls("1-picurls");
		blog.setTime("1-time");
		blog.setTitle("1-title");
		blog.setType("1-type");
		blog.setZhaiyao("1-zhaiyao");

		boolean flag = blogdao.add(blog);
		System.out.println("插入是否成功:" + flag);

		list = blogdao.getBlog();
		for (int i = 0; i < list.size(); i++)
			System.out.println((list.get(i)).getZhaiyao());

		/////////////////////////////////// //改
		System.out.println("************************************\n下面测试改的功能");
		blog.setZhaiyao("摘要测试");
		blogdao.update(blog);
		list = blogdao.getBlog();
		for (int i = 0; i < list.size(); i++)
			System.out.println(( list.get(i)).getZhaiyao());

		/////////////////////////////////// //查
		System.out.println("************************************\n下面测试查的功能");
		Blog u = new Blog();
		u = blogdao.search(2);
		if (u != null)
			System.out.println("查：" + u.getZhaiyao());
		else
			System.out.println("查无此人");

		/////////////////////////////////// // //删
		System.out.println("************************************\n下面测试删的功能");
		blogdao.remove(2);

		list = blogdao.getBlog();
		for (int i = 0; i < list.size(); i++)
			System.out.println(( list.get(i)).getZhaiyao());

	}
}
