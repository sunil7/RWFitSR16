package com.example.test.ui.main.model;

/* loaded from: classes.dex */
public class HomeMuslinModel extends BaseDataModel {
    private int goalCount;
    private float targetPerCent;
    private int totalCount;

    public HomeMuslinModel() {
        super(10);
        this.totalCount = 0;
        this.goalCount = 0;
    }

    public int getGoalCount() {
        return this.goalCount;
    }

    public float getTargetPerCent() {
        return this.targetPerCent;
    }

    public int getTotalCount() {
        return this.totalCount;
    }

    public void setGoalCount(int i3) {
        this.goalCount = i3;
    }

    public void setTargetPerCent(float f2) {
        this.targetPerCent = f2;
    }

    public void setTotalCount(int i3) {
        this.totalCount = i3;
    }
}
