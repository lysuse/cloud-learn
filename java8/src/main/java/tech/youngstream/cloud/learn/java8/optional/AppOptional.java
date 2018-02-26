package tech.youngstream.cloud.learn.java8.optional;

import java.util.Optional;

public class AppOptional {

    public static void main(String[] args) {
        Integer a1 = null;
        Integer a2 = new Integer(10);

        Optional<Integer> a = Optional.ofNullable(a1);

        Optional<Integer> b = Optional.of(a2);

        System.out.println(sum(a, b));
    }

    public static Integer sum(Optional<Integer> a1, Optional<Integer> a2) {
        System.out.println("第一个参数值存在: "+ a1.isPresent());
        System.out.println("第二个参数值存在: "+ a2.isPresent());

        // Optional.orElse - 如果值存在，返回它，否则返回默认值
        Integer a1Temp = a1.orElse(new Integer(0));
        return a1Temp + a2.get();
    }

}
