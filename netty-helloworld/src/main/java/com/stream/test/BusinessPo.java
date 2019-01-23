package com.stream.test;


public class BusinessPo {
    private int businessId;
    private String businessName;

    public int getBusinessId() {
        return businessId;
    }

    public void setBusinessId(int businessId) {
        this.businessId = businessId;
    }

    public String getBusinessName() {
        return businessName;
    }

    public void setBusinessName(String businessName) {
        this.businessName = businessName;
    }

    public BusinessPo(int businessId, String businessName) {
        this.businessId = businessId;
        this.businessName = businessName;
    }
}
