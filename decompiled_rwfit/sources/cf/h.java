package cf;

import android.content.Context;
import android.view.ViewConfiguration;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;

/* loaded from: classes2.dex */
public final class h {

    /* renamed from: x, reason: collision with root package name */
    public static final float f3475x = (float) (Math.log(0.78d) / Math.log(0.9d));

    /* renamed from: y, reason: collision with root package name */
    public static final float[] f3476y = new float[101];

    /* renamed from: z, reason: collision with root package name */
    public static final float[] f3477z = new float[101];

    /* renamed from: a, reason: collision with root package name */
    public final Interpolator f3478a;

    /* renamed from: b, reason: collision with root package name */
    public int f3479b;

    /* renamed from: c, reason: collision with root package name */
    public int f3480c;

    /* renamed from: d, reason: collision with root package name */
    public int f3481d;
    public int e;

    /* renamed from: f, reason: collision with root package name */
    public int f3482f;

    /* renamed from: g, reason: collision with root package name */
    public int f3483g;

    /* renamed from: h, reason: collision with root package name */
    public int f3484h;

    /* renamed from: i, reason: collision with root package name */
    public int f3485i;

    /* renamed from: j, reason: collision with root package name */
    public int f3486j;

    /* renamed from: k, reason: collision with root package name */
    public long f3487k;

    /* renamed from: l, reason: collision with root package name */
    public int f3488l;

    /* renamed from: m, reason: collision with root package name */
    public float f3489m;

    /* renamed from: n, reason: collision with root package name */
    public float f3490n;

    /* renamed from: o, reason: collision with root package name */
    public float f3491o;

    /* renamed from: q, reason: collision with root package name */
    public final boolean f3493q;
    public float r;

    /* renamed from: s, reason: collision with root package name */
    public float f3494s;

    /* renamed from: t, reason: collision with root package name */
    public int f3495t;

    /* renamed from: v, reason: collision with root package name */
    public final float f3497v;

    /* renamed from: w, reason: collision with root package name */
    public final float f3498w;

    /* renamed from: u, reason: collision with root package name */
    public final float f3496u = ViewConfiguration.getScrollFriction();

    /* renamed from: p, reason: collision with root package name */
    public boolean f3492p = true;

    static {
        float f2;
        float f10;
        float f11;
        float f12;
        float f13;
        float f14;
        float f15;
        float f16;
        float f17;
        float f18;
        float f19 = 0.0f;
        int i3 = 0;
        float f20 = 0.0f;
        while (true) {
            float f21 = 1.0f;
            if (i3 >= 100) {
                float[] fArr = f3476y;
                f3477z[100] = 1.0f;
                fArr[100] = 1.0f;
                return;
            }
            float f22 = i3 / 100.0f;
            float f23 = 1.0f;
            while (true) {
                f2 = ((f23 - f19) / 2.0f) + f19;
                f10 = f21 - f2;
                f11 = f2 * 3.0f * f10;
                f12 = f2 * f2 * f2;
                float f24 = (((f2 * 0.35000002f) + (f10 * 0.175f)) * f11) + f12;
                f13 = f21;
                f14 = f22;
                if (Math.abs(f24 - f22) < 1.0E-5d) {
                    break;
                }
                if (f24 > f14) {
                    f23 = f2;
                } else {
                    f19 = f2;
                }
                f21 = f13;
                f22 = f14;
            }
            f3476y[i3] = (((f10 * 0.5f) + f2) * f11) + f12;
            float f25 = f13;
            while (true) {
                f15 = ((f25 - f20) / 2.0f) + f20;
                f16 = f13 - f15;
                f17 = f15 * 3.0f * f16;
                f18 = f15 * f15 * f15;
                float f26 = (((f16 * 0.5f) + f15) * f17) + f18;
                if (Math.abs(f26 - f14) < 1.0E-5d) {
                    break;
                } else if (f26 > f14) {
                    f25 = f15;
                } else {
                    f20 = f15;
                }
            }
            f3477z[i3] = (((f15 * 0.35000002f) + (f16 * 0.175f)) * f17) + f18;
            i3++;
        }
    }

    public h(Context context, DecelerateInterpolator decelerateInterpolator, boolean z5) {
        if (decelerateInterpolator == null) {
            this.f3478a = new g();
        } else {
            this.f3478a = decelerateInterpolator;
        }
        float f2 = context.getResources().getDisplayMetrics().density * 160.0f;
        this.f3497v = f2 * 386.0878f * ViewConfiguration.getScrollFriction();
        this.f3493q = z5;
        this.f3498w = f2 * 386.0878f * 0.84f;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x00b0  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x00b7  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00b2  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void a(int r18, int r19, int r20, int r21, int r22, int r23) {
        /*
            Method dump skipped, instructions count: 282
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: cf.h.a(int, int, int, int, int, int):void");
    }

    public final void b(int i3, int i10, int i11) {
        this.f3479b = 0;
        this.f3492p = false;
        this.f3488l = i11;
        this.f3487k = AnimationUtils.currentAnimationTimeMillis();
        this.f3480c = 0;
        this.f3481d = 0;
        this.e = i3;
        this.f3482f = i10;
        this.f3490n = i3;
        this.f3491o = i10;
        this.f3489m = 1.0f / this.f3488l;
    }
}
