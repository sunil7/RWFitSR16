package com.amap.api.col.p0003sl;

import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkInfo;
import android.net.NetworkRequest;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.os.IBinder;
import android.os.Parcel;
import android.os.StatFs;
import android.provider.Settings;
import android.support.v4.media.session.PlaybackStateCompat;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Xml;
import android.view.WindowManager;
import com.autonavi.aps.amapapi.config.Const;
import com.autonavi.aps.amapapi.storage.SdCardDbCreator;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.security.MessageDigest;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import org.xmlpull.v1.XmlPullParser;

/* loaded from: classes.dex */
public class f9 {

    /* renamed from: a, reason: collision with root package name */
    static volatile String f4096a = "";

    /* renamed from: b, reason: collision with root package name */
    static volatile String f4097b = "";

    /* renamed from: c, reason: collision with root package name */
    static volatile boolean f4098c = true;

    /* renamed from: d, reason: collision with root package name */
    private static String f4099d = null;
    public static d e = null;

    /* renamed from: f, reason: collision with root package name */
    private static volatile boolean f4100f = false;

    /* renamed from: g, reason: collision with root package name */
    private static String f4101g = "";

    /* renamed from: h, reason: collision with root package name */
    private static boolean f4102h = false;

    /* renamed from: i, reason: collision with root package name */
    private static boolean f4103i = true;

    /* renamed from: j, reason: collision with root package name */
    private static String f4104j;

    /* renamed from: k, reason: collision with root package name */
    private static IBinder f4105k;

    /* renamed from: v, reason: collision with root package name */
    private static long f4115v;

    /* renamed from: w, reason: collision with root package name */
    private static int f4116w;

    /* renamed from: x, reason: collision with root package name */
    private static String f4117x;

    /* renamed from: l, reason: collision with root package name */
    private static final AtomicBoolean f4106l = new AtomicBoolean(false);

    /* renamed from: m, reason: collision with root package name */
    private static boolean f4107m = false;

    /* renamed from: n, reason: collision with root package name */
    private static final AtomicBoolean f4108n = new AtomicBoolean(false);

    /* renamed from: o, reason: collision with root package name */
    private static String f4109o = "";

    /* renamed from: p, reason: collision with root package name */
    private static String f4110p = "";

    /* renamed from: q, reason: collision with root package name */
    private static boolean f4111q = false;
    private static String r = "";

    /* renamed from: s, reason: collision with root package name */
    private static String f4112s = "";

    /* renamed from: t, reason: collision with root package name */
    static String f4113t = "";

    /* renamed from: u, reason: collision with root package name */
    private static String f4114u = "";

    /* renamed from: y, reason: collision with root package name */
    private static String f4118y = "";

    /* renamed from: z, reason: collision with root package name */
    private static String f4119z = "";
    private static boolean A = false;
    private static int B = -1;
    private static boolean C = false;
    private static int D = -1;
    private static boolean E = false;
    private static volatile e F = null;

    public static class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Context f4120a;

        public a(Context context) {
            this.f4120a = context;
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                Map<String, String> b3 = f9.e.b();
                String a3 = f9.e.a(f9.t(this.f4120a), "", "", "");
                if (TextUtils.isEmpty(a3)) {
                    return;
                }
                String a10 = f9.e.a(this.f4120a, new String(ib.a().a(f9.e.a(a3.getBytes(), b3)).f4927a));
                if (TextUtils.isEmpty(a10)) {
                    return;
                }
                f9.f4097b = a10;
            } catch (Throwable unused) {
            }
        }
    }

    public static class b implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Context f4121a;

        public b(Context context) {
            this.f4121a = context;
        }

        @Override // java.lang.Runnable
        public final void run() {
            f9.d(this.f4121a);
        }
    }

    public static class c implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Context f4122a;

        public c(Context context) {
            this.f4122a = context;
        }

        @Override // java.lang.Runnable
        public final void run() {
            f9.e(this.f4122a.getApplicationContext());
        }
    }

    public interface d {
        pb a(byte[] bArr, Map<String, String> map);

        String a();

        String a(Context context, String str);

        String a(String str, String str2, String str3, String str4);

        Map<String, String> b();
    }

    public static class e {

        /* renamed from: a, reason: collision with root package name */
        private static BroadcastReceiver f4123a;

        /* renamed from: b, reason: collision with root package name */
        private static ConnectivityManager f4124b;

        /* renamed from: c, reason: collision with root package name */
        private static NetworkRequest f4125c;

        /* renamed from: d, reason: collision with root package name */
        private static ConnectivityManager.NetworkCallback f4126d;

        public class a extends BroadcastReceiver {
            public a(e eVar) {
            }

            @Override // android.content.BroadcastReceiver
            public final void onReceive(Context context, Intent intent) {
                if (n9.b("WYW5kcm9pZC5uZXQuY29ubi5DT05ORUNUSVZJVFlfQ0hBTkdF").equals(intent.getAction())) {
                    f9.f();
                }
            }
        }

        public class b extends ConnectivityManager.NetworkCallback {
            public b(e eVar) {
            }

            @Override // android.net.ConnectivityManager.NetworkCallback
            public final void onAvailable(Network network) {
                super.onAvailable(network);
                f9.f();
            }

            @Override // android.net.ConnectivityManager.NetworkCallback
            public final void onLost(Network network) {
                super.onLost(network);
                f9.f();
            }
        }

        @SuppressLint({"WrongConstant", "MissingPermission"})
        public final void a(Context context) {
            if (f9.b(context, n9.b("AYW5kcm9pZC5wZXJtaXNzaW9uLkFDQ0VTU19ORVRXT1JLX1NUQVRF")) && context != null && f4124b == null) {
                ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
                f4124b = connectivityManager;
                if (connectivityManager != null) {
                    f4125c = new NetworkRequest.Builder().addCapability(12).addTransportType(1).addTransportType(0).build();
                    b bVar = new b(this);
                    f4126d = bVar;
                    f4124b.registerNetworkCallback(f4125c, bVar);
                }
            }
        }
    }

    public static class f implements ServiceConnection {
        @Override // android.content.ServiceConnection
        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            IBinder unused = f9.f4105k = iBinder;
        }

        @Override // android.content.ServiceConnection
        public final void onServiceDisconnected(ComponentName componentName) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0027 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0028  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static java.lang.String A(android.content.Context r9) {
        /*
            java.lang.String r0 = "SIw"
            java.lang.String r1 = "LYW1hcF9kZXZpY2VfYWRpdQ"
            java.lang.String r1 = com.amap.api.col.p0003sl.n9.b(r1)
            java.lang.String r1 = com.amap.api.col.p0003sl.e9.c(r1)
            r2 = 0
            java.io.File r3 = r9.getExternalCacheDir()     // Catch: java.lang.Exception -> L1e
            if (r3 != 0) goto L17
            java.io.File r3 = r9.getCacheDir()     // Catch: java.lang.Exception -> L1e
        L17:
            if (r3 == 0) goto L1e
            java.lang.String r9 = r3.getAbsolutePath()     // Catch: java.lang.Exception -> L1e
            goto L1f
        L1e:
            r9 = r2
        L1f:
            boolean r3 = android.text.TextUtils.isEmpty(r9)
            java.lang.String r4 = ""
            if (r3 == 0) goto L28
            return r4
        L28:
            java.lang.StringBuilder r9 = com.google.android.gms.internal.mlkit_vision_barcode.l0.t(r9)
            java.lang.String r3 = java.io.File.separator
            r9.append(r3)
            java.lang.String r3 = "KYmFja3Vwcw"
            java.lang.String r3 = com.amap.api.col.p0003sl.n9.b(r3)
            r9.append(r3)
            java.lang.String r9 = r9.toString()
            java.io.File r3 = new java.io.File
            java.lang.String r5 = "MLmFkaXU"
            java.lang.String r5 = com.amap.api.col.p0003sl.n9.b(r5)
            r3.<init>(r9, r5)
            boolean r9 = r3.exists()
            if (r9 == 0) goto Lc7
            boolean r9 = r3.canRead()
            if (r9 != 0) goto L57
            goto Lc7
        L57:
            long r5 = r3.length()
            r7 = 0
            int r9 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r9 != 0) goto L65
            r3.delete()
            return r4
        L65:
            java.io.RandomAccessFile r9 = new java.io.RandomAccessFile     // Catch: java.lang.Throwable -> Lc0
            java.lang.String r5 = "r"
            r9.<init>(r3, r5)     // Catch: java.lang.Throwable -> Lc0
            r3 = 1024(0x400, float:1.435E-42)
            byte[] r3 = new byte[r3]     // Catch: java.lang.Throwable -> Lbe
            java.io.ByteArrayOutputStream r5 = new java.io.ByteArrayOutputStream     // Catch: java.lang.Throwable -> Lbe
            r5.<init>()     // Catch: java.lang.Throwable -> Lbe
        L75:
            int r2 = r9.read(r3)     // Catch: java.lang.Throwable -> Lbc
            r6 = -1
            r7 = 0
            if (r2 == r6) goto L81
            r5.write(r3, r7, r2)     // Catch: java.lang.Throwable -> Lbc
            goto L75
        L81:
            java.lang.String r2 = new java.lang.String     // Catch: java.lang.Throwable -> Lbc
            byte[] r3 = r5.toByteArray()     // Catch: java.lang.Throwable -> Lbc
            java.lang.String r6 = "UTF-8"
            r2.<init>(r3, r6)     // Catch: java.lang.Throwable -> Lbc
            boolean r3 = android.text.TextUtils.isEmpty(r2)     // Catch: java.lang.Throwable -> Lbc
            if (r3 != 0) goto Lbc
            java.lang.String r3 = com.amap.api.col.p0003sl.n9.b(r0)     // Catch: java.lang.Throwable -> Lbc
            boolean r3 = r2.contains(r3)     // Catch: java.lang.Throwable -> Lbc
            if (r3 == 0) goto Lbc
            java.lang.String r0 = com.amap.api.col.p0003sl.n9.b(r0)     // Catch: java.lang.Throwable -> Lbc
            java.lang.String[] r0 = r2.split(r0)     // Catch: java.lang.Throwable -> Lbc
            if (r0 == 0) goto Lbc
            int r2 = r0.length     // Catch: java.lang.Throwable -> Lbc
            r3 = 2
            if (r2 != r3) goto Lbc
            r2 = r0[r7]     // Catch: java.lang.Throwable -> Lbc
            boolean r1 = android.text.TextUtils.equals(r1, r2)     // Catch: java.lang.Throwable -> Lbc
            if (r1 == 0) goto Lbc
            r1 = 1
            r0 = r0[r1]     // Catch: java.lang.Throwable -> Lbc
            a(r5)
            a(r9)
            return r0
        Lbc:
            r2 = r9
            goto Lc1
        Lbe:
            r5 = r2
            goto Lbc
        Lc0:
            r5 = r2
        Lc1:
            a(r5)
            a(r2)
        Lc7:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.p0003sl.f9.A(android.content.Context):java.lang.String");
    }

    private static synchronized e B(Context context) {
        synchronized (f9.class) {
            try {
                if (F == null) {
                    if (context == null) {
                        return null;
                    }
                    e eVar = new e();
                    F = eVar;
                    eVar.a(context.getApplicationContext());
                }
                return F;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean b(Context context, String str) {
        return context != null && context.checkCallingOrSelfPermission(str) == 0;
    }

    public static String c() {
        return f4109o;
    }

    public static long d() {
        long j4 = f4115v;
        if (j4 != 0) {
            return j4;
        }
        try {
            StatFs statFs = new StatFs(Environment.getRootDirectory().getAbsolutePath());
            StatFs statFs2 = new StatFs(Environment.getExternalStorageDirectory().getAbsolutePath());
            f4115v = ((statFs.getBlockCountLong() * statFs.getBlockSizeLong()) / PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED) + ((statFs2.getBlockCountLong() * statFs2.getBlockSizeLong()) / PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED);
        } catch (Throwable unused) {
        }
        return f4115v;
    }

    public static String e() {
        return f4099d;
    }

    public static String f(Context context) {
        if (!TextUtils.isEmpty(f4097b)) {
            return f4097b;
        }
        if (context == null) {
            return "";
        }
        String z5 = z(context);
        f4097b = z5;
        if (!TextUtils.isEmpty(z5)) {
            return f4097b;
        }
        if (e == null || f4100f) {
            return "";
        }
        f4100f = true;
        new Thread(new a(context), "ADIUFetchingThread").start();
        return "";
    }

    public static int g(Context context) {
        try {
            return x(context);
        } catch (Throwable unused) {
            return -1;
        }
    }

    public static String h(Context context) {
        ConnectivityManager connectivityManager;
        NetworkInfo activeNetworkInfo;
        try {
            return (!b(context, n9.b("AYW5kcm9pZC5wZXJtaXNzaW9uLkFDQ0VTU19ORVRXT1JLX1NUQVRF")) || (connectivityManager = (ConnectivityManager) context.getSystemService("connectivity")) == null || (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) == null) ? "" : activeNetworkInfo.getTypeName();
        } catch (Throwable unused) {
            return "";
        }
    }

    public static int i(Context context) {
        try {
            return x(context);
        } catch (Throwable th2) {
            th2.printStackTrace();
            return -1;
        }
    }

    public static int j(Context context) {
        try {
            return y(context);
        } catch (Throwable th2) {
            th2.printStackTrace();
            return -1;
        }
    }

    public static String k(Context context) {
        try {
            return w(context);
        } catch (Throwable th2) {
            th2.printStackTrace();
            return "";
        }
    }

    public static String l(Context context) {
        return f4112s + Const.STR_MART_WELL + f(context) + Const.STR_MART_WELL + p(context);
    }

    public static String m(Context context) {
        try {
            if (!b(context, n9.b("WYW5kcm9pZC5wZXJtaXNzaW9uLlJFQURfUEhPTkVfU1RBVEU="))) {
                return f4118y;
            }
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            return telephonyManager == null ? "" : telephonyManager.getNetworkOperatorName();
        } catch (Throwable unused) {
            return "";
        }
    }

    public static NetworkInfo n(Context context) {
        ConnectivityManager connectivityManager;
        if (b(context, n9.b("AYW5kcm9pZC5wZXJtaXNzaW9uLkFDQ0VTU19ORVRXT1JLX1NUQVRF")) && (connectivityManager = (ConnectivityManager) context.getSystemService("connectivity")) != null) {
            return connectivityManager.getActiveNetworkInfo();
        }
        return null;
    }

    public static int o(Context context) {
        try {
            return y(context);
        } catch (Throwable unused) {
            return -1;
        }
    }

    public static String p(Context context) {
        String str;
        str = "";
        try {
            String str2 = f4112s;
            try {
                if (TextUtils.isEmpty(str2)) {
                    str2 = f(context);
                }
                if (TextUtils.isEmpty(str2)) {
                    str2 = t(context);
                }
                if (TextUtils.isEmpty(str2)) {
                    str2 = q(context);
                }
                str = TextUtils.isEmpty(str2) ? "" : str2;
                return TextUtils.isEmpty(str) ? u(context) : str;
            } catch (Throwable unused) {
                return str2;
            }
        } catch (Throwable unused2) {
            return str;
        }
    }

    public static String q(Context context) {
        if (!f4103i || f4102h) {
            return "";
        }
        if (!TextUtils.isEmpty(f4101g)) {
            return f4101g;
        }
        if (f4106l.compareAndSet(false, true)) {
            new Thread(new b(context), "OD-Thread").start();
        }
        return f4101g;
    }

    public static int r(Context context) {
        int i3 = f4116w;
        if (i3 != 0) {
            return i3;
        }
        ActivityManager activityManager = (ActivityManager) context.getSystemService(Const.STR_PROCESS_TAG);
        if (activityManager == null) {
            return 0;
        }
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        activityManager.getMemoryInfo(memoryInfo);
        int i10 = ((int) (memoryInfo.totalMem / 1024)) / 1024;
        f4116w = i10;
        return i10;
    }

    public static String s(Context context) {
        try {
            if (!TextUtils.isEmpty(f4104j)) {
                return f4104j;
            }
            byte[] digest = MessageDigest.getInstance(n9.b("IU0hBMQ")).digest(context.getPackageManager().getPackageInfo(context.getPackageName(), 64).signatures[0].toByteArray());
            StringBuffer stringBuffer = new StringBuffer();
            for (byte b3 : digest) {
                stringBuffer.append(Integer.toHexString((b3 & 255) | 256).substring(1, 3));
            }
            String stringBuffer2 = stringBuffer.toString();
            if (!TextUtils.isEmpty(stringBuffer2)) {
                f4104j = stringBuffer2;
            }
            return stringBuffer2;
        } catch (Throwable unused) {
            return "";
        }
    }

    public static String t(Context context) {
        if (f4107m) {
            return f4096a == null ? "" : f4096a;
        }
        if (f4096a != null && !"".equals(f4096a)) {
            return f4096a;
        }
        if (f4108n.compareAndSet(false, true)) {
            new Thread(new c(context), "UD-Thread").start();
        }
        return f4096a == null ? "" : f4096a;
    }

    public static String u(Context context) {
        if (!TextUtils.isEmpty(f4114u)) {
            return f4114u;
        }
        try {
            String b3 = xa.b(context, "open_common", SdCardDbCreator.FIELD_LASTLOC_ID, "");
            if (TextUtils.isEmpty(b3)) {
                f4114u = Const.STR_PUBLIC_TAG + UUID.randomUUID().toString().replace("_", "").toLowerCase();
                SharedPreferences.Editor a3 = xa.a(context, "open_common");
                xa.a(a3, SdCardDbCreator.FIELD_LASTLOC_ID, n9.f(f4114u));
                xa.a(a3);
            } else {
                f4114u = n9.b(b3);
            }
            return f4114u;
        } catch (Throwable unused) {
            return f4114u;
        }
    }

    private static String v(Context context) {
        FileInputStream fileInputStream;
        XmlPullParser newPullParser;
        int eventType;
        try {
            File file = new File(context.getExternalCacheDir().getAbsolutePath() + "/.UTSystemConfig/Global/Alvin2.xml");
            newPullParser = Xml.newPullParser();
            fileInputStream = new FileInputStream(file);
        } catch (Throwable unused) {
            fileInputStream = null;
        }
        try {
            newPullParser.setInput(fileInputStream, "utf-8");
            boolean z5 = false;
            for (eventType = newPullParser.getEventType(); 1 != eventType; eventType = newPullParser.next()) {
                if (eventType != 2) {
                    if (eventType == 3) {
                        z5 = false;
                    } else if (eventType == 4 && z5) {
                        String text = newPullParser.getText();
                        try {
                            fileInputStream.close();
                        } catch (Throwable unused2) {
                        }
                        return text;
                    }
                } else if (newPullParser.getAttributeCount() > 0) {
                    int attributeCount = newPullParser.getAttributeCount();
                    for (int i3 = 0; i3 < attributeCount; i3++) {
                        String attributeValue = newPullParser.getAttributeValue(i3);
                        if ("UTDID2".equals(attributeValue) || "UTDID".equals(attributeValue)) {
                            z5 = true;
                        }
                    }
                }
            }
        } catch (Throwable unused3) {
            if (fileInputStream == null) {
                return "";
            }
            fileInputStream.close();
            return "";
        }
        try {
            fileInputStream.close();
            return "";
        } catch (Throwable unused4) {
            return "";
        }
    }

    private static String w(Context context) {
        if (A) {
            return f4119z;
        }
        B(context);
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
        if (telephonyManager == null) {
            return f4119z;
        }
        String simOperatorName = telephonyManager.getSimOperatorName();
        f4119z = simOperatorName;
        if (TextUtils.isEmpty(simOperatorName)) {
            f4119z = telephonyManager.getNetworkOperatorName();
        }
        A = true;
        return f4119z;
    }

    private static int x(Context context) {
        if (C) {
            return B;
        }
        B(context);
        if (context == null || !b(context, n9.b("AYW5kcm9pZC5wZXJtaXNzaW9uLkFDQ0VTU19ORVRXT1JLX1NUQVRF"))) {
            return B;
        }
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        if (connectivityManager == null) {
            return B;
        }
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        if (activeNetworkInfo == null) {
            C = true;
            return B;
        }
        int type = activeNetworkInfo.getType();
        B = type;
        C = true;
        return type;
    }

    private static int y(Context context) {
        ConnectivityManager connectivityManager;
        if (E) {
            return D;
        }
        B(context);
        if (b(context, n9.b("AYW5kcm9pZC5wZXJtaXNzaW9uLkFDQ0VTU19ORVRXT1JLX1NUQVRF")) && (connectivityManager = (ConnectivityManager) context.getSystemService("connectivity")) != null) {
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            if (activeNetworkInfo != null && activeNetworkInfo.isAvailable()) {
                D = activeNetworkInfo.getSubtype();
                E = true;
            }
            return D;
        }
        return D;
    }

    private static String z(Context context) {
        String str;
        if (!f4098c) {
            return "";
        }
        try {
            str = A(context);
        } catch (Throwable unused) {
            str = "";
        }
        try {
            if (TextUtils.isEmpty(str)) {
                str = context.getSharedPreferences(n9.b("SU2hhcmVkUHJlZmVyZW5jZUFkaXU"), 0).getString(e9.c(n9.b("RYW1hcF9kZXZpY2VfYWRpdQ")), "");
            }
        } catch (Throwable unused2) {
            str = null;
        }
        if (TextUtils.isEmpty(str)) {
            f4098c = false;
            return "";
        }
        try {
            byte[] bytes = n9.b("MAAAAAAAAAAAAAAAAAAAAAA").getBytes("UTF-8");
            return new String(h9.b(n9.b("HYW1hcGFkaXVhbWFwYWRpdWFtYXBhZGl1YW1hcGFkaXU").getBytes("UTF-8"), h9.a(str), bytes), "UTF-8");
        } catch (Throwable unused3) {
            f4098c = false;
            return "";
        }
    }

    public static String b(Context context) {
        String str;
        StringBuilder sb2;
        try {
            str = r;
        } catch (Throwable unused) {
        }
        if (str != null && !"".equals(str)) {
            return r;
        }
        DisplayMetrics displayMetrics = new DisplayMetrics();
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        if (windowManager == null) {
            return "";
        }
        windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        int i3 = displayMetrics.widthPixels;
        int i10 = displayMetrics.heightPixels;
        if (i10 > i3) {
            sb2 = new StringBuilder();
            sb2.append(i3);
            sb2.append("*");
            sb2.append(i10);
        } else {
            sb2 = new StringBuilder();
            sb2.append(i10);
            sb2.append("*");
            sb2.append(i3);
        }
        r = sb2.toString();
        return r;
    }

    public static String c(Context context) {
        try {
            return w(context);
        } catch (Throwable unused) {
            return "";
        }
    }

    public static void e(Context context) {
        String str = "";
        try {
            if (b(context, n9.b("WYW5kcm9pZC5wZXJtaXNzaW9uLldSSVRFX1NFVFRJTkdT"))) {
                f4096a = Settings.System.getString(context.getContentResolver(), "mqBRboGZkQPcAkyk");
            }
            if (!TextUtils.isEmpty(f4096a)) {
                f4107m = true;
                return;
            }
        } catch (Throwable unused) {
        }
        try {
            String b3 = xa.b(context, "Alvin2", "UTDID2", "");
            str = TextUtils.isEmpty(b3) ? xa.b(context, "Alvin2", "UTDID", "") : b3;
        } catch (Throwable unused2) {
        }
        try {
            f4096a = str;
            if (!TextUtils.isEmpty(str)) {
                f4107m = true;
                return;
            }
        } catch (Throwable unused3) {
        }
        try {
            f4096a = v(context);
            f4107m = true;
        } catch (Throwable unused4) {
        }
    }

    public static void a(String str) {
        f4099d = str;
    }

    /* JADX WARN: Finally extract failed */
    private static String a(Context context, int i3) {
        try {
            Intent intent = new Intent();
            if (i3 == 2) {
                intent.setAction(n9.b("WY29tLnVvZGlzLm9wZW5kZXZpY2UuT1BFTklEU19TRVJWSUNF"));
                intent.setPackage(n9.b("UY29tLmh1YXdlaS5od2lk"));
            } else if (i3 == 4) {
                intent.setClassName(n9.b("WY29tLnNhbXN1bmcuYW5kcm9pZC5kZXZpY2VpZHNlcnZpY2U"), n9.b("QY29tLnNhbXN1bmcuYW5kcm9pZC5kZXZpY2VpZHNlcnZpY2UuRGV2aWNlSWRTZXJ2aWNl"));
            } else {
                if (i3 != 5) {
                    f4102h = true;
                    return f4101g;
                }
                intent.setClassName(n9.b("YY29tLmhleXRhcC5vcGVuaWQ"), n9.b("SY29tLmhleXRhcC5vcGVuaWQuSWRlbnRpZnlTZXJ2aWNl"));
                intent.setAction(n9.b("EYWN0aW9uLmNvbS5oZXl0YXAub3BlbmlkLk9QRU5fSURfU0VSVklDRQ"));
            }
            f fVar = new f();
            if (context.bindService(intent, fVar, 1)) {
                int i10 = 0;
                while (i10 < 100 && TextUtils.isEmpty(f4101g)) {
                    i10++;
                    if (f4105k != null) {
                        Parcel obtain = Parcel.obtain();
                        Parcel obtain2 = Parcel.obtain();
                        if (i3 == 2) {
                            obtain.writeInterfaceToken(n9.b("UY29tLnVvZGlzLm9wZW5kZXZpY2UuYWlkbC5PcGVuRGV2aWNlSWRlbnRpZmllclNlcnZpY2U"));
                        } else if (i3 == 4) {
                            obtain.writeInterfaceToken(n9.b("UY29tLnNhbXN1bmcuYW5kcm9pZC5kZXZpY2VpZHNlcnZpY2UuSURldmljZUlkU2VydmljZQ"));
                        } else {
                            if (i3 == 5) {
                                try {
                                    obtain.writeInterfaceToken(n9.b("KY29tLmhleXRhcC5vcGVuaWQuSU9wZW5JRA"));
                                    obtain.writeString(context.getPackageName());
                                    obtain.writeString(s(context));
                                    obtain.writeString(n9.b("IT1VJRA"));
                                } catch (Throwable th2) {
                                    try {
                                        ga.a(th2, "oac", String.valueOf(i3));
                                        obtain2.recycle();
                                    } catch (Throwable th3) {
                                        obtain2.recycle();
                                        obtain.recycle();
                                        throw th3;
                                    }
                                }
                            }
                            obtain2.recycle();
                            obtain.recycle();
                        }
                        f4105k.transact(1, obtain, obtain2, 0);
                        obtain2.readException();
                        f4101g = obtain2.readString();
                        obtain2.recycle();
                        obtain.recycle();
                    }
                    Thread.sleep(15L);
                }
                context.unbindService(fVar);
                f4105k = null;
            }
            return f4101g;
        } catch (Throwable th4) {
            ga.a(th4, "oa", String.valueOf(i3));
            f4102h = true;
            return f4101g;
        }
    }

    public static String d(Context context) {
        String b3 = n9.b("IeGlhb21p");
        String str = Build.MANUFACTURER;
        if (!b3.equalsIgnoreCase(str)) {
            String b10 = n9.b("IeGlhb21p");
            String str2 = Build.BRAND;
            if (!b10.equalsIgnoreCase(str2) && !n9.b("IUkVETUk=").equalsIgnoreCase(str) && !n9.b("IUkVETUk=").equalsIgnoreCase(str2)) {
                if (!n9.b("Idml2bw").equalsIgnoreCase(str) && !n9.b("Idml2bw").equalsIgnoreCase(str2)) {
                    if (!n9.b("IaHVhd2Vp").equalsIgnoreCase(str) && !n9.b("IaHVhd2Vp").equalsIgnoreCase(str2) && !n9.b("ISE9OT1I=").equalsIgnoreCase(str)) {
                        if (!n9.b("Mc2Ftc3VuZw").equalsIgnoreCase(str) && !n9.b("Mc2Ftc3VuZw").equalsIgnoreCase(str2)) {
                            if (!n9.b("IT1BQTw").equalsIgnoreCase(str) && !n9.b("IT1BQTw").equalsIgnoreCase(str2) && !n9.b("MT25lUGx1cw").equalsIgnoreCase(str) && !n9.b("MT25lUGx1cw").equalsIgnoreCase(str2) && !n9.b("IUkVBTE1F").equalsIgnoreCase(str2)) {
                                f4102h = true;
                                return f4101g;
                            }
                            return a(context, 5);
                        }
                        return a(context, 4);
                    }
                    return a(context, 2);
                }
                try {
                    Cursor query = context.getContentResolver().query(Uri.parse(n9.b("QY29udGVudDovL2NvbS52aXZvLnZtcy5JZFByb3ZpZGVyL0lkZW50aWZpZXJJZC9PQUlE")), null, null, null, null);
                    if (query != null) {
                        while (query.moveToNext()) {
                            int columnCount = query.getColumnCount();
                            int i3 = 0;
                            while (true) {
                                if (i3 >= columnCount) {
                                    break;
                                }
                                if (n9.b("IdmFsdWU").equals(query.getColumnName(i3))) {
                                    f4101g = query.getString(i3);
                                    break;
                                }
                                i3++;
                            }
                        }
                        query.close();
                    }
                } catch (Throwable th2) {
                    f4102h = true;
                    ga.a(th2, "oa", Const.BRAND_VIVO);
                }
                return f4101g;
            }
        }
        try {
            Class<?> cls = Class.forName(n9.b("WY29tLmFuZHJvaWQuaWQuaW1wbC5JZFByb3ZpZGVySW1wbA"));
            Object invoke = cls.getMethod(n9.b("MZ2V0T0FJRA"), Context.class).invoke(cls.newInstance(), context);
            if (invoke != null) {
                String str3 = (String) invoke;
                f4101g = str3;
                return str3;
            }
        } catch (Throwable th3) {
            ga.a(th3, "oa", "xm");
            f4102h = true;
        }
        return f4101g;
    }

    public static String b() {
        return f4112s;
    }

    public static void f() {
        B = -1;
        C = false;
        D = -1;
        E = false;
        f4119z = "";
        A = false;
        f4110p = "";
        f4111q = false;
    }

    public static void a(boolean z5) {
        f4103i = z5;
    }

    public static String a(Context context) {
        TelephonyManager telephonyManager;
        if (f4111q) {
            return f4110p;
        }
        try {
            B(context);
            telephonyManager = (TelephonyManager) context.getSystemService("phone");
        } catch (Throwable unused) {
        }
        if (telephonyManager == null) {
            return f4110p;
        }
        String networkOperator = telephonyManager.getNetworkOperator();
        if (!TextUtils.isEmpty(networkOperator) && networkOperator.length() >= 3) {
            f4110p = networkOperator.substring(3);
            f4111q = true;
            return f4110p;
        }
        f4111q = true;
        return f4110p;
    }

    public static String a() {
        if (!TextUtils.isEmpty(f4117x)) {
            return f4117x;
        }
        String property = System.getProperty("os.arch");
        f4117x = property;
        return property;
    }

    private static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Throwable unused) {
            }
        }
    }
}
