package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import java.util.HashMap;
import w0.e;
import w0.j;
import w0.k;
import w0.o;
import w0.p;

/* loaded from: classes.dex */
public class Constraints extends ViewGroup {

    /* renamed from: a, reason: collision with root package name */
    public o f1872a;

    public Constraints(Context context) {
        super(context);
        super.setVisibility(8);
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new p();
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        Context context = getContext();
        p pVar = new p(context, attributeSet);
        pVar.f19445q0 = 1.0f;
        pVar.f19446r0 = false;
        pVar.f19447s0 = 0.0f;
        pVar.f19448t0 = 0.0f;
        pVar.f19449u0 = 0.0f;
        pVar.f19450v0 = 0.0f;
        pVar.f19451w0 = 1.0f;
        pVar.f19452x0 = 1.0f;
        pVar.f19453y0 = 0.0f;
        pVar.f19454z0 = 0.0f;
        pVar.A0 = 0.0f;
        pVar.B0 = 0.0f;
        pVar.C0 = 0.0f;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.ConstraintSet);
        int indexCount = obtainStyledAttributes.getIndexCount();
        for (int i3 = 0; i3 < indexCount; i3++) {
            int index = obtainStyledAttributes.getIndex(i3);
            if (index == R$styleable.ConstraintSet_android_alpha) {
                pVar.f19445q0 = obtainStyledAttributes.getFloat(index, pVar.f19445q0);
            } else if (index == R$styleable.ConstraintSet_android_elevation) {
                pVar.f19447s0 = obtainStyledAttributes.getFloat(index, pVar.f19447s0);
                pVar.f19446r0 = true;
            } else if (index == R$styleable.ConstraintSet_android_rotationX) {
                pVar.f19449u0 = obtainStyledAttributes.getFloat(index, pVar.f19449u0);
            } else if (index == R$styleable.ConstraintSet_android_rotationY) {
                pVar.f19450v0 = obtainStyledAttributes.getFloat(index, pVar.f19450v0);
            } else if (index == R$styleable.ConstraintSet_android_rotation) {
                pVar.f19448t0 = obtainStyledAttributes.getFloat(index, pVar.f19448t0);
            } else if (index == R$styleable.ConstraintSet_android_scaleX) {
                pVar.f19451w0 = obtainStyledAttributes.getFloat(index, pVar.f19451w0);
            } else if (index == R$styleable.ConstraintSet_android_scaleY) {
                pVar.f19452x0 = obtainStyledAttributes.getFloat(index, pVar.f19452x0);
            } else if (index == R$styleable.ConstraintSet_android_transformPivotX) {
                pVar.f19453y0 = obtainStyledAttributes.getFloat(index, pVar.f19453y0);
            } else if (index == R$styleable.ConstraintSet_android_transformPivotY) {
                pVar.f19454z0 = obtainStyledAttributes.getFloat(index, pVar.f19454z0);
            } else if (index == R$styleable.ConstraintSet_android_translationX) {
                pVar.A0 = obtainStyledAttributes.getFloat(index, pVar.A0);
            } else if (index == R$styleable.ConstraintSet_android_translationY) {
                pVar.B0 = obtainStyledAttributes.getFloat(index, pVar.B0);
            } else if (index == R$styleable.ConstraintSet_android_translationZ) {
                pVar.C0 = obtainStyledAttributes.getFloat(index, pVar.C0);
            }
        }
        obtainStyledAttributes.recycle();
        return pVar;
    }

    public o getConstraintSet() {
        if (this.f1872a == null) {
            this.f1872a = new o();
        }
        o oVar = this.f1872a;
        oVar.getClass();
        int childCount = getChildCount();
        HashMap hashMap = oVar.f19444f;
        hashMap.clear();
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = getChildAt(i3);
            p pVar = (p) childAt.getLayoutParams();
            int id2 = childAt.getId();
            if (oVar.e && id2 == -1) {
                throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
            }
            if (!hashMap.containsKey(Integer.valueOf(id2))) {
                hashMap.put(Integer.valueOf(id2), new j());
            }
            j jVar = (j) hashMap.get(Integer.valueOf(id2));
            if (jVar != null) {
                if (childAt instanceof ConstraintHelper) {
                    ConstraintHelper constraintHelper = (ConstraintHelper) childAt;
                    jVar.d(id2, pVar);
                    if (constraintHelper instanceof Barrier) {
                        k kVar = jVar.e;
                        kVar.f19382h0 = 1;
                        Barrier barrier = (Barrier) constraintHelper;
                        kVar.f19378f0 = barrier.getType();
                        kVar.i0 = barrier.getReferencedIds();
                        kVar.f19380g0 = barrier.getMargin();
                    }
                }
                jVar.d(id2, pVar);
            }
        }
        return this.f1872a;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z5, int i3, int i10, int i11, int i12) {
    }

    public Constraints(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Log.v("Constraints", " ################# init");
        super.setVisibility(8);
    }

    public Constraints(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Log.v("Constraints", " ################# init");
        super.setVisibility(8);
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new e(layoutParams);
    }
}
