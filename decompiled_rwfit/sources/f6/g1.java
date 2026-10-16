package f6;

import android.view.View;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.example.test.ui.view.TitleView;

/* loaded from: classes.dex */
public final class g1 implements m2.a {

    /* renamed from: a, reason: collision with root package name */
    public final LinearLayout f12914a;

    /* renamed from: b, reason: collision with root package name */
    public final RecyclerView f12915b;

    /* renamed from: c, reason: collision with root package name */
    public final TitleView f12916c;

    public g1(LinearLayout linearLayout, RecyclerView recyclerView, TitleView titleView) {
        this.f12914a = linearLayout;
        this.f12915b = recyclerView;
        this.f12916c = titleView;
    }

    @Override // m2.a
    public final View b() {
        return this.f12914a;
    }
}
