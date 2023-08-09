package com.minis.core;

import com.minis.beans.BeanDefinition;
import org.dom4j.Element;

/**
 * 将 XML 转换为 BeanDefinition
 *
 * @author ybqdren
 * @date 7/23/2023
 */


public class XmlBeanDefinitionReader {
    SimpleBeanFactory simpleBeanFactory;

    public XmlBeanDefinitionReader(SimpleBeanFactory simpleBeanFactory) {
        this.simpleBeanFactory = simpleBeanFactory;
    }

    /**
     * 把解析的 XML 内容转换成 BeanDefinition，并加载到 BeanFactory 中
     */
    public void loadBeanDefinitions(Resource resource) {
        while (resource.hasNext()) {
            Element element = (Element) resource.next();
            String beanId = element.attributeValue("id");
            String beanClassName = element.attributeValue("class");
            BeanDefinition beanDefinition = new BeanDefinition(beanId, beanClassName);
            this.simpleBeanFactory.registerBeanDefinition(beanDefinition);
        }
    }
}
