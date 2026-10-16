package f6;

import android.view.View;
import android.widget.LinearLayout;
import com.example.test.ui.view.InputView;
import com.example.test.ui.view.TitleView;

/* loaded from: classes.dex */
public final class s implements m2.a {

    /* renamed from: a, reason: collision with root package name */
    public final LinearLayout f13286a;

    /* renamed from: b, reason: collision with root package name */
    public final InputView f13287b;

    /* renamed from: c, reason: collision with root package name */
    public final InputView f13288c;

    /* renamed from: d, reason: collision with root package name */
    public final TitleView f13289d;

    public s(LinearLayout linearLayout, InputView inputView, InputView inputView2, TitleView titleView) {
        this.f13286a = linearLayout;
        this.f13287b = inputView;
        this.f13288c = inputView2;
        this.f13289d = titleView;
    }

    @Override // m2.a
    public final View b() {
        return this.f13286a;
    }
}
