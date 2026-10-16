package com.example.test.ui.main.model;

import android.graphics.PointF;
import com.github.mikephil.charting.data.Entry;
import java.util.List;

/* loaded from: classes.dex */
public class HomeSugarModel extends BaseDataModel {
    private float currentSugar;
    private List<Entry> dataItems;
    private String endTime;
    private List<PointF> items;
    private String startTime;

    public HomeSugarModel() {
        super(9);
    }

    public float getCurrentSugar() {
        return this.currentSugar;
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

    public void setCurrentSugar(float f2) {
        this.currentSugar = f2;
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
