package t4;

import android.os.SystemClock;

/* loaded from: classes.dex */
public abstract class g {

    /* renamed from: a, reason: collision with root package name */
    public static final double f18514a = 1.0d / Math.pow(10.0d, 6.0d);

    /* renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f18515b = 0;

    public static double a(long j4) {
        return (SystemClock.elapsedRealtimeNanos() - j4) * f18514a;
    }
}
