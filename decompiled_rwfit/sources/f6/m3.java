package f6;

import android.view.View;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.example.test.ui.view.ToolBarView;

/* loaded from: classes.dex */
public final class m3 implements m2.a {

    /* renamed from: a, reason: collision with root package name */
    public final LinearLayout f13125a;

    /* renamed from: b, reason: collision with root package name */
    public final RecyclerView f13126b;

    /* renamed from: c, reason: collision with root package name */
    public final SwipeRefreshLayout f13127c;

    /* renamed from: d, reason: collision with root package name */
    public final ToolBarView f13128d;

    public m3(LinearLayout linearLayout, RecyclerView recyclerView, SwipeRefreshLayout swipeRefreshLayout, ToolBarView toolBarView) {
        this.f13125a = linearLayout;
        this.f13126b = recyclerView;
        this.f13127c = swipeRefreshLayout;
        this.f13128d = toolBarView;
    }

    @Override // m2.a
    public final View b() {
        return this.f13125a;
    }
}
