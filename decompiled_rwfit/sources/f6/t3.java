package f6;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.widget.NestedScrollView;
import com.example.test.ui.view.DataView;
import com.example.test.ui.view.DateSelectView;
import com.github.mikephil.charting.charts.LineChart;

/* loaded from: classes.dex */
public final class t3 implements m2.a {

    /* renamed from: a, reason: collision with root package name */
    public final NestedScrollView f13345a;

    /* renamed from: b, reason: collision with root package name */
    public final LineChart f13346b;

    /* renamed from: c, reason: collision with root package name */
    public final View f13347c;

    /* renamed from: d, reason: collision with root package name */
    public final DataView f13348d;
    public final DataView e;

    /* renamed from: f, reason: collision with root package name */
    public final DataView f13349f;

    /* renamed from: g, reason: collision with root package name */
    public final DataView f13350g;

    /* renamed from: h, reason: collision with root package name */
    public final TextView f13351h;

    /* renamed from: i, reason: collision with root package name */
    public final View f13352i;

    /* renamed from: j, reason: collision with root package name */
    public final LinearLayout f13353j;

    /* renamed from: k, reason: collision with root package name */
    public final TextView f13354k;

    /* renamed from: l, reason: collision with root package name */
    public final DateSelectView f13355l;

    public t3(NestedScrollView nestedScrollView, LineChart lineChart, View view, DataView dataView, DataView dataView2, DataView dataView3, DataView dataView4, TextView textView, View view2, LinearLayout linearLayout, TextView textView2, DateSelectView dateSelectView) {
        this.f13345a = nestedScrollView;
        this.f13346b = lineChart;
        this.f13347c = view;
        this.f13348d = dataView;
        this.e = dataView2;
        this.f13349f = dataView3;
        this.f13350g = dataView4;
        this.f13351h = textView;
        this.f13352i = view2;
        this.f13353j = linearLayout;
        this.f13354k = textView2;
        this.f13355l = dateSelectView;
    }

    @Override // m2.a
    public final View b() {
        return this.f13345a;
    }
}
