package com.hp.test.dynamic_proxy;

import java.lang.reflect.Proxy;

/**
 * @author hupan
 * @date 2019-11-05 17:28
 */
public class Main {

    public static void main(String[] args) {
        NikeSaler nike = new NikeSaler();
        UniqloSaler uniqlo = new UniqloSaler();

        ProxySaler nikeProxy = new ProxySaler(nike);
        ProxySaler uniqloProxy = new ProxySaler(uniqlo);

        Saler nikeSaler = (Saler) Proxy.newProxyInstance(nike.getClass().getClassLoader(), nike.getClass()
                                                                                               .getInterfaces(), nikeProxy);
        Saler uniqloSaler = (Saler) Proxy.newProxyInstance(uniqlo.getClass().getClassLoader(), uniqlo.getClass()
                                                                                                     .getInterfaces(), uniqloProxy);
        nikeSaler.saleClothes();
        uniqloSaler.saleShoes();
    }
}