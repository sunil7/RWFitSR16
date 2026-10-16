package com.example.test.ui.model.chart.chart;

import com.github.mikephil.charting.data.BarEntry;
import java.util.List;

/* loaded from: classes.dex */
public class StepChartData {
    private int avgSteps;
    private float calorie;
    private float distance;
    private String endTime;
    private String startTime;
    private int stepTarget;
    private int stepTargetPercent;
    private List<BarEntry> steps;
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

    public String getEndTime() {
        return this.endTime;
    }

    public String getStartTime() {
        return this.startTime;
    }

    public int getStepTarget() {
        return this.stepTarget;
    }

    public int getStepTargetPercent() {
        return this.stepTargetPercent;
    }

    public List<BarEntry> getSteps() {
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

    public void setEndTime(String str) {
        this.endTime = str;
    }

    public void setStartTime(String str) {
        this.startTime = str;
    }

    public void setStepTarget(int i3) {
        this.stepTarget = i3;
    }

    public void setStepTargetPercent(int i3) {
        this.stepTargetPercent = i3;
    }

    public void setSteps(List<BarEntry> list) {
        this.steps = list;
    }

    public void setTotalSteps(int i3) {
        this.totalSteps = i3;
    }
}
