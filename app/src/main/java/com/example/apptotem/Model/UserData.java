package com.example.apptotem.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class UserData {

    @SerializedName("username")
    @Expose
    private String username;
    @SerializedName("employee")
    @Expose
    private Employee employee;
    @SerializedName("supplier")
    @Expose
    private Object supplier;
    @SerializedName("authorities")
    @Expose
    private List<String> authorities = null;
    @SerializedName("firstAccess")
    @Expose
    private Boolean firstAccess;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public UserData withUsername(String username) {
        this.username = username;
        return this;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public UserData withEmployee(Employee employee) {
        this.employee = employee;
        return this;
    }

    public Object getSupplier() {
        return supplier;
    }

    public void setSupplier(Object supplier) {
        this.supplier = supplier;
    }

    public UserData withSupplier(Object supplier) {
        this.supplier = supplier;
        return this;
    }

    public List<String> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(List<String> authorities) {
        this.authorities = authorities;
    }

    public UserData withAuthorities(List<String> authorities) {
        this.authorities = authorities;
        return this;
    }

    public Boolean getFirstAccess() {
        return firstAccess;
    }

    public void setFirstAccess(Boolean firstAccess) {
        this.firstAccess = firstAccess;
    }

    public UserData withFirstAccess(Boolean firstAccess) {
        this.firstAccess = firstAccess;
        return this;
    }

}
