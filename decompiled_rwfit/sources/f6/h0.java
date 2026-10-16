package f6;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.example.test.ui.testui.TRingToolBarView;

/* loaded from: classes.dex */
public final class h0 implements m2.a {

    /* renamed from: a, reason: collision with root package name */
    public final LinearLayout f12944a;

    /* renamed from: b, reason: collision with root package name */
    public final RecyclerView f12945b;

    /* renamed from: c, reason: collision with root package name */
    public final RelativeLayout f12946c;

    /* renamed from: d, reason: collision with root package name */
    public final TRingToolBarView f12947d;
    public final TextView e;

    public h0(LinearLayout linearLayout, RecyclerView recyclerView, RelativeLayout relativeLayout, TRingToolBarView tRingToolBarView, TextView textView) {
        this.f12944a = linearLayout;
        this.f12945b = recyclerView;
        this.f12946c = relativeLayout;
        this.f12947d = tRingToolBarView;
        this.e = textView;
    }

    @Override // m2.a
    public final View b() {
        return this.f12944a;
    }
}
