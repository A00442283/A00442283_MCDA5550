package com.example.demo.model;

public  enum GenderModel { 
	MALE(1), FEMALE(2), NONIDENTIFIED(3);
 
    private int code;
     
    GenderModel(int code) {
        this.code = code;
    }
 
    public int getCode() {
        return code;
    }

}
