package f6;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes.dex */
public final class h3 implements m2.a {

    /* renamed from: a, reason: collision with root package name */
    public final RelativeLayout f12954a;

    /* renamed from: b, reason: collision with root package name */
    public final RecyclerView f12955b;

    /* renamed from: c, reason: collision with root package name */
    public final ImageView f12956c;

    /* renamed from: d, reason: collision with root package name */
    public final ImageView f12957d;
    public final TextView e;

    public h3(RelativeLayout relativeLayout, RecyclerView recyclerView, ImageView imageView, ImageView imageView2, TextView textView) {
        this.f12954a = relativeLayout;
        this.f12955b = recyclerView;
        this.f12956c = imageView;
        this.f12957d = imageView2;
        this.e = textView;
    }

    @Override // m2.a
    public final View b() {
        return this.f12954a;
    }
}
