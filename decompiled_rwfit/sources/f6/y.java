package f6;

import android.view.View;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.example.test.ui.view.TitleView;
import com.scwang.smart.refresh.layout.SmartRefreshLayout;

/* loaded from: classes.dex */
public final class y implements m2.a {

    /* renamed from: a, reason: collision with root package name */
    public final LinearLayout f13451a;

    /* renamed from: b, reason: collision with root package name */
    public final RecyclerView f13452b;

    /* renamed from: c, reason: collision with root package name */
    public final SmartRefreshLayout f13453c;

    /* renamed from: d, reason: collision with root package name */
    public final TitleView f13454d;

    public y(LinearLayout linearLayout, RecyclerView recyclerView, SmartRefreshLayout smartRefreshLayout, TitleView titleView) {
        this.f13451a = linearLayout;
        this.f13452b = recyclerView;
        this.f13453c = smartRefreshLayout;
        this.f13454d = titleView;
    }

    @Override // m2.a
    public final View b() {
        return this.f13451a;
    }
}
