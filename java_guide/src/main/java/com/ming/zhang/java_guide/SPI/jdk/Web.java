package com.ming.zhang.java_guide.SPI.jdk;

/**
 * @author 张铭
 * @since 2023/2/7 16:00
 */
public class Web implements Upload {
    @Override
    public void upload() {
        System.out.println("web上传");
    }
}
