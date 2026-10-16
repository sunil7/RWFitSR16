package f6;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.widget.NestedScrollView;
import com.example.test.ui.view.DataView;
import com.example.test.ui.view.DateSelectView;
import com.github.mikephil.charting.charts.LineChart;

/* loaded from: classes.dex */
public final class l3 implements m2.a {

    /* renamed from: a, reason: collision with root package name */
    public final NestedScrollView f13099a;

    /* renamed from: b, reason: collision with root package name */
    public final LineChart f13100b;

    /* renamed from: c, reason: collision with root package name */
    public final View f13101c;

    /* renamed from: d, reason: collision with root package name */
    public final DataView f13102d;
    public final DataView e;

    /* renamed from: f, reason: collision with root package name */
    public final DataView f13103f;

    /* renamed from: g, reason: collision with root package name */
    public final DataView f13104g;

    /* renamed from: h, reason: collision with root package name */
    public final TextView f13105h;

    /* renamed from: i, reason: collision with root package name */
    public final View f13106i;

    /* renamed from: j, reason: collision with root package name */
    public final LinearLayout f13107j;

    /* renamed from: k, reason: collision with root package name */
    public final TextView f13108k;

    /* renamed from: l, reason: collision with root package name */
    public final DateSelectView f13109l;

    public l3(NestedScrollView nestedScrollView, LineChart lineChart, View view, DataView dataView, DataView dataView2, DataView dataView3, DataView dataView4, TextView textView, View view2, LinearLayout linearLayout, TextView textView2, DateSelectView dateSelectView) {
        this.f13099a = nestedScrollView;
        this.f13100b = lineChart;
        this.f13101c = view;
        this.f13102d = dataView;
        this.e = dataView2;
        this.f13103f = dataView3;
        this.f13104g = dataView4;
        this.f13105h = textView;
        this.f13106i = view2;
        this.f13107j = linearLayout;
        this.f13108k = textView2;
        this.f13109l = dateSelectView;
    }

    @Override // m2.a
    public final View b() {
        return this.f13099a;
    }
}
