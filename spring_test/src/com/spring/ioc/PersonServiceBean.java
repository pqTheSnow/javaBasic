package com.spring.ioc;

/**
 * Created by PQ on 2016/6/30.
 */
public class PersonServiceBean implements PersonService {
    private PersonDao personDao;

    public void setPersonDao(PersonDao personDao) {
        this.personDao = personDao;
    }

    @Override
    public void save() {
        personDao.add();
    }
}
