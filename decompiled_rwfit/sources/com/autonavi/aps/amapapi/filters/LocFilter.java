package com.autonavi.aps.amapapi.filters;

import android.text.TextUtils;
import com.amap.api.location.AMapLocation;
import com.autonavi.aps.amapapi.model.AMapLocationServer;
import com.autonavi.aps.amapapi.utils.AuthUtil;
import com.autonavi.aps.amapapi.utils.Utils;

/* loaded from: classes.dex */
public class LocFilter {

    /* renamed from: a, reason: collision with root package name */
    AMapLocationServer f6634a = null;

    /* renamed from: b, reason: collision with root package name */
    long f6635b = 0;

    /* renamed from: c, reason: collision with root package name */
    long f6636c = 0;

    /* renamed from: d, reason: collision with root package name */
    private boolean f6637d = true;
    int e = 0;

    /* renamed from: f, reason: collision with root package name */
    long f6638f = 0;

    /* renamed from: g, reason: collision with root package name */
    AMapLocation f6639g = null;

    /* renamed from: h, reason: collision with root package name */
    long f6640h = 0;

    public AMapLocationServer a(AMapLocationServer aMapLocationServer) {
        if (Utils.locCorrect(aMapLocationServer)) {
            if (!this.f6637d || !AuthUtil.isCacheAble(aMapLocationServer.getTime())) {
                aMapLocationServer.setLocationType(this.e);
            } else if (aMapLocationServer.getLocationType() == 5 || aMapLocationServer.getLocationType() == 6) {
                aMapLocationServer.setLocationType(4);
                return aMapLocationServer;
            }
        }
        return aMapLocationServer;
    }

    public AMapLocationServer filterFusion(AMapLocationServer aMapLocationServer) {
        return aMapLocationServer;
    }

    public AMapLocation filterGPSShake(AMapLocation aMapLocation) {
        if (Utils.locCorrect(aMapLocation)) {
            long timeBoot = Utils.getTimeBoot() - this.f6640h;
            this.f6640h = Utils.getTimeBoot();
            if (timeBoot <= 5000) {
                AMapLocation aMapLocation2 = this.f6639g;
                if (aMapLocation2 == null) {
                    this.f6639g = aMapLocation;
                    return aMapLocation;
                }
                if (1 != aMapLocation2.getLocationType() && !"gps".equalsIgnoreCase(this.f6639g.getProvider())) {
                    this.f6639g = aMapLocation;
                    return aMapLocation;
                }
                if (this.f6639g.getAltitude() == aMapLocation.getAltitude() && this.f6639g.getLongitude() == aMapLocation.getLongitude()) {
                    this.f6639g = aMapLocation;
                    return aMapLocation;
                }
                long abs = Math.abs(aMapLocation.getTime() - this.f6639g.getTime());
                if (30000 < abs) {
                    this.f6639g = aMapLocation;
                    return aMapLocation;
                }
                if (Utils.dist(aMapLocation, this.f6639g) > ((aMapLocation.getAccuracy() + this.f6639g.getAccuracy()) * 2.0f) + (((aMapLocation.getSpeed() + this.f6639g.getSpeed()) * abs) / 2000.0f) + 3000.0f) {
                    return this.f6639g;
                }
                this.f6639g = aMapLocation;
                return aMapLocation;
            }
        }
        return aMapLocation;
    }

    public AMapLocationServer filterShake(AMapLocationServer aMapLocationServer) {
        if (Utils.getTimeBoot() - this.f6638f > 30000) {
            this.f6634a = aMapLocationServer;
            this.f6638f = Utils.getTimeBoot();
            return this.f6634a;
        }
        this.f6638f = Utils.getTimeBoot();
        if (!Utils.locCorrect(this.f6634a) || !Utils.locCorrect(aMapLocationServer)) {
            this.f6635b = Utils.getTimeBoot();
            this.f6634a = aMapLocationServer;
            return aMapLocationServer;
        }
        if (aMapLocationServer.getTime() == this.f6634a.getTime() && aMapLocationServer.getAccuracy() < 300.0f) {
            return aMapLocationServer;
        }
        if ("gps".equals(aMapLocationServer.getProvider())) {
            this.f6635b = Utils.getTimeBoot();
            this.f6634a = aMapLocationServer;
            return aMapLocationServer;
        }
        if (aMapLocationServer.getCoord() != this.f6634a.getCoord()) {
            this.f6635b = Utils.getTimeBoot();
            this.f6634a = aMapLocationServer;
            return aMapLocationServer;
        }
        if (aMapLocationServer.getBuildingId() != null && !aMapLocationServer.getBuildingId().equals(this.f6634a.getBuildingId()) && !TextUtils.isEmpty(aMapLocationServer.getBuildingId())) {
            this.f6635b = Utils.getTimeBoot();
            this.f6634a = aMapLocationServer;
            return aMapLocationServer;
        }
        this.e = aMapLocationServer.getLocationType();
        float dist = Utils.dist(aMapLocationServer, this.f6634a);
        float accuracy = this.f6634a.getAccuracy();
        float accuracy2 = aMapLocationServer.getAccuracy();
        float f2 = accuracy2 - accuracy;
        long timeBoot = Utils.getTimeBoot();
        long j4 = timeBoot - this.f6635b;
        boolean z5 = false;
        boolean z6 = accuracy <= 100.0f && accuracy2 > 299.0f;
        if (accuracy > 299.0f && accuracy2 > 299.0f) {
            z5 = true;
        }
        if (z6 || z5) {
            long j10 = this.f6636c;
            if (j10 == 0) {
                this.f6636c = timeBoot;
            } else if (timeBoot - j10 > 30000) {
                this.f6635b = timeBoot;
                this.f6634a = aMapLocationServer;
                this.f6636c = 0L;
                return aMapLocationServer;
            }
            AMapLocationServer a3 = a(this.f6634a);
            this.f6634a = a3;
            return a3;
        }
        if (accuracy2 < 100.0f && accuracy > 299.0f) {
            this.f6635b = timeBoot;
            this.f6634a = aMapLocationServer;
            this.f6636c = 0L;
            return aMapLocationServer;
        }
        if (accuracy2 <= 299.0f) {
            this.f6636c = 0L;
        }
        if (dist >= 10.0f || dist <= 0.1d || accuracy2 <= 5.0f) {
            if (f2 < 300.0f) {
                this.f6635b = Utils.getTimeBoot();
                this.f6634a = aMapLocationServer;
                return aMapLocationServer;
            }
            if (j4 >= 30000) {
                this.f6635b = Utils.getTimeBoot();
                this.f6634a = aMapLocationServer;
                return aMapLocationServer;
            }
            AMapLocationServer a10 = a(this.f6634a);
            this.f6634a = a10;
            return a10;
        }
        if (f2 >= -300.0f) {
            AMapLocationServer a11 = a(this.f6634a);
            this.f6634a = a11;
            return a11;
        }
        if (accuracy / accuracy2 >= 2.0f) {
            this.f6635b = timeBoot;
            this.f6634a = aMapLocationServer;
            return aMapLocationServer;
        }
        AMapLocationServer a12 = a(this.f6634a);
        this.f6634a = a12;
        return a12;
    }

    public void reset() {
        this.f6634a = null;
        this.f6635b = 0L;
        this.f6636c = 0L;
        this.f6639g = null;
        this.f6640h = 0L;
    }

    public void setLocationCahceEnable(boolean z5) {
        this.f6637d = z5;
    }
}
