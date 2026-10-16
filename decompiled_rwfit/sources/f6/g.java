package f6;

import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.example.test.ui.testui.TRingToolBarView;

/* loaded from: classes.dex */
public final class g implements m2.a {

    /* renamed from: a, reason: collision with root package name */
    public final ConstraintLayout f12893a;

    /* renamed from: b, reason: collision with root package name */
    public final TRingToolBarView f12894b;

    /* renamed from: c, reason: collision with root package name */
    public final TextView f12895c;

    /* renamed from: d, reason: collision with root package name */
    public final TextView f12896d;

    public g(ConstraintLayout constraintLayout, TRingToolBarView tRingToolBarView, TextView textView, TextView textView2) {
        this.f12893a = constraintLayout;
        this.f12894b = tRingToolBarView;
        this.f12895c = textView;
        this.f12896d = textView2;
    }

    @Override // m2.a
    public final View b() {
        return this.f12893a;
    }
}
