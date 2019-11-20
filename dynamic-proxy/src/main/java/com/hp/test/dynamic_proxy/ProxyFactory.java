package com.hp.test.dynamic_proxy;

import java.lang.reflect.Proxy;

public class ProxyFactory {

    public static <T> T getProxy(final Class interfaceClass) {
        return (T) Proxy.newProxyInstance(interfaceClass.getClassLoader(), new Class[]{interfaceClass}, (proxy, method, args) -> method.invoke(interfaceClass, args));
    }
}
