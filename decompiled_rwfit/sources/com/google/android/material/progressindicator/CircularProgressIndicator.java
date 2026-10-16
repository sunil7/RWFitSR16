package com.google.android.material.progressindicator;

import ab.d;
import ab.e;
import ab.h;
import ab.j;
import ab.o;
import android.content.Context;
import android.util.AttributeSet;
import com.google.android.material.R$attr;
import com.google.android.material.R$style;

/* loaded from: classes.dex */
public final class CircularProgressIndicator extends BaseProgressIndicator<CircularProgressIndicatorSpec> {

    /* renamed from: m, reason: collision with root package name */
    public static final int f10716m = R$style.Widget_MaterialComponents_CircularProgressIndicator;

    public CircularProgressIndicator(Context context) {
        this(context, null);
    }

    @Override // com.google.android.material.progressindicator.BaseProgressIndicator
    public final d a(Context context, AttributeSet attributeSet) {
        return new CircularProgressIndicatorSpec(context, attributeSet);
    }

    public int getIndicatorDirection() {
        return ((CircularProgressIndicatorSpec) this.f10706a).f10719i;
    }

    public int getIndicatorInset() {
        return ((CircularProgressIndicatorSpec) this.f10706a).f10718h;
    }

    public int getIndicatorSize() {
        return ((CircularProgressIndicatorSpec) this.f10706a).f10717g;
    }

    public void setIndicatorDirection(int i3) {
        ((CircularProgressIndicatorSpec) this.f10706a).f10719i = i3;
        invalidate();
    }

    public void setIndicatorInset(int i3) {
        d dVar = this.f10706a;
        if (((CircularProgressIndicatorSpec) dVar).f10718h != i3) {
            ((CircularProgressIndicatorSpec) dVar).f10718h = i3;
            invalidate();
        }
    }

    public void setIndicatorSize(int i3) {
        int max = Math.max(i3, getTrackThickness() * 2);
        d dVar = this.f10706a;
        if (((CircularProgressIndicatorSpec) dVar).f10717g != max) {
            ((CircularProgressIndicatorSpec) dVar).f10717g = max;
            ((CircularProgressIndicatorSpec) dVar).getClass();
            invalidate();
        }
    }

    @Override // com.google.android.material.progressindicator.BaseProgressIndicator
    public void setTrackThickness(int i3) {
        super.setTrackThickness(i3);
        ((CircularProgressIndicatorSpec) this.f10706a).getClass();
    }

    public CircularProgressIndicator(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.circularProgressIndicatorStyle);
    }

    public CircularProgressIndicator(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3, f10716m);
        Context context2 = getContext();
        CircularProgressIndicatorSpec circularProgressIndicatorSpec = (CircularProgressIndicatorSpec) this.f10706a;
        setIndeterminateDrawable(new o(context2, circularProgressIndicatorSpec, new e(circularProgressIndicatorSpec), new h(circularProgressIndicatorSpec)));
        setProgressDrawable(new j(getContext(), circularProgressIndicatorSpec, new e(circularProgressIndicatorSpec)));
    }
}
