package com.minis.event;

import java.util.EventObject;

/**
 * @author ybqdren
 * @date 8/9/2023
 */
public class ApplicationEvent extends EventObject {
    private static final long serialVersionUID = 1L;

    public ApplicationEvent(Object arg0) {
        super(arg0);
    }
}
