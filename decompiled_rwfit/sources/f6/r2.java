package f6;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.example.test.ui.testui.TRingToolBarView;

/* loaded from: classes.dex */
public final class r2 implements m2.a {

    /* renamed from: a, reason: collision with root package name */
    public final LinearLayout f13276a;

    /* renamed from: b, reason: collision with root package name */
    public final RelativeLayout f13277b;

    /* renamed from: c, reason: collision with root package name */
    public final RelativeLayout f13278c;

    /* renamed from: d, reason: collision with root package name */
    public final RelativeLayout f13279d;
    public final TRingToolBarView e;

    public r2(LinearLayout linearLayout, RelativeLayout relativeLayout, RelativeLayout relativeLayout2, RelativeLayout relativeLayout3, TRingToolBarView tRingToolBarView) {
        this.f13276a = linearLayout;
        this.f13277b = relativeLayout;
        this.f13278c = relativeLayout2;
        this.f13279d = relativeLayout3;
        this.e = tRingToolBarView;
    }

    @Override // m2.a
    public final View b() {
        return this.f13276a;
    }
}
