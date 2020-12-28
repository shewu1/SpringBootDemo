package com.wushe.springbootmybatisplus.generator;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.core.exceptions.MybatisPlusException;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.builder.ConfigBuilder;
import com.baomidou.mybatisplus.generator.config.rules.FileType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 * @Description:
 * @Copyright: Copyright (c) 2020  ALL RIGHTS RESERVED.
 * @Company: 成都旺小宝科技有限公司
 * @Author: jtb
 * @CreateDate: 2020/12/14 15:45
 * @UpdateDate: 2020/12/14 15:45
 * @UpdateRemark: init
 * @Version: 1.0
 * @menu
 */
public class MyBatisPlusGenerator {
    public static void main(String[] args) throws IOException {
        // 代码生成器
        AutoGenerator ag = new AutoGenerator();

        //1. 全局配置
        GlobalConfig config = new GlobalConfig();
        String projectPath = System.getProperty("user.dir")+"/spring-boot-mybatis-plus";//获取当前项目的路径
        System.out.println("projectPath="+projectPath);
        //config.setActiveRecord(true); // 是否支持AR模式
        config.setAuthor("jtb") ;// 作者
        config.setOpen(false);
        config.setOutputDir(projectPath + "/src/main/java");//配置生成的代码目录
        // config.setFileOverride(true);  // 文件覆盖
        config.setIdType(IdType.AUTO) ;// 主键策略
        // 自定义文件命名，注意 %s 会自动填充表实体属性！
        config.setMapperName("%sMapper");
        config.setXmlName("%sMapper");
        config.setServiceName("%sService");
        config.setServiceImplName("%sServiceImpl");
        config.setEntityName("%sBean");
        config.setBaseResultMap(true);//生成基本的resultMap
        config.setBaseColumnList(true);//生成基本的SQL片段
        config.setEnableCache(false);// XML 二级缓存
        ag.setGlobalConfig(config);

        //2. 数据源配置
        DataSourceConfig dsConfig  = new DataSourceConfig();
        dsConfig.setDbType(DbType.MYSQL); // 设置数据库类型
        dsConfig.setDriverName("com.mysql.cj.jdbc.Driver");
        dsConfig.setUsername("root");
        dsConfig.setPassword("UmMtAvFl");
        dsConfig.setUrl(
                "jdbc:mysql://vrmysql.source3g.com:3306/vr?useUnicode=true&characterEncoding=utf8&useSSL=false&serverTimezone=Asia/Shanghai&allowPublicKeyRetrieval=true");
        ag.setDataSource(dsConfig);

        //4. 包名策略配置
        PackageConfig pc = new PackageConfig();
       /* pkConfig.setParent("com.haoyi")
                .setMapper("mapper")//dao
                .setService("service")//servcie
                .setController("controller")//controller
                .setEntity("entity")
                .setXml("mapper");//mapper.xml*/
        String moduleName = scanner("角色名");//模块名可根据实际情况是否需要
        pc.setParent("com.wushe.springbootmybatisplus");//自己的包名
        //配置路径
        pc.setEntity("model");
        pc.setMapper("mapper." + moduleName);
        pc.setService("service");
        pc.setServiceImpl("service.impl");
        pc.setXml("mapper."+moduleName);
        //pc.setController()
        //pc.setService("service." + moduleName);
        //pc.setServiceImpl("service." + moduleName + ".impl");

        //不生成Controller 和 xml 两个命名的包(不是指**Controller.java 和 *.xml文件)
        //因为我们项目没有Controller层 和使用的是MyBatis的注解,所以不需要生成Controller和XML文件

        ag.setPackageInfo(pc);


        // 自定义配置
        InjectionConfig cfg = new InjectionConfig() {
            @Override
            public void initMap() {
                // to do nothing
            }
        };

        cfg.setFileCreate(new IFileCreate() {
            @Override
            public boolean isCreate(ConfigBuilder configBuilder, FileType fileType, String filePath) {
                //这里配置不想生成的文件类型
                //不生成controller文件
                if (fileType == FileType.CONTROLLER) {
                    return false;
                }
                // 允许生成模板文件
                return true;
            }
        });

        ag.setCfg(cfg);

        //3. 策略配置globalConfiguration中
        StrategyConfig stConfig = new StrategyConfig();
        //stConfig.setCapitalMode(true); //全局大写命名
        // stConfig.setDbColumnUnderline(true);  // 指定表名 字段名是否使用下划线
        stConfig.setNaming(NamingStrategy.underline_to_camel);// 数据库表映射到实体的命名策略
        stConfig.setColumnNaming(NamingStrategy.underline_to_camel);
        // 此处可以修改为您的表前缀
        //stConfig.setTablePrefix("tbl_");
        // stConfig.setInclude(new String[] { "hy_doctor","hy_dept"}); // 需要生成的表
        stConfig.setEntityLombokModel(true);
        stConfig.setEntityBuilderModel(true);
        stConfig.setInclude(scanner("表名，多个英文逗号分割").split(","));
//        strategy.setControllerMappingHyphenStyle(true);
        // 此处可以修改为您的表前缀
//        strategy.setTablePrefix(pc.getModuleName() + "_");
        // strategy.setTablePrefix("t_");
        ag.setStrategy(stConfig);
        ag.setTemplateEngine(new FreemarkerTemplateEngine());


        //5. 执行
        ag.execute();
    }


    /**
     * <p>
     * 读取控制台内容,用于自己输入要生成的模块(生成后以文件夹形式)和表名
     * </p>
     */
    public static String scanner(String tip) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder help = new StringBuilder();
        help.append("请输入" + tip + "：");
        System.out.println(help.toString());
        if (scanner.hasNext()) {
            String ipt = scanner.next();
            if (StringUtils.isNotEmpty(ipt)) {
                return ipt;
            }
        }
        throw new MybatisPlusException("请输入正确的" + tip + "！");
    }
}
