package com.vuson.algorithm.string;

import java.util.function.Consumer;

class Nguoi {
	String ten;
	String diaChi;

	public Nguoi() {
		super();
	}

	public Nguoi(String ten, String diaChi) {
		super();
		this.ten = ten;
		this.diaChi = diaChi;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj.getClass() != this.getClass())
			return false;
		Nguoi n = (Nguoi) obj;
		return this.ten == n.ten;
	}

	@Override
	public int hashCode() {
		return diaChi.hashCode();
	}
}

public class EqualsHashCode {

	public static void main(String[] args) {
		
		Nguoi n1 = new Nguoi("tran van a", "ha noi");
		Nguoi n2 = new Nguoi("tran van a", "ha noi 1");
		
		
		Consumer<Nguoi> s = event -> System.out.println(event.diaChi);
		
		
		System.out.println("n1 equals n2: " + n1.equals(n2));
		System.out.println("n1 equals n2: " + (n1 == n2));
		System.out.println("n1 hashcode " + n1.hashCode());
		System.out.println("n2 hashcode " + n2.hashCode());
	}
}
