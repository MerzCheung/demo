package com.example.autopoi;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;
import java.util.*;

@RestController
@RequestMapping("/test")
public class Test {

    @RequestMapping("/download")
    public void download(HttpServletResponse response) throws IOException {
        Map<String, Object> map = new HashMap<>();
        map.put("date", "2022-01-01");
        map.put("name", "张三");
        map.put("year", "2022");
        map.put("project", "全部项目");
        map.put("staff", "全部员工");
        map.put("version", Arrays.asList("测试","测试","测试","测试","测试","测试","测试","测试","测试","测试","测试","测试","测试"));
        map.put("month", Arrays.asList("1","2","3","4","5","6","7","8","9","10","11","12","13"));
        map.put("statutoryHourArray", initDoubleArray());
        map.put("yieldHourArray", initDoubleArray());
        map.put("costHourArray", initDoubleArray());
        map.put("loadRateArray", initDoubleArray());
        map.put("incomeArray", initDoubleArray());
        map.put("otherIncomeArray", initDoubleArray());
        map.put("sumIncomeArray", initDoubleArray());
        map.put("costArray", initDoubleArray());
        map.put("shebaoArray", initDoubleArray());
        map.put("otherCostArray", initDoubleArray());
        map.put("sumCostArray", initDoubleArray());
        map.put("costProfitRateArray", initDoubleArray());
        map.put("staffProfitRateArray", initDoubleArray());
        map.put("grossProfitRateArray", initDoubleArray());
        map.put("backMoneyArray", initDoubleArray());
        map.put("backTimeArray", initDoubleArray());
        map.put("staffScaleArray", initDoubleArray());
        map.put("pullScaleArray", initDoubleArray());
        InputStream is = this.getClass().getResourceAsStream("/templates/project.xlsx");
        XSSFWorkbook workbook = new XSSFWorkbook(is);
        XSSFSheet sheetAt = workbook.getSheetAt(0);
        int callSize = sheetAt.getRow(0).getPhysicalNumberOfCells();
        Iterator<Row> rowIterator = sheetAt.rowIterator();
        while (rowIterator.hasNext()) {
            Row row = rowIterator.next();
            for (int i = 0; i < callSize; i++) {
                String stringCellValue = row.getCell(i).getStringCellValue();
                boolean matches = stringCellValue.matches("\\{\\{([^}])*\\}\\}");
                if (!matches) {
                    continue;
                }
                stringCellValue = stringCellValue.replace("{{", "").replace("}}", "").replaceAll("\\s{1,}", " ").trim();
                if (stringCellValue.contains(".")) {
                    // 循环输出
                    stringCellValue = stringCellValue.replace(".", "");
                    List list = (List) map.get(stringCellValue);
                    for (int j = 0; j < list.size(); j++) {
                        try {
                            row.getCell(i + j).setCellValue(list.get(j).toString());
                        } catch (NullPointerException e) {
                            row.createCell(i + j).setCellValue(list.get(j).toString());
                        }
                    }
                    break;
                }
                row.getCell(i).setCellValue(map.get(stringCellValue).toString());
            }
        }

        response.setContentType(MediaType.APPLICATION_OCTET_STREAM_VALUE);
        //attachment为以附件方式下载
        response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(
                "project.xlsx", "utf-8"));
        response.setHeader("Cache-Control", "No-cache");
        response.flushBuffer();
        workbook.write(response.getOutputStream());
        workbook.close();
    }

    private List<Double> initDoubleArray() {
        return Arrays.asList(0d, 0d, 0d, 0d, 0d, 0d, 0d, 0d, 0d, 0d, 0d, 0d, 0d, 0d, 0d, 0d, 0d, 0d);
    }
}
