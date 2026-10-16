package com.example.test.ui.main.model;

import android.graphics.PointF;
import com.github.mikephil.charting.data.Entry;
import java.util.List;

/* loaded from: classes.dex */
public class HomeHrvModel extends BaseDataModel {
    private int currentHrv;
    private List<Entry> dataItems;
    private String endTime;
    private List<PointF> items;
    private String startTime;

    public HomeHrvModel() {
        super(13);
    }

    public int getCurrentHrv() {
        return this.currentHrv;
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

    public void setCurrentHrv(int i3) {
        this.currentHrv = i3;
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
