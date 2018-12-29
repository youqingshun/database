package main;

import java.util.List;

import DaoImplment.MessageDao;
import vo.Message;

public class TestMessage {
	public static void main(String args[]) throws Exception {
		List<Message> list = null;
		MessageDao vodao = new MessageDao(); // 遍历
		System.out.println("1111111111111");
		list = vodao.getMessage();
		for (int i = 0; i < list.size(); i++)
			System.out.println((list.get(i)).getInfos());

		/////////////////////////////////// 增
		System.out.println("************************************\n下面测试增的功能");
		Message vo = new Message();
		vo.setId(2);
		vo.setInfos("info1");
		vo.setReply("reply1");
		vo.setState("state1");
		vo.setUid(1);

		boolean flag = vodao.add(vo);
		System.out.println("插入是否成功:" + flag);

		list = vodao.getMessage();
		for (int i = 0; i < list.size(); i++)
			System.out.println((list.get(i)).getInfos());

		/////////////////////////////////// //改
		System.out.println("************************************\n下面测试改的功能");
		vo.setInfos("info测试");
		vodao.update(vo);
		list = vodao.getMessage();
		for (int i = 0; i < list.size(); i++)
			System.out.println(( list.get(i)).getInfos());

		/////////////////////////////////// //查
		System.out.println("************************************\n下面测试查的功能");
		Message u = new Message();
		u = vodao.search(2);
		if (u != null)
			System.out.println("查：" + u.getInfos());
		else
			System.out.println("查无此人");

		/////////////////////////////////// // //删
		System.out.println("************************************\n下面测试删的功能");
		vodao.remove(2);

		list = vodao.getMessage();
		for (int i = 0; i < list.size(); i++)
			System.out.println(( list.get(i)).getInfos());

	}
}
