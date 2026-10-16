package f6;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.widget.NestedScrollView;
import com.example.test.ui.view.DataView;
import com.example.test.ui.view.DateSelectView;
import com.example.test.ui.view.SleepDetailChartView;
import com.github.mikephil.charting.charts.BarChart;

/* loaded from: classes.dex */
public final class p3 implements m2.a {

    /* renamed from: a, reason: collision with root package name */
    public final NestedScrollView f13231a;

    /* renamed from: b, reason: collision with root package name */
    public final BarChart f13232b;

    /* renamed from: c, reason: collision with root package name */
    public final SleepDetailChartView f13233c;

    /* renamed from: d, reason: collision with root package name */
    public final DataView f13234d;
    public final DataView e;

    /* renamed from: f, reason: collision with root package name */
    public final DataView f13235f;

    /* renamed from: g, reason: collision with root package name */
    public final DataView f13236g;

    /* renamed from: h, reason: collision with root package name */
    public final DataView f13237h;

    /* renamed from: i, reason: collision with root package name */
    public final DataView f13238i;

    /* renamed from: j, reason: collision with root package name */
    public final View f13239j;

    /* renamed from: k, reason: collision with root package name */
    public final View f13240k;

    /* renamed from: l, reason: collision with root package name */
    public final LinearLayout f13241l;

    /* renamed from: m, reason: collision with root package name */
    public final LinearLayout f13242m;

    /* renamed from: n, reason: collision with root package name */
    public final TextView f13243n;

    /* renamed from: o, reason: collision with root package name */
    public final DateSelectView f13244o;

    public p3(NestedScrollView nestedScrollView, BarChart barChart, SleepDetailChartView sleepDetailChartView, DataView dataView, DataView dataView2, DataView dataView3, DataView dataView4, DataView dataView5, DataView dataView6, View view, View view2, LinearLayout linearLayout, LinearLayout linearLayout2, TextView textView, DateSelectView dateSelectView) {
        this.f13231a = nestedScrollView;
        this.f13232b = barChart;
        this.f13233c = sleepDetailChartView;
        this.f13234d = dataView;
        this.e = dataView2;
        this.f13235f = dataView3;
        this.f13236g = dataView4;
        this.f13237h = dataView5;
        this.f13238i = dataView6;
        this.f13239j = view;
        this.f13240k = view2;
        this.f13241l = linearLayout;
        this.f13242m = linearLayout2;
        this.f13243n = textView;
        this.f13244o = dateSelectView;
    }

    @Override // m2.a
    public final View b() {
        return this.f13231a;
    }
}
