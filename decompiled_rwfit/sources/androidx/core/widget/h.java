package androidx.core.widget;

import android.content.res.Resources;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnimationUtils;
import android.widget.ListView;
import androidx.appcompat.widget.t1;

/* loaded from: classes.dex */
public final class h implements View.OnTouchListener {
    public static final int r = ViewConfiguration.getTapTimeout();

    /* renamed from: a, reason: collision with root package name */
    public final a f1961a;

    /* renamed from: b, reason: collision with root package name */
    public final AccelerateInterpolator f1962b;

    /* renamed from: c, reason: collision with root package name */
    public final ListView f1963c;

    /* renamed from: d, reason: collision with root package name */
    public androidx.activity.e f1964d;
    public final float[] e;

    /* renamed from: f, reason: collision with root package name */
    public final float[] f1965f;

    /* renamed from: g, reason: collision with root package name */
    public final int f1966g;

    /* renamed from: h, reason: collision with root package name */
    public final int f1967h;

    /* renamed from: i, reason: collision with root package name */
    public final float[] f1968i;

    /* renamed from: j, reason: collision with root package name */
    public final float[] f1969j;

    /* renamed from: k, reason: collision with root package name */
    public final float[] f1970k;

    /* renamed from: l, reason: collision with root package name */
    public boolean f1971l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f1972m;

    /* renamed from: n, reason: collision with root package name */
    public boolean f1973n;

    /* renamed from: o, reason: collision with root package name */
    public boolean f1974o;

    /* renamed from: p, reason: collision with root package name */
    public boolean f1975p;

    /* renamed from: q, reason: collision with root package name */
    public final t1 f1976q;

    public h(t1 t1Var) {
        a aVar = new a();
        aVar.e = Long.MIN_VALUE;
        aVar.f1956g = -1L;
        aVar.f1955f = 0L;
        this.f1961a = aVar;
        this.f1962b = new AccelerateInterpolator();
        float[] fArr = {0.0f, 0.0f};
        this.e = fArr;
        float[] fArr2 = {Float.MAX_VALUE, Float.MAX_VALUE};
        this.f1965f = fArr2;
        float[] fArr3 = {0.0f, 0.0f};
        this.f1968i = fArr3;
        float[] fArr4 = {0.0f, 0.0f};
        this.f1969j = fArr4;
        float[] fArr5 = {Float.MAX_VALUE, Float.MAX_VALUE};
        this.f1970k = fArr5;
        this.f1963c = t1Var;
        float f2 = Resources.getSystem().getDisplayMetrics().density;
        float f10 = ((int) ((1575.0f * f2) + 0.5f)) / 1000.0f;
        fArr5[0] = f10;
        fArr5[1] = f10;
        float f11 = ((int) ((f2 * 315.0f) + 0.5f)) / 1000.0f;
        fArr4[0] = f11;
        fArr4[1] = f11;
        this.f1966g = 1;
        fArr2[0] = Float.MAX_VALUE;
        fArr2[1] = Float.MAX_VALUE;
        fArr[0] = 0.2f;
        fArr[1] = 0.2f;
        fArr3[0] = 0.001f;
        fArr3[1] = 0.001f;
        this.f1967h = r;
        aVar.f1951a = 500;
        aVar.f1952b = 500;
        this.f1976q = t1Var;
    }

    public static float b(float f2, float f10, float f11) {
        return f2 > f11 ? f11 : f2 < f10 ? f10 : f2;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x003b A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x003c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final float a(float r4, float r5, float r6, int r7) {
        /*
            r3 = this;
            float[] r0 = r3.e
            r0 = r0[r7]
            float[] r1 = r3.f1965f
            r1 = r1[r7]
            float r0 = r0 * r5
            r2 = 0
            float r0 = b(r0, r2, r1)
            float r1 = r3.c(r4, r0)
            float r5 = r5 - r4
            float r4 = r3.c(r5, r0)
            float r4 = r4 - r1
            int r5 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            android.view.animation.AccelerateInterpolator r0 = r3.f1962b
            if (r5 >= 0) goto L25
            float r4 = -r4
            float r4 = r0.getInterpolation(r4)
            float r4 = -r4
            goto L2d
        L25:
            int r5 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            if (r5 <= 0) goto L36
            float r4 = r0.getInterpolation(r4)
        L2d:
            r5 = -1082130432(0xffffffffbf800000, float:-1.0)
            r0 = 1065353216(0x3f800000, float:1.0)
            float r4 = b(r4, r5, r0)
            goto L37
        L36:
            r4 = r2
        L37:
            int r5 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            if (r5 != 0) goto L3c
            return r2
        L3c:
            float[] r0 = r3.f1968i
            r0 = r0[r7]
            float[] r1 = r3.f1969j
            r1 = r1[r7]
            float[] r2 = r3.f1970k
            r7 = r2[r7]
            float r0 = r0 * r6
            if (r5 <= 0) goto L51
            float r4 = r4 * r0
            float r4 = b(r4, r1, r7)
            return r4
        L51:
            float r4 = -r4
            float r4 = r4 * r0
            float r4 = b(r4, r1, r7)
            float r4 = -r4
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.widget.h.a(float, float, float, int):float");
    }

    public final float c(float f2, float f10) {
        if (f10 != 0.0f) {
            int i3 = this.f1966g;
            if (i3 == 0 || i3 == 1) {
                if (f2 < f10) {
                    if (f2 >= 0.0f) {
                        return 1.0f - (f2 / f10);
                    }
                    if (this.f1974o && i3 == 1) {
                        return 1.0f;
                    }
                }
            } else if (i3 == 2 && f2 < 0.0f) {
                return f2 / (-f10);
            }
        }
        return 0.0f;
    }

    public final void d() {
        int i3 = 0;
        if (this.f1972m) {
            this.f1974o = false;
            return;
        }
        a aVar = this.f1961a;
        long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
        int i10 = (int) (currentAnimationTimeMillis - aVar.e);
        int i11 = aVar.f1952b;
        if (i10 > i11) {
            i3 = i11;
        } else if (i10 >= 0) {
            i3 = i10;
        }
        aVar.f1958i = i3;
        aVar.f1957h = aVar.a(currentAnimationTimeMillis);
        aVar.f1956g = currentAnimationTimeMillis;
    }

    public final boolean e() {
        t1 t1Var;
        int count;
        a aVar = this.f1961a;
        float f2 = aVar.f1954d;
        int abs = (int) (f2 / Math.abs(f2));
        Math.abs(aVar.f1953c);
        if (abs != 0 && (count = (t1Var = this.f1976q).getCount()) != 0) {
            int childCount = t1Var.getChildCount();
            int firstVisiblePosition = t1Var.getFirstVisiblePosition();
            int i3 = firstVisiblePosition + childCount;
            if (abs <= 0 ? !(abs >= 0 || (firstVisiblePosition <= 0 && t1Var.getChildAt(0).getTop() >= 0)) : !(i3 >= count && t1Var.getChildAt(childCount - 1).getBottom() <= t1Var.getHeight())) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x0014, code lost:
    
        if (r1 != 3) goto L29;
     */
    @Override // android.view.View.OnTouchListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean onTouch(android.view.View r8, android.view.MotionEvent r9) {
        /*
            r7 = this;
            r0 = 3
            boolean r1 = r7.f1975p
            r2 = 0
            if (r1 != 0) goto L8
            goto L7c
        L8:
            int r1 = r9.getActionMasked()
            r3 = 1
            if (r1 == 0) goto L1b
            if (r1 == r3) goto L17
            r4 = 2
            if (r1 == r4) goto L1f
            if (r1 == r0) goto L17
            goto L7c
        L17:
            r7.d()
            return r2
        L1b:
            r7.f1973n = r3
            r7.f1971l = r2
        L1f:
            float r1 = r9.getX()
            int r4 = r8.getWidth()
            float r4 = (float) r4
            android.widget.ListView r5 = r7.f1963c
            int r6 = r5.getWidth()
            float r6 = (float) r6
            float r1 = r7.a(r1, r4, r6, r2)
            float r9 = r9.getY()
            int r8 = r8.getHeight()
            float r8 = (float) r8
            int r4 = r5.getHeight()
            float r4 = (float) r4
            float r8 = r7.a(r9, r8, r4, r3)
            androidx.core.widget.a r9 = r7.f1961a
            r9.f1953c = r1
            r9.f1954d = r8
            boolean r8 = r7.f1974o
            if (r8 != 0) goto L7c
            boolean r8 = r7.e()
            if (r8 == 0) goto L7c
            androidx.activity.e r8 = r7.f1964d
            if (r8 != 0) goto L60
            androidx.activity.e r8 = new androidx.activity.e
            r8.<init>(r7, r0)
            r7.f1964d = r8
        L60:
            r7.f1974o = r3
            r7.f1972m = r3
            boolean r8 = r7.f1971l
            if (r8 != 0) goto L75
            int r8 = r7.f1967h
            if (r8 <= 0) goto L75
            androidx.activity.e r9 = r7.f1964d
            long r0 = (long) r8
            java.util.WeakHashMap r8 = l1.z0.f15748a
            l1.h0.n(r5, r9, r0)
            goto L7a
        L75:
            androidx.activity.e r8 = r7.f1964d
            r8.run()
        L7a:
            r7.f1971l = r3
        L7c:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.widget.h.onTouch(android.view.View, android.view.MotionEvent):boolean");
    }
}
