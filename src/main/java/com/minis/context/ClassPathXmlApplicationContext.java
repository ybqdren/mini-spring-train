package com.minis.context;

import com.minis.beans.BeanDefinition;
import com.minis.core.*;


/**
 * 解析 XML 文件来构建应用上下文
 *
 * @author ybqdren
 * @date 7/22/2023
 */


public class ClassPathXmlApplicationContext implements BeanFactory {
    BeanFactory beanFactory;


    // context 负责整合容器的启动过程，读外部配置，解析 Bean 定义，创建 BeanFactory
    public ClassPathXmlApplicationContext(String fileName) {
        ClassPathXmlResource resource = new ClassPathXmlResource(fileName);
        SimpleBeanFactory beanFactory = new SimpleBeanFactory();
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(beanFactory);
        reader.loadBeanDefinitions(resource);
        this.beanFactory = beanFactory;
    }

    /**
     * context 再对外提供一个 getBean ，底下即使调用的 BeanFactory 对应的方法
     */
    public Object getBean(String beanName) throws BeansException {
        return this.beanFactory.getBean(beanName);
    }

    @Override
    public Boolean containsBean(String name) {
        return this.beanFactory.containsBean(name);
    }

    @Override
    public void registerBean(String beanName,Object object) {
        this.beanFactory.registerBean(beanName , object);
    }
}
