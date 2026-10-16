package com.amap.api.col.p0003sl;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
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
import com.autonavi.aps.amapapi.model.AMapLocationServer;
import com.autonavi.aps.amapapi.utils.CoreUtil;
import com.autonavi.aps.amapapi.utils.DebugUtils;
import com.autonavi.aps.amapapi.utils.OffsetUtil;
import com.autonavi.aps.amapapi.utils.Reflect;
import com.autonavi.aps.amapapi.utils.ReportUtil;
import com.autonavi.aps.amapapi.utils.SPUtil;
import com.autonavi.aps.amapapi.utils.Utils;
import java.util.List;

/* loaded from: classes.dex */
public class h implements p {

    /* renamed from: s, reason: collision with root package name */
    private static long f4219s = 0;

    /* renamed from: t, reason: collision with root package name */
    private static boolean f4220t = false;

    /* renamed from: u, reason: collision with root package name */
    private static boolean f4221u = false;

    /* renamed from: v, reason: collision with root package name */
    private static boolean f4222v = false;

    /* renamed from: w, reason: collision with root package name */
    private static boolean f4223w = false;

    /* renamed from: x, reason: collision with root package name */
    public static volatile AMapLocation f4224x;
    private LocFilter e;

    /* renamed from: i, reason: collision with root package name */
    private Handler f4231i;

    /* renamed from: j, reason: collision with root package name */
    private Context f4232j;

    /* renamed from: m, reason: collision with root package name */
    private LocationManager f4235m;

    /* renamed from: n, reason: collision with root package name */
    private AMapLocationClientOption f4236n;

    /* renamed from: b, reason: collision with root package name */
    private long f4225b = 0;

    /* renamed from: c, reason: collision with root package name */
    private boolean f4226c = false;

    /* renamed from: d, reason: collision with root package name */
    private int f4227d = 0;

    /* renamed from: f, reason: collision with root package name */
    private int f4228f = 240;

    /* renamed from: g, reason: collision with root package name */
    private int f4229g = 80;

    /* renamed from: h, reason: collision with root package name */
    private int f4230h = 0;

    /* renamed from: k, reason: collision with root package name */
    private long f4233k = 0;

    /* renamed from: l, reason: collision with root package name */
    private int f4234l = 0;

    /* renamed from: o, reason: collision with root package name */
    private Object f4237o = new Object();

    /* renamed from: p, reason: collision with root package name */
    private boolean f4238p = true;

    /* renamed from: q, reason: collision with root package name */
    private AMapLocationClientOption.GeoLanguage f4239q = AMapLocationClientOption.GeoLanguage.DEFAULT;
    private LocationListener r = null;

    public static class a implements LocationListener {

        /* renamed from: a, reason: collision with root package name */
        private h f4240a;

        public a(h hVar) {
            this.f4240a = hVar;
        }

        public void a() {
            this.f4240a = null;
        }

        @Override // android.location.LocationListener
        public void onLocationChanged(Location location) {
            try {
                h hVar = this.f4240a;
                if (hVar != null) {
                    h.a(hVar, location);
                }
            } catch (Throwable unused) {
            }
        }

        @Override // android.location.LocationListener
        public void onProviderDisabled(String str) {
            try {
                h hVar = this.f4240a;
                if (hVar != null) {
                    h.a(hVar, str);
                }
            } catch (Throwable unused) {
            }
        }

        @Override // android.location.LocationListener
        public void onProviderEnabled(String str) {
            if ("gps".equalsIgnoreCase(str)) {
                DebugUtils.writeCat("CoarseLocation | onProviderEnabled  ");
            }
        }

        @Override // android.location.LocationListener
        public void onStatusChanged(String str, int i3, Bundle bundle) {
            try {
                h hVar = this.f4240a;
                if (hVar != null) {
                    h.a(hVar, str, i3, bundle);
                }
            } catch (Throwable unused) {
            }
        }
    }

    public h(Context context, Handler handler) {
        this.e = null;
        this.f4232j = context;
        this.f4231i = handler;
        try {
            this.f4235m = (LocationManager) context.getSystemService("location");
        } catch (Throwable th2) {
            CoreUtil.reportError(th2, "CoarseLocation", "<init>");
        }
        this.e = new LocFilter();
    }

    public static void a(h hVar, String str) {
        hVar.getClass();
        try {
            DebugUtils.writeCat("CoarseLocation | onProviderDisabled  ");
            hVar.f4230h = 0;
        } catch (Throwable unused) {
        }
    }

    private void d(AMapLocation aMapLocation) {
        if (this.f4231i != null) {
            DebugUtils.writeCat("CoarseLocation | callBackGpsResult");
            Message obtain = Message.obtain();
            obtain.obj = aMapLocation;
            obtain.what = 101;
            this.f4231i.sendMessage(obtain);
        }
    }

    private boolean e() {
        boolean z5 = true;
        try {
            if (Utils.getSdk() >= 28) {
                if (this.f4235m == null) {
                    this.f4235m = (LocationManager) this.f4232j.getApplicationContext().getSystemService("location");
                }
                z5 = ((Boolean) Reflect.invokeMethod(this.f4235m, "isLocationEnabled", new Object[0])).booleanValue();
            }
            if (Utils.getSdk() >= 24 && Utils.getSdk() < 28) {
                if (Settings.Secure.getInt(this.f4232j.getContentResolver(), "location_mode", 0) == 0) {
                    return false;
                }
            }
            return z5;
        } catch (Throwable unused) {
            DebugUtils.writeCat("CoarseLocation | isLocationSwitchOpen error");
            return z5;
        }
    }

    public void b(AMapLocationClientOption aMapLocationClientOption) {
        if (aMapLocationClientOption == null) {
            aMapLocationClientOption = new AMapLocationClientOption();
        }
        this.f4236n = aMapLocationClientOption;
        DebugUtils.writeCat("CoarseLocation | setLocationOption ", "option: " + this.f4236n.toString());
        this.f4231i.removeMessages(100);
        if (this.f4239q != this.f4236n.getGeoLanguage()) {
            synchronized (this.f4237o) {
                f4224x = null;
            }
        }
        this.f4239q = this.f4236n.getGeoLanguage();
    }

    @Override // com.amap.api.col.p0003sl.t
    public void c() {
        DebugUtils.writeCat("CoarseLocation | stopLocation ");
        LocationManager locationManager = this.f4235m;
        if (locationManager == null) {
            return;
        }
        try {
            LocationListener locationListener = this.r;
            if (locationListener != null) {
                locationManager.removeUpdates(locationListener);
                ((a) this.r).a();
                this.r = null;
                DebugUtils.writeCat("CoarseLocation | removeUpdates ");
            }
        } catch (Throwable th2) {
            DebugUtils.writeCat(e.p(th2, new StringBuilder("CoarseLocation | removeUpdates error ")));
        }
        try {
            Handler handler = this.f4231i;
            if (handler != null) {
                handler.removeMessages(100);
            }
        } catch (Throwable unused) {
        }
        this.f4230h = 0;
        this.f4225b = 0L;
        this.f4233k = 0L;
        this.f4227d = 0;
        this.f4234l = 0;
        this.e.reset();
    }

    public static void a(h hVar, String str, int i3, Bundle bundle) {
        hVar.getClass();
        if (i3 == 0) {
            try {
                DebugUtils.writeCat("CoarseLocation | gps is outOfService  ");
                hVar.f4230h = 0;
            } catch (Throwable unused) {
            }
        }
    }

    @Override // com.amap.api.col.p0003sl.t
    public void a(AMapLocationClientOption aMapLocationClientOption) {
        this.f4236n = aMapLocationClientOption;
        if (aMapLocationClientOption == null) {
            this.f4236n = new AMapLocationClientOption();
        }
        DebugUtils.writeCat("CoarseLocation | startLocation ", "option: " + this.f4236n.toString());
        if (!this.f4236n.isOnceLocation()) {
            AMapLocationServer aMapLocationServer = new AMapLocationServer("");
            aMapLocationServer.setErrorCode(20);
            aMapLocationServer.setLocationDetail("模糊权限下不支持连续定位#2006");
            a(aMapLocationServer);
            return;
        }
        if (e()) {
            try {
                f4219s = SPUtil.getPrefsLong(this.f4232j, Const.STR_PREF, Const.SP_KEY_LAST_AGPS_TIME, f4219s);
            } catch (Throwable unused) {
            }
            if (this.f4235m == null) {
                return;
            }
            try {
                this.f4238p = true;
                Looper myLooper = Looper.myLooper();
                if (myLooper == null) {
                    myLooper = this.f4232j.getMainLooper();
                }
                Looper looper = myLooper;
                this.f4225b = Utils.getTimeBoot();
                if (b(this.f4235m)) {
                    if (this.r == null) {
                        this.r = new a(this);
                    }
                    this.f4235m.requestLocationUpdates(Const.PROVIDER_NETWORK, this.f4236n.getInterval(), this.f4236n.getDeviceModeDistanceFilter(), this.r, looper);
                }
                if (a(this.f4235m)) {
                    try {
                        if (Utils.getTime() - f4219s >= Const.MIN_TIME_AGPS_REQUEST) {
                            if (Utils.hasPerminssion(this.f4232j, Const.ACCESS_LOCATION_EXTRA_COMMANDS_SELF_BASE64)) {
                                this.f4235m.sendExtraCommand("gps", "force_xtra_injection", null);
                                f4219s = Utils.getTime();
                                SharedPreferences.Editor startEdit = SPUtil.startEdit(this.f4232j, Const.STR_PREF);
                                SPUtil.setPrefsLong(startEdit, Const.SP_KEY_LAST_AGPS_TIME, f4219s);
                                SPUtil.endEdit(startEdit);
                                DebugUtils.writeCat("CoarseLocation | sendExtraCommand");
                            } else {
                                CoreUtil.reportError(new Exception("n_alec"), "OPENSDK_CL", "rlu_n_alec");
                            }
                        }
                    } catch (Throwable th2) {
                        DebugUtils.writeCat("CoarseLocation | sendExtraCommand error: " + th2.getMessage());
                    }
                    if (this.r == null) {
                        this.r = new a(this);
                    }
                    this.f4235m.requestLocationUpdates("gps", this.f4236n.getInterval(), this.f4236n.getDeviceModeDistanceFilter(), this.r, looper);
                    DebugUtils.writeCat("CoarseLocation | requestLocationUpdates");
                }
                if (f4221u || f4223w) {
                    a(100, 20, "系统返回定位结果超时#2002", this.f4236n.getHttpTimeOut());
                }
                if (f4221u || f4223w) {
                    return;
                }
                DebugUtils.writeCat("CoarseLocation | no GPS_provider");
                a(100, 20, "系统定位当前不可用#2003", 0L);
                return;
            } catch (SecurityException e) {
                DebugUtils.writeCat("CoarseLocation | no location permission");
                this.f4238p = false;
                ReportUtil.reportLocError(null, ReportUtil.EXCEPTION_CODE_NOLOCPERMISSION);
                a(101, 20, e.getMessage() + "#2004", 0L);
                return;
            } catch (Throwable th3) {
                DebugUtils.writeCat(e.p(th3, new StringBuilder("CoarseLocation | requestLocationUpdates error: ")));
                CoreUtil.reportError(th3, "CoarseLocation", "requestLocationUpdates part2");
                return;
            }
        }
        AMapLocationServer aMapLocationServer2 = new AMapLocationServer("");
        aMapLocationServer2.setErrorCode(12);
        aMapLocationServer2.setLocationDetail("定位服务没有开启，请在设置中打开定位服务开关#1206");
        a(aMapLocationServer2);
    }

    @SuppressLint({"NewApi"})
    public int d() {
        LocationManager locationManager = this.f4235m;
        if (locationManager == null || !a(locationManager)) {
            return 1;
        }
        int i3 = Settings.Secure.getInt(this.f4232j.getContentResolver(), "location_mode", 0);
        if (i3 == 0) {
            return 2;
        }
        if (i3 == 2) {
            return 3;
        }
        return !this.f4238p ? 4 : 0;
    }

    public boolean b(LocationManager locationManager) {
        try {
            if (f4222v) {
                return f4223w;
            }
            boolean isProviderEnabled = locationManager.isProviderEnabled(Const.PROVIDER_NETWORK);
            f4223w = isProviderEnabled;
            f4222v = true;
            return isProviderEnabled;
        } catch (Throwable th2) {
            DebugUtils.writeCat(e.p(th2, new StringBuilder("CoarseLocation | hasProvider error: ")));
            return f4223w;
        }
    }

    public void b(AMapLocation aMapLocation) {
        if (Utils.locCorrect(aMapLocation) && this.f4231i != null) {
            long timeBoot = Utils.getTimeBoot();
            if (this.f4236n.getInterval() <= Const.L_MIN_GET_REQ || timeBoot - this.f4233k > this.f4236n.getInterval() - Const.L_MIN_GET_REQ) {
                Bundle bundle = new Bundle();
                bundle.putDouble(Const.JSON_KEY_LAT, aMapLocation.getLatitude());
                bundle.putDouble(Const.JSON_KEY_LON, aMapLocation.getLongitude());
                bundle.putFloat("radius", aMapLocation.getAccuracy());
                bundle.putLong(Const.JSON_KEY_TIME, aMapLocation.getTime());
                Message obtain = Message.obtain();
                obtain.setData(bundle);
                obtain.what = 102;
                synchronized (this.f4237o) {
                    try {
                        if (f4224x == null) {
                            this.f4231i.sendMessage(obtain);
                        } else if (Utils.dist(aMapLocation, f4224x) > this.f4229g) {
                            this.f4231i.sendMessage(obtain);
                        }
                    } catch (Throwable th2) {
                        throw th2;
                    }
                }
            }
        }
    }

    private void c(AMapLocation aMapLocation) {
        try {
            if (CoreUtil.isChina(aMapLocation.getLatitude(), aMapLocation.getLongitude()) && this.f4236n.isOffset()) {
                DPoint offset = OffsetUtil.offset(this.f4232j, new DPoint(aMapLocation.getLatitude(), aMapLocation.getLongitude()));
                aMapLocation.setLatitude(offset.getLatitude());
                aMapLocation.setLongitude(offset.getLongitude());
                aMapLocation.setOffset(this.f4236n.isOffset());
                aMapLocation.setCoordType("GCJ02");
                return;
            }
            aMapLocation.setOffset(false);
            aMapLocation.setCoordType("WGS84");
        } catch (Throwable th2) {
            aMapLocation.setOffset(false);
            aMapLocation.setCoordType("WGS84");
            DebugUtils.writeCat(e.p(th2, new StringBuilder("CoarseLocation | offset error: ")));
        }
    }

    public boolean a(LocationManager locationManager) {
        try {
            if (f4220t) {
                return f4221u;
            }
            List<String> allProviders = locationManager.getAllProviders();
            if (allProviders != null && allProviders.size() > 0) {
                f4221u = allProviders.contains("gps");
            } else {
                f4221u = false;
            }
            f4220t = true;
            return f4221u;
        } catch (Throwable th2) {
            DebugUtils.writeCat(e.p(th2, new StringBuilder("CoarseLocation | hasProvider error: ")));
            return f4221u;
        }
    }

    private void a(int i3, int i10, String str, long j4) {
        try {
            if (this.f4231i != null) {
                Message obtain = Message.obtain();
                AMapLocation aMapLocation = new AMapLocation("");
                aMapLocation.setErrorCode(i10);
                aMapLocation.setLocationDetail(str);
                aMapLocation.setLocationType(11);
                obtain.obj = aMapLocation;
                obtain.what = i3;
                this.f4231i.sendMessageDelayed(obtain, j4);
            }
        } catch (Throwable unused) {
            DebugUtils.writeCat("CoarseLocation | sendMessage", false);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x008a A[Catch: all -> 0x018d, TryCatch #3 {all -> 0x018d, blocks: (B:6:0x0011, B:9:0x0020, B:11:0x002a, B:12:0x0035, B:14:0x003f, B:16:0x0045, B:17:0x005f, B:23:0x0082, B:25:0x008a, B:27:0x0099, B:29:0x009d, B:32:0x00c9, B:34:0x00d0, B:36:0x00d6, B:37:0x00de, B:40:0x011c, B:43:0x0157, B:46:0x0163, B:47:0x0168, B:57:0x0187, B:63:0x018c, B:64:0x015e, B:65:0x0123, B:68:0x0128, B:70:0x0133, B:72:0x013e, B:74:0x0146, B:76:0x0151, B:77:0x014e, B:78:0x013b, B:79:0x00fc, B:81:0x0102, B:83:0x0116, B:85:0x00ce, B:91:0x0030, B:49:0x0169, B:51:0x016d, B:53:0x0175, B:55:0x0180, B:56:0x0186), top: B:5:0x0011, inners: #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00d6 A[Catch: all -> 0x018d, TryCatch #3 {all -> 0x018d, blocks: (B:6:0x0011, B:9:0x0020, B:11:0x002a, B:12:0x0035, B:14:0x003f, B:16:0x0045, B:17:0x005f, B:23:0x0082, B:25:0x008a, B:27:0x0099, B:29:0x009d, B:32:0x00c9, B:34:0x00d0, B:36:0x00d6, B:37:0x00de, B:40:0x011c, B:43:0x0157, B:46:0x0163, B:47:0x0168, B:57:0x0187, B:63:0x018c, B:64:0x015e, B:65:0x0123, B:68:0x0128, B:70:0x0133, B:72:0x013e, B:74:0x0146, B:76:0x0151, B:77:0x014e, B:78:0x013b, B:79:0x00fc, B:81:0x0102, B:83:0x0116, B:85:0x00ce, B:91:0x0030, B:49:0x0169, B:51:0x016d, B:53:0x0175, B:55:0x0180, B:56:0x0186), top: B:5:0x0011, inners: #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x015d A[DONT_GENERATE] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0169 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:64:0x015e A[Catch: all -> 0x018d, TryCatch #3 {all -> 0x018d, blocks: (B:6:0x0011, B:9:0x0020, B:11:0x002a, B:12:0x0035, B:14:0x003f, B:16:0x0045, B:17:0x005f, B:23:0x0082, B:25:0x008a, B:27:0x0099, B:29:0x009d, B:32:0x00c9, B:34:0x00d0, B:36:0x00d6, B:37:0x00de, B:40:0x011c, B:43:0x0157, B:46:0x0163, B:47:0x0168, B:57:0x0187, B:63:0x018c, B:64:0x015e, B:65:0x0123, B:68:0x0128, B:70:0x0133, B:72:0x013e, B:74:0x0146, B:76:0x0151, B:77:0x014e, B:78:0x013b, B:79:0x00fc, B:81:0x0102, B:83:0x0116, B:85:0x00ce, B:91:0x0030, B:49:0x0169, B:51:0x016d, B:53:0x0175, B:55:0x0180, B:56:0x0186), top: B:5:0x0011, inners: #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0116 A[Catch: all -> 0x018d, TryCatch #3 {all -> 0x018d, blocks: (B:6:0x0011, B:9:0x0020, B:11:0x002a, B:12:0x0035, B:14:0x003f, B:16:0x0045, B:17:0x005f, B:23:0x0082, B:25:0x008a, B:27:0x0099, B:29:0x009d, B:32:0x00c9, B:34:0x00d0, B:36:0x00d6, B:37:0x00de, B:40:0x011c, B:43:0x0157, B:46:0x0163, B:47:0x0168, B:57:0x0187, B:63:0x018c, B:64:0x015e, B:65:0x0123, B:68:0x0128, B:70:0x0133, B:72:0x013e, B:74:0x0146, B:76:0x0151, B:77:0x014e, B:78:0x013b, B:79:0x00fc, B:81:0x0102, B:83:0x0116, B:85:0x00ce, B:91:0x0030, B:49:0x0169, B:51:0x016d, B:53:0x0175, B:55:0x0180, B:56:0x0186), top: B:5:0x0011, inners: #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:84:0x00dd  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x00ce A[Catch: all -> 0x018d, TryCatch #3 {all -> 0x018d, blocks: (B:6:0x0011, B:9:0x0020, B:11:0x002a, B:12:0x0035, B:14:0x003f, B:16:0x0045, B:17:0x005f, B:23:0x0082, B:25:0x008a, B:27:0x0099, B:29:0x009d, B:32:0x00c9, B:34:0x00d0, B:36:0x00d6, B:37:0x00de, B:40:0x011c, B:43:0x0157, B:46:0x0163, B:47:0x0168, B:57:0x0187, B:63:0x018c, B:64:0x015e, B:65:0x0123, B:68:0x0128, B:70:0x0133, B:72:0x013e, B:74:0x0146, B:76:0x0151, B:77:0x014e, B:78:0x013b, B:79:0x00fc, B:81:0x0102, B:83:0x0116, B:85:0x00ce, B:91:0x0030, B:49:0x0169, B:51:0x016d, B:53:0x0175, B:55:0x0180, B:56:0x0186), top: B:5:0x0011, inners: #2 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void a(com.amap.api.col.p0003sl.h r11, android.location.Location r12) {
        /*
            Method dump skipped, instructions count: 406
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.p0003sl.h.a(com.amap.api.col.3sl.h, android.location.Location):void");
    }

    private void a(AMapLocation aMapLocation) {
        if (this.f4236n.getLocationMode().equals(AMapLocationClientOption.AMapLocationMode.Device_Sensors) && this.f4236n.getDeviceModeDistanceFilter() > 0.0f) {
            d(aMapLocation);
        } else if (Utils.getTimeBoot() - this.f4233k >= this.f4236n.getInterval() - 200) {
            this.f4233k = Utils.getTimeBoot();
            d(aMapLocation);
        }
    }

    @Override // com.amap.api.col.p0003sl.t
    public void a(Bundle bundle) {
        if (bundle != null) {
            try {
                bundle.setClassLoader(AMapLocation.class.getClassLoader());
                this.f4228f = bundle.getInt("I_MAX_GEO_DIS", this.f4228f);
                this.f4229g = bundle.getInt("I_MIN_GEO_DIS", this.f4229g);
                AMapLocation aMapLocation = (AMapLocation) bundle.getParcelable("loc");
                if (TextUtils.isEmpty(aMapLocation.getAdCode())) {
                    return;
                }
                synchronized (this.f4237o) {
                    f4224x = aMapLocation;
                }
            } catch (Throwable th2) {
                CoreUtil.reportError(th2, "CoarseLocation", "setLastGeoLocation");
            }
        }
    }
}
