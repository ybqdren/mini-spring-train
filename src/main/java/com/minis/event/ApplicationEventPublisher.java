package com.minis.event;

/**
 * @author ybqdren
 * @date 8/9/2023
 */
public interface ApplicationEventPublisher {
    void publishEvent(ApplicationEvent event);

}
