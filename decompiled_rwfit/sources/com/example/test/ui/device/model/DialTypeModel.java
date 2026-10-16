package com.example.test.ui.device.model;

import java.util.List;

/* loaded from: classes.dex */
public class DialTypeModel {
    private int classifyId;
    private List<DialModel> dials;
    private String type;

    public int getClassifyId() {
        return this.classifyId;
    }

    public List<DialModel> getDials() {
        return this.dials;
    }

    public String getType() {
        return this.type;
    }

    public void setClassifyId(int i3) {
        this.classifyId = i3;
    }

    public void setDials(List<DialModel> list) {
        this.dials = list;
    }

    public void setType(String str) {
        this.type = str;
    }
}
