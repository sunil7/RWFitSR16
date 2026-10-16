package com.example.test.ui.main.model;

import android.graphics.PointF;
import com.github.mikephil.charting.data.Entry;
import java.util.List;

/* loaded from: classes.dex */
public class HomeHrModel extends BaseDataModel {
    private int currentHr;
    private List<Entry> dataItems;
    private String endTime;
    private List<PointF> items;
    private String startTime;

    public HomeHrModel() {
        super(1);
    }

    public int getCurrentHr() {
        return this.currentHr;
    }

    public List<Entry> getDataItems() {
        return this.dataItems;
    }

    public String getEndTime() {
        return this.endTime;
    }

    public List<PointF> getItems() {
        return this.items;
    }

    public String getStartTime() {
        return this.startTime;
    }

    public void setCurrentHr(int i3) {
        this.currentHr = i3;
    }

    public void setDataItems(List<Entry> list) {
        this.dataItems = list;
    }

    public void setEndTime(String str) {
        this.endTime = str;
    }

    public void setItems(List<PointF> list) {
        this.items = list;
    }

    public void setStartTime(String str) {
        this.startTime = str;
    }
}
