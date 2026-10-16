package com.google.android.material.progressindicator;

import ab.d;
import ab.j;
import ab.o;
import ab.p;
import ab.r;
import ab.s;
import android.content.Context;
import android.util.AttributeSet;
import com.google.android.material.R$attr;
import com.google.android.material.R$style;
import java.util.WeakHashMap;
import l1.i0;
import l1.z0;

/* loaded from: classes.dex */
public final class LinearProgressIndicator extends BaseProgressIndicator<LinearProgressIndicatorSpec> {

    /* renamed from: m, reason: collision with root package name */
    public static final int f10720m = R$style.Widget_MaterialComponents_LinearProgressIndicator;

    public LinearProgressIndicator(Context context) {
        this(context, null);
    }

    @Override // com.google.android.material.progressindicator.BaseProgressIndicator
    public final d a(Context context, AttributeSet attributeSet) {
        return new LinearProgressIndicatorSpec(context, attributeSet);
    }

    @Override // com.google.android.material.progressindicator.BaseProgressIndicator
    public final void b(int i3) {
        d dVar = this.f10706a;
        if (dVar != null && ((LinearProgressIndicatorSpec) dVar).f10721g == 0 && isIndeterminate()) {
            return;
        }
        super.b(i3);
    }

    public int getIndeterminateAnimationType() {
        return ((LinearProgressIndicatorSpec) this.f10706a).f10721g;
    }

    public int getIndicatorDirection() {
        return ((LinearProgressIndicatorSpec) this.f10706a).f10722h;
    }

    @Override // android.view.View
    public final void onLayout(boolean z5, int i3, int i10, int i11, int i12) {
        super.onLayout(z5, i3, i10, i11, i12);
        d dVar = this.f10706a;
        LinearProgressIndicatorSpec linearProgressIndicatorSpec = (LinearProgressIndicatorSpec) dVar;
        boolean z6 = true;
        if (((LinearProgressIndicatorSpec) dVar).f10722h != 1) {
            WeakHashMap weakHashMap = z0.f15748a;
            if ((i0.d(this) != 1 || ((LinearProgressIndicatorSpec) dVar).f10722h != 2) && (i0.d(this) != 0 || ((LinearProgressIndicatorSpec) dVar).f10722h != 3)) {
                z6 = false;
            }
        }
        linearProgressIndicatorSpec.f10723i = z6;
    }

    @Override // android.widget.ProgressBar, android.view.View
    public final void onSizeChanged(int i3, int i10, int i11, int i12) {
        int paddingRight = i3 - (getPaddingRight() + getPaddingLeft());
        int paddingBottom = i10 - (getPaddingBottom() + getPaddingTop());
        o indeterminateDrawable = getIndeterminateDrawable();
        if (indeterminateDrawable != null) {
            indeterminateDrawable.setBounds(0, 0, paddingRight, paddingBottom);
        }
        j progressDrawable = getProgressDrawable();
        if (progressDrawable != null) {
            progressDrawable.setBounds(0, 0, paddingRight, paddingBottom);
        }
    }

    public void setIndeterminateAnimationType(int i3) {
        d dVar = this.f10706a;
        if (((LinearProgressIndicatorSpec) dVar).f10721g == i3) {
            return;
        }
        if (c() && isIndeterminate()) {
            throw new IllegalStateException("Cannot change indeterminate animation type while the progress indicator is show in indeterminate mode.");
        }
        ((LinearProgressIndicatorSpec) dVar).f10721g = i3;
        ((LinearProgressIndicatorSpec) dVar).a();
        if (i3 == 0) {
            o indeterminateDrawable = getIndeterminateDrawable();
            r rVar = new r((LinearProgressIndicatorSpec) dVar);
            indeterminateDrawable.f198m = rVar;
            rVar.f194a = indeterminateDrawable;
        } else {
            o indeterminateDrawable2 = getIndeterminateDrawable();
            s sVar = new s(getContext(), (LinearProgressIndicatorSpec) dVar);
            indeterminateDrawable2.f198m = sVar;
            sVar.f194a = indeterminateDrawable2;
        }
        invalidate();
    }

    @Override // com.google.android.material.progressindicator.BaseProgressIndicator
    public void setIndicatorColor(int... iArr) {
        super.setIndicatorColor(iArr);
        ((LinearProgressIndicatorSpec) this.f10706a).a();
    }

    public void setIndicatorDirection(int i3) {
        d dVar = this.f10706a;
        ((LinearProgressIndicatorSpec) dVar).f10722h = i3;
        LinearProgressIndicatorSpec linearProgressIndicatorSpec = (LinearProgressIndicatorSpec) dVar;
        boolean z5 = true;
        if (i3 != 1) {
            WeakHashMap weakHashMap = z0.f15748a;
            if ((i0.d(this) != 1 || ((LinearProgressIndicatorSpec) dVar).f10722h != 2) && (i0.d(this) != 0 || i3 != 3)) {
                z5 = false;
            }
        }
        linearProgressIndicatorSpec.f10723i = z5;
        invalidate();
    }

    @Override // com.google.android.material.progressindicator.BaseProgressIndicator
    public void setTrackCornerRadius(int i3) {
        super.setTrackCornerRadius(i3);
        ((LinearProgressIndicatorSpec) this.f10706a).a();
        invalidate();
    }

    public LinearProgressIndicator(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.linearProgressIndicatorStyle);
    }

    public LinearProgressIndicator(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3, f10720m);
        Context context2 = getContext();
        LinearProgressIndicatorSpec linearProgressIndicatorSpec = (LinearProgressIndicatorSpec) this.f10706a;
        setIndeterminateDrawable(new o(context2, linearProgressIndicatorSpec, new p(linearProgressIndicatorSpec), linearProgressIndicatorSpec.f10721g == 0 ? new r(linearProgressIndicatorSpec) : new s(context2, linearProgressIndicatorSpec)));
        setProgressDrawable(new j(getContext(), linearProgressIndicatorSpec, new p(linearProgressIndicatorSpec)));
    }
}
