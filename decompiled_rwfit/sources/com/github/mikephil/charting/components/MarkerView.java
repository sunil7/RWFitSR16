package com.github.mikephil.charting.components;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import com.github.mikephil.charting.charts.Chart;
import com.github.mikephil.charting.data.Entry;
import java.lang.ref.WeakReference;
import n7.d;
import q7.c;

/* loaded from: classes.dex */
public class MarkerView extends RelativeLayout implements d {

    /* renamed from: a, reason: collision with root package name */
    public v7.d f8822a;

    /* renamed from: b, reason: collision with root package name */
    public final v7.d f8823b;

    /* renamed from: c, reason: collision with root package name */
    public WeakReference f8824c;

    public MarkerView(Context context, int i3) {
        super(context);
        this.f8822a = new v7.d();
        this.f8823b = new v7.d();
        setupLayoutResource(i3);
    }

    private void setupLayoutResource(int i3) {
        View inflate = LayoutInflater.from(getContext()).inflate(i3, this);
        inflate.setLayoutParams(new RelativeLayout.LayoutParams(-2, -2));
        inflate.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        inflate.layout(0, 0, inflate.getMeasuredWidth(), inflate.getMeasuredHeight());
    }

    public void a(Entry entry, c cVar) {
        measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        layout(0, 0, getMeasuredWidth(), getMeasuredHeight());
    }

    public Chart getChartView() {
        WeakReference weakReference = this.f8824c;
        if (weakReference == null) {
            return null;
        }
        return (Chart) weakReference.get();
    }

    public v7.d getOffset() {
        return this.f8822a;
    }

    public void setChartView(Chart chart) {
        this.f8824c = new WeakReference(chart);
    }

    public void setOffset(v7.d dVar) {
        this.f8822a = dVar;
        if (dVar == null) {
            this.f8822a = new v7.d();
        }
    }
}
