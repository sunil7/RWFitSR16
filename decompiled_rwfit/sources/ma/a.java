package ma;

import android.view.View;
import android.view.ViewParent;
import com.google.android.gms.internal.mlkit_vision_barcode.sf;
import com.google.android.material.behavior.SwipeDismissBehavior;
import java.util.WeakHashMap;
import l1.i0;
import l1.z0;

/* loaded from: classes.dex */
public final class a extends sf {

    /* renamed from: a, reason: collision with root package name */
    public int f15996a;

    /* renamed from: b, reason: collision with root package name */
    public int f15997b = -1;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ SwipeDismissBehavior f15998c;

    public a(SwipeDismissBehavior swipeDismissBehavior) {
        this.f15998c = swipeDismissBehavior;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.sf
    public final int a(int i3, View view) {
        int width;
        int width2;
        int width3;
        WeakHashMap weakHashMap = z0.f15748a;
        boolean z5 = i0.d(view) == 1;
        int i10 = this.f15998c.f10230c;
        if (i10 == 0) {
            if (z5) {
                width = this.f15996a - view.getWidth();
                width2 = this.f15996a;
            } else {
                width = this.f15996a;
                width3 = view.getWidth();
                width2 = width3 + width;
            }
        } else if (i10 != 1) {
            width = this.f15996a - view.getWidth();
            width2 = view.getWidth() + this.f15996a;
        } else if (z5) {
            width = this.f15996a;
            width3 = view.getWidth();
            width2 = width3 + width;
        } else {
            width = this.f15996a - view.getWidth();
            width2 = this.f15996a;
        }
        return Math.min(Math.max(width, i3), width2);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.sf
    public final int b(int i3, View view) {
        return view.getTop();
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.sf
    public final int c(View view) {
        return view.getWidth();
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.sf
    public final void g(int i3, View view) {
        this.f15997b = i3;
        this.f15996a = view.getLeft();
        ViewParent parent = view.getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(true);
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.sf
    public final void h(int i3) {
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.sf
    public final void i(View view, int i3, int i10) {
        float f2 = this.f15996a;
        float width = view.getWidth();
        SwipeDismissBehavior swipeDismissBehavior = this.f15998c;
        float f10 = (width * swipeDismissBehavior.f10231d) + f2;
        float width2 = (view.getWidth() * swipeDismissBehavior.e) + this.f15996a;
        float f11 = i3;
        if (f11 <= f10) {
            view.setAlpha(1.0f);
        } else if (f11 >= width2) {
            view.setAlpha(0.0f);
        } else {
            view.setAlpha(Math.min(Math.max(0.0f, 1.0f - ((f11 - f10) / (width2 - f10))), 1.0f));
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x0050, code lost:
    
        if (java.lang.Math.abs(r9.getLeft() - r8.f15996a) >= java.lang.Math.round(r9.getWidth() * 0.5f)) goto L27;
     */
    @Override // com.google.android.gms.internal.mlkit_vision_barcode.sf
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void j(android.view.View r9, float r10, float r11) {
        /*
            r8 = this;
            r11 = -1
            r8.f15997b = r11
            int r11 = r9.getWidth()
            r0 = 0
            int r1 = (r10 > r0 ? 1 : (r10 == r0 ? 0 : -1))
            com.google.android.material.behavior.SwipeDismissBehavior r2 = r8.f15998c
            r3 = 1
            r4 = 0
            if (r1 == 0) goto L39
            java.util.WeakHashMap r5 = l1.z0.f15748a
            int r5 = l1.i0.d(r9)
            if (r5 != r3) goto L1a
            r5 = r3
            goto L1b
        L1a:
            r5 = r4
        L1b:
            int r6 = r2.f10230c
            r7 = 2
            if (r6 != r7) goto L21
            goto L52
        L21:
            if (r6 != 0) goto L2d
            if (r5 == 0) goto L2a
            int r10 = (r10 > r0 ? 1 : (r10 == r0 ? 0 : -1))
            if (r10 >= 0) goto L5e
            goto L52
        L2a:
            if (r1 <= 0) goto L5e
            goto L52
        L2d:
            if (r6 != r3) goto L5e
            if (r5 == 0) goto L34
            if (r1 <= 0) goto L5e
            goto L52
        L34:
            int r10 = (r10 > r0 ? 1 : (r10 == r0 ? 0 : -1))
            if (r10 >= 0) goto L5e
            goto L52
        L39:
            int r10 = r9.getLeft()
            int r0 = r8.f15996a
            int r10 = r10 - r0
            int r0 = r9.getWidth()
            float r0 = (float) r0
            r1 = 1056964608(0x3f000000, float:0.5)
            float r0 = r0 * r1
            int r0 = java.lang.Math.round(r0)
            int r10 = java.lang.Math.abs(r10)
            if (r10 < r0) goto L5e
        L52:
            int r10 = r9.getLeft()
            int r0 = r8.f15996a
            if (r10 >= r0) goto L5c
            int r0 = r0 - r11
            goto L61
        L5c:
            int r0 = r0 + r11
            goto L61
        L5e:
            int r0 = r8.f15996a
            r3 = r4
        L61:
            p1.d r10 = r2.f10228a
            int r11 = r9.getTop()
            boolean r10 = r10.q(r0, r11)
            if (r10 == 0) goto L77
            ia.j r10 = new ia.j
            r10.<init>(r2, r9, r3)
            java.util.WeakHashMap r11 = l1.z0.f15748a
            l1.h0.m(r9, r10)
        L77:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: ma.a.j(android.view.View, float, float):void");
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.sf
    public final boolean k(int i3, View view) {
        int i10 = this.f15997b;
        return (i10 == -1 || i10 == i3) && this.f15998c.s(view);
    }
}
