package f6;

import android.view.View;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.example.test.ui.view.ActionItemView;
import com.example.test.ui.view.TitleView;

/* loaded from: classes.dex */
public final class t0 implements m2.a {

    /* renamed from: a, reason: collision with root package name */
    public final LinearLayout f13333a;

    /* renamed from: b, reason: collision with root package name */
    public final RecyclerView f13334b;

    /* renamed from: c, reason: collision with root package name */
    public final ActionItemView f13335c;

    /* renamed from: d, reason: collision with root package name */
    public final ActionItemView f13336d;
    public final View e;

    /* renamed from: f, reason: collision with root package name */
    public final View f13337f;

    /* renamed from: g, reason: collision with root package name */
    public final TitleView f13338g;

    public t0(LinearLayout linearLayout, RecyclerView recyclerView, ActionItemView actionItemView, ActionItemView actionItemView2, View view, View view2, TitleView titleView) {
        this.f13333a = linearLayout;
        this.f13334b = recyclerView;
        this.f13335c = actionItemView;
        this.f13336d = actionItemView2;
        this.e = view;
        this.f13337f = view2;
        this.f13338g = titleView;
    }

    @Override // m2.a
    public final View b() {
        return this.f13333a;
    }
}
