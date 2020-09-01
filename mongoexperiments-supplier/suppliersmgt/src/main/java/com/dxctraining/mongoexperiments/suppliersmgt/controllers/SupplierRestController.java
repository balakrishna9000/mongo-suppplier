package com.dxctraining.mongoexperiments.suppliersmgt.controllers;

import com.dxctraining.mongoexperiments.suppliersmgt.dto.CreateSupplierRequest;
import com.dxctraining.mongoexperiments.suppliersmgt.dto.SupplierDto;
import com.dxctraining.mongoexperiments.suppliersmgt.entities.Supplier;
import com.dxctraining.mongoexperiments.suppliersmgt.service.ISupplierService;
import com.dxctraining.mongoexperiments.suppliersmgt.util.SupplierUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/suppliers")
@RestController
public class SupplierRestController {

    @Autowired
    private ISupplierService service;

    @Autowired
    private SupplierUtil util;

    /*
      uri is /suppliers/add
      url http://localhost:8585/suppliers/add
   */
    @PostMapping(value = "/add")
    @ResponseStatus(HttpStatus.CREATED)
    public SupplierDto create(@RequestBody CreateSupplierRequest requestData) {
    	Supplier supplier=new Supplier( requestData.getName());
    	supplier=service.add(supplier);
    	SupplierDto response=util.supplierDto(supplier);
        return response;
    }


    /*
    uri is /employees/get
   request parameter  /employees/get?id=10
   path variable /employees/get/10
     */
    @GetMapping("/get/{id}")
    public SupplierDto findSupplier(@PathVariable("id") int id) {
    	Supplier supplier = service.findById(id);
    	SupplierDto response = util.supplierDto(supplier);
        return response;
    }


}
