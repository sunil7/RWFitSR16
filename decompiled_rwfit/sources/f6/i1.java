package f6;

import android.view.View;
import android.widget.LinearLayout;
import com.example.test.ui.view.TitleView;
import com.yanzhenjie.recyclerview.SwipeRecyclerView;

/* loaded from: classes.dex */
public final class i1 implements m2.a {

    /* renamed from: a, reason: collision with root package name */
    public final LinearLayout f12985a;

    /* renamed from: b, reason: collision with root package name */
    public final LinearLayout f12986b;

    /* renamed from: c, reason: collision with root package name */
    public final SwipeRecyclerView f12987c;

    /* renamed from: d, reason: collision with root package name */
    public final TitleView f12988d;

    public i1(LinearLayout linearLayout, LinearLayout linearLayout2, SwipeRecyclerView swipeRecyclerView, TitleView titleView) {
        this.f12985a = linearLayout;
        this.f12986b = linearLayout2;
        this.f12987c = swipeRecyclerView;
        this.f12988d = titleView;
    }

    @Override // m2.a
    public final View b() {
        return this.f12985a;
    }
}
