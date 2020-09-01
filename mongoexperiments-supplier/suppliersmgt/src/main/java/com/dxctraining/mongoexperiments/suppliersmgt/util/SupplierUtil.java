package com.dxctraining.mongoexperiments.suppliersmgt.util;

import com.dxctraining.mongoexperiments.suppliersmgt.dto.SupplierDto;
import com.dxctraining.mongoexperiments.suppliersmgt.entities.Supplier;
import org.springframework.stereotype.Component;

@Component
public class SupplierUtil {

    public SupplierDto supplierDto(Supplier supplier){
    	SupplierDto dto=new SupplierDto(supplier.getId(),supplier.getname());
        return dto;
    }

}
