package j7;

import com.google.android.gms.internal.mlkit_vision_barcode.l0;

/* loaded from: classes.dex */
public final class k implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final float f15339a;

    /* renamed from: b, reason: collision with root package name */
    public final float f15340b;

    /* renamed from: c, reason: collision with root package name */
    public final long f15341c = System.currentTimeMillis();

    /* renamed from: d, reason: collision with root package name */
    public final float f15342d;
    public final float e;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ m f15343f;

    public k(m mVar, float f2, float f10, float f11, float f12) {
        this.f15343f = mVar;
        this.f15339a = f11;
        this.f15340b = f12;
        this.f15342d = f2;
        this.e = f10;
    }

    @Override // java.lang.Runnable
    public final void run() {
        m mVar = this.f15343f;
        float interpolation = mVar.f15348a.getInterpolation(Math.min(1.0f, ((System.currentTimeMillis() - this.f15341c) * 1.0f) / mVar.f15349b));
        float f2 = this.e;
        float f10 = this.f15342d;
        mVar.f15367v.t(l0.a(f2, f10, interpolation, f10) / mVar.d(), this.f15339a, this.f15340b);
        if (interpolation < 1.0f) {
            mVar.f15354h.postOnAnimation(this);
        }
    }
}
