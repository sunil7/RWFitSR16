package f6;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.widget.NestedScrollView;
import com.example.test.ui.view.DataView;
import com.example.test.ui.view.DateSelectView;
import com.github.mikephil.charting.charts.LineChart;

/* loaded from: classes.dex */
public final class e3 implements m2.a {

    /* renamed from: a, reason: collision with root package name */
    public final NestedScrollView f12828a;

    /* renamed from: b, reason: collision with root package name */
    public final LineChart f12829b;

    /* renamed from: c, reason: collision with root package name */
    public final View f12830c;

    /* renamed from: d, reason: collision with root package name */
    public final DataView f12831d;
    public final DataView e;

    /* renamed from: f, reason: collision with root package name */
    public final DataView f12832f;

    /* renamed from: g, reason: collision with root package name */
    public final DataView f12833g;

    /* renamed from: h, reason: collision with root package name */
    public final TextView f12834h;

    /* renamed from: i, reason: collision with root package name */
    public final View f12835i;

    /* renamed from: j, reason: collision with root package name */
    public final LinearLayout f12836j;

    /* renamed from: k, reason: collision with root package name */
    public final TextView f12837k;

    /* renamed from: l, reason: collision with root package name */
    public final DateSelectView f12838l;

    public e3(NestedScrollView nestedScrollView, LineChart lineChart, View view, DataView dataView, DataView dataView2, DataView dataView3, DataView dataView4, TextView textView, View view2, LinearLayout linearLayout, TextView textView2, DateSelectView dateSelectView) {
        this.f12828a = nestedScrollView;
        this.f12829b = lineChart;
        this.f12830c = view;
        this.f12831d = dataView;
        this.e = dataView2;
        this.f12832f = dataView3;
        this.f12833g = dataView4;
        this.f12834h = textView;
        this.f12835i = view2;
        this.f12836j = linearLayout;
        this.f12837k = textView2;
        this.f12838l = dateSelectView;
    }

    @Override // m2.a
    public final View b() {
        return this.f12828a;
    }
}
