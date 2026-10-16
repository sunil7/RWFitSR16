package com.amap.api.col.p0003sl;

import android.content.Context;
import android.content.SharedPreferences;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.v4.media.session.e;
import android.text.TextUtils;
import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.location.DPoint;
import com.autonavi.aps.amapapi.config.Const;
import com.autonavi.aps.amapapi.filters.LocFilter;
import com.autonavi.aps.amapapi.utils.CoreUtil;
import com.autonavi.aps.amapapi.utils.DebugUtils;
import com.autonavi.aps.amapapi.utils.OffsetUtil;
import com.autonavi.aps.amapapi.utils.ReportUtil;
import com.autonavi.aps.amapapi.utils.SPUtil;
import com.autonavi.aps.amapapi.utils.Utils;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class z implements u {
    static boolean A = false;
    static boolean B = false;
    private static volatile AMapLocation C;

    /* renamed from: w, reason: collision with root package name */
    static AMapLocation f5484w;

    /* renamed from: x, reason: collision with root package name */
    static long f5485x;

    /* renamed from: y, reason: collision with root package name */
    static Object f5486y = new Object();

    /* renamed from: z, reason: collision with root package name */
    static long f5487z;

    /* renamed from: b, reason: collision with root package name */
    Handler f5488b;

    /* renamed from: c, reason: collision with root package name */
    private Context f5489c;

    /* renamed from: d, reason: collision with root package name */
    LocationManager f5490d;
    AMapLocationClientOption e;

    /* renamed from: m, reason: collision with root package name */
    LocFilter f5498m;

    /* renamed from: u, reason: collision with root package name */
    long f5505u;

    /* renamed from: v, reason: collision with root package name */
    LocationListener f5506v;

    /* renamed from: f, reason: collision with root package name */
    private String f5491f = null;

    /* renamed from: g, reason: collision with root package name */
    private int f5492g = 0;

    /* renamed from: h, reason: collision with root package name */
    private boolean f5493h = false;

    /* renamed from: i, reason: collision with root package name */
    private long f5494i = 0;

    /* renamed from: j, reason: collision with root package name */
    long f5495j = 0;

    /* renamed from: k, reason: collision with root package name */
    boolean f5496k = false;

    /* renamed from: l, reason: collision with root package name */
    private int f5497l = 0;

    /* renamed from: n, reason: collision with root package name */
    int f5499n = 240;

    /* renamed from: o, reason: collision with root package name */
    int f5500o = 80;

    /* renamed from: p, reason: collision with root package name */
    AMapLocation f5501p = null;

    /* renamed from: q, reason: collision with root package name */
    long f5502q = 0;
    float r = 0.0f;

    /* renamed from: s, reason: collision with root package name */
    Object f5503s = new Object();

    /* renamed from: t, reason: collision with root package name */
    Object f5504t = new Object();

    public static class a implements LocationListener {

        /* renamed from: a, reason: collision with root package name */
        private z f5507a;

        public a(z zVar) {
            this.f5507a = zVar;
        }

        public void a() {
            this.f5507a = null;
        }

        @Override // android.location.LocationListener
        public void onLocationChanged(Location location) {
            try {
                DebugUtils.writeCat("GLS olc", "tid=" + Thread.currentThread().getId());
                z zVar = this.f5507a;
                if (zVar != null) {
                    z.a(zVar, location);
                }
            } catch (Throwable unused) {
            }
        }

        @Override // android.location.LocationListener
        public void onProviderDisabled(String str) {
            try {
                z zVar = this.f5507a;
                if (zVar == null || !Const.PROVIDER_NETWORK.equalsIgnoreCase(str)) {
                    return;
                }
                zVar.f5495j = 0L;
            } catch (Throwable unused) {
            }
        }

        @Override // android.location.LocationListener
        public void onProviderEnabled(String str) {
        }

        @Override // android.location.LocationListener
        public void onStatusChanged(String str, int i3, Bundle bundle) {
            try {
                z zVar = this.f5507a;
                if (zVar == null || i3 != 0) {
                    return;
                }
                zVar.f5495j = 0L;
            } catch (Throwable unused) {
            }
        }
    }

    public z(Context context, Handler handler) {
        this.f5498m = null;
        AMapLocationClientOption.GeoLanguage geoLanguage = AMapLocationClientOption.GeoLanguage.DEFAULT;
        this.f5505u = 0L;
        this.f5506v = null;
        this.f5489c = context;
        this.f5488b = handler;
        try {
            this.f5490d = (LocationManager) context.getSystemService("location");
        } catch (Throwable th2) {
            CoreUtil.reportError(th2, "NetworkLocation", "<init>");
        }
        this.f5498m = new LocFilter();
    }

    private void d() {
        if (Utils.getTimeBoot() - f5485x > 5000 || !Utils.locCorrect(f5484w)) {
            return;
        }
        if (this.e.isMockEnable() || !f5484w.isMock()) {
            synchronized (this.f5503s) {
                a(f5484w, k.K);
            }
            this.f5495j = Utils.getTimeBoot();
            a(f5484w);
        }
    }

    @Override // com.amap.api.col.p0003sl.t
    public void a(AMapLocationClientOption aMapLocationClientOption) {
        this.e = aMapLocationClientOption;
        if (aMapLocationClientOption == null) {
            this.e = new AMapLocationClientOption();
        }
        try {
            f5487z = SPUtil.getPrefsLong(this.f5489c, Const.STR_PREF, Const.SP_KEY_LAST_AGPS_TIME, f5487z);
        } catch (Throwable unused) {
        }
        if (this.f5490d == null) {
            return;
        }
        try {
            d();
            Looper myLooper = Looper.myLooper();
            if (myLooper == null) {
                myLooper = this.f5489c.getMainLooper();
            }
            Looper looper = myLooper;
            this.f5494i = Utils.getTimeBoot();
            if (!a(this.f5490d)) {
                DebugUtils.writeCat("NetworkLocation | no network_provider");
                a(17, 13, "no network provider#1402", 0L);
                return;
            }
            try {
                if (Utils.getTime() - f5487z >= Const.MIN_TIME_AGPS_REQUEST) {
                    if (Utils.hasPerminssion(this.f5489c, Const.ACCESS_LOCATION_EXTRA_COMMANDS_SELF_BASE64)) {
                        this.f5490d.sendExtraCommand("gps", "force_xtra_injection", null);
                        f5487z = Utils.getTime();
                        SharedPreferences.Editor startEdit = SPUtil.startEdit(this.f5489c, Const.STR_PREF);
                        SPUtil.setPrefsLong(startEdit, Const.SP_KEY_LAST_AGPS_TIME, f5487z);
                        SPUtil.endEdit(startEdit);
                        DebugUtils.writeCat("GpsLocation | sendExtraCommand");
                    } else {
                        CoreUtil.reportError(new Exception("n_alec"), "OPENSDK_GL", "rlu_n_alec");
                    }
                }
            } catch (Throwable th2) {
                DebugUtils.writeCat("GpsLocation | sendExtraCommand error: " + th2.getMessage());
            }
            if (this.f5506v == null) {
                this.f5506v = new a(this);
            }
            if (!this.e.getLocationMode().equals(AMapLocationClientOption.AMapLocationMode.Battery_Saving) || this.e.getDeviceModeDistanceFilter() <= 0.0f) {
                this.f5490d.requestLocationUpdates(Const.PROVIDER_NETWORK, 900L, 0.0f, this.f5506v, looper);
            } else {
                this.f5490d.requestLocationUpdates(Const.PROVIDER_NETWORK, this.e.getInterval(), this.e.getDeviceModeDistanceFilter(), this.f5506v, looper);
            }
            a(17, 13, "no enough satellites#1401", this.e.getHttpTimeOut());
        } catch (SecurityException e) {
            DebugUtils.writeCat("NetworkLocation | no location permission");
            ReportUtil.reportLocError(null, ReportUtil.EXCEPTION_CODE_NOLOCPERMISSION);
            a(15, 12, e.getMessage() + "#1201", 0L);
        } catch (Throwable th3) {
            DebugUtils.writeCat(e.p(th3, new StringBuilder("NetworkLocation | requestLocationUpdates error: ")));
            CoreUtil.reportError(th3, "NetworkLocation", "requestLocationUpdates part2");
        }
    }

    public void b(AMapLocation aMapLocation) {
        if (Utils.locCorrect(aMapLocation) && this.f5488b != null) {
            long timeBoot = Utils.getTimeBoot();
            if (this.e.getInterval() <= Const.L_MIN_GET_REQ || timeBoot - this.f5505u > this.e.getInterval() - Const.L_MIN_GET_REQ) {
                Bundle bundle = new Bundle();
                bundle.putDouble(Const.JSON_KEY_LAT, aMapLocation.getLatitude());
                bundle.putDouble(Const.JSON_KEY_LON, aMapLocation.getLongitude());
                bundle.putFloat("radius", aMapLocation.getAccuracy());
                bundle.putLong(Const.JSON_KEY_TIME, aMapLocation.getTime());
                Message obtain = Message.obtain();
                obtain.setData(bundle);
                obtain.what = 14;
                synchronized (this.f5503s) {
                    try {
                        if (C == null) {
                            this.f5488b.sendMessage(obtain);
                        } else if (Utils.dist(aMapLocation, C) > this.f5500o) {
                            this.f5488b.sendMessage(obtain);
                        }
                    } catch (Throwable th2) {
                        throw th2;
                    }
                }
            }
        }
    }

    @Override // com.amap.api.col.p0003sl.t
    public void c() {
        LocationManager locationManager = this.f5490d;
        if (locationManager == null) {
            return;
        }
        try {
            LocationListener locationListener = this.f5506v;
            if (locationListener != null) {
                locationManager.removeUpdates(locationListener);
                ((a) this.f5506v).a();
                this.f5506v = null;
            }
        } catch (Throwable unused) {
        }
        try {
            Handler handler = this.f5488b;
            if (handler != null) {
                handler.removeMessages(17);
            }
        } catch (Throwable unused2) {
        }
        this.f5494i = 0L;
        this.f5505u = 0L;
        this.f5495j = 0L;
        this.f5497l = 0;
        this.f5498m.reset();
        this.f5501p = null;
        this.f5502q = 0L;
        this.r = 0.0f;
        this.f5491f = null;
    }

    private void c(AMapLocation aMapLocation) {
        try {
            if (CoreUtil.isChina(aMapLocation.getLatitude(), aMapLocation.getLongitude()) && this.e.isOffset()) {
                DPoint offset = OffsetUtil.offset(this.f5489c, new DPoint(aMapLocation.getLatitude(), aMapLocation.getLongitude()));
                aMapLocation.setLatitude(offset.getLatitude());
                aMapLocation.setLongitude(offset.getLongitude());
                aMapLocation.setOffset(this.e.isOffset());
                aMapLocation.setCoordType("GCJ02");
                return;
            }
            aMapLocation.setOffset(false);
            aMapLocation.setCoordType("WGS84");
        } catch (Throwable unused) {
            aMapLocation.setOffset(false);
            aMapLocation.setCoordType("WGS84");
        }
    }

    @Override // com.amap.api.col.p0003sl.u
    public boolean b() {
        return Utils.getTimeBoot() - this.f5495j <= 2800;
    }

    public boolean a(LocationManager locationManager) {
        try {
            if (A) {
                return B;
            }
            List<String> allProviders = locationManager.getAllProviders();
            if (allProviders != null && allProviders.size() > 0) {
                B = allProviders.contains(Const.PROVIDER_NETWORK);
            } else {
                B = false;
            }
            A = true;
            return B;
        } catch (Throwable th2) {
            DebugUtils.writeCat(e.p(th2, new StringBuilder("NetworkLocation | hasProvider error: ")));
            return B;
        }
    }

    private void a(int i3, int i10, String str, long j4) {
        try {
            if (this.f5488b == null || this.e.getLocationMode() != AMapLocationClientOption.AMapLocationMode.Battery_Saving) {
                return;
            }
            Message obtain = Message.obtain();
            AMapLocation aMapLocation = new AMapLocation("");
            aMapLocation.setProvider(Const.PROVIDER_NETWORK);
            aMapLocation.setErrorCode(i10);
            aMapLocation.setLocationDetail(str);
            aMapLocation.setLocationType(12);
            obtain.obj = aMapLocation;
            obtain.what = i3;
            this.f5488b.sendMessageDelayed(obtain, j4);
        } catch (Throwable unused) {
        }
    }

    public static void a(z zVar, Location location) {
        Handler handler = zVar.f5488b;
        if (handler != null) {
            handler.removeMessages(17);
        }
        if (location == null) {
            return;
        }
        try {
            AMapLocation aMapLocation = new AMapLocation(location);
            if (Utils.locCorrect(aMapLocation)) {
                aMapLocation.setProvider(Const.PROVIDER_NETWORK);
                aMapLocation.setLocationType(12);
                if (!zVar.f5496k && Utils.locCorrect(aMapLocation)) {
                    ReportUtil.reportGPSLocUseTime(zVar.f5489c, Utils.getTimeBoot() - zVar.f5494i, CoreUtil.isChina(aMapLocation.getLatitude(), aMapLocation.getLongitude()));
                    zVar.f5496k = true;
                }
                zVar.c(aMapLocation);
                if (Utils.locCorrect(aMapLocation) && zVar.f5497l >= 3) {
                    if (aMapLocation.getAccuracy() < 0.0f || aMapLocation.getAccuracy() == Float.MAX_VALUE) {
                        aMapLocation.setAccuracy(0.0f);
                    }
                    if (aMapLocation.getSpeed() < 0.0f || aMapLocation.getSpeed() == Float.MAX_VALUE) {
                        aMapLocation.setSpeed(0.0f);
                    }
                    aMapLocation = zVar.f5498m.filterGPSShake(aMapLocation);
                }
                if (Utils.locCorrect(aMapLocation)) {
                    zVar.f5495j = Utils.getTimeBoot();
                    synchronized (f5486y) {
                        f5485x = Utils.getTimeBoot();
                        f5484w = aMapLocation.m2clone();
                    }
                    zVar.f5497l++;
                }
                zVar.b(aMapLocation);
                synchronized (zVar.f5503s) {
                    zVar.a(aMapLocation, C);
                }
                try {
                    if (Utils.locCorrect(aMapLocation)) {
                        if (zVar.f5501p != null) {
                            zVar.f5502q = location.getTime() - zVar.f5501p.getTime();
                            zVar.r = Utils.dist(zVar.f5501p, aMapLocation);
                        }
                        synchronized (zVar.f5504t) {
                            zVar.f5501p = aMapLocation.m2clone();
                        }
                        zVar.f5491f = null;
                        zVar.f5493h = false;
                        zVar.f5492g = 0;
                    }
                } catch (Throwable th2) {
                    CoreUtil.reportError(th2, "NetworkLocation", "onLocationChangedLast");
                }
                zVar.a(aMapLocation);
            }
        } catch (Throwable th3) {
            CoreUtil.reportError(th3, "NetworkLocation", "onLocationChanged");
        }
    }

    private void a(AMapLocation aMapLocation) {
        if (aMapLocation.getErrorCode() != 15 || AMapLocationClientOption.AMapLocationMode.Battery_Saving.equals(this.e.getLocationMode())) {
            if (this.e.getLocationMode().equals(AMapLocationClientOption.AMapLocationMode.Battery_Saving) && this.e.getDeviceModeDistanceFilter() > 0.0f) {
                if (this.f5488b != null) {
                    Message obtain = Message.obtain();
                    obtain.obj = aMapLocation;
                    obtain.what = 15;
                    this.f5488b.sendMessage(obtain);
                    return;
                }
                return;
            }
            if (Utils.getTimeBoot() - this.f5505u >= this.e.getInterval() - 200) {
                this.f5505u = Utils.getTimeBoot();
                if (this.f5488b != null) {
                    Message obtain2 = Message.obtain();
                    obtain2.obj = aMapLocation;
                    obtain2.what = 15;
                    this.f5488b.sendMessage(obtain2);
                }
            }
        }
    }

    @Override // com.amap.api.col.p0003sl.t
    public void a(Bundle bundle) {
        if (bundle != null) {
            try {
                bundle.setClassLoader(AMapLocation.class.getClassLoader());
                this.f5499n = bundle.getInt("I_MAX_GEO_DIS", this.f5499n);
                this.f5500o = bundle.getInt("I_MIN_GEO_DIS", this.f5500o);
                AMapLocation aMapLocation = (AMapLocation) bundle.getParcelable("loc");
                if (TextUtils.isEmpty(aMapLocation.getAdCode())) {
                    return;
                }
                synchronized (this.f5503s) {
                    C = aMapLocation;
                }
            } catch (Throwable th2) {
                CoreUtil.reportError(th2, "NetworkLocation", "setLastGeoLocation");
            }
        }
    }

    private void a(AMapLocation aMapLocation, AMapLocation aMapLocation2) {
        if (aMapLocation2 == null || !this.e.isNeedAddress() || Utils.dist(aMapLocation, aMapLocation2) >= this.f5499n) {
            return;
        }
        CoreUtil.transformAddress(aMapLocation, aMapLocation2);
    }

    @Override // com.amap.api.col.p0003sl.u
    public boolean a() {
        AMapLocationClientOption aMapLocationClientOption = this.e;
        return (aMapLocationClientOption == null || aMapLocationClientOption.isOnceLocation() || Utils.getTimeBoot() - this.f5495j <= Const.L_GPS_REBOOT_INTERVAL) ? false : true;
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x0098  */
    @Override // com.amap.api.col.p0003sl.u
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public com.amap.api.location.AMapLocation a(com.amap.api.location.AMapLocation r17, java.lang.String r18) {
        /*
            Method dump skipped, instructions count: 216
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.p0003sl.z.a(com.amap.api.location.AMapLocation, java.lang.String):com.amap.api.location.AMapLocation");
    }

    private boolean a(String str) {
        try {
            ArrayList<String> wifiListFromStrNb = Utils.getWifiListFromStrNb(str);
            ArrayList<String> wifiListFromStrNb2 = Utils.getWifiListFromStrNb(this.f5491f);
            if (wifiListFromStrNb == null || wifiListFromStrNb.size() < 8 || wifiListFromStrNb2 == null || wifiListFromStrNb2.size() < 8) {
                return false;
            }
            return Utils.nbWifiSimiMem(this.f5491f, str);
        } catch (Throwable unused) {
            return false;
        }
    }
}
