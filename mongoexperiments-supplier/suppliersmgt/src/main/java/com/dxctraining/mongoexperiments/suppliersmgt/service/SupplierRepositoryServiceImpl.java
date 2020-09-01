package com.dxctraining.mongoexperiments.suppliersmgt.service;

import com.dxctraining.mongoexperiments.suppliersmgt.dao.ISupplierDao;
import com.dxctraining.mongoexperiments.suppliersmgt.entities.Supplier;
import com.dxctraining.mongoexperiments.suppliersmgt.exceptions.SupplierNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SupplierRepositoryServiceImpl implements ISupplierService {

    @Autowired
    private ISupplierDao dao;


    @Override
    public Supplier save(Supplier supplier) {
    	supplier = dao.save(supplier);
        return supplier;
    }

    @Override
    public Supplier findById(int id) {
        Optional<Supplier> optional = dao.findById(id);
        boolean exist = optional.isPresent();
        if (!exist) {
            throw new SupplierNotFoundException("supplier not found for id=" + id);
        }
        Supplier supplier = optional.get();
        return supplier;
    }


    @Override
    public List<Supplier> findAll() {
        List<Supplier> list = dao.findAll();
        return list;
    }
    @Override
    public List<Supplier>findByame(String name){
        List<Supplier>list=dao.findByname(name);
        return list;
    }
    @Override
    public void removeById(int id) {
        dao.deleteById(id);
    }
}
