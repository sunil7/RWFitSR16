package com.example.network.bean;

/* loaded from: classes.dex */
public class MemberFriendDataBean {
    private DailyHeartRateBean heartRate;
    private DailyHrvBean hrv;
    private DailyOxygenBean oxygen;
    private DailyPressureBean pressure;
    private DailySleepBean sleep;
    private Integer sportTarget;
    private DailyStepBean step;
    private DailySugarBean sugar;

    public DailyHeartRateBean getHeartRate() {
        return this.heartRate;
    }

    public DailyHrvBean getHrv() {
        return this.hrv;
    }

    public DailyOxygenBean getOxygen() {
        return this.oxygen;
    }

    public DailyPressureBean getPressure() {
        return this.pressure;
    }

    public DailySleepBean getSleep() {
        return this.sleep;
    }

    public Integer getSportTarget() {
        return this.sportTarget;
    }

    public DailyStepBean getStep() {
        return this.step;
    }

    public DailySugarBean getSugar() {
        return this.sugar;
    }

    public void setHeartRate(DailyHeartRateBean dailyHeartRateBean) {
        this.heartRate = dailyHeartRateBean;
    }

    public void setHrv(DailyHrvBean dailyHrvBean) {
        this.hrv = dailyHrvBean;
    }

    public void setOxygen(DailyOxygenBean dailyOxygenBean) {
        this.oxygen = dailyOxygenBean;
    }

    public void setPressure(DailyPressureBean dailyPressureBean) {
        this.pressure = dailyPressureBean;
    }

    public void setSleep(DailySleepBean dailySleepBean) {
        this.sleep = dailySleepBean;
    }

    public void setSportTarget(Integer num) {
        this.sportTarget = num;
    }

    public void setStep(DailyStepBean dailyStepBean) {
        this.step = dailyStepBean;
    }

    public void setSugar(DailySugarBean dailySugarBean) {
        this.sugar = dailySugarBean;
    }

    public String toString() {
        return "MemberFriendDataBean{step=" + this.step + ", heartRate=" + this.heartRate + ", sleep=" + this.sleep + ", oxygen=" + this.oxygen + ", hrv=" + this.hrv + ", pressure=" + this.pressure + ", sugar=" + this.sugar + ", sportTarget=" + this.sportTarget + '}';
    }
}
