package main;

import java.util.ArrayList;
import java.util.List;

import base.Vobase;

public class Test {
	public static void use(T1 t1)
	{
		T2 t3=(T2)t1;
		System.out.println("in function    "+t3+"  t3.a1="+t3.a1+"  t3.f1="+t3.f1);
	}
	
	
	public static void main(String args[]) throws Exception {
		List<T1> list = new ArrayList<T1>();
		T2 t2=new T2();
		t2.a1=10;
		t2.f1=0.23;
		list.add(t2);
		T2 t3=(T2) list.get(0);
		System.out.println(t3+"  t3.a1="+t3.a1+"  t3.f1="+t3.f1);
		
		use(t2);
	}
	
}

class T1
{
	public int a1;
}

class T2 extends T1
{
	public double f1;
}