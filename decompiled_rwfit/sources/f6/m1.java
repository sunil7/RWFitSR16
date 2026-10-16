package f6;

import android.view.View;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.example.test.ui.view.ActionItemView;
import com.example.test.ui.view.TitleView;

/* loaded from: classes.dex */
public final class m1 implements m2.a {

    /* renamed from: a, reason: collision with root package name */
    public final LinearLayout f13118a;

    /* renamed from: b, reason: collision with root package name */
    public final RecyclerView f13119b;

    /* renamed from: c, reason: collision with root package name */
    public final ActionItemView f13120c;

    /* renamed from: d, reason: collision with root package name */
    public final ActionItemView f13121d;
    public final View e;

    /* renamed from: f, reason: collision with root package name */
    public final View f13122f;

    /* renamed from: g, reason: collision with root package name */
    public final TitleView f13123g;

    public m1(LinearLayout linearLayout, RecyclerView recyclerView, ActionItemView actionItemView, ActionItemView actionItemView2, View view, View view2, TitleView titleView) {
        this.f13118a = linearLayout;
        this.f13119b = recyclerView;
        this.f13120c = actionItemView;
        this.f13121d = actionItemView2;
        this.e = view;
        this.f13122f = view2;
        this.f13123g = titleView;
    }

    @Override // m2.a
    public final View b() {
        return this.f13118a;
    }
}
