package f6;

import android.view.View;
import android.widget.LinearLayout;
import com.example.test.ui.view.TitleView;
import com.yanzhenjie.recyclerview.SwipeRecyclerView;

/* loaded from: classes.dex */
public final class q1 implements m2.a {

    /* renamed from: a, reason: collision with root package name */
    public final LinearLayout f13255a;

    /* renamed from: b, reason: collision with root package name */
    public final LinearLayout f13256b;

    /* renamed from: c, reason: collision with root package name */
    public final SwipeRecyclerView f13257c;

    /* renamed from: d, reason: collision with root package name */
    public final TitleView f13258d;

    public q1(LinearLayout linearLayout, LinearLayout linearLayout2, SwipeRecyclerView swipeRecyclerView, TitleView titleView) {
        this.f13255a = linearLayout;
        this.f13256b = linearLayout2;
        this.f13257c = swipeRecyclerView;
        this.f13258d = titleView;
    }

    @Override // m2.a
    public final View b() {
        return this.f13255a;
    }
}
