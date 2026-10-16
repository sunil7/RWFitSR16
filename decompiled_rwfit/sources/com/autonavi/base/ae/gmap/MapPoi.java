package com.autonavi.base.ae.gmap;

import com.autonavi.base.amap.mapcore.jbinding.JBindingExclude;
import com.autonavi.base.amap.mapcore.jbinding.JBindingInclude;

@JBindingInclude
/* loaded from: classes.dex */
public class MapPoi {
    private String extendInfo;
    private long iconXMax;
    private long iconXMin;
    private long iconYMax;
    private long iconYMin;
    private boolean isFocus;
    private double latitude;
    private double longitude;
    private long mainKey;
    private String name;
    private long poiType;
    private String poiid;
    private float screenX;
    private float screenY;
    private long subKey;
    private long subType;
    private long timestamp;

    /* renamed from: z, reason: collision with root package name */
    private double f6842z;

    @JBindingExclude
    public String getExtendInfo() {
        return this.extendInfo;
    }

    @JBindingExclude
    public long getIconXMax() {
        return this.iconXMax;
    }

    @JBindingExclude
    public long getIconXMin() {
        return this.iconXMin;
    }

    @JBindingExclude
    public long getIconYMax() {
        return this.iconYMax;
    }

    @JBindingExclude
    public long getIconYMin() {
        return this.iconYMin;
    }

    @JBindingExclude
    public double getLatitude() {
        return this.latitude;
    }

    @JBindingExclude
    public double getLongitude() {
        return this.longitude;
    }

    @JBindingExclude
    public long getMainKey() {
        return this.mainKey;
    }

    @JBindingExclude
    public String getName() {
        return this.name;
    }

    @JBindingExclude
    public long getPoiType() {
        return this.poiType;
    }

    @JBindingExclude
    public String getPoiid() {
        return this.poiid;
    }

    @JBindingExclude
    public float getScreenX() {
        return this.screenX;
    }

    @JBindingExclude
    public float getScreenY() {
        return this.screenY;
    }

    @JBindingExclude
    public long getSubKey() {
        return this.subKey;
    }

    @JBindingExclude
    public long getSubType() {
        return this.subType;
    }

    @JBindingExclude
    public long getTimestamp() {
        return this.timestamp;
    }

    @JBindingExclude
    public double getZ() {
        return this.f6842z;
    }

    @JBindingExclude
    public boolean isFocus() {
        return this.isFocus;
    }

    @JBindingExclude
    public void setExtendInfo(String str) {
        this.extendInfo = str;
    }

    @JBindingExclude
    public void setFocus(boolean z5) {
        this.isFocus = z5;
    }

    @JBindingExclude
    public void setIconXMax(long j4) {
        this.iconXMax = j4;
    }

    @JBindingExclude
    public void setIconXMin(long j4) {
        this.iconXMin = j4;
    }

    @JBindingExclude
    public void setIconYMax(long j4) {
        this.iconYMax = j4;
    }

    @JBindingExclude
    public void setIconYMin(long j4) {
        this.iconYMin = j4;
    }

    @JBindingExclude
    public void setLatitude(double d5) {
        this.latitude = d5;
    }

    @JBindingExclude
    public void setLongitude(double d5) {
        this.longitude = d5;
    }

    @JBindingExclude
    public void setMainKey(long j4) {
        this.mainKey = j4;
    }

    @JBindingExclude
    public void setName(String str) {
        this.name = str;
    }

    @JBindingExclude
    public void setPoiType(long j4) {
        this.poiType = j4;
    }

    @JBindingExclude
    public void setPoiid(String str) {
        this.poiid = str;
    }

    @JBindingExclude
    public void setScreenX(float f2) {
        this.screenX = f2;
    }

    @JBindingExclude
    public void setScreenY(float f2) {
        this.screenY = f2;
    }

    @JBindingExclude
    public void setSubKey(long j4) {
        this.subKey = j4;
    }

    @JBindingExclude
    public void setSubType(long j4) {
        this.subType = j4;
    }

    @JBindingExclude
    public void setTimestamp(long j4) {
        this.timestamp = j4;
    }

    @JBindingExclude
    public void setZ(double d5) {
        this.f6842z = d5;
    }
}
