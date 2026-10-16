package com.example.blesdk.bean.sync;

import com.google.android.gms.internal.mlkit_vision_barcode.l0;
import java.util.List;

/* loaded from: classes.dex */
public class SportItemBean {
    private List<ImperialPaceItemBean> imperialPaceItems;
    private List<MetricPaceItemBean> metricPaceItems;
    private List<SportHrItemBean> sportHrItems;
    private long sportTime;
    private int sportType;
    private List<StepFrequencyItemBean> stepFrequencyItems;
    private int totalCalorie;
    private int totalDistance;
    private long totalSportTime;
    private int totalStep;

    public List<ImperialPaceItemBean> getImperialPaceItems() {
        return this.imperialPaceItems;
    }

    public List<MetricPaceItemBean> getMetricPaceItems() {
        return this.metricPaceItems;
    }

    public List<SportHrItemBean> getSportHrItems() {
        return this.sportHrItems;
    }

    public long getSportTime() {
        return this.sportTime;
    }

    public int getSportType() {
        return this.sportType;
    }

    public List<StepFrequencyItemBean> getStepFrequencyItems() {
        return this.stepFrequencyItems;
    }

    public int getTotalCalorie() {
        return this.totalCalorie;
    }

    public int getTotalDistance() {
        return this.totalDistance;
    }

    public long getTotalSportTime() {
        return this.totalSportTime;
    }

    public int getTotalStep() {
        return this.totalStep;
    }

    public void setImperialPaceItems(List<ImperialPaceItemBean> list) {
        this.imperialPaceItems = list;
    }

    public void setMetricPaceItems(List<MetricPaceItemBean> list) {
        this.metricPaceItems = list;
    }

    public void setSportHrItems(List<SportHrItemBean> list) {
        this.sportHrItems = list;
    }

    public void setSportTime(long j4) {
        this.sportTime = j4;
    }

    public void setSportType(int i3) {
        this.sportType = i3;
    }

    public void setStepFrequencyItems(List<StepFrequencyItemBean> list) {
        this.stepFrequencyItems = list;
    }

    public void setTotalCalorie(int i3) {
        this.totalCalorie = i3;
    }

    public void setTotalDistance(int i3) {
        this.totalDistance = i3;
    }

    public void setTotalSportTime(long j4) {
        this.totalSportTime = j4;
    }

    public void setTotalStep(int i3) {
        this.totalStep = i3;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder("SportItemBean{sportTime=");
        sb2.append(this.sportTime);
        sb2.append(", sportType=");
        sb2.append(this.sportType);
        sb2.append(", totalSportTime=");
        sb2.append(this.totalSportTime);
        sb2.append(", totalDistance=");
        sb2.append(this.totalDistance);
        sb2.append(", totalStep=");
        sb2.append(this.totalStep);
        sb2.append(", totalCalorie=");
        sb2.append(this.totalCalorie);
        sb2.append(", metricPaceItems=");
        sb2.append(this.metricPaceItems);
        sb2.append(", imperialPaceItems=");
        sb2.append(this.imperialPaceItems);
        sb2.append(", stepFrequencyItems=");
        sb2.append(this.stepFrequencyItems);
        sb2.append(", sportHrItems=");
        return l0.r(sb2, this.sportHrItems, '}');
    }
}
