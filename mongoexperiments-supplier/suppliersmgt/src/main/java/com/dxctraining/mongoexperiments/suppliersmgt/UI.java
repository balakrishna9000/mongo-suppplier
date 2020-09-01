package com.dxctraining.mongoexperiments.suppliersmgt;
import com.dxctraining.mongoexperiments.suppliersmgt.entities.Supplier;
import com.dxctraining.mongoexperiments.suppliersmgt.service.ISupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;

@Component
public class UI {
    @Autowired
    private ISupplierService service;


    @PostConstruct
    public void start() {
    	Supplier supplier1 = new Supplier("ravi");
    	supplier1 = createSupplier(supplier1);
       
        Supplier supplier2 = new Supplier("ramu");
        supplier2 = createSupplier(supplier2);
        Supplier supplier3 = new Supplier("balakrishna");
        supplier3 = createSupplier(supplier3);

        String id2 = supplier2.getId();
        displaySupplierById(id1);
        displaySupplierById(id2);
        displayAll();

        
        void displayAll(){
      System.out.println("********displayAll");
      List<Supplier>list=  service.findAll();
      for (Supplier supplier:list){
          displaySupplier(supplier);
      }
    }

    void displaySupplier(Supplier supplier) {
        System.out.println("supplier="+supplier.getId());
    }

    public void displaySupplierById(String id) {
        System.out.println("*****displaySupplierById");
        Supplier supplier = service.findByName(id);
        displaySupplier(supplier);
    }


    public Supplier createSupplier(Supplier supplier) {
        System.out.println("*********createsupplier");
        supplier = service.add(supplier);
        displaySupplier(supplier);
        return supplier;
    }
}