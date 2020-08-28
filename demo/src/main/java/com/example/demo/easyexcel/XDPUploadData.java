package com.example.demo.easyexcel;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

@Data
public class XDPUploadData {
    @ExcelProperty(value = "Date")
    private String date;
    @ExcelProperty(value = "Tracking#")
    private String tracking;
}
