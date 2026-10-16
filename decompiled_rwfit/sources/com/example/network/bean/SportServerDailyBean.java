package com.example.network.bean;

import com.google.android.gms.internal.mlkit_vision_barcode.l0;
import java.util.List;

/* loaded from: classes.dex */
public class SportServerDailyBean {
    private Long avgHr;
    private Long avgPace;
    private Long avgSteps;
    private String deviceId;
    private int from;
    private List<SportHrServerItemBean> heartRates;
    private List<SportPacesServerItemBean> kmPaces;
    private List<SportLatLngServerItemBean> locations;
    private Long maxHr;
    private Long maxPace;
    private Long maxSteps;
    private String memberId;
    private List<SportPacesServerItemBean> milePaces;
    private Long minHr;
    private Long minPace;
    private Long minSteps;
    private String newSportHrs;
    private List<SportStepFreServerItemBean> stepFrequencies;
    private int timestamp;
    private int totalCal;
    private int totalDistance;
    private int totalStep;
    private int totalTime;
    private int type;
    private Integer viewType;

    public Long getAvgHr() {
        return this.avgHr;
    }

    public Long getAvgPace() {
        return this.avgPace;
    }

    public Long getAvgSteps() {
        return this.avgSteps;
    }

    public String getDeviceId() {
        return this.deviceId;
    }

    public int getFrom() {
        return this.from;
    }

    public List<SportHrServerItemBean> getHeartRates() {
        return this.heartRates;
    }

    public List<SportPacesServerItemBean> getKmPaces() {
        return this.kmPaces;
    }

    public List<SportLatLngServerItemBean> getLocations() {
        return this.locations;
    }

    public Long getMaxHr() {
        return this.maxHr;
    }

    public Long getMaxPace() {
        return this.maxPace;
    }

    public Long getMaxSteps() {
        return this.maxSteps;
    }

    public String getMemberId() {
        return this.memberId;
    }

    public List<SportPacesServerItemBean> getMilePaces() {
        return this.milePaces;
    }

    public Long getMinHr() {
        return this.minHr;
    }

    public Long getMinPace() {
        return this.minPace;
    }

    public Long getMinSteps() {
        return this.minSteps;
    }

    public String getNewSportHrs() {
        return this.newSportHrs;
    }

    public List<SportStepFreServerItemBean> getStepFrequencies() {
        return this.stepFrequencies;
    }

    public int getTimestamp() {
        return this.timestamp;
    }

    public int getTotalCal() {
        return this.totalCal;
    }

    public int getTotalDistance() {
        return this.totalDistance;
    }

    public int getTotalStep() {
        return this.totalStep;
    }

    public int getTotalTime() {
        return this.totalTime;
    }

    public int getType() {
        return this.type;
    }

    public Integer getViewType() {
        return this.viewType;
    }

    public void setAvgHr(Long l3) {
        this.avgHr = l3;
    }

    public void setAvgPace(Long l3) {
        this.avgPace = l3;
    }

    public void setAvgSteps(Long l3) {
        this.avgSteps = l3;
    }

    public void setDeviceId(String str) {
        this.deviceId = str;
    }

    public void setFrom(int i3) {
        this.from = i3;
    }

    public void setHeartRates(List<SportHrServerItemBean> list) {
        this.heartRates = list;
    }

    public void setKmPaces(List<SportPacesServerItemBean> list) {
        this.kmPaces = list;
    }

    public void setLocations(List<SportLatLngServerItemBean> list) {
        this.locations = list;
    }

    public void setMaxHr(Long l3) {
        this.maxHr = l3;
    }

    public void setMaxPace(Long l3) {
        this.maxPace = l3;
    }

    public void setMaxSteps(Long l3) {
        this.maxSteps = l3;
    }

    public void setMemberId(String str) {
        this.memberId = str;
    }

    public void setMilePaces(List<SportPacesServerItemBean> list) {
        this.milePaces = list;
    }

    public void setMinHr(Long l3) {
        this.minHr = l3;
    }

    public void setMinPace(Long l3) {
        this.minPace = l3;
    }

    public void setMinSteps(Long l3) {
        this.minSteps = l3;
    }

    public void setNewSportHrs(String str) {
        this.newSportHrs = str;
    }

    public void setStepFrequencies(List<SportStepFreServerItemBean> list) {
        this.stepFrequencies = list;
    }

    public void setTimestamp(int i3) {
        this.timestamp = i3;
    }

    public void setTotalCal(int i3) {
        this.totalCal = i3;
    }

    public void setTotalDistance(int i3) {
        this.totalDistance = i3;
    }

    public void setTotalStep(int i3) {
        this.totalStep = i3;
    }

    public void setTotalTime(int i3) {
        this.totalTime = i3;
    }

    public void setType(int i3) {
        this.type = i3;
    }

    public void setViewType(Integer num) {
        this.viewType = num;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder("SportServerDailyBean{memberId='");
        sb2.append(this.memberId);
        sb2.append("', deviceId='");
        sb2.append(this.deviceId);
        sb2.append("', from=");
        sb2.append(this.from);
        sb2.append(", timestamp=");
        sb2.append(this.timestamp);
        sb2.append(", type=");
        sb2.append(this.type);
        sb2.append(", totalTime=");
        sb2.append(this.totalTime);
        sb2.append(", totalDistance=");
        sb2.append(this.totalDistance);
        sb2.append(", totalStep=");
        sb2.append(this.totalStep);
        sb2.append(", totalCal=");
        sb2.append(this.totalCal);
        sb2.append(", heartRates=");
        sb2.append(this.heartRates);
        sb2.append(", kmPaces=");
        sb2.append(this.kmPaces);
        sb2.append(", milePaces=");
        sb2.append(this.milePaces);
        sb2.append(", stepFrequencies=");
        sb2.append(this.stepFrequencies);
        sb2.append(", locations=");
        return l0.r(sb2, this.locations, '}');
    }
}
