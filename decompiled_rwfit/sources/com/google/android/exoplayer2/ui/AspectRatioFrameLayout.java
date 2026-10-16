package com.google.android.exoplayer2.ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import cf.b;

/* loaded from: classes.dex */
public final class AspectRatioFrameLayout extends FrameLayout {

    /* renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ int f8901d = 0;

    /* renamed from: a, reason: collision with root package name */
    public final b f8902a;

    /* renamed from: b, reason: collision with root package name */
    public float f8903b;

    /* renamed from: c, reason: collision with root package name */
    public int f8904c;

    public AspectRatioFrameLayout(Context context) {
        this(context, null);
    }

    public int getResizeMode() {
        return this.f8904c;
    }

    @Override // android.widget.FrameLayout, android.view.View
    public final void onMeasure(int i3, int i10) {
        float f2;
        float f10;
        super.onMeasure(i3, i10);
        if (this.f8903b <= 0.0f) {
            return;
        }
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        float f11 = measuredWidth;
        float f12 = measuredHeight;
        float f13 = (this.f8903b / (f11 / f12)) - 1.0f;
        float abs = Math.abs(f13);
        b bVar = this.f8902a;
        if (abs <= 0.01f) {
            if (bVar.f3467b) {
                return;
            }
            bVar.f3467b = true;
            ((AspectRatioFrameLayout) bVar.f3468c).post(bVar);
            return;
        }
        int i11 = this.f8904c;
        if (i11 != 0) {
            if (i11 != 1) {
                if (i11 == 2) {
                    f2 = this.f8903b;
                } else if (i11 == 4) {
                    if (f13 > 0.0f) {
                        f2 = this.f8903b;
                    } else {
                        f10 = this.f8903b;
                    }
                }
                measuredWidth = (int) (f12 * f2);
            } else {
                f10 = this.f8903b;
            }
            measuredHeight = (int) (f11 / f10);
        } else if (f13 > 0.0f) {
            f10 = this.f8903b;
            measuredHeight = (int) (f11 / f10);
        } else {
            f2 = this.f8903b;
            measuredWidth = (int) (f12 * f2);
        }
        if (!bVar.f3467b) {
            bVar.f3467b = true;
            ((AspectRatioFrameLayout) bVar.f3468c).post(bVar);
        }
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(measuredWidth, 1073741824), View.MeasureSpec.makeMeasureSpec(measuredHeight, 1073741824));
    }

    public void setAspectRatio(float f2) {
        if (this.f8903b != f2) {
            this.f8903b = f2;
            requestLayout();
        }
    }

    public void setAspectRatioListener(g9.b bVar) {
    }

    public void setResizeMode(int i3) {
        if (this.f8904c != i3) {
            this.f8904c = i3;
            requestLayout();
        }
    }

    public AspectRatioFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f8904c = 0;
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R$styleable.AspectRatioFrameLayout, 0, 0);
            try {
                this.f8904c = obtainStyledAttributes.getInt(R$styleable.AspectRatioFrameLayout_resize_mode, 0);
            } finally {
                obtainStyledAttributes.recycle();
            }
        }
        this.f8902a = new b(this, 4);
    }
}
