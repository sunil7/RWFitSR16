package com.autonavi.aps.amapapi.filters;

import com.amap.api.location.AMapLocation;
import com.autonavi.aps.amapapi.config.Const;

/* loaded from: classes.dex */
public class FilterEntity {

    /* renamed from: a, reason: collision with root package name */
    double f6628a;

    /* renamed from: b, reason: collision with root package name */
    double f6629b;

    /* renamed from: c, reason: collision with root package name */
    long f6630c;

    /* renamed from: d, reason: collision with root package name */
    float f6631d;
    float e;

    /* renamed from: f, reason: collision with root package name */
    int f6632f;

    /* renamed from: g, reason: collision with root package name */
    String f6633g;

    public FilterEntity(AMapLocation aMapLocation, int i3) {
        this.f6628a = aMapLocation.getLatitude();
        this.f6629b = aMapLocation.getLongitude();
        this.f6630c = aMapLocation.getTime();
        this.f6631d = aMapLocation.getAccuracy();
        this.e = aMapLocation.getSpeed();
        this.f6632f = i3;
        this.f6633g = aMapLocation.getProvider();
    }

    public boolean equals(Object obj) {
        try {
            if (!(obj instanceof FilterEntity)) {
                return false;
            }
            FilterEntity filterEntity = (FilterEntity) obj;
            if (this.f6628a == filterEntity.f6628a && this.f6629b == filterEntity.f6629b) {
                return this.f6632f == filterEntity.f6632f;
            }
            return false;
        } catch (Throwable unused) {
            return false;
        }
    }

    public int hashCode() {
        return Double.valueOf(this.f6629b).hashCode() + Double.valueOf(this.f6628a).hashCode() + this.f6632f;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.f6628a);
        stringBuffer.append(Const.STR_MART_COMMA);
        stringBuffer.append(this.f6629b);
        stringBuffer.append(Const.STR_MART_COMMA);
        stringBuffer.append(this.f6631d);
        stringBuffer.append(Const.STR_MART_COMMA);
        stringBuffer.append(this.f6630c);
        stringBuffer.append(Const.STR_MART_COMMA);
        stringBuffer.append(this.e);
        stringBuffer.append(Const.STR_MART_COMMA);
        stringBuffer.append(this.f6632f);
        stringBuffer.append(Const.STR_MART_COMMA);
        stringBuffer.append(this.f6633g);
        return stringBuffer.toString();
    }
}
