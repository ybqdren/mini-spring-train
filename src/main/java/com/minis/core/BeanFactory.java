package com.minis.core;

import com.minis.beans.BeanDefinition;

/**
 * 特性：
 * 1. 获取一个 Bean
 * 2. 注册一个 BeanDefinition
 *
 * @author ybqdren
 * @date 7/23/2023
 */
public interface BeanFactory {
    Object getBean(String beanName) throws BeansException;

    Boolean containsBean(String name);

    void registerBean(
            String beanName,
            Object obj
    );
}
