package com.example.apptotem.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RequestFormat {
    @SerializedName("permitType")
    @Expose
    private String permitType;
    @SerializedName("startDate")
    @Expose
    private String startDate;
    @SerializedName("endDate")
    @Expose
    private String endDate;
    @SerializedName("employeeId")
    @Expose
    private Integer employeeId;

    public String getPermitType() {
        return permitType;
    }

    public void setPermitType(String permitType) {
        this.permitType = permitType;
    }

    public RequestFormat withPermitType(String permitType) {
        this.permitType = permitType;
        return this;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public RequestFormat withStartDate(String startDate) {
        this.startDate = startDate;
        return this;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public RequestFormat withEndDate(String endDate) {
        this.endDate = endDate;
        return this;
    }

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public RequestFormat withEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
        return this;
    }

    public RequestFormat(String permitType, String startDate, String endDate, Integer employeeId) {
        this.permitType = permitType;
        this.startDate = startDate;
        this.endDate = endDate;
        this.employeeId = employeeId;
    }
}
