package com.pq.enumpractice;

/**
 * Created by PQ on 2016/6/19.
 */
public enum Demo01 {
    REDq("红色", "1"), GREENq("绿色", "2"), BLACKq("黑色", "3"), YELLOWq("黄色", "4");
    // 成员变量
    private String name;
    private String index;

    // 构造函数，枚举类型只能为私有
    private Demo01(String name, String index){
        this.name = name;
        this.index = index;
    }

    public static String getName(String index){
        for (Demo01 c : Demo01.values()) {// enum.values()方法获得枚举类型的实例
            if (c.getIndex() == index){// index应该是RED(String, Integer)中的整型
                return c.name;
            }
        }
        return null;
    }

    public String getIndex() {
        return index;
    }

    public void setIndex(String index) {
        this.index = index;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

