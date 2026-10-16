package md;

import android.animation.ValueAnimator;
import com.haibin.calendarview.CalendarLayout;

/* loaded from: classes.dex */
public final class d implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f16036a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ CalendarLayout f16037b;

    public /* synthetic */ d(CalendarLayout calendarLayout, int i3) {
        this.f16036a = i3;
        this.f16037b = calendarLayout;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        switch (this.f16036a) {
            case 0:
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue() * 1.0f;
                CalendarLayout calendarLayout = this.f16037b;
                calendarLayout.f11308d.setTranslationY(calendarLayout.f11315l * (floatValue / calendarLayout.f11314k));
                calendarLayout.f11319p = true;
                break;
            default:
                float floatValue2 = ((Float) valueAnimator.getAnimatedValue()).floatValue() * 1.0f;
                CalendarLayout calendarLayout2 = this.f16037b;
                calendarLayout2.f11308d.setTranslationY(calendarLayout2.f11315l * (floatValue2 / calendarLayout2.f11314k));
                calendarLayout2.f11319p = true;
                break;
        }
    }
}
