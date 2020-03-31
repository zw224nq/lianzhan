package com.how2java.tmall.service;

import com.how2java.tmall.dao.AcceptDao;
import com.how2java.tmall.dao.NewDao;
import com.how2java.tmall.pojo.Accept;
import com.how2java.tmall.pojo.Contact;
import com.how2java.tmall.pojo.New;
import com.how2java.tmall.util.Page4Navigator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class AcceptService {

    @Autowired
    AcceptDao acceptDao;


    public Page4Navigator<Contact> list(int start, int size, int navigatePages) {
        Sort sort = new Sort(Sort.Direction.DESC, "id");
        Pageable pageable = new PageRequest(start, size,sort);
        Page pageFromJPA =acceptDao.findAll(pageable);
        return new Page4Navigator<>(pageFromJPA,navigatePages);
    }


    public void add(Accept bean) {
        acceptDao.save(bean);
    }

    public void delete(int id) {
        acceptDao.delete(id);

    }

    public Accept get(int id){
        return acceptDao.findOne(id);
    }


    public void update(Accept bean) {
        acceptDao.save(bean);
    }




}
