package com.minis.core;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author ybqdren
 * @date 8/9/2023
 */
public class DefaultSingletonBeanRegistry implements SinletonBeanRegistry {

    // 容器中存放所有 bean 的名称的列表
    protected List<String> beanNames = new ArrayList<>();

    // 容器中存放所有 bean 实例的 map
    protected Map<String, Object> singletons = new ConcurrentHashMap<>(256);

    @Override
    public void registerSingleton(String beanName, Object sinletonObject) {
        // 保证一个应用中的 Bean 是唯一的、单例的
        synchronized (this.singletons) {
            this.singletons.put(beanName, sinletonObject);
            this.beanNames.add(beanName);
        }
    }

    @Override
    public Object getSingleton(String beanName) {
        return this.singletons.get(beanName);
    }

    @Override
    public boolean containsSingleton(String beanName) {
        return this.singletons.containsKey(beanName);
    }

    @Override
    public String[] getSingletonNames() {
        return (String[]) this.beanNames.toArray();
    }

    protected void removeSingleton(String beanName) {
        synchronized (this.singletons) {
            this.beanNames.remove(beanName);
            this.singletons.remove(beanName);
        }
    }
}
