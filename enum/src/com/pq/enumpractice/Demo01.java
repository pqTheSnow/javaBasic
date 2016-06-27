package com.pq.enumpractice;

/**
 * Created by PQ on 2016/6/19.
 */
public enum Demo01 {
    REDq("��ɫ", "1"), GREENq("��ɫ", "2"), BLACKq("��ɫ", "3"), YELLOWq("��ɫ", "4");
    // ��Ա����
    private String name;
    private String index;

    // ���캯����ö������ֻ��Ϊ˽��
    private Demo01(String name, String index){
        this.name = name;
        this.index = index;
    }

    public static String getName(String index){
        for (Demo01 c : Demo01.values()) {// enum.values()�������ö�����͵�ʵ��
            if (c.getIndex() == index){// indexӦ����RED(String, Integer)�е�����
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

