package com.loeo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.loeo.common.uniquekey.IdGererateFactory;
import com.loeo.test.TestBeanPostProcessor;

/**
 * 功能：
 *
 * @author：LT(286269159@qq.com)
 * @create：2017-06-14 10:05:36
 * @version：2017 Version：1.0
 * @company：创海科技 Created with IntelliJ IDEA
 */

@Configuration
public class AppConfig {
    @Bean
    public TestBeanPostProcessor testBeanPostProcessor() {
        return new TestBeanPostProcessor();
    }

    @Bean
    public IdGererateFactory idGererateFactory() {
        return new IdGererateFactory(1L);
    }
}
