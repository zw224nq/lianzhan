
package com.how2java.tmall.service;

import com.how2java.tmall.dao.ContactDao;
import com.how2java.tmall.pojo.Contact;

import com.how2java.tmall.pojo.User;
import com.how2java.tmall.util.Page4Navigator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;


@Service
public class ContactService {

    @Autowired ContactDao contactDao;


    public Page4Navigator<Contact> list(int start, int size, int navigatePages) {
        Sort sort = new Sort(Sort.Direction.DESC, "id");
        Pageable pageable = new PageRequest(start, size,sort);
        Page pageFromJPA =contactDao.findAll(pageable);
        return new Page4Navigator<>(pageFromJPA,navigatePages);
    }


    public void add(Contact bean) {
        contactDao.save(bean);
    }

    public void delete(int id) {
        contactDao.delete(id);

    }

    public Contact get(int id){
        return contactDao.findOne(id);
    }


    public void update(Contact bean) {
        contactDao.save(bean);
    }






}

