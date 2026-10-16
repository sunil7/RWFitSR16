package com.example.blesdk.bean.sync;

/* loaded from: classes.dex */
public class SportDataPushBean {
    private Integer tActivityTime = 0;
    private Integer tActivityHr = 0;
    private Integer tActivitySteps = 0;
    private Integer tActivityCalorie = 0;
    private Integer tActivityDistance = 0;

    public Integer gettActivityCalorie() {
        return this.tActivityCalorie;
    }

    public Integer gettActivityDistance() {
        return this.tActivityDistance;
    }

    public Integer gettActivityHr() {
        return this.tActivityHr;
    }

    public Integer gettActivitySteps() {
        return this.tActivitySteps;
    }

    public Integer gettActivityTime() {
        return this.tActivityTime;
    }

    public void settActivityCalorie(Integer num) {
        this.tActivityCalorie = num;
    }

    public void settActivityDistance(Integer num) {
        this.tActivityDistance = num;
    }

    public void settActivityHr(Integer num) {
        this.tActivityHr = num;
    }

    public void settActivitySteps(Integer num) {
        this.tActivitySteps = num;
    }

    public void settActivityTime(Integer num) {
        this.tActivityTime = num;
    }
}
