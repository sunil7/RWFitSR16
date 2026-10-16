package com.amap.api.location;

import android.os.Parcel;
import android.os.Parcelable;
import com.autonavi.aps.amapapi.config.Const;
import com.autonavi.aps.amapapi.utils.CoreUtil;

/* loaded from: classes.dex */
public class AMapLocationClientOption implements Cloneable, Parcelable {
    private static int E;
    private float A;
    private AMapLocationPurpose B;
    boolean C;
    String D;

    /* renamed from: a, reason: collision with root package name */
    private long f5636a;

    /* renamed from: b, reason: collision with root package name */
    private long f5637b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f5638c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f5639d;
    private boolean e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f5640f;

    /* renamed from: g, reason: collision with root package name */
    private boolean f5641g;

    /* renamed from: h, reason: collision with root package name */
    private AMapLocationMode f5642h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f5643i;

    /* renamed from: j, reason: collision with root package name */
    private boolean f5644j;

    /* renamed from: k, reason: collision with root package name */
    private boolean f5645k;

    /* renamed from: l, reason: collision with root package name */
    private boolean f5646l;

    /* renamed from: m, reason: collision with root package name */
    private boolean f5647m;

    /* renamed from: n, reason: collision with root package name */
    private boolean f5648n;

    /* renamed from: o, reason: collision with root package name */
    private boolean f5649o;

    /* renamed from: p, reason: collision with root package name */
    private long f5650p;

    /* renamed from: q, reason: collision with root package name */
    private long f5651q;
    private GeoLanguage r;

    /* renamed from: s, reason: collision with root package name */
    private boolean f5652s;

    /* renamed from: t, reason: collision with root package name */
    private int f5653t;

    /* renamed from: u, reason: collision with root package name */
    private int f5654u;

    /* renamed from: v, reason: collision with root package name */
    private boolean f5655v;

    /* renamed from: w, reason: collision with root package name */
    private boolean f5656w;

    /* renamed from: x, reason: collision with root package name */
    private boolean f5657x;

    /* renamed from: y, reason: collision with root package name */
    private boolean f5658y;

    /* renamed from: z, reason: collision with root package name */
    private boolean f5659z;
    private static AMapLocationProtocol F = AMapLocationProtocol.HTTP;
    public static String APIKEY = "";
    public static final Parcelable.Creator<AMapLocationClientOption> CREATOR = new a();
    public static boolean OPEN_ALWAYS_SCAN_WIFI = true;
    public static long SCAN_WIFI_INTERVAL = 30000;

    public enum AMapLocationMode {
        Battery_Saving,
        Device_Sensors,
        Hight_Accuracy
    }

    public enum AMapLocationProtocol {
        HTTP(0),
        HTTPS(1);


        /* renamed from: a, reason: collision with root package name */
        private int f5662a;

        AMapLocationProtocol(int i3) {
            this.f5662a = i3;
        }

        public int getValue() {
            return this.f5662a;
        }
    }

    public enum AMapLocationPurpose {
        SignIn,
        Transport,
        Sport
    }

    public enum GeoLanguage {
        DEFAULT,
        ZH,
        EN
    }

    public static class a implements Parcelable.Creator<AMapLocationClientOption> {
        @Override // android.os.Parcelable.Creator
        public AMapLocationClientOption createFromParcel(Parcel parcel) {
            return new AMapLocationClientOption(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public AMapLocationClientOption[] newArray(int i3) {
            return new AMapLocationClientOption[i3];
        }
    }

    public AMapLocationClientOption() {
        this.f5636a = 2000L;
        this.f5637b = CoreUtil.iTo;
        this.f5638c = false;
        this.f5639d = true;
        this.e = false;
        this.f5640f = true;
        this.f5641g = true;
        this.f5642h = AMapLocationMode.Hight_Accuracy;
        this.f5643i = false;
        this.f5644j = false;
        this.f5645k = true;
        this.f5646l = true;
        this.f5647m = false;
        this.f5648n = false;
        this.f5649o = true;
        this.f5650p = 30000L;
        this.f5651q = 30000L;
        this.r = GeoLanguage.DEFAULT;
        this.f5652s = false;
        this.f5653t = 1500;
        this.f5654u = 21600000;
        this.f5655v = false;
        this.f5656w = true;
        this.f5657x = true;
        this.f5658y = true;
        this.f5659z = true;
        this.A = 0.0f;
        this.B = null;
        this.C = false;
        this.D = null;
    }

    public static String getAPIKEY() {
        return APIKEY;
    }

    public static boolean isDownloadCoordinateConvertLibrary() {
        return false;
    }

    public static boolean isOpenAlwaysScanWifi() {
        return OPEN_ALWAYS_SCAN_WIFI;
    }

    public static void setDownloadCoordinateConvertLibrary(boolean z5) {
    }

    public static void setLocationProtocol(AMapLocationProtocol aMapLocationProtocol) {
        F = aMapLocationProtocol;
    }

    public static void setOpenAlwaysScanWifi(boolean z5) {
        OPEN_ALWAYS_SCAN_WIFI = z5;
    }

    public static void setScanWifiInterval(long j4) {
        SCAN_WIFI_INTERVAL = j4;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean getCacheCallBack() {
        return this.f5652s;
    }

    public int getCacheCallBackTime() {
        return this.f5653t;
    }

    public int getCacheTimeOut() {
        return this.f5654u;
    }

    public float getDeviceModeDistanceFilter() {
        return this.A;
    }

    public GeoLanguage getGeoLanguage() {
        return this.r;
    }

    public long getGpsFirstTimeout() {
        return this.f5651q;
    }

    public long getHttpTimeOut() {
        return this.f5637b;
    }

    public long getInterval() {
        return this.f5636a;
    }

    public long getLastLocationLifeCycle() {
        return this.f5650p;
    }

    public AMapLocationMode getLocationMode() {
        return this.f5642h;
    }

    public AMapLocationProtocol getLocationProtocol() {
        return F;
    }

    public AMapLocationPurpose getLocationPurpose() {
        return this.B;
    }

    public long getScanWifiInterval() {
        return SCAN_WIFI_INTERVAL;
    }

    public boolean isBeidouFirst() {
        return this.f5655v;
    }

    public boolean isGpsFirst() {
        return this.f5644j;
    }

    public boolean isKillProcess() {
        return this.f5643i;
    }

    public boolean isLBSLocationEnable() {
        return this.f5659z;
    }

    public boolean isLocationCacheEnable() {
        return this.f5646l;
    }

    public boolean isMockEnable() {
        return this.f5639d;
    }

    public boolean isNeedAddress() {
        return this.e;
    }

    public boolean isNoLocReqCgiEnable() {
        return this.f5657x;
    }

    public boolean isOffset() {
        return this.f5645k;
    }

    public boolean isOnceLocation() {
        return this.f5638c;
    }

    public boolean isOnceLocationLatest() {
        return this.f5647m;
    }

    public boolean isSelfStartServiceEnable() {
        return this.f5656w;
    }

    public boolean isSensorEnable() {
        return this.f5648n;
    }

    public boolean isSysNetworkLocEnable() {
        return this.f5658y;
    }

    public boolean isWifiActiveScan() {
        return this.f5640f;
    }

    public boolean isWifiScan() {
        return this.f5649o;
    }

    public AMapLocationClientOption setBeidouFirst(boolean z5) {
        this.f5655v = z5;
        return this;
    }

    public void setCacheCallBack(boolean z5) {
        this.f5652s = z5;
    }

    public void setCacheCallBackTime(int i3) {
        this.f5653t = i3;
    }

    public void setCacheTimeOut(int i3) {
        this.f5654u = i3;
    }

    public AMapLocationClientOption setDeviceModeDistanceFilter(float f2) {
        if (f2 < 0.0f) {
            f2 = 0.0f;
        }
        this.A = f2;
        return this;
    }

    public AMapLocationClientOption setGeoLanguage(GeoLanguage geoLanguage) {
        this.r = geoLanguage;
        return this;
    }

    public AMapLocationClientOption setGpsFirst(boolean z5) {
        this.f5644j = z5;
        return this;
    }

    public AMapLocationClientOption setGpsFirstTimeout(long j4) {
        if (j4 < 5000) {
            j4 = 5000;
        }
        if (j4 > 30000) {
            j4 = 30000;
        }
        this.f5651q = j4;
        return this;
    }

    public AMapLocationClientOption setHttpTimeOut(long j4) {
        this.f5637b = j4;
        return this;
    }

    public AMapLocationClientOption setInterval(long j4) {
        if (j4 <= 800) {
            j4 = 800;
        }
        this.f5636a = j4;
        return this;
    }

    public AMapLocationClientOption setKillProcess(boolean z5) {
        this.f5643i = z5;
        return this;
    }

    public void setLBSLocationEnable(boolean z5) {
        this.f5659z = z5;
    }

    public AMapLocationClientOption setLastLocationLifeCycle(long j4) {
        this.f5650p = j4;
        return this;
    }

    public AMapLocationClientOption setLocationCacheEnable(boolean z5) {
        this.f5646l = z5;
        return this;
    }

    public AMapLocationClientOption setLocationMode(AMapLocationMode aMapLocationMode) {
        this.f5642h = aMapLocationMode;
        return this;
    }

    public AMapLocationClientOption setLocationPurpose(AMapLocationPurpose aMapLocationPurpose) {
        this.B = aMapLocationPurpose;
        if (aMapLocationPurpose != null) {
            int ordinal = aMapLocationPurpose.ordinal();
            if (ordinal == 0) {
                this.f5642h = AMapLocationMode.Hight_Accuracy;
                this.f5638c = true;
                this.f5647m = true;
                this.f5639d = false;
                this.f5649o = true;
                this.f5656w = true;
                this.f5657x = true;
                this.f5658y = true;
                int i3 = E;
                if ((i3 & 1) == 0) {
                    this.C = true;
                    E = i3 | 1;
                    this.D = "signin";
                }
            } else {
                if (ordinal == 1) {
                    int i10 = E;
                    if ((i10 & 2) == 0) {
                        this.C = true;
                        E = i10 | 2;
                        this.D = "transport";
                    }
                    this.f5642h = AMapLocationMode.Hight_Accuracy;
                    this.f5638c = false;
                    this.f5647m = false;
                    this.f5644j = true;
                    this.f5655v = false;
                    this.f5656w = true;
                    this.f5657x = true;
                    this.f5658y = true;
                    this.f5639d = false;
                    return this;
                }
                if (ordinal == 2) {
                    int i11 = E;
                    if ((i11 & 4) == 0) {
                        this.C = true;
                        E = i11 | 4;
                        this.D = "sport";
                    }
                    this.f5642h = AMapLocationMode.Hight_Accuracy;
                    this.f5638c = false;
                    this.f5647m = false;
                    this.f5644j = true;
                    this.f5655v = false;
                    this.f5656w = true;
                    this.f5657x = true;
                    this.f5658y = true;
                    this.f5639d = false;
                    return this;
                }
            }
        }
        return this;
    }

    public AMapLocationClientOption setMockEnable(boolean z5) {
        this.f5639d = z5;
        return this;
    }

    public AMapLocationClientOption setNeedAddress(boolean z5) {
        this.e = z5;
        return this;
    }

    public void setNoLocReqCgiEnable(boolean z5) {
        this.f5657x = z5;
    }

    public AMapLocationClientOption setOffset(boolean z5) {
        this.f5645k = z5;
        return this;
    }

    public AMapLocationClientOption setOnceLocation(boolean z5) {
        this.f5638c = z5;
        return this;
    }

    public AMapLocationClientOption setOnceLocationLatest(boolean z5) {
        this.f5647m = z5;
        return this;
    }

    public void setSelfStartServiceEnable(boolean z5) {
        this.f5656w = z5;
    }

    public AMapLocationClientOption setSensorEnable(boolean z5) {
        this.f5648n = z5;
        return this;
    }

    public void setSysNetworkLocEnable(boolean z5) {
        this.f5658y = z5;
    }

    public AMapLocationClientOption setWifiScan(boolean z5) {
        this.f5649o = z5;
        if (z5) {
            this.f5640f = this.f5641g;
            return this;
        }
        this.f5640f = false;
        return this;
    }

    public String toString() {
        return "interval:" + String.valueOf(this.f5636a) + "#isOnceLocation:" + String.valueOf(this.f5638c) + "#locationMode:" + String.valueOf(this.f5642h) + "#locationProtocol:" + String.valueOf(F) + "#isMockEnable:" + String.valueOf(this.f5639d) + "#isKillProcess:" + String.valueOf(this.f5643i) + "#isGpsFirst:" + String.valueOf(this.f5644j) + "#isBeidouFirst:" + String.valueOf(this.f5655v) + "#isSelfStartServiceEnable:" + String.valueOf(this.f5656w) + "#noLocReqCgiEnable:" + String.valueOf(this.f5657x) + "#sysNetworkLocEnable:" + String.valueOf(this.f5658y) + "#isLBSLocationEnable:" + String.valueOf(this.f5659z) + "#isNeedAddress:" + String.valueOf(this.e) + "#isWifiActiveScan:" + String.valueOf(this.f5640f) + "#wifiScan:" + String.valueOf(this.f5649o) + "#httpTimeOut:" + String.valueOf(this.f5637b) + "#isLocationCacheEnable:" + String.valueOf(this.f5646l) + "#isOnceLocationLatest:" + String.valueOf(this.f5647m) + "#sensorEnable:" + String.valueOf(this.f5648n) + "#geoLanguage:" + String.valueOf(this.r) + "#locationPurpose:" + String.valueOf(this.B) + "#callback:" + String.valueOf(this.f5652s) + "#time:" + String.valueOf(this.f5653t) + Const.STR_MART_WELL;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeLong(this.f5636a);
        parcel.writeLong(this.f5637b);
        parcel.writeByte(this.f5638c ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f5639d ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.e ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f5640f ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f5641g ? (byte) 1 : (byte) 0);
        AMapLocationMode aMapLocationMode = this.f5642h;
        parcel.writeInt(aMapLocationMode == null ? -1 : aMapLocationMode.ordinal());
        parcel.writeByte(this.f5643i ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f5644j ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f5655v ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f5656w ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f5657x ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f5658y ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f5659z ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f5645k ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f5646l ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f5647m ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f5648n ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f5649o ? (byte) 1 : (byte) 0);
        parcel.writeLong(this.f5650p);
        parcel.writeInt(F == null ? -1 : getLocationProtocol().ordinal());
        GeoLanguage geoLanguage = this.r;
        parcel.writeInt(geoLanguage == null ? -1 : geoLanguage.ordinal());
        parcel.writeFloat(this.A);
        AMapLocationPurpose aMapLocationPurpose = this.B;
        parcel.writeInt(aMapLocationPurpose != null ? aMapLocationPurpose.ordinal() : -1);
        parcel.writeInt(OPEN_ALWAYS_SCAN_WIFI ? 1 : 0);
        parcel.writeLong(this.f5651q);
    }

    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public AMapLocationClientOption m3clone() {
        try {
            super.clone();
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
        AMapLocationClientOption aMapLocationClientOption = new AMapLocationClientOption();
        aMapLocationClientOption.f5636a = this.f5636a;
        aMapLocationClientOption.f5638c = this.f5638c;
        aMapLocationClientOption.f5642h = this.f5642h;
        aMapLocationClientOption.f5639d = this.f5639d;
        aMapLocationClientOption.f5643i = this.f5643i;
        aMapLocationClientOption.f5644j = this.f5644j;
        aMapLocationClientOption.e = this.e;
        aMapLocationClientOption.f5640f = this.f5640f;
        aMapLocationClientOption.f5637b = this.f5637b;
        aMapLocationClientOption.f5645k = this.f5645k;
        aMapLocationClientOption.f5646l = this.f5646l;
        aMapLocationClientOption.f5647m = this.f5647m;
        aMapLocationClientOption.f5648n = isSensorEnable();
        aMapLocationClientOption.f5649o = isWifiScan();
        aMapLocationClientOption.f5650p = this.f5650p;
        setLocationProtocol(getLocationProtocol());
        aMapLocationClientOption.r = this.r;
        setDownloadCoordinateConvertLibrary(isDownloadCoordinateConvertLibrary());
        aMapLocationClientOption.A = this.A;
        aMapLocationClientOption.B = this.B;
        setOpenAlwaysScanWifi(isOpenAlwaysScanWifi());
        setScanWifiInterval(getScanWifiInterval());
        aMapLocationClientOption.f5651q = this.f5651q;
        aMapLocationClientOption.f5654u = getCacheTimeOut();
        aMapLocationClientOption.f5652s = getCacheCallBack();
        aMapLocationClientOption.f5653t = getCacheCallBackTime();
        aMapLocationClientOption.f5656w = isSelfStartServiceEnable();
        aMapLocationClientOption.f5657x = isNoLocReqCgiEnable();
        aMapLocationClientOption.f5658y = isSysNetworkLocEnable();
        aMapLocationClientOption.f5659z = isLBSLocationEnable();
        return aMapLocationClientOption;
    }

    public AMapLocationClientOption(Parcel parcel) {
        this.f5636a = 2000L;
        this.f5637b = CoreUtil.iTo;
        this.f5638c = false;
        this.f5639d = true;
        this.e = false;
        this.f5640f = true;
        this.f5641g = true;
        AMapLocationMode aMapLocationMode = AMapLocationMode.Hight_Accuracy;
        this.f5642h = aMapLocationMode;
        this.f5643i = false;
        this.f5644j = false;
        this.f5645k = true;
        this.f5646l = true;
        this.f5647m = false;
        this.f5648n = false;
        this.f5649o = true;
        this.f5650p = 30000L;
        this.f5651q = 30000L;
        GeoLanguage geoLanguage = GeoLanguage.DEFAULT;
        this.r = geoLanguage;
        this.f5652s = false;
        this.f5653t = 1500;
        this.f5654u = 21600000;
        this.f5655v = false;
        this.f5656w = true;
        this.f5657x = true;
        this.f5658y = true;
        this.f5659z = true;
        this.A = 0.0f;
        this.B = null;
        this.C = false;
        this.D = null;
        this.f5636a = parcel.readLong();
        this.f5637b = parcel.readLong();
        this.f5638c = parcel.readByte() != 0;
        this.f5639d = parcel.readByte() != 0;
        this.e = parcel.readByte() != 0;
        this.f5640f = parcel.readByte() != 0;
        this.f5641g = parcel.readByte() != 0;
        int readInt = parcel.readInt();
        this.f5642h = readInt != -1 ? AMapLocationMode.values()[readInt] : aMapLocationMode;
        this.f5643i = parcel.readByte() != 0;
        this.f5644j = parcel.readByte() != 0;
        this.f5655v = parcel.readByte() != 0;
        this.f5656w = parcel.readByte() != 0;
        this.f5657x = parcel.readByte() != 0;
        this.f5658y = parcel.readByte() != 0;
        this.f5659z = parcel.readByte() != 0;
        this.f5645k = parcel.readByte() != 0;
        this.f5646l = parcel.readByte() != 0;
        this.f5647m = parcel.readByte() != 0;
        this.f5648n = parcel.readByte() != 0;
        this.f5649o = parcel.readByte() != 0;
        this.f5650p = parcel.readLong();
        int readInt2 = parcel.readInt();
        F = readInt2 == -1 ? AMapLocationProtocol.HTTP : AMapLocationProtocol.values()[readInt2];
        int readInt3 = parcel.readInt();
        this.r = readInt3 != -1 ? GeoLanguage.values()[readInt3] : geoLanguage;
        this.A = parcel.readFloat();
        int readInt4 = parcel.readInt();
        this.B = readInt4 != -1 ? AMapLocationPurpose.values()[readInt4] : null;
        OPEN_ALWAYS_SCAN_WIFI = parcel.readByte() != 0;
        this.f5651q = parcel.readLong();
    }
}
