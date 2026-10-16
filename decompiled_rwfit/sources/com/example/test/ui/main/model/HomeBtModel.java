package com.example.test.ui.main.model;

import android.graphics.PointF;
import java.util.List;

/* loaded from: classes.dex */
public class HomeBtModel extends BaseDataModel {
    private float currentBt;
    private List<PointF> items;

    public HomeBtModel() {
        super(5);
    }

    public float getCurrentBt() {
        return this.currentBt;
    }

    public List<PointF> getItems() {
        return this.items;
    }

    public void setCurrentBt(float f2) {
        this.currentBt = f2;
    }

    public void setItems(List<PointF> list) {
        this.items = list;
    }
}
