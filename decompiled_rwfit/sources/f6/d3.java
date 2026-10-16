package f6;

import android.view.View;
import androidx.core.widget.NestedScrollView;
import com.example.test.ui.view.DataView;
import com.example.test.ui.view.DateSelectView;
import com.github.mikephil.charting.charts.BarChart;

/* loaded from: classes.dex */
public final class d3 implements m2.a {

    /* renamed from: a, reason: collision with root package name */
    public final NestedScrollView f12804a;

    /* renamed from: b, reason: collision with root package name */
    public final BarChart f12805b;

    /* renamed from: c, reason: collision with root package name */
    public final DataView f12806c;

    /* renamed from: d, reason: collision with root package name */
    public final DataView f12807d;
    public final DateSelectView e;

    public d3(NestedScrollView nestedScrollView, BarChart barChart, DataView dataView, DataView dataView2, DateSelectView dateSelectView) {
        this.f12804a = nestedScrollView;
        this.f12805b = barChart;
        this.f12806c = dataView;
        this.f12807d = dataView2;
        this.e = dateSelectView;
    }

    @Override // m2.a
    public final View b() {
        return this.f12804a;
    }
}
