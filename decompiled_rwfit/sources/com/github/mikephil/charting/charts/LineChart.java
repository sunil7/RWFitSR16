package com.github.mikephil.charting.charts;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.util.AttributeSet;
import java.lang.ref.WeakReference;
import o7.j;
import r7.g;
import u7.h;
import u7.n;

/* loaded from: classes.dex */
public class LineChart extends BarLineChartBase<j> implements g {
    public LineChart(Context context) {
        super(context);
    }

    @Override // r7.g
    public j getLineData() {
        return (j) this.f8792b;
    }

    @Override // com.github.mikephil.charting.charts.BarLineChartBase, com.github.mikephil.charting.charts.Chart
    public final void m() {
        super.m();
        this.f8806q = new n(this, this.f8808t, this.f8807s);
    }

    @Override // com.github.mikephil.charting.charts.Chart, android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        h hVar = this.f8806q;
        if (hVar != null && (hVar instanceof n)) {
            n nVar = (n) hVar;
            Canvas canvas = nVar.f18968k;
            if (canvas != null) {
                canvas.setBitmap(null);
                nVar.f18968k = null;
            }
            WeakReference weakReference = nVar.f18967j;
            if (weakReference != null) {
                Bitmap bitmap = (Bitmap) weakReference.get();
                if (bitmap != null) {
                    bitmap.recycle();
                }
                nVar.f18967j.clear();
                nVar.f18967j = null;
            }
        }
        super.onDetachedFromWindow();
    }

    public LineChart(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public LineChart(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
    }
}
