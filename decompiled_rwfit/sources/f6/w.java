package f6;

import android.view.View;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.example.test.ui.view.TitleView;

/* loaded from: classes.dex */
public final class w implements m2.a {

    /* renamed from: a, reason: collision with root package name */
    public final LinearLayout f13412a;

    /* renamed from: b, reason: collision with root package name */
    public final RecyclerView f13413b;

    /* renamed from: c, reason: collision with root package name */
    public final TitleView f13414c;

    public w(LinearLayout linearLayout, RecyclerView recyclerView, TitleView titleView) {
        this.f13412a = linearLayout;
        this.f13413b = recyclerView;
        this.f13414c = titleView;
    }

    @Override // m2.a
    public final View b() {
        return this.f13412a;
    }
}
