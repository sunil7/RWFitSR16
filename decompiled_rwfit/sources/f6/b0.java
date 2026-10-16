package f6;

import android.view.View;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.example.test.ui.testui.TRingToolBarView;

/* loaded from: classes.dex */
public final class b0 implements m2.a {

    /* renamed from: a, reason: collision with root package name */
    public final LinearLayout f12709a;

    /* renamed from: b, reason: collision with root package name */
    public final RecyclerView f12710b;

    /* renamed from: c, reason: collision with root package name */
    public final TRingToolBarView f12711c;

    public b0(LinearLayout linearLayout, RecyclerView recyclerView, TRingToolBarView tRingToolBarView) {
        this.f12709a = linearLayout;
        this.f12710b = recyclerView;
        this.f12711c = tRingToolBarView;
    }

    @Override // m2.a
    public final View b() {
        return this.f12709a;
    }
}
