package com.zoengsihou.mall.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * MyBatis配置类
 * @author zoengsihou
 */

@Configuration
@MapperScan({"com.zoengsihou.mall.mapper", "com.zoengsihou.mall.dao"})
public class MyBatisConfig {
}
