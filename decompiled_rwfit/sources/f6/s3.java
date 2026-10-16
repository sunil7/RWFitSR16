package f6;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.widget.NestedScrollView;
import com.example.test.ui.view.DataView;
import com.example.test.ui.view.DateSelectView;
import com.example.test.ui.view.RoundProgressBar;
import com.example.test.ui.view.TimeIndicatorView;
import com.github.mikephil.charting.charts.BarChart;

/* loaded from: classes.dex */
public final class s3 implements m2.a {

    /* renamed from: a, reason: collision with root package name */
    public final NestedScrollView f13303a;

    /* renamed from: b, reason: collision with root package name */
    public final BarChart f13304b;

    /* renamed from: c, reason: collision with root package name */
    public final DataView f13305c;

    /* renamed from: d, reason: collision with root package name */
    public final DataView f13306d;
    public final LinearLayout e;

    /* renamed from: f, reason: collision with root package name */
    public final LinearLayout f13307f;

    /* renamed from: g, reason: collision with root package name */
    public final TimeIndicatorView f13308g;

    /* renamed from: h, reason: collision with root package name */
    public final RoundProgressBar f13309h;

    /* renamed from: i, reason: collision with root package name */
    public final ImageView f13310i;

    /* renamed from: j, reason: collision with root package name */
    public final TextView f13311j;

    /* renamed from: k, reason: collision with root package name */
    public final TextView f13312k;

    /* renamed from: l, reason: collision with root package name */
    public final TextView f13313l;

    /* renamed from: m, reason: collision with root package name */
    public final DateSelectView f13314m;

    public s3(NestedScrollView nestedScrollView, BarChart barChart, DataView dataView, DataView dataView2, LinearLayout linearLayout, LinearLayout linearLayout2, TimeIndicatorView timeIndicatorView, RoundProgressBar roundProgressBar, ImageView imageView, TextView textView, TextView textView2, TextView textView3, DateSelectView dateSelectView) {
        this.f13303a = nestedScrollView;
        this.f13304b = barChart;
        this.f13305c = dataView;
        this.f13306d = dataView2;
        this.e = linearLayout;
        this.f13307f = linearLayout2;
        this.f13308g = timeIndicatorView;
        this.f13309h = roundProgressBar;
        this.f13310i = imageView;
        this.f13311j = textView;
        this.f13312k = textView2;
        this.f13313l = textView3;
        this.f13314m = dateSelectView;
    }

    @Override // m2.a
    public final View b() {
        return this.f13303a;
    }
}
