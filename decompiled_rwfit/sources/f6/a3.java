package f6;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.widget.NestedScrollView;
import com.example.test.ui.view.DataView;
import com.example.test.ui.view.DateSelectView;
import com.github.mikephil.charting.charts.LineChart;

/* loaded from: classes.dex */
public final class a3 implements m2.a {

    /* renamed from: a, reason: collision with root package name */
    public final NestedScrollView f12692a;

    /* renamed from: b, reason: collision with root package name */
    public final LineChart f12693b;

    /* renamed from: c, reason: collision with root package name */
    public final View f12694c;

    /* renamed from: d, reason: collision with root package name */
    public final DataView f12695d;
    public final DataView e;

    /* renamed from: f, reason: collision with root package name */
    public final DataView f12696f;

    /* renamed from: g, reason: collision with root package name */
    public final DataView f12697g;

    /* renamed from: h, reason: collision with root package name */
    public final TextView f12698h;

    /* renamed from: i, reason: collision with root package name */
    public final View f12699i;

    /* renamed from: j, reason: collision with root package name */
    public final LinearLayout f12700j;

    /* renamed from: k, reason: collision with root package name */
    public final TextView f12701k;

    /* renamed from: l, reason: collision with root package name */
    public final DateSelectView f12702l;

    public a3(NestedScrollView nestedScrollView, LineChart lineChart, View view, DataView dataView, DataView dataView2, DataView dataView3, DataView dataView4, TextView textView, View view2, LinearLayout linearLayout, TextView textView2, DateSelectView dateSelectView) {
        this.f12692a = nestedScrollView;
        this.f12693b = lineChart;
        this.f12694c = view;
        this.f12695d = dataView;
        this.e = dataView2;
        this.f12696f = dataView3;
        this.f12697g = dataView4;
        this.f12698h = textView;
        this.f12699i = view2;
        this.f12700j = linearLayout;
        this.f12701k = textView2;
        this.f12702l = dateSelectView;
    }

    @Override // m2.a
    public final View b() {
        return this.f12692a;
    }
}
