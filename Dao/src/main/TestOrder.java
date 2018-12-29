package main;

import java.util.List;

import DaoImplment.OrderDao;
import vo.Order;

public class TestOrder {
	
	public static void main(String args[]) throws Exception {
		List<Order> list = null;
		OrderDao vodao = new OrderDao(); // 遍历
		System.out.println("1111111111111");
		list = vodao.getOrder();
		for (int i = 0; i < list.size(); i++)
			System.out.println((list.get(i)).getInfos());

		/////////////////////////////////// 增
		System.out.println("************************************\n下面测试增的功能");
		Order vo = new Order();
		vo.setId(2);
		vo.setInfos("info1");
		vo.setUid(1);
		vo.setItid(1);

		boolean flag = vodao.add(vo);
		System.out.println("插入是否成功:" + flag);

		list = vodao.getOrder();
		for (int i = 0; i < list.size(); i++)
			System.out.println((list.get(i)).getInfos());

		/////////////////////////////////// //改
		System.out.println("************************************\n下面测试改的功能");
		vo.setInfos("info测试");
		vodao.update(vo);
		list = vodao.getOrder();
		for (int i = 0; i < list.size(); i++)
			System.out.println(( list.get(i)).getInfos());

		/////////////////////////////////// //查
		System.out.println("************************************\n下面测试查的功能");
		Order u = new Order();
		u = vodao.search(2);
		if (u != null)
			System.out.println("查：" + u.getInfos());
		else
			System.out.println("查无此人");

		/////////////////////////////////// // //删
		System.out.println("************************************\n下面测试删的功能");
		vodao.remove(2);

		list = vodao.getOrder();
		for (int i = 0; i < list.size(); i++)
			System.out.println(( list.get(i)).getInfos());

	}
}
