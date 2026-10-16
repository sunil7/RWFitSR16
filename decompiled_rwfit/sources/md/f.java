package md;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import com.haibin.calendarview.CalendarLayout;
import com.haibin.calendarview.CalendarView;

/* loaded from: classes.dex */
public final class f extends AnimatorListenerAdapter {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f16040a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ CalendarView f16041b;

    public /* synthetic */ f(CalendarView calendarView, int i3) {
        this.f16040a = i3;
        this.f16041b = calendarView;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        switch (this.f16040a) {
            case 0:
                super.onAnimationEnd(animator);
                this.f16041b.f11328f.setVisibility(0);
                break;
            default:
                super.onAnimationEnd(animator);
                CalendarView calendarView = this.f16041b;
                calendarView.f11324a.getClass();
                CalendarLayout calendarLayout = calendarView.f11329g;
                if (calendarLayout != null) {
                    ViewGroup viewGroup = calendarLayout.f11311h;
                    if (viewGroup != null) {
                        viewGroup.setTranslationY(calendarLayout.getHeight() - calendarLayout.f11308d.getHeight());
                        calendarLayout.f11311h.setVisibility(0);
                        calendarLayout.f11311h.animate().translationY(0.0f).setDuration(180L).setInterpolator(new LinearInterpolator()).setListener(new b());
                    }
                    if (calendarView.f11329g.f11308d.getVisibility() == 0) {
                        calendarView.f11325b.setVisibility(0);
                    } else {
                        calendarView.f11326c.setVisibility(0);
                        calendarView.f11329g.d(240);
                    }
                } else {
                    calendarView.f11325b.setVisibility(0);
                }
                calendarView.f11325b.clearAnimation();
                break;
        }
    }
}
