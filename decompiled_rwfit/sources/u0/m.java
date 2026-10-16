package u0;

import android.view.animation.Interpolator;

/* loaded from: classes.dex */
public final class m implements Interpolator {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f18711a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ p0.e f18712b;

    public /* synthetic */ m(p0.e eVar, int i3) {
        this.f18711a = i3;
        this.f18712b = eVar;
    }

    @Override // android.animation.TimeInterpolator
    public final float getInterpolation(float f2) {
        switch (this.f18711a) {
        }
        return (float) this.f18712b.a(f2);
    }
}
