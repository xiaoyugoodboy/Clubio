package com.clubio.auto;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.engine.VelocityTemplateEngine;

import java.util.*;

/**
 * @author Smile
 * @date 2023-10-15 21:18
 */
public class MybatisPlusCodeGenerator {
    /**
     * 数据源配置
     *
     * */
    private static final String URL = "jdbc:mysql://localhost:3307/clubio?useUnicode=true&characterEncoding=UTF-8&serverTimezone=GMT%2B8";
    private static final String username = "root";
    private static final String password = "123456";
    /**
     * 当前项目的根路径
     */
    private static final String projectPath = System.getProperty("user.dir")+"\\Clubio\\";

    public static void main(String[] args) {
        System.out.println(projectPath);
        FastAutoGenerator.create(URL, username, password)
                // 全局配置
                .globalConfig(builder -> {
                    builder.author("Smile")   // 作者
                            .fileOverride()    // 覆盖已生成文件
                            .outputDir( projectPath+"/src/main/java")     // 指定输出目录
                            .enableSwagger()   // 开启 swagger 的 api
                            .disableOpenDir()  // 禁止打开输出目录
                            .dateType(DateType.ONLY_DATE) // 时间策略
                            .commentDate("yyyy-MM-dd") //注释日期
                            .build();
                })
                // 包配置
                .packageConfig(builder -> {
                    builder.parent("com.clubio")   // 父包名
                            .moduleName("")                 // 父包模块名
                            .entity("entity")               // Entity 包名
                            .service("service")             // service 包名
                            .serviceImpl("service.impl")    //
                            .mapper("mapper")               //
                            .xml("mapper.xml")              // MapperXML 包名
                            .controller("controller")       //
                            .pathInfo(Collections.singletonMap(OutputFile.xml, projectPath+"/src/main/resources/mapper")) // 自定义某个文件的路径
                            .build();
                })
                // 策略配置
                .strategyConfig(builder -> {
                    builder.addTablePrefix("%")
                            .entityBuilder()  // 实体类配置
                            .enableTableFieldAnnotation()
                            .idType(IdType.ASSIGN_ID)//全局主键类型
                            .controllerBuilder() // controller 接口配置
                            .enableHyphenStyle() // 开启驼峰转连字符
                            .enableRestStyle()
                            .serviceBuilder() // service 配置
                            .formatServiceFileName("%sService")
                            .formatServiceImplFileName("%sServiceImpl")
                            .mapperBuilder()  //mapper 配置
                            .superClass(BaseMapper.class)
                            .enableMapperAnnotation()
                            .enableBaseResultMap()
                            .enableBaseColumnList()
                            .formatMapperFileName("%sMapper")
                            .formatXmlFileName("%sMapper")//这个是xml
                            .build();
                })
                // 模板配置
                .templateEngine(new VelocityTemplateEngine()) // 默认
                .templateConfig(builder -> {
                    builder.controller("/templates/controller.java") // 自定义 controller 模板
                            .build();
                })
                .execute();
    }
}
