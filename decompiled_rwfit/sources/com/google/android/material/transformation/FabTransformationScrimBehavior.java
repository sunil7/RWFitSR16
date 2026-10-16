package com.google.android.material.transformation;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.util.Property;
import android.view.MotionEvent;
import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.gms.internal.mlkit_vision_barcode.nd;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import j2.o;
import ja.f;
import java.util.ArrayList;

@Deprecated
/* loaded from: classes.dex */
public class FabTransformationScrimBehavior extends ExpandableTransformationBehavior {

    /* renamed from: c, reason: collision with root package name */
    public final f f10993c;

    /* renamed from: d, reason: collision with root package name */
    public final f f10994d;

    public FabTransformationScrimBehavior() {
        this.f10993c = new f(75L);
        this.f10994d = new f(0L);
    }

    @Override // com.google.android.material.transformation.ExpandableBehavior, x0.c
    public final boolean b(View view, View view2) {
        return view2 instanceof FloatingActionButton;
    }

    @Override // x0.c
    public final boolean r(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
        return false;
    }

    @Override // com.google.android.material.transformation.ExpandableTransformationBehavior
    public final AnimatorSet t(View view, View view2, boolean z5, boolean z6) {
        ObjectAnimator ofFloat;
        ArrayList arrayList = new ArrayList();
        new ArrayList();
        f fVar = z5 ? this.f10993c : this.f10994d;
        if (z5) {
            if (!z6) {
                view2.setAlpha(0.0f);
            }
            ofFloat = ObjectAnimator.ofFloat(view2, (Property<View, Float>) View.ALPHA, 1.0f);
        } else {
            ofFloat = ObjectAnimator.ofFloat(view2, (Property<View, Float>) View.ALPHA, 0.0f);
        }
        fVar.a(ofFloat);
        arrayList.add(ofFloat);
        AnimatorSet animatorSet = new AnimatorSet();
        nd.a(animatorSet, arrayList);
        animatorSet.addListener(new o(view2, z5));
        return animatorSet;
    }

    public FabTransformationScrimBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f10993c = new f(75L);
        this.f10994d = new f(0L);
    }
}
