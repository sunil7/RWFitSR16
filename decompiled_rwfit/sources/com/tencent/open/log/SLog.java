package com.tencent.open.log;

import android.os.Environment;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.open.log.d;
import java.io.File;

/* loaded from: classes2.dex */
public class SLog implements TraceLevel {
    public static final String TAG = "openSDK_LOG";

    /* renamed from: c, reason: collision with root package name */
    private static boolean f12026c = false;
    public static SLog instance;

    /* renamed from: a, reason: collision with root package name */
    protected a f12027a;

    /* renamed from: b, reason: collision with root package name */
    private Tracer f12028b;

    private SLog() {
    }

    private void d() {
        this.f12027a = new a(new b(a(), c.f12064m, c.f12058g, c.f12059h, c.f12055c, c.f12060i, 10, c.e, c.f12065n));
    }

    public static final void e(String str, String str2) {
        getInstance().a(16, str, str2, null);
    }

    public static void flushLogs() {
        getInstance().c();
    }

    public static SLog getInstance() {
        if (instance == null) {
            synchronized (SLog.class) {
                try {
                    if (instance == null) {
                        SLog sLog = new SLog();
                        instance = sLog;
                        sLog.d();
                        f12026c = true;
                    }
                } finally {
                }
            }
        }
        return instance;
    }

    public static final void i(String str, String str2) {
        getInstance().a(4, str, str2, null);
    }

    public static void release() {
        synchronized (SLog.class) {
            try {
                getInstance().b();
                if (instance != null) {
                    instance = null;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public static final void u(String str, String str2) {
        getInstance().a(32, str, str2, null);
    }

    public static final void v(String str, String str2) {
        getInstance().a(1, str, str2, null);
    }

    public static final void w(String str, String str2) {
        getInstance().a(8, str, str2, null);
    }

    public void a(int i3, String str, String str2, Throwable th2) {
        if (f12026c) {
            String b3 = com.tencent.open.utils.g.b();
            if (!TextUtils.isEmpty(b3)) {
                String l3 = android.support.v4.media.session.e.l(b3, " SDK_VERSION:3.5.11.lite");
                if (this.f12027a == null) {
                    return;
                }
                e.f12070a.a(32, Thread.currentThread(), System.currentTimeMillis(), TAG, l3, null);
                this.f12027a.a(32, Thread.currentThread(), System.currentTimeMillis(), TAG, l3, null);
                f12026c = false;
            }
        }
        e.f12070a.a(i3, Thread.currentThread(), System.currentTimeMillis(), str, str2, th2);
        if (d.a.a(c.f12054b, i3)) {
            a aVar = this.f12027a;
            if (aVar == null) {
                return;
            } else {
                aVar.a(i3, Thread.currentThread(), System.currentTimeMillis(), str, str2, th2);
            }
        }
        Tracer tracer = this.f12028b;
        if (tracer != null) {
            try {
                tracer.a(i3, Thread.currentThread(), System.currentTimeMillis(), str, a(str2), th2);
            } catch (Exception e) {
                Log.e(str, "Exception", e);
            }
        }
    }

    public void b() {
        a aVar = this.f12027a;
        if (aVar != null) {
            aVar.a();
            this.f12027a.b();
            this.f12027a = null;
        }
    }

    public void c() {
        a aVar = this.f12027a;
        if (aVar != null) {
            aVar.a();
        }
    }

    public void setCustomLogger(Tracer tracer) {
        this.f12028b = tracer;
    }

    public static final void e(String str, String str2, Throwable th2) {
        getInstance().a(16, str, str2, th2);
    }

    public static final void i(String str, String str2, Throwable th2) {
        getInstance().a(4, str, str2, th2);
    }

    public static final void u(String str, String str2, Throwable th2) {
        getInstance().a(32, str, str2, th2);
    }

    public static final void v(String str, String str2, Throwable th2) {
        getInstance().a(1, str, str2, th2);
    }

    public static final void w(String str, String str2, Throwable th2) {
        getInstance().a(8, str, str2, th2);
    }

    public static final void d(String str, String str2) {
        getInstance().a(2, str, str2, null);
    }

    public static final void d(String str, String str2, Throwable th2) {
        getInstance().a(2, str, str2, th2);
    }

    private String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        return d.a(str) ? "xxxxxx" : str;
    }

    public static File a() {
        String str = c.f12056d;
        try {
            d.c b3 = d.b.b();
            if (b3 != null && b3.c() > c.f12057f) {
                return new File(Environment.getExternalStorageDirectory(), str);
            }
            return new File(com.tencent.open.utils.g.c(), str);
        } catch (Throwable th2) {
            e(TAG, "getLogFilePath:", th2);
            return null;
        }
    }
}
