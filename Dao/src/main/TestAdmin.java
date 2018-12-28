package main;

import java.util.List;

import DaoImplment.AdminDao;
import base.Vobase;
import vo.Admin;

public class TestAdmin {

	public static void main(String args[]) throws Exception {
		List<Vobase> list = null;
		AdminDao admindao = new AdminDao(); // 遍历
		System.out.println("1111111111111");
		list = admindao.getVos();
		for (int i = 0; i < list.size(); i++)
			System.out.println(((Admin) list.get(i)).getName());

		/////////////////////////////////// 增
		System.out.println("************************************\n下面测试增的功能");
		Admin admin = new Admin();
		admin.setEmail("test");
		admin.setPwd("123");
		admin.setNo("admin3");
		admin.setTel("131590");
		admin.setName("黎明");

		boolean flag = admindao.add(admin);
		System.out.println("插入是否成功:" + flag);

		list = admindao.getVos();
		for (int i = 0; i < list.size(); i++)
			System.out.println(((Admin) list.get(i)).getName());

		/////////////////////////////////// //改
		System.out.println("************************************\n下面测试改的功能");
		admin.setName("黎明2");
		admindao.update(admin);
		list = admindao.getVos();
		for (int i = 0; i < list.size(); i++)
			System.out.println(((Admin) list.get(i)).getName());

		/////////////////////////////////// //查
		System.out.println("************************************\n下面测试查的功能");
		Admin u = new Admin();
		u = admindao.search("admin2");
		if (u != null)
			System.out.println("查：" + u.getName());
		else
			System.out.println("查无此人");

		/////////////////////////////////// // //删
		System.out.println("************************************\n下面测试删的功能");
		admindao.remove("admin3");

		list = admindao.getVos();
		for (int i = 0; i < list.size(); i++)
			System.out.println(((Admin) list.get(i)).getName());

	}
}