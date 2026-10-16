package com.example.test.ui.device.model;

import java.io.Serializable;

/* loaded from: classes.dex */
public class ContactModel implements Serializable {
    private String contactName;
    private String contactType;
    private boolean isConvert;

    public String getContactName() {
        return this.contactName;
    }

    public String getContactType() {
        return this.contactType;
    }

    public boolean isConvert() {
        return this.isConvert;
    }

    public void setContactName(String str) {
        this.contactName = str;
    }

    public void setContactType(String str) {
        this.contactType = str;
    }

    public void setConvert(boolean z5) {
        this.isConvert = z5;
    }
}
