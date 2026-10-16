package com.amap.api.col.p0003sl;

/* loaded from: classes.dex */
public class u4 {

    /* renamed from: b, reason: collision with root package name */
    private static volatile u4 f5132b;

    /* renamed from: a, reason: collision with root package name */
    private qc f5133a;

    private u4() {
        this.f5133a = null;
        this.f5133a = x.b("AMapThreadUtil");
    }

    public static void a() {
        if (f5132b != null) {
            try {
                if (f5132b.f5133a != null) {
                    f5132b.f5133a.a();
                }
            } catch (Throwable th2) {
                th2.printStackTrace();
            }
            f5132b.f5133a = null;
            f5132b = null;
        }
    }

    public static u4 b() {
        if (f5132b == null) {
            synchronized (u4.class) {
                try {
                    if (f5132b == null) {
                        f5132b = new u4();
                    }
                } finally {
                }
            }
        }
        return f5132b;
    }

    public void a(rc rcVar) {
        try {
            this.f5133a.b(rcVar);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
