package f6;

import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.example.test.ui.testui.TRingToolBarView;
import com.haibin.calendarview.CalendarView;

/* loaded from: classes.dex */
public final class c1 implements m2.a {

    /* renamed from: a, reason: collision with root package name */
    public final ConstraintLayout f12758a;

    /* renamed from: b, reason: collision with root package name */
    public final CalendarView f12759b;

    /* renamed from: c, reason: collision with root package name */
    public final TRingToolBarView f12760c;

    /* renamed from: d, reason: collision with root package name */
    public final TextView f12761d;

    public c1(ConstraintLayout constraintLayout, CalendarView calendarView, TRingToolBarView tRingToolBarView, TextView textView) {
        this.f12758a = constraintLayout;
        this.f12759b = calendarView;
        this.f12760c = tRingToolBarView;
        this.f12761d = textView;
    }

    @Override // m2.a
    public final View b() {
        return this.f12758a;
    }
}
