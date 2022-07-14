package com.ming.zhang.java_guide.java8.接口内允许添加默认实现的方法;

public class Test {
    public static void main(String[] args) {
        Formula f = new FormulaImpl();
        System.out.println(f.calculate(100));
        System.out.println(f.sqrt(16));
    }
}
