package com.bortnichuk.model.handler;

import com.bortnichuk.model.exception.SetterCalledException;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class MyInvocationHandler implements InvocationHandler {

    private Object object;

    public MyInvocationHandler(Object object) {
        this.object = object;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if(method.getName().startsWith("set")){
            throw new SetterCalledException();
        }

        return method.invoke(object, args);
    }
}
