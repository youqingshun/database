package main;

import java.util.List;

import DaoImplment.BlogDao;
import DaoImplment.ItemsDao;
import vo.Blog;
import vo.Items;

public class TestItems {
	public static void main(String args[]) throws Exception {
		List<Items> list = null;
		ItemsDao itemsdao = new ItemsDao(); // 遍历
		System.out.println("1111111111111");
		list = itemsdao.getItems();
		for (int i = 0; i < list.size(); i++)
			System.out.println((list.get(i)).getName());

		/////////////////////////////////// 增
		System.out.println("************************************\n下面测试增的功能");
		Items item = new Items();
		item.setBrand("brand1");
		item.setId(2);
		item.setInfos("info1");
		item.setName("name1");
		item.setNo("user1");
		item.setPrice(4.4);
		item.setType("type1");
		item.setUrls("urls1");
		
		boolean flag = itemsdao.add(item);
		System.out.println("插入是否成功:" + flag);

		list = itemsdao.getItems();
		for (int i = 0; i < list.size(); i++)
			System.out.println((list.get(i)).getName());

		/////////////////////////////////// //改
		System.out.println("************************************\n下面测试改的功能");
		item.setName("名字测试");
		itemsdao.update(item);
		list = itemsdao.getItems();
		for (int i = 0; i < list.size(); i++)
			System.out.println(( list.get(i)).getName());

		/////////////////////////////////// //查
		System.out.println("************************************\n下面测试查的功能");
		Items u = new Items();
		u = itemsdao.search(2);
		if (u != null)
			System.out.println("查：" + u.getName());
		else
			System.out.println("查无此人");

		/////////////////////////////////// // //删
		System.out.println("************************************\n下面测试删的功能");
		itemsdao.remove(2);

		list = itemsdao.getItems();
		for (int i = 0; i < list.size(); i++)
			System.out.println(( list.get(i)).getName());

	}
}
