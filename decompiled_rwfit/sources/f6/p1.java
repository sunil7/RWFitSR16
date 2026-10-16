package f6;

import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.example.test.ui.view.ActionItemView;
import com.example.test.ui.view.TitleView;

/* loaded from: classes.dex */
public final class p1 implements m2.a {

    /* renamed from: a, reason: collision with root package name */
    public final LinearLayout f13221a;

    /* renamed from: b, reason: collision with root package name */
    public final EditText f13222b;

    /* renamed from: c, reason: collision with root package name */
    public final TextView f13223c;

    /* renamed from: d, reason: collision with root package name */
    public final ActionItemView f13224d;
    public final ActionItemView e;

    /* renamed from: f, reason: collision with root package name */
    public final ActionItemView f13225f;

    /* renamed from: g, reason: collision with root package name */
    public final TitleView f13226g;

    public p1(LinearLayout linearLayout, EditText editText, TextView textView, ActionItemView actionItemView, ActionItemView actionItemView2, ActionItemView actionItemView3, TitleView titleView) {
        this.f13221a = linearLayout;
        this.f13222b = editText;
        this.f13223c = textView;
        this.f13224d = actionItemView;
        this.e = actionItemView2;
        this.f13225f = actionItemView3;
        this.f13226g = titleView;
    }

    @Override // m2.a
    public final View b() {
        return this.f13221a;
    }
}
