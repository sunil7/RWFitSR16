package f6;

import android.view.View;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.example.test.ui.view.TitleView;

/* loaded from: classes.dex */
public final class n1 implements m2.a {

    /* renamed from: a, reason: collision with root package name */
    public final LinearLayout f13138a;

    /* renamed from: b, reason: collision with root package name */
    public final RecyclerView f13139b;

    /* renamed from: c, reason: collision with root package name */
    public final TitleView f13140c;

    public n1(LinearLayout linearLayout, RecyclerView recyclerView, TitleView titleView) {
        this.f13138a = linearLayout;
        this.f13139b = recyclerView;
        this.f13140c = titleView;
    }

    @Override // m2.a
    public final View b() {
        return this.f13138a;
    }
}
