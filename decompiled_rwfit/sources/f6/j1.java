package f6;

import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import com.example.test.ui.view.TitleView;

/* loaded from: classes.dex */
public final class j1 implements m2.a {

    /* renamed from: a, reason: collision with root package name */
    public final LinearLayout f13016a;

    /* renamed from: b, reason: collision with root package name */
    public final Button f13017b;

    /* renamed from: c, reason: collision with root package name */
    public final TitleView f13018c;

    public j1(LinearLayout linearLayout, Button button, TitleView titleView) {
        this.f13016a = linearLayout;
        this.f13017b = button;
        this.f13018c = titleView;
    }

    @Override // m2.a
    public final View b() {
        return this.f13016a;
    }
}
