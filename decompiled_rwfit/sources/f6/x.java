package f6;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.example.test.ui.view.ProgressButtonView;
import com.example.test.ui.view.TitleView;

/* loaded from: classes.dex */
public final class x implements m2.a {

    /* renamed from: a, reason: collision with root package name */
    public final LinearLayout f13428a;

    /* renamed from: b, reason: collision with root package name */
    public final ImageView f13429b;

    /* renamed from: c, reason: collision with root package name */
    public final TextView f13430c;

    /* renamed from: d, reason: collision with root package name */
    public final TextView f13431d;
    public final TextView e;

    /* renamed from: f, reason: collision with root package name */
    public final TextView f13432f;

    /* renamed from: g, reason: collision with root package name */
    public final ProgressButtonView f13433g;

    /* renamed from: h, reason: collision with root package name */
    public final TitleView f13434h;

    public x(LinearLayout linearLayout, ImageView imageView, TextView textView, TextView textView2, TextView textView3, TextView textView4, ProgressButtonView progressButtonView, TitleView titleView) {
        this.f13428a = linearLayout;
        this.f13429b = imageView;
        this.f13430c = textView;
        this.f13431d = textView2;
        this.e = textView3;
        this.f13432f = textView4;
        this.f13433g = progressButtonView;
        this.f13434h = titleView;
    }

    @Override // m2.a
    public final View b() {
        return this.f13428a;
    }
}
