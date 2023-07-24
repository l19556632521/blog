package com.lmeng.blog.config;

import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @version 1.0
 * @learner Lmeng
 * @date 2023/7/24
 */
@Configuration
@MapperScan("com.lmeng.blog.mapper")
public class MyBatisPlusConfig {

    //MyBatisPlus的分页插件
    @Bean
    public MybatisPlusInterceptor mybatisPlusInterceptor() {
        //新建拦截器
        MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();
        interceptor.addInnerInterceptor(new PaginationInnerInterceptor());
        return interceptor;
    }
}
