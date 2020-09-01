package com.dxctraining.mongoexperiments.suppliersmgt.dto;

public class SupplierDto {
    private int id;

    private String name;

    public SupplierDto(){

    }

    public SupplierDto(int id, String name){
        this.id=id;
        this.name=name;
       }

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
