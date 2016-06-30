package com.spring.ioc;

/**
 * Created by PQ on 2016/6/30
 * 存放属性的对象.
 */
public class ProsDefinition {
    private String name;
    private String ref;

    public ProsDefinition(String name, String ref){
        this.name = name;
        this.ref = ref;
    }

    public String getName() {
        return name;
    }

    public String getRef() {
        return ref;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRef(String ref) {
        this.ref = ref;
    }
}
