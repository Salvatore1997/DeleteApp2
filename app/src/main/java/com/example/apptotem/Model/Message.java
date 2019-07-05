package com.example.apptotem.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Message {

    @SerializedName("text")
    @Expose
    private String text;
    @SerializedName("severity")
    @Expose
    private String severity;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Message withText(String text) {
        this.text = text;
        return this;
    }

    public String getSeverity() {
        return severity;
    }

    public void setSeverity(String severity) {
        this.severity = severity;
    }

    public Message withSeverity(String severity) {
        this.severity = severity;
        return this;
    }
}
