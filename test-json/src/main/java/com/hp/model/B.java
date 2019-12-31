package com.hp.model;

import lombok.Getter;
import lombok.Setter;

/**
 * @author hupan
 * @date 2018/12/04
 */
@Getter
@Setter
public class B {
    A a;

    public B(A a) {
        this.a = a;
    }

}
