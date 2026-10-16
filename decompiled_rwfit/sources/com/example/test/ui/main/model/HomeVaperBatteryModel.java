package com.example.test.ui.main.model;

import android.graphics.PointF;
import java.util.List;

/* loaded from: classes.dex */
public class HomeVaperBatteryModel extends BaseDataModel {
    private int currentBattery;
    private List<PointF> items;

    public HomeVaperBatteryModel() {
        super(12);
    }

    public int getCurrentBattery() {
        return this.currentBattery;
    }

    public List<PointF> getItems() {
        return this.items;
    }

    public void setCurrentBattery(int i3) {
        this.currentBattery = i3;
    }

    public void setItems(List<PointF> list) {
        this.items = list;
    }
}
