package com.ming.zhang.java_guide.SPI.jdk;

/**
 * @author 张铭
 * @since 2023/2/7 16:00
 */
public class App implements Upload {
    @Override
    public void upload() {
        System.out.println("App上传");
    }
}
