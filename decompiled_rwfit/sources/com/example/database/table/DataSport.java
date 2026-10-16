package com.example.database.table;

/* loaded from: classes.dex */
public class DataSport {
    private long avgHr;
    private long avgPace;
    private long avgSteps;
    private String date;
    private int from;
    private String hrData;

    /* renamed from: id, reason: collision with root package name */
    private Long f7375id;
    private boolean isNew;
    private boolean isUpdate;
    private String latLng;
    private String mac;
    private long maxHr;
    private long maxPace;
    private long maxSteps;
    private long minHr;
    private long minPace;
    private long minSteps;
    private String newSportHrs;
    private String paceImperials;
    private String paceMetrics;
    private long speed;
    private int sportType;
    private String stepDetails;
    private String timestamp;
    private String totalCalories;
    private String totalDistances;
    private String totalSteps;
    private String totalTimes;
    private String userId;
    private int viewType;

    public DataSport(Long l3, String str, String str2, String str3, String str4, int i3, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, long j4, long j10, long j11, long j12, long j13, long j14, long j15, long j16, long j17, long j18, boolean z5, int i10, int i11, String str14, boolean z6) {
        this.f7375id = l3;
        this.mac = str;
        this.userId = str2;
        this.timestamp = str3;
        this.date = str4;
        this.sportType = i3;
        this.totalCalories = str5;
        this.totalTimes = str6;
        this.totalSteps = str7;
        this.totalDistances = str8;
        this.paceMetrics = str9;
        this.paceImperials = str10;
        this.stepDetails = str11;
        this.hrData = str12;
        this.latLng = str13;
        this.avgPace = j4;
        this.maxPace = j10;
        this.minPace = j11;
        this.avgSteps = j12;
        this.maxSteps = j13;
        this.minSteps = j14;
        this.avgHr = j15;
        this.maxHr = j16;
        this.minHr = j17;
        this.speed = j18;
        this.isUpdate = z5;
        this.from = i10;
        this.viewType = i11;
        this.newSportHrs = str14;
        this.isNew = z6;
    }

    public long getAvgHr() {
        return this.avgHr;
    }

    public long getAvgPace() {
        return this.avgPace;
    }

    public long getAvgSteps() {
        return this.avgSteps;
    }

    public String getDate() {
        return this.date;
    }

    public int getFrom() {
        return this.from;
    }

    public String getHrData() {
        return this.hrData;
    }

    public Long getId() {
        return this.f7375id;
    }

    public boolean getIsNew() {
        return this.isNew;
    }

    public boolean getIsUpdate() {
        return this.isUpdate;
    }

    public String getLatLng() {
        return this.latLng;
    }

    public String getMac() {
        return this.mac;
    }

    public long getMaxHr() {
        return this.maxHr;
    }

    public long getMaxPace() {
        return this.maxPace;
    }

    public long getMaxSteps() {
        return this.maxSteps;
    }

    public long getMinHr() {
        return this.minHr;
    }

    public long getMinPace() {
        return this.minPace;
    }

    public long getMinSteps() {
        return this.minSteps;
    }

    public String getNewSportHrs() {
        return this.newSportHrs;
    }

    public String getPaceImperials() {
        return this.paceImperials;
    }

    public String getPaceMetrics() {
        return this.paceMetrics;
    }

    public long getSpeed() {
        return this.speed;
    }

    public int getSportType() {
        return this.sportType;
    }

    public String getStepDetails() {
        return this.stepDetails;
    }

    public String getTimestamp() {
        return this.timestamp;
    }

    public String getTotalCalories() {
        return this.totalCalories;
    }

    public String getTotalDistances() {
        return this.totalDistances;
    }

    public String getTotalSteps() {
        return this.totalSteps;
    }

    public String getTotalTimes() {
        return this.totalTimes;
    }

    public String getUserId() {
        return this.userId;
    }

    public int getViewType() {
        return this.viewType;
    }

    public void setAvgHr(long j4) {
        this.avgHr = j4;
    }

    public void setAvgPace(long j4) {
        this.avgPace = j4;
    }

    public void setAvgSteps(long j4) {
        this.avgSteps = j4;
    }

    public void setDate(String str) {
        this.date = str;
    }

    public void setFrom(int i3) {
        this.from = i3;
    }

    public void setHrData(String str) {
        this.hrData = str;
    }

    public void setId(Long l3) {
        this.f7375id = l3;
    }

    public void setIsNew(boolean z5) {
        this.isNew = z5;
    }

    public void setIsUpdate(boolean z5) {
        this.isUpdate = z5;
    }

    public void setLatLng(String str) {
        this.latLng = str;
    }

    public void setMac(String str) {
        this.mac = str;
    }

    public void setMaxHr(long j4) {
        this.maxHr = j4;
    }

    public void setMaxPace(long j4) {
        this.maxPace = j4;
    }

    public void setMaxSteps(long j4) {
        this.maxSteps = j4;
    }

    public void setMinHr(long j4) {
        this.minHr = j4;
    }

    public void setMinPace(long j4) {
        this.minPace = j4;
    }

    public void setMinSteps(long j4) {
        this.minSteps = j4;
    }

    public void setNewSportHrs(String str) {
        this.newSportHrs = str;
    }

    public void setPaceImperials(String str) {
        this.paceImperials = str;
    }

    public void setPaceMetrics(String str) {
        this.paceMetrics = str;
    }

    public void setSpeed(long j4) {
        this.speed = j4;
    }

    public void setSportType(int i3) {
        this.sportType = i3;
    }

    public void setStepDetails(String str) {
        this.stepDetails = str;
    }

    public void setTimestamp(String str) {
        this.timestamp = str;
    }

    public void setTotalCalories(String str) {
        this.totalCalories = str;
    }

    public void setTotalDistances(String str) {
        this.totalDistances = str;
    }

    public void setTotalSteps(String str) {
        this.totalSteps = str;
    }

    public void setTotalTimes(String str) {
        this.totalTimes = str;
    }

    public void setUserId(String str) {
        this.userId = str;
    }

    public void setViewType(int i3) {
        this.viewType = i3;
    }

    public DataSport() {
    }
}
