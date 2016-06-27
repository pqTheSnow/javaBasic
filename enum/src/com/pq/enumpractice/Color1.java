package com.pq.enumpractice;

/**
 * Created by PQ on 2016/6/19.
 */
enum Color {
    RED("��ɫ", 1), GREEN("��ɫ", 2), BLACK("��ɫ", 3), YELLOW("��ɫ", 4);
    // ��Ա����
    private String name;
    private Integer index;

    // ���캯����ö������ֻ��Ϊ˽��
    private Color(String name, Integer index){
        this.name = name;
        this.index = index;
    }

    public static String getName(Integer index){
        for (Color c : Color.values()) {// enum.values()�������ö�����͵�ʵ��
            if (c.getIndex() == index){// indexӦ����RED(String, Integer)�е�����
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
