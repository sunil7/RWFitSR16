package b7;

import android.util.Log;
import android.view.ViewGroup;
import com.example.test.R$string;
import com.example.test.ui.testui.TRingPCycleStatisticsActivity;
import com.example.test.ui.view.MainBottomTabView;
import com.example.test.ui.view.weekcalendar.WeekCalendar;
import com.google.android.gms.internal.mlkit_vision_barcode.l0;
import com.haibin.calendarview.BaseMonthView;
import com.haibin.calendarview.BaseWeekView;
import com.haibin.calendarview.Calendar;
import com.haibin.calendarview.CalendarLayout;
import com.haibin.calendarview.CalendarView;
import com.haibin.calendarview.MonthViewPager;
import com.haibin.calendarview.WeekViewPager;
import eh.b;
import f6.c1;
import kotlin.jvm.internal.e;
import md.k;
import md.m;
import md.r;
import md.s;
import md.t;
import n2.j;

/* loaded from: classes.dex */
public final class a implements j {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3163a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ViewGroup f3164b;

    public /* synthetic */ a(ViewGroup viewGroup, int i3) {
        this.f3163a = i3;
        this.f3164b = viewGroup;
    }

    private final void c(int i3) {
    }

    private final void e(int i3) {
    }

    private final void f(int i3) {
    }

    private final void g(int i3) {
    }

    private final void h(int i3) {
    }

    private final void i(float f2, int i3) {
    }

    private final void j(float f2, int i3) {
    }

    private final void k(float f2, int i3) {
    }

    private final void l(int i3) {
    }

    @Override // n2.j
    public final void a(int i3) {
        int i10 = this.f3163a;
    }

    @Override // n2.j
    public final void b(int i3) {
        CalendarLayout calendarLayout;
        ViewGroup viewGroup = this.f3164b;
        switch (this.f3163a) {
            case 0:
                int i10 = WeekCalendar.f8709j;
                WeekCalendar weekCalendar = (WeekCalendar) viewGroup;
                weekCalendar.f8717i.f3398g.plusWeeks(i3 - weekCalendar.f8711b);
                break;
            case 1:
                break;
            case 2:
                CalendarView calendarView = (CalendarView) viewGroup;
                if (calendarView.f11326c.getVisibility() != 0) {
                    calendarView.f11324a.getClass();
                    break;
                }
                break;
            case 3:
                MonthViewPager monthViewPager = (MonthViewPager) viewGroup;
                r rVar = monthViewPager.f11337e0;
                Calendar calendar = new Calendar();
                calendar.setYear((((rVar.Y + i3) - 1) / 12) + rVar.W);
                calendar.setMonth((((rVar.Y + i3) - 1) % 12) + 1);
                if (rVar.f16042a != 0) {
                    int j4 = t.j(calendar.getYear(), calendar.getMonth());
                    Calendar calendar2 = rVar.f16074r0;
                    if (calendar2 == null || calendar2.getDay() == 0) {
                        j4 = 1;
                    } else if (j4 >= calendar2.getDay()) {
                        j4 = calendar2.getDay();
                    }
                    calendar.setDay(j4);
                } else {
                    calendar.setDay(1);
                }
                if (!t.y(calendar, rVar)) {
                    java.util.Calendar calendar3 = java.util.Calendar.getInstance();
                    calendar3.set(rVar.W, rVar.Y - 1, rVar.f16043a0, 12, 0);
                    long timeInMillis = calendar3.getTimeInMillis();
                    calendar3.set(calendar.getYear(), calendar.getMonth() - 1, calendar.getDay(), 12, 0);
                    calendar = calendar3.getTimeInMillis() < timeInMillis ? rVar.d() : rVar.c();
                }
                calendar.setCurrentMonth(calendar.getYear() == rVar.f16056h0.getYear() && calendar.getMonth() == rVar.f16056h0.getMonth());
                calendar.setCurrentDay(calendar.equals(rVar.f16056h0));
                s.c(calendar);
                if (monthViewPager.getVisibility() == 0) {
                    r rVar2 = monthViewPager.f11337e0;
                    rVar2.getClass();
                    if (rVar2.f16074r0 != null && calendar.getYear() != monthViewPager.f11337e0.f16074r0.getYear()) {
                        monthViewPager.f11337e0.getClass();
                    }
                    monthViewPager.f11337e0.f16074r0 = calendar;
                }
                m mVar = monthViewPager.f11337e0.f16071p0;
                if (mVar != null) {
                    int year = calendar.getYear();
                    int month = calendar.getMonth();
                    int i11 = TRingPCycleStatisticsActivity.I;
                    TRingPCycleStatisticsActivity tRingPCycleStatisticsActivity = (TRingPCycleStatisticsActivity) ((af.a) mVar).f277b;
                    Integer num = tRingPCycleStatisticsActivity.G;
                    Integer num2 = tRingPCycleStatisticsActivity.F;
                    String str = tRingPCycleStatisticsActivity.H;
                    StringBuilder s7 = l0.s(year, "Year = ", month, "---Month = ", " mensDays ");
                    s7.append(num);
                    s7.append(" mensCycleDays ");
                    s7.append(num2);
                    s7.append(" mensStartDate ");
                    s7.append(str);
                    Log.e("tong", s7.toString());
                    b bVar = tRingPCycleStatisticsActivity.f7247z;
                    ((c1) bVar.getValue()).f12761d.setText(month + tRingPCycleStatisticsActivity.getString(R$string.str_tab_month) + " " + year);
                    String str2 = tRingPCycleStatisticsActivity.H;
                    e.c(str2);
                    Integer num3 = tRingPCycleStatisticsActivity.F;
                    e.c(num3);
                    int intValue = num3.intValue();
                    Integer num4 = tRingPCycleStatisticsActivity.G;
                    e.c(num4);
                    ((c1) bVar.getValue()).f12759b.setSchemeDate(TRingPCycleStatisticsActivity.S0(TRingPCycleStatisticsActivity.R0(year, month, str2, intValue, num4.intValue())));
                }
                if (monthViewPager.f11341j0.getVisibility() != 0) {
                    r rVar3 = monthViewPager.f11337e0;
                    if (rVar3.f16048d == 0) {
                        if (calendar.isCurrentMonth()) {
                            r rVar4 = monthViewPager.f11337e0;
                            rVar4.f16073q0 = (!t.y(rVar4.f16056h0, rVar4) || rVar4.f16042a == 2) ? t.y(calendar, rVar4) ? calendar : rVar4.d().isSameMonth(calendar) ? rVar4.d() : rVar4.c() : rVar4.b();
                        } else {
                            monthViewPager.f11337e0.f16073q0 = calendar;
                        }
                        r rVar5 = monthViewPager.f11337e0;
                        rVar5.f16074r0 = rVar5.f16073q0;
                    } else {
                        Calendar calendar4 = rVar3.f16080u0;
                        if (calendar4 != null && calendar4.isSameMonth(rVar3.f16074r0)) {
                            r rVar6 = monthViewPager.f11337e0;
                            rVar6.f16074r0 = rVar6.f16080u0;
                        } else if (calendar.isSameMonth(monthViewPager.f11337e0.f16073q0)) {
                            r rVar7 = monthViewPager.f11337e0;
                            rVar7.f16074r0 = rVar7.f16073q0;
                        }
                    }
                    monthViewPager.f11337e0.f();
                    if (!monthViewPager.U0) {
                        r rVar8 = monthViewPager.f11337e0;
                        if (rVar8.f16048d == 0) {
                            monthViewPager.f11342k0.b(rVar8.f16073q0, rVar8.f16044b);
                            r rVar9 = monthViewPager.f11337e0;
                            k kVar = rVar9.f16067n0;
                            if (kVar != null) {
                                kVar.o(rVar9.f16073q0);
                            }
                        }
                    }
                    BaseMonthView baseMonthView = (BaseMonthView) monthViewPager.findViewWithTag(Integer.valueOf(i3));
                    if (baseMonthView != null) {
                        int indexOf = baseMonthView.f11298o.indexOf(monthViewPager.f11337e0.f16074r0);
                        if (monthViewPager.f11337e0.f16048d == 0) {
                            baseMonthView.f11304v = indexOf;
                        }
                        if (indexOf >= 0 && (calendarLayout = monthViewPager.i0) != null) {
                            calendarLayout.g(indexOf);
                        }
                        baseMonthView.invalidate();
                    }
                    monthViewPager.f11341j0.y(monthViewPager.f11337e0.f16074r0);
                    monthViewPager.y(calendar.getYear(), calendar.getMonth());
                    monthViewPager.U0 = false;
                    break;
                } else {
                    monthViewPager.y(calendar.getYear(), calendar.getMonth());
                    break;
                }
                break;
            default:
                WeekViewPager weekViewPager = (WeekViewPager) viewGroup;
                if (weekViewPager.getVisibility() == 0) {
                    if (!weekViewPager.f11348g0) {
                        BaseWeekView baseWeekView = (BaseWeekView) weekViewPager.findViewWithTag(Integer.valueOf(i3));
                        if (baseWeekView != null) {
                            r rVar10 = weekViewPager.f11346e0;
                            baseWeekView.h(rVar10.f16048d != 0 ? rVar10.f16074r0 : rVar10.f16073q0, true ^ weekViewPager.f11348g0);
                            weekViewPager.f11346e0.getClass();
                        }
                        weekViewPager.f11348g0 = false;
                        break;
                    } else {
                        weekViewPager.f11348g0 = false;
                        break;
                    }
                } else {
                    weekViewPager.f11348g0 = false;
                    break;
                }
        }
    }

    @Override // n2.j
    public final void d(float f2, int i3) {
        float f10;
        int i10;
        switch (this.f3163a) {
            case 1:
                ((MainBottomTabView) this.f3164b).setTabPosition(i3);
                break;
            case 3:
                MonthViewPager monthViewPager = (MonthViewPager) this.f3164b;
                if (monthViewPager.f11337e0.f16046c != 0) {
                    if (i3 < monthViewPager.getCurrentItem()) {
                        f10 = (1.0f - f2) * monthViewPager.f11339g0;
                        i10 = monthViewPager.f11340h0;
                    } else {
                        f10 = (1.0f - f2) * monthViewPager.f11340h0;
                        i10 = monthViewPager.f11338f0;
                    }
                    int i11 = (int) ((i10 * f2) + f10);
                    ViewGroup.LayoutParams layoutParams = monthViewPager.getLayoutParams();
                    layoutParams.height = i11;
                    monthViewPager.setLayoutParams(layoutParams);
                    break;
                }
                break;
        }
    }
}
