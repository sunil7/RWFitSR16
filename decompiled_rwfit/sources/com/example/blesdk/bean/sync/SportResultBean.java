package com.example.blesdk.bean.sync;

import android.support.v4.media.session.e;

/* loaded from: classes.dex */
public class SportResultBean {
    private int averageHr;
    private int barometricPressure;
    private int cadence;
    private long calorie;
    private long distance;
    private long endTime;
    private int exerciseTime;
    private int height;
    private boolean isNewSportHrsData;
    private int maxCadence;
    private int maxHr;
    private int maxPace;
    private int minCadence;
    private int minHr;
    private int minPace;
    private String newSportHrs;
    private int pace;
    private int speed;
    private long startTime;
    private long step;
    private int viewType;
    private int workModel;

    public int getAverageHr() {
        return this.averageHr;
    }

    public int getBarometricPressure() {
        return this.barometricPressure;
    }

    public int getCadence() {
        return this.cadence;
    }

    public long getCalorie() {
        return this.calorie;
    }

    public long getDistance() {
        return this.distance;
    }

    public long getEndTime() {
        return this.endTime;
    }

    public int getExerciseTime() {
        return this.exerciseTime;
    }

    public int getHeight() {
        return this.height;
    }

    public int getMaxCadence() {
        return this.maxCadence;
    }

    public int getMaxHr() {
        return this.maxHr;
    }

    public int getMaxPace() {
        return this.maxPace;
    }

    public int getMinCadence() {
        return this.minCadence;
    }

    public int getMinHr() {
        return this.minHr;
    }

    public int getMinPace() {
        return this.minPace;
    }

    public String getNewSportHrs() {
        return this.newSportHrs;
    }

    public int getPace() {
        return this.pace;
    }

    public int getSpeed() {
        return this.speed;
    }

    public long getStartTime() {
        return this.startTime;
    }

    public long getStep() {
        return this.step;
    }

    public int getViewType() {
        return this.viewType;
    }

    public int getWorkModel() {
        return this.workModel;
    }

    public boolean isNewSportHrsData() {
        return this.isNewSportHrsData;
    }

    public void setAverageHr(int i3) {
        this.averageHr = i3;
    }

    public void setBarometricPressure(int i3) {
        this.barometricPressure = i3;
    }

    public void setCadence(int i3) {
        this.cadence = i3;
    }

    public void setCalorie(long j4) {
        this.calorie = j4;
    }

    public void setDistance(long j4) {
        this.distance = j4;
    }

    public void setEndTime(long j4) {
        this.endTime = j4;
    }

    public void setExerciseTime(int i3) {
        this.exerciseTime = i3;
    }

    public void setHeight(int i3) {
        this.height = i3;
    }

    public void setMaxCadence(int i3) {
        this.maxCadence = i3;
    }

    public void setMaxHr(int i3) {
        this.maxHr = i3;
    }

    public void setMaxPace(int i3) {
        this.maxPace = i3;
    }

    public void setMinCadence(int i3) {
        this.minCadence = i3;
    }

    public void setMinHr(int i3) {
        this.minHr = i3;
    }

    public void setMinPace(int i3) {
        this.minPace = i3;
    }

    public void setNewSportHrs(String str) {
        this.newSportHrs = str;
    }

    public void setNewSportHrsData(boolean z5) {
        this.isNewSportHrsData = z5;
    }

    public void setPace(int i3) {
        this.pace = i3;
    }

    public void setSpeed(int i3) {
        this.speed = i3;
    }

    public void setStartTime(long j4) {
        this.startTime = j4;
    }

    public void setStep(long j4) {
        this.step = j4;
    }

    public void setViewType(int i3) {
        this.viewType = i3;
    }

    public void setWorkModel(int i3) {
        this.workModel = i3;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder("SportResultBean{startTime=");
        sb2.append(this.startTime);
        sb2.append(", endTime=");
        sb2.append(this.endTime);
        sb2.append(", exerciseTime=");
        sb2.append(this.exerciseTime);
        sb2.append(", height=");
        sb2.append(this.height);
        sb2.append(", barometricPressure=");
        sb2.append(this.barometricPressure);
        sb2.append(", cadence=");
        sb2.append(this.cadence);
        sb2.append(", workModel=");
        sb2.append(this.workModel);
        sb2.append(", step=");
        sb2.append(this.step);
        sb2.append(", distance=");
        sb2.append(this.distance);
        sb2.append(", calorie=");
        sb2.append(this.calorie);
        sb2.append(", speed=");
        sb2.append(this.speed);
        sb2.append(", pace=");
        sb2.append(this.pace);
        sb2.append(", averageHr=");
        sb2.append(this.averageHr);
        sb2.append(", maxHr=");
        sb2.append(this.maxHr);
        sb2.append(", minHr=");
        sb2.append(this.minHr);
        sb2.append(", maxCadence=");
        sb2.append(this.maxCadence);
        sb2.append(", minCadence=");
        sb2.append(this.minCadence);
        sb2.append(", maxPace=");
        sb2.append(this.maxPace);
        sb2.append(", minPace=");
        sb2.append(this.minPace);
        sb2.append(", viewType=");
        sb2.append(this.viewType);
        sb2.append(", newSportHrs='");
        sb2.append(this.newSportHrs);
        sb2.append("', isNewSportHrsData=");
        return e.o(sb2, this.isNewSportHrsData, '}');
    }
}
