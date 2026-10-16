package f6;

import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.example.test.ui.view.SelectView;

/* loaded from: classes.dex */
public final class r3 implements m2.a {

    /* renamed from: a, reason: collision with root package name */
    public final ConstraintLayout f13280a;

    /* renamed from: b, reason: collision with root package name */
    public final View f13281b;

    /* renamed from: c, reason: collision with root package name */
    public final SelectView f13282c;

    /* renamed from: d, reason: collision with root package name */
    public final TextView f13283d;
    public final TextView e;

    /* renamed from: f, reason: collision with root package name */
    public final TextView f13284f;

    /* renamed from: g, reason: collision with root package name */
    public final TextView f13285g;

    public r3(ConstraintLayout constraintLayout, View view, SelectView selectView, TextView textView, TextView textView2, TextView textView3, TextView textView4) {
        this.f13280a = constraintLayout;
        this.f13281b = view;
        this.f13282c = selectView;
        this.f13283d = textView;
        this.e = textView2;
        this.f13284f = textView3;
        this.f13285g = textView4;
    }

    @Override // m2.a
    public final View b() {
        return this.f13280a;
    }
}
