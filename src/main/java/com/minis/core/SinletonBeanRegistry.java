package com.minis.core;

/**
 *
 * 名称中带有 Registry，表示里面存储的就是 Bean
 *
 * @author ybqdren
 * @date 8/9/2023
 */


public interface SinletonBeanRegistry {
    void registerSingleton(String beanName, Object sinletonObject);

    Object getSingleton(String beanName);

    boolean containsSingleton(String beanName);

    String[] getSingletonNames();
}
