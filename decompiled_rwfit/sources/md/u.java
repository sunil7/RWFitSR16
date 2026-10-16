package md;

import android.content.Context;
import android.view.View;
import androidx.viewpager.widget.ViewPager;
import com.haibin.calendarview.BaseMonthView;
import com.haibin.calendarview.BaseView;
import com.haibin.calendarview.BaseWeekView;
import com.haibin.calendarview.Calendar;
import com.haibin.calendarview.DefaultMonthView;
import com.haibin.calendarview.DefaultWeekView;
import com.haibin.calendarview.MonthViewPager;
import com.haibin.calendarview.WeekViewPager;

/* loaded from: classes.dex */
public final class u extends n2.a {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f16116c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ ViewPager f16117d;

    public /* synthetic */ u(ViewPager viewPager, int i3) {
        this.f16116c = i3;
        this.f16117d = viewPager;
    }

    @Override // n2.a
    public final void a(ViewPager viewPager, int i3, Object obj) {
        switch (this.f16116c) {
            case 0:
                BaseView baseView = (BaseView) obj;
                baseView.getClass();
                viewPager.removeView(baseView);
                break;
            default:
                BaseWeekView baseWeekView = (BaseWeekView) obj;
                baseWeekView.getClass();
                viewPager.removeView(baseWeekView);
                break;
        }
    }

    @Override // n2.a
    public final int c() {
        switch (this.f16116c) {
            case 0:
                return ((MonthViewPager) this.f16117d).f11336d0;
            default:
                return ((WeekViewPager) this.f16117d).f11345d0;
        }
    }

    @Override // n2.a
    public final int d(Object obj) {
        switch (this.f16116c) {
            case 0:
                if (((MonthViewPager) this.f16117d).f11335c0) {
                }
                break;
            default:
                if (((WeekViewPager) this.f16117d).f11344c0) {
                }
                break;
        }
        return -1;
    }

    @Override // n2.a
    public final Object f(ViewPager viewPager, int i3) {
        switch (this.f16116c) {
            case 0:
                MonthViewPager monthViewPager = (MonthViewPager) this.f16117d;
                r rVar = monthViewPager.f11337e0;
                int i10 = (rVar.Y + i3) - 1;
                int i11 = (i10 / 12) + rVar.W;
                int i12 = (i10 % 12) + 1;
                try {
                    BaseMonthView baseMonthView = (BaseMonthView) rVar.Q.getConstructor(Context.class).newInstance(monthViewPager.getContext());
                    baseMonthView.f11281w = monthViewPager;
                    baseMonthView.f11297n = monthViewPager.i0;
                    baseMonthView.setup(monthViewPager.f11337e0);
                    baseMonthView.setTag(Integer.valueOf(i3));
                    baseMonthView.f11282x = i11;
                    baseMonthView.f11283y = i12;
                    baseMonthView.g();
                    int i13 = baseMonthView.f11299p;
                    r rVar2 = baseMonthView.f11285a;
                    baseMonthView.A = t.m(i11, i12, i13, rVar2.f16044b, rVar2.f16046c);
                    baseMonthView.setSelectedCalendar(monthViewPager.f11337e0.f16073q0);
                    viewPager.addView(baseMonthView);
                    return baseMonthView;
                } catch (Exception e) {
                    e.printStackTrace();
                    return new DefaultMonthView(monthViewPager.getContext());
                }
            default:
                WeekViewPager weekViewPager = (WeekViewPager) this.f16117d;
                r rVar3 = weekViewPager.f11346e0;
                Calendar i14 = t.i(rVar3.W, rVar3.Y, rVar3.f16043a0, i3 + 1, rVar3.f16044b);
                try {
                    BaseWeekView baseWeekView = (BaseWeekView) weekViewPager.f11346e0.R.getConstructor(Context.class).newInstance(weekViewPager.getContext());
                    baseWeekView.f11297n = weekViewPager.f11347f0;
                    baseWeekView.setup(weekViewPager.f11346e0);
                    baseWeekView.setup(i14);
                    baseWeekView.setTag(Integer.valueOf(i3));
                    baseWeekView.setSelectedCalendar(weekViewPager.f11346e0.f16073q0);
                    viewPager.addView(baseWeekView);
                    return baseWeekView;
                } catch (Exception e10) {
                    e10.printStackTrace();
                    return new DefaultWeekView(weekViewPager.getContext());
                }
        }
    }

    @Override // n2.a
    public final boolean g(View view, Object obj) {
        switch (this.f16116c) {
        }
        return view.equals(obj);
    }
}
