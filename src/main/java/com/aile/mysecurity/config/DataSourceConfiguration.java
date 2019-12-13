package com.aile.mysecurity.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @Author aile
 * @Date 2019/12/13 12:52
 */
@Configuration
@MapperScan("com.aile.mysecurity.**.mapper")
public class DataSourceConfiguration {
}
