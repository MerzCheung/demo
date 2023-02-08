package com.ming.zhang.java_guide.SPI.jdk;

import java.util.ServiceLoader;

/**
 * @author 张铭
 * @since 2023/2/7 16:02
 */
public class Test {

    public static void main(String[] args) {
        ServiceLoader<Upload> uploadServiceLoader = ServiceLoader.load(Upload.class);
        for (Upload u : uploadServiceLoader) {
            u.upload();
        }
    }
}
