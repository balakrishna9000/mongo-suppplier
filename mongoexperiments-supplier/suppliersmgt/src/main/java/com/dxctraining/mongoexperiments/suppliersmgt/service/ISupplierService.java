package com.dxctraining.mongoexperiments.suppliersmgt.service;

import com.dxctraining.mongoexperiments.suppliersmgt.entities.Supplier;

import java.util.List;

public interface ISupplierService {

	Supplier add(Supplier supplier);

    Supplier findById(int id);

    void removeById(int id);

    List<Supplier> findAll();

    List<Supplier>findByname(String name);
}
