package f6;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.example.test.ui.view.TitleView;

/* loaded from: classes.dex */
public final class d0 implements m2.a {

    /* renamed from: a, reason: collision with root package name */
    public final LinearLayout f12775a;

    /* renamed from: b, reason: collision with root package name */
    public final LinearLayout f12776b;

    /* renamed from: c, reason: collision with root package name */
    public final TextView f12777c;

    /* renamed from: d, reason: collision with root package name */
    public final TitleView f12778d;

    public d0(LinearLayout linearLayout, LinearLayout linearLayout2, TextView textView, TitleView titleView) {
        this.f12775a = linearLayout;
        this.f12776b = linearLayout2;
        this.f12777c = textView;
        this.f12778d = titleView;
    }

    @Override // m2.a
    public final View b() {
        return this.f12775a;
    }
}
