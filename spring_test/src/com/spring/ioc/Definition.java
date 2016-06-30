package com.spring.ioc;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by PQ on 2016/6/30.
 */
public class Definition {
    private String id;
    private String className;
    private List<ProsDefinition> properties = new ArrayList<ProsDefinition>();

    public Definition(String id, String className){
        this.id = id;
        this.className = className;
    }

    public String getId() {
        return id;
    }

    public String getClassName() {
        return className;
    }

    public List<ProsDefinition> getProperties() {
        return properties;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public void setProperties(List<ProsDefinition> properties) {
        this.properties = properties;
    }
}
