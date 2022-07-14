package com.ming.zhang.java_guide.java8.函数式接口;
/*
所谓函数式接口（Functional Interface）就是只包含有且只有一个抽象方法的声明.
即使去掉 @FunctionalInterface 也是好使的，它仅仅是一种约束而已

https://www.runoob.com/java/java8-functional-interfaces.html
*/

@FunctionalInterface
public interface Converter<T, F> {
    T convert(F from);
}
