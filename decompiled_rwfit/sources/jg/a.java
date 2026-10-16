package jg;

import android.animation.ValueAnimator;
import android.graphics.PointF;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import androidx.viewpager.widget.ViewPager;
import com.example.test.utils.s0;
import ig.b;

/* loaded from: classes2.dex */
public final class a implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: a, reason: collision with root package name */
    public View f15441a;

    /* renamed from: b, reason: collision with root package name */
    public final View f15442b;

    /* renamed from: c, reason: collision with root package name */
    public View f15443c;

    /* renamed from: d, reason: collision with root package name */
    public View f15444d;
    public View e;

    /* renamed from: f, reason: collision with root package name */
    public int f15445f = 0;

    /* renamed from: g, reason: collision with root package name */
    public boolean f15446g = true;

    /* renamed from: h, reason: collision with root package name */
    public boolean f15447h = true;

    /* renamed from: i, reason: collision with root package name */
    public final s0 f15448i;

    public a(View view) {
        s0 s0Var = new s0();
        s0Var.f8756a = true;
        this.f15448i = s0Var;
        this.f15443c = view;
        this.f15442b = view;
        this.f15441a = view;
    }

    public static View c(View view, PointF pointF, View view2) {
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            PointF pointF2 = new PointF();
            for (int childCount = viewGroup.getChildCount(); childCount > 0; childCount--) {
                View childAt = viewGroup.getChildAt(childCount - 1);
                if (b.e(viewGroup, childAt, pointF.x, pointF.y, pointF2)) {
                    if (!(childAt instanceof ViewPager) && b.c(childAt)) {
                        return childAt;
                    }
                    pointF.offset(pointF2.x, pointF2.y);
                    View c9 = c(childAt, pointF, view2);
                    pointF.offset(-pointF2.x, -pointF2.y);
                    return c9;
                }
            }
        }
        return view2;
    }

    public final boolean a() {
        if (!this.f15447h) {
            return false;
        }
        s0 s0Var = this.f15448i;
        return b.a(this.f15441a, (PointF) s0Var.f8757b, s0Var.f8756a);
    }

    public final boolean b() {
        if (this.f15446g) {
            return b.b(this.f15441a, (PointF) this.f15448i.f8757b);
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x003f  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0057  */
    /* JADX WARN: Removed duplicated region for block: B:22:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0044  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0031  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void d(int r7, int r8, int r9) {
        /*
            r6 = this;
            r0 = 1
            android.view.View r1 = r6.f15442b
            r2 = 0
            r3 = 0
            r4 = -1
            if (r8 == r4) goto L21
            android.view.View r8 = r1.findViewById(r8)
            if (r8 == 0) goto L21
            if (r7 <= 0) goto L16
            float r5 = (float) r7
            r8.setTranslationY(r5)
            r8 = r0
            goto L22
        L16:
            float r5 = r8.getTranslationY()
            int r5 = (r5 > r2 ? 1 : (r5 == r2 ? 0 : -1))
            if (r5 <= 0) goto L21
            r8.setTranslationY(r2)
        L21:
            r8 = r3
        L22:
            if (r9 == r4) goto L3c
            android.view.View r9 = r1.findViewById(r9)
            if (r9 == 0) goto L3c
            if (r7 >= 0) goto L31
            float r8 = (float) r7
            r9.setTranslationY(r8)
            goto L3d
        L31:
            float r0 = r9.getTranslationY()
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 >= 0) goto L3c
            r9.setTranslationY(r2)
        L3c:
            r0 = r8
        L3d:
            if (r0 != 0) goto L44
            float r8 = (float) r7
            r1.setTranslationY(r8)
            goto L47
        L44:
            r1.setTranslationY(r2)
        L47:
            android.view.View r8 = r6.f15444d
            if (r8 == 0) goto L53
            int r9 = java.lang.Math.max(r3, r7)
            float r9 = (float) r9
            r8.setTranslationY(r9)
        L53:
            android.view.View r8 = r6.e
            if (r8 == 0) goto L5f
            int r7 = java.lang.Math.min(r3, r7)
            float r7 = (float) r7
            r8.setTranslationY(r7)
        L5f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: jg.a.d(int, int, int):void");
    }

    public final a e(int i3) {
        View view = this.f15443c;
        if (view == null || i3 == 0) {
            return null;
        }
        if ((i3 >= 0 || !view.canScrollVertically(1)) && (i3 <= 0 || !this.f15443c.canScrollVertically(-1))) {
            return null;
        }
        this.f15445f = i3;
        return this;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
        try {
            float scaleY = (intValue - this.f15445f) * this.f15443c.getScaleY();
            View view = this.f15443c;
            if (view instanceof AbsListView) {
                float f2 = b.f14432a;
                ((AbsListView) view).scrollListBy((int) scaleY);
            } else {
                view.scrollBy(0, (int) scaleY);
            }
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
        this.f15445f = intValue;
    }
}
