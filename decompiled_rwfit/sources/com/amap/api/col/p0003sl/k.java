package com.amap.api.col.p0003sl;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.location.GnssStatus;
import android.location.GpsSatellite;
import android.location.GpsStatus;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.provider.Settings;
import android.support.v4.media.session.e;
import android.text.TextUtils;
import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.location.DPoint;
import com.autonavi.aps.amapapi.config.Const;
import com.autonavi.aps.amapapi.filters.LocFilter;
import com.autonavi.aps.amapapi.utils.AuthUtil;
import com.autonavi.aps.amapapi.utils.CoreUtil;
import com.autonavi.aps.amapapi.utils.DateUtil;
import com.autonavi.aps.amapapi.utils.DebugUtils;
import com.autonavi.aps.amapapi.utils.OffsetUtil;
import com.autonavi.aps.amapapi.utils.Reflect;
import com.autonavi.aps.amapapi.utils.ReportUtil;
import com.autonavi.aps.amapapi.utils.SPUtil;
import com.autonavi.aps.amapapi.utils.Utils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public class k implements r {
    static AMapLocation E = null;
    static long F = 0;
    static Object G = new Object();
    static long H = 0;
    static boolean I = false;
    static boolean J = false;
    public static volatile AMapLocation K;

    /* renamed from: b, reason: collision with root package name */
    Handler f4339b;

    /* renamed from: c, reason: collision with root package name */
    private Context f4340c;

    /* renamed from: d, reason: collision with root package name */
    LocationManager f4341d;
    AMapLocationClientOption e;

    /* renamed from: j, reason: collision with root package name */
    LocFilter f4346j;

    /* renamed from: u, reason: collision with root package name */
    private GnssStatus.Callback f4356u;

    /* renamed from: f, reason: collision with root package name */
    private long f4342f = 0;

    /* renamed from: g, reason: collision with root package name */
    long f4343g = 0;

    /* renamed from: h, reason: collision with root package name */
    boolean f4344h = false;

    /* renamed from: i, reason: collision with root package name */
    private int f4345i = 0;

    /* renamed from: k, reason: collision with root package name */
    int f4347k = 240;

    /* renamed from: l, reason: collision with root package name */
    int f4348l = 80;

    /* renamed from: m, reason: collision with root package name */
    AMapLocation f4349m = null;

    /* renamed from: n, reason: collision with root package name */
    long f4350n = 0;

    /* renamed from: o, reason: collision with root package name */
    float f4351o = 0.0f;

    /* renamed from: p, reason: collision with root package name */
    Object f4352p = new Object();

    /* renamed from: q, reason: collision with root package name */
    Object f4353q = new Object();
    private int r = 0;

    /* renamed from: s, reason: collision with root package name */
    private GpsStatus f4354s = null;

    /* renamed from: t, reason: collision with root package name */
    private GpsStatus.Listener f4355t = null;

    /* renamed from: v, reason: collision with root package name */
    AMapLocationClientOption.GeoLanguage f4357v = AMapLocationClientOption.GeoLanguage.DEFAULT;

    /* renamed from: w, reason: collision with root package name */
    boolean f4358w = true;

    /* renamed from: x, reason: collision with root package name */
    long f4359x = 0;

    /* renamed from: y, reason: collision with root package name */
    int f4360y = 0;

    /* renamed from: z, reason: collision with root package name */
    LocationListener f4361z = null;
    private String A = null;
    private boolean B = false;
    private int C = 0;
    private boolean D = false;

    public static class a implements LocationListener {

        /* renamed from: a, reason: collision with root package name */
        private k f4362a;

        public a(k kVar) {
            this.f4362a = kVar;
        }

        public void a() {
            this.f4362a = null;
        }

        @Override // android.location.LocationListener
        public void onLocationChanged(Location location) {
            try {
                DebugUtils.writeCat("GLS olc", "tid=" + Thread.currentThread().getId());
                k kVar = this.f4362a;
                if (kVar != null) {
                    k.a(kVar, location);
                }
            } catch (Throwable unused) {
            }
        }

        @Override // android.location.LocationListener
        public void onProviderDisabled(String str) {
            try {
                k kVar = this.f4362a;
                if (kVar != null) {
                    k.a(kVar, str);
                }
            } catch (Throwable unused) {
            }
        }

        @Override // android.location.LocationListener
        public void onProviderEnabled(String str) {
        }

        @Override // android.location.LocationListener
        public void onStatusChanged(String str, int i3, Bundle bundle) {
            try {
                k kVar = this.f4362a;
                if (kVar != null) {
                    k.a(kVar, str, i3, bundle);
                }
            } catch (Throwable unused) {
            }
        }
    }

    public k(Context context, Handler handler) {
        this.f4346j = null;
        this.f4340c = context;
        this.f4339b = handler;
        try {
            this.f4341d = (LocationManager) context.getSystemService("location");
        } catch (Throwable th2) {
            CoreUtil.reportError(th2, "GpsLocation", "<init>");
        }
        this.f4346j = new LocFilter();
    }

    public static void a(k kVar) {
        kVar.getClass();
        DebugUtils.writeCat("GpsLocation | status stopped ");
        kVar.r = 0;
    }

    public static void c(k kVar) {
        Iterable<GpsSatellite> satellites;
        kVar.getClass();
        int i3 = 0;
        try {
            GpsStatus gpsStatus = kVar.f4354s;
            if (gpsStatus != null && (satellites = gpsStatus.getSatellites()) != null) {
                Iterator<GpsSatellite> it = satellites.iterator();
                int maxSatellites = kVar.f4354s.getMaxSatellites();
                while (it.hasNext() && i3 < maxSatellites) {
                    if (it.next().usedInFix()) {
                        i3++;
                    }
                }
            }
        } catch (Throwable th2) {
            CoreUtil.reportError(th2, "GpsLocation", "GPS_EVENT_SATELLITE_STATUS");
        }
        kVar.r = i3;
    }

    private void d() {
        if (Utils.getTimeBoot() - F > 5000 || !Utils.locCorrect(E)) {
            return;
        }
        if (this.e.isMockEnable() || !E.isMock()) {
            synchronized (this.f4352p) {
                a(E, K);
            }
            this.f4343g = Utils.getTimeBoot();
            a(E);
        }
    }

    private boolean g() {
        try {
            return ((Boolean) Reflect.invokeStaticMethod(n9.b("KY29tLmFtYXAuYXBpLm5hdmkuQU1hcE5hdmk="), n9.b("UaXNOYXZpU3RhcnRlZA=="), (Object[]) null, (Class<?>[]) null)).booleanValue();
        } catch (Throwable unused) {
            return false;
        }
    }

    @SuppressLint({"NewApi"})
    public int e() {
        LocationManager locationManager = this.f4341d;
        if (locationManager == null || !a(locationManager)) {
            return 1;
        }
        int i3 = Settings.Secure.getInt(this.f4340c.getContentResolver(), "location_mode", 0);
        if (i3 == 0) {
            return 2;
        }
        if (i3 == 2) {
            return 3;
        }
        return !this.f4358w ? 4 : 0;
    }

    public int f() {
        return this.r;
    }

    public void b(AMapLocationClientOption aMapLocationClientOption) {
        Handler handler;
        if (aMapLocationClientOption == null) {
            aMapLocationClientOption = new AMapLocationClientOption();
        }
        this.e = aMapLocationClientOption;
        if (aMapLocationClientOption.getLocationMode() != AMapLocationClientOption.AMapLocationMode.Device_Sensors && (handler = this.f4339b) != null) {
            handler.removeMessages(8);
        }
        if (this.f4357v != this.e.getGeoLanguage()) {
            synchronized (this.f4352p) {
                K = null;
            }
        }
        this.f4357v = this.e.getGeoLanguage();
    }

    public static void a(k kVar, GnssStatus gnssStatus) {
        kVar.getClass();
        int i3 = 0;
        if (gnssStatus != null) {
            try {
                int satelliteCount = gnssStatus.getSatelliteCount();
                int i10 = 0;
                while (i3 < satelliteCount) {
                    try {
                        if (gnssStatus.usedInFix(i3)) {
                            i10++;
                        }
                        i3++;
                    } catch (Throwable th2) {
                        th = th2;
                        i3 = i10;
                        CoreUtil.reportError(th, "GpsLocation_Gnss", "GPS_EVENT_SATELLITE_STATUS");
                        kVar.r = i3;
                    }
                }
                i3 = i10;
            } catch (Throwable th3) {
                th = th3;
            }
        }
        kVar.r = i3;
    }

    public static void a(k kVar, String str) {
        kVar.getClass();
        try {
            if ("gps".equalsIgnoreCase(str)) {
                kVar.f4343g = 0L;
                kVar.r = 0;
            }
        } catch (Throwable unused) {
        }
    }

    public void b(AMapLocation aMapLocation) {
        if (Utils.locCorrect(aMapLocation) && this.f4339b != null) {
            long timeBoot = Utils.getTimeBoot();
            if (this.e.getInterval() <= Const.L_MIN_GET_REQ || timeBoot - this.f4359x > this.e.getInterval() - Const.L_MIN_GET_REQ) {
                Bundle bundle = new Bundle();
                bundle.putDouble(Const.JSON_KEY_LAT, aMapLocation.getLatitude());
                bundle.putDouble(Const.JSON_KEY_LON, aMapLocation.getLongitude());
                bundle.putBoolean(Const.JSON_KEY_ISOFFSET, aMapLocation.isOffset());
                bundle.putFloat("radius", aMapLocation.getAccuracy());
                bundle.putLong(Const.JSON_KEY_TIME, aMapLocation.getTime());
                bundle.putInt("locationType", aMapLocation.getLocationType());
                Message obtain = Message.obtain();
                obtain.setData(bundle);
                obtain.what = 5;
                synchronized (this.f4352p) {
                    try {
                        if (K == null) {
                            this.f4339b.sendMessage(obtain);
                        } else if (Utils.dist(aMapLocation, K) > this.f4348l) {
                            this.f4339b.sendMessage(obtain);
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
        LocationManager locationManager = this.f4341d;
        if (locationManager == null) {
            return;
        }
        try {
            LocationListener locationListener = this.f4361z;
            if (locationListener != null) {
                locationManager.removeUpdates(locationListener);
                ((a) this.f4361z).a();
                this.f4361z = null;
            }
        } catch (Throwable unused) {
        }
        try {
            GpsStatus.Listener listener = this.f4355t;
            if (listener != null) {
                this.f4341d.removeGpsStatusListener(listener);
            }
        } catch (Throwable unused2) {
        }
        try {
            GnssStatus.Callback callback = this.f4356u;
            if (callback != null) {
                this.f4341d.unregisterGnssStatusCallback(callback);
            }
        } catch (Throwable unused3) {
        }
        try {
            Handler handler = this.f4339b;
            if (handler != null) {
                handler.removeMessages(8);
            }
        } catch (Throwable unused4) {
        }
        this.r = 0;
        this.f4342f = 0L;
        this.f4359x = 0L;
        this.f4343g = 0L;
        this.f4345i = 0;
        this.f4360y = 0;
        this.f4346j.reset();
        this.f4349m = null;
        this.f4350n = 0L;
        this.f4351o = 0.0f;
        this.A = null;
        this.D = false;
    }

    public static void a(k kVar, String str, int i3, Bundle bundle) {
        kVar.getClass();
        if (i3 == 0) {
            try {
                kVar.f4343g = 0L;
                kVar.r = 0;
            } catch (Throwable unused) {
            }
        }
    }

    @Override // com.amap.api.col.p0003sl.t
    public void a(AMapLocationClientOption aMapLocationClientOption) {
        k kVar;
        Throwable th2;
        this.e = aMapLocationClientOption;
        if (aMapLocationClientOption == null) {
            this.e = new AMapLocationClientOption();
        }
        try {
            H = SPUtil.getPrefsLong(this.f4340c, Const.STR_PREF, Const.SP_KEY_LAST_AGPS_TIME, H);
        } catch (Throwable unused) {
        }
        if (this.f4341d == null) {
            return;
        }
        try {
            try {
                d();
                this.f4358w = true;
                Looper myLooper = Looper.myLooper();
                if (myLooper == null) {
                    try {
                        myLooper = this.f4340c.getMainLooper();
                    } catch (Throwable th3) {
                        th2 = th3;
                        DebugUtils.writeCat(e.p(th2, new StringBuilder("GpsLocation | requestLocationUpdates error: ")));
                        CoreUtil.reportError(th2, "GpsLocation", "requestLocationUpdates part2");
                    }
                }
                Looper looper = myLooper;
                this.f4342f = Utils.getTimeBoot();
                if (a(this.f4341d)) {
                    try {
                        if (Utils.getTime() - H >= Const.MIN_TIME_AGPS_REQUEST) {
                            if (Utils.hasPerminssion(this.f4340c, Const.ACCESS_LOCATION_EXTRA_COMMANDS_SELF_BASE64)) {
                                this.f4341d.sendExtraCommand("gps", "force_xtra_injection", null);
                                H = Utils.getTime();
                                SharedPreferences.Editor startEdit = SPUtil.startEdit(this.f4340c, Const.STR_PREF);
                                SPUtil.setPrefsLong(startEdit, Const.SP_KEY_LAST_AGPS_TIME, H);
                                SPUtil.endEdit(startEdit);
                                DebugUtils.writeCat("GpsLocation | sendExtraCommand");
                            } else {
                                CoreUtil.reportError(new Exception("n_alec"), "OPENSDK_GL", "rlu_n_alec");
                            }
                        }
                    } catch (Throwable th4) {
                        DebugUtils.writeCat("GpsLocation | sendExtraCommand error: " + th4.getMessage());
                    }
                    if (this.f4361z == null) {
                        this.f4361z = new a(this);
                    }
                    if (this.e.getLocationMode().equals(AMapLocationClientOption.AMapLocationMode.Device_Sensors) && this.e.getDeviceModeDistanceFilter() > 0.0f) {
                        this.f4341d.requestLocationUpdates("gps", this.e.getInterval(), this.e.getDeviceModeDistanceFilter(), this.f4361z, looper);
                    } else {
                        this.f4341d.requestLocationUpdates("gps", 900L, 0.0f, this.f4361z, looper);
                    }
                    i iVar = new i(this);
                    this.f4356u = iVar;
                    this.f4341d.registerGnssStatusCallback(iVar);
                    a(8, 14, "no enough satellites#1401", this.e.getHttpTimeOut());
                    return;
                }
                DebugUtils.writeCat("GpsLocation | no GPS_provider");
                kVar = this;
                try {
                    kVar.a(8, 14, "no gps provider#1402", 0L);
                } catch (SecurityException e) {
                    e = e;
                    DebugUtils.writeCat("GpsLocation | no location permission");
                    kVar.f4358w = false;
                    ReportUtil.reportLocError(null, ReportUtil.EXCEPTION_CODE_NOLOCPERMISSION);
                    kVar.a(2, 12, e.getMessage() + "#1201", 0L);
                } catch (Throwable th5) {
                    th = th5;
                    th2 = th;
                    DebugUtils.writeCat(e.p(th2, new StringBuilder("GpsLocation | requestLocationUpdates error: ")));
                    CoreUtil.reportError(th2, "GpsLocation", "requestLocationUpdates part2");
                }
            } catch (Throwable th6) {
                th = th6;
            }
        } catch (SecurityException e10) {
            e = e10;
            kVar = this;
        }
    }

    private void c(AMapLocation aMapLocation) {
        try {
            if (CoreUtil.isChina(aMapLocation.getLatitude(), aMapLocation.getLongitude()) && this.e.isOffset()) {
                DPoint offset = OffsetUtil.offset(this.f4340c, new DPoint(aMapLocation.getLatitude(), aMapLocation.getLongitude()));
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

    public boolean a(LocationManager locationManager) {
        try {
            if (I) {
                return J;
            }
            List<String> allProviders = locationManager.getAllProviders();
            if (allProviders != null && allProviders.size() > 0) {
                J = allProviders.contains("gps");
            } else {
                J = false;
            }
            I = true;
            return J;
        } catch (Throwable th2) {
            DebugUtils.writeCat(e.p(th2, new StringBuilder("GpsLocation | hasProvider error: ")));
            return J;
        }
    }

    private void a(int i3, int i10, String str, long j4) {
        try {
            if (this.f4339b == null || this.e.getLocationMode() != AMapLocationClientOption.AMapLocationMode.Device_Sensors) {
                return;
            }
            Message obtain = Message.obtain();
            AMapLocation aMapLocation = new AMapLocation("");
            aMapLocation.setProvider("gps");
            aMapLocation.setErrorCode(i10);
            aMapLocation.setLocationDetail(str);
            aMapLocation.setLocationType(1);
            obtain.obj = aMapLocation;
            obtain.what = i3;
            this.f4339b.sendMessageDelayed(obtain, j4);
        } catch (Throwable unused) {
        }
    }

    public static void a(k kVar, Location location) {
        Handler handler = kVar.f4339b;
        if (handler != null) {
            handler.removeMessages(8);
        }
        if (location == null) {
            return;
        }
        try {
            AMapLocation aMapLocation = new AMapLocation(location);
            if (Utils.locCorrect(aMapLocation)) {
                aMapLocation.setProvider("gps");
                aMapLocation.setLocationType(1);
                if (!kVar.f4344h && Utils.locCorrect(aMapLocation)) {
                    ReportUtil.reportGPSLocUseTime(kVar.f4340c, Utils.getTimeBoot() - kVar.f4342f, CoreUtil.isChina(aMapLocation.getLatitude(), aMapLocation.getLongitude()));
                    kVar.f4344h = true;
                }
                if (Utils.isGpsMock(location, kVar.r)) {
                    aMapLocation.setMock(true);
                    aMapLocation.setTrustedLevel(4);
                    if (!kVar.e.isMockEnable()) {
                        int i3 = kVar.f4360y;
                        if (i3 > 3) {
                            ReportUtil.reportLocError(null, ReportUtil.EXCEPTION_CODE_MOCKGPSLOC);
                            aMapLocation.setErrorCode(15);
                            aMapLocation.setLocationDetail("GpsLocation has been mocked!#1501");
                            aMapLocation.setLatitude(0.0d);
                            aMapLocation.setLongitude(0.0d);
                            aMapLocation.setAltitude(0.0d);
                            aMapLocation.setSpeed(0.0f);
                            aMapLocation.setAccuracy(0.0f);
                            aMapLocation.setBearing(0.0f);
                            aMapLocation.setExtras(null);
                            kVar.a(aMapLocation);
                            return;
                        }
                        kVar.f4360y = i3 + 1;
                        return;
                    }
                } else {
                    kVar.f4360y = 0;
                }
                aMapLocation.setSatellites(kVar.r);
                kVar.c(aMapLocation);
                try {
                    int i10 = kVar.r;
                    if (i10 >= 4) {
                        aMapLocation.setGpsAccuracyStatus(1);
                    } else if (i10 == 0) {
                        aMapLocation.setGpsAccuracyStatus(-1);
                    } else {
                        aMapLocation.setGpsAccuracyStatus(0);
                    }
                } catch (Throwable unused) {
                }
                if (Utils.locCorrect(aMapLocation) && AuthUtil.isNeedCheckGpsTime()) {
                    long time = aMapLocation.getTime();
                    long currentTimeMillis = System.currentTimeMillis();
                    long correctedGpsTime = DateUtil.getCorrectedGpsTime(time, currentTimeMillis, AuthUtil.getCheckGPSTimeOffsetYear());
                    if (correctedGpsTime != time) {
                        aMapLocation.setTime(correctedGpsTime);
                        ReportUtil.reportCheckGPSTime(time, currentTimeMillis);
                    }
                }
                if (Utils.locCorrect(aMapLocation) && kVar.f4345i >= 3) {
                    if (aMapLocation.getAccuracy() < 0.0f || aMapLocation.getAccuracy() == Float.MAX_VALUE) {
                        aMapLocation.setAccuracy(0.0f);
                    }
                    if (aMapLocation.getSpeed() < 0.0f || aMapLocation.getSpeed() == Float.MAX_VALUE) {
                        aMapLocation.setSpeed(0.0f);
                    }
                    aMapLocation = kVar.f4346j.filterGPSShake(aMapLocation);
                }
                if (Utils.locCorrect(aMapLocation)) {
                    kVar.f4343g = Utils.getTimeBoot();
                    synchronized (G) {
                        F = Utils.getTimeBoot();
                        E = aMapLocation.m2clone();
                    }
                    kVar.f4345i++;
                }
                kVar.b(aMapLocation);
                synchronized (kVar.f4352p) {
                    kVar.a(aMapLocation, K);
                }
                try {
                    if (Utils.locCorrect(aMapLocation)) {
                        if (kVar.f4349m != null) {
                            kVar.f4350n = location.getTime() - kVar.f4349m.getTime();
                            kVar.f4351o = Utils.dist(kVar.f4349m, aMapLocation);
                        }
                        synchronized (kVar.f4353q) {
                            kVar.f4349m = aMapLocation.m2clone();
                        }
                        kVar.A = null;
                        kVar.B = false;
                        kVar.C = 0;
                    }
                } catch (Throwable th2) {
                    CoreUtil.reportError(th2, "GpsLocation", "onLocationChangedLast");
                }
                kVar.a(aMapLocation);
            }
        } catch (Throwable th3) {
            CoreUtil.reportError(th3, "GpsLocation", "onLocationChanged");
        }
    }

    private void a(AMapLocation aMapLocation) {
        if (aMapLocation.getErrorCode() != 15 || AMapLocationClientOption.AMapLocationMode.Device_Sensors.equals(this.e.getLocationMode())) {
            if (this.e.getLocationMode().equals(AMapLocationClientOption.AMapLocationMode.Device_Sensors) && this.e.getDeviceModeDistanceFilter() > 0.0f) {
                if (this.f4339b != null) {
                    Message obtain = Message.obtain();
                    obtain.obj = aMapLocation;
                    obtain.what = 2;
                    this.f4339b.sendMessage(obtain);
                    return;
                }
                return;
            }
            if (Utils.getTimeBoot() - this.f4359x >= this.e.getInterval() - 200) {
                this.f4359x = Utils.getTimeBoot();
                if (this.f4339b != null) {
                    Message obtain2 = Message.obtain();
                    obtain2.obj = aMapLocation;
                    obtain2.what = 2;
                    this.f4339b.sendMessage(obtain2);
                }
            }
        }
    }

    @Override // com.amap.api.col.p0003sl.t
    public void a(Bundle bundle) {
        if (bundle != null) {
            try {
                bundle.setClassLoader(AMapLocation.class.getClassLoader());
                this.f4347k = bundle.getInt("I_MAX_GEO_DIS", this.f4347k);
                this.f4348l = bundle.getInt("I_MIN_GEO_DIS", this.f4348l);
                AMapLocation aMapLocation = (AMapLocation) bundle.getParcelable("loc");
                if (TextUtils.isEmpty(aMapLocation.getAdCode())) {
                    return;
                }
                synchronized (this.f4352p) {
                    K = aMapLocation;
                }
            } catch (Throwable th2) {
                CoreUtil.reportError(th2, "GpsLocation", "setLastGeoLocation");
            }
        }
    }

    private void a(AMapLocation aMapLocation, AMapLocation aMapLocation2) {
        if (aMapLocation2 == null || !this.e.isNeedAddress() || Utils.dist(aMapLocation, aMapLocation2) >= this.f4347k) {
            return;
        }
        CoreUtil.transformAddress(aMapLocation, aMapLocation2);
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0126  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x013c  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0156  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0168  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x019f  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x017f  */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public com.amap.api.location.AMapLocation a(com.amap.api.location.AMapLocation r18, java.lang.String r19) {
        /*
            Method dump skipped, instructions count: 481
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.p0003sl.k.a(com.amap.api.location.AMapLocation, java.lang.String):com.amap.api.location.AMapLocation");
    }

    private boolean a(String str) {
        try {
            ArrayList<String> wifiListFromStrNb = Utils.getWifiListFromStrNb(str);
            ArrayList<String> wifiListFromStrNb2 = Utils.getWifiListFromStrNb(this.A);
            if (wifiListFromStrNb == null || wifiListFromStrNb.size() < 8 || wifiListFromStrNb2 == null || wifiListFromStrNb2.size() < 8) {
                return false;
            }
            return Utils.nbWifiSimiMem(this.A, str);
        } catch (Throwable unused) {
            return false;
        }
    }
}
