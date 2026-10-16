package com.example.test.ui.main.model;

import android.graphics.PointF;
import com.github.mikephil.charting.data.Entry;
import java.util.List;

/* loaded from: classes.dex */
public class HomeBpModel extends BaseDataModel {
    private int currentDp;
    private int currentSp;
    private String endTime;
    private List<PointF> itemDp;
    private List<Entry> itemDps;
    private List<PointF> itemSp;
    private List<Entry> itemSps;
    private String startTime;

    public HomeBpModel() {
        super(2);
    }

    public int getCurrentDp() {
        return this.currentDp;
    }

    public int getCurrentSp() {
        return this.currentSp;
    }

    public String getEndTime() {
        return this.endTime;
    }

    public List<PointF> getItemDp() {
        return this.itemDp;
    }

    public List<Entry> getItemDps() {
        return this.itemDps;
    }

    public List<PointF> getItemSp() {
        return this.itemSp;
    }

    public List<Entry> getItemSps() {
        return this.itemSps;
    }

    public String getStartTime() {
        return this.startTime;
    }

    public void setCurrentDp(int i3) {
        this.currentDp = i3;
    }

    public void setCurrentSp(int i3) {
        this.currentSp = i3;
    }

    public void setEndTime(String str) {
        this.endTime = str;
    }

    public void setItemDp(List<PointF> list) {
        this.itemDp = list;
    }

    public void setItemDps(List<Entry> list) {
        this.itemDps = list;
    }

    public void setItemSp(List<PointF> list) {
        this.itemSp = list;
    }

    public void setItemSps(List<Entry> list) {
        this.itemSps = list;
    }

    public void setStartTime(String str) {
        this.startTime = str;
    }
}
