package androidx.recyclerview.widget;

import android.util.Log;
import android.view.animation.BaseInterpolator;

/* loaded from: classes.dex */
public final class u1 {

    /* renamed from: a, reason: collision with root package name */
    public int f2746a;

    /* renamed from: b, reason: collision with root package name */
    public int f2747b;

    /* renamed from: c, reason: collision with root package name */
    public int f2748c;

    /* renamed from: d, reason: collision with root package name */
    public int f2749d;
    public BaseInterpolator e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f2750f;

    /* renamed from: g, reason: collision with root package name */
    public int f2751g;

    public final void a(RecyclerView recyclerView) {
        int i3 = this.f2749d;
        if (i3 >= 0) {
            this.f2749d = -1;
            recyclerView.P(i3);
            this.f2750f = false;
            return;
        }
        if (!this.f2750f) {
            this.f2751g = 0;
            return;
        }
        BaseInterpolator baseInterpolator = this.e;
        if (baseInterpolator != null && this.f2748c < 1) {
            throw new IllegalStateException("If you provide an interpolator, you must set a positive duration");
        }
        int i10 = this.f2748c;
        if (i10 < 1) {
            throw new IllegalStateException("Scroll duration must be a positive number");
        }
        recyclerView.f2453d0.b(this.f2746a, this.f2747b, i10, baseInterpolator);
        int i11 = this.f2751g + 1;
        this.f2751g = i11;
        if (i11 > 10) {
            Log.e("RecyclerView", "Smooth Scroll action is being updated too frequently. Make sure you are not changing it unless necessary");
        }
        this.f2750f = false;
    }
}
