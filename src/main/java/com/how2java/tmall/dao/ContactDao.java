package com.how2java.tmall.dao;

import com.how2java.tmall.pojo.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactDao extends JpaRepository<Contact,Integer> {

}
