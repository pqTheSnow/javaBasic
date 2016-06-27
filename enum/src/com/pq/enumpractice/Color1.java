package com.pq.enumpractice;

/**
 * Created by PQ on 2016/6/19.
 */
enum Color {
    RED("红色", 1), GREEN("绿色", 2), BLACK("黑色", 3), YELLOW("黄色", 4);
    // 成员变量
    private String name;
    private Integer index;

    // 构造函数，枚举类型只能为私有
    private Color(String name, Integer index){
        this.name = name;
        this.index = index;
    }

    public static String getName(Integer index){
        for (Color c : Color.values()) {// enum.values()方法获得枚举类型的实例
            if (c.getIndex() == index){// index应该是RED(String, Integer)中的整型
                return c.name;
            }
        }
        return null;
    }

    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
