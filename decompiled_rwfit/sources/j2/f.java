package j2;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.TypeConverter;
import android.graphics.PointF;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.internal.mlkit_vision_barcode.kd;
import java.util.HashMap;
import java.util.WeakHashMap;
import l1.z0;

/* loaded from: classes.dex */
public final class f extends f0 {
    public static final ab.g A;
    public static final ab.g B;
    public static final ab.g C;

    /* renamed from: x, reason: collision with root package name */
    public static final String[] f15200x = {"android:changeBounds:bounds", "android:changeBounds:clip", "android:changeBounds:parent", "android:changeBounds:windowX", "android:changeBounds:windowY"};

    /* renamed from: y, reason: collision with root package name */
    public static final ab.g f15201y;

    /* renamed from: z, reason: collision with root package name */
    public static final ab.g f15202z;

    static {
        new b("boundsOrigin", PointF.class).f15183b = new Rect();
        f15201y = new ab.g(6, PointF.class, "topLeft");
        f15202z = new ab.g(7, PointF.class, "bottomRight");
        A = new ab.g(8, PointF.class, "bottomRight");
        B = new ab.g(9, PointF.class, "topLeft");
        C = new ab.g(10, PointF.class, "position");
    }

    public static void I(m0 m0Var) {
        View view = m0Var.f15264b;
        WeakHashMap weakHashMap = z0.f15748a;
        if (!l1.k0.c(view) && view.getWidth() == 0 && view.getHeight() == 0) {
            return;
        }
        HashMap hashMap = m0Var.f15263a;
        hashMap.put("android:changeBounds:bounds", new Rect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom()));
        hashMap.put("android:changeBounds:parent", m0Var.f15264b.getParent());
    }

    @Override // j2.f0
    public final void d(m0 m0Var) {
        I(m0Var);
    }

    @Override // j2.f0
    public final void g(m0 m0Var) {
        I(m0Var);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // j2.f0
    public final Animator k(ViewGroup viewGroup, m0 m0Var, m0 m0Var2) {
        int i3;
        f fVar;
        ObjectAnimator ofObject;
        if (m0Var != null && m0Var2 != null) {
            HashMap hashMap = m0Var.f15263a;
            HashMap hashMap2 = m0Var2.f15263a;
            ViewGroup viewGroup2 = (ViewGroup) hashMap.get("android:changeBounds:parent");
            ViewGroup viewGroup3 = (ViewGroup) hashMap2.get("android:changeBounds:parent");
            if (viewGroup2 != null && viewGroup3 != null) {
                Rect rect = (Rect) hashMap.get("android:changeBounds:bounds");
                Rect rect2 = (Rect) hashMap2.get("android:changeBounds:bounds");
                int i10 = rect.left;
                int i11 = rect2.left;
                int i12 = rect.top;
                int i13 = rect2.top;
                int i14 = rect.right;
                int i15 = rect2.right;
                int i16 = rect.bottom;
                int i17 = rect2.bottom;
                int i18 = i14 - i10;
                int i19 = i16 - i12;
                int i20 = i15 - i11;
                int i21 = i17 - i13;
                Rect rect3 = (Rect) hashMap.get("android:changeBounds:clip");
                Rect rect4 = (Rect) hashMap2.get("android:changeBounds:clip");
                if ((i18 == 0 || i19 == 0) && (i20 == 0 || i21 == 0)) {
                    i3 = 0;
                } else {
                    i3 = (i10 == i11 && i12 == i13) ? 0 : 1;
                    if (i14 != i15 || i16 != i17) {
                        i3++;
                    }
                }
                if ((rect3 != null && !rect3.equals(rect4)) || (rect3 == null && rect4 != null)) {
                    i3++;
                }
                if (i3 > 0) {
                    View view = m0Var2.f15264b;
                    o0.a(view, i10, i12, i14, i16);
                    if (i3 != 2) {
                        fVar = this;
                        if (i10 == i11 && i12 == i13) {
                            fVar.f15223t.getClass();
                            ofObject = ObjectAnimator.ofObject(view, A, (TypeConverter) null, hc.a.f(i14, i16, i15, i17));
                        } else {
                            fVar.f15223t.getClass();
                            ofObject = ObjectAnimator.ofObject(view, B, (TypeConverter) null, hc.a.f(i10, i12, i11, i13));
                        }
                    } else if (i18 == i20 && i19 == i21) {
                        fVar = this;
                        fVar.f15223t.getClass();
                        ofObject = ObjectAnimator.ofObject(view, C, (TypeConverter) null, hc.a.f(i10, i12, i11, i13));
                    } else {
                        fVar = this;
                        e eVar = new e();
                        eVar.e = view;
                        fVar.f15223t.getClass();
                        ObjectAnimator ofObject2 = ObjectAnimator.ofObject(eVar, f15201y, (TypeConverter) null, hc.a.f(i10, i12, i11, i13));
                        fVar.f15223t.getClass();
                        ObjectAnimator ofObject3 = ObjectAnimator.ofObject(eVar, f15202z, (TypeConverter) null, hc.a.f(i14, i16, i15, i17));
                        AnimatorSet animatorSet = new AnimatorSet();
                        animatorSet.playTogether(ofObject2, ofObject3);
                        animatorSet.addListener(new c(eVar));
                        ofObject = animatorSet;
                    }
                    if (view.getParent() instanceof ViewGroup) {
                        ViewGroup viewGroup4 = (ViewGroup) view.getParent();
                        kd.a(viewGroup4, true);
                        fVar.a(new d(viewGroup4));
                    }
                    return ofObject;
                }
            }
        }
        return null;
    }

    @Override // j2.f0
    public final String[] q() {
        return f15200x;
    }
}
