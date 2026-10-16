package f6;

import android.view.View;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.example.test.ui.testui.TRingToolBarView;

/* loaded from: classes.dex */
public final class v3 implements m2.a {

    /* renamed from: a, reason: collision with root package name */
    public final LinearLayout f13408a;

    /* renamed from: b, reason: collision with root package name */
    public final LinearLayout f13409b;

    /* renamed from: c, reason: collision with root package name */
    public final RecyclerView f13410c;

    /* renamed from: d, reason: collision with root package name */
    public final SwipeRefreshLayout f13411d;
    public final TRingToolBarView e;

    public v3(LinearLayout linearLayout, LinearLayout linearLayout2, RecyclerView recyclerView, SwipeRefreshLayout swipeRefreshLayout, TRingToolBarView tRingToolBarView) {
        this.f13408a = linearLayout;
        this.f13409b = linearLayout2;
        this.f13410c = recyclerView;
        this.f13411d = swipeRefreshLayout;
        this.e = tRingToolBarView;
    }

    @Override // m2.a
    public final View b() {
        return this.f13408a;
    }
}
