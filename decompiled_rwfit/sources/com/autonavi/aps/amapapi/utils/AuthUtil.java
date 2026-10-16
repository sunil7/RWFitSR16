package com.autonavi.aps.amapapi.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.text.TextUtils;
import com.amap.api.col.p0003sl.ac;
import com.amap.api.col.p0003sl.c9;
import com.amap.api.col.p0003sl.ka;
import com.amap.api.col.p0003sl.m9;
import com.amap.api.col.p0003sl.n9;
import com.amap.api.col.p0003sl.q9;
import com.amap.api.col.p0003sl.y;
import com.amap.api.col.p0003sl.yb;
import com.amap.api.location.AMapLocationClientOption;
import com.autonavi.aps.amapapi.config.Const;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class AuthUtil {
    private static long A = 0;
    private static boolean B = false;
    private static int C = 0;
    private static boolean D = false;
    private static int E = 0;
    private static boolean F = false;
    private static String G = null;
    private static long H = 0;

    /* renamed from: a, reason: collision with root package name */
    private static volatile boolean f6789a = false;

    /* renamed from: b, reason: collision with root package name */
    private static boolean f6790b = true;

    /* renamed from: c, reason: collision with root package name */
    private static int f6791c = 1000;

    /* renamed from: d, reason: collision with root package name */
    private static int f6792d = 200;
    private static boolean e = false;

    /* renamed from: f, reason: collision with root package name */
    private static boolean f6793f = false;

    /* renamed from: g, reason: collision with root package name */
    private static boolean f6794g = false;

    /* renamed from: h, reason: collision with root package name */
    private static boolean f6795h = false;

    /* renamed from: i, reason: collision with root package name */
    private static int f6796i = 20;

    /* renamed from: j, reason: collision with root package name */
    private static int f6797j = 0;

    /* renamed from: k, reason: collision with root package name */
    private static volatile int f6798k = 0;

    /* renamed from: l, reason: collision with root package name */
    private static boolean f6799l = true;
    public static volatile long lastRequestConfig;

    /* renamed from: m, reason: collision with root package name */
    private static ArrayList<String> f6800m = new ArrayList<>();
    public static boolean mCarrierAble;
    public static int mCarrierInterVal;
    public static boolean mCarrierMobileUpdate;
    public static boolean mLocationDisable;
    public static int maxUpdate;

    /* renamed from: n, reason: collision with root package name */
    private static volatile boolean f6801n;

    /* renamed from: o, reason: collision with root package name */
    private static boolean f6802o;

    /* renamed from: p, reason: collision with root package name */
    private static long f6803p;

    /* renamed from: q, reason: collision with root package name */
    private static boolean f6804q;
    private static double r;

    /* renamed from: s, reason: collision with root package name */
    private static boolean f6805s;

    /* renamed from: t, reason: collision with root package name */
    private static int f6806t;

    /* renamed from: u, reason: collision with root package name */
    private static int f6807u;

    /* renamed from: v, reason: collision with root package name */
    static long f6808v;

    /* renamed from: w, reason: collision with root package name */
    private static boolean f6809w;

    /* renamed from: x, reason: collision with root package name */
    private static boolean f6810x;

    /* renamed from: y, reason: collision with root package name */
    static boolean f6811y;

    /* renamed from: z, reason: collision with root package name */
    private static boolean f6812z;

    public static class LocateObj {
    }

    static {
        new ArrayList();
        f6801n = false;
        f6802o = true;
        f6803p = Const.L_GPS_REBOOT_INTERVAL;
        f6804q = false;
        r = 0.618d;
        f6805s = true;
        f6806t = 80;
        f6807u = 5;
        f6808v = Const.L_WIFI_EXP;
        f6809w = true;
        f6810x = false;
        lastRequestConfig = 0L;
        f6811y = false;
        f6812z = true;
        A = -1L;
        B = true;
        C = 1;
        D = false;
        E = 5;
        F = false;
        G = "CMjAzLjEwNy4xLjEvMTU0MDgxL2Q";
        H = 0L;
        mCarrierAble = false;
        mCarrierMobileUpdate = false;
        maxUpdate = 20480;
        mCarrierInterVal = 10800000;
        mLocationDisable = false;
    }

    private static void a(c9.c cVar, SharedPreferences.Editor editor) {
        try {
            c9.c.a aVar = cVar.f3848d;
            if (aVar != null) {
                boolean z5 = aVar.f3849a;
                f6790b = z5;
                SPUtil.setPrefsBoolean(editor, Const.SP_KEY_EXCEPTION, z5);
                JSONObject jSONObject = aVar.f3850b;
                if (jSONObject != null) {
                    f6791c = jSONObject.optInt(Const.SP_KEY_FILENUM, f6791c);
                    int optInt = jSONObject.optInt(Const.SP_KEY_MAX_POINT_NUM, f6792d);
                    f6792d = optInt;
                    if (optInt > 500) {
                        f6792d = 500;
                    }
                    if (f6792d < 30) {
                        f6792d = 30;
                    }
                    e = c9.a(jSONObject.optString(Const.SP_KEY_GSM_UPLOAD), false);
                    f6796i = jSONObject.optInt(Const.SP_KEY_GSM_UPLOAD_MXSIZE, f6796i);
                    f6798k = jSONObject.optInt(Const.SP_KEY_RECORD_OFF_LOC_TYPE, 0);
                    f6797j = jSONObject.optInt(Const.SP_KEY_PER_UPLOAD_MXSIZE, 0);
                    f6793f = c9.a(jSONObject.optString(Const.SP_KEY_INFO_WRITE), false);
                    f6794g = c9.a(jSONObject.optString(Const.SP_KEY_INFO_UPLOAD), false);
                    f6795h = c9.a(jSONObject.optString(Const.SP_KEY_FORCED_UPLOAD), false);
                }
                yb.a(f6791c, e, f6796i, f6797j);
                ac.a(e, f6797j);
                boolean z6 = f6790b;
                boolean z8 = e;
                boolean z10 = f6793f;
                boolean z11 = f6794g;
                boolean z12 = f6795h;
                int i3 = y.f5412b;
                try {
                    q9.a(CoreUtil.getSDKInfo()).a(z6, z8, z10, z11, null);
                    q9.a(CoreUtil.getSDKInfo()).c(z12);
                } catch (Throwable th2) {
                    th2.printStackTrace();
                }
                SPUtil.setPrefsInt(editor, Const.SP_KEY_FILENUM, f6791c);
                SPUtil.setPrefsInt(editor, Const.SP_KEY_MAX_POINT_NUM, f6792d);
                SPUtil.setPrefsBoolean(editor, Const.SP_KEY_GSM_UPLOAD, e);
                SPUtil.setPrefsInt(editor, Const.SP_KEY_GSM_UPLOAD_MXSIZE, f6796i);
                SPUtil.setPrefsBoolean(editor, Const.SP_KEY_INFO_WRITE, f6793f);
                SPUtil.setPrefsBoolean(editor, Const.SP_KEY_INFO_UPLOAD, f6794g);
                SPUtil.setPrefsBoolean(editor, Const.SP_KEY_FORCED_UPLOAD, f6795h);
                SPUtil.setPrefsInt(editor, Const.SP_KEY_RECORD_OFF_LOC_TYPE, f6798k);
                SPUtil.setPrefsInt(editor, Const.SP_KEY_PER_UPLOAD_MXSIZE, f6797j);
            }
        } catch (Throwable th3) {
            CoreUtil.reportError(th3, "AuthUtil", "loadConfigDataUploadException");
        }
    }

    private static void b(JSONObject jSONObject, SharedPreferences.Editor editor) {
        try {
            JSONObject optJSONObject = jSONObject.optJSONObject("15O");
            if (optJSONObject != null) {
                if (c9.a(optJSONObject.optString("able"), false)) {
                    JSONArray optJSONArray = optJSONObject.optJSONArray("fl");
                    if (optJSONArray == null || optJSONArray.length() <= 0) {
                        A = optJSONObject.optInt("iv", 30) * 1000;
                    } else if (optJSONArray.toString().contains(Build.MANUFACTURER)) {
                        A = optJSONObject.optInt("iv", 30) * 1000;
                    } else {
                        A = -1L;
                    }
                } else {
                    A = -1L;
                }
                SPUtil.setPrefsLong(editor, Const.SP_KEY_AP_WIFI_SCAN_INTERVAL, A);
            }
        } catch (Throwable unused) {
        }
    }

    private static void c(JSONObject jSONObject, SharedPreferences.Editor editor) {
        try {
            JSONObject optJSONObject = jSONObject.optJSONObject("11G");
            if (optJSONObject != null) {
                boolean a3 = c9.a(optJSONObject.optString("able"), true);
                f6802o = a3;
                if (a3) {
                    f6803p = optJSONObject.optInt("c", 300) * 1000;
                }
                f6804q = c9.a(optJSONObject.optString("fa"), false);
                r = Math.min(1.0d, Math.max(0.2d, optJSONObject.optDouble(Const.SP_KEY_GSM_UPLOAD_MXSIZE, 0.618d)));
                SPUtil.setPrefsBoolean(editor, Const.SP_KEY_CACHEABLE, f6802o);
                SPUtil.setPrefsLong(editor, Const.SP_KEY_CACHETIME, f6803p);
                SPUtil.setPrefsBoolean(editor, Const.SP_KEY_FORCE_CACHEABLE, f6804q);
                SPUtil.setPrefsStr(editor, Const.SP_KEY_MIN_CACHE_SIM, String.valueOf(r));
            }
        } catch (Throwable th2) {
            CoreUtil.reportError(th2, "AuthUtil", "loadConfigDataCacheAble");
        }
    }

    private static void d(JSONObject jSONObject, SharedPreferences.Editor editor) {
        try {
            JSONObject optJSONObject = jSONObject.optJSONObject("13J");
            if (optJSONObject != null) {
                boolean a3 = c9.a(optJSONObject.optString("able"), true);
                f6805s = a3;
                if (a3) {
                    f6806t = optJSONObject.optInt("c", f6806t);
                    f6807u = optJSONObject.optInt("t", f6807u);
                }
                SPUtil.setPrefsBoolean(editor, Const.SP_KEY_GPS_GEO_ABLE, f6805s);
                SPUtil.setPrefsInt(editor, Const.SP_KEY_GPS_GEO_DIS, f6806t);
                SPUtil.setPrefsInt(editor, Const.SP_KEY_GPS_GEO_DELAY, f6807u);
            }
        } catch (Throwable th2) {
            CoreUtil.reportError(th2, "AuthUtil", "loadConfigDataGpsGeoAble");
        }
    }

    private static void e(JSONObject jSONObject, SharedPreferences.Editor editor) {
        int parseInt;
        if (jSONObject == null) {
            return;
        }
        try {
            JSONObject optJSONObject = jSONObject.optJSONObject("17J");
            if (optJSONObject != null) {
                boolean a3 = c9.a(optJSONObject.optString("able"), false);
                D = a3;
                SPUtil.setPrefsBoolean(editor, Const.SP_KEY_DNS_ABLE, a3);
                if (a3) {
                    String optString = optJSONObject.optString("auth");
                    String optString2 = optJSONObject.optString("ht");
                    G = optString2;
                    SPUtil.setPrefsStr(editor, Const.SP_KEY_DNS_HOST, optString2);
                    c9.a(optString, false);
                    F = c9.a(optJSONObject.optString("nr"), false);
                    String optString3 = optJSONObject.optString("tm");
                    if (TextUtils.isEmpty(optString3) || (parseInt = Integer.parseInt(optString3)) <= 0 || parseInt >= 20) {
                        return;
                    }
                    E = parseInt;
                    SPUtil.setPrefsInt(editor, Const.SP_KEY_DNS_TIME, parseInt);
                }
            }
        } catch (Throwable unused) {
        }
    }

    public static ArrayList<String> getAMapServcieNames() {
        return f6800m;
    }

    public static long getAPWifiScanInterval() {
        return A;
    }

    public static boolean getCacheAble() {
        return f6802o;
    }

    public static long getCacheValidTime() {
        return f6803p;
    }

    public static int getCheckGPSTimeOffsetYear() {
        return C;
    }

    public static int getFileNum() {
        return f6791c;
    }

    public static boolean getGpsGeoAble() {
        return f6805s;
    }

    public static int getGpsGeoDelay() {
        return f6807u;
    }

    public static int getGpsGeoDis() {
        return f6806t;
    }

    public static String getHost() {
        return n9.b(G);
    }

    public static boolean getHttpDNSAble() {
        return D;
    }

    public static int getMaxPointNum() {
        return f6792d;
    }

    public static double getMinCacheSim() {
        return r;
    }

    public static boolean getNeedRefresh() {
        return F;
    }

    public static int getRecordOffLogType() {
        if (f6798k < 0) {
            f6798k = 0;
        }
        return f6798k;
    }

    public static long getRequestSdkAuthInterval() {
        return f6808v;
    }

    public static long getSerTime() {
        return H;
    }

    public static int getTimeOut() {
        return E;
    }

    public static void initSDKLogHandler(Context context) {
        try {
            m9 sDKInfo = CoreUtil.getSDKInfo();
            sDKInfo.a(f6790b);
            ka.a(context, sDKInfo);
        } catch (Throwable unused) {
        }
    }

    public static boolean isCacheAble(long j4) {
        if (!f6802o) {
            return false;
        }
        long time = Utils.getTime() - j4;
        long j10 = f6803p;
        return j10 < 0 || time < j10;
    }

    public static boolean isCallAMap(Context context) {
        return false;
    }

    public static boolean isCanAlwaysScanWifi() {
        return f6812z;
    }

    public static boolean isCanUseNaviLoc() {
        return f6809w;
    }

    public static boolean isFirstReLocation() {
        return f6811y;
    }

    public static boolean isForceCacheAble() {
        return f6804q;
    }

    public static boolean isGsmUpload() {
        return e;
    }

    public static boolean isInstalledHighDangerMockApp() {
        return f6810x;
    }

    public static boolean isNeedCheckGpsTime() {
        return B && C > 0;
    }

    public static boolean isReciveMessage() {
        return f6799l;
    }

    public static boolean isUploadLog() {
        return f6790b;
    }

    public static void loadLastAbleState(Context context) {
        loadLastAbleState(context, null);
    }

    public static void registerLoadConfig(final Context context) {
        if (f6789a) {
            return;
        }
        f6789a = true;
        c9.a(context, CoreUtil.getSDKInfo(), CoreUtil.getLocOperType(), new c9.b() { // from class: com.autonavi.aps.amapapi.utils.AuthUtil.1
            @Override // com.amap.api.col.3sl.c9.b
            public void onReceiveAuthConfig(c9.c cVar) {
                AuthUtil.a(context, cVar);
            }
        });
    }

    public static void setReciveMessage(boolean z5) {
        f6799l = z5;
    }

    public static void loadLastAbleState(Context context, AMapLocationClientOption aMapLocationClientOption) {
        if (f6801n) {
            return;
        }
        f6801n = true;
        try {
            f6790b = SPUtil.getPrefsBoolean(context, Const.STR_PREF, Const.SP_KEY_EXCEPTION, f6790b);
            initSDKLogHandler(context);
        } catch (Throwable th2) {
            CoreUtil.reportError(th2, "AuthUtil", "loadLastAbleState p1");
        }
        try {
            f6791c = SPUtil.getPrefsInt(context, Const.STR_PREF, Const.SP_KEY_FILENUM, f6791c);
            f6792d = SPUtil.getPrefsInt(context, Const.STR_PREF, Const.SP_KEY_MAX_POINT_NUM, f6792d);
            e = SPUtil.getPrefsBoolean(context, Const.STR_PREF, Const.SP_KEY_GSM_UPLOAD, e);
            f6796i = SPUtil.getPrefsInt(context, Const.STR_PREF, Const.SP_KEY_GSM_UPLOAD_MXSIZE, f6796i);
            f6798k = SPUtil.getPrefsInt(context, Const.STR_PREF, Const.SP_KEY_RECORD_OFF_LOC_TYPE, 0);
            int prefsInt = SPUtil.getPrefsInt(context, Const.STR_PREF, Const.SP_KEY_PER_UPLOAD_MXSIZE, 0);
            f6797j = prefsInt;
            yb.a(f6791c, e, f6796i, prefsInt);
            ac.a(e, f6797j);
        } catch (Throwable th3) {
            CoreUtil.reportError(th3, "AuthUtil", "loadLastAbleState p2");
        }
        try {
            f6802o = SPUtil.getPrefsBoolean(context, Const.STR_PREF, Const.SP_KEY_CACHEABLE, f6802o);
            f6803p = SPUtil.getPrefsLong(context, Const.STR_PREF, Const.SP_KEY_CACHETIME, f6803p);
            f6804q = SPUtil.getPrefsBoolean(context, Const.STR_PREF, Const.SP_KEY_FORCE_CACHEABLE, f6804q);
            double doubleValue = Double.valueOf(SPUtil.getPrefsStr(context, Const.STR_PREF, Const.SP_KEY_MIN_CACHE_SIM, String.valueOf(r))).doubleValue();
            r = doubleValue;
            r = Math.max(0.2d, doubleValue);
        } catch (Throwable th4) {
            CoreUtil.reportError(th4, "AuthUtil", "loadLastAbleState p3");
        }
        try {
            f6811y = SPUtil.getPrefsBoolean(context, Const.STR_PREF, Const.SP_KEY_FIRSTLOC_RELOC, f6811y);
        } catch (Throwable th5) {
            CoreUtil.reportError(th5, "AuthUtil", "loadLastAbleState p4");
        }
        try {
            f6812z = SPUtil.getPrefsBoolean(context, Const.STR_PREF, Const.SP_KEY_CAN_ALWAYS_SCAN_WIFI, f6812z);
        } catch (Throwable th6) {
            CoreUtil.reportError(th6, "AuthUtil", "loadLastAbleState p5");
        }
        try {
            A = SPUtil.getPrefsLong(context, Const.STR_PREF, Const.SP_KEY_AP_WIFI_SCAN_INTERVAL, A);
        } catch (Throwable th7) {
            CoreUtil.reportError(th7, "AuthUtil", "loadLastAbleState p6");
        }
        try {
            B = SPUtil.getPrefsBoolean(context, Const.STR_PREF, Const.SP_KEY_CHECK_GPSTIME_ABLE, B);
            C = SPUtil.getPrefsInt(context, Const.STR_PREF, Const.SP_KEY_CHECK_GPSTIME_OFFSET_YEAR, C);
            H = SPUtil.getPrefsLong(context, Const.STR_PREF, Const.SP_KEY_SERVER_TIME, H);
        } catch (Throwable th8) {
            CoreUtil.reportError(th8, "AuthUtil", "loadLastAbleState p7");
        }
        try {
            D = SPUtil.getPrefsBoolean(context, Const.STR_PREF, Const.SP_KEY_DNS_ABLE, D);
            E = SPUtil.getPrefsInt(context, Const.STR_PREF, Const.SP_KEY_DNS_TIME, E);
            G = SPUtil.getPrefsStr(context, Const.STR_PREF, Const.SP_KEY_DNS_HOST, G);
        } catch (Throwable th9) {
            CoreUtil.reportError(th9, "AuthUtil", "loadLastAbleState p8");
        }
        try {
            mCarrierAble = SPUtil.getPrefsBoolean(context, Const.STR_PREF, Const.SP_CARRIER_ABLE, false);
            mCarrierMobileUpdate = SPUtil.getPrefsBoolean(context, Const.STR_PREF, Const.SP_CARRIER_MOBILE, false);
            mCarrierInterVal = SPUtil.getPrefsInt(context, Const.STR_PREF, Const.SP_CARRIER_INTERVAL, 2) * 3600000;
            maxUpdate = SPUtil.getPrefsInt(context, Const.STR_PREF, Const.SP_CARRIER_MAX, 100) * 1024;
        } catch (Throwable th10) {
            CoreUtil.reportError(th10, "AuthUtil", "loadLastAbleState p9");
        }
        try {
            lastRequestConfig = Utils.getTimeBoot();
            f6808v = SPUtil.getPrefsLong(context, Const.STR_PREF, Const.SP_KEY_REQUEST_AUTH_INTERVAL, f6808v);
            f6809w = SPUtil.getPrefsBoolean(context, Const.STR_PREF, Const.SP_KEY_CAN_USE_NAVI_LOC, f6809w);
            f6805s = SPUtil.getPrefsBoolean(context, Const.STR_PREF, Const.SP_KEY_GPS_GEO_ABLE, f6805s);
            f6806t = SPUtil.getPrefsInt(context, Const.STR_PREF, Const.SP_KEY_GPS_GEO_DIS, f6806t);
            f6807u = SPUtil.getPrefsInt(context, Const.STR_PREF, Const.SP_KEY_GPS_GEO_DELAY, f6807u);
        } catch (Throwable th11) {
            CoreUtil.reportError(th11, "AuthUtil", "loadLastAbleState p10");
        }
        c9.c(context);
        try {
            String prefsStr = SPUtil.getPrefsStr(context, Const.STR_PREF, Const.SP_KEY_MOCK_APP_LIST, null);
            if (!TextUtils.isEmpty(prefsStr) && aMapLocationClientOption != null && aMapLocationClientOption.isMockEnable()) {
                f6810x = a(context, new JSONArray(n9.b(prefsStr)));
            }
        } catch (Throwable th12) {
            CoreUtil.reportError(th12, "AuthUtil", "loadLastAbleState p11");
        }
        try {
            boolean prefsBoolean = SPUtil.getPrefsBoolean(context, Const.STR_PREF, Const.SP_DEMOTION_ABLE, false);
            String prefsStr2 = SPUtil.getPrefsStr(context, Const.STR_PREF, Const.SP_DEMOTION_SV, "");
            String prefsStr3 = SPUtil.getPrefsStr(context, Const.STR_PREF, Const.SP_DEMOTION_TV, "");
            if (prefsBoolean && CoreUtil.ENGINE_VERSION.equals(prefsStr2)) {
                for (String str : CoreUtil.DEMOTION_ENGINE_VERSION) {
                    if (str.equals(prefsStr3)) {
                        CoreUtil.ENGINE_VERSION = prefsStr3;
                    }
                }
            }
        } catch (Throwable th13) {
            CoreUtil.reportError(th13, "AuthUtil", "loadLastAbleState p12");
        }
        try {
            mLocationDisable = SPUtil.getPrefsBoolean(context, Const.STR_PREF, Const.SP_LOCATION_DISABLE, mLocationDisable);
        } catch (Throwable th14) {
            CoreUtil.reportError(th14, "AuthUtil", "loadSdkEnableConfig p13");
        }
    }

    public static boolean a(Context context, c9.c cVar) {
        SharedPreferences.Editor editor;
        try {
            editor = SPUtil.startEdit(context, Const.STR_PREF);
        } catch (Throwable unused) {
            editor = null;
        }
        try {
            a(cVar, editor);
            initSDKLogHandler(context);
            JSONObject jSONObject = cVar.f3847c;
            if (jSONObject == null) {
                if (editor != null) {
                    try {
                        SPUtil.endEdit(editor);
                    } catch (Throwable unused2) {
                    }
                }
                return true;
            }
            a(context, jSONObject, editor);
            c(jSONObject, editor);
            d(jSONObject, editor);
            b(jSONObject, editor);
            try {
                JSONObject optJSONObject = jSONObject.optJSONObject("15U");
                if (optJSONObject != null) {
                    boolean a3 = c9.a(optJSONObject.optString("able"), true);
                    int optInt = optJSONObject.optInt("yn", C);
                    H = optJSONObject.optLong(Const.JSON_KEY_SYSTIME, H);
                    SPUtil.setPrefsBoolean(editor, Const.SP_KEY_CHECK_GPSTIME_ABLE, a3);
                    SPUtil.setPrefsInt(editor, Const.SP_KEY_CHECK_GPSTIME_OFFSET_YEAR, optInt);
                    SPUtil.setPrefsLong(editor, Const.SP_KEY_SERVER_TIME, H);
                }
            } catch (Throwable unused3) {
            }
            a(jSONObject, editor);
            e(jSONObject, editor);
            try {
                JSONObject jSONObject2 = jSONObject.getJSONObject("197");
                if (jSONObject2 != null) {
                    boolean a10 = c9.a(jSONObject2.optString("able"), false);
                    SPUtil.setPrefsBoolean(editor, Const.SP_DEMOTION_ABLE, a10);
                    if (a10) {
                        SPUtil.setPrefsStr(editor, Const.SP_DEMOTION_SV, jSONObject2.optString("sv", ""));
                        SPUtil.setPrefsStr(editor, Const.SP_DEMOTION_TV, jSONObject2.optString("tv", ""));
                    } else {
                        SPUtil.setPrefsStr(editor, Const.SP_DEMOTION_SV, "");
                        SPUtil.setPrefsStr(editor, Const.SP_DEMOTION_TV, "");
                    }
                }
            } catch (Throwable unused4) {
            }
            try {
                JSONObject jSONObject3 = jSONObject.getJSONObject(Const.SP_LOCATION_DISABLE);
                if (jSONObject3 != null) {
                    boolean a11 = c9.a(jSONObject3.optString("ic"), false);
                    SPUtil.setPrefsBoolean(editor, Const.SP_LOCATION_DISABLE, a11);
                    mLocationDisable = a11;
                }
            } catch (Throwable unused5) {
            }
            if (editor != null) {
                try {
                    SPUtil.endEdit(editor);
                } catch (Throwable unused6) {
                }
            }
            return true;
        } catch (Throwable unused7) {
            if (editor != null) {
                try {
                    SPUtil.endEdit(editor);
                } catch (Throwable unused8) {
                }
            }
            return false;
        }
    }

    public static void a(Context context, JSONObject jSONObject, SharedPreferences.Editor editor) {
        try {
            JSONObject optJSONObject = jSONObject.optJSONObject("13S");
            if (optJSONObject != null) {
                try {
                    long optInt = optJSONObject.optInt("at", 123) * 60000;
                    f6808v = optInt;
                    SPUtil.setPrefsLong(editor, Const.SP_KEY_REQUEST_AUTH_INTERVAL, optInt);
                } catch (Throwable th2) {
                    CoreUtil.reportError(th2, "AuthUtil", "requestSdkAuthInterval");
                }
                try {
                    boolean a3 = c9.a(optJSONObject.optString("re"), false);
                    f6811y = a3;
                    SPUtil.setPrefsBoolean(editor, Const.SP_KEY_FIRSTLOC_RELOC, a3);
                } catch (Throwable th3) {
                    CoreUtil.reportError(th3, "AuthUtil", "checkReLocationAble");
                }
                try {
                    boolean a10 = c9.a(optJSONObject.optString("nla"), true);
                    f6809w = a10;
                    SPUtil.setPrefsBoolean(editor, Const.SP_KEY_CAN_USE_NAVI_LOC, a10);
                } catch (Throwable unused) {
                }
                try {
                    boolean a11 = c9.a(optJSONObject.optString(Const.SP_KEY_CAN_ALWAYS_SCAN_WIFI), true);
                    f6812z = a11;
                    SPUtil.setPrefsBoolean(editor, Const.SP_KEY_CAN_ALWAYS_SCAN_WIFI, a11);
                } catch (Throwable unused2) {
                }
                try {
                    JSONArray optJSONArray = optJSONObject.optJSONArray("mlpl");
                    if (optJSONArray != null && optJSONArray.length() > 0 && context != null) {
                        SPUtil.setPrefsStr(editor, Const.SP_KEY_MOCK_APP_LIST, n9.f(optJSONArray.toString()));
                        f6810x = a(context, optJSONArray);
                    } else {
                        f6810x = false;
                        SPUtil.removeKeyData(editor, Const.SP_KEY_MOCK_APP_LIST);
                    }
                } catch (Throwable unused3) {
                }
            }
        } catch (Throwable th4) {
            CoreUtil.reportError(th4, "AuthUtil", "loadConfigAbleStatus");
        }
    }

    private static boolean a(Context context, JSONArray jSONArray) {
        try {
            if (jSONArray.length() > 0 && context != null) {
                for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                    if (Utils.checkInstallByPkg(context, jSONArray.getString(i3))) {
                        return true;
                    }
                }
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    private static void a(JSONObject jSONObject, SharedPreferences.Editor editor) {
        if (jSONObject == null) {
            return;
        }
        try {
            JSONObject jSONObject2 = jSONObject.getJSONObject("17Y");
            if (jSONObject2 != null) {
                boolean a3 = c9.a(jSONObject2.optString("able"), false);
                mCarrierAble = a3;
                SPUtil.setPrefsBoolean(editor, Const.SP_CARRIER_ABLE, a3);
                boolean a10 = c9.a(jSONObject2.optString("mup"), false);
                mCarrierMobileUpdate = a10;
                SPUtil.setPrefsBoolean(editor, Const.SP_CARRIER_MOBILE, a10);
                int optInt = jSONObject2.optInt("max", 20);
                if (optInt > 0) {
                    SPUtil.setPrefsInt(editor, Const.SP_CARRIER_MAX, optInt);
                    maxUpdate = optInt * 1024;
                }
                int optInt2 = jSONObject2.optInt("inv", 3);
                if (optInt2 > 0) {
                    SPUtil.setPrefsInt(editor, Const.SP_CARRIER_INTERVAL, optInt2);
                    mCarrierInterVal = optInt2 * 3600000;
                }
            }
        } catch (Throwable unused) {
        }
    }
}
