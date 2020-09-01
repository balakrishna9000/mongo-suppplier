package com.dxctraining.mongoexperiments.suppliersmgt.service;
import com.dxctraining.mongoexperiments.suppliersmgt.entities.Supplier;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.AutoConfigureDataMongo;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.context.annotation.Import;
import org.springframework.data.mongodb.core.MongoTemplate;

import java.util.List;

@DataMongoTest
@Import(SupplierRepositoryServiceImpl.class)
public class SupplierServiceImplTest {

    @Autowired
    private ISupplierService supplierService;

    @Autowired
    private MongoTemplate mongo;

    /**
     * case : employee successfully added
     * precondition: supplier doesn't exist before
     * verifying: stored employee contains expected details
     */
    @Test
    public void testSave_1(){
        String name="balakrishna";
        int id=1;
        Supplier supplier1=new Supplier(name);
        supplier1=supplierService.add(supplier1);
        int id1=supplier1.getId();
        Supplier fetched=mongo.findById(id1,Supplier.class);
        Assertions.assertEquals(supplier1.getId(),fetched.getId());
        Assertions.assertEquals(name,supplier1.getName());
          }

    /**
     * case: supplier exists in store,
     * precondition:supplier added in store
     * verifying: fetched supplier has same details as stored supplier
     */
    @Test
    public void findById_2(){
        String name="krishna";
        int id=2;
        Supplier supplier1=new Supplier(name);
        supplier1=((ISupplierService) mongo).add(supplier1);
        Supplier fetched=supplierService.findById(supplier1.getId());
        Assertions.assertEquals(name, fetched.getName());
        Assertions.assertEquals(supplier1.getId(),fetched.getId());

    }


}
