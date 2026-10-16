package f6;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.example.test.ui.view.ProgressButtonView;
import com.example.test.ui.view.TitleView;

/* loaded from: classes.dex */
public final class a1 implements m2.a {

    /* renamed from: a, reason: collision with root package name */
    public final LinearLayout f12680a;

    /* renamed from: b, reason: collision with root package name */
    public final ProgressButtonView f12681b;

    /* renamed from: c, reason: collision with root package name */
    public final TitleView f12682c;

    /* renamed from: d, reason: collision with root package name */
    public final TextView f12683d;
    public final TextView e;

    /* renamed from: f, reason: collision with root package name */
    public final TextView f12684f;

    /* renamed from: g, reason: collision with root package name */
    public final TextView f12685g;

    /* renamed from: h, reason: collision with root package name */
    public final TextView f12686h;

    public a1(LinearLayout linearLayout, ProgressButtonView progressButtonView, TitleView titleView, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5) {
        this.f12680a = linearLayout;
        this.f12681b = progressButtonView;
        this.f12682c = titleView;
        this.f12683d = textView;
        this.e = textView2;
        this.f12684f = textView3;
        this.f12685g = textView4;
        this.f12686h = textView5;
    }

    @Override // m2.a
    public final View b() {
        return this.f12680a;
    }
}
