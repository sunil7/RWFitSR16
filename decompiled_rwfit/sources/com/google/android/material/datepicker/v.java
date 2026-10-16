package com.google.android.material.datepicker;

import android.content.Context;
import android.icu.text.DateFormat;
import android.icu.util.TimeZone;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.google.android.material.R$layout;
import com.google.android.material.timepicker.TimeModel;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Locale;

/* loaded from: classes.dex */
public final class v extends BaseAdapter {

    /* renamed from: f, reason: collision with root package name */
    public static final int f10471f = e0.f(null).getMaximum(4);

    /* renamed from: a, reason: collision with root package name */
    public final Month f10472a;

    /* renamed from: b, reason: collision with root package name */
    public final DateSelector f10473b;

    /* renamed from: c, reason: collision with root package name */
    public Collection f10474c;

    /* renamed from: d, reason: collision with root package name */
    public c f10475d;
    public final CalendarConstraints e;

    public v(Month month, DateSelector dateSelector, CalendarConstraints calendarConstraints) {
        this.f10472a = month;
        this.f10473b = dateSelector;
        this.e = calendarConstraints;
        this.f10474c = dateSelector.F();
    }

    @Override // android.widget.Adapter
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public final Long getItem(int i3) {
        Month month = this.f10472a;
        if (i3 < month.h() || i3 > b()) {
            return null;
        }
        return Long.valueOf(month.i((i3 - month.h()) + 1));
    }

    public final int b() {
        Month month = this.f10472a;
        return (month.h() + month.f10408d) - 1;
    }

    public final void c(TextView textView, long j4) {
        androidx.appcompat.widget.w wVar;
        if (textView == null) {
            return;
        }
        int i3 = 0;
        if (this.e.j().g(j4)) {
            textView.setEnabled(true);
            ArrayList F = this.f10473b.F();
            int size = F.size();
            while (true) {
                if (i3 < size) {
                    Object obj = F.get(i3);
                    i3++;
                    if (e0.a(j4) == e0.a(((Long) obj).longValue())) {
                        wVar = (androidx.appcompat.widget.w) this.f10475d.f10420b;
                        break;
                    }
                } else {
                    wVar = e0.e().getTimeInMillis() == j4 ? (androidx.appcompat.widget.w) this.f10475d.f10421c : (androidx.appcompat.widget.w) this.f10475d.f10419a;
                }
            }
        } else {
            textView.setEnabled(false);
            wVar = (androidx.appcompat.widget.w) this.f10475d.f10424g;
        }
        wVar.v(textView);
    }

    public final void d(MaterialCalendarGridView materialCalendarGridView, long j4) {
        Month d5 = Month.d(j4);
        Month month = this.f10472a;
        if (d5.equals(month)) {
            c((TextView) materialCalendarGridView.getChildAt((materialCalendarGridView.a().f10472a.h() + (month.j(j4) - 1)) - materialCalendarGridView.getFirstVisiblePosition()), j4);
        }
    }

    @Override // android.widget.Adapter
    public final int getCount() {
        Month month = this.f10472a;
        return month.f10408d + month.h();
    }

    @Override // android.widget.Adapter
    public final long getItemId(int i3) {
        return i3 / this.f10472a.f10407c;
    }

    @Override // android.widget.Adapter
    public final View getView(int i3, View view, ViewGroup viewGroup) {
        Context context = viewGroup.getContext();
        if (this.f10475d == null) {
            this.f10475d = new c(context);
        }
        TextView textView = (TextView) view;
        if (view == null) {
            textView = (TextView) LayoutInflater.from(viewGroup.getContext()).inflate(R$layout.mtrl_calendar_day, viewGroup, false);
        }
        Month month = this.f10472a;
        int h4 = i3 - month.h();
        if (h4 < 0 || h4 >= month.f10408d) {
            textView.setVisibility(8);
            textView.setEnabled(false);
        } else {
            int i10 = h4 + 1;
            textView.setTag(month);
            textView.setText(String.format(textView.getResources().getConfiguration().locale, TimeModel.NUMBER_FORMAT, Integer.valueOf(i10)));
            long i11 = month.i(i10);
            if (month.f10406b == new Month(e0.e()).f10406b) {
                DateFormat instanceForSkeleton = DateFormat.getInstanceForSkeleton("MMMEd", Locale.getDefault());
                instanceForSkeleton.setTimeZone(TimeZone.getTimeZone("UTC"));
                textView.setContentDescription(instanceForSkeleton.format(new Date(i11)));
            } else {
                DateFormat instanceForSkeleton2 = DateFormat.getInstanceForSkeleton("yMMMEd", Locale.getDefault());
                instanceForSkeleton2.setTimeZone(TimeZone.getTimeZone("UTC"));
                textView.setContentDescription(instanceForSkeleton2.format(new Date(i11)));
            }
            textView.setVisibility(0);
            textView.setEnabled(true);
        }
        Long item = getItem(i3);
        if (item == null) {
            return textView;
        }
        c(textView, item.longValue());
        return textView;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public final boolean hasStableIds() {
        return true;
    }
}
