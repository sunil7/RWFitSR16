package f6;

import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.example.test.ui.view.ActionItemView;
import com.example.test.ui.view.TitleView;

/* loaded from: classes.dex */
public final class b implements m2.a {

    /* renamed from: a, reason: collision with root package name */
    public final LinearLayout f12703a;

    /* renamed from: b, reason: collision with root package name */
    public final ActionItemView f12704b;

    /* renamed from: c, reason: collision with root package name */
    public final ActionItemView f12705c;

    /* renamed from: d, reason: collision with root package name */
    public final TextView f12706d;
    public final Button e;

    /* renamed from: f, reason: collision with root package name */
    public final TitleView f12707f;

    /* renamed from: g, reason: collision with root package name */
    public final ActionItemView f12708g;

    public b(LinearLayout linearLayout, ActionItemView actionItemView, ActionItemView actionItemView2, TextView textView, Button button, TitleView titleView, ActionItemView actionItemView3) {
        this.f12703a = linearLayout;
        this.f12704b = actionItemView;
        this.f12705c = actionItemView2;
        this.f12706d = textView;
        this.e = button;
        this.f12707f = titleView;
        this.f12708g = actionItemView3;
    }

    @Override // m2.a
    public final View b() {
        return this.f12703a;
    }
}
