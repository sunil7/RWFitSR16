package f6;

import android.view.View;
import android.widget.Button;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.example.test.ui.view.TitleView;

/* loaded from: classes.dex */
public final class u1 implements m2.a {

    /* renamed from: a, reason: collision with root package name */
    public final ConstraintLayout f13371a;

    /* renamed from: b, reason: collision with root package name */
    public final Button f13372b;

    /* renamed from: c, reason: collision with root package name */
    public final TitleView f13373c;

    public u1(ConstraintLayout constraintLayout, Button button, TitleView titleView) {
        this.f13371a = constraintLayout;
        this.f13372b = button;
        this.f13373c = titleView;
    }

    @Override // m2.a
    public final View b() {
        return this.f13371a;
    }
}
