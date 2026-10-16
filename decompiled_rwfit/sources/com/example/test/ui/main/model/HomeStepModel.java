package com.example.test.ui.main.model;

/* loaded from: classes.dex */
public class HomeStepModel extends BaseDataModel {
    private float calorie;
    private String currentSteps;
    private float distance;
    private String target;
    private float targetPerCent;

    public HomeStepModel() {
        super(0);
        this.target = "0";
    }

    public float getCalorie() {
        return this.calorie;
    }

    public String getCurrentSteps() {
        return this.currentSteps;
    }

    public float getDistance() {
        return this.distance;
    }

    public String getTarget() {
        return this.target;
    }

    public float getTargetPerCent() {
        return this.targetPerCent;
    }

    public void setCalorie(float f2) {
        this.calorie = f2;
    }

    public void setCurrentSteps(String str) {
        this.currentSteps = str;
    }

    public void setDistance(float f2) {
        this.distance = f2;
    }

    public void setTarget(String str) {
        this.target = str;
    }

    public void setTargetPerCent(float f2) {
        this.targetPerCent = f2;
    }
}
