package com.tencent.open.log;

import com.tencent.connect.common.Constants;
import java.io.File;

/* loaded from: classes2.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    public static int f12053a = 60;

    /* renamed from: b, reason: collision with root package name */
    public static int f12054b = 60;

    /* renamed from: c, reason: collision with root package name */
    public static String f12055c = "OpenSDK.Client.File.Tracer";

    /* renamed from: d, reason: collision with root package name */
    public static String f12056d;
    public static String e;

    /* renamed from: f, reason: collision with root package name */
    public static long f12057f;

    /* renamed from: g, reason: collision with root package name */
    public static int f12058g;

    /* renamed from: h, reason: collision with root package name */
    public static int f12059h;

    /* renamed from: i, reason: collision with root package name */
    public static int f12060i;

    /* renamed from: j, reason: collision with root package name */
    public static String f12061j;

    /* renamed from: k, reason: collision with root package name */
    public static String f12062k;

    /* renamed from: l, reason: collision with root package name */
    public static String f12063l;

    /* renamed from: m, reason: collision with root package name */
    public static int f12064m;

    /* renamed from: n, reason: collision with root package name */
    public static long f12065n;

    /* renamed from: o, reason: collision with root package name */
    public static String f12066o;

    static {
        StringBuilder sb2 = new StringBuilder("Tencent");
        String str = File.separator;
        android.support.v4.media.session.e.z(sb2, str, "msflogs", str, "com");
        android.support.v4.media.session.e.z(sb2, str, "tencent", str, "mobileqq");
        sb2.append(str);
        f12056d = sb2.toString();
        e = ".log";
        f12057f = 8388608L;
        f12058g = 262144;
        f12059h = 1024;
        f12060i = 10000;
        f12061j = "debug.file.blockcount";
        f12062k = "debug.file.keepperiod";
        f12063l = "debug.file.tracelevel";
        f12064m = 24;
        f12065n = 604800000L;
        f12066o = Constants.APP_SPECIFIC_ROOT + str + "logs";
    }
}
