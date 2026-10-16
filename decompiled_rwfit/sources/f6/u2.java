package f6;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.example.test.ui.view.TitleView;

/* loaded from: classes.dex */
public final class u2 implements m2.a {

    /* renamed from: a, reason: collision with root package name */
    public final LinearLayout f13374a;

    /* renamed from: b, reason: collision with root package name */
    public final RelativeLayout f13375b;

    /* renamed from: c, reason: collision with root package name */
    public final RelativeLayout f13376c;

    /* renamed from: d, reason: collision with root package name */
    public final TitleView f13377d;
    public final TextView e;

    /* renamed from: f, reason: collision with root package name */
    public final TextView f13378f;

    public u2(LinearLayout linearLayout, RelativeLayout relativeLayout, RelativeLayout relativeLayout2, TitleView titleView, TextView textView, TextView textView2) {
        this.f13374a = linearLayout;
        this.f13375b = relativeLayout;
        this.f13376c = relativeLayout2;
        this.f13377d = titleView;
        this.e = textView;
        this.f13378f = textView2;
    }

    @Override // m2.a
    public final View b() {
        return this.f13374a;
    }
}
