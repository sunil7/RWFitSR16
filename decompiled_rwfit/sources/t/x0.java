package t;

import com.google.android.gms.internal.mlkit_vision_barcode.pd;

/* loaded from: classes.dex */
public final class x0 {

    /* renamed from: d, reason: collision with root package name */
    public static final x0 f18425d = new x0(false, 0, false);
    public static final x0 e = new x0(true, 500, false);

    /* renamed from: f, reason: collision with root package name */
    public static final x0 f18426f;

    /* renamed from: a, reason: collision with root package name */
    public final long f18427a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f18428b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f18429c;

    static {
        new x0(true, 100L, false);
        f18426f = new x0(false, 0L, true);
    }

    public x0(boolean z5, long j4, boolean z6) {
        this.f18428b = z5;
        this.f18427a = j4;
        if (z6) {
            pd.a("shouldRetry must be false when completeWithoutFailure is set to true", !z5);
        }
        this.f18429c = z6;
    }
}
