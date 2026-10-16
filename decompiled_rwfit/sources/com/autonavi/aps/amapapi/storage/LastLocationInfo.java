package com.autonavi.aps.amapapi.storage;

import com.amap.api.col.p0003sl.ua;
import com.amap.api.col.p0003sl.va;
import com.amap.api.location.AMapLocation;

@ua(tableName = "c")
/* loaded from: classes.dex */
public class LastLocationInfo {

    /* renamed from: a, reason: collision with root package name */
    @va(fieldName = SdCardDbCreator.FIELD_LASTLOC_INFO, fieldType = 6)
    private String f6749a;

    /* renamed from: b, reason: collision with root package name */
    @va(fieldName = SdCardDbCreator.FIELD_LASTLOC_TIME, fieldType = 5)
    private long f6750b;

    /* renamed from: c, reason: collision with root package name */
    @va(fieldName = SdCardDbCreator.FIELD_LASTLOC_NB, fieldType = 6)
    private String f6751c;

    /* renamed from: d, reason: collision with root package name */
    private AMapLocation f6752d;

    public AMapLocation getAmapLocation() {
        return this.f6752d;
    }

    public String getLocInfo() {
        return this.f6749a;
    }

    public String getNb() {
        return this.f6751c;
    }

    public long getTime() {
        return this.f6750b;
    }

    public void setAmapLocation(AMapLocation aMapLocation) {
        this.f6752d = aMapLocation;
    }

    public void setLocInfo(String str) {
        this.f6749a = str;
    }

    public void setNb(String str) {
        this.f6751c = str;
    }

    public void setTime(long j4) {
        this.f6750b = j4;
    }
}
