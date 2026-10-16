package t7;

import android.view.GestureDetector;
import android.view.View;
import com.github.mikephil.charting.charts.Chart;

/* loaded from: classes.dex */
public abstract class b extends GestureDetector.SimpleOnGestureListener implements View.OnTouchListener {

    /* renamed from: a, reason: collision with root package name */
    public int f18581a = 0;

    /* renamed from: b, reason: collision with root package name */
    public q7.c f18582b;

    /* renamed from: c, reason: collision with root package name */
    public final GestureDetector f18583c;

    /* renamed from: d, reason: collision with root package name */
    public final Chart f18584d;

    public b(Chart chart) {
        this.f18584d = chart;
        this.f18583c = new GestureDetector(chart.getContext(), this);
    }
}
