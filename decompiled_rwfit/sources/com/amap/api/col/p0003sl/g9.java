package com.amap.api.col.p0003sl;

import android.content.Context;
import android.text.TextUtils;
import java.io.InputStream;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes.dex */
public class g9 {

    /* renamed from: a, reason: collision with root package name */
    public static g9 f4207a;

    /* renamed from: b, reason: collision with root package name */
    private static final ConcurrentHashMap<Integer, String> f4208b = new ConcurrentHashMap<>();

    /* renamed from: c, reason: collision with root package name */
    private static volatile boolean f4209c = false;

    private g9(Context context) {
        if (f4209c) {
            return;
        }
        synchronized (g9.class) {
            f4208b.clear();
            try {
                a(context);
                f4209c = true;
            } catch (Exception e) {
                ka.a(e, "DynamicHostManager", "Init error)");
            }
        }
        a(context);
    }

    public static g9 b(Context context) {
        if (f4207a == null) {
            f4207a = new g9(context);
        }
        return f4207a;
    }

    public String a(int i3) {
        ConcurrentHashMap<Integer, String> concurrentHashMap = f4208b;
        if (concurrentHashMap.isEmpty()) {
            return null;
        }
        return concurrentHashMap.get(Integer.valueOf(i3));
    }

    private static void a(Context context) {
        String str;
        if (context == null) {
            return;
        }
        try {
            try {
                InputStream open = context.getAssets().open(b9.c() ? "Localizable/servers/oversea/Localizable.url" : "Localizable/servers/Localizable.url");
                byte[] bArr = new byte[open.available()];
                open.read(bArr);
                str = new String(bArr, "UTF-8");
            } catch (Exception e) {
                ka.a(e, "DynamicHostManager", "readAssetsFile error)");
                str = null;
            }
            for (String str2 : str.split("\";")) {
                if (str2.length() > 0) {
                    int indexOf = str2.indexOf("\"");
                    int indexOf2 = str2.indexOf("\"=\"");
                    if (indexOf >= 0 && indexOf2 >= 0) {
                        String substring = str2.substring(indexOf + 1, indexOf2);
                        String substring2 = str2.substring(indexOf2 + 3);
                        if (!TextUtils.isEmpty(substring) && !TextUtils.isEmpty(substring2)) {
                            f4208b.put(Integer.valueOf(Integer.parseInt(substring)), substring2);
                        }
                    }
                }
            }
        } catch (Exception e10) {
            ka.a(e10, "DynamicHostManager", "preloadConfigData error)");
        }
    }
}
