package f6;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.example.test.ui.testui.TRingDateSelectView;
import com.example.test.ui.testui.TRingToolBarView;
import com.example.test.ui.view.HalfCircle;

/* loaded from: classes.dex */
public final class e0 implements m2.a {

    /* renamed from: a, reason: collision with root package name */
    public final LinearLayout f12812a;

    /* renamed from: b, reason: collision with root package name */
    public final HalfCircle f12813b;

    /* renamed from: c, reason: collision with root package name */
    public final TRingToolBarView f12814c;

    /* renamed from: d, reason: collision with root package name */
    public final TextView f12815d;
    public final TextView e;

    /* renamed from: f, reason: collision with root package name */
    public final TextView f12816f;

    /* renamed from: g, reason: collision with root package name */
    public final TextView f12817g;

    /* renamed from: h, reason: collision with root package name */
    public final TRingDateSelectView f12818h;

    public e0(LinearLayout linearLayout, HalfCircle halfCircle, TRingToolBarView tRingToolBarView, TextView textView, TextView textView2, TextView textView3, TextView textView4, TRingDateSelectView tRingDateSelectView) {
        this.f12812a = linearLayout;
        this.f12813b = halfCircle;
        this.f12814c = tRingToolBarView;
        this.f12815d = textView;
        this.e = textView2;
        this.f12816f = textView3;
        this.f12817g = textView4;
        this.f12818h = tRingDateSelectView;
    }

    @Override // m2.a
    public final View b() {
        return this.f12812a;
    }
}
