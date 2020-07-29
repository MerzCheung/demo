package com.example.demo.easyexcel;

import com.alibaba.excel.EasyExcel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

@Controller
public class EasyExcelDemoController {

    @Autowired
    private UploadDAO uploadDAO;

    /**
     * 文件上传
     * <p>1. 创建excel对应的实体对象 参照{@link UploadData}
     * <p>2. 由于默认一行行的读取excel，所以需要创建excel一行一行的回调监听器，参照{@link UploadDataListener}
     * <p>3. 直接读即可
     */
    @PostMapping("upload")
    @ResponseBody
    public String upload(@RequestParam("file") MultipartFile file) throws IOException {
        EasyExcel.read(file.getInputStream(), UploadData.class, new UploadDataListener(uploadDAO)).sheet().headRowNumber(2).doRead();
        return "success";
    }

    @PostMapping("uploadUrl")
    @ResponseBody
    public String uploadUrl() throws IOException {
        // http://172.16.2.108/uploads/SupplierStatementFile/bill/upload//2019/EASY_POST/original_bill/ces.xlsx
        String urlPath = "http://172.16.2.108/uploads/SupplierStatementFile/bill/upload//2019/EASY_POST/original_bill/ces.xlsx".replace(" ", "%20");
        URL url = null;
        HttpURLConnection urlCon = null;
        try {
            url = new URL(urlPath);
            urlCon = (HttpURLConnection) url.openConnection();
            urlCon.setConnectTimeout(5000);
            urlCon.setDoOutput(true);
            urlCon.setReadTimeout(5000);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if(urlCon==null){
            return null;
        }
        EasyExcel.read(urlCon.getInputStream(), UploadData.class, new UploadDataListener(uploadDAO)).sheet().headRowNumber(2).doRead();
        return "success";
    }
}
