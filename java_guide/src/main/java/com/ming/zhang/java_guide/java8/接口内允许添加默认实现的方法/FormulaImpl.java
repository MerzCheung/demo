package com.ming.zhang.java_guide.java8.接口内允许添加默认实现的方法;

public class FormulaImpl implements Formula {
    @Override
    public double calculate(int a) {
        return sqrt(a * 100);
    }
}
