package f6;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.core.widget.NestedScrollView;

/* loaded from: classes.dex */
public final class i3 implements m2.a {

    /* renamed from: a, reason: collision with root package name */
    public final NestedScrollView f12995a;

    /* renamed from: b, reason: collision with root package name */
    public final LinearLayout f12996b;

    /* renamed from: c, reason: collision with root package name */
    public final ImageView f12997c;

    public i3(NestedScrollView nestedScrollView, LinearLayout linearLayout, ImageView imageView) {
        this.f12995a = nestedScrollView;
        this.f12996b = linearLayout;
        this.f12997c = imageView;
    }

    @Override // m2.a
    public final View b() {
        return this.f12995a;
    }
}
