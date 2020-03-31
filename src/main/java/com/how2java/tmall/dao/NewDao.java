package com.how2java.tmall.dao;

import com.how2java.tmall.pojo.New;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface NewDao extends JpaRepository<New,Integer> {

    @Query(value="SELECT title from New N where N.id=?1")
    List<New> findNameById(int id);

    @Query(value="SELECT content from New ")
    List<New> findContent();


    @Query(value="SELECT title from New ")
    List<New> findTitle();


}
