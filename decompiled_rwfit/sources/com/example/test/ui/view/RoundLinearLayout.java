package com.example.test.ui.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.PaintFlagsDrawFilter;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Region;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import com.example.test.R$styleable;

/* loaded from: classes.dex */
public class RoundLinearLayout extends LinearLayout {

    /* renamed from: a, reason: collision with root package name */
    public final Path f8546a;

    /* renamed from: b, reason: collision with root package name */
    public final float f8547b;

    public RoundLinearLayout(Context context) {
        this(context, null);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchDraw(Canvas canvas) {
        Path path = this.f8546a;
        path.reset();
        RectF rectF = new RectF(0.0f, 0.0f, getMeasuredWidth(), getMeasuredHeight());
        float f2 = this.f8547b;
        path.addRoundRect(rectF, f2, f2, Path.Direction.CW);
        canvas.setDrawFilter(new PaintFlagsDrawFilter(0, 3));
        canvas.clipPath(path, Region.Op.INTERSECT);
        super.dispatchDraw(canvas);
    }

    public RoundLinearLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RoundLinearLayout(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f8547b = 20.0f;
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.RoundRelativeLayout);
            this.f8547b = obtainStyledAttributes.getDimension(R$styleable.RoundRelativeLayout_radius, 20.0f);
            obtainStyledAttributes.recycle();
        }
        this.f8546a = new Path();
    }
}
