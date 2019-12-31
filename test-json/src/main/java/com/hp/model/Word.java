package com.hp.model;

import lombok.Data;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author hupan
 * @date 2018/12/04
 */
@Data
public class Word {

    private String d;
    private String e;
    private String f;
    private String a;
    private int b;
    private boolean c;
    private Date date;
    private Map<String, Object> map;
    private List<User> list;
}