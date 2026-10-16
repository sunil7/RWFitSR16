package com.google.android.gms.internal.mlkit_vision_common;

import android.os.SystemClock;
import java.io.Closeable;
import java.util.HashMap;
import java.util.Locale;

/* loaded from: classes.dex */
public class fa implements Closeable, AutoCloseable {

    /* renamed from: f, reason: collision with root package name */
    public static final HashMap f9912f = new HashMap();

    /* renamed from: a, reason: collision with root package name */
    public int f9913a;

    /* renamed from: b, reason: collision with root package name */
    public long f9914b;

    /* renamed from: c, reason: collision with root package name */
    public long f9915c;

    /* renamed from: d, reason: collision with root package name */
    public long f9916d = 2147483647L;
    public long e = -2147483648L;

    public fa(String str) {
    }

    public void b() {
        this.f9914b = SystemClock.elapsedRealtimeNanos() / 1000;
    }

    public void c(long j4) {
        long elapsedRealtimeNanos = SystemClock.elapsedRealtimeNanos() / 1000;
        long j10 = this.f9915c;
        if (j10 != 0 && elapsedRealtimeNanos - j10 >= 1000000) {
            this.f9913a = 0;
            this.f9914b = 0L;
            this.f9916d = 2147483647L;
            this.e = -2147483648L;
        }
        this.f9915c = elapsedRealtimeNanos;
        this.f9913a++;
        this.f9916d = Math.min(this.f9916d, j4);
        this.e = Math.max(this.e, j4);
        if (this.f9913a % 50 == 0) {
            Locale locale = Locale.US;
            na.b();
        }
        if (this.f9913a % 500 == 0) {
            this.f9913a = 0;
            this.f9914b = 0L;
            this.f9916d = 2147483647L;
            this.e = -2147483648L;
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        long j4 = this.f9914b;
        if (j4 == 0) {
            throw new IllegalStateException("Did you forget to call start()?");
        }
        e(j4);
    }

    public void e(long j4) {
        c((SystemClock.elapsedRealtimeNanos() / 1000) - j4);
    }
}
