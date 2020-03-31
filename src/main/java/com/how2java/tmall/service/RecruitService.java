package com.how2java.tmall.service;

import com.how2java.tmall.dao.NewDao;
import com.how2java.tmall.dao.RecruitDao;
import com.how2java.tmall.pojo.Contact;
import com.how2java.tmall.pojo.New;
import com.how2java.tmall.pojo.Recruit;
import com.how2java.tmall.util.Page4Navigator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class RecruitService {



    @Autowired
    RecruitDao recruitDao;


    public Page4Navigator<Recruit> list(int start, int size, int navigatePages) {
        Sort sort = new Sort(Sort.Direction.DESC, "id");
        Pageable pageable = new PageRequest(start, size,sort);
        Page pageFromJPA =recruitDao.findAll(pageable);
        return new Page4Navigator<>(pageFromJPA,navigatePages);
    }


    public void add(Recruit bean) {
        recruitDao.save(bean);
    }

    public void delete(int id) {
        recruitDao.delete(id);

    }

    public Recruit get(int id){
        return recruitDao.findOne(id);
    }


    public void update(Recruit bean) {
        recruitDao.save(bean);
    }
}
