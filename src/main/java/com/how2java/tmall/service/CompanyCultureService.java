package com.how2java.tmall.service;

import com.how2java.tmall.dao.CompanyCultureDao;
import com.how2java.tmall.dao.ContactDao;
import com.how2java.tmall.pojo.CompanyCulture;
import com.how2java.tmall.pojo.Contact;
import com.how2java.tmall.util.Page4Navigator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class CompanyCultureService {


    @Autowired
    CompanyCultureDao companyCultureDao;


    public Page4Navigator<Contact> list(int start, int size, int navigatePages) {
        Sort sort = new Sort(Sort.Direction.DESC, "id");
        Pageable pageable = new PageRequest(start, size,sort);
        Page pageFromJPA =companyCultureDao.findAll(pageable);
        return new Page4Navigator<>(pageFromJPA,navigatePages);
    }


    public void add(CompanyCulture bean) {
        companyCultureDao.save(bean);
    }

    public void delete(int id) {
        companyCultureDao.delete(id);

    }

    public CompanyCulture get(int id){
        return companyCultureDao.findOne(id);
    }


    public void update(CompanyCulture bean) {
        companyCultureDao.save(bean);
    }

}
