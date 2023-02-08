package com.example.demo;

import cn.hutool.core.io.FileTypeUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

@Slf4j
@SpringBootTest
public class ZipDownloadTest {

    @Test
    public void tes() throws Exception {
        URL url = new URL("https://img2.woyaogexing.com/2022/11/03/ced896a37c413320!400x400.jpg");
//        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
//        conn.setDoInput(true);
//        conn.setConnectTimeout(5000);
//        conn.connect();
        InputStream inputStream = url.openStream();
        String fileType = FileTypeUtil.getType(url.openStream());
        String fileName = "file_3." + fileType;
        ZipOutputStream zos = null;
        File zipFile = new File("d:\\uploadFiles\\a.zip");
        if (!zipFile.exists()) {
            zipFile.createNewFile();
        }
        zos = new ZipOutputStream(new FileOutputStream(zipFile));
        try {
            byte[] buf = new byte[1024];
            zos.putNextEntry(new ZipEntry(fileName));
            int len;
            while ((len = inputStream.read(buf)) != -1) {
                zos.write(buf, 0, len);
            }
            zos.flush();
            zos.closeEntry();
            zos.finish();
        } catch (Exception e) {
            e.printStackTrace();
        }
        inputStream.close();
//        conn.disconnect();
        zos.close();
    }

    @Test
    public void download() {
        try {
            byte[] buf = new byte[1024];
            File zipFile = new File("d:\\uploadFiles\\a.zip");
            if (!zipFile.exists()) {
                zipFile.createNewFile();
            }
            ZipOutputStream zos = new ZipOutputStream(new FileOutputStream(zipFile));
            int num = 0;
            List<String> strings = Arrays.asList("https://img2.woyaogexing.com/2022/08/23/cfcf821f37fa046e!400x400.jpg",
                    "https://img2.woyaogexing.com/2022/08/23/cc8909ab73204efd!400x400.png",
                    "http://www.merzjava.com:9000/oss/wallbg0.png?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Credential=9FTO606GOP5VMQ2L7GVE%2F20221009%2Fus-east-1%2Fs3%2Faws4_request&X-Amz-Date=20221009T070515Z&X-Amz-Expires=604800&X-Amz-Security-Token=eyJhbGciOiJIUzUxMiIsInR5cCI6IkpXVCJ9.eyJhY2Nlc3NLZXkiOiI5RlRPNjA2R09QNVZNUTJMN0dWRSIsImV4cCI6MTY2NTMwMjY2MywicGFyZW50IjoiYWRtaW4ifQ.kWglx0CSoRiyN1kSca6dIaMjMb5-KqWVtmF495yALm2FMX1CUBY8C-UbezO1at9oAx1m-pbAdHvYMHV5QKefSA&X-Amz-SignedHeaders=host&versionId=null&X-Amz-Signature=cb902c5530d2b5ef887abf620af8cfa3ba3f2edb4c99af405ad993de5eda976d",
                    "http://www.merzjava.com:9000/dev/1536151064%281%29.jpg",
                    "http://www.merzjava.com:9000/dev/%E5%BC%A0%E9%93%AD-java.docx",
                    "http://www.merzjava.com:9000/dev/pay_demo.zip");

            for (String path : strings) {
                // 下载附件,图片
                InputStream inputStream = null;
                String fileName = "file_" + (++num);
                try {
                    URL url = new URL(path);
                    System.out.println(url.getFile());
                    HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                    conn.setDoInput(true);
//                    conn.setConnectTimeout(2000);//设置连接超时
                    conn.connect();
                    inputStream = conn.getInputStream();
                    String fileType = FileTypeUtil.getType(inputStream);
                    System.out.println(fileType);
                    System.out.println(conn.getContentType());
                    fileName = fileName + "." + fileType;
                } catch (IOException e) {
                    log.error("链接文件失败， 文件地址：{}", path);
                    continue;
                }
                zos.putNextEntry(new ZipEntry(fileName));
                int len;
                while ((len = inputStream.read(buf)) > 0) {
                    zos.write(buf, 0, len);
                }
                zos.closeEntry();
            }
            // 下载错误日志
            String msg = "sadasdsadasdsadsadsadasdsadsadasdq1231231231231";
            if (StringUtils.isNotEmpty(msg)) {
                ByteArrayInputStream msgInputStream = new ByteArrayInputStream(msg.getBytes(StandardCharsets.UTF_8));
                zos.putNextEntry(new ZipEntry("connect_error.txt"));
                int msgLen;
                while ((msgLen = msgInputStream.read(buf)) > 0) {
                    zos.write(buf, 0, msgLen);
                }
                zos.closeEntry();
            }
            zos.close();
        } catch (IOException e) {
            log.error("下载离线文档失败, error: ", e);
        }
    }
}
