package j2;

import android.animation.ObjectAnimator;
import android.view.View;
import java.util.HashMap;

/* loaded from: classes.dex */
public final class p extends f0 {

    /* renamed from: y, reason: collision with root package name */
    public static final String[] f15274y = {"android:visibility:visibility", "android:visibility:parent"};

    /* renamed from: x, reason: collision with root package name */
    public final int f15275x;

    public p(int i3) {
        this.f15275x = i3;
    }

    public static void I(m0 m0Var) {
        int visibility = m0Var.f15264b.getVisibility();
        HashMap hashMap = m0Var.f15263a;
        hashMap.put("android:visibility:visibility", Integer.valueOf(visibility));
        View view = m0Var.f15264b;
        hashMap.put("android:visibility:parent", view.getParent());
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        hashMap.put("android:visibility:screenLocation", iArr);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0059 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0097  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0035  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static j2.t0 K(j2.m0 r8, j2.m0 r9) {
        /*
            j2.t0 r0 = new j2.t0
            r0.<init>()
            r1 = 0
            r0.f15299a = r1
            r0.f15300b = r1
            r2 = 0
            r3 = -1
            java.lang.String r4 = "android:visibility:parent"
            java.lang.String r5 = "android:visibility:visibility"
            if (r8 == 0) goto L2f
            java.util.HashMap r6 = r8.f15263a
            boolean r7 = r6.containsKey(r5)
            if (r7 == 0) goto L2f
            java.lang.Object r7 = r6.get(r5)
            java.lang.Integer r7 = (java.lang.Integer) r7
            int r7 = r7.intValue()
            r0.f15301c = r7
            java.lang.Object r6 = r6.get(r4)
            android.view.ViewGroup r6 = (android.view.ViewGroup) r6
            r0.e = r6
            goto L33
        L2f:
            r0.f15301c = r3
            r0.e = r2
        L33:
            if (r9 == 0) goto L52
            java.util.HashMap r6 = r9.f15263a
            boolean r7 = r6.containsKey(r5)
            if (r7 == 0) goto L52
            java.lang.Object r2 = r6.get(r5)
            java.lang.Integer r2 = (java.lang.Integer) r2
            int r2 = r2.intValue()
            r0.f15302d = r2
            java.lang.Object r2 = r6.get(r4)
            android.view.ViewGroup r2 = (android.view.ViewGroup) r2
            r0.f15303f = r2
            goto L56
        L52:
            r0.f15302d = r3
            r0.f15303f = r2
        L56:
            r2 = 1
            if (r8 == 0) goto L8a
            if (r9 == 0) goto L8a
            int r8 = r0.f15301c
            int r9 = r0.f15302d
            if (r8 != r9) goto L68
            android.view.ViewGroup r3 = r0.e
            android.view.ViewGroup r4 = r0.f15303f
            if (r3 != r4) goto L68
            goto L9f
        L68:
            if (r8 == r9) goto L78
            if (r8 != 0) goto L71
            r0.f15300b = r1
            r0.f15299a = r2
            return r0
        L71:
            if (r9 != 0) goto L9f
            r0.f15300b = r2
            r0.f15299a = r2
            return r0
        L78:
            android.view.ViewGroup r8 = r0.f15303f
            if (r8 != 0) goto L81
            r0.f15300b = r1
            r0.f15299a = r2
            return r0
        L81:
            android.view.ViewGroup r8 = r0.e
            if (r8 != 0) goto L9f
            r0.f15300b = r2
            r0.f15299a = r2
            return r0
        L8a:
            if (r8 != 0) goto L95
            int r8 = r0.f15302d
            if (r8 != 0) goto L95
            r0.f15300b = r2
            r0.f15299a = r2
            return r0
        L95:
            if (r9 != 0) goto L9f
            int r8 = r0.f15301c
            if (r8 != 0) goto L9f
            r0.f15300b = r1
            r0.f15299a = r2
        L9f:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: j2.p.K(j2.m0, j2.m0):j2.t0");
    }

    public final ObjectAnimator J(View view, float f2, float f10) {
        int i3 = 1;
        if (f2 == f10) {
            return null;
        }
        o0.b(view, f2);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, o0.f15273b, f10);
        ofFloat.addListener(new o(view));
        a(new com.dh.imagepick.preview.utils.c(view, i3));
        return ofFloat;
    }

    @Override // j2.f0
    public final void d(m0 m0Var) {
        I(m0Var);
    }

    @Override // j2.f0
    public final void g(m0 m0Var) {
        I(m0Var);
        m0Var.f15263a.put("android:fade:transitionAlpha", Float.valueOf(o0.f15272a.a(m0Var.f15264b)));
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x004a, code lost:
    
        if (K(o(r3, false), r(r3, false)).f15299a != false) goto L9;
     */
    /* JADX WARN: Removed duplicated region for block: B:74:0x00b0  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0208  */
    @Override // j2.f0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final android.animation.Animator k(android.view.ViewGroup r24, j2.m0 r25, j2.m0 r26) {
        /*
            Method dump skipped, instructions count: 766
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: j2.p.k(android.view.ViewGroup, j2.m0, j2.m0):android.animation.Animator");
    }

    @Override // j2.f0
    public final String[] q() {
        return f15274y;
    }

    @Override // j2.f0
    public final boolean s(m0 m0Var, m0 m0Var2) {
        if (m0Var == null && m0Var2 == null) {
            return false;
        }
        if (m0Var != null && m0Var2 != null && m0Var2.f15263a.containsKey("android:visibility:visibility") != m0Var.f15263a.containsKey("android:visibility:visibility")) {
            return false;
        }
        t0 K = K(m0Var, m0Var2);
        if (K.f15299a) {
            return K.f15301c == 0 || K.f15302d == 0;
        }
        return false;
    }
}
