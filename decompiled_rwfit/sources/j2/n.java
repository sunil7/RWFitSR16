package j2;

import android.graphics.Matrix;
import android.graphics.PointF;
import android.view.View;
import android.view.ViewGroup;
import androidx.transition.R$id;
import java.util.HashMap;

/* loaded from: classes.dex */
public final class n extends f0 {
    public static final String[] A = {"android:changeTransform:matrix", "android:changeTransform:transforms", "android:changeTransform:parentMatrix"};
    public static final ab.g B = new ab.g(12, float[].class, "nonTranslations");
    public static final ab.g C = new ab.g(13, PointF.class, "translations");
    public static final boolean D = true;

    /* renamed from: x, reason: collision with root package name */
    public boolean f15266x;

    /* renamed from: y, reason: collision with root package name */
    public boolean f15267y;

    /* renamed from: z, reason: collision with root package name */
    public Matrix f15268z;

    public final void I(m0 m0Var) {
        View view = m0Var.f15264b;
        if (view.getVisibility() == 8) {
            return;
        }
        HashMap hashMap = m0Var.f15263a;
        hashMap.put("android:changeTransform:parent", view.getParent());
        hashMap.put("android:changeTransform:transforms", new m(view));
        Matrix matrix = view.getMatrix();
        hashMap.put("android:changeTransform:matrix", (matrix == null || matrix.isIdentity()) ? null : new Matrix(matrix));
        if (this.f15267y) {
            Matrix matrix2 = new Matrix();
            o0.f15272a.f((ViewGroup) view.getParent(), matrix2);
            matrix2.preTranslate(-r2.getScrollX(), -r2.getScrollY());
            hashMap.put("android:changeTransform:parentMatrix", matrix2);
            hashMap.put("android:changeTransform:intermediateMatrix", view.getTag(R$id.transition_transform));
            hashMap.put("android:changeTransform:intermediateParentMatrix", view.getTag(R$id.parent_matrix));
        }
    }

    @Override // j2.f0
    public final void d(m0 m0Var) {
        I(m0Var);
    }

    @Override // j2.f0
    public final void g(m0 m0Var) {
        I(m0Var);
        if (D) {
            return;
        }
        View view = m0Var.f15264b;
        ((ViewGroup) view.getParent()).startViewTransition(view);
    }

    /* JADX WARN: Code restructure failed: missing block: B:159:0x0389, code lost:
    
        if (r16.size() == r5) goto L140;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r25v0, types: [android.view.View, android.view.ViewGroup, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r6v16, types: [g9.a] */
    @Override // j2.f0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final android.animation.Animator k(android.view.ViewGroup r25, j2.m0 r26, j2.m0 r27) {
        /*
            Method dump skipped, instructions count: 1054
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: j2.n.k(android.view.ViewGroup, j2.m0, j2.m0):android.animation.Animator");
    }

    @Override // j2.f0
    public final String[] q() {
        return A;
    }
}
