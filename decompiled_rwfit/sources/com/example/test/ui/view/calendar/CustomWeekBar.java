package com.example.test.ui.view.calendar;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;
import com.example.test.R$layout;
import com.haibin.calendarview.Calendar;
import com.haibin.calendarview.WeekBar;

/* loaded from: classes.dex */
public class CustomWeekBar extends WeekBar {

    /* renamed from: b, reason: collision with root package name */
    public int f8678b;

    public CustomWeekBar(Context context) {
        super(context);
        LayoutInflater.from(context).inflate(R$layout.custom_week_bar, (ViewGroup) this, true);
    }

    @Override // com.haibin.calendarview.WeekBar
    public final void b(Calendar calendar, int i3) {
        int i10 = 0;
        getChildAt(this.f8678b).setSelected(false);
        int week = calendar.getWeek();
        int i11 = week + 1;
        if (i3 == 1) {
            i10 = week;
        } else if (i3 == 2) {
            i10 = i11 == 1 ? 6 : week - 1;
        } else if (i11 != 7) {
            i10 = i11;
        }
        getChildAt(i10).setSelected(true);
        this.f8678b = i10;
    }

    @Override // com.haibin.calendarview.WeekBar
    public final void c(int i3) {
        for (int i10 = 0; i10 < getChildCount(); i10++) {
            ((TextView) getChildAt(i10)).setText(a(i10, i3));
        }
    }
}
