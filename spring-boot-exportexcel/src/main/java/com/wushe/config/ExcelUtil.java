package com.wushe.config;

import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.awt.image.IndexColorModel;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description:
 * @Copyright: Copyright (c) 2020  ALL RIGHTS RESERVED.
 * @Company: 成都旺小宝科技有限公司
 * @Author: jtb
 * @CreateDate: 2020/12/9 10:33
 * @UpdateDate: 2020/12/9 10:33
 * @UpdateRemark: init
 * @Version: 1.0
 * @menu
 */
@Service
public class ExcelUtil {
    /**
     *  导出excel （HSSFWorkbook）
     */
    public void exportExcel(HttpServletResponse response) {

        /** 第一步，创建一个Workbook，对应一个Excel文件  */
        HSSFWorkbook wb = new HSSFWorkbook();

        /** 第二步，在Workbook中添加一个sheet,对应Excel文件中的sheet  */
        HSSFSheet sheet = wb.createSheet("excel导出标题");

        /** 第三步，设置样式以及字体样式*/
        HSSFCellStyle titleStyle = createTitleCellStyle(wb);
        HSSFCellStyle headerStyle = createHeadCellStyle(wb);
        HSSFCellStyle contentStyle = createContentCellStyle(wb);

        /** 第四步，创建标题 ,合并标题单元格 */
        // 行号
        int rowNum = 0;
        // 创建第一页的第一行，索引从0开始
        HSSFRow row0 = sheet.createRow(rowNum++);
        row0.setHeight((short) 800);// 设置行高

        String title = "excel导出标题";
        HSSFCell c00 = row0.createCell(0);
        c00.setCellValue(title);
        c00.setCellStyle(titleStyle);
        // 合并单元格，参数依次为起始行，结束行，起始列，结束列 （索引0开始）
        sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, 6));//标题合并单元格操作，6为总列数

        // 第二行
        HSSFRow row1 = sheet.createRow(rowNum++);
        row1.setHeight((short) 500);
        String[] row_first = {"填表单位：", "", "", "", "", " 2019年第2季度 ", ""};
        for (int i = 0; i < row_first.length; i++) {
            HSSFCell tempCell = row1.createCell(i);
            tempCell.setCellStyle(headerStyle);
            if (i == 0) {
                tempCell.setCellValue(row_first[i] + "测试单位");
            } else if (i == 5) {
                tempCell.setCellStyle(headerStyle);
                tempCell.setCellValue(row_first[i]);
            } else {
                tempCell.setCellValue(row_first[i]);
            }
        }

        // 合并
        sheet.addMergedRegion(new CellRangeAddress(1, 1, 0, 4));
        sheet.addMergedRegion(new CellRangeAddress(1, 1, 5, 6));

        //第三行
        HSSFRow row2 = sheet.createRow(rowNum++);
        row2.setHeight((short) 700);
        String[] row_second = {"名称", "采集情况", "", "", "登记情况", "", "备注"};
        for (int i = 0; i < row_second.length; i++) {
            HSSFCell tempCell = row2.createCell(i);
            tempCell.setCellValue(row_second[i]);
            tempCell.setCellStyle(headerStyle);
        }

        // 合并
        sheet.addMergedRegion(new CellRangeAddress(2, 3, 0, 0));//名称
        sheet.addMergedRegion(new CellRangeAddress(2, 2, 1, 3));//人数情况
        sheet.addMergedRegion(new CellRangeAddress(2, 2, 4, 5));//登记情况
        sheet.addMergedRegion(new CellRangeAddress(2, 3, 6, 6));//备注

        //第三行
        HSSFRow row3 = sheet.createRow(rowNum++);
        row3.setHeight((short) 700);
        String[] row_third = {"", "登记数(人)", "办证总数(人)", "办证率(%)", "登记户数(户)", "签订数(份)", ""};
        for (int i = 0; i < row_third.length; i++) {
            HSSFCell tempCell = row3.createCell(i);
            tempCell.setCellValue(row_third[i]);
            tempCell.setCellStyle(headerStyle);
        }

        //循环每一行数据
        List<Map<String, Object>> dataList = new ArrayList<Map<String, Object>>(); //查询出来的数据
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("name", "测试名称1");
        map.put("r1", "111");
        map.put("r2", "222");
        map.put("r3", "333");
        map.put("r4", "444");
        map.put("r5", "555");
        map.put("r6", "666");
        dataList.add(map);
        dataList.add(map);//加多一条list

        for (Map<String, Object> excelData : dataList) {
            HSSFRow tempRow = sheet.createRow(rowNum++);
            tempRow.setHeight((short) 500);
            // 循环单元格填入数据
            for (int j = 0; j < 7; j++) {
                HSSFCell tempCell = tempRow.createCell(j);
                tempCell.setCellStyle(contentStyle);
                String tempValue;
                if (j == 0) {
                    // 乡镇、街道名称
                    tempValue = excelData.get("name").toString();
                } else if (j == 1) {
                    // 登记数（人）
                    tempValue = excelData.get("r1").toString();
                } else if (j == 2) {
                    // 办证总数（人）
                    tempValue = excelData.get("r2").toString();
                } else if (j == 3) {
                    // 办证率（%）
                    tempValue = excelData.get("r3").toString();
                } else if (j == 4) {
                    // 登记户数（户）
                    tempValue = excelData.get("r4").toString();
                } else if (j == 5) {
                    // 签订数（份）
                    tempValue = excelData.get("r5").toString();
                } else {
                    // 备注
                    tempValue = excelData.get("r6").toString();
                }
                tempCell.setCellValue(tempValue);
            }
        }

        // 注释行
        HSSFRow remark = sheet.createRow(rowNum++);
        remark.setHeight((short) 500);
        String[] row_remark = {"注：表中的“办证率=办证总数÷登记数×100%”", "", "", "", "", "", ""};
        for (int i = 0; i < row_remark.length; i++) {
            HSSFCell tempCell = remark.createCell(i);
            if (i == 0) {
                tempCell.setCellStyle(headerStyle);
            } else {
                tempCell.setCellStyle(contentStyle);
            }
            tempCell.setCellValue(row_remark[i]);
        }
        int remarkRowNum = dataList.size() + 4;
        sheet.addMergedRegion(new CellRangeAddress(remarkRowNum, remarkRowNum, 0, 6));//注释行合并单元格

        // 尾行
        HSSFRow foot = sheet.createRow(rowNum++);
        foot.setHeight((short) 500);
        String[] row_foot = {"审核人：", "", "填表人：", "", "填表时间：", "", ""};
        for (int i = 0; i < row_foot.length; i++) {
            HSSFCell tempCell = foot.createCell(i);
            tempCell.setCellStyle(contentStyle);
            if (i == 0) {
                tempCell.setCellValue(row_foot[i] + "张三");
            } else if (i == 2) {
                tempCell.setCellValue(row_foot[i] + "李四");
            } else if (i == 4) {
                tempCell.setCellValue(row_foot[i] + "xxxx");
            } else {
                tempCell.setCellValue(row_foot[i]);
            }
        }
        int footRowNum = dataList.size() + 5;
        // 注
        sheet.addMergedRegion(new CellRangeAddress(footRowNum, footRowNum, 0, 1));
        sheet.addMergedRegion(new CellRangeAddress(footRowNum, footRowNum, 2, 3));
        sheet.addMergedRegion(new CellRangeAddress(footRowNum, footRowNum, 4, 6));

        //导出
        //HttpServletResponse response = this.getResponse();
        String fileName = "报表名称.xls";

        try {
            fileName = new String(fileName.getBytes("UTF-8"), "ISO-8859-1");
            response.setHeader("Content-disposition", "attachment;filename=\"" + fileName + "\"");
            OutputStream stream = response.getOutputStream();
            if (null != wb && null != stream) {
                wb.write(stream);// 将数据写出去
               // wb.close();

                stream.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * 创建标题样式
     * @param wb
     * @return
     */
    private static HSSFCellStyle createTitleCellStyle(HSSFWorkbook wb) {
        HSSFCellStyle cellStyle = wb.createCellStyle();
        //cellStyle.setAlignment(HorizontalAlignment.CENTER);//水平居中
        //cellStyle.setVerticalAlignment(VerticalAlignment.CENTER);//垂直对齐
        //cellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        cellStyle.setFillForegroundColor(IndexedColors.GREY_40_PERCENT.getIndex());//背景颜色

        HSSFFont headerFont1 = (HSSFFont) wb.createFont(); // 创建字体样式
        //headerFont1.setBold(true); //字体加粗
        headerFont1.setFontName("黑体"); // 设置字体类型
        headerFont1.setFontHeightInPoints((short) 15); // 设置字体大小
        cellStyle.setFont(headerFont1); // 为标题样式设置字体样式

        return cellStyle;
    }
    private static HSSFCellStyle createHeadCellStyle(HSSFWorkbook wb){
        HSSFCellStyle cellStyle = wb.createCellStyle();
        cellStyle.setWrapText(true);
        cellStyle.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.getIndex());

       // cellStyle.setAlignment(HorizontalAlignment.CENTER);
       // cellStyle.setVerticalAlignment(VerticalAlignment.CENTER);
       // cellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        cellStyle.setBottomBorderColor(IndexedColors.BLACK.index);
       // cellStyle.setBorderBottom(BorderStyle.THIN); //下边框
       // cellStyle.setBorderLeft(BorderStyle.THIN); //左边框
       // cellStyle.setBorderRight(BorderStyle.THIN); //右边框
       // cellStyle.setBorderTop(BorderStyle.THIN); //上边框

        HSSFFont headerFont = (HSSFFont) wb.createFont(); // 创建字体样式
        //headerFont.setBold(true); //字体加粗
        headerFont.setFontName("黑体"); // 设置字体类型
        headerFont.setFontHeightInPoints((short) 12); // 设置字体大小
        cellStyle.setFont(headerFont); // 为标题样式设置字体样式

        return cellStyle;
    }

    /**
     * 创建内容样式
     * @param wb
     * @return
     */
    private static HSSFCellStyle createContentCellStyle(HSSFWorkbook wb) {
        HSSFCellStyle cellStyle = wb.createCellStyle();
//        cellStyle.setVerticalAlignment(VerticalAlignment.CENTER);// 垂直居中
//        cellStyle.setAlignment(HorizontalAlignment.CENTER);// 水平居中
          cellStyle.setWrapText(true);// 设置自动换行
//        cellStyle.setBorderBottom(BorderStyle.THIN); //下边框
//        cellStyle.setBorderLeft(BorderStyle.THIN); //左边框
//        cellStyle.setBorderRight(BorderStyle.THIN); //右边框
//        cellStyle.setBorderTop(BorderStyle.THIN); //上边框

        // 生成12号字体
        HSSFFont font = wb.createFont();
        font.setColor((short)8);
        font.setFontHeightInPoints((short) 12);
        cellStyle.setFont(font);

        return cellStyle;
    }
}
