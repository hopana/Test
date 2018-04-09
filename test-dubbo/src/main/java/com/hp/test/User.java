package com.hp.test;  
  
import java.io.Serializable;  
  
  
//必须实现Serializable接口  
public class User implements Serializable {  
    private static final long serialVersionUID = -2814022769568306965L;  
    private String name;  
    private Integer age;  
    private String sex;  
  
    public String getName() {  
        return name;  
    }  
  
    public void setName(String name) {  
        this.name = name;  
    }  
  
    public Integer getAge() {  
        return age;  
    }  
  
    public void setAge(Integer age) {  
        this.age = age;  
    }  
  
    public String getSex() {  
        return sex;  
    }  
  
    public void setSex(String sex) {  
        this.sex = sex;  
    }  
  
  
    @Override  
    public String toString() {  
        return "User{" +  
                "name='" + name + '\'' +  
                ", age=" + age +  
                ", sex='" + sex + '\'' +  
                '}';  
    }  
}