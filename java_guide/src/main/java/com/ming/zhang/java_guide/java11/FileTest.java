package com.ming.zhang.java_guide.java11;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileTest {
    public static void main(String[] args) throws IOException {
        Path path = Files.writeString(Files.createTempFile("test", ".txt"), "java从入门到放弃");
        System.out.println(path);
        String s = Files.readString(path);
        System.out.println(s);
    }
}
