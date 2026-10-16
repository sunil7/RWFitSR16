package androidx.lifecycle;

import android.os.Handler;

/* loaded from: classes.dex */
public final class f0 implements s {

    /* renamed from: i, reason: collision with root package name */
    public static final f0 f2349i = new f0();
    public Handler e;

    /* renamed from: a, reason: collision with root package name */
    public int f2350a = 0;

    /* renamed from: b, reason: collision with root package name */
    public int f2351b = 0;

    /* renamed from: c, reason: collision with root package name */
    public boolean f2352c = true;

    /* renamed from: d, reason: collision with root package name */
    public boolean f2353d = true;

    /* renamed from: f, reason: collision with root package name */
    public final u f2354f = new u(this);

    /* renamed from: g, reason: collision with root package name */
    public final androidx.activity.e f2355g = new androidx.activity.e(this, 6);

    /* renamed from: h, reason: collision with root package name */
    public final androidx.appcompat.app.t f2356h = new androidx.appcompat.app.t(this, 4);

    public final void a() {
        int i3 = this.f2351b + 1;
        this.f2351b = i3;
        if (i3 == 1) {
            if (!this.f2352c) {
                this.e.removeCallbacks(this.f2355g);
            } else {
                this.f2354f.e(Lifecycle$Event.ON_RESUME);
                this.f2352c = false;
            }
        }
    }

    @Override // androidx.lifecycle.s
    public final n getLifecycle() {
        return this.f2354f;
    }
}
