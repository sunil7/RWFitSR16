package com.otaliastudios.cameraview.internal;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import com.autonavi.amap.mapcore.tools.GlMapUtil;
import com.otaliastudios.cameraview.controls.Grid;
import qf.e;

/* loaded from: classes2.dex */
public class GridLinesLayout extends View {

    /* renamed from: f, reason: collision with root package name */
    public static final int f11611f = Color.argb(GlMapUtil.DEVICE_DISPLAY_DPI_NORMAL, 255, 255, 255);

    /* renamed from: a, reason: collision with root package name */
    public Grid f11612a;

    /* renamed from: b, reason: collision with root package name */
    public int f11613b;

    /* renamed from: c, reason: collision with root package name */
    public final ColorDrawable f11614c;

    /* renamed from: d, reason: collision with root package name */
    public final ColorDrawable f11615d;
    public final float e;

    public GridLinesLayout(Context context) {
        this(context, null);
    }

    private int getLineCount() {
        int i3 = e.f17944a[this.f11612a.ordinal()];
        if (i3 == 2 || i3 == 3) {
            return 2;
        }
        return i3 != 4 ? 0 : 3;
    }

    public int getGridColor() {
        return this.f11613b;
    }

    public Grid getGridMode() {
        return this.f11612a;
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int lineCount = getLineCount();
        int i3 = 0;
        while (i3 < lineCount) {
            float lineCount2 = this.f11612a == Grid.DRAW_PHI ? i3 == 1 ? 0.38196602f : 0.618034f : (1.0f / (getLineCount() + 1)) * (i3 + 1.0f);
            canvas.translate(0.0f, getHeight() * lineCount2);
            this.f11614c.draw(canvas);
            float f2 = -lineCount2;
            canvas.translate(0.0f, getHeight() * f2);
            canvas.translate(lineCount2 * getWidth(), 0.0f);
            this.f11615d.draw(canvas);
            canvas.translate(f2 * getWidth(), 0.0f);
            i3++;
        }
    }

    @Override // android.view.View
    public final void onLayout(boolean z5, int i3, int i10, int i11, int i12) {
        super.onLayout(z5, i3, i10, i11, i12);
        ColorDrawable colorDrawable = this.f11614c;
        float f2 = this.e;
        colorDrawable.setBounds(i3, 0, i11, (int) f2);
        this.f11615d.setBounds(0, i10, (int) f2, i12);
    }

    public void setGridColor(int i3) {
        this.f11613b = i3;
        this.f11614c.setColor(i3);
        this.f11615d.setColor(i3);
        postInvalidate();
    }

    public void setGridMode(Grid grid) {
        this.f11612a = grid;
        postInvalidate();
    }

    public GridLinesLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f11613b = f11611f;
        this.f11614c = new ColorDrawable(this.f11613b);
        this.f11615d = new ColorDrawable(this.f11613b);
        this.e = TypedValue.applyDimension(1, 0.9f, context.getResources().getDisplayMetrics());
    }
}
