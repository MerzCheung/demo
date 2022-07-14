package com.ming.zhang.java_guide.java11;

import java.util.stream.Stream;

public class StringTest {
    public static void main(String[] args) {
        // 1. isBlank判空
        String s = "  ";
        System.out.println(s.isBlank()); // true

        // 2. lines()按行分割获取stream流
        String s2 = "第一行\n第二行\n第三行";
        Stream<String> lines = s2.lines();
        lines.forEach(System.out::println);

        // 3. strip()去除空白字符。trim 只能去除半角空格，而 strip 是去除各种空白符
        String s3 = " aaacccddd ";
        //去除前后各种空白字符（包括全角半角）
        System.out.println("===" + s3.strip() + "===");
        //去除前面各种空白字符（包括全角半角）
        System.out.println("===" + s3.stripLeading() + "===");
        //去除后面各种空白字符（包括全角半角）
        System.out.println("===" + s3.stripTrailing() + "===");
        //输出
        //===aaacccddd===
        //===aaacccddd ===
        //=== aaacccddd===

        // 4. repeat()复制字符串
        String s4 = "你好!";
        String repeat = s4.repeat(4);
        System.out.println(repeat);
    }
}
