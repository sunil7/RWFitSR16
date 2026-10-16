package f6;

import android.view.View;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.example.test.ui.view.TitleView;

/* loaded from: classes.dex */
public final class z0 implements m2.a {

    /* renamed from: a, reason: collision with root package name */
    public final LinearLayout f13477a;

    /* renamed from: b, reason: collision with root package name */
    public final RecyclerView f13478b;

    /* renamed from: c, reason: collision with root package name */
    public final TitleView f13479c;

    public z0(LinearLayout linearLayout, RecyclerView recyclerView, TitleView titleView) {
        this.f13477a = linearLayout;
        this.f13478b = recyclerView;
        this.f13479c = titleView;
    }

    @Override // m2.a
    public final View b() {
        return this.f13477a;
    }
}
