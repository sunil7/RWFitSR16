package f6;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import com.example.test.ui.view.TitleView;

/* loaded from: classes.dex */
public final class c0 implements m2.a {

    /* renamed from: a, reason: collision with root package name */
    public final LinearLayout f12754a;

    /* renamed from: b, reason: collision with root package name */
    public final Button f12755b;

    /* renamed from: c, reason: collision with root package name */
    public final EditText f12756c;

    /* renamed from: d, reason: collision with root package name */
    public final TitleView f12757d;

    public c0(LinearLayout linearLayout, Button button, EditText editText, TitleView titleView) {
        this.f12754a = linearLayout;
        this.f12755b = button;
        this.f12756c = editText;
        this.f12757d = titleView;
    }

    @Override // m2.a
    public final View b() {
        return this.f12754a;
    }
}
