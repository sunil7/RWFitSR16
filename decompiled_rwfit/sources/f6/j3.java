package f6;

import android.view.View;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes.dex */
public final class j3 implements m2.a {

    /* renamed from: a, reason: collision with root package name */
    public final NestedScrollView f13021a;

    /* renamed from: b, reason: collision with root package name */
    public final RecyclerView f13022b;

    public j3(NestedScrollView nestedScrollView, RecyclerView recyclerView) {
        this.f13021a = nestedScrollView;
        this.f13022b = recyclerView;
    }

    @Override // m2.a
    public final View b() {
        return this.f13021a;
    }
}
