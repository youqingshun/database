package main;

import java.util.List;

import DaoImplment.ShopcarDao;
import vo.Shopcar;

public class TestShopcar {
	public static void main(String args[]) throws Exception {
		List<Shopcar> list = null;
		ShopcarDao vodao = new ShopcarDao(); // 遍历
		System.out.println("1111111111111");
		list = vodao.getShopcar();
		for (int i = 0; i < list.size(); i++)
			System.out.println((list.get(i)).getName());

		/////////////////////////////////// 增
		System.out.println("************************************\n下面测试增的功能");
		Shopcar vo = new Shopcar();
		vo.setId(2);
		vo.setName("name1");
		vo.setItid(1);
		vo.setUid(1);
		boolean flag = vodao.add(vo);
		System.out.println("插入是否成功:" + flag);

		list = vodao.getShopcar();
		for (int i = 0; i < list.size(); i++)
			System.out.println((list.get(i)).getName());

		/////////////////////////////////// //改
		System.out.println("************************************\n下面测试改的功能");
		vo.setName("name测试");
		vodao.update(vo);
		list = vodao.getShopcar();
		for (int i = 0; i < list.size(); i++)
			System.out.println(( list.get(i)).getName());

		/////////////////////////////////// //查
		System.out.println("************************************\n下面测试查的功能");
		Shopcar u = new Shopcar();
		u = vodao.search(2);
		if (u != null)
			System.out.println("查：" + u.getName());
		else
			System.out.println("查无此人");

		/////////////////////////////////// // //删
		System.out.println("************************************\n下面测试删的功能");
		vodao.remove(2);

		list = vodao.getShopcar();
		for (int i = 0; i < list.size(); i++)
			System.out.println(( list.get(i)).getName());

	}
}
