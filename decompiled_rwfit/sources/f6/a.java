package f6;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.example.test.ui.view.ActionItemView;
import com.example.test.ui.view.TitleView;

/* loaded from: classes.dex */
public final class a implements m2.a {

    /* renamed from: a, reason: collision with root package name */
    public final LinearLayout f12668a;

    /* renamed from: b, reason: collision with root package name */
    public final ImageView f12669b;

    /* renamed from: c, reason: collision with root package name */
    public final ActionItemView f12670c;

    /* renamed from: d, reason: collision with root package name */
    public final ActionItemView f12671d;
    public final ActionItemView e;

    /* renamed from: f, reason: collision with root package name */
    public final TitleView f12672f;

    /* renamed from: g, reason: collision with root package name */
    public final TextView f12673g;

    public a(LinearLayout linearLayout, ImageView imageView, ActionItemView actionItemView, ActionItemView actionItemView2, ActionItemView actionItemView3, TitleView titleView, TextView textView) {
        this.f12668a = linearLayout;
        this.f12669b = imageView;
        this.f12670c = actionItemView;
        this.f12671d = actionItemView2;
        this.e = actionItemView3;
        this.f12672f = titleView;
        this.f12673g = textView;
    }

    @Override // m2.a
    public final View b() {
        return this.f12668a;
    }
}
