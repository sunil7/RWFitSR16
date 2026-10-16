package com.autonavi.aps.amapapi;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.location.LocationManager;
import android.net.ConnectivityManager;
import android.net.wifi.WifiManager;
import android.os.Handler;
import android.provider.Settings;
import android.text.TextUtils;
import com.amap.api.col.p0003sl.ka;
import com.amap.api.col.p0003sl.n9;
import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClientOption;
import com.autonavi.aps.amapapi.config.Const;
import com.autonavi.aps.amapapi.filters.LocFilter;
import com.autonavi.aps.amapapi.model.AMapLocationServer;
import com.autonavi.aps.amapapi.restruct.AmapSensorManager;
import com.autonavi.aps.amapapi.restruct.Cgi;
import com.autonavi.aps.amapapi.restruct.CgiManager;
import com.autonavi.aps.amapapi.restruct.HistoryLocation;
import com.autonavi.aps.amapapi.restruct.HistoryLocationRecorder;
import com.autonavi.aps.amapapi.restruct.WifiManagerWrapper;
import com.autonavi.aps.amapapi.storage.Cache;
import com.autonavi.aps.amapapi.trans.LocNetManager;
import com.autonavi.aps.amapapi.trans.Parser;
import com.autonavi.aps.amapapi.trans.Req;
import com.autonavi.aps.amapapi.utils.CollectionFactory;
import com.autonavi.aps.amapapi.utils.CoreUtil;
import com.autonavi.aps.amapapi.utils.Reflect;
import com.autonavi.aps.amapapi.utils.ReportUtil;
import com.autonavi.aps.amapapi.utils.Utils;
import com.autonavi.base.ae.gmap.glyph.FontStyle;
import java.util.ArrayList;
import java.util.Locale;
import k3.a;

@SuppressLint({"NewApi"})
/* loaded from: classes.dex */
public class Aps {
    private static volatile boolean M = false;
    public static String locBackGroundPermissions = "android.permission.ACCESS_BACKGROUND_LOCATION";
    public static String[] locPermissions = {"android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"};
    private Handler F;
    private HistoryLocationRecorder G;
    boolean H;
    private String K;
    private ICollectionManager L;

    /* renamed from: a, reason: collision with root package name */
    Context f6583a = null;

    /* renamed from: b, reason: collision with root package name */
    ConnectivityManager f6584b = null;

    /* renamed from: c, reason: collision with root package name */
    WifiManagerWrapper f6585c = null;

    /* renamed from: d, reason: collision with root package name */
    CgiManager f6586d = null;
    Cache e = null;

    /* renamed from: f, reason: collision with root package name */
    Parser f6587f = null;

    /* renamed from: g, reason: collision with root package name */
    ArrayList<a> f6588g = new ArrayList<>();

    /* renamed from: h, reason: collision with root package name */
    MyBroadcastReceiver f6589h = null;

    /* renamed from: i, reason: collision with root package name */
    AMapLocationClientOption f6590i = new AMapLocationClientOption();

    /* renamed from: j, reason: collision with root package name */
    AMapLocationServer f6591j = null;

    /* renamed from: k, reason: collision with root package name */
    long f6592k = 0;

    /* renamed from: l, reason: collision with root package name */
    private int f6593l = 0;

    /* renamed from: m, reason: collision with root package name */
    Req f6594m = null;

    /* renamed from: n, reason: collision with root package name */
    boolean f6595n = false;

    /* renamed from: o, reason: collision with root package name */
    private String f6596o = null;

    /* renamed from: p, reason: collision with root package name */
    LocNetManager f6597p = null;

    /* renamed from: q, reason: collision with root package name */
    StringBuilder f6598q = new StringBuilder();
    boolean r = true;

    /* renamed from: s, reason: collision with root package name */
    boolean f6599s = true;

    /* renamed from: t, reason: collision with root package name */
    AMapLocationClientOption.GeoLanguage f6600t = AMapLocationClientOption.GeoLanguage.DEFAULT;

    /* renamed from: u, reason: collision with root package name */
    boolean f6601u = true;

    /* renamed from: v, reason: collision with root package name */
    boolean f6602v = false;

    /* renamed from: w, reason: collision with root package name */
    private String f6603w = null;

    /* renamed from: x, reason: collision with root package name */
    StringBuilder f6604x = null;

    /* renamed from: y, reason: collision with root package name */
    boolean f6605y = false;
    public boolean isInit = false;

    /* renamed from: z, reason: collision with root package name */
    int f6606z = 12;
    private boolean A = true;
    AmapSensorManager B = null;
    boolean C = false;
    LocFilter D = null;
    String E = null;
    IntentFilter I = null;
    LocationManager J = null;

    /* renamed from: com.autonavi.aps.amapapi.Aps$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f6607a;

        static {
            AMapLocationClientOption.GeoLanguage.values();
            int[] iArr = new int[3];
            f6607a = iArr;
            try {
                iArr[0] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f6607a[1] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f6607a[2] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public class MyBroadcastReceiver extends BroadcastReceiver {
        public MyBroadcastReceiver() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            WifiManagerWrapper wifiManagerWrapper;
            WifiManagerWrapper wifiManagerWrapper2;
            if (context == null || intent == null) {
                return;
            }
            try {
                String action = intent.getAction();
                if (TextUtils.isEmpty(action)) {
                    return;
                }
                if (action.equals("android.net.wifi.SCAN_RESULTS")) {
                    WifiManagerWrapper wifiManagerWrapper3 = Aps.this.f6585c;
                    if (wifiManagerWrapper3 != null) {
                        wifiManagerWrapper3.wifiResultChange();
                    }
                    try {
                        if (intent.getExtras() == null || !intent.getExtras().getBoolean("resultsUpdated", true) || (wifiManagerWrapper2 = Aps.this.f6585c) == null) {
                            return;
                        }
                        wifiManagerWrapper2.wifiResultUpdateChange();
                        return;
                    } catch (Throwable unused) {
                        return;
                    }
                }
                if (action.equals("android.net.wifi.WIFI_STATE_CHANGED")) {
                    WifiManagerWrapper wifiManagerWrapper4 = Aps.this.f6585c;
                    if (wifiManagerWrapper4 != null) {
                        wifiManagerWrapper4.wifiStateChange();
                        return;
                    }
                    return;
                }
                if (!action.equals("android.net.wifi.STATE_CHANGE") || (wifiManagerWrapper = Aps.this.f6585c) == null) {
                    return;
                }
                wifiManagerWrapper.resetWifiAccess();
            } catch (Throwable th2) {
                CoreUtil.reportError(th2, "Aps", "onReceive");
            }
        }
    }

    public Aps(boolean z5) {
        this.H = z5;
    }

    private boolean c() {
        WifiManagerWrapper wifiManagerWrapper = this.f6585c;
        if (wifiManagerWrapper != null) {
            this.f6588g = wifiManagerWrapper.getScanResultsParam();
        }
        ArrayList<a> arrayList = this.f6588g;
        return arrayList == null || arrayList.size() <= 0;
    }

    private void d() {
        int ordinal;
        if (this.f6597p != null) {
            try {
                if (this.f6590i == null) {
                    this.f6590i = new AMapLocationClientOption();
                }
                int i3 = 0;
                if (this.f6590i.getGeoLanguage() != null && (ordinal = this.f6590i.getGeoLanguage().ordinal()) != 0) {
                    int i10 = 1;
                    if (ordinal != 1) {
                        i10 = 2;
                        if (ordinal != 2) {
                        }
                    }
                    i3 = i10;
                }
                this.f6597p.setOption(this.f6590i.getHttpTimeOut(), this.f6590i.getLocationProtocol().equals(AMapLocationClientOption.AMapLocationProtocol.HTTPS), i3);
            } catch (Throwable unused) {
            }
        }
    }

    public boolean a(long j4) {
        if (!this.A) {
            this.A = true;
            return false;
        }
        if (Utils.getTimeBoot() - j4 < 800) {
            if ((Utils.locCorrect(this.f6591j) ? Utils.getTime() - this.f6591j.getTime() : 0L) <= 10000) {
                return true;
            }
        }
        return false;
    }

    public void b() {
        try {
            if (this.f6589h == null) {
                this.f6589h = new MyBroadcastReceiver();
            }
            if (this.I == null) {
                IntentFilter intentFilter = new IntentFilter();
                this.I = intentFilter;
                intentFilter.addAction("android.net.wifi.WIFI_STATE_CHANGED");
                this.I.addAction("android.net.wifi.SCAN_RESULTS");
                this.I.addAction("android.net.wifi.STATE_CHANGE");
            }
            this.f6583a.registerReceiver(this.f6589h, this.I);
        } catch (Throwable th2) {
            CoreUtil.reportError(th2, "Aps", "initBroadcastListener");
        }
    }

    public void clearLocationDetail() {
        if (this.f6598q.length() > 0) {
            StringBuilder sb2 = this.f6598q;
            sb2.delete(0, sb2.length());
        }
    }

    @SuppressLint({"NewApi"})
    public void destroy() {
        this.E = null;
        this.f6605y = false;
        this.isInit = false;
        Cache cache = this.e;
        if (cache != null) {
            cache.destroy(this.f6583a);
        }
        LocFilter locFilter = this.D;
        if (locFilter != null) {
            locFilter.reset();
        }
        if (this.f6587f != null) {
            this.f6587f = null;
        }
        HistoryLocationRecorder historyLocationRecorder = this.G;
        if (historyLocationRecorder != null) {
            historyLocationRecorder.destroy(this.H);
        }
        destroyCgiWifi();
        ArrayList<a> arrayList = this.f6588g;
        if (arrayList != null) {
            arrayList.clear();
        }
        AmapSensorManager amapSensorManager = this.B;
        if (amapSensorManager != null) {
            amapSensorManager.destroy();
        }
        this.f6591j = null;
        this.f6583a = null;
        this.f6604x = null;
        this.J = null;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x001b  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:17:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void destroyCgiWifi() {
        /*
            r4 = this;
            r0 = 0
            android.content.Context r1 = r4.f6583a     // Catch: java.lang.Throwable -> Ld
            if (r1 == 0) goto L15
            com.autonavi.aps.amapapi.Aps$MyBroadcastReceiver r2 = r4.f6589h     // Catch: java.lang.Throwable -> Ld
            if (r2 == 0) goto L15
            r1.unregisterReceiver(r2)     // Catch: java.lang.Throwable -> Ld
            goto L15
        Ld:
            r1 = move-exception
            java.lang.String r2 = "Aps"
            java.lang.String r3 = "destroy"
            com.autonavi.aps.amapapi.utils.CoreUtil.reportError(r1, r2, r3)     // Catch: java.lang.Throwable -> L2a
        L15:
            r4.f6589h = r0
            com.autonavi.aps.amapapi.restruct.CgiManager r0 = r4.f6586d
            if (r0 == 0) goto L20
            boolean r1 = r4.H
            r0.destroy(r1)
        L20:
            com.autonavi.aps.amapapi.restruct.WifiManagerWrapper r0 = r4.f6585c
            if (r0 == 0) goto L29
            boolean r1 = r4.H
            r0.destroy(r1)
        L29:
            return
        L2a:
            r1 = move-exception
            r4.f6589h = r0
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.autonavi.aps.amapapi.Aps.destroyCgiWifi():void");
    }

    public void destroyColl() {
        ICollectionManager iCollectionManager = this.L;
        if (iCollectionManager != null) {
            iCollectionManager.destroyColl();
        }
    }

    public void doFirstAddCache(AMapLocationServer aMapLocationServer) {
        if (Utils.locCorrect(aMapLocationServer)) {
            this.e.add(this.f6603w, this.f6604x, aMapLocationServer, this.f6583a, true);
        }
    }

    public AMapLocationServer doFirstCacheLocate(boolean z5) {
        if (this.f6585c.isMock()) {
            return a(15, "networkLocation has been mocked!#1502");
        }
        if (TextUtils.isEmpty(this.f6603w)) {
            return a(this.f6606z, this.f6598q.toString());
        }
        AMapLocationServer aMapLocationServer = this.e.get(this.f6583a, this.f6603w, this.f6604x, true, z5);
        if (Utils.locCorrect(aMapLocationServer) && aMapLocationServer != null) {
            this.f6591j = aMapLocationServer;
        }
        return aMapLocationServer;
    }

    public AMapLocationServer doFirstNetLocate(boolean z5, AMapLocationStaticsEntity aMapLocationStaticsEntity) {
        if (z5) {
            aMapLocationStaticsEntity.setLocationType(AMapLocationStaticsEntity.STATICS_LOCATE);
        } else {
            aMapLocationStaticsEntity.setLocationType(AMapLocationStaticsEntity.FIRST_LOCATE);
        }
        if (this.f6583a == null) {
            aMapLocationStaticsEntity.setReason("#0101");
            this.f6598q.append("context is null#0101");
            ReportUtil.reportLocError(null, 2011);
            return a(1, this.f6598q.toString());
        }
        WifiManagerWrapper wifiManagerWrapper = this.f6585c;
        if (wifiManagerWrapper != null && wifiManagerWrapper.isMock()) {
            aMapLocationStaticsEntity.setReason("#1502");
            return a(15, "networkLocation has been mocked!#1502");
        }
        initNetManager();
        if (TextUtils.isEmpty(this.f6603w)) {
            return a(this.f6606z, this.f6598q.toString());
        }
        AMapLocationServer a3 = a(false, z5, aMapLocationStaticsEntity);
        if (Utils.locCorrect(a3) && !M) {
            this.e.setLastNb(this.f6604x.toString());
            this.e.setLastCgi(this.f6586d.getMainCgi());
            this.f6591j = a3;
        }
        M = true;
        return a3;
    }

    public AMapLocationServer filter(AMapLocationServer aMapLocationServer, String... strArr) {
        this.D.setLocationCahceEnable(this.f6601u);
        return (strArr == null || strArr.length == 0) ? this.D.filterShake(aMapLocationServer) : strArr[0].equals(Const.STR_FLT_SHAKE) ? this.D.filterShake(aMapLocationServer) : strArr[0].equals(Const.STR_FLT_FUSION) ? this.D.filterFusion(aMapLocationServer) : aMapLocationServer;
    }

    public String getErrorMessage() {
        return this.f6596o;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(14:22|(2:24|(1:26)(1:27))|28|29|30|(8:35|36|(1:38)|40|41|(1:43)|45|(2:47|48)(2:49|(15:55|(1:59)(1:106)|60|(1:105)(1:64)|65|(1:67)(2:91|(3:93|(1:95)|96)(4:97|(1:101)|102|(8:104|69|70|(2:72|(1:74)(2:75|(1:77)(2:78|(1:80)(1:81))))|82|(1:89)(1:86)|87|88)))|68|69|70|(0)|82|(1:84)|89|87|88)(2:53|54)))|109|36|(0)|40|41|(0)|45|(0)(0)) */
    /* JADX WARN: Can't wrap try/catch for region: R(15:55|(1:59)(1:106)|60|(1:105)(1:64)|65|(1:67)(2:91|(3:93|(1:95)|96)(4:97|(1:101)|102|(8:104|69|70|(2:72|(1:74)(2:75|(1:77)(2:78|(1:80)(1:81))))|82|(1:89)(1:86)|87|88)))|68|69|70|(0)|82|(1:84)|89|87|88) */
    /* JADX WARN: Code restructure failed: missing block: B:107:0x00ab, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:108:0x00ac, code lost:
    
        com.autonavi.aps.amapapi.utils.CoreUtil.reportError(r0, "Aps", "getLocation getCgiListParam");
     */
    /* JADX WARN: Removed duplicated region for block: B:38:0x008e A[Catch: all -> 0x0087, TRY_LEAVE, TryCatch #1 {all -> 0x0087, blocks: (B:30:0x0074, B:32:0x007c, B:36:0x008a, B:38:0x008e), top: B:29:0x0074 }] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00a3 A[Catch: all -> 0x00ab, TRY_LEAVE, TryCatch #2 {all -> 0x00ab, blocks: (B:41:0x009f, B:43:0x00a3), top: B:40:0x009f }] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00ca  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x018a A[Catch: all -> 0x01b0, TryCatch #0 {all -> 0x01b0, blocks: (B:70:0x0186, B:72:0x018a, B:74:0x0194, B:77:0x019e, B:80:0x01a8, B:81:0x01ad), top: B:69:0x0186 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public com.autonavi.aps.amapapi.model.AMapLocationServer getLocation(com.autonavi.aps.amapapi.AMapLocationStaticsEntity r18) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 506
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.autonavi.aps.amapapi.Aps.getLocation(com.autonavi.aps.amapapi.AMapLocationStaticsEntity):com.autonavi.aps.amapapi.model.AMapLocationServer");
    }

    public String getReqKey(boolean z5, AMapLocationStaticsEntity aMapLocationStaticsEntity) {
        CgiManager cgiManager = this.f6586d;
        String str = "";
        if (cgiManager != null && this.f6585c != null) {
            int mainCgiTypeMasked = cgiManager.getMainCgiTypeMasked();
            Cgi mainCgi = this.f6586d.getMainCgi();
            Cgi mainCgiV2 = this.f6586d.getMainCgiV2();
            ArrayList<a> arrayList = this.f6588g;
            boolean z6 = arrayList == null || arrayList.isEmpty();
            if (mainCgi == null && mainCgiV2 == null && z6) {
                if (this.f6584b == null) {
                    this.f6584b = (ConnectivityManager) Utils.getServ(this.f6583a, "connectivity");
                }
                if (Utils.getSdk() >= 31) {
                    if (Utils.airPlaneModeOn(this.f6583a) && !this.f6585c.isSystemWifiEnabled()) {
                        this.f6606z = 18;
                        this.f6598q.append("飞行模式下关闭了WIFI开关，请关闭飞行模式或者打开WIFI开关#1802");
                        ReportUtil.reportLocError(null, ReportUtil.EXCEPTION_AIRPLANEMODE_WIFIOFF);
                        aMapLocationStaticsEntity.setReason("#1802");
                        return "";
                    }
                } else if (Utils.airPlaneModeOn(this.f6583a) && !this.f6585c.isWifiEnabled()) {
                    this.f6606z = 18;
                    this.f6598q.append("飞行模式下关闭了WIFI开关，请关闭飞行模式或者打开WIFI开关#1801");
                    ReportUtil.reportLocError(null, ReportUtil.EXCEPTION_AIRPLANEMODE_WIFIOFF);
                    aMapLocationStaticsEntity.setReason("#1801");
                    return "";
                }
                if (Utils.getSdk() >= 28) {
                    if (this.J == null) {
                        this.J = (LocationManager) this.f6583a.getApplicationContext().getSystemService("location");
                    }
                    if (!((Boolean) Reflect.invokeMethod(this.J, "isLocationEnabled", new Object[0])).booleanValue()) {
                        this.f6606z = 12;
                        this.f6598q.append("定位服务没有开启，请在设置中打开定位服务开关#1206");
                        aMapLocationStaticsEntity.setReason("#1206");
                        ReportUtil.reportLocError(null, ReportUtil.EXCEPTION_CODE_NOLOCPERMISSION);
                        return "";
                    }
                }
                if (!Utils.checkLocPerm(this.f6583a)) {
                    this.f6606z = 12;
                    this.f6598q.append("定位权限被禁用,请授予应用定位权限#1201");
                    aMapLocationStaticsEntity.setReason("#1201");
                    ReportUtil.reportLocError(null, ReportUtil.EXCEPTION_CODE_NOLOCPERMISSION);
                    return "";
                }
                if (Utils.getSdk() >= 24 && Utils.getSdk() < 28 && Settings.Secure.getInt(this.f6583a.getContentResolver(), "location_mode", 0) == 0) {
                    this.f6606z = 12;
                    aMapLocationStaticsEntity.setReason("#1206");
                    this.f6598q.append("定位服务没有开启，请在设置中打开定位服务开关#1206");
                    ReportUtil.reportLocError(null, ReportUtil.EXCEPTION_CODE_NOLOCPERMISSION);
                    return "";
                }
                String securityException = this.f6586d.getSecurityException();
                String securityException2 = this.f6585c.getSecurityException();
                if (this.f6585c.wifiAccess(this.f6584b) && securityException2 != null) {
                    this.f6606z = 12;
                    aMapLocationStaticsEntity.setReason("#1202");
                    this.f6598q.append("获取基站与获取WIFI的权限都被禁用，请在安全软件中打开应用的定位权限#1202");
                    ReportUtil.reportLocError(null, ReportUtil.EXCEPTION_CODE_NOLOCPERMISSION);
                    return "";
                }
                if (securityException != null) {
                    this.f6606z = 12;
                    if (this.f6585c.isWifiEnabled()) {
                        aMapLocationStaticsEntity.setReason("#1205");
                        this.f6598q.append("获取的WIFI列表为空，并且获取基站权限被禁用，请在安全软件中打开应用的定位权限#1205");
                    } else {
                        aMapLocationStaticsEntity.setReason("#1204");
                        this.f6598q.append("WIFI开关关闭，并且获取基站权限被禁用，请在安全软件中打开应用的定位权限或者打开WIFI开关#1204");
                    }
                    ReportUtil.reportLocError(null, ReportUtil.EXCEPTION_CODE_NOLOCPERMISSION);
                    return "";
                }
                if (!this.f6585c.isWifiEnabled() && !this.f6586d.isSimValid()) {
                    this.f6606z = 19;
                    aMapLocationStaticsEntity.setReason("#1901");
                    this.f6598q.append("没有检查到SIM卡，并且WIFI开关关闭，请打开WIFI开关或者插入SIM卡#1901");
                    ReportUtil.reportLocError(null, ReportUtil.EXCEPTION_NOCGI_WIFIOFF);
                    return "";
                }
                if (this.f6585c.isWifiEnabled()) {
                    aMapLocationStaticsEntity.setReason("#1302");
                    if (this.f6585c.getConnectionInfo() != null) {
                        this.f6598q.append("获取到的基站和WIFI信息均为空，请检查是否授予APP定位权限");
                        if (!Utils.checkBackGroundLocPerm(this.f6583a)) {
                            this.f6598q.append("或后台运行没有后台定位权限");
                        }
                        this.f6598q.append("#1302");
                    } else {
                        this.f6598q.append("获取到的基站和WIFI信息均为空，请移动到有WIFI的区域，若确定当前区域有WIFI，请检查是否授予APP定位权限");
                        if (!Utils.checkBackGroundLocPerm(this.f6583a)) {
                            this.f6598q.append("或后台运行没有后台定位权限");
                        }
                        this.f6598q.append("#1302");
                    }
                } else {
                    aMapLocationStaticsEntity.setReason("#1301");
                    this.f6598q.append("获取到的基站为空，并且关闭了WIFI开关，请您打开WIFI开关再发起定位#1301");
                }
                this.f6606z = 13;
                ReportUtil.reportLocError(null, ReportUtil.EXCEPTION_CODE_NOCGIANDWIFI);
                return "";
            }
            boolean wifiUseful = this.f6585c.wifiUseful(this.f6585c.getWifiAccess());
            String str2 = Const.STR_CACHE_CW;
            if (mainCgiTypeMasked == 0) {
                boolean z8 = !this.f6588g.isEmpty() || wifiUseful;
                boolean z10 = mainCgiV2 != null;
                if (!z5 && !z10) {
                    if (wifiUseful && this.f6588g.isEmpty()) {
                        this.f6606z = 2;
                        aMapLocationStaticsEntity.setReason("#0201");
                        this.f6598q.append("当前基站为伪基站，并且WIFI权限被禁用，请在安全软件中打开应用的定位权限#0201");
                        ReportUtil.reportLocError(null, 2021);
                        return "";
                    }
                    if (this.f6588g.size() == 1) {
                        this.f6606z = 2;
                        if (!wifiUseful) {
                            aMapLocationStaticsEntity.setReason("#0202");
                            this.f6598q.append("当前基站为伪基站，并且搜到的WIFI数量不足，请移动到WIFI比较丰富的区域#0202");
                            ReportUtil.reportLocError(null, 2022);
                            return "";
                        }
                        if (this.f6588g.get(0).f15461h) {
                            aMapLocationStaticsEntity.setReason("#0202");
                            this.f6598q.append("当前基站为伪基站，并且搜到的WIFI数量不足，请移动到WIFI比较丰富的区域#0202");
                            ReportUtil.reportLocError(null, 2021);
                            return "";
                        }
                    }
                }
                Locale locale = Locale.US;
                if (z10) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(mainCgiV2.getCellKey());
                    if (this.f6588g.isEmpty() && !wifiUseful) {
                        str2 = "cgi";
                    }
                    str = r5.a.f(sb2, "network#", str2);
                } else if (z8) {
                    str = "#network#".concat("wifi");
                } else {
                    this.f6606z = 2;
                    if (this.f6585c.isWifiEnabled()) {
                        aMapLocationStaticsEntity.setReason("#0204");
                        this.f6598q.append("当前基站为伪基站,并且没有搜索到WIFI，请移动到WIFI比较丰富的区域#0204");
                    } else {
                        aMapLocationStaticsEntity.setReason("#0203");
                        this.f6598q.append("当前基站为伪基站,并且关闭了WIFI开关，请在设置中打开WIFI开关#0203");
                    }
                    ReportUtil.reportLocError(null, 2022);
                }
            } else if (mainCgiTypeMasked != 1) {
                if (mainCgiTypeMasked != 2) {
                    this.f6606z = 11;
                    ReportUtil.reportLocError(null, ReportUtil.EXCEPTION_CODE_CGIINFOERROR);
                    aMapLocationStaticsEntity.setReason("#1101");
                    this.f6598q.append("get cgi failure#1101");
                } else if (mainCgi != null) {
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append(mainCgi.mcc);
                    sb3.append(Const.STR_MART_WELL);
                    sb3.append(mainCgi.mnc);
                    sb3.append(Const.STR_MART_WELL);
                    sb3.append(mainCgi.sid);
                    sb3.append(Const.STR_MART_WELL);
                    sb3.append(mainCgi.nid);
                    sb3.append(Const.STR_MART_WELL);
                    sb3.append(mainCgi.bid);
                    sb3.append("#network#");
                    if (this.f6588g.isEmpty() && !wifiUseful) {
                        str2 = "cgi";
                    }
                    sb3.append(str2);
                    str = sb3.toString();
                }
            } else if (mainCgi != null) {
                StringBuilder sb4 = new StringBuilder();
                sb4.append(mainCgi.mcc);
                sb4.append(Const.STR_MART_WELL);
                sb4.append(mainCgi.mnc);
                sb4.append(Const.STR_MART_WELL);
                sb4.append(mainCgi.lac);
                sb4.append(Const.STR_MART_WELL);
                sb4.append(mainCgi.cid);
                sb4.append("#network#");
                if (this.f6588g.isEmpty() && !wifiUseful) {
                    str2 = "cgi";
                }
                sb4.append(str2);
                str = sb4.toString();
            }
            if (!TextUtils.isEmpty(str)) {
                if (!str.startsWith(Const.STR_MART_WELL)) {
                    str = Const.STR_MART_WELL.concat(str);
                }
                return Utils.encodeLicense() + str;
            }
        }
        return str;
    }

    public StringBuilder getReqNb(StringBuilder sb2) {
        if (sb2 == null) {
            sb2 = new StringBuilder(FontStyle.WEIGHT_BOLD);
        } else {
            sb2.delete(0, sb2.length());
        }
        CgiManager cgiManager = this.f6586d;
        if (cgiManager != null && this.f6585c != null) {
            sb2.append(cgiManager.getCgiParam());
            sb2.append(this.f6585c.getWifiParam());
        }
        return sb2;
    }

    public AMapLocationServer gpsLocationGeo(double d5, double d8, boolean z5) {
        try {
            String postReGeo = this.f6597p.postReGeo(this.f6583a, d5, d8, z5);
            if (!postReGeo.contains("\"status\":\"1\"")) {
                return null;
            }
            AMapLocationServer parseGeoJsonResult = this.f6587f.parseGeoJsonResult(postReGeo);
            parseGeoJsonResult.setLatitude(d5);
            parseGeoJsonResult.setLongitude(d8);
            return parseGeoJsonResult;
        } catch (Throwable unused) {
            return null;
        }
    }

    public void initBase(Context context) {
        try {
            if (this.f6583a != null) {
                return;
            }
            this.D = new LocFilter();
            Context applicationContext = context.getApplicationContext();
            this.f6583a = applicationContext;
            Utils.getAppName(applicationContext);
            if (this.f6585c == null) {
                this.f6585c = new WifiManagerWrapper(this.f6583a, (WifiManager) Utils.getServ(this.f6583a, "wifi"), this.F);
            }
            if (this.f6586d == null) {
                this.f6586d = new CgiManager(this.f6583a, this.F);
            }
            this.G = new HistoryLocationRecorder(context, this.F);
            if (this.e == null) {
                this.e = new Cache();
            }
            if (this.f6587f == null) {
                this.f6587f = new Parser();
            }
        } catch (Throwable th2) {
            th2.printStackTrace();
            CoreUtil.reportError(th2, "Aps", "initBase");
        }
    }

    public void initFirstLocateParam(Context context, AMapLocationStaticsEntity aMapLocationStaticsEntity) {
        try {
        } catch (Throwable th2) {
            CoreUtil.reportError(th2, "Aps", "initFirstLocateParam");
        }
        if (this.f6605y) {
            return;
        }
        if (this.f6603w != null) {
            this.f6603w = null;
        }
        StringBuilder sb2 = this.f6604x;
        if (sb2 != null) {
            sb2.delete(0, sb2.length());
        }
        if (this.f6602v) {
            b();
        }
        WifiManagerWrapper wifiManagerWrapper = this.f6585c;
        if (wifiManagerWrapper != null) {
            wifiManagerWrapper.updateWifi(this.f6602v);
            this.f6588g = this.f6585c.getScanResultsParam();
        }
        CgiManager cgiManager = this.f6586d;
        if (cgiManager != null) {
            cgiManager.updateCgi(true, c());
        }
        String reqKey = getReqKey(false, aMapLocationStaticsEntity);
        this.f6603w = reqKey;
        if (!TextUtils.isEmpty(reqKey)) {
            this.f6604x = getReqNb(this.f6604x);
        }
        this.f6605y = true;
    }

    public void initHandler(Handler handler) {
        this.F = handler;
    }

    public void initNetManager() {
        this.f6597p = LocNetManager.getInstance(this.f6583a);
        d();
        if (this.f6584b == null) {
            this.f6584b = (ConnectivityManager) Utils.getServ(this.f6583a, "connectivity");
        }
        if (this.f6594m == null) {
            this.f6594m = new Req();
        }
    }

    public void initOther() {
        if (this.f6590i.isLBSLocationEnable()) {
            if (this.B == null) {
                this.B = new AmapSensorManager(this.f6583a);
            }
            b();
            WifiManagerWrapper wifiManagerWrapper = this.f6585c;
            if (wifiManagerWrapper != null) {
                wifiManagerWrapper.updateWifi(false);
                this.f6588g = this.f6585c.getScanResultsParam();
            }
            CgiManager cgiManager = this.f6586d;
            if (cgiManager != null) {
                cgiManager.updateCgi(false, c());
            }
            this.e.loadDB(this.f6583a);
            try {
                if (this.f6583a.checkCallingOrSelfPermission(n9.b(Const.WRITE_SECURE_SETTINGS_SELF_BASE64)) == 0) {
                    this.f6595n = true;
                }
            } catch (Throwable unused) {
            }
            this.isInit = true;
        }
    }

    public boolean isInit() {
        return this.isInit;
    }

    public void notifyLocationStatus(boolean z5) {
        CgiManager cgiManager = this.f6586d;
        if (cgiManager != null) {
            cgiManager.notifyLocationStatus(z5);
        }
    }

    public void reInitIfNeed() {
        CgiManager cgiManager = this.f6586d;
        if (cgiManager != null) {
            cgiManager.reInitIfNeed();
        }
    }

    public void requestSdkAuth(Context context) {
        ICollectionManager iCollectionManager = this.L;
        if (iCollectionManager != null) {
            iCollectionManager.updateToServer();
        }
    }

    public void setExtra(AMapLocationClientOption aMapLocationClientOption) {
        boolean z5;
        boolean z6;
        boolean z8;
        this.f6590i = aMapLocationClientOption;
        if (aMapLocationClientOption == null) {
            this.f6590i = new AMapLocationClientOption();
        }
        WifiManagerWrapper wifiManagerWrapper = this.f6585c;
        if (wifiManagerWrapper != null) {
            wifiManagerWrapper.setOption(this.f6590i.isWifiActiveScan(), this.f6590i.isWifiScan(), this.f6590i.isMockEnable(), AMapLocationClientOption.isOpenAlwaysScanWifi(), aMapLocationClientOption.getScanWifiInterval());
        }
        d();
        Cache cache = this.e;
        if (cache != null) {
            cache.setOption(this.f6590i);
        }
        Parser parser = this.f6587f;
        if (parser != null) {
            parser.setOption(this.f6590i);
        }
        CgiManager cgiManager = this.f6586d;
        if (cgiManager != null) {
            cgiManager.setNoLocReqCgiEnable(this.f6590i.isNoLocReqCgiEnable());
        }
        AMapLocationClientOption.GeoLanguage geoLanguage = AMapLocationClientOption.GeoLanguage.DEFAULT;
        boolean z10 = true;
        try {
            geoLanguage = this.f6590i.getGeoLanguage();
            z5 = this.f6590i.isNeedAddress();
            try {
                z8 = this.f6590i.isOffset();
                try {
                    z6 = this.f6590i.isLocationCacheEnable();
                    try {
                        this.f6602v = this.f6590i.isOnceLocationLatest();
                        this.C = this.f6590i.isSensorEnable();
                        if (z8 != this.f6599s || z5 != this.r || z6 != this.f6601u || geoLanguage != this.f6600t) {
                            try {
                                this.A = false;
                                LocFilter locFilter = this.D;
                                if (locFilter != null) {
                                    locFilter.reset();
                                }
                            } catch (Throwable th2) {
                                CoreUtil.reportError(th2, "Aps", "cleanCache");
                            }
                        }
                    } catch (Throwable unused) {
                        z10 = z8;
                        z8 = z10;
                        this.f6599s = z8;
                        this.r = z5;
                        this.f6601u = z6;
                        this.f6600t = geoLanguage;
                    }
                } catch (Throwable unused2) {
                    z6 = true;
                }
            } catch (Throwable unused3) {
                z6 = true;
            }
        } catch (Throwable unused4) {
            z5 = true;
            z6 = true;
        }
        this.f6599s = z8;
        this.r = z5;
        this.f6601u = z6;
        this.f6600t = geoLanguage;
    }

    public void setFusionLocation(AMapLocation aMapLocation) {
        if (aMapLocation != null && aMapLocation.getErrorCode() == 0) {
            HistoryLocation historyLocation = new HistoryLocation();
            historyLocation.locationType = aMapLocation.getLocationType();
            historyLocation.time = aMapLocation.getTime();
            historyLocation.radius = (int) aMapLocation.getAccuracy();
            historyLocation.latitude = aMapLocation.getLatitude();
            historyLocation.longitude = aMapLocation.getLongitude();
            if (aMapLocation.getLocationType() == 1) {
                this.G.addGpsLocation(historyLocation);
            }
        }
    }

    public void setGpsLocation(AMapLocation aMapLocation) {
        if (aMapLocation != null && aMapLocation.getErrorCode() == 0) {
            HistoryLocation historyLocation = new HistoryLocation();
            historyLocation.locationType = aMapLocation.getLocationType();
            historyLocation.time = aMapLocation.getTime();
            historyLocation.radius = (int) aMapLocation.getAccuracy();
            historyLocation.latitude = aMapLocation.getLatitude();
            historyLocation.longitude = aMapLocation.getLongitude();
            if (aMapLocation.getLocationType() == 1) {
                this.G.addGpsLocation(historyLocation);
            }
        }
    }

    public void setNetworkLocation(AMapLocationServer aMapLocationServer) {
        if (aMapLocationServer != null && aMapLocationServer.getErrorCode() == 0) {
            HistoryLocation historyLocation = new HistoryLocation();
            historyLocation.time = aMapLocationServer.getTime();
            historyLocation.radius = (int) aMapLocationServer.getAccuracy();
            historyLocation.latitude = aMapLocationServer.getLatitude();
            historyLocation.longitude = aMapLocationServer.getLongitude();
            historyLocation.locationType = aMapLocationServer.getLocationType();
            if (!TextUtils.isEmpty(aMapLocationServer.getRetype())) {
                historyLocation.reType = Integer.parseInt(aMapLocationServer.getRetype());
            }
            historyLocation.reSubType = aMapLocationServer.getSubType();
            this.G.addNetworkLocation(historyLocation);
        }
    }

    public void startColl() {
        try {
            Context context = this.f6583a;
            if (context == null) {
                return;
            }
            if (this.L == null) {
                this.L = CollectionFactory.getCollectionManager(context);
            }
            this.L.startColl(this.f6586d, this.f6585c, this.F);
        } catch (Throwable th2) {
            ka.a(th2, "as", "stc");
        }
    }

    public void stopColl() {
        ICollectionManager iCollectionManager = this.L;
        if (iCollectionManager != null) {
            iCollectionManager.stopColl();
        }
    }

    public void transformLocationType(AMapLocationServer aMapLocationServer) {
        if (aMapLocationServer.getErrorCode() == 0 && aMapLocationServer.getLocationType() == 0) {
            if (Const.L_LOCATION_TYPE.equals(aMapLocationServer.getRetype()) || "1".equals(aMapLocationServer.getRetype()) || "2".equals(aMapLocationServer.getRetype()) || "14".equals(aMapLocationServer.getRetype()) || "24".equals(aMapLocationServer.getRetype()) || Const.INDOOR_LOCATION_TYPE.equals(aMapLocationServer.getRetype())) {
                aMapLocationServer.setLocationType(5);
            } else {
                aMapLocationServer.setLocationType(6);
            }
        }
    }

    public byte[] a() throws Throwable {
        if (this.f6594m == null) {
            this.f6594m = new Req();
        }
        if (this.f6590i == null) {
            this.f6590i = new AMapLocationClientOption();
        }
        if (this.f6586d != null && this.f6585c != null) {
            this.f6594m.createReq(this.f6583a, this.f6590i.isNeedAddress(), this.f6590i.isOffset(), this.f6586d, this.f6585c, this.f6584b, null, this.E, false, this.G);
        }
        return this.f6594m.buildBinary();
    }

    /* JADX WARN: Can't wrap try/catch for region: R(8:78|(3:109|110|(3:114|(3:116|117|118)(2:122|(4:124|(1:130)(1:128)|129|86))|(1:88)(2:90|(2:92|93)(2:94|(6:96|(1:98)(1:104)|99|(1:101)|102|103)(1:105)))))|80|81|82|(1:84)|86|(0)(0)) */
    /* JADX WARN: Code restructure failed: missing block: B:106:0x0253, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Removed duplicated region for block: B:145:0x0372  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x0380  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0289 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:90:0x028a  */
    @android.annotation.SuppressLint({"NewApi"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private com.autonavi.aps.amapapi.model.AMapLocationServer a(boolean r18, boolean r19, com.autonavi.aps.amapapi.AMapLocationStaticsEntity r20) {
        /*
            Method dump skipped, instructions count: 1110
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.autonavi.aps.amapapi.Aps.a(boolean, boolean, com.autonavi.aps.amapapi.AMapLocationStaticsEntity):com.autonavi.aps.amapapi.model.AMapLocationServer");
    }

    private AMapLocationServer a(int i3, String str) {
        AMapLocationServer aMapLocationServer = new AMapLocationServer("");
        aMapLocationServer.setErrorCode(i3);
        aMapLocationServer.setLocationDetail(str);
        if (i3 == 15) {
            ReportUtil.reportLocError(null, ReportUtil.EXCEPTION_CODE_MOCKNETLOC);
        }
        return aMapLocationServer;
    }
}
