package com.wushe.controller;

import com.wushe.config.ExcelUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Description:
 * @Copyright: Copyright (c) 2020  ALL RIGHTS RESERVED.
 * @Company: 成都旺小宝科技有限公司
 * @Author: jtb
 * @CreateDate: 2020/12/9 10:44
 * @UpdateDate: 2020/12/9 10:44
 * @UpdateRemark: init
 * @Version: 1.0
 * @menu
 */
@RestController
public class ExportExcelController {
    @Autowired
    ExcelUtil excelUtil;

    @RequestMapping("/e")
    public void export(HttpServletRequest request, HttpServletResponse response){
        excelUtil.exportExcel(response);
    }

}
