package com.dxctraining.mongoexperiments.suppliersmgt.dao;


import com.dxctraining.mongoexperiments.suppliersmgt.entities.Supplier;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface ISupplierDao extends MongoRepository<Supplier, String> {

    List<Supplier> findById(int id);

	Supplier add(Supplier supplier);

    void removeById(int id);

    List<Supplier> findAll();

    List<Supplier>findByname(String name);

}
