package com.example.apptotem.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Employee {

    @SerializedName("clazz")
    @Expose
    private String clazz;
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("enabled")
    @Expose
    private Boolean enabled;
    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("firstname")
    @Expose
    private String firstname;
    @SerializedName("lastname")
    @Expose
    private String lastname;
    @SerializedName("alias")
    @Expose
    private Object alias;
    @SerializedName("phone")
    @Expose
    private String phone;
    @SerializedName("address")
    @Expose
    private Object address;
    @SerializedName("postalCode")
    @Expose
    private Object postalCode;
    @SerializedName("city")
    @Expose
    private Object city;
    @SerializedName("province")
    @Expose
    private Object province;
    @SerializedName("country")
    @Expose
    private Object country;
    @SerializedName("logInEnabled")
    @Expose
    private Boolean logInEnabled;

    public String getClazz() {
        return clazz;
    }

    public void setClazz(String clazz) {
        this.clazz = clazz;
    }

    public Employee withClazz(String clazz) {
        this.clazz = clazz;
        return this;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Employee withId(Integer id) {
        this.id = id;
        return this;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public Employee withEnabled(Boolean enabled) {
        this.enabled = enabled;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Employee withEmail(String email) {
        this.email = email;
        return this;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public Employee withFirstname(String firstname) {
        this.firstname = firstname;
        return this;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Employee withLastname(String lastname) {
        this.lastname = lastname;
        return this;
    }

    public Object getAlias() {
        return alias;
    }

    public void setAlias(Object alias) {
        this.alias = alias;
    }

    public Employee withAlias(Object alias) {
        this.alias = alias;
        return this;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Employee withPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public Object getAddress() {
        return address;
    }

    public void setAddress(Object address) {
        this.address = address;
    }

    public Employee withAddress(Object address) {
        this.address = address;
        return this;
    }

    public Object getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(Object postalCode) {
        this.postalCode = postalCode;
    }

    public Employee withPostalCode(Object postalCode) {
        this.postalCode = postalCode;
        return this;
    }

    public Object getCity() {
        return city;
    }

    public void setCity(Object city) {
        this.city = city;
    }

    public Employee withCity(Object city) {
        this.city = city;
        return this;
    }

    public Object getProvince() {
        return province;
    }

    public void setProvince(Object province) {
        this.province = province;
    }

    public Employee withProvince(Object province) {
        this.province = province;
        return this;
    }

    public Object getCountry() {
        return country;
    }

    public void setCountry(Object country) {
        this.country = country;
    }

    public Employee withCountry(Object country) {
        this.country = country;
        return this;
    }

    public Boolean getLogInEnabled() {
        return logInEnabled;
    }

    public void setLogInEnabled(Boolean logInEnabled) {
        this.logInEnabled = logInEnabled;
    }

    public Employee withLogInEnabled(Boolean logInEnabled) {
        this.logInEnabled = logInEnabled;
        return this;
    }
}
