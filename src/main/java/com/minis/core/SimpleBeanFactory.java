package com.minis.core;

import com.minis.beans.BeanDefinition;

import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author ybqdren
 * @date 7/23/2023
 */

public class SimpleBeanFactory extends DefaultSingletonBeanRegistry implements BeanFactory {

    private Map<String, BeanDefinition> beanDefinitions = new ConcurrentHashMap<>();


    public SimpleBeanFactory() {

    }

    // getBean 容器的核心方法
    @Override
    public Object getBean(String beanName) throws BeansException {

        Object singleton = this.getSingleton(beanName);
        // 若没有这个 Bean 的实例，则获取它的定义来创建实例
        if (singleton == null) {
            BeanDefinition beanDefinition = beanDefinitions.get(beanName);
            if (Objects.isNull(beanDefinition)) {
                throw new BeansException("No bean.");
            }
            try {
                singleton = Class.forName(beanDefinition.getClassName()).newInstance();
            } catch (InstantiationException e) {
                throw new RuntimeException(e);
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }

            this.registerSingleton(beanName, singleton);
        }
        return singleton;
    }

    public void registerBeanDefinition(BeanDefinition beanDefinition) {
        this.beanDefinitions.put(
                beanDefinition.getId(),
                beanDefinition
        );
    }

    @Override
    public Boolean containsBean(String name) {
        return containsSingleton(name);
    }


    @Override
    public void registerBean(String beanName, Object object) {
        this.registerSingleton(beanName, object);
    }

}
