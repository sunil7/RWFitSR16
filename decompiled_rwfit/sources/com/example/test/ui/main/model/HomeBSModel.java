package com.example.test.ui.main.model;

import android.graphics.PointF;
import java.util.List;

/* loaded from: classes.dex */
public class HomeBSModel extends BaseDataModel {
    private int avgStress;
    private int currentStress;
    private List<PointF> items;
    private int maxStress;
    private int minStress;

    public HomeBSModel() {
        super(6);
    }

    public int getAvgStress() {
        return this.avgStress;
    }

    public int getCurrentStress() {
        return this.currentStress;
    }

    public List<PointF> getItems() {
        return this.items;
    }

    public int getMaxStress() {
        return this.maxStress;
    }

    public int getMinStress() {
        return this.minStress;
    }

    public void setAvgStress(int i3) {
        this.avgStress = i3;
    }

    public void setCurrentStress(int i3) {
        this.currentStress = i3;
    }

    public void setItems(List<PointF> list) {
        this.items = list;
    }

    public void setMaxStress(int i3) {
        this.maxStress = i3;
    }

    public void setMinStress(int i3) {
        this.minStress = i3;
    }
}
