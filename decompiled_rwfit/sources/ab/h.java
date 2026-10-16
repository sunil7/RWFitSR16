package ab;

import android.animation.ObjectAnimator;
import com.autonavi.base.amap.mapcore.tools.GLMapStaticValue;
import com.google.android.gms.internal.mlkit_vision_common.x;
import com.google.android.material.progressindicator.CircularProgressIndicatorSpec;

/* loaded from: classes.dex */
public final class h extends n {

    /* renamed from: l, reason: collision with root package name */
    public static final int[] f162l = {0, 1350, 2700, 4050};

    /* renamed from: m, reason: collision with root package name */
    public static final int[] f163m = {667, GLMapStaticValue.AM_PARAMETERNAME_SHOW_BUILDING_MARK, 3367, 4717};

    /* renamed from: n, reason: collision with root package name */
    public static final int[] f164n = {1000, 2350, 3700, 5050};

    /* renamed from: o, reason: collision with root package name */
    public static final g f165o = new g(0, Float.class, "animationFraction");

    /* renamed from: p, reason: collision with root package name */
    public static final g f166p = new g(1, Float.class, "completeEndFraction");

    /* renamed from: d, reason: collision with root package name */
    public ObjectAnimator f167d;
    public ObjectAnimator e;

    /* renamed from: f, reason: collision with root package name */
    public final v1.a f168f;

    /* renamed from: g, reason: collision with root package name */
    public final CircularProgressIndicatorSpec f169g;

    /* renamed from: h, reason: collision with root package name */
    public int f170h;

    /* renamed from: i, reason: collision with root package name */
    public float f171i;

    /* renamed from: j, reason: collision with root package name */
    public float f172j;

    /* renamed from: k, reason: collision with root package name */
    public c f173k;

    public h(CircularProgressIndicatorSpec circularProgressIndicatorSpec) {
        super(1);
        this.f170h = 0;
        this.f173k = null;
        this.f169g = circularProgressIndicatorSpec;
        this.f168f = new v1.a();
    }

    @Override // ab.n
    public final void c() {
        ObjectAnimator objectAnimator = this.f167d;
        if (objectAnimator != null) {
            objectAnimator.cancel();
        }
    }

    @Override // ab.n
    public final void p() {
        this.f170h = 0;
        ((int[]) this.f196c)[0] = x.a(this.f169g.f153c[0], ((o) this.f194a).f191j);
        this.f172j = 0.0f;
    }

    @Override // ab.n
    public final void q(c cVar) {
        this.f173k = cVar;
    }

    @Override // ab.n
    public final void r() {
        if (this.e.isRunning()) {
            return;
        }
        if (((o) this.f194a).isVisible()) {
            this.e.start();
        } else {
            c();
        }
    }

    @Override // ab.n
    public final void t() {
        if (this.f167d == null) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, f165o, 0.0f, 1.0f);
            this.f167d = ofFloat;
            ofFloat.setDuration(5400L);
            this.f167d.setInterpolator(null);
            this.f167d.setRepeatCount(-1);
            this.f167d.addListener(new f(this, 0));
        }
        if (this.e == null) {
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this, f166p, 0.0f, 1.0f);
            this.e = ofFloat2;
            ofFloat2.setDuration(333L);
            this.e.setInterpolator(this.f168f);
            this.e.addListener(new f(this, 1));
        }
        this.f170h = 0;
        ((int[]) this.f196c)[0] = x.a(this.f169g.f153c[0], ((o) this.f194a).f191j);
        this.f172j = 0.0f;
        this.f167d.start();
    }

    @Override // ab.n
    public final void w() {
        this.f173k = null;
    }
}
