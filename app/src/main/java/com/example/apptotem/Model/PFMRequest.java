package com.example.apptotem.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PFMRequest {
    @SerializedName("clazz")
    @Expose
    private String clazz;
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("enabled")
    @Expose
    private Boolean enabled;
    @SerializedName("idpermitType")
    @Expose
    private Integer idpermitType;
    @SerializedName("permitType")
    @Expose
    private String permitType;
    @SerializedName("startDate")
    @Expose
    private String startDate;
    @SerializedName("endDate")
    @Expose
    private String endDate;
    @SerializedName("emailManager")
    @Expose
    private Object emailManager;
    @SerializedName("state")
    @Expose
    private String state;
    @SerializedName("employeeId")
    @Expose
    private Integer employeeId;
    @SerializedName("managerId")
    @Expose
    private Object managerId;
    @SerializedName("stateMessage")
    @Expose
    private String stateMessage;
    @SerializedName("mailLink")
    @Expose
    private String mailLink;
    @SerializedName("firstName")
    @Expose
    private String firstName;
    @SerializedName("lastName")
    @Expose
    private String lastName;
    @SerializedName("emailEmployee")
    @Expose
    private String emailEmployee;
    @SerializedName("source")
    @Expose
    private Object source;
    @SerializedName("lastModifiedDate")
    @Expose
    private Long lastModifiedDate;
    @SerializedName("createdDate")
    @Expose
    private Long createdDate;
    @SerializedName("allDay")
    @Expose
    private Boolean allDay;

    public String getClazz() {
        return clazz;
    }

    public void setClazz(String clazz) {
        this.clazz = clazz;
    }

    public PFMRequest withClazz(String clazz) {
        this.clazz = clazz;
        return this;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public PFMRequest withId(Integer id) {
        this.id = id;
        return this;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public PFMRequest withEnabled(Boolean enabled) {
        this.enabled = enabled;
        return this;
    }

    public Integer getIdpermitType() {
        return idpermitType;
    }

    public void setIdpermitType(Integer idpermitType) {
        this.idpermitType = idpermitType;
    }

    public PFMRequest withIdpermitType(Integer idpermitType) {
        this.idpermitType = idpermitType;
        return this;
    }

    public String getPermitType() {
        return permitType;
    }

    public void setPermitType(String permitType) {
        this.permitType = permitType;
    }

    public PFMRequest withPermitType(String permitType) {
        this.permitType = permitType;
        return this;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public PFMRequest withStartDate(String startDate) {
        this.startDate = startDate;
        return this;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public PFMRequest withEndDate(String endDate) {
        this.endDate = endDate;
        return this;
    }

    public Object getEmailManager() {
        return emailManager;
    }

    public void setEmailManager(Object emailManager) {
        this.emailManager = emailManager;
    }

    public PFMRequest withEmailManager(Object emailManager) {
        this.emailManager = emailManager;
        return this;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public PFMRequest withState(String state) {
        this.state = state;
        return this;
    }

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public PFMRequest withEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
        return this;
    }

    public Object getManagerId() {
        return managerId;
    }

    public void setManagerId(Object managerId) {
        this.managerId = managerId;
    }

    public PFMRequest withManagerId(Object managerId) {
        this.managerId = managerId;
        return this;
    }

    public String getStateMessage() {
        return stateMessage;
    }

    public void setStateMessage(String stateMessage) {
        this.stateMessage = stateMessage;
    }

    public PFMRequest withStateMessage(String stateMessage) {
        this.stateMessage = stateMessage;
        return this;
    }

    public String getMailLink() {
        return mailLink;
    }

    public void setMailLink(String mailLink) {
        this.mailLink = mailLink;
    }

    public PFMRequest withMailLink(String mailLink) {
        this.mailLink = mailLink;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public PFMRequest withFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public PFMRequest withLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getEmailEmployee() {
        return emailEmployee;
    }

    public void setEmailEmployee(String emailEmployee) {
        this.emailEmployee = emailEmployee;
    }

    public PFMRequest withEmailEmployee(String emailEmployee) {
        this.emailEmployee = emailEmployee;
        return this;
    }

    public Object getSource() {
        return source;
    }

    public void setSource(Object source) {
        this.source = source;
    }

    public PFMRequest withSource(Object source) {
        this.source = source;
        return this;
    }

    public Long getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(Long lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    public PFMRequest withLastModifiedDate(Long lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
        return this;
    }

    public Long getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Long createdDate) {
        this.createdDate = createdDate;
    }

    public PFMRequest withCreatedDate(Long createdDate) {
        this.createdDate = createdDate;
        return this;
    }

    public Boolean getAllDay() {
        return allDay;
    }

    public void setAllDay(Boolean allDay) {
        this.allDay = allDay;
    }

    public PFMRequest withAllDay(Boolean allDay) {
        this.allDay = allDay;
        return this;
    }
}
