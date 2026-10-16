package com.example.test.ui.main.model;

import h6.b;
import java.util.List;

/* loaded from: classes.dex */
public class HomeSportModel extends BaseDataModel {
    private List<b> dataItems;
    private String endTime;
    private String startTime;

    public HomeSportModel() {
        super(8);
    }

    public List<b> getDataItems() {
        return this.dataItems;
    }

    public String getEndTime() {
        return this.endTime;
    }

    public String getStartTime() {
        return this.startTime;
    }

    public void setDataItems(List<b> list) {
        this.dataItems = list;
    }

    public void setEndTime(String str) {
        this.endTime = str;
    }

    public void setStartTime(String str) {
        this.startTime = str;
    }

    public String toString() {
        return "HomeSportModel dataItems size " + this.dataItems.size();
    }
}
