package com.dxctraining.mongoexperiments.suppliersmgt.service;

import com.dxctraining.mongoexperiments.suppliersmgt.entities.Supplier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;

//@Service
public class SupplierServiceImpl implements ISupplierService {

    @Autowired
    private MongoTemplate mongo;

    @Override
    public Supplier add(Supplier supplier) {
        System.out.println("using mongotemplate add");
        supplier = mongo.save(supplier);
        return supplier;
    }

    @Override
    public Supplier findById(int id) {
    	supplier supplier = mongo.findById(id, supplier.class);
        return supplier;
    }

    @Override
    public void removeById(int id) {
    	Supplier supplier=findById(id);
        mongo.remove(supplier);
        /*
        Criteria criteria=Criteria.where("id").is(id);
        Query query=Query.query(criteria);
        mongo.findAndRemove(query,supplier.class);
       */
    }

    @Override
    public List<Supplier> findAll() {
        List<Supplier> list = mongo.findAll(Supplier.class);
        return list;
    }

    
    @Override
    public List<Supplier> findByname(String name) {
        Criteria criteria=Criteria.where("name").is(name) ;
        Query query = Query.query(criteria);
        List<Supplier> list = mongo.find(query, Supplier.class);
        return list;
    }
}
