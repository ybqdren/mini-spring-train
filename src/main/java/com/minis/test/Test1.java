package com.minis.test;

import com.minis.context.ClassPathXmlApplicationContext;
import com.minis.core.BeansException;

/**
 * @author ybqdrena
 * @date 7/22/2023
 */
public class Test1 {
    public static void main(String[] args) throws BeansException {
        ClassPathXmlApplicationContext ctx
                = new ClassPathXmlApplicationContext("beans.xml");
        AService aservice = (AService) ctx.getBean("aservice");
        aservice.sayHello();
    }
}
