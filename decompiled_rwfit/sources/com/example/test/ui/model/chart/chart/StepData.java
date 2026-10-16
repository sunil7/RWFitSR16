package com.example.test.ui.model.chart.chart;

import java.util.List;

/* loaded from: classes.dex */
public class StepData {
    private int avgSteps;
    private float calorie;
    private float distance;
    private List<StepItemData> steps;
    private int totalSteps;

    public int getAvgSteps() {
        return this.avgSteps;
    }

    public float getCalorie() {
        return this.calorie;
    }

    public float getDistance() {
        return this.distance;
    }

    public List<StepItemData> getSteps() {
        return this.steps;
    }

    public int getTotalSteps() {
        return this.totalSteps;
    }

    public void setAvgSteps(int i3) {
        this.avgSteps = i3;
    }

    public void setCalorie(float f2) {
        this.calorie = f2;
    }

    public void setDistance(float f2) {
        this.distance = f2;
    }

    public void setSteps(List<StepItemData> list) {
        this.steps = list;
    }

    public void setTotalSteps(int i3) {
        this.totalSteps = i3;
    }
}
