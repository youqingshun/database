package main;

import java.util.List;

import DaoImplment.WishDao;
import vo.Wish;

public class TestWish {
	public static void main(String args[]) throws Exception {
		List<Wish> list = null;
		WishDao vodao = new WishDao(); // 遍历
		System.out.println("1111111111111");
		list = vodao.getWish();
		for (int i = 0; i < list.size(); i++)
			System.out.println((list.get(i)).getName());

		/////////////////////////////////// 增
		System.out.println("************************************\n下面测试增的功能");
		Wish vo = new Wish();
		vo.setId(2);
		vo.setName("name1");
		vo.setItid(1);
		vo.setUid(1);
		boolean flag = vodao.add(vo);
		System.out.println("插入是否成功:" + flag);

		list = vodao.getWish();
		for (int i = 0; i < list.size(); i++)
			System.out.println((list.get(i)).getName());

		/////////////////////////////////// //改
		System.out.println("************************************\n下面测试改的功能");
		vo.setName("name测试");
		vodao.update(vo);
		list = vodao.getWish();
		for (int i = 0; i < list.size(); i++)
			System.out.println(( list.get(i)).getName());

		/////////////////////////////////// //查
		System.out.println("************************************\n下面测试查的功能");
		Wish u = new Wish();
		u = vodao.search(2);
		if (u != null)
			System.out.println("查：" + u.getName());
		else
			System.out.println("查无此人");

		/////////////////////////////////// // //删
		System.out.println("************************************\n下面测试删的功能");
		vodao.remove(2);

		list = vodao.getWish();
		for (int i = 0; i < list.size(); i++)
			System.out.println(( list.get(i)).getName());

	}
}
