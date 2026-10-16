package f6;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.example.test.ui.view.ProgressButtonView;
import com.example.test.ui.view.TitleView;

/* loaded from: classes.dex */
public final class u implements m2.a {

    /* renamed from: a, reason: collision with root package name */
    public final LinearLayout f13356a;

    /* renamed from: b, reason: collision with root package name */
    public final RecyclerView f13357b;

    /* renamed from: c, reason: collision with root package name */
    public final View f13358c;

    /* renamed from: d, reason: collision with root package name */
    public final ImageView f13359d;
    public final RecyclerView e;

    /* renamed from: f, reason: collision with root package name */
    public final ProgressButtonView f13360f;

    /* renamed from: g, reason: collision with root package name */
    public final RecyclerView f13361g;

    /* renamed from: h, reason: collision with root package name */
    public final RecyclerView f13362h;

    /* renamed from: i, reason: collision with root package name */
    public final TitleView f13363i;

    public u(LinearLayout linearLayout, RecyclerView recyclerView, View view, ImageView imageView, RecyclerView recyclerView2, ProgressButtonView progressButtonView, RecyclerView recyclerView3, RecyclerView recyclerView4, TitleView titleView) {
        this.f13356a = linearLayout;
        this.f13357b = recyclerView;
        this.f13358c = view;
        this.f13359d = imageView;
        this.e = recyclerView2;
        this.f13360f = progressButtonView;
        this.f13361g = recyclerView3;
        this.f13362h = recyclerView4;
        this.f13363i = titleView;
    }

    @Override // m2.a
    public final View b() {
        return this.f13356a;
    }
}
