package com.autonavi.aps.amapapi.utils;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.ServiceInfo;
import android.location.Location;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.SystemClock;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Base64;
import com.amap.api.col.p0003sl.b9;
import com.amap.api.col.p0003sl.f9;
import com.amap.api.col.p0003sl.h9;
import com.amap.api.col.p0003sl.n9;
import com.amap.api.location.AMapLocation;
import com.amap.api.location.DPoint;
import com.amap.api.services.core.AMapException;
import com.autonavi.aps.amapapi.Aps;
import com.autonavi.aps.amapapi.config.Const;
import com.autonavi.aps.amapapi.model.AMapLocationServer;
import com.autonavi.aps.amapapi.security.Encrypt;
import com.tencent.connect.common.Constants;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;
import java.util.Random;
import java.util.zip.GZIPInputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class Utils {

    /* renamed from: a, reason: collision with root package name */
    private static String[] f6837a;

    /* renamed from: b, reason: collision with root package name */
    static WifiManager f6838b;

    /* renamed from: c, reason: collision with root package name */
    private static String f6839c;

    private Utils() {
    }

    private static boolean a(Context context, String str) throws Throwable {
        return ((Integer) Reflect.invokeStaticMethod(str, "getInt", new Object[]{context.getContentResolver(), ((String) Reflect.getStaticProp(str, "AIRPLANE_MODE_ON")).toString()}, (Class<?>[]) new Class[]{ContentResolver.class, String.class})).intValue() == 1;
    }

    public static boolean airPlaneModeOn(Context context) {
        if (context == null) {
            return false;
        }
        try {
            return getSdk() < 17 ? a(context, "android.provider.Settings$System") : a(context, "android.provider.Settings$Global");
        } catch (Throwable unused) {
            return false;
        }
    }

    public static int amapErrorCode2OpenErrorCode(String str, int i3) {
        if (TextUtils.equals(str, Const.OPEN_ERROR_CAUSE)) {
            return i3;
        }
        if (TextUtils.equals(str, Const.NETLOC_FAIL_CAUSE)) {
            switch (i3) {
                case -13:
                    return 12;
                case -12:
                    return 20;
                case -11:
                    return 18;
                default:
                    switch (i3) {
                        case 0:
                            return 8;
                        case 1:
                            return 2;
                        case 2:
                        case 3:
                        case 4:
                        case 5:
                        case 6:
                        case 8:
                            return 4;
                        case 7:
                            return 6;
                        default:
                            return 0;
                    }
            }
        }
        if (!TextUtils.equals(str, Const.SIGNAL_WEAK_CAUSE)) {
            return 0;
        }
        if (i3 == 40 || i3 == 41 || i3 == -3) {
            return 14;
        }
        if (i3 == -2 || i3 == -1) {
            return 12;
        }
        if (i3 == 0 || i3 == 1) {
            return 14;
        }
        switch (i3) {
            case 11:
            case 12:
            case 13:
            case 14:
                return 14;
            default:
                switch (i3) {
                    case 20:
                    case 21:
                    case 22:
                    case 23:
                    case 24:
                        return 14;
                    default:
                        switch (i3) {
                            case 30:
                                return 8;
                            case 31:
                            case 32:
                            case 33:
                            case 34:
                                return 14;
                            default:
                                return 0;
                        }
                }
        }
    }

    public static int asu2Dbm(int i3) {
        return (i3 * 2) + Const.I_DEF_CGI_SIG;
    }

    private static boolean b(Context context) {
        try {
            int i3 = Build.VERSION.SDK_INT;
            int i10 = context.getApplicationInfo().targetSdkVersion;
            return ((i3 == 30) && (i10 >= 23)) || ((i3 == 31) && (i10 <= 30 && i10 >= 23));
        } catch (Throwable unused) {
            DebugUtils.writeCat("tv e", false);
            return false;
        }
    }

    public static int ba2IntB(byte[] bArr) {
        int i3 = 0;
        for (int i10 = 0; i10 < bArr.length; i10++) {
            i3 |= (bArr[i10] & 255) << (((bArr.length - 1) - i10) * 8);
        }
        return i3;
    }

    public static int ba2IntL(byte[] bArr) {
        int i3 = 0;
        for (int i10 = 0; i10 < bArr.length; i10++) {
            i3 |= (bArr[i10] & 255) << (i10 * 8);
        }
        return i3;
    }

    public static String ba2hex(byte[] bArr) {
        return n9.b(bArr);
    }

    public static String base642Str(String str) {
        if (str == null || str.length() == 0) {
            return "";
        }
        try {
            return new String(Base64.decode(str, 0), "UTF-8");
        } catch (Throwable th2) {
            CoreUtil.reportError(th2, "Utils", "base642Str");
            return null;
        }
    }

    public static byte[] byteReverse(byte[] bArr) {
        byte[] bArr2 = new byte[bArr.length + 1];
        bArr2[0] = 0;
        for (int i3 = 1; i3 <= bArr.length; i3++) {
            bArr2[i3] = bArr[bArr.length - i3];
        }
        return bArr2;
    }

    public static final int bytesToInt(byte[] bArr) {
        int i3 = 0;
        for (int i10 = 0; i10 < 4; i10++) {
            i3 = (i3 << 8) | (bArr[i10] & 255);
        }
        return i3;
    }

    public static final long bytesToLong(byte[] bArr) {
        long j4 = 0;
        for (int i3 = 0; i3 < 8; i3++) {
            j4 = (j4 << 8) | (bArr[i3] & 255);
        }
        return j4;
    }

    public static final int bytesToUnsignedShort(byte[] bArr) {
        return (bArr[1] & 255) | ((bArr[0] & 255) << 8);
    }

    public static boolean checkBackGroundLocPerm(Context context) {
        int i3;
        if (context.getApplicationInfo().targetSdkVersion >= 29 && Build.VERSION.SDK_INT >= 29) {
            try {
                i3 = Reflect.invokeIntMethod(((Application) context).getBaseContext(), "checkSelfPermission", Aps.locBackGroundPermissions);
            } catch (Throwable unused) {
                i3 = 0;
            }
            if (i3 != 0) {
                return false;
            }
        }
        return true;
    }

    public static boolean checkDirExists(String str, String str2) {
        File file = new File(str);
        if (file.exists() && file.isDirectory()) {
            for (File file2 : file.listFiles()) {
                if (file2.isDirectory() && file2.getName().equals(str2)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean checkInstallByPkg(Context context, String str) {
        PackageInfo packageInfo;
        try {
            packageInfo = context.getApplicationContext().getPackageManager().getPackageInfo(str, 256);
        } catch (Throwable unused) {
            packageInfo = null;
        }
        return packageInfo != null;
    }

    public static boolean checkLoc(AMapLocation aMapLocation) {
        double longitude = aMapLocation.getLongitude();
        double latitude = aMapLocation.getLatitude();
        return !(longitude == 0.0d && latitude == 0.0d) && longitude <= 180.0d && latitude <= 90.0d && longitude >= -180.0d && latitude >= -90.0d;
    }

    public static boolean checkLocPerm(Context context) {
        int i3;
        if (context.getApplicationInfo().targetSdkVersion >= 23) {
            Application application = (Application) context;
            for (String str : Aps.locPermissions) {
                try {
                    i3 = Reflect.invokeIntMethod(application.getBaseContext(), "checkSelfPermission", str);
                } catch (Throwable unused) {
                    i3 = 0;
                }
                if (i3 != 0) {
                    return false;
                }
            }
        } else {
            for (String str2 : Aps.locPermissions) {
                if (context.checkCallingOrSelfPermission(str2) != 0) {
                    return false;
                }
            }
        }
        return true;
    }

    public static byte[] copyOf(byte[] bArr, int i3, int i10) {
        byte[] bArr2 = new byte[i10 - i3];
        System.arraycopy(bArr, i3, bArr2, 0, Math.min(i10, bArr.length) - i3);
        return bArr2;
    }

    public static void delDir(String str) {
        try {
            String str2 = File.separator;
            if (!str.endsWith(str2)) {
                str = str + str2;
            }
            File file = new File(str);
            if (file.exists() && file.isDirectory()) {
                for (File file2 : file.listFiles()) {
                    if (file2.isDirectory()) {
                        delDir(file2.getAbsolutePath());
                    } else {
                        file2.delete();
                    }
                }
                file.delete();
            }
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public static float dist(double[] dArr) {
        if (dArr.length != 4) {
            return 0.0f;
        }
        float[] fArr = new float[1];
        Location.distanceBetween(dArr[0], dArr[1], dArr[2], dArr[3], fArr);
        return fArr[0];
    }

    public static String encodeLicense() {
        try {
            return h9.c(CoreUtil.AMAP_LICENSE.getBytes("UTF-8")).substring(20);
        } catch (Throwable unused) {
            return "";
        }
    }

    public static boolean extMemAvl() {
        return "mounted".equals(Environment.getExternalStorageState());
    }

    public static double fmatCoordinates(double d5) {
        return formatDoubleKeep6Point(d5);
    }

    public static double formatDoubleKeep2Point(double d5) {
        return ((long) (d5 * 100.0d)) / 100.0d;
    }

    public static double formatDoubleKeep6Point(double d5) {
        return ((long) (d5 * 1000000.0d)) / 1000000.0d;
    }

    public static float formatFloatKeep2Point(float f2) {
        return (float) (((long) (f2 * 100.0d)) / 100.0d);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002a A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:14:0x002d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.String formatUTC(long r3, java.lang.String r5) {
        /*
            boolean r0 = android.text.TextUtils.isEmpty(r5)
            if (r0 == 0) goto L8
            java.lang.String r5 = "yyyy-MM-dd HH:mm:ss"
        L8:
            java.text.SimpleDateFormat r0 = new java.text.SimpleDateFormat     // Catch: java.lang.Throwable -> L15
            java.util.Locale r1 = java.util.Locale.CHINA     // Catch: java.lang.Throwable -> L15
            r0.<init>(r5, r1)     // Catch: java.lang.Throwable -> L15
            r0.applyPattern(r5)     // Catch: java.lang.Throwable -> L13
            goto L1e
        L13:
            r5 = move-exception
            goto L17
        L15:
            r5 = move-exception
            r0 = 0
        L17:
            java.lang.String r1 = "Utils"
            java.lang.String r2 = "formatUTC"
            com.autonavi.aps.amapapi.utils.CoreUtil.reportError(r5, r1, r2)
        L1e:
            r1 = 0
            int r5 = (r3 > r1 ? 1 : (r3 == r1 ? 0 : -1))
            if (r5 > 0) goto L28
            long r3 = getTime()
        L28:
            if (r0 != 0) goto L2d
            java.lang.String r3 = "NULL"
            goto L35
        L2d:
            java.lang.Long r3 = java.lang.Long.valueOf(r3)
            java.lang.String r3 = r0.format(r3)
        L35:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.autonavi.aps.amapapi.utils.Utils.formatUTC(long, java.lang.String):java.lang.String");
    }

    public static byte[] get2BaFromInt(int i3, byte[] bArr) {
        if (bArr == null || bArr.length < 2) {
            bArr = new byte[2];
        }
        bArr[0] = (byte) (i3 & 255);
        bArr[1] = (byte) ((i3 & 65280) >> 8);
        return bArr;
    }

    public static byte[] get2BaFromStr(String str, byte[] bArr) {
        return get2BaFromInt(parseInt(str), bArr);
    }

    public static byte[] get4BaFromInt(int i3, byte[] bArr) {
        if (bArr == null || bArr.length < 4) {
            bArr = new byte[4];
        }
        for (int i10 = 0; i10 < bArr.length; i10++) {
            bArr[i10] = (byte) ((i3 >> (i10 * 8)) & 255);
        }
        return bArr;
    }

    public static byte[] get4BaFromStr(String str, byte[] bArr) {
        return get4BaFromInt(parseInt(str), bArr);
    }

    public static byte[] get6BaFromMac(String str) {
        byte[] bArr = new byte[6];
        String[] split = str.split(":");
        for (int i3 = 0; i3 < split.length; i3++) {
            bArr[i3] = (byte) parseInt(split[i3], 16);
        }
        return bArr;
    }

    public static byte[] get8BaFromLong(long j4) {
        byte[] bArr = new byte[8];
        for (int i3 = 0; i3 < 8; i3++) {
            bArr[i3] = (byte) ((j4 >> (i3 * 8)) & 255);
        }
        return bArr;
    }

    public static String getAppName(Context context) {
        PackageInfo packageInfo;
        if (!TextUtils.isEmpty(CoreUtil.strAppname)) {
            return CoreUtil.strAppname;
        }
        if (context == null) {
            return null;
        }
        try {
            packageInfo = context.getPackageManager().getPackageInfo(b9.f(context), 64);
        } catch (Throwable th2) {
            CoreUtil.reportError(th2, "Utils", "getAppName part");
            packageInfo = null;
        }
        try {
            if (TextUtils.isEmpty(CoreUtil.strAppSha1)) {
                CoreUtil.strAppSha1 = null;
            }
        } catch (Throwable th3) {
            CoreUtil.reportError(th3, "Utils", "getAppName");
        }
        StringBuilder sb2 = new StringBuilder();
        if (packageInfo != null) {
            ApplicationInfo applicationInfo = packageInfo.applicationInfo;
            CharSequence loadLabel = applicationInfo != null ? applicationInfo.loadLabel(context.getPackageManager()) : null;
            if (loadLabel != null) {
                sb2.append(loadLabel.toString());
            }
            if (!TextUtils.isEmpty(packageInfo.versionName)) {
                sb2.append(packageInfo.versionName);
            }
        }
        String f2 = b9.f(context);
        if (!TextUtils.isEmpty(f2)) {
            sb2.append(Const.STR_MART_COMMA);
            sb2.append(f2);
        }
        if (!TextUtils.isEmpty(CoreUtil.strAppSha1)) {
            sb2.append(Const.STR_MART_COMMA);
            sb2.append(CoreUtil.strAppSha1);
        }
        String sb3 = sb2.toString();
        CoreUtil.strAppname = sb3;
        return sb3;
    }

    public static String getDeviceMac(Context context) {
        String c9 = f9.c();
        if (TextUtils.isEmpty(c9) || c9.equals(Const.STR_DEF_SMAC)) {
            c9 = SPUtil.getSmac(context);
        }
        return TextUtils.isEmpty(c9) ? Const.STR_DEF_SMAC : c9;
    }

    public static boolean getHUAWEICoarseSwitch(Context context) {
        if (context != null) {
            try {
                try {
                    if (context.checkSelfPermission(Const.HUAWEI_APPROXIMATELY_PERMISSION) == 0) {
                        return true;
                    }
                } catch (Throwable unused) {
                }
            } catch (Throwable unused2) {
                DebugUtils.writeCat("hwcs e", false);
            }
        }
        return false;
    }

    public static String getLocDetail(int i3) {
        if (i3 == 0) {
            return "success";
        }
        if (i3 == 2) {
            return "当前基站为伪基站,并且没有搜索到WIFI，请移动到WIFI比较丰富的区域#0204";
        }
        if (i3 == 33) {
            return "补偿定位失败，未命中缓存";
        }
        switch (i3) {
            case 10:
                return "请检查配置文件是否配置服务，并且manifest中service标签是否配置在application标签内#1003";
            case 11:
                return "get cgi failure#1101";
            case 12:
                return "定位服务没有开启，请在设置中打开定位服务开关#1206";
            case 13:
                return "网络定位失败，请检查设备是否插入sim卡，是否开启移动网络或开启了wifi模块";
            case 14:
                return "GPS 定位失败，由于设备当前 GPS 状态差,建议持设备到相对开阔的露天场所再次尝试";
            case 15:
                return "networkLocation has been mocked!#1502";
            default:
                switch (i3) {
                    case 18:
                        return "飞行模式下关闭了WIFI开关，请关闭飞行模式或者打开WIFI开关#1801";
                    case 19:
                        return "没有检查到SIM卡，并且WIFI开关关闭，请打开WIFI开关或者插入SIM卡#1901";
                    case 20:
                        return "系统定位当前不可用#2003";
                    default:
                        return "";
                }
        }
    }

    public static String getLocErrorInfo(int i3) {
        if (i3 == 33) {
            return "补偿定位失败，未命中缓存";
        }
        switch (i3) {
            case 0:
                break;
            case 1:
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
            case 5:
                break;
            case 6:
                break;
            case 7:
                break;
            case 8:
                break;
            case 9:
                break;
            case 10:
                break;
            case 11:
                break;
            case 12:
                break;
            case 13:
                break;
            case 14:
                break;
            case 15:
                break;
            default:
                switch (i3) {
                }
        }
        return "其他错误";
    }

    public static String[] getMccMnc(TelephonyManager telephonyManager) {
        int i3;
        String[] strArr;
        String networkOperator = telephonyManager != null ? telephonyManager.getNetworkOperator() : null;
        String[] strArr2 = {"0", "0"};
        if (!TextUtils.isEmpty(networkOperator) && TextUtils.isDigitsOnly(networkOperator) && networkOperator.length() > 4) {
            strArr2[0] = networkOperator.substring(0, 3);
            char[] charArray = networkOperator.substring(3).toCharArray();
            int i10 = 0;
            while (i10 < charArray.length && Character.isDigit(charArray[i10])) {
                i10++;
            }
            strArr2[1] = networkOperator.substring(3, i10 + 3);
        }
        try {
            i3 = Integer.parseInt(strArr2[0]);
        } catch (Throwable th2) {
            CoreUtil.reportError(th2, "Utils", "getMccMnc");
            i3 = 0;
        }
        if (i3 == 0) {
            strArr2[0] = "0";
        }
        if ("0".equals(strArr2[0]) || "0".equals(strArr2[1])) {
            return ("0".equals(strArr2[0]) && "0".equals(strArr2[1]) && (strArr = f6837a) != null) ? strArr : strArr2;
        }
        f6837a = strArr2;
        return strArr2;
    }

    public static String getNetMode(Context context, ConnectivityManager connectivityManager) {
        int i3 = 0;
        if (connectivityManager != null) {
            try {
                NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
                if (activeNetworkInfo != null) {
                    i3 = activeNetworkInfo.getSubtype();
                }
            } catch (Throwable unused) {
            }
        }
        switch (i3) {
            case 1:
                return "GPRS";
            case 2:
                return "EDGE";
            case 3:
                return "UMTS";
            case 4:
                return "CDMA";
            case 5:
                return "EVDO_0";
            case 6:
                return "EVDO_A";
            case 7:
                return "1xRTT";
            case 8:
                return "HSDPA";
            case 9:
                return "HSUPA";
            case 10:
                return "HSPA";
            case 11:
                return "IDEN";
            case 12:
                return "EVDO_B";
            case 13:
                return "LTE";
            case 14:
                return "EHRPD";
            case 15:
                return "HSPAP";
            default:
                return "UNKWN";
        }
    }

    public static int getNetT(NetworkInfo networkInfo) {
        if (networkInfo != null && networkInfo.isAvailable() && networkInfo.isConnected()) {
            return networkInfo.getType();
        }
        return -1;
    }

    public static NetworkInfo getNetWorkInfo(Context context) {
        try {
            return f9.n(context);
        } catch (Throwable th2) {
            CoreUtil.reportError(th2, "Utils", "getNetWorkInfo");
            return null;
        }
    }

    public static String getNetWorkTypeStr(Context context) {
        NetworkInfo netWorkInfo = getNetWorkInfo(context);
        if (netWorkInfo == null || !netWorkInfo.isConnectedOrConnecting()) {
            return "DISCONNECTED";
        }
        int type = netWorkInfo.getType();
        if (type == 1) {
            return "WIFI";
        }
        if (type != 0) {
            return Constants.APP_VERSION_UNKNOWN;
        }
        String subtypeName = netWorkInfo.getSubtypeName();
        switch (netWorkInfo.getSubtype()) {
            case 1:
            case 2:
            case 4:
            case 7:
            case 11:
            case 16:
                return "2G";
            case 3:
            case 5:
            case 6:
            case 8:
            case 9:
            case 10:
            case 12:
            case 14:
            case 15:
            case 17:
                return "3G";
            case 13:
                return "4G";
            default:
                return "GSM".equalsIgnoreCase(subtypeName) ? "2G" : ("TD-SCDMA".equalsIgnoreCase(subtypeName) || "WCDMA".equalsIgnoreCase(subtypeName) || "CDMA2000".equalsIgnoreCase(subtypeName)) ? "3G" : subtypeName;
        }
    }

    public static String getPackageNameMD5(Context context) {
        if (f6839c == null) {
            f6839c = Encrypt.encode("MD5", b9.f(context));
        }
        return f6839c;
    }

    public static int getSdk() {
        try {
            try {
                return Reflect.getStaticIntProp("android.os.Build$VERSION", "SDK_INT");
            } catch (Throwable unused) {
                return 0;
            }
        } catch (Throwable unused2) {
            return Integer.parseInt(Reflect.getStaticProp("android.os.Build$VERSION", "SDK").toString());
        }
    }

    public static Object getServ(Context context, String str) {
        if (context == null) {
            return null;
        }
        try {
            return context.getApplicationContext().getSystemService(str);
        } catch (Throwable th2) {
            CoreUtil.reportError(th2, "Utils", "getServ");
            return null;
        }
    }

    public static long getTime() {
        return System.currentTimeMillis();
    }

    public static long getTimeBoot() {
        return SystemClock.elapsedRealtime();
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x0047, code lost:
    
        if (r8 == null) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0049, code lost:
    
        r8.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0050, code lost:
    
        return r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x004d, code lost:
    
        if (r8 != null) goto L21;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static boolean getVIVOCoarseSwitch(android.content.Context r8) {
        /*
            r0 = 0
            java.lang.String r1 = r8.getPackageName()     // Catch: java.lang.Throwable -> L40
            android.content.ContentResolver r2 = r8.getContentResolver()     // Catch: java.lang.Throwable -> L40
            java.lang.String r8 = "content://com.vivo.permissionmanager.provider.permission/fuzzy_location_apps"
            android.net.Uri r3 = android.net.Uri.parse(r8)     // Catch: java.lang.Throwable -> L40
            java.lang.String r8 = "package_name"
            java.lang.String r4 = "selected_fuzzy"
            java.lang.String[] r4 = new java.lang.String[]{r8, r4}     // Catch: java.lang.Throwable -> L40
            java.lang.String r5 = "package_name=?"
            java.lang.String[] r6 = new java.lang.String[]{r1}     // Catch: java.lang.Throwable -> L40
            r7 = 0
            android.database.Cursor r8 = r2.query(r3, r4, r5, r6, r7)     // Catch: java.lang.Throwable -> L40
            r1 = r0
        L23:
            if (r8 == 0) goto L3a
            boolean r2 = r8.moveToNext()     // Catch: java.lang.Throwable -> L42
            if (r2 == 0) goto L3a
            java.lang.String r2 = r8.getString(r0)     // Catch: java.lang.Throwable -> L42
            if (r2 == 0) goto L23
            r2 = 1
            int r3 = r8.getInt(r2)     // Catch: java.lang.Throwable -> L42
            if (r3 != r2) goto L23
            r1 = r2
            goto L23
        L3a:
            if (r8 == 0) goto L3f
            r8.close()
        L3f:
            return r1
        L40:
            r8 = 0
            r1 = r0
        L42:
            java.lang.String r2 = "vvcs e"
            com.autonavi.aps.amapapi.utils.DebugUtils.writeCat(r2, r0)     // Catch: java.lang.Throwable -> L4d
            if (r8 == 0) goto L50
        L49:
            r8.close()
            goto L50
        L4d:
            if (r8 == 0) goto L50
            goto L49
        L50:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.autonavi.aps.amapapi.utils.Utils.getVIVOCoarseSwitch(android.content.Context):boolean");
    }

    public static ArrayList<String> getWifiListFromStrNb(String str) {
        ArrayList<String> arrayList = new ArrayList<>();
        if (!TextUtils.isEmpty(str)) {
            String[] split = str.split(Const.STR_MART_WELL);
            for (int i3 = 0; i3 < split.length; i3++) {
                if (split[i3].contains(",nb") || split[i3].contains(",access")) {
                    arrayList.add(split[i3]);
                }
            }
        }
        return arrayList;
    }

    public static byte[] gz(byte[] bArr) {
        return n9.f(bArr);
    }

    public static boolean hasPerminssion(Context context, String str) {
        if (context != null) {
            try {
                if (context.checkSelfPermission(n9.b(str)) == 0) {
                    return true;
                }
            } catch (Throwable unused) {
                DebugUtils.writeCat("hasPerm err", false);
            }
        }
        return false;
    }

    public static boolean isAppInstalled(Context context, String str) {
        return context.getPackageManager().getPackageInfo(str, 0) != null;
    }

    public static boolean isCoarsePermOpen(Context context) {
        try {
            if (a(context)) {
                return true;
            }
            if (a(Const.BRAND_VIVO) && b(context) && getVIVOCoarseSwitch(context)) {
                return true;
            }
            if (a(Const.BRAND_HUAWEI) && b(context)) {
                if (getHUAWEICoarseSwitch(context)) {
                    return true;
                }
            }
            return false;
        } catch (Throwable unused) {
            DebugUtils.writeCat("icpo e", false);
            return false;
        }
    }

    public static boolean isGpsMock(Location location, int i3) {
        boolean z5;
        Bundle extras;
        try {
            z5 = location.isFromMockProvider();
        } catch (Throwable unused) {
            z5 = false;
        }
        if (z5) {
            return true;
        }
        try {
            extras = location.getExtras();
        } catch (Throwable unused2) {
        }
        if ((extras != null ? extras.getInt("satellites") : 0) <= 0) {
            return true;
        }
        if (i3 == 0 && location.getAltitude() == 0.0d && location.getBearing() == 0.0f) {
            if (location.getSpeed() == 0.0f) {
                return true;
            }
        }
        return false;
    }

    public static boolean isHadApsService(Context context) {
        ServiceInfo serviceInfo;
        try {
            serviceInfo = context.getPackageManager().getServiceInfo(new ComponentName(context, "com.amap.api.location.APSService"), 128);
        } catch (Throwable unused) {
            serviceInfo = null;
        }
        return serviceInfo != null;
    }

    public static boolean isNetworkAvaliable(Context context) {
        try {
            NetworkInfo netWorkInfo = getNetWorkInfo(context);
            if (netWorkInfo != null) {
                if (netWorkInfo.isConnectedOrConnecting()) {
                    return true;
                }
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    public static boolean isSameDay(long j4, long j10) {
        String formatUTC = formatUTC(j4, "yyyyMMdd");
        String formatUTC2 = formatUTC(j10, "yyyyMMdd");
        if ("NULL".equals(formatUTC) || "NULL".equals(formatUTC2)) {
            return false;
        }
        return formatUTC.equals(formatUTC2);
    }

    public static boolean isSameDayAndPart(long j4, long j10) {
        if (!isSameDay(j4, j10)) {
            return false;
        }
        Calendar calendar = Calendar.getInstance(Locale.CHINA);
        calendar.setTimeInMillis(j4);
        int i3 = calendar.get(11);
        calendar.setTimeInMillis(j10);
        int i10 = calendar.get(11);
        if (i3 > 12) {
            if (i10 > 12) {
                return true;
            }
        } else if (i10 <= 12) {
            return true;
        }
        return false;
    }

    public static boolean isSameHour(long j4, long j10) {
        String formatUTC = formatUTC(j4, "yyyyMMddHH");
        String formatUTC2 = formatUTC(j10, "yyyyMMddHH");
        if ("NULL".equals(formatUTC) || "NULL".equals(formatUTC2)) {
            return false;
        }
        return formatUTC.equals(formatUTC2);
    }

    public static boolean isTargetAndroidP(Context context) {
        return Build.VERSION.SDK_INT >= 28 && context.getApplicationInfo().targetSdkVersion >= 28;
    }

    public static String isVIVOOverSea(Context context) {
        try {
            try {
                Class<?> loadClass = context.getClassLoader().loadClass("android.os.SystemProperties");
                return (String) loadClass.getMethod("get", String.class).invoke(loadClass, "ro.vivo.product.overseas");
            } catch (Throwable unused) {
                DebugUtils.writeCat("vvos", false);
                return "no";
            }
        } catch (Throwable unused2) {
            return "no";
        }
    }

    @SuppressLint({"NewApi"})
    public static boolean isWifiAble(Context context) {
        boolean z5;
        boolean z6;
        if (context == null) {
            return true;
        }
        if (f6838b == null) {
            f6838b = (WifiManager) getServ(context, "wifi");
        }
        try {
            if (hasPerminssion(context, Const.ACCESS_WIFI_STATE_SELF_BASE64)) {
                z6 = f6838b.isWifiEnabled();
            } else {
                CoreUtil.reportError(new Exception("n_aws"), "OPENSDK_UTS", "iwfal_n_aws");
                z6 = false;
            }
        } catch (Throwable th2) {
            th = th2;
            z5 = false;
        }
        try {
            DebugUtils.writeCat("iwfal = " + z6, false);
        } catch (Throwable th3) {
            z5 = z6;
            th = th3;
            DebugUtils.printE(th);
            z6 = z5;
            return z6 ? z6 : z6;
        }
        if (z6 && getSdk() > 17) {
            try {
                return "true".equals(String.valueOf(Reflect.invokeMethod(f6838b, "isScanAlwaysAvailable", new Object[0])));
            } catch (Throwable unused) {
                return z6;
            }
        }
    }

    public static boolean joHasK(JSONObject jSONObject, String str) {
        return n9.a(jSONObject, str);
    }

    public static boolean locCorrect(AMapLocationServer aMapLocationServer) {
        if (aMapLocationServer == null || Constants.VIA_SHARE_TYPE_PUBLISHVIDEO.equals(aMapLocationServer.getRetype()) || "5".equals(aMapLocationServer.getRetype()) || Constants.VIA_SHARE_TYPE_INFO.equals(aMapLocationServer.getRetype())) {
            return false;
        }
        return checkLoc(aMapLocationServer);
    }

    public static boolean nbWifiSimiMem(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            ArrayList<String> wifiListFromStrNb = getWifiListFromStrNb(str);
            String[] split = str2.toString().split(Const.STR_MART_WELL);
            int i3 = 0;
            int i10 = 0;
            for (int i11 = 0; i11 < split.length; i11++) {
                if (split[i11].contains(",nb") || split[i11].contains(",access")) {
                    i10++;
                    if (wifiListFromStrNb.contains(split[i11])) {
                        i3++;
                    }
                }
            }
            if (i3 * 2 >= (wifiListFromStrNb.size() + i10) * 0.618d) {
                return true;
            }
        }
        return false;
    }

    public static byte parseByte(String str) throws NumberFormatException {
        return Byte.parseByte(str);
    }

    public static double parseDouble(String str) throws NumberFormatException {
        return Double.parseDouble(str);
    }

    public static float parseFloat(String str) throws NumberFormatException {
        return Float.parseFloat(str);
    }

    public static int parseInt(String str) throws NumberFormatException {
        return Integer.parseInt(str);
    }

    public static int randomInt(int i3, int i10) {
        return new Random().nextInt((i10 - i3) + 1) + i3;
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x003f A[Catch: IOException -> 0x003b, TryCatch #4 {IOException -> 0x003b, blocks: (B:34:0x0037, B:26:0x003f, B:28:0x0044), top: B:33:0x0037 }] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0044 A[Catch: IOException -> 0x003b, TRY_LEAVE, TryCatch #4 {IOException -> 0x003b, blocks: (B:34:0x0037, B:26:0x003f, B:28:0x0044), top: B:33:0x0037 }] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0037 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.util.List<java.lang.String> readLines(java.io.File r4) {
        /*
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            r1 = 0
            java.io.FileInputStream r4 = a(r4)     // Catch: java.lang.Throwable -> L33
            java.io.InputStreamReader r2 = new java.io.InputStreamReader     // Catch: java.lang.Throwable -> L34
            java.nio.charset.Charset r3 = java.nio.charset.Charset.defaultCharset()     // Catch: java.lang.Throwable -> L34
            r2.<init>(r4, r3)     // Catch: java.lang.Throwable -> L34
            java.io.BufferedReader r3 = new java.io.BufferedReader     // Catch: java.lang.Throwable -> L35
            r3.<init>(r2)     // Catch: java.lang.Throwable -> L35
        L18:
            java.lang.String r1 = r3.readLine()     // Catch: java.lang.Throwable -> L31
            if (r1 == 0) goto L22
            r0.add(r1)     // Catch: java.lang.Throwable -> L31
            goto L18
        L22:
            r3.close()     // Catch: java.io.IOException -> L2c
            r2.close()     // Catch: java.io.IOException -> L2c
            r4.close()     // Catch: java.io.IOException -> L2c
            return r0
        L2c:
            r4 = move-exception
            r4.printStackTrace()
            goto L4b
        L31:
            r1 = r3
            goto L35
        L33:
            r4 = r1
        L34:
            r2 = r1
        L35:
            if (r1 == 0) goto L3d
            r1.close()     // Catch: java.io.IOException -> L3b
            goto L3d
        L3b:
            r4 = move-exception
            goto L48
        L3d:
            if (r2 == 0) goto L42
            r2.close()     // Catch: java.io.IOException -> L3b
        L42:
            if (r4 == 0) goto L4b
            r4.close()     // Catch: java.io.IOException -> L3b
            goto L4b
        L48:
            r4.printStackTrace()
        L4b:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.autonavi.aps.amapapi.utils.Utils.readLines(java.io.File):java.util.List");
    }

    public static String str2Base64(String str) {
        return str2Base64(str, 0);
    }

    /* JADX WARN: Code restructure failed: missing block: B:29:0x005c, code lost:
    
        if (r13 == null) goto L26;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static boolean tableExisted(android.database.sqlite.SQLiteDatabase r13, java.lang.String r14) {
        /*
            java.lang.String r0 = "type = 'table' AND name = '"
            boolean r1 = android.text.TextUtils.isEmpty(r14)
            r2 = 0
            if (r1 == 0) goto La
            return r2
        La:
            java.lang.String r1 = "."
            java.lang.String r3 = ""
            java.lang.String r4 = "2.0.201501131131"
            java.lang.String r1 = r4.replace(r1, r3)
            if (r13 == 0) goto L62
            r3 = 1
            boolean r4 = r13.isOpen()     // Catch: java.lang.Throwable -> L5b
            if (r4 != 0) goto L1e
            goto L62
        L1e:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L5b
            r4.<init>(r0)     // Catch: java.lang.Throwable -> L5b
            java.lang.String r14 = r14.trim()     // Catch: java.lang.Throwable -> L5b
            r4.append(r14)     // Catch: java.lang.Throwable -> L5b
            r4.append(r1)     // Catch: java.lang.Throwable -> L5b
            java.lang.String r14 = "'"
            r4.append(r14)     // Catch: java.lang.Throwable -> L5b
            java.lang.String r8 = r4.toString()     // Catch: java.lang.Throwable -> L5b
            java.lang.String r6 = "sqlite_master"
            java.lang.String r14 = "count(*) as c"
            java.lang.String[] r7 = new java.lang.String[]{r14}     // Catch: java.lang.Throwable -> L5b
            r11 = 0
            r12 = 0
            r9 = 0
            r10 = 0
            r5 = r13
            android.database.Cursor r13 = r5.query(r6, r7, r8, r9, r10, r11, r12)     // Catch: java.lang.Throwable -> L5b
            if (r13 == 0) goto L56
            boolean r14 = r13.moveToFirst()     // Catch: java.lang.Throwable -> L5c
            if (r14 == 0) goto L56
            int r14 = r13.getInt(r2)     // Catch: java.lang.Throwable -> L5c
            if (r14 <= 0) goto L56
            r2 = r3
        L56:
            if (r13 == 0) goto L5a
            r3 = r2
            goto L5e
        L5a:
            return r2
        L5b:
            r13 = 0
        L5c:
            if (r13 == 0) goto L61
        L5e:
            r13.close()
        L61:
            return r3
        L62:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.autonavi.aps.amapapi.utils.Utils.tableExisted(android.database.sqlite.SQLiteDatabase, java.lang.String):boolean");
    }

    public static void unZip(String str, String str2) {
        Throwable th2;
        File file;
        FileOutputStream fileOutputStream;
        byte[] bArr;
        String name;
        ZipInputStream zipInputStream = null;
        FileOutputStream fileOutputStream2 = null;
        try {
            try {
                file = new File(str);
            } catch (Throwable unused) {
                return;
            }
        } catch (Throwable th3) {
            th2 = th3;
        }
        if (file.exists() && !file.isDirectory()) {
            String str3 = File.separator;
            if (!str2.endsWith(str3)) {
                str2 = str2 + str3;
            }
            ZipInputStream zipInputStream2 = new ZipInputStream(new FileInputStream(file));
            while (true) {
                try {
                    ZipEntry nextEntry = zipInputStream2.getNextEntry();
                    if (nextEntry == null) {
                        break;
                    }
                    try {
                        bArr = new byte[1024];
                        name = nextEntry.getName();
                    } catch (Exception unused2) {
                        fileOutputStream = null;
                    } catch (Throwable th4) {
                        th = th4;
                    }
                    if (TextUtils.isEmpty(name) || name.contains("../")) {
                        break;
                    }
                    if (!nextEntry.isDirectory()) {
                        File file2 = new File(str2 + name);
                        File file3 = new File(file2.getParent());
                        if (!file3.exists()) {
                            file3.mkdirs();
                        }
                        fileOutputStream = new FileOutputStream(file2);
                        while (true) {
                            try {
                                int read = zipInputStream2.read(bArr, 0, 1024);
                                if (read == -1) {
                                    break;
                                } else {
                                    fileOutputStream.write(bArr, 0, read);
                                }
                            } catch (Exception unused3) {
                                if (fileOutputStream != null) {
                                    fileOutputStream.close();
                                }
                            } catch (Throwable th5) {
                                th = th5;
                                fileOutputStream2 = fileOutputStream;
                                if (fileOutputStream2 != null) {
                                    try {
                                        fileOutputStream2.close();
                                    } catch (Throwable unused4) {
                                    }
                                }
                                throw th;
                            }
                        }
                        fileOutputStream.flush();
                        try {
                            fileOutputStream.close();
                        } catch (Throwable unused5) {
                        }
                    }
                } catch (Throwable th6) {
                    th2 = th6;
                    zipInputStream = zipInputStream2;
                    try {
                        CoreUtil.reportError(th2, "Utils", "unZip");
                        if (zipInputStream != null) {
                            zipInputStream.closeEntry();
                            zipInputStream2 = zipInputStream;
                            zipInputStream2.close();
                        }
                        return;
                    } catch (Throwable th7) {
                        if (zipInputStream != null) {
                            try {
                                zipInputStream.closeEntry();
                                zipInputStream.close();
                            } catch (Throwable unused6) {
                            }
                        }
                        throw th7;
                    }
                }
            }
            zipInputStream2.closeEntry();
            zipInputStream2.close();
        }
    }

    public static byte[] ungz(byte[] bArr) {
        byte[] bArr2 = new byte[10240];
        try {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
            GZIPInputStream gZIPInputStream = new GZIPInputStream(byteArrayInputStream);
            DataInputStream dataInputStream = new DataInputStream(gZIPInputStream);
            int i3 = 0;
            while (true) {
                int read = dataInputStream.read(bArr2, i3, i3 + 2048);
                if (read == -1) {
                    byte[] bArr3 = new byte[i3];
                    System.arraycopy(bArr2, 0, bArr3, 0, i3);
                    dataInputStream.close();
                    gZIPInputStream.close();
                    byteArrayInputStream.close();
                    return bArr3;
                }
                i3 += read;
            }
        } catch (Throwable th2) {
            CoreUtil.reportError(th2, "Utils", "ungz");
            return null;
        }
    }

    public static boolean wifiUseful(String str) {
        return (TextUtils.isEmpty(str) || Const.STR_DEF_SMAC.equals(str) || Const.STR_DEF_NOPERM_SMAC.equals(str) || str.contains(" :")) ? false : true;
    }

    public static void writeStringToFile(File file, String str, boolean z5) {
        FileOutputStream fileOutputStream = null;
        try {
            try {
                try {
                    fileOutputStream = a(file, z5);
                    if (str != null) {
                        fileOutputStream.write(str.getBytes());
                    }
                    fileOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                    if (fileOutputStream != null) {
                        fileOutputStream.close();
                    }
                }
            } catch (IOException e10) {
                e10.printStackTrace();
            }
        } catch (Throwable th2) {
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (IOException e11) {
                    e11.printStackTrace();
                }
            }
            throw th2;
        }
    }

    public static String getLocErrorInfo(String str, int i3) {
        if (TextUtils.equals(str, Const.NETLOC_FAIL_CAUSE)) {
            switch (i3) {
                case -13:
                    return "定位开关未开启";
                case -12:
                    return "定位权限Coarse未开启";
                case -11:
                    return "飞行模式";
                default:
                    switch (i3) {
                        case 0:
                            return AMapException.AMAP_CLIENT_UNKNOWN_ERROR;
                        case 1:
                            return "指纹不足";
                        case 2:
                            return "客户端限流";
                        case 3:
                            return "服务端限流";
                        case 4:
                            return "请求间隔过快";
                        case 5:
                            return "在线定位-网络异常";
                        case 6:
                            return "在线定位-请求超时";
                        case 7:
                            return "在线定位-定位无效";
                        case 8:
                            return "在线定位-服务返回失败";
                        default:
                            return "其他错误";
                    }
            }
        }
        if (!TextUtils.equals(str, Const.SIGNAL_WEAK_CAUSE)) {
            return "其他错误";
        }
        if (i3 == 40 || i3 == 41) {
            return "卫星信号弱";
        }
        if (i3 == -3 || i3 == -2 || i3 == -1) {
            return "无卫星信号";
        }
        if (i3 == 0) {
            return "卫星信号弱";
        }
        if (i3 == 1) {
            return "卫星信号正常";
        }
        switch (i3) {
            case 11:
                return "疑似卫星信号被遮挡";
            case 12:
            case 13:
                return "卫星信号受到干扰";
            case 14:
                return "卫星信号被遮挡";
            default:
                switch (i3) {
                    case 20:
                    case 21:
                    case 22:
                    case 23:
                    case 24:
                        return "卫星信号被遮挡";
                    default:
                        switch (i3) {
                            case 30:
                                return "疑似系统异常";
                            case 31:
                                return "系统异常";
                            case 32:
                            case 33:
                            case 34:
                                return "卫星信号弱";
                            default:
                                return "其他错误";
                        }
                }
        }
    }

    public static int parseInt(String str, int i3) throws NumberFormatException {
        return Integer.parseInt(str, i3);
    }

    public static String str2Base64(String str, int i3) {
        byte[] bArr;
        try {
            bArr = str.getBytes("UTF-8");
        } catch (Throwable th2) {
            CoreUtil.reportError(th2, "Utils", "str2Base64");
            bArr = null;
        }
        return Base64.encodeToString(bArr, i3);
    }

    public static float dist(AMapLocation aMapLocation, AMapLocation aMapLocation2) {
        return dist(new double[]{aMapLocation.getLatitude(), aMapLocation.getLongitude(), aMapLocation2.getLatitude(), aMapLocation2.getLongitude()});
    }

    public static boolean locCorrect(AMapLocation aMapLocation) {
        if (aMapLocation != null && aMapLocation.getErrorCode() == 0) {
            return checkLoc(aMapLocation);
        }
        return false;
    }

    private static FileInputStream a(File file) throws IOException {
        if (file.exists()) {
            if (!file.isDirectory()) {
                if (file.canRead()) {
                    return new FileInputStream(file);
                }
                throw new IOException("File '" + file + "' cannot be read");
            }
            throw new IOException("File '" + file + "' exists but is a directory");
        }
        throw new FileNotFoundException("File '" + file + "' does not exist");
    }

    public static float dist(DPoint dPoint, DPoint dPoint2) {
        return dist(new double[]{dPoint.getLatitude(), dPoint.getLongitude(), dPoint2.getLatitude(), dPoint2.getLongitude()});
    }

    private static FileOutputStream a(File file, boolean z5) throws IOException {
        if (file.exists()) {
            if (!file.isDirectory()) {
                if (!file.canWrite()) {
                    throw new IOException("File '" + file + "' cannot be written to");
                }
            } else {
                throw new IOException("File '" + file + "' exists but is a directory");
            }
        } else {
            File parentFile = file.getParentFile();
            if (parentFile != null) {
                if (!parentFile.mkdirs() && !parentFile.isDirectory()) {
                    throw new IOException("Directory '" + parentFile + "' could not be created");
                }
                file.createNewFile();
            }
        }
        return new FileOutputStream(file, z5);
    }

    private static boolean a(Context context) {
        try {
            if (Build.VERSION.SDK_INT >= 31 && context != null && context.checkSelfPermission("android.permission.ACCESS_FINE_LOCATION") != 0) {
                if (context.checkSelfPermission("android.permission.ACCESS_COARSE_LOCATION") == 0) {
                    return true;
                }
            }
            return false;
        } catch (Throwable unused) {
            DebugUtils.writeCat("isCoarsePermSORAbove", false);
            return false;
        }
    }

    private static boolean a(String str) {
        try {
            String str2 = Build.MANUFACTURER;
            String str3 = Build.BRAND;
            if (str2.equalsIgnoreCase(str)) {
                return true;
            }
            return str3.toLowerCase().contains(str);
        } catch (Throwable unused) {
            DebugUtils.writeCat("tdb e", false);
            return false;
        }
    }
}
