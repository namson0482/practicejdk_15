<<<<<<<< HEAD:src/main/java/vunam/java8/ReferenceParticularType.java
package vunam.java8;
========
package vu.son.java8;
>>>>>>>> revert-7-beta:src/main/java/vu/son/java8/ReferenceParticularType.java

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
		long count = list.stream().filter(x -> x.isEmpty() == true).count();
		Consumer<Long> consumer = x -> System.out.println(x);
		consumer.accept(count);
		
		Stream<User> steamUser = list.stream().filter(x -> x.isBlank() == false).map(User::new);
		List<User> lstUser = steamUser.collect(Collectors.toList());
		lstUser.forEach(user -> System.out.println(user.getUserName()));
	}
}
