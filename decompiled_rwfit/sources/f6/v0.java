package f6;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.example.test.ui.testui.TRingDateSelectView;
import com.example.test.ui.testui.TRingToolBarView;
import com.github.mikephil.charting.charts.BarChart;

/* loaded from: classes.dex */
public final class v0 implements m2.a {

    /* renamed from: a, reason: collision with root package name */
    public final ConstraintLayout f13389a;

    /* renamed from: b, reason: collision with root package name */
    public final BarChart f13390b;

    /* renamed from: c, reason: collision with root package name */
    public final LinearLayout f13391c;

    /* renamed from: d, reason: collision with root package name */
    public final TRingToolBarView f13392d;
    public final TextView e;

    /* renamed from: f, reason: collision with root package name */
    public final TextView f13393f;

    /* renamed from: g, reason: collision with root package name */
    public final TextView f13394g;

    /* renamed from: h, reason: collision with root package name */
    public final TextView f13395h;

    /* renamed from: i, reason: collision with root package name */
    public final TRingDateSelectView f13396i;

    public v0(ConstraintLayout constraintLayout, BarChart barChart, LinearLayout linearLayout, TRingToolBarView tRingToolBarView, TextView textView, TextView textView2, TextView textView3, TextView textView4, TRingDateSelectView tRingDateSelectView) {
        this.f13389a = constraintLayout;
        this.f13390b = barChart;
        this.f13391c = linearLayout;
        this.f13392d = tRingToolBarView;
        this.e = textView;
        this.f13393f = textView2;
        this.f13394g = textView3;
        this.f13395h = textView4;
        this.f13396i = tRingDateSelectView;
    }

    @Override // m2.a
    public final View b() {
        return this.f13389a;
    }
}
