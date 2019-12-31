package com.hp.test.dynamic_proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author hupan
 * @date 2019-11-05 17:27
 */
public class ProxySaler implements InvocationHandler {

    private Saler saler;

    public ProxySaler(Saler saler) {
        this.saler = saler;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("---------渠道进货---------");
        Object result = method.invoke(saler, args);
        System.out.println("---------更新库存---------");
        return result;
    }

}