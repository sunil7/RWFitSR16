package ab;

import android.animation.ObjectAnimator;
import com.google.android.gms.internal.mlkit_vision_common.x;
import com.google.android.material.progressindicator.LinearProgressIndicatorSpec;
import java.util.Arrays;

/* loaded from: classes.dex */
public final class r extends n {

    /* renamed from: j, reason: collision with root package name */
    public static final g f203j = new g(3, Float.class, "animationFraction");

    /* renamed from: d, reason: collision with root package name */
    public ObjectAnimator f204d;
    public final v1.a e;

    /* renamed from: f, reason: collision with root package name */
    public final LinearProgressIndicatorSpec f205f;

    /* renamed from: g, reason: collision with root package name */
    public int f206g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f207h;

    /* renamed from: i, reason: collision with root package name */
    public float f208i;

    public r(LinearProgressIndicatorSpec linearProgressIndicatorSpec) {
        super(3);
        this.f206g = 1;
        this.f205f = linearProgressIndicatorSpec;
        this.e = new v1.a();
    }

    @Override // ab.n
    public final void c() {
        ObjectAnimator objectAnimator = this.f204d;
        if (objectAnimator != null) {
            objectAnimator.cancel();
        }
    }

    @Override // ab.n
    public final void p() {
        this.f207h = true;
        this.f206g = 1;
        Arrays.fill((int[]) this.f196c, x.a(this.f205f.f153c[0], ((o) this.f194a).f191j));
    }

    @Override // ab.n
    public final void q(c cVar) {
    }

    @Override // ab.n
    public final void r() {
    }

    @Override // ab.n
    public final void t() {
        if (this.f204d == null) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, f203j, 0.0f, 1.0f);
            this.f204d = ofFloat;
            ofFloat.setDuration(333L);
            this.f204d.setInterpolator(null);
            this.f204d.setRepeatCount(-1);
            this.f204d.addListener(new q(this, 0));
        }
        this.f207h = true;
        this.f206g = 1;
        Arrays.fill((int[]) this.f196c, x.a(this.f205f.f153c[0], ((o) this.f194a).f191j));
        this.f204d.start();
    }

    @Override // ab.n
    public final void w() {
    }
}
