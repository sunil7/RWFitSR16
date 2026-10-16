package ab;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import com.autonavi.amap.mapcore.AMapEngineUtils;
import com.autonavi.aps.amapapi.utils.ReportUtil;
import com.google.android.gms.internal.mlkit_vision_common.x;
import com.google.android.material.R$animator;
import com.google.android.material.progressindicator.LinearProgressIndicatorSpec;

/* loaded from: classes.dex */
public final class s extends n {

    /* renamed from: l, reason: collision with root package name */
    public static final int[] f209l = {533, 567, 850, 750};

    /* renamed from: m, reason: collision with root package name */
    public static final int[] f210m = {1267, 1000, AMapEngineUtils.ARROW_LINE_SHADOW_TEXTURE_ID, 0};

    /* renamed from: n, reason: collision with root package name */
    public static final g f211n = new g(4, Float.class, "animationFraction");

    /* renamed from: d, reason: collision with root package name */
    public ObjectAnimator f212d;
    public final Interpolator[] e;

    /* renamed from: f, reason: collision with root package name */
    public final LinearProgressIndicatorSpec f213f;

    /* renamed from: g, reason: collision with root package name */
    public int f214g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f215h;

    /* renamed from: i, reason: collision with root package name */
    public float f216i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f217j;

    /* renamed from: k, reason: collision with root package name */
    public c f218k;

    public s(Context context, LinearProgressIndicatorSpec linearProgressIndicatorSpec) {
        super(2);
        this.f214g = 0;
        this.f218k = null;
        this.f213f = linearProgressIndicatorSpec;
        this.e = new Interpolator[]{AnimationUtils.loadInterpolator(context, R$animator.linear_indeterminate_line1_head_interpolator), AnimationUtils.loadInterpolator(context, R$animator.linear_indeterminate_line1_tail_interpolator), AnimationUtils.loadInterpolator(context, R$animator.linear_indeterminate_line2_head_interpolator), AnimationUtils.loadInterpolator(context, R$animator.linear_indeterminate_line2_tail_interpolator)};
    }

    @Override // ab.n
    public final void c() {
        ObjectAnimator objectAnimator = this.f212d;
        if (objectAnimator != null) {
            objectAnimator.cancel();
        }
    }

    @Override // ab.n
    public final void p() {
        this.f214g = 0;
        int a3 = x.a(this.f213f.f153c[0], ((o) this.f194a).f191j);
        int[] iArr = (int[]) this.f196c;
        iArr[0] = a3;
        iArr[1] = a3;
    }

    @Override // ab.n
    public final void q(c cVar) {
        this.f218k = cVar;
    }

    @Override // ab.n
    public final void r() {
        if (!((o) this.f194a).isVisible()) {
            c();
        } else {
            this.f217j = true;
            this.f212d.setRepeatCount(0);
        }
    }

    @Override // ab.n
    public final void t() {
        if (this.f212d == null) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, f211n, 0.0f, 1.0f);
            this.f212d = ofFloat;
            ofFloat.setDuration(ReportUtil.BIGSHIFT_VALIDTIME);
            this.f212d.setInterpolator(null);
            this.f212d.setRepeatCount(-1);
            this.f212d.addListener(new q(this, 1));
        }
        this.f214g = 0;
        int a3 = x.a(this.f213f.f153c[0], ((o) this.f194a).f191j);
        int[] iArr = (int[]) this.f196c;
        iArr[0] = a3;
        iArr[1] = a3;
        this.f212d.start();
    }

    @Override // ab.n
    public final void w() {
        this.f218k = null;
    }
}
