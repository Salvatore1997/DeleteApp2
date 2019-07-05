package com.example.apptotem.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ApiError {

    @SerializedName("messages")
    @Expose
    private List<Message> messages = null;
    @SerializedName("fieldErrors")
    @Expose
    private List<Object> fieldErrors = null;

    public List<Message> getMessages() {
        return messages;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }

    public ApiError withMessages(List<Message> messages) {
        this.messages = messages;
        return this;
    }

    public List<Object> getFieldErrors() {
        return fieldErrors;
    }

    public void setFieldErrors(List<Object> fieldErrors) {
        this.fieldErrors = fieldErrors;
    }

    public ApiError withFieldErrors(List<Object> fieldErrors) {
        this.fieldErrors = fieldErrors;
        return this;
    }
}
