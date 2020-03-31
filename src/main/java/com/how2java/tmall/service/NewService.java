package com.how2java.tmall.service;

import com.how2java.tmall.dao.ContactDao;
import com.how2java.tmall.dao.NewDao;
import com.how2java.tmall.pojo.Contact;
import com.how2java.tmall.pojo.New;
import com.how2java.tmall.util.Page4Navigator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NewService {

    @Autowired
    NewDao newDao;


    public Page4Navigator<New> list(int start, int size, int navigatePages) {
        Sort sort = new Sort(Sort.Direction.DESC, "id");
        Pageable pageable = new PageRequest(start, size,sort);
        Page pageFromJPA =newDao.findAll(pageable);
        return new Page4Navigator<>(pageFromJPA,navigatePages);
    }


    public void add(New bean) {
        newDao.save(bean);
    }

    public void delete(int id) {
        newDao.delete(id);

    }

    public New get(int id){
        return newDao.findOne(id);
    }

    public void update(New bean) {
        newDao.save(bean);
    }

   //根据id查询姓名
    public List<New> findNameById(int id){
      return   newDao.findNameById(id);
    }



   public  List<New> findContent(){

        return newDao.findContent();
   }

    public  List<New> findTitle(){

        return newDao.findTitle();
    }


}
