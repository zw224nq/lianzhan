package com.how2java.tmall.service;

import com.how2java.tmall.dao.CompanyCultureDao;
import com.how2java.tmall.dao.CompanySummaryDao;
import com.how2java.tmall.pojo.CompanyCulture;
import com.how2java.tmall.pojo.CompanySummary;
import com.how2java.tmall.pojo.Contact;
import com.how2java.tmall.util.Page4Navigator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class CompanySummaryService {

    @Autowired
    CompanySummaryDao companySummaryDao;


    public Page4Navigator<Contact> list(int start, int size, int navigatePages) {
        Sort sort = new Sort(Sort.Direction.DESC, "id");
        Pageable pageable = new PageRequest(start, size,sort);
        Page pageFromJPA =companySummaryDao.findAll(pageable);
        return new Page4Navigator<>(pageFromJPA,navigatePages);
    }


    public void add(CompanySummary bean) {
        companySummaryDao.save(bean);
    }

    public void delete(int id) {
        companySummaryDao.delete(id);

    }

    public CompanySummary get(int id){
        return companySummaryDao.findOne(id);
    }


    public void update(CompanySummary bean) {
        companySummaryDao.save(bean);
    }

}
