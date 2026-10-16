package f6;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.SwitchCompat;
import com.example.test.ui.view.TitleView;

/* loaded from: classes.dex */
public final class l implements m2.a {

    /* renamed from: a, reason: collision with root package name */
    public final LinearLayout f13078a;

    /* renamed from: b, reason: collision with root package name */
    public final SwitchCompat f13079b;

    /* renamed from: c, reason: collision with root package name */
    public final RelativeLayout f13080c;

    /* renamed from: d, reason: collision with root package name */
    public final TitleView f13081d;
    public final TextView e;

    public l(LinearLayout linearLayout, SwitchCompat switchCompat, RelativeLayout relativeLayout, TitleView titleView, TextView textView) {
        this.f13078a = linearLayout;
        this.f13079b = switchCompat;
        this.f13080c = relativeLayout;
        this.f13081d = titleView;
        this.e = textView;
    }

    @Override // m2.a
    public final View b() {
        return this.f13078a;
    }
}
