package com.example.test.ui.main.model;

import android.graphics.PointF;
import java.util.List;

/* loaded from: classes.dex */
public class HomeViperPowerModel extends BaseDataModel {
    private int currentPower;
    private List<PointF> items;
    private int[] powerLevel;
    private int powerType;

    public HomeViperPowerModel() {
        super(11);
    }

    public int getCurrentPower() {
        return this.currentPower;
    }

    public List<PointF> getItems() {
        return this.items;
    }

    public int[] getPowerLevel() {
        return this.powerLevel;
    }

    public int getPowerType() {
        return this.powerType;
    }

    public void setCurrentPower(int i3) {
        this.currentPower = i3;
    }

    public void setItems(List<PointF> list) {
        this.items = list;
    }

    public void setPowerLevel(int[] iArr) {
        this.powerLevel = iArr;
    }

    public void setPowerType(int i3) {
        this.powerType = i3;
    }
}
