package f6;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.example.test.ui.view.TitleView;

/* loaded from: classes.dex */
public final class f1 implements m2.a {

    /* renamed from: a, reason: collision with root package name */
    public final LinearLayout f12848a;

    /* renamed from: b, reason: collision with root package name */
    public final Button f12849b;

    /* renamed from: c, reason: collision with root package name */
    public final Button f12850c;

    /* renamed from: d, reason: collision with root package name */
    public final EditText f12851d;
    public final ImageView e;

    /* renamed from: f, reason: collision with root package name */
    public final Button f12852f;

    /* renamed from: g, reason: collision with root package name */
    public final TitleView f12853g;

    public f1(LinearLayout linearLayout, Button button, Button button2, EditText editText, ImageView imageView, Button button3, TitleView titleView) {
        this.f12848a = linearLayout;
        this.f12849b = button;
        this.f12850c = button2;
        this.f12851d = editText;
        this.e = imageView;
        this.f12852f = button3;
        this.f12853g = titleView;
    }

    @Override // m2.a
    public final View b() {
        return this.f12848a;
    }
}
