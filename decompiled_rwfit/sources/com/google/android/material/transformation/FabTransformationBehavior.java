package com.google.android.material.transformation;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Pair;
import android.view.View;
import com.example.test.utils.y;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import ja.a;
import ja.e;
import ja.f;
import ja.g;

@Deprecated
/* loaded from: classes.dex */
public abstract class FabTransformationBehavior extends ExpandableTransformationBehavior {

    /* renamed from: c, reason: collision with root package name */
    public final Rect f10988c;

    /* renamed from: d, reason: collision with root package name */
    public final RectF f10989d;
    public final RectF e;

    /* renamed from: f, reason: collision with root package name */
    public final int[] f10990f;

    /* renamed from: g, reason: collision with root package name */
    public float f10991g;

    /* renamed from: h, reason: collision with root package name */
    public float f10992h;

    public FabTransformationBehavior() {
        this.f10988c = new Rect();
        this.f10989d = new RectF();
        this.e = new RectF();
        this.f10990f = new int[2];
    }

    public static Pair u(float f2, float f10, boolean z5, y yVar) {
        f f11;
        f f12;
        if (f2 == 0.0f || f10 == 0.0f) {
            f11 = ((e) yVar.f8773b).f("translationXLinear");
            f12 = ((e) yVar.f8773b).f("translationYLinear");
        } else if ((!z5 || f10 >= 0.0f) && (z5 || f10 <= 0.0f)) {
            f11 = ((e) yVar.f8773b).f("translationXCurveDownwards");
            f12 = ((e) yVar.f8773b).f("translationYCurveDownwards");
        } else {
            f11 = ((e) yVar.f8773b).f("translationXCurveUpwards");
            f12 = ((e) yVar.f8773b).f("translationYCurveUpwards");
        }
        return new Pair(f11, f12);
    }

    public static float x(y yVar, f fVar, float f2) {
        long j4 = fVar.f15392a;
        f f10 = ((e) yVar.f8773b).f("expansion");
        return a.a(f2, 0.0f, fVar.b().getInterpolation((((f10.f15392a + f10.f15393b) + 17) - j4) / fVar.f15393b));
    }

    @Override // com.google.android.material.transformation.ExpandableBehavior, x0.c
    public final boolean b(View view, View view2) {
        if (view.getVisibility() == 8) {
            throw new IllegalStateException("This behavior cannot be attached to a GONE view. Set the view to INVISIBLE instead.");
        }
        if (!(view2 instanceof FloatingActionButton)) {
            return false;
        }
        int expandedComponentIdHint = ((FloatingActionButton) view2).getExpandedComponentIdHint();
        return expandedComponentIdHint == 0 || expandedComponentIdHint == view.getId();
    }

    @Override // x0.c
    public final void c(x0.f fVar) {
        if (fVar.f19722h == 0) {
            fVar.f19722h = 80;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:34:0x01ab  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x02d6  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0329  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x03b7 A[LOOP:0: B:61:0x03b5->B:62:0x03b7, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:76:0x01af  */
    @Override // com.google.android.material.transformation.ExpandableTransformationBehavior
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final android.animation.AnimatorSet t(android.view.View r25, android.view.View r26, boolean r27, boolean r28) {
        /*
            Method dump skipped, instructions count: 966
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.transformation.FabTransformationBehavior.t(android.view.View, android.view.View, boolean, boolean):android.animation.AnimatorSet");
    }

    public final float v(View view, View view2, g gVar) {
        RectF rectF = this.f10989d;
        RectF rectF2 = this.e;
        y(view, rectF);
        rectF.offset(this.f10991g, this.f10992h);
        y(view2, rectF2);
        gVar.getClass();
        return (rectF2.centerX() - rectF.centerX()) + 0.0f;
    }

    public final float w(View view, View view2, g gVar) {
        RectF rectF = this.f10989d;
        RectF rectF2 = this.e;
        y(view, rectF);
        rectF.offset(this.f10991g, this.f10992h);
        y(view2, rectF2);
        gVar.getClass();
        return (rectF2.centerY() - rectF.centerY()) + 0.0f;
    }

    public final void y(View view, RectF rectF) {
        rectF.set(0.0f, 0.0f, view.getWidth(), view.getHeight());
        view.getLocationInWindow(this.f10990f);
        rectF.offsetTo(r0[0], r0[1]);
        rectF.offset((int) (-view.getTranslationX()), (int) (-view.getTranslationY()));
    }

    public abstract y z(Context context, boolean z5);

    public FabTransformationBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f10988c = new Rect();
        this.f10989d = new RectF();
        this.e = new RectF();
        this.f10990f = new int[2];
    }
}
