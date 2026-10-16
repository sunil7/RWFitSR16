package com.autonavi.aps.amapapi.utils;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.amap.api.col.p0003sl.a9;
import com.amap.api.col.p0003sl.b9;
import com.amap.api.col.p0003sl.e9;
import com.amap.api.col.p0003sl.fa;
import com.amap.api.col.p0003sl.g9;
import com.amap.api.col.p0003sl.ka;
import com.amap.api.col.p0003sl.m9;
import com.amap.api.col.p0003sl.n9;
import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClientOption;
import com.autonavi.aps.amapapi.config.Const;
import com.autonavi.aps.amapapi.security.Encrypt;
import com.tencent.open.SocialConstants;
import java.util.HashMap;
import java.util.Locale;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class CoreUtil {
    public static final String AMAP_LICENSE = "S128DF1572465B890OE3F7A13167KLEI";
    public static final String AMAP_SRC = "api_serverSDK_130905";
    public static final boolean B_FILTER_GPS2LBS = false;
    public static final String CODE_UTF8 = "UTF-8";
    public static String ENGINE_VERSION = "5.3";
    public static final String HTTP_HEADER_USER_AGENT = "AMAP_Location_SDK_Android 11.1.060";
    public static final float LOCATIONDIS = 0.0f;
    public static final String PRODUCT_FIRST_LOC = "locf";
    public static final String SDK_NAME = "loc";
    public static final String STR_API_DEFAULT_DNS_HOST = "httpdns.apilocate.amap.com";
    public static final String STR_API_DNS_SERVER = "http://httpdns.apilocate.amap.com/mobile/binary";
    public static final String STR_API_INOFCN_HOST = "apilocate.amap.com";
    public static final String STR_API_INOFCN_HOST_IPV6 = "apilocate.amap.com";
    public static final String STR_API_INOFCN_IPV6_SERVER = "http://a.apilocate.amap.com/mobile/binary";
    public static final String STR_API_INOFCN_SERVER = "http://apilocate.amap.com/mobile/binary";
    public static final String STR_API_INOFCN_STATIC_HOST = "a.apilocate.amap.com";
    public static final String STR_API_OUTOFCN_HOST = "abroad.apilocate.amap.com";
    public static final String STR_API_OUTOFCN_SERVER = "http://abroad.apilocate.amap.com/mobile/binary";
    public static final String STR_CONFIG_VERSION = "11.1.060";
    public static final String STR_DEX_COLLECTION_NAME = "Collection";
    public static final String STR_DEX_COLLECTION_VERSION = "1.0.0";
    public static final String STR_DEX_GEO_FENCE_NAME = "GeoFence";
    public static final String STR_DEX_GEO_FENCE_VERSION = "1.0.0";
    public static final String STR_DEX_HTTP_DNS_NAME = "HttpDNS";
    public static final String STR_DEX_HTTP_DNS_VERSION = "1.0.0";
    public static final String STR_DEX_MAC_NAME = "mac";
    public static final String STR_DEX_MAC_VERSION = "1.0.0";
    public static final String STR_ORIGN_LICENSE = "BKZCHMBBSSUK7U8GLUKHBB56CCFF78U";
    public static final String STR_ORIGN_SRC = "UC_nlp_20131029";
    public static final String STR_REGEO_IPV6_SERVER = "http://arestapi.amap.com/v3/geocode/regeo";
    public static final int TIMEOUT_SECONDS = 5;
    public static final String URL_PATH_STR_REGEO_SERVER = "/v3/geocode/regeo";

    /* renamed from: a, reason: collision with root package name */
    static String f6814a = "http://apilocate.amap.com/mobile/binary";

    /* renamed from: b, reason: collision with root package name */
    static String f6815b = "http://a.apilocate.amap.com/mobile/binary";

    /* renamed from: d, reason: collision with root package name */
    static String f6817d = null;
    static HashMap<String, String> e = null;

    /* renamed from: f, reason: collision with root package name */
    private static m9 f6818f = null;
    public static int iTo = 30000;
    public static String strAppSha1;
    public static String strAppname;
    public static String strImeiMeid;
    public static String strImsi;
    public static final String[] DEMOTION_ENGINE_VERSION = {"5.1"};

    /* renamed from: c, reason: collision with root package name */
    private static final String[] f6816c = {"com.amap.api.location", "com.loc", "com.amap.api.fence"};

    private static boolean a(double d5, double d8, double d10, double d11, double d12, double d13, double d14, double d15) {
        double d16 = d10 - d5;
        double d17 = d15 - d13;
        double d18 = d11 - d8;
        double d19 = d14 - d12;
        double d20 = (d16 * d17) - (d18 * d19);
        if (d20 == 0.0d) {
            return false;
        }
        double d21 = d8 - d13;
        double d22 = d5 - d12;
        double d23 = ((d19 * d21) - (d17 * d22)) / d20;
        double d24 = ((d21 * d16) - (d22 * d18)) / d20;
        return d23 >= 0.0d && d23 <= 1.0d && d24 >= 0.0d && d24 <= 1.0d;
    }

    public static void changeUrl(Context context) {
        try {
            g9 b3 = g9.b(context);
            int i3 = n9.f4707d;
            if (fa.a(context, false)) {
                String a3 = b3.a(40);
                f6814a = a3;
                f6815b = a3;
                return;
            }
            f6814a = "http://" + b3.a(43) + ReportUtil.PATH_LOC;
            f6815b = "http://" + b3.a(44) + ReportUtil.PATH_LOC;
        } catch (Throwable th2) {
            reportError(th2, "CoreUtil", "changeUrl");
        }
    }

    public static void checkUrl(Context context) {
        try {
            String a3 = g9.b(context).a(40);
            int i3 = n9.f4707d;
            if (fa.a(context, false)) {
                f6814a = a3;
                return;
            }
            try {
                if (e == null) {
                    e = new HashMap<>(16);
                }
                e.clear();
                e.put("fe643c382e5c3b3962141f1a2e815a78", "FB923EE67A8B4032DAA517DD8CD7A26FF7C25B0C3663F92A0B61251C4FFFA858DF169D61321C3E7919CB67DF8EFEC827");
                e.put("9a571aa113ad987d626c0457828962e6", "D2FF99A88BEB04683D89470D4FA72B1749DA456AB0D0F1A476477CE5A6874F53A9106423D905F9D808C0FCE8E7F1E04AC642F01FE41D0C7D933971F45CBA72B7");
                e.put("668319f11506def6208d6afe320dfd52", "53E53D46011A6BBAEA4FAE5442E659E0577CDD336F930C28635C322FB3F51C3C63F7FBAC9EAE448DFA2E5E5D716C4807");
            } catch (Throwable th2) {
                reportError(th2, "CoreUtil", "initUrlHash");
            }
            String generatorKey = Encrypt.generatorKey(b9.e(context));
            f6817d = generatorKey;
            a(generatorKey);
        } catch (Throwable th3) {
            reportError(th3, "CoreUtil", "checkUrl");
        }
    }

    public static m9 getDexSDKInfo(String str, String str2) {
        try {
            return new m9.a(str, str2, HTTP_HEADER_USER_AGENT).a(getPackage()).a();
        } catch (Throwable th2) {
            reportError(th2, "CoreUtil", "getSDKInfo");
            return null;
        }
    }

    public static String getLocOperType() {
        return "11G;11K;13J;13S;15O;15U;17J;17Y;197;1A6";
    }

    public static Bundle getOptionBundle(AMapLocationClientOption aMapLocationClientOption) {
        Bundle bundle = new Bundle();
        if (aMapLocationClientOption == null) {
            aMapLocationClientOption = new AMapLocationClientOption();
        }
        try {
            bundle.putParcelable("opt", aMapLocationClientOption);
            return bundle;
        } catch (Throwable th2) {
            reportError(th2, "CoreUtil", "getOptionBundle");
            return bundle;
        }
    }

    public static AMapLocationClientOption getOptionFromBundle(Bundle bundle) {
        AMapLocationClientOption aMapLocationClientOption = new AMapLocationClientOption();
        if (bundle != null) {
            try {
                bundle.setClassLoader(AMapLocationClientOption.class.getClassLoader());
                return (AMapLocationClientOption) bundle.getParcelable("opt");
            } catch (Throwable th2) {
                reportError(th2, "CoreUtil", "getOptionFromBundle");
            }
        }
        return aMapLocationClientOption;
    }

    public static JSONObject getOptionJson(AMapLocationClientOption aMapLocationClientOption) {
        JSONObject jSONObject = new JSONObject();
        if (aMapLocationClientOption == null) {
            aMapLocationClientOption = new AMapLocationClientOption();
        }
        try {
            jSONObject.put("nbssid", "0");
            jSONObject.put("reversegeo", aMapLocationClientOption.isNeedAddress());
            jSONObject.put(Const.JSON_KEY_ISOFFSET, aMapLocationClientOption.isOffset());
            jSONObject.put("wifiactivescan", aMapLocationClientOption.isWifiActiveScan() ? "1" : "0");
            jSONObject.put("httptimeout", aMapLocationClientOption.getHttpTimeOut());
            jSONObject.put("isOnceLocationLatest", aMapLocationClientOption.isOnceLocationLatest());
            jSONObject.put("isKillProcess", aMapLocationClientOption.isKillProcess() ? "1" : "0");
            boolean z5 = true;
            if (aMapLocationClientOption.getLocationProtocol().ordinal() != 1) {
                z5 = false;
            }
            jSONObject.put("locationProtocol", z5);
            jSONObject.put("sensorEnable", aMapLocationClientOption.isSensorEnable());
            jSONObject.put("isWifiPassiveScan", aMapLocationClientOption.isWifiScan());
            jSONObject.put("isMock", aMapLocationClientOption.isMockEnable());
            return jSONObject;
        } catch (Throwable th2) {
            reportError(th2, "CoreUtil", "getOptionJson");
            return jSONObject;
        }
    }

    public static String[] getPackage() {
        return (String[]) f6816c.clone();
    }

    public static m9 getSDKInfo() {
        try {
            if (f6818f == null) {
                f6818f = new m9.a("loc", STR_CONFIG_VERSION, HTTP_HEADER_USER_AGENT).a(getPackage()).a(STR_CONFIG_VERSION).a();
            }
        } catch (Throwable th2) {
            reportError(th2, "CoreUtil", "getSDKInfo");
        }
        return f6818f;
    }

    public static String getScode(Context context) {
        return e9.c(b9.g(context));
    }

    public static String getStrApiServer() {
        return f6814a;
    }

    public static String getStrIPV6ApiServer() {
        return f6815b;
    }

    public static boolean isChina(double d5, double d8) {
        int i3 = (int) ((d8 - 73.0d) / 0.5d);
        int i10 = (int) ((d5 - 3.5d) / 0.5d);
        if (i10 < 0 || i10 >= 101 || i3 < 0 || i3 >= 124) {
            return false;
        }
        try {
            return "00000000000000000000000000000000000000000000000000000000000000000000000000000010000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000010000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000011000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000001100000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000001000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000010000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000001100000001011000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000011101010111100000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000110111111111000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000111101111110000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000001000110111100000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000001111111110000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000001111111100000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000011010111000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000001110011100000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000010001000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000100000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000110000001000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000001010011100000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000111100110001000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000001110000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000001100000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000001111000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000111110000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000011111000111000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000001111110011000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000001110000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000001111000000000111000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000111100000000000010111110100000011000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000111110000000001111111111111111000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000111111111000000111111111111111110000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000011111111111101111111111111111111111100000000000000000000000000000000000000000000000000000000000000000000000000000000000000011111111111111111111111111111111111111000000000000000000000000000000000000000000000000000000000000000000000000000000000000101111111111111111111111111111111111111110000000000000000000000000000000000000000000000000000000000000000000000000000000000011111111111111111111111111111111111111111100000000000000000000000000000000000000000000000000000000000000000000000000000000001111111111111111111111111111111111111111111100000000000000000000000000000000000000000000000000000000000000000000000000000000111111111111111111111111111111111111111111111000000000000000000000000000000000000000000000000000000000000000000000000000000001111111111111111111111111111111111111111111100000000000000000000000000000000000000000000000000000000000000000000000000000000011111111111111111111111111111111111111111111100000000000000000000000000000000000000000000000000000000000000000011110000000001111111111111111111111111111111111111111111110000000000000000000000000000000000000000000000000000000000011000011111100000000111111111111111111111111111111111111111111111100000000000000000000000000000000000000000000000000001111111100111111111100110111111111111111111111111111111111111111111111110000000000000000000000000000000000000000000000000001111111111111111111111111111111111111111111111111111111111111111111111111100000000000000000000000000000000000000000000000011111111111111111111111111111111111111111111111111111111111111111111111111111000000000000000000000000000000000000000000000111111111111111111111111111111111111111111111111111111111111111111111111111111100000000000000000000000000000000000000000101111111111111111111111111111111111111111111111111111111111111111111111111111111111000000000000000000000000000000000000001111111111111111111111111111111111111111111111111111111111111111111111111111111111111100000000000000000000000000000000000011111111111111111111111111111111111111111111111111111111111111111111111111111111111111110000000000000000000000000000000000011111111111111111111111111111111111111111111111111111111111111111111111111111111111111110000000000000000000000000000000000001111111111111111111111111111111111111111111111111111111111111111111111111111111111111110000000000000000000000000000000000001111111111111111111111111111111111111111111111111111111111111111111111111111111111111111000000000000000000000000000000000000111111111111111111111111111111111111111111111111111111111111111111111111111111111111111000000000000000000000000000000000000001111111111111111111111111111111111111111111111111111111111111111111111111111111111111000000000000000000000000000000000000000111111111111111111111111111111111111111111111111111111111111111111111111111111111111100000000000000000000000000000000000000011111111111111111111111111111111111111111111111111111111111111111111111111111111111100000000000000000000000000000000000000011111111111111111111111111111111111111111111111111111111111111111111111111111111111100000000000000000000000000000000000000111111111111111111111111111111111111111111111111111111111111111111111111111111111111110000000000000000000000000000000000001111111111111111111111111111111111111111111111111111111111111111111111111111111111111111110000000000000000000000000000000001111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111100000000000000000000000000000011111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111110000000000000000000000000011111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111000000000000000000000000000111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111011111000000000000000000000000000111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111100100000000000000000000000000000111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111100011100000000000000000000000000011111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111000111110000000000000000000000001111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111110011111110000000000000000000000111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111110111111110000000000000000000000111011111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111110000000000000000000000001111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111100000000000000000000000011111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111000000000000000000000000011111111111111111111111111111111111111111111111100001111111111111111111111111111111111111111111111111010000000000000000000000111111111111111111111111111111111111111111110000000000000001111111111111111111111111111111111111111111100000000000000000000011111111111111111111111111111111100000000000000000000000000001111111111111111111111111111111111111111110000000000000000000001111111111111111111111111111111100000000000000000000000000000001111111111111111111111111111111111111111000000000000000000000111111111111111111111111111111110000000000000000000000000000001111111111111111111111111111111111111111100000000000000000000111111111111111111111111111111000000000000000000000000000000000111111111111111111111111111111111111111111000000000000000000001111111111111111111111111110000000000000000000000000000000000001110011111111111111111111111111111111111111100000000000000000000011111111111111111100000000000000000000000000000000000000000000000001111111111111111111111111111111111111000000000000000000001111111111111111111000000000000000000000000000000000000000000000000011111111111111111111111111111111111100000000000000000000011111111111111111100000000000000000000000000000000000000000000000000011111111111111111111111111111111111000000000000000000001111111111111111100000000000000000000000000000000000000000000000000000000111111111111111111111111111111110000000000000000000000000111111111100000000000000000000000000000000000000000000000000111111111111111111111111111111111111111000000000000000000000000011111111100000000000000000000000000000000000000000000000000011111111111111111111111111111110001111100000000000000000000000000111110000000000000000000000000000000000000000000000000000001111111111111111111111111111111000000000000000000000000000000000001110000000000000000000000000000000000000000000000000000000011111111111111111111111111111000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000001111111111111111111111111100000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000111111111111111111000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000011111111111111111000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000111111111111111100000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000011111111111111100000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000011111111111110000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000011111111111110000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000001111111111110000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000010110000000000000000000000".charAt((i10 * 124) + i3) == '1';
        } catch (Throwable th2) {
            reportError(th2, "CoreUtil", "isChina");
            return true;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x00a9, code lost:
    
        if (r9 > r19) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x00ab, code lost:
    
        r20 = r13;
        r19 = r14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x00b0, code lost:
    
        r20 = r13;
        r19 = r14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x00c6, code lost:
    
        if (r19 > r9) goto L18;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static boolean isInPolygon(com.amap.api.location.DPoint r28, java.util.List<com.amap.api.location.DPoint> r29) {
        /*
            Method dump skipped, instructions count: 246
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.autonavi.aps.amapapi.utils.CoreUtil.isInPolygon(com.amap.api.location.DPoint, java.util.List):boolean");
    }

    public static void reportError(Throwable th2, String str, String str2) {
        if ("reportError".equals(str2)) {
            return;
        }
        try {
            if (th2 instanceof a9) {
                return;
            }
            ka.a(th2, str, str2);
        } catch (Throwable unused) {
        }
    }

    public static AMapLocation transformAddress(AMapLocation aMapLocation, AMapLocation aMapLocation2) {
        if (aMapLocation2 != null) {
            try {
                aMapLocation.setCountry(aMapLocation2.getCountry());
                aMapLocation.setRoad(aMapLocation2.getRoad());
                aMapLocation.setPoiName(aMapLocation2.getPoiName());
                aMapLocation.setStreet(aMapLocation2.getStreet());
                aMapLocation.setNumber(aMapLocation2.getStreetNum());
                String cityCode = aMapLocation2.getCityCode();
                String adCode = aMapLocation2.getAdCode();
                aMapLocation.setCityCode(cityCode);
                aMapLocation.setAdCode(adCode);
                aMapLocation.setCity(aMapLocation2.getCity());
                aMapLocation.setDistrict(aMapLocation2.getDistrict());
                aMapLocation.setProvince(aMapLocation2.getProvince());
                aMapLocation.setAoiName(aMapLocation2.getAoiName());
                aMapLocation.setAddress(aMapLocation2.getAddress());
                aMapLocation.setDescription(aMapLocation2.getDescription());
                if (aMapLocation.getExtras() != null) {
                    aMapLocation.getExtras().putString(Const.JSON_KEY_CITYCODE, aMapLocation2.getCityCode());
                    aMapLocation.getExtras().putString("desc", aMapLocation2.getExtras().getString("desc"));
                    aMapLocation.getExtras().putString(Const.JSON_KEY_ADCODE, aMapLocation2.getAdCode());
                    return aMapLocation;
                }
                Bundle bundle = new Bundle();
                bundle.putString(Const.JSON_KEY_CITYCODE, aMapLocation2.getCityCode());
                bundle.putString("desc", aMapLocation2.getExtras().getString("desc"));
                bundle.putString(Const.JSON_KEY_ADCODE, aMapLocation2.getAdCode());
                aMapLocation.setExtras(bundle);
            } catch (Throwable unused) {
            }
        }
        return aMapLocation;
    }

    public static void transformLocation(AMapLocation aMapLocation, JSONObject jSONObject) {
        if (jSONObject == null || aMapLocation == null) {
            return;
        }
        try {
            double optDouble = jSONObject.optDouble(Const.JSON_KEY_LAT, aMapLocation.getLatitude());
            double optDouble2 = jSONObject.optDouble(Const.JSON_KEY_LON, aMapLocation.getLongitude());
            aMapLocation.setProvider(jSONObject.optString(Const.JSON_KEY_PROVIDER, aMapLocation.getProvider()));
            aMapLocation.setLatitude(optDouble);
            aMapLocation.setLongitude(optDouble2);
            aMapLocation.setAltitude(jSONObject.optDouble("altitude", aMapLocation.getAltitude()));
            try {
                String optString = jSONObject.optString(Const.JSON_KEY_ACCURACY);
                if (!TextUtils.isEmpty(optString)) {
                    aMapLocation.setAccuracy(Float.parseFloat(optString));
                }
            } catch (Throwable unused) {
            }
            try {
                String optString2 = jSONObject.optString(Const.JSON_KEY_SPEED);
                if (!TextUtils.isEmpty(optString2)) {
                    aMapLocation.setSpeed(Float.parseFloat(optString2));
                }
            } catch (Throwable unused2) {
            }
            try {
                String optString3 = jSONObject.optString(Const.JSON_KEY_BEARING);
                if (!TextUtils.isEmpty(optString3)) {
                    aMapLocation.setBearing(Float.parseFloat(optString3));
                }
            } catch (Throwable unused3) {
            }
            aMapLocation.setAdCode(jSONObject.optString(Const.JSON_KEY_ADCODE, aMapLocation.getAdCode()));
            aMapLocation.setCityCode(jSONObject.optString(Const.JSON_KEY_CITYCODE, aMapLocation.getCityCode()));
            aMapLocation.setAddress(jSONObject.optString(Const.JSON_KEY_ADDRESS, aMapLocation.getAddress()));
            String optString4 = jSONObject.optString("desc", "");
            aMapLocation.setCountry(jSONObject.optString("country", aMapLocation.getCountry()));
            aMapLocation.setProvince(jSONObject.optString("province", aMapLocation.getProvince()));
            aMapLocation.setCity(jSONObject.optString("city", aMapLocation.getCity()));
            aMapLocation.setDistrict(jSONObject.optString("district", aMapLocation.getDistrict()));
            aMapLocation.setRoad(jSONObject.optString(Const.JSON_KEY_ROAD, aMapLocation.getRoad()));
            aMapLocation.setStreet(jSONObject.optString(Const.JSON_KEY_STREET, aMapLocation.getStreet()));
            aMapLocation.setNumber(jSONObject.optString(Const.JSON_KEY_NUMBER, aMapLocation.getStreetNum()));
            aMapLocation.setPoiName(jSONObject.optString(Const.JSON_KEY_POINAME, aMapLocation.getPoiName()));
            aMapLocation.setAoiName(jSONObject.optString(Const.JSON_KEY_AOINAME, aMapLocation.getAoiName()));
            aMapLocation.setErrorCode(jSONObject.optInt("errorCode", aMapLocation.getErrorCode()));
            aMapLocation.setErrorInfo(jSONObject.optString("errorInfo", aMapLocation.getErrorInfo()));
            aMapLocation.setLocationType(jSONObject.optInt("locationType", aMapLocation.getLocationType()));
            aMapLocation.setLocationDetail(jSONObject.optString(Const.JSON_KEY_LOCATIONDETAIL, aMapLocation.getLocationDetail()));
            aMapLocation.setTime(jSONObject.optLong(Const.JSON_KEY_TIME, aMapLocation.getTime()));
            boolean optBoolean = jSONObject.optBoolean(Const.JSON_KEY_ISOFFSET, aMapLocation.isOffset());
            aMapLocation.setOffset(optBoolean);
            aMapLocation.setBuildingId(jSONObject.optString(Const.JSON_KEY_POIID, aMapLocation.getBuildingId()));
            aMapLocation.setFloor(jSONObject.optString(Const.JSON_KEY_FLOOR, aMapLocation.getFloor()));
            aMapLocation.setDescription(jSONObject.optString(SocialConstants.PARAM_COMMENT, aMapLocation.getDescription()));
            if (jSONObject.has("coordType")) {
                aMapLocation.setCoordType(jSONObject.optString("coordType", "GCJ02"));
            } else if (!isChina(optDouble, optDouble2)) {
                aMapLocation.setCoordType("WGS84");
            } else if (optBoolean) {
                aMapLocation.setCoordType("GCJ02");
            } else {
                aMapLocation.setCoordType("WGS84");
            }
            Bundle bundle = new Bundle();
            bundle.putString(Const.JSON_KEY_CITYCODE, aMapLocation.getCityCode());
            bundle.putString("desc", optString4.toString());
            bundle.putString(Const.JSON_KEY_ADCODE, aMapLocation.getAdCode());
            aMapLocation.setExtras(bundle);
        } catch (Throwable th2) {
            reportError(th2, "CoreUtil", "transformLocation");
        }
    }

    public static void a(String str) {
        HashMap<String, String> hashMap;
        String str2;
        byte[] bArr;
        if (str != null) {
            try {
                if (str.length() != 0 && (hashMap = e) != null && hashMap.containsKey(str)) {
                    String str3 = e.get(str);
                    if (str3 == null || str3.length() <= 0) {
                        str2 = null;
                    } else {
                        if (str3.length() < 2) {
                            bArr = new byte[0];
                        } else {
                            String lowerCase = str3.toLowerCase(Locale.US);
                            int length = lowerCase.length() / 2;
                            byte[] bArr2 = new byte[length];
                            for (int i3 = 0; i3 < length; i3++) {
                                int i10 = i3 * 2;
                                bArr2[i3] = (byte) (Utils.parseInt(lowerCase.substring(i10, i10 + 2), 16) & 255);
                            }
                            bArr = bArr2;
                        }
                        str2 = new String(Encrypt.aesDecrypt(bArr, str), "utf-8");
                    }
                    if (str2 == null || str2.length() <= 0 || !str2.contains(Const.HTTP_START)) {
                        return;
                    }
                    f6814a = str2;
                }
            } catch (Throwable th2) {
                reportError(th2, "CoreUtil", "checkUrl");
            }
        }
    }

    private static boolean a(double d5, double d8, double d10, double d11, double d12, double d13) {
        if (Math.abs(((d13 - d8) * (d10 - d5)) - ((d11 - d8) * (d12 - d5))) >= 1.0E-9d) {
            return false;
        }
        if ((d5 - d12) * (d5 - d10) <= 0.0d) {
            return (d8 - d13) * (d8 - d11) <= 0.0d;
        }
        return false;
    }
}
