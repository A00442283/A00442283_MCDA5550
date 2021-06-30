package com.example.demo.model;

public enum GenderModel {
	
	Male(1), Female(2), NonIdentified(3);
	 
    private int code;
     
    GenderModel(int code) {
        this.code = code;
    }
 
    public int getCode() {
        return code;
    }

}
