package com.example.test.ui.main.model;

import com.example.blesdk.bean.sync.BreatheItemBean;
import java.util.List;

/* loaded from: classes.dex */
public class BreatheDayDataModel {
    private List<BreatheItemBean> items;
    private int totalMin;

    public List<BreatheItemBean> getItems() {
        return this.items;
    }

    public int getTotalMin() {
        return this.totalMin;
    }

    public void setItems(List<BreatheItemBean> list) {
        this.items = list;
    }

    public void setTotalMin(int i3) {
        this.totalMin = i3;
    }
}
