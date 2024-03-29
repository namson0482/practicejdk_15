package com.vuson.algorithm.java8;


import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;


class User {
	
	public String userName;
	
	public User(String userName) {
		
		this.userName = userName;
	}
	
	public String getUserName() {
		return this.userName;
	}
}

public class ReferenceParticularType {

	
	public static void main(String[] args) {
		
		List<String> list = new ArrayList<String>();
		list.add("Son");
		list.add("Nam");
		list.add("     ");
		long count = list.stream().filter(x -> x.isEmpty()).count();
		Consumer<Long> consumer = x -> System.out.println(x);
		consumer.accept(count);
		
		Stream<User> steamUser = list.stream().filter(x -> !x.isBlank()).map(User::new);
		List<User> lstUser = steamUser.collect(Collectors.toList());
		lstUser.forEach(user -> System.out.println(user.getUserName()));
	}
}
