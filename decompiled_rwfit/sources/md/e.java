package md;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.haibin.calendarview.CalendarLayout;

/* loaded from: classes.dex */
public final class e extends AnimatorListenerAdapter {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f16038a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ CalendarLayout f16039b;

    public /* synthetic */ e(CalendarLayout calendarLayout, int i3) {
        this.f16038a = i3;
        this.f16039b = calendarLayout;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        switch (this.f16038a) {
            case 0:
                super.onAnimationEnd(animator);
                CalendarLayout calendarLayout = this.f16039b;
                calendarLayout.f11319p = false;
                if (calendarLayout.f11312i == 2) {
                    calendarLayout.requestLayout();
                }
                if (calendarLayout.f11308d.getVisibility() != 0) {
                    r rVar = calendarLayout.f11323u;
                }
                calendarLayout.f11309f.setVisibility(8);
                calendarLayout.f11308d.setVisibility(0);
                calendarLayout.f11323u.getClass();
                calendarLayout.f11307c = false;
                break;
            default:
                super.onAnimationEnd(animator);
                CalendarLayout calendarLayout2 = this.f16039b;
                calendarLayout2.f11319p = false;
                CalendarLayout.a(calendarLayout2);
                calendarLayout2.f11307c = true;
                break;
        }
    }
}
