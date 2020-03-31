package com.how2java.tmall.service;


import com.how2java.tmall.dao.LineDao;
import com.how2java.tmall.pojo.Line;
import com.how2java.tmall.util.Page4Navigator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class LineService {

    @Autowired
    LineDao lineDao;


    public Page4Navigator<Line> list(int start, int size, int navigatePages) {
        Sort sort = new Sort(Sort.Direction.DESC, "id");
        Pageable pageable = new PageRequest(start, size,sort);
        Page pageFromJPA =lineDao.findAll(pageable);
        return new Page4Navigator<>(pageFromJPA,navigatePages);
    }


    public void add(Line bean) {
        lineDao.save(bean);
    }

    public void delete(int id) {
        lineDao.delete(id);

    }

    public Line get(int id){
        return lineDao.findOne(id);
    }


    public void update(Line bean) {
        lineDao.save(bean);
    }




}
