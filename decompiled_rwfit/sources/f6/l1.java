package f6;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.example.test.ui.view.TitleView;

/* loaded from: classes.dex */
public final class l1 implements m2.a {

    /* renamed from: a, reason: collision with root package name */
    public final LinearLayout f13086a;

    /* renamed from: b, reason: collision with root package name */
    public final Button f13087b;

    /* renamed from: c, reason: collision with root package name */
    public final EditText f13088c;

    /* renamed from: d, reason: collision with root package name */
    public final TextView f13089d;
    public final EditText e;

    /* renamed from: f, reason: collision with root package name */
    public final RecyclerView f13090f;

    /* renamed from: g, reason: collision with root package name */
    public final TextView f13091g;

    /* renamed from: h, reason: collision with root package name */
    public final EditText f13092h;

    /* renamed from: i, reason: collision with root package name */
    public final TitleView f13093i;

    /* renamed from: j, reason: collision with root package name */
    public final TextView f13094j;

    public l1(LinearLayout linearLayout, Button button, EditText editText, TextView textView, EditText editText2, RecyclerView recyclerView, TextView textView2, EditText editText3, TitleView titleView, TextView textView3) {
        this.f13086a = linearLayout;
        this.f13087b = button;
        this.f13088c = editText;
        this.f13089d = textView;
        this.e = editText2;
        this.f13090f = recyclerView;
        this.f13091g = textView2;
        this.f13092h = editText3;
        this.f13093i = titleView;
        this.f13094j = textView3;
    }

    @Override // m2.a
    public final View b() {
        return this.f13086a;
    }
}
