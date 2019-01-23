package com.retry;

import java.util.Optional;

public class Test {

    public static void main(String[] args) {
        User user = new User();
        user.setEmail("123@163.com");
        user.setName("zhangsan");
        User user2 = new User();
        user2.setName("default");
        user2.setEmail("default@163.com");
        String email = Optional.ofNullable(user2).map(u -> u.getEmail()).orElse(user.getEmail());
        System.out.println(email);
        User result = Optional.ofNullable(user).orElse(user2);  // ofNullable不为Null时还是会执行orElse但是orElseGet不会执行了
        System.out.println(result);
//        Optional<User> optUser = Optional.ofNullable(user);
//        optUser.ifPresent((item -> System.out.println(item)));
    }
}
