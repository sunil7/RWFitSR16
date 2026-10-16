package md;

import android.animation.ObjectAnimator;
import android.view.ViewGroup;
import com.haibin.calendarview.CalendarLayout;

/* loaded from: classes.dex */
public final class c implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f16034a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ CalendarLayout f16035b;

    public /* synthetic */ c(CalendarLayout calendarLayout, int i3) {
        this.f16034a = i3;
        this.f16035b = calendarLayout;
    }

    @Override // java.lang.Runnable
    public final void run() {
        CalendarLayout calendarLayout = this.f16035b;
        switch (this.f16034a) {
            case 0:
                calendarLayout.b(0);
                break;
            case 1:
                calendarLayout.d(0);
                break;
            default:
                ViewGroup viewGroup = calendarLayout.f11311h;
                ObjectAnimator ofFloat = ObjectAnimator.ofFloat(viewGroup, "translationY", viewGroup.getTranslationY(), -calendarLayout.f11314k);
                ofFloat.setDuration(0L);
                ofFloat.addUpdateListener(new com.google.android.material.internal.t(this, 9));
                ofFloat.addListener(new ab.q(this, 10));
                ofFloat.start();
                break;
        }
    }
}
