package f6;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.example.test.ui.view.TitleView;

/* loaded from: classes.dex */
public final class f0 implements m2.a {

    /* renamed from: a, reason: collision with root package name */
    public final LinearLayout f12841a;

    /* renamed from: b, reason: collision with root package name */
    public final Button f12842b;

    /* renamed from: c, reason: collision with root package name */
    public final EditText f12843c;

    /* renamed from: d, reason: collision with root package name */
    public final EditText f12844d;
    public final EditText e;

    /* renamed from: f, reason: collision with root package name */
    public final RecyclerView f12845f;

    /* renamed from: g, reason: collision with root package name */
    public final TextView f12846g;

    /* renamed from: h, reason: collision with root package name */
    public final TitleView f12847h;

    public f0(LinearLayout linearLayout, Button button, EditText editText, EditText editText2, EditText editText3, RecyclerView recyclerView, TextView textView, TitleView titleView) {
        this.f12841a = linearLayout;
        this.f12842b = button;
        this.f12843c = editText;
        this.f12844d = editText2;
        this.e = editText3;
        this.f12845f = recyclerView;
        this.f12846g = textView;
        this.f12847h = titleView;
    }

    @Override // m2.a
    public final View b() {
        return this.f12841a;
    }
}
