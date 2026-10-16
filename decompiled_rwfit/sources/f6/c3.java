package f6;

import android.view.View;
import android.widget.TextView;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.RecyclerView;
import com.example.test.ui.view.CircleProgressView;

/* loaded from: classes.dex */
public final class c3 implements m2.a {

    /* renamed from: a, reason: collision with root package name */
    public final NestedScrollView f12767a;

    /* renamed from: b, reason: collision with root package name */
    public final RecyclerView f12768b;

    /* renamed from: c, reason: collision with root package name */
    public final TextView f12769c;

    /* renamed from: d, reason: collision with root package name */
    public final CircleProgressView f12770d;
    public final TextView e;

    public c3(NestedScrollView nestedScrollView, RecyclerView recyclerView, TextView textView, CircleProgressView circleProgressView, TextView textView2) {
        this.f12767a = nestedScrollView;
        this.f12768b = recyclerView;
        this.f12769c = textView;
        this.f12770d = circleProgressView;
        this.e = textView2;
    }

    @Override // m2.a
    public final View b() {
        return this.f12767a;
    }
}
