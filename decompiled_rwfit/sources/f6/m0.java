package f6;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.SwitchCompat;
import com.example.test.ui.view.TitleView;

/* loaded from: classes.dex */
public final class m0 implements m2.a {

    /* renamed from: a, reason: collision with root package name */
    public final LinearLayout f13114a;

    /* renamed from: b, reason: collision with root package name */
    public final SwitchCompat f13115b;

    /* renamed from: c, reason: collision with root package name */
    public final RelativeLayout f13116c;

    /* renamed from: d, reason: collision with root package name */
    public final TitleView f13117d;
    public final TextView e;

    public m0(LinearLayout linearLayout, SwitchCompat switchCompat, RelativeLayout relativeLayout, TitleView titleView, TextView textView) {
        this.f13114a = linearLayout;
        this.f13115b = switchCompat;
        this.f13116c = relativeLayout;
        this.f13117d = titleView;
        this.e = textView;
    }

    @Override // m2.a
    public final View b() {
        return this.f13114a;
    }
}
