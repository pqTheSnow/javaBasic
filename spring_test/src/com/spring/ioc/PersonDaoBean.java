package com.spring.ioc;

/**
 * Created by PQ on 2016/6/30.
 */
public class PersonDaoBean implements PersonDao {
    @Override
    public void add() {
        System.out.println("Ö´ÐÐadd()·½·¨");
    }
}
