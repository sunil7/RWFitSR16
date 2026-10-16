package rg;

import io.reactivex.BackpressureStrategy;

/* loaded from: classes2.dex */
public abstract /* synthetic */ class k {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f18128a;

    static {
        int[] iArr = new int[BackpressureStrategy.values().length];
        f18128a = iArr;
        try {
            iArr[BackpressureStrategy.DROP.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            f18128a[BackpressureStrategy.LATEST.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            f18128a[BackpressureStrategy.MISSING.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            f18128a[BackpressureStrategy.ERROR.ordinal()] = 4;
        } catch (NoSuchFieldError unused4) {
        }
    }
}
