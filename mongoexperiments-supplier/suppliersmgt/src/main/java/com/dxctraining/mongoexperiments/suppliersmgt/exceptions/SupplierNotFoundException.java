package com.dxctraining.mongoexperiments.suppliersmgt.exceptions;

public class SupplierNotFoundException extends RuntimeException{

    public SupplierNotFoundException(String msg){
        super(msg);
    }

}
