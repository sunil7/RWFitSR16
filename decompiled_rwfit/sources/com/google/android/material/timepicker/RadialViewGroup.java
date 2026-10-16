package com.google.android.material.timepicker;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.android.material.R$id;
import com.google.android.material.R$layout;
import com.google.android.material.R$styleable;
import java.util.WeakHashMap;
import l1.h0;
import l1.i0;
import l1.z0;
import w0.o;

/* loaded from: classes.dex */
class RadialViewGroup extends ConstraintLayout {

    /* renamed from: s, reason: collision with root package name */
    public final g f10968s;

    /* renamed from: t, reason: collision with root package name */
    public int f10969t;

    /* renamed from: u, reason: collision with root package name */
    public final eb.h f10970u;

    public RadialViewGroup(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    @Override // android.view.ViewGroup
    public final void addView(View view, int i3, ViewGroup.LayoutParams layoutParams) {
        super.addView(view, i3, layoutParams);
        if (view.getId() == -1) {
            WeakHashMap weakHashMap = z0.f15748a;
            view.setId(i0.a());
        }
        Handler handler = getHandler();
        if (handler != null) {
            g gVar = this.f10968s;
            handler.removeCallbacks(gVar);
            handler.post(gVar);
        }
    }

    @Override // android.view.View
    public final void onFinishInflate() {
        super.onFinishInflate();
        p();
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup
    public final void onViewRemoved(View view) {
        super.onViewRemoved(view);
        Handler handler = getHandler();
        if (handler != null) {
            g gVar = this.f10968s;
            handler.removeCallbacks(gVar);
            handler.post(gVar);
        }
    }

    public final void p() {
        int childCount = getChildCount();
        int i3 = 1;
        for (int i10 = 0; i10 < childCount; i10++) {
            if ("skip".equals(getChildAt(i10).getTag())) {
                i3++;
            }
        }
        o oVar = new o();
        oVar.e(this);
        float f2 = 0.0f;
        for (int i11 = 0; i11 < childCount; i11++) {
            View childAt = getChildAt(i11);
            if (childAt.getId() != R$id.circle_center && !"skip".equals(childAt.getTag())) {
                int id2 = childAt.getId();
                int i12 = R$id.circle_center;
                int i13 = this.f10969t;
                w0.k kVar = oVar.h(id2).e;
                kVar.f19405z = i12;
                kVar.A = i13;
                kVar.B = f2;
                f2 = (360.0f / (childCount - i3)) + f2;
            }
        }
        oVar.b(this);
    }

    @Override // android.view.View
    public final void setBackgroundColor(int i3) {
        this.f10970u.l(ColorStateList.valueOf(i3));
    }

    public RadialViewGroup(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        LayoutInflater.from(context).inflate(R$layout.material_radial_view_group, this);
        eb.h hVar = new eb.h();
        this.f10970u = hVar;
        eb.j jVar = new eb.j(0.5f);
        eb.l f2 = hVar.f12505a.f12488a.f();
        f2.e = jVar;
        f2.f12532f = jVar;
        f2.f12533g = jVar;
        f2.f12534h = jVar;
        hVar.setShapeAppearanceModel(f2.a());
        this.f10970u.l(ColorStateList.valueOf(-1));
        eb.h hVar2 = this.f10970u;
        WeakHashMap weakHashMap = z0.f15748a;
        h0.q(this, hVar2);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.RadialViewGroup, i3, 0);
        this.f10969t = obtainStyledAttributes.getDimensionPixelSize(R$styleable.RadialViewGroup_materialCircleRadius, 0);
        this.f10968s = new g(this);
        obtainStyledAttributes.recycle();
    }
}
