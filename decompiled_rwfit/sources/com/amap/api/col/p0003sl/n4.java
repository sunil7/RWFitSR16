package com.amap.api.col.p0003sl;

import android.content.Context;
import android.text.TextUtils;
import com.amap.api.maps.model.LatLng;
import com.autonavi.aps.amapapi.config.Const;
import java.lang.ref.WeakReference;
import java.util.Hashtable;
import java.util.Iterator;

/* loaded from: classes.dex */
public class n4 {

    /* renamed from: c, reason: collision with root package name */
    private static boolean f4692c = false;

    /* renamed from: d, reason: collision with root package name */
    private static volatile n4 f4693d;

    /* renamed from: a, reason: collision with root package name */
    private Hashtable<String, String> f4694a = new Hashtable<>();

    /* renamed from: b, reason: collision with root package name */
    private WeakReference<Context> f4695b = null;

    private n4() {
    }

    public static void a() {
        if (f4693d != null) {
            if (f4693d.f4694a != null && f4693d.f4694a.size() > 0) {
                synchronized (f4693d.f4694a) {
                    try {
                        f4693d.d();
                        if (f4693d.f4695b != null) {
                            f4693d.f4695b.clear();
                        }
                    } finally {
                    }
                }
            }
            f4693d = null;
        }
        f4692c = false;
    }

    public static n4 b() {
        if (f4693d == null) {
            synchronized (n4.class) {
                try {
                    if (f4693d == null) {
                        f4693d = new n4();
                    }
                } finally {
                }
            }
        }
        return f4693d;
    }

    public static boolean c() {
        return f4692c;
    }

    private void d() {
        WeakReference<Context> weakReference;
        if (!f4692c) {
            this.f4694a.clear();
            return;
        }
        if (this.f4694a != null) {
            StringBuffer stringBuffer = new StringBuffer();
            int size = this.f4694a.size();
            if (size > 0) {
                stringBuffer.append("[");
                Iterator<String> it = this.f4694a.values().iterator();
                int i3 = 0;
                while (it.hasNext()) {
                    i3++;
                    stringBuffer.append(it.next());
                    if (i3 < size) {
                        stringBuffer.append(Const.STR_MART_COMMA);
                    }
                }
                stringBuffer.append("]");
                String stringBuffer2 = stringBuffer.toString();
                if (!TextUtils.isEmpty(stringBuffer2) && (weakReference = this.f4695b) != null && weakReference.get() != null) {
                    wb.a(stringBuffer2, this.f4695b.get());
                }
            }
            this.f4694a.clear();
        }
    }

    public static void a(boolean z5) {
        f4692c = z5;
    }

    public void a(Context context) {
        if (context != null) {
            this.f4695b = new WeakReference<>(context);
        }
    }

    public void a(LatLng latLng, String str, String str2) {
        Hashtable<String, String> hashtable;
        if (!f4692c) {
            this.f4694a.clear();
            return;
        }
        if (latLng == null || TextUtils.isEmpty(str)) {
            return;
        }
        StringBuffer stringBuffer = new StringBuffer("{\"lon\":");
        stringBuffer.append(latLng.longitude);
        stringBuffer.append(",\"lat\":");
        stringBuffer.append(latLng.latitude);
        stringBuffer.append(",\"title\":\"");
        stringBuffer.append(str);
        stringBuffer.append("\",\"snippet\":\"");
        if (TextUtils.isEmpty(str2)) {
            str2 = "";
        }
        stringBuffer.append(str2);
        stringBuffer.append("\"}");
        String stringBuffer2 = stringBuffer.toString();
        if (stringBuffer2 == null || (hashtable = this.f4694a) == null) {
            return;
        }
        synchronized (hashtable) {
            try {
                String c9 = e9.c(stringBuffer2);
                Hashtable<String, String> hashtable2 = this.f4694a;
                if (hashtable2 != null && !hashtable2.contains(c9)) {
                    this.f4694a.put(c9, stringBuffer2);
                }
                Hashtable<String, String> hashtable3 = this.f4694a;
                if (hashtable3 != null && hashtable3.size() > 20) {
                    d();
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }
}
