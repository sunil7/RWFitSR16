package net.zetetic.database.sqlcipher;

import android.util.Log;

/* loaded from: classes2.dex */
public final class SQLiteDebug {

    /* renamed from: a, reason: collision with root package name */
    public static final boolean f16561a;

    /* renamed from: b, reason: collision with root package name */
    public static final boolean f16562b;

    public static class DbStats {
        public DbStats(String str, long j4, long j10, int i3, int i10, int i11, int i12) {
        }
    }

    public static class PagerStats {
        public int largestMemAlloc;
        public int memoryUsed;
        public int pageCacheOverflow;
    }

    static {
        Log.isLoggable("SQLiteLog", 2);
        f16561a = Log.isLoggable("SQLiteStatements", 2);
        f16562b = Log.isLoggable("SQLiteTime", 2);
    }

    private static native void nativeGetPagerStats(PagerStats pagerStats);
}
