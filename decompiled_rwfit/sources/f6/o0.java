package f6;

import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.example.test.ui.view.TitleView;

/* loaded from: classes.dex */
public final class o0 implements m2.a {

    /* renamed from: a, reason: collision with root package name */
    public final LinearLayout f13160a;

    /* renamed from: b, reason: collision with root package name */
    public final EditText f13161b;

    /* renamed from: c, reason: collision with root package name */
    public final TextView f13162c;

    /* renamed from: d, reason: collision with root package name */
    public final TitleView f13163d;
    public final TextView e;

    public o0(LinearLayout linearLayout, EditText editText, TextView textView, TitleView titleView, TextView textView2) {
        this.f13160a = linearLayout;
        this.f13161b = editText;
        this.f13162c = textView;
        this.f13163d = titleView;
        this.e = textView2;
    }

    @Override // m2.a
    public final View b() {
        return this.f13160a;
    }
}
