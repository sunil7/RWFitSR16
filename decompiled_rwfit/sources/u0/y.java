package u0;

import android.graphics.Rect;
import android.view.animation.Interpolator;
import androidx.constraintlayout.motion.widget.MotionLayout;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class y {

    /* renamed from: a, reason: collision with root package name */
    public final int f18799a;

    /* renamed from: b, reason: collision with root package name */
    public final int f18800b;

    /* renamed from: c, reason: collision with root package name */
    public final n f18801c;

    /* renamed from: d, reason: collision with root package name */
    public final int f18802d;

    /* renamed from: f, reason: collision with root package name */
    public final androidx.camera.core.impl.e f18803f;

    /* renamed from: g, reason: collision with root package name */
    public final Interpolator f18804g;

    /* renamed from: i, reason: collision with root package name */
    public float f18806i;

    /* renamed from: j, reason: collision with root package name */
    public float f18807j;

    /* renamed from: m, reason: collision with root package name */
    public final boolean f18810m;
    public final p0.e e = new p0.e(1);

    /* renamed from: h, reason: collision with root package name */
    public boolean f18805h = false;

    /* renamed from: l, reason: collision with root package name */
    public final Rect f18809l = new Rect();

    /* renamed from: k, reason: collision with root package name */
    public long f18808k = System.nanoTime();

    public y(androidx.camera.core.impl.e eVar, n nVar, int i3, int i10, int i11, Interpolator interpolator, int i12, int i13) {
        this.f18810m = false;
        this.f18803f = eVar;
        this.f18801c = nVar;
        this.f18802d = i10;
        if (((ArrayList) eVar.f1380f) == null) {
            eVar.f1380f = new ArrayList();
        }
        ((ArrayList) eVar.f1380f).add(this);
        this.f18804g = interpolator;
        this.f18799a = i12;
        this.f18800b = i13;
        if (i11 == 3) {
            this.f18810m = true;
        }
        this.f18807j = i3 == 0 ? Float.MAX_VALUE : 1.0f / i3;
        a();
    }

    public final void a() {
        boolean z5 = this.f18805h;
        androidx.camera.core.impl.e eVar = this.f18803f;
        Interpolator interpolator = this.f18804g;
        n nVar = this.f18801c;
        int i3 = this.f18800b;
        int i10 = this.f18799a;
        if (!z5) {
            long nanoTime = System.nanoTime();
            long j4 = nanoTime - this.f18808k;
            this.f18808k = nanoTime;
            float f2 = (((float) (j4 * 1.0E-6d)) * this.f18807j) + this.f18806i;
            this.f18806i = f2;
            if (f2 >= 1.0f) {
                this.f18806i = 1.0f;
            }
            boolean e = nVar.e(interpolator == null ? this.f18806i : interpolator.getInterpolation(this.f18806i), nanoTime, nVar.f18714b, this.e);
            if (this.f18806i >= 1.0f) {
                if (i10 != -1) {
                    nVar.f18714b.setTag(i10, Long.valueOf(System.nanoTime()));
                }
                if (i3 != -1) {
                    nVar.f18714b.setTag(i3, null);
                }
                if (!this.f18810m) {
                    ((ArrayList) eVar.f1377b).add(this);
                }
            }
            if (this.f18806i < 1.0f || e) {
                ((MotionLayout) eVar.f1378c).invalidate();
                return;
            }
            return;
        }
        long nanoTime2 = System.nanoTime();
        long j10 = nanoTime2 - this.f18808k;
        this.f18808k = nanoTime2;
        float f10 = this.f18806i - (((float) (j10 * 1.0E-6d)) * this.f18807j);
        this.f18806i = f10;
        if (f10 < 0.0f) {
            this.f18806i = 0.0f;
        }
        float f11 = this.f18806i;
        if (interpolator != null) {
            f11 = interpolator.getInterpolation(f11);
        }
        boolean e10 = nVar.e(f11, nanoTime2, nVar.f18714b, this.e);
        if (this.f18806i <= 0.0f) {
            if (i10 != -1) {
                nVar.f18714b.setTag(i10, Long.valueOf(System.nanoTime()));
            }
            if (i3 != -1) {
                nVar.f18714b.setTag(i3, null);
            }
            ((ArrayList) eVar.f1377b).add(this);
        }
        if (this.f18806i > 0.0f || e10) {
            ((MotionLayout) eVar.f1378c).invalidate();
        }
    }

    public final void b() {
        this.f18805h = true;
        int i3 = this.f18802d;
        if (i3 != -1) {
            this.f18807j = i3 == 0 ? Float.MAX_VALUE : 1.0f / i3;
        }
        ((MotionLayout) this.f18803f.f1378c).invalidate();
        this.f18808k = System.nanoTime();
    }
}
