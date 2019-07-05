package com.example.apptotem.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PFMType {
    @SerializedName("clazz")
    @Expose
    private String clazz;
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("enabled")
    @Expose
    private Boolean enabled;
    @SerializedName("permitType")
    @Expose
    private String permitType;
    @SerializedName("notice")
    @Expose
    private Integer notice;
    @SerializedName("allDay")
    @Expose
    private Boolean allDay;
    @SerializedName("acronym")
    @Expose
    private String acronym;
    @SerializedName("addToOrd")
    @Expose
    private Integer addToOrd;
    @SerializedName("showToUser")
    @Expose
    private Integer showToUser;
    @SerializedName("rowOrder")
    @Expose
    private Object rowOrder;

    public String getClazz() {
        return clazz;
    }

    public void setClazz(String clazz) {
        this.clazz = clazz;
    }

    public PFMType withClazz(String clazz) {
        this.clazz = clazz;
        return this;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public PFMType withId(Integer id) {
        this.id = id;
        return this;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public PFMType withEnabled(Boolean enabled) {
        this.enabled = enabled;
        return this;
    }

    public String getPermitType() {
        return permitType;
    }

    public void setPermitType(String permitType) {
        this.permitType = permitType;
    }

    public PFMType withPermitType(String permitType) {
        this.permitType = permitType;
        return this;
    }

    public Integer getNotice() {
        return notice;
    }

    public void setNotice(Integer notice) {
        this.notice = notice;
    }

    public PFMType withNotice(Integer notice) {
        this.notice = notice;
        return this;
    }

    public Boolean getAllDay() {
        return allDay;
    }

    public void setAllDay(Boolean allDay) {
        this.allDay = allDay;
    }

    public PFMType withAllDay(Boolean allDay) {
        this.allDay = allDay;
        return this;
    }

    public String getAcronym() {
        return acronym;
    }

    public void setAcronym(String acronym) {
        this.acronym = acronym;
    }

    public PFMType withAcronym(String acronym) {
        this.acronym = acronym;
        return this;
    }

    public Integer getAddToOrd() {
        return addToOrd;
    }

    public void setAddToOrd(Integer addToOrd) {
        this.addToOrd = addToOrd;
    }

    public PFMType withAddToOrd(Integer addToOrd) {
        this.addToOrd = addToOrd;
        return this;
    }

    public Integer getShowToUser() {
        return showToUser;
    }

    public void setShowToUser(Integer showToUser) {
        this.showToUser = showToUser;
    }

    public PFMType withShowToUser(Integer showToUser) {
        this.showToUser = showToUser;
        return this;
    }

    public Object getRowOrder() {
        return rowOrder;
    }

    public void setRowOrder(Object rowOrder) {
        this.rowOrder = rowOrder;
    }

    public PFMType withRowOrder(Object rowOrder) {
        this.rowOrder = rowOrder;
        return this;
    }

}
