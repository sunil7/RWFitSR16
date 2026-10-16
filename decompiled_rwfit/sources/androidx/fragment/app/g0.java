package androidx.fragment.app;

import android.os.Handler;

/* loaded from: classes.dex */
public abstract class g0 extends f0 {

    /* renamed from: a, reason: collision with root package name */
    public final FragmentActivity f2181a;

    /* renamed from: b, reason: collision with root package name */
    public final FragmentActivity f2182b;

    /* renamed from: c, reason: collision with root package name */
    public final Handler f2183c;

    /* renamed from: d, reason: collision with root package name */
    public final u0 f2184d;

    public g0(FragmentActivity fragmentActivity) {
        Handler handler = new Handler();
        this.f2184d = new u0();
        this.f2181a = fragmentActivity;
        this.f2182b = fragmentActivity;
        this.f2183c = handler;
    }
}
