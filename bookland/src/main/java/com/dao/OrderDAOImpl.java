package com.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.model.*;
import org.hibernate.Session;


@Repository
@Transactional
public class OrderDAOImpl {
	
	@Autowired
    SessionFactory sessionFactory;

    public void addCustomerOrder(Order customerOrder){
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(customerOrder);
        session.flush();
    }


}
