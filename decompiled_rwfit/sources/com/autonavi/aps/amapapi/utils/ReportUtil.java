package com.autonavi.aps.amapapi.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.SparseArray;
import com.amap.api.col.p0003sl.a9;
import com.amap.api.col.p0003sl.ac;
import com.amap.api.col.p0003sl.ka;
import com.amap.api.col.p0003sl.m9;
import com.amap.api.col.p0003sl.xb;
import com.amap.api.col.p0003sl.yb;
import com.amap.api.col.p0003sl.zb;
import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClientOption;
import com.autonavi.aps.amapapi.AMapLocationStaticsEntity;
import com.autonavi.aps.amapapi.config.Const;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class ReportUtil {
    public static final float BIGSHIFT_DIST = 30000.0f;
    public static final float BIGSHIFT_SPEED = 1000.0f;
    public static final long BIGSHIFT_VALIDTIME = 1800;
    public static final String DEX_NAME_HTTPDNS = "HttpDns";
    public static final int EXCEPTION_AIRPLANEMODE_WIFIOFF = 2132;
    public static final int EXCEPTION_CODE_BINDSERVICE = 2101;
    public static final int EXCEPTION_CODE_CGIINFOERROR = 2111;
    public static final int EXCEPTION_CODE_CONTEXTISNULL = 2011;
    public static final int EXCEPTION_CODE_CREATEAPSREQ = 2031;
    public static final int EXCEPTION_CODE_DESCRYPTRESPONSE = 2053;
    public static final int EXCEPTION_CODE_FUSION_LOC_FAIL = 2156;
    public static final int EXCEPTION_CODE_GPSORNLPUNABLE = 2155;
    public static final int EXCEPTION_CODE_INTT = 2091;
    public static final int EXCEPTION_CODE_LOCALLOC = 2081;
    public static final int EXCEPTION_CODE_MAYBEINTERCEPTED = 2052;
    public static final int EXCEPTION_CODE_MOCKGPSLOC = 2152;
    public static final int EXCEPTION_CODE_MOCKNETLOC = 2151;
    public static final int EXCEPTION_CODE_NEEDLOGINNETWORK = 2051;
    public static final int EXCEPTION_CODE_NET_LOC_FAIL = 2157;
    public static final int EXCEPTION_CODE_NOCGIANDWIFI = 2131;
    public static final int EXCEPTION_CODE_NOENOUGHSTATELLITES = 2141;
    public static final int EXCEPTION_CODE_NOLOCPERMISSION = 2121;
    public static final int EXCEPTION_CODE_NOMAINWIFIANDONLYONE = 2022;
    public static final int EXCEPTION_CODE_NOTAPSSERVICE = 2103;
    public static final int EXCEPTION_CODE_ONLYMAINWIFI = 2021;
    public static final int EXCEPTION_CODE_PARSERDATA = 2054;
    public static final int EXCEPTION_CODE_REDESC = 2062;
    public static final int EXCEPTION_CODE_RESPONSEBODYISNULL = 2041;
    public static final int EXCEPTION_CODE_RETYPE = 2061;
    public static final int EXCEPTION_CODE_SERVERAUTHCLIENSCODE = 2102;
    public static final int EXCEPTION_CODE_UNSUPPORTCOARSELBSLOC = 2153;
    public static final int EXCEPTION_CODE_UNSUPPORTCONTINUELOC = 2154;
    public static final int EXCEPTION_NOCGI_WIFIOFF = 2133;
    public static final String PATH_LOC = "/mobile/binary";
    public static final String STATICS_ID_COORDINATE = "O021";
    public static final String STATICS_ID_GEOFENCE = "O020";
    public static final String STATICS_ID_LOCATE_Error = "O018";
    public static final String STATICS_ID_LOCATE_PURPOSE = "O019";
    public static final String STATICS_ID_OFFLINECOUNT = "O023";
    public static final String STATISTICS_ID_LOCBATTING_MULITY = "O016";
    public static final String STATISTICS_ID_LOCTIME_COARSE = "O024";
    public static final String STATISTICS_ID_LOCTIME_GPS = "O015";
    public static final String STATISTICS_ID_LOCTIME_NETWORK = "O014";
    public static final String STATISTICS_ID_LOCTIME_NOTGPS = "O013";
    public static final String STATISTICS_ID_SERVICE_ALIVE_TIME = "O012";
    public static final String STATISTICS_KEY_BIGONSHIFT = "bigshiftstatistics";
    public static final String STATISTICS_KEY_DEXROLLBACK = "dexrollbackstatistics";
    public static final String STATISTICS_KEY_GPSFILTER = "gpsstatistics";
    public static final String STATISTICS_KEY_USENAVILOC = "useNaviLoc";
    public static final String STATISTICS_LOCTYPE_NET = "net";
    public static final int STATISTICS_RESULT_FAIL = 0;
    public static final int STATISTICS_RESULT_SUCCESS = 1;

    /* renamed from: b, reason: collision with root package name */
    private static List<zb> f6830b = new ArrayList();

    /* renamed from: c, reason: collision with root package name */
    private static JSONArray f6831c = null;

    /* renamed from: d, reason: collision with root package name */
    static AMapLocation f6832d = null;
    static boolean e = false;
    public SparseArray<Long> sparseArray = new SparseArray<>();
    public int currentType = -1;
    public long locationStartTime = 0;

    /* renamed from: a, reason: collision with root package name */
    String[] f6833a = {Const.SP_KEY_ONCE_LOCATION, Const.SP_KEY_CONTINUE_LOCATION, Const.SP_KEY_GEOFEN_LOCATION, Const.SP_KEY_HIGHT_ACCURACY, Const.SP_KEY_BATTERY_SAVING, Const.SP_KEY_DEVICE_SENSORS};
    public int currentmode = -1;
    public long currentModeStartTime = -1;

    /* renamed from: com.autonavi.aps.amapapi.utils.ReportUtil$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f6834a;

        static {
            AMapLocationClientOption.AMapLocationMode.values();
            int[] iArr = new int[3];
            f6834a = iArr;
            try {
                iArr[0] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f6834a[1] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f6834a[2] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    private static void a(Context context, long j4, boolean z5, String str) {
        int intValue = Long.valueOf(j4).intValue();
        String str2 = !z5 ? "abroad" : "domestic";
        if (context != null) {
            try {
                if (AuthUtil.isUploadLog()) {
                    JSONObject jSONObject = new JSONObject();
                    if (!TextUtils.isEmpty(str2)) {
                        jSONObject.put("param_string_first", str2);
                    }
                    if (!TextUtils.isEmpty(null)) {
                        jSONObject.put("param_string_second", (Object) null);
                    }
                    if (intValue != Integer.MAX_VALUE) {
                        jSONObject.put("param_int_first", intValue);
                    }
                    applyStatistics(context, str, jSONObject);
                }
            } catch (Throwable th2) {
                CoreUtil.reportError(th2, "ReportUtil", "applyStatisticsEx");
            }
        }
    }

    public static synchronized void applyStatistics(Context context, String str, JSONObject jSONObject) {
        synchronized (ReportUtil.class) {
            if (context != null) {
                try {
                } finally {
                }
                if (AuthUtil.isUploadLog()) {
                    zb zbVar = new zb(context, "loc", CoreUtil.STR_CONFIG_VERSION, str);
                    if (jSONObject != null) {
                        zbVar.a(jSONObject.toString());
                    }
                    f6830b.add(zbVar);
                    if (f6830b.size() >= 30) {
                        ArrayList arrayList = new ArrayList();
                        arrayList.addAll(f6830b);
                        ac.a(arrayList, context);
                        f6830b.clear();
                    }
                }
            }
        }
    }

    public static void checkBigShift(AMapLocation aMapLocation, AMapLocation aMapLocation2) {
        try {
            if (f6832d == null) {
                if (!Utils.locCorrect(aMapLocation)) {
                    f6832d = aMapLocation2;
                    return;
                }
                f6832d = aMapLocation.m2clone();
            }
            if (Utils.locCorrect(f6832d) && Utils.locCorrect(aMapLocation2)) {
                AMapLocation m2clone = aMapLocation2.m2clone();
                if (f6832d.getLocationType() != 1 && f6832d.getLocationType() != 9 && !"gps".equalsIgnoreCase(f6832d.getProvider()) && f6832d.getLocationType() != 7 && m2clone.getLocationType() != 1 && m2clone.getLocationType() != 9 && !"gps".equalsIgnoreCase(m2clone.getProvider()) && m2clone.getLocationType() != 7) {
                    long abs = Math.abs(m2clone.getTime() - f6832d.getTime()) / 1000;
                    if (abs <= 0) {
                        abs = 1;
                    }
                    if (abs <= BIGSHIFT_VALIDTIME) {
                        float dist = Utils.dist(f6832d, m2clone);
                        float f2 = dist / abs;
                        if (dist > 30000.0f && f2 > 1000.0f) {
                            StringBuilder sb2 = new StringBuilder();
                            sb2.append(f6832d.getLatitude());
                            sb2.append(Const.STR_MART_COMMA);
                            sb2.append(f6832d.getLongitude());
                            sb2.append(Const.STR_MART_COMMA);
                            sb2.append(f6832d.getAccuracy());
                            sb2.append(Const.STR_MART_COMMA);
                            sb2.append(f6832d.getLocationType());
                            sb2.append(Const.STR_MART_COMMA);
                            if (aMapLocation.getTime() != 0) {
                                sb2.append(Utils.formatUTC(f6832d.getTime(), "yyyyMMdd_HH:mm:ss:SS"));
                            } else {
                                sb2.append(f6832d.getTime());
                            }
                            sb2.append(Const.STR_MART_WELL);
                            sb2.append(m2clone.getLatitude());
                            sb2.append(Const.STR_MART_COMMA);
                            sb2.append(m2clone.getLongitude());
                            sb2.append(Const.STR_MART_COMMA);
                            sb2.append(m2clone.getAccuracy());
                            sb2.append(Const.STR_MART_COMMA);
                            sb2.append(m2clone.getLocationType());
                            sb2.append(Const.STR_MART_COMMA);
                            if (m2clone.getTime() != 0) {
                                sb2.append(Utils.formatUTC(m2clone.getTime(), "yyyyMMdd_HH:mm:ss:SS"));
                            } else {
                                sb2.append(m2clone.getTime());
                            }
                            reportLog(STATISTICS_KEY_BIGONSHIFT, sb2.toString());
                            sb2.delete(0, sb2.length());
                        }
                    }
                }
                f6832d = m2clone;
            }
        } catch (Throwable unused) {
        }
    }

    public static boolean isDexDownloaded(Context context, m9 m9Var) {
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0033 A[Catch: all -> 0x0052, TRY_LEAVE, TryCatch #0 {all -> 0x0052, blocks: (B:4:0x0003, B:9:0x000b, B:21:0x0033, B:31:0x0046, B:33:0x004a, B:34:0x0055, B:36:0x005c, B:38:0x0069, B:40:0x007b, B:42:0x008e, B:44:0x009b, B:46:0x00a2, B:48:0x00b0, B:50:0x00bd, B:52:0x00cb, B:53:0x00df, B:55:0x00f1, B:57:0x0094), top: B:3:0x0003 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static synchronized void recordOfflineLocLog(android.content.Context r8, com.amap.api.location.AMapLocation r9) {
        /*
            Method dump skipped, instructions count: 256
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.autonavi.aps.amapapi.utils.ReportUtil.recordOfflineLocLog(android.content.Context, com.amap.api.location.AMapLocation):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:37:0x0061, code lost:
    
        if (r0 != 6) goto L33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x0036, code lost:
    
        if (com.autonavi.aps.amapapi.utils.CoreUtil.STR_API_OUTOFCN_SERVER.equals(com.autonavi.aps.amapapi.utils.CoreUtil.f6814a) != false) goto L17;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void reportBatting(android.content.Context r9, com.amap.api.location.AMapLocation r10, com.autonavi.aps.amapapi.AMapLocationStaticsEntity r11) {
        /*
            if (r10 != 0) goto L4
            goto L80
        L4:
            java.lang.String r0 = "gps"
            java.lang.String r1 = r10.getProvider()     // Catch: java.lang.Throwable -> L77
            boolean r0 = r0.equalsIgnoreCase(r1)     // Catch: java.lang.Throwable -> L77
            if (r0 != 0) goto L80
            int r0 = r10.getLocationType()     // Catch: java.lang.Throwable -> L77
            r1 = 1
            if (r0 != r1) goto L19
            goto L80
        L19:
            boolean r0 = com.autonavi.aps.amapapi.utils.Utils.locCorrect(r10)     // Catch: java.lang.Throwable -> L77
            if (r0 == 0) goto L2e
            double r2 = r10.getLatitude()     // Catch: java.lang.Throwable -> L77
            double r4 = r10.getLongitude()     // Catch: java.lang.Throwable -> L77
            boolean r0 = com.autonavi.aps.amapapi.utils.CoreUtil.isChina(r2, r4)     // Catch: java.lang.Throwable -> L77
            if (r0 == 0) goto L38
            goto L3c
        L2e:
            java.lang.String r0 = com.autonavi.aps.amapapi.utils.CoreUtil.f6814a     // Catch: java.lang.Throwable -> L77
            java.lang.String r2 = "http://abroad.apilocate.amap.com/mobile/binary"
            boolean r0 = r2.equals(r0)     // Catch: java.lang.Throwable -> L77
            if (r0 == 0) goto L3c
        L38:
            java.lang.String r0 = "abroad"
        L3a:
            r5 = r0
            goto L3f
        L3c:
            java.lang.String r0 = "domestic"
            goto L3a
        L3f:
            int r0 = r10.getErrorCode()     // Catch: java.lang.Throwable -> L77
            r2 = 6
            r3 = 5
            if (r0 == 0) goto L5b
            int r0 = r10.getErrorCode()     // Catch: java.lang.Throwable -> L77
            r1 = 11
            r4 = 0
            if (r0 == r1) goto L59
            r1 = 4
            if (r0 == r1) goto L59
            if (r0 == r3) goto L59
            if (r0 == r2) goto L59
            r1 = r4
            goto L63
        L59:
            r1 = r4
            goto L68
        L5b:
            int r0 = r10.getLocationType()     // Catch: java.lang.Throwable -> L77
            if (r0 == r3) goto L68
            if (r0 == r2) goto L68
        L63:
            java.lang.String r0 = "cache"
        L65:
            r4 = r0
            r6 = r1
            goto L6b
        L68:
            java.lang.String r0 = "net"
            goto L65
        L6b:
            java.lang.String r3 = "O016"
            int r7 = r10.getErrorCode()     // Catch: java.lang.Throwable -> L77
            r2 = r9
            r8 = r11
            a(r2, r3, r4, r5, r6, r7, r8)     // Catch: java.lang.Throwable -> L77
            return
        L77:
            r0 = move-exception
            r9 = r0
            java.lang.String r10 = "ReportUtil"
            java.lang.String r11 = "reportBatting"
            com.autonavi.aps.amapapi.utils.CoreUtil.reportError(r9, r10, r11)
        L80:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.autonavi.aps.amapapi.utils.ReportUtil.reportBatting(android.content.Context, com.amap.api.location.AMapLocation, com.autonavi.aps.amapapi.AMapLocationStaticsEntity):void");
    }

    public static void reportCheckGPSTime(long j4, long j10) {
        try {
            if (e) {
                return;
            }
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("gpsTime:");
            stringBuffer.append(Utils.formatUTC(j4, "yyyy-MM-dd HH:mm:ss.SSS"));
            stringBuffer.append(",sysTime:");
            stringBuffer.append(Utils.formatUTC(j10, "yyyy-MM-dd HH:mm:ss.SSS"));
            stringBuffer.append(",serverTime:");
            long serTime = AuthUtil.getSerTime();
            stringBuffer.append(0 != serTime ? Utils.formatUTC(serTime, "yyyy-MM-dd HH:mm:ss.SSS") : "0");
            reportLog("checkgpstime", stringBuffer.toString());
            if (0 != serTime && Math.abs(j4 - serTime) < Const.YEAR_IN_MILLIS) {
                stringBuffer.append(", correctError");
                reportLog("checkgpstimeerror", stringBuffer.toString());
            }
            stringBuffer.delete(0, stringBuffer.length());
            e = true;
        } catch (Throwable unused) {
        }
    }

    public static void reportCoarseLocUseTime(Context context, long j4, boolean z5) {
        if (context != null) {
            try {
                if (AuthUtil.isUploadLog()) {
                    a(context, j4, z5, STATISTICS_ID_LOCTIME_COARSE);
                }
            } catch (Throwable th2) {
                CoreUtil.reportError(th2, "ReportUtil", "reportCoarseLocUseTime");
            }
        }
    }

    public static void reportGPSLocUseTime(Context context, long j4, boolean z5) {
        if (context != null) {
            try {
                if (AuthUtil.isUploadLog()) {
                    a(context, j4, z5, STATISTICS_ID_LOCTIME_GPS);
                }
            } catch (Throwable th2) {
                CoreUtil.reportError(th2, "ReportUtil", "reportGPSLocUseTime");
            }
        }
    }

    public static void reportLocError(String str, int i3) {
        String str2;
        String valueOf = String.valueOf(i3);
        if (i3 == 2011) {
            str2 = "ContextIsNull";
        } else if (i3 == 2031) {
            str2 = "CreateApsReqException";
        } else if (i3 == 2041) {
            str2 = "ResponseResultIsNull";
        } else if (i3 == 2081) {
            str2 = "LocalLocException";
        } else if (i3 == 2091) {
            str2 = "InitException";
        } else if (i3 == 2111) {
            str2 = "ErrorCgiInfo";
        } else if (i3 == 2121) {
            str2 = "NotLocPermission";
        } else if (i3 == 2141) {
            str2 = "NoEnoughStatellites";
        } else if (i3 == 2021) {
            str2 = "OnlyMainWifi";
        } else if (i3 == 2022) {
            str2 = "OnlyOneWifiButNotMain";
        } else if (i3 == 2061) {
            str2 = "ServerRetypeError";
        } else if (i3 == 2062) {
            str2 = "ServerLocFail";
        } else if (i3 == 2156) {
            str2 = "EXCEPTION_FUSION_LOC_FAIL";
        } else if (i3 != 2157) {
            switch (i3) {
                case 2051:
                    str2 = "NeedLoginNetWork\t";
                    break;
                case 2052:
                    str2 = "MaybeIntercepted";
                    break;
                case 2053:
                    str2 = "DecryptResponseException";
                    break;
                case 2054:
                    str2 = "ParserDataException";
                    break;
                default:
                    switch (i3) {
                        case 2101:
                            str2 = "BindAPSServiceException";
                            break;
                        case EXCEPTION_CODE_SERVERAUTHCLIENSCODE /* 2102 */:
                            str2 = "AuthClientScodeFail";
                            break;
                        case EXCEPTION_CODE_NOTAPSSERVICE /* 2103 */:
                            str2 = "NotConfigAPSService";
                            break;
                        default:
                            switch (i3) {
                                case EXCEPTION_CODE_NOCGIANDWIFI /* 2131 */:
                                    str2 = "NoCgiOAndWifiInfo";
                                    break;
                                case EXCEPTION_AIRPLANEMODE_WIFIOFF /* 2132 */:
                                    str2 = "AirPlaneModeAndWifiOff";
                                    break;
                                case EXCEPTION_NOCGI_WIFIOFF /* 2133 */:
                                    str2 = "NoCgiAndWifiOff";
                                    break;
                                default:
                                    switch (i3) {
                                        case EXCEPTION_CODE_MOCKNETLOC /* 2151 */:
                                            str2 = "MaybeMockNetLoc";
                                            break;
                                        case EXCEPTION_CODE_MOCKGPSLOC /* 2152 */:
                                            str2 = "MaybeMockGPSLoc";
                                            break;
                                        case EXCEPTION_CODE_UNSUPPORTCOARSELBSLOC /* 2153 */:
                                            str2 = "UNSUPPORT_COARSE_LBSLOC";
                                            break;
                                        case EXCEPTION_CODE_UNSUPPORTCONTINUELOC /* 2154 */:
                                            str2 = "UNSUPPORT_CONTINUE_LOC";
                                            break;
                                        default:
                                            str2 = "";
                                            break;
                                    }
                            }
                    }
            }
        } else {
            str2 = "EXCEPTION_NET_LOC_FAIL";
        }
        reportLocError(str, valueOf, str2);
    }

    public static void reportLog(String str, String str2) {
        try {
            ka.a(CoreUtil.getSDKInfo(), str2, str);
        } catch (Throwable th2) {
            CoreUtil.reportError(th2, "ReportUtil", "reportLog");
        }
    }

    public static void reportNetWorkError(String str, Throwable th2) {
        try {
            if (th2 instanceof a9) {
                m9 sDKInfo = CoreUtil.getSDKInfo();
                a9 a9Var = (a9) th2;
                int i3 = ka.f4429i;
                if (a9Var != null) {
                    ka.a(sDKInfo, str, a9Var.g(), a9Var.e(), a9Var.b(), a9Var.f());
                }
            }
        } catch (Throwable unused) {
        }
    }

    public static void reportServiceAliveTime(Context context, int i3, int i10, long j4, long j10) {
        if (i3 == -1 || i10 == -1 || context == null) {
            return;
        }
        try {
            if (AuthUtil.isUploadLog()) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("param_int_first", i3);
                jSONObject.put("param_int_second", i10);
                jSONObject.put("param_long_first", j4);
                jSONObject.put("param_long_second", j10);
                applyStatistics(context, STATISTICS_ID_SERVICE_ALIVE_TIME, jSONObject);
            }
        } catch (Throwable th2) {
            try {
                CoreUtil.reportError(th2, "ReportUtil", "applyStatisticsEx");
            } catch (Throwable th3) {
                CoreUtil.reportError(th3, "ReportUtil", "reportServiceAliveTime");
            }
        }
    }

    public static synchronized void saveStatistics(Context context) {
        synchronized (ReportUtil.class) {
            if (context != null) {
                try {
                } finally {
                }
                if (AuthUtil.isUploadLog()) {
                    List<zb> list = f6830b;
                    if (list != null && list.size() > 0) {
                        ArrayList arrayList = new ArrayList();
                        arrayList.addAll(f6830b);
                        ac.a(arrayList, context);
                        f6830b.clear();
                    }
                    a(context);
                }
            }
        }
    }

    public void clearLocationModeAndType(Context context) {
        try {
            SharedPreferences.Editor startEdit = SPUtil.startEdit(context, Const.STR_PREF1);
            int i3 = 0;
            while (true) {
                String[] strArr = this.f6833a;
                if (i3 >= strArr.length) {
                    SPUtil.endEdit(startEdit);
                    return;
                } else {
                    SPUtil.setPrefsLong(startEdit, strArr[i3], 0L);
                    i3++;
                }
            }
        } catch (Throwable unused) {
        }
    }

    public int getLocationMode(Context context) {
        try {
            long prefsLong = SPUtil.getPrefsLong(context, Const.STR_PREF1, this.f6833a[3], 0L);
            long prefsLong2 = SPUtil.getPrefsLong(context, Const.STR_PREF1, this.f6833a[4], 0L);
            long prefsLong3 = SPUtil.getPrefsLong(context, Const.STR_PREF1, this.f6833a[5], 0L);
            if (prefsLong == 0 && prefsLong2 == 0 && prefsLong3 == 0) {
                return -1;
            }
            return prefsLong > prefsLong2 ? prefsLong > prefsLong3 ? 3 : 5 : prefsLong2 > prefsLong3 ? 4 : 5;
        } catch (Throwable unused) {
            return -1;
        }
    }

    public int getLocationType(Context context) {
        try {
            long prefsLong = SPUtil.getPrefsLong(context, Const.STR_PREF1, this.f6833a[2], 0L);
            long prefsLong2 = SPUtil.getPrefsLong(context, Const.STR_PREF1, this.f6833a[0], 0L);
            long prefsLong3 = SPUtil.getPrefsLong(context, Const.STR_PREF1, this.f6833a[1], 0L);
            if (prefsLong == 0 && prefsLong2 == 0 && prefsLong3 == 0) {
                return -1;
            }
            long j4 = prefsLong2 - prefsLong;
            long j10 = prefsLong3 - prefsLong;
            return prefsLong > j4 ? prefsLong > j10 ? 2 : 1 : j4 > j10 ? 0 : 1;
        } catch (Throwable unused) {
            return -1;
        }
    }

    public void saveLocationTypeAndMode(Context context) {
        try {
            long timeBoot = Utils.getTimeBoot() - this.locationStartTime;
            int i3 = this.currentType;
            if (i3 != -1) {
                this.sparseArray.append(this.currentType, Long.valueOf(timeBoot + this.sparseArray.get(i3, 0L).longValue()));
            }
            long timeBoot2 = Utils.getTimeBoot() - this.currentModeStartTime;
            int i10 = this.currentmode;
            if (i10 != -1) {
                this.sparseArray.append(this.currentmode, Long.valueOf(timeBoot2 + this.sparseArray.get(i10, 0L).longValue()));
            }
            SharedPreferences.Editor startEdit = SPUtil.startEdit(context, Const.STR_PREF1);
            for (int i11 = 0; i11 < this.f6833a.length; i11++) {
                long longValue = this.sparseArray.get(i11, 0L).longValue();
                if (longValue > 0 && longValue > SPUtil.getPrefsLong(context, Const.STR_PREF1, this.f6833a[i11], 0L)) {
                    SPUtil.setPrefsLong(startEdit, this.f6833a[i11], longValue);
                }
            }
            SPUtil.endEdit(startEdit);
        } catch (Throwable th2) {
            CoreUtil.reportError(th2, "ReportUtil", "saveLocationTypeAndMode");
        }
    }

    public void setLocationMode(Context context, AMapLocationClientOption aMapLocationClientOption) {
        try {
            int ordinal = aMapLocationClientOption.getLocationMode().ordinal();
            int i3 = ordinal != 0 ? ordinal != 1 ? ordinal != 2 ? -1 : 3 : 5 : 4;
            int i10 = this.currentmode;
            if (i10 == i3) {
                return;
            }
            if (i10 != -1 && i10 != i3) {
                this.sparseArray.append(this.currentmode, Long.valueOf((Utils.getTimeBoot() - this.currentModeStartTime) + this.sparseArray.get(this.currentmode, 0L).longValue()));
            }
            this.currentModeStartTime = Utils.getTimeBoot() - SPUtil.getPrefsLong(context, Const.STR_PREF1, this.f6833a[i3], 0L);
            this.currentmode = i3;
        } catch (Throwable th2) {
            CoreUtil.reportError(th2, "ReportUtil", "setLocationMode");
        }
    }

    public void setLocationType(Context context, int i3) {
        try {
            int i10 = this.currentType;
            if (i10 == i3) {
                return;
            }
            if (i10 != -1 && i10 != i3) {
                this.sparseArray.append(this.currentType, Long.valueOf((Utils.getTimeBoot() - this.locationStartTime) + this.sparseArray.get(this.currentType, 0L).longValue()));
            }
            this.locationStartTime = Utils.getTimeBoot() - SPUtil.getPrefsLong(context, Const.STR_PREF1, this.f6833a[i3], 0L);
            this.currentType = i3;
        } catch (Throwable th2) {
            CoreUtil.reportError(th2, "ReportUtil", "setLocationType");
        }
    }

    public static void reportLocError(String str, String str2, String str3) {
        try {
            ka.a(CoreUtil.getSDKInfo(), PATH_LOC, str3, str, "", str2);
        } catch (Throwable unused) {
        }
    }

    private static void a(Context context, String str, String str2, String str3, int i3, int i10, AMapLocationStaticsEntity aMapLocationStaticsEntity) {
        if (context != null) {
            try {
                if (AuthUtil.isUploadLog()) {
                    JSONObject jSONObject = new JSONObject();
                    if (!TextUtils.isEmpty(str2)) {
                        jSONObject.put("param_string_first", str2);
                    }
                    if (!TextUtils.isEmpty(str3)) {
                        jSONObject.put("param_string_second", str3);
                    }
                    if (i3 != Integer.MAX_VALUE) {
                        jSONObject.put("param_int_first", i3);
                    }
                    if (i10 != Integer.MAX_VALUE) {
                        jSONObject.put("param_int_second", i10);
                    }
                    if (aMapLocationStaticsEntity != null) {
                        if (!TextUtils.isEmpty(aMapLocationStaticsEntity.getDNSStaus())) {
                            jSONObject.put("dns", aMapLocationStaticsEntity.getDNSStaus());
                        }
                        if (!TextUtils.isEmpty(aMapLocationStaticsEntity.getDominStatus())) {
                            jSONObject.put("domain", aMapLocationStaticsEntity.getDominStatus());
                        }
                        if (!TextUtils.isEmpty(aMapLocationStaticsEntity.getLocationType())) {
                            jSONObject.put("type", aMapLocationStaticsEntity.getLocationType());
                        }
                        if (!TextUtils.isEmpty(aMapLocationStaticsEntity.getReason())) {
                            jSONObject.put("reason", aMapLocationStaticsEntity.getReason());
                        }
                        if (!TextUtils.isEmpty(aMapLocationStaticsEntity.getIP())) {
                            jSONObject.put("ip", aMapLocationStaticsEntity.getIP());
                        }
                        if (!TextUtils.isEmpty(aMapLocationStaticsEntity.getStackType())) {
                            jSONObject.put("stack", aMapLocationStaticsEntity.getStackType());
                        }
                        if (aMapLocationStaticsEntity.getContinueTime() > 0) {
                            jSONObject.put("ctime", String.valueOf(aMapLocationStaticsEntity.getContinueTime()));
                        }
                        if (aMapLocationStaticsEntity.getNetUseTime() > 0) {
                            jSONObject.put("ntime", String.valueOf(aMapLocationStaticsEntity.getNetUseTime()));
                        }
                    }
                    applyStatistics(context, str, jSONObject);
                }
            } catch (Throwable th2) {
                CoreUtil.reportError(th2, "ReportUtil", "applyStatisticsEx");
            }
        }
    }

    private static void a(Context context) {
        try {
            JSONArray jSONArray = f6831c;
            if (jSONArray == null || jSONArray.length() <= 0) {
                return;
            }
            yb.a(new xb(context, CoreUtil.getSDKInfo(), f6831c.toString()), context);
            f6831c = null;
        } catch (Throwable th2) {
            CoreUtil.reportError(th2, "ReportUtil", "writeOfflineLocLog");
        }
    }
}
