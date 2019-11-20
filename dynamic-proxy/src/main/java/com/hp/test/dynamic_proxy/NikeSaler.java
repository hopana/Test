package com.hp.test.dynamic_proxy;

/**
 * @author hupan
 * @date 2019-11-05 17:26
 */
public class NikeSaler implements Saler {

    @Override
    public void saleShoes() {
        System.out.println("销售耐克鞋子...");
    }

    @Override
    public void saleClothes() {
        System.out.println("销售耐克衣服...");
    }

}
