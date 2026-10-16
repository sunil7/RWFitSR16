package com.google.android.material.datepicker;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.google.android.material.R$layout;
import com.google.android.material.R$string;
import java.util.Calendar;
import java.util.Locale;

/* loaded from: classes.dex */
public final class k extends BaseAdapter {

    /* renamed from: a, reason: collision with root package name */
    public final Calendar f10441a;

    /* renamed from: b, reason: collision with root package name */
    public final int f10442b;

    /* renamed from: c, reason: collision with root package name */
    public final int f10443c;

    public k() {
        Calendar f2 = e0.f(null);
        this.f10441a = f2;
        this.f10442b = f2.getMaximum(7);
        this.f10443c = f2.getFirstDayOfWeek();
    }

    @Override // android.widget.Adapter
    public final int getCount() {
        return this.f10442b;
    }

    @Override // android.widget.Adapter
    public final Object getItem(int i3) {
        int i10 = this.f10442b;
        if (i3 >= i10) {
            return null;
        }
        int i11 = i3 + this.f10443c;
        if (i11 > i10) {
            i11 -= i10;
        }
        return Integer.valueOf(i11);
    }

    @Override // android.widget.Adapter
    public final long getItemId(int i3) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public final View getView(int i3, View view, ViewGroup viewGroup) {
        TextView textView = (TextView) view;
        if (view == null) {
            textView = (TextView) LayoutInflater.from(viewGroup.getContext()).inflate(R$layout.mtrl_calendar_day_of_week, viewGroup, false);
        }
        int i10 = i3 + this.f10443c;
        int i11 = this.f10442b;
        if (i10 > i11) {
            i10 -= i11;
        }
        Calendar calendar = this.f10441a;
        calendar.set(7, i10);
        textView.setText(calendar.getDisplayName(7, 4, textView.getResources().getConfiguration().locale));
        textView.setContentDescription(String.format(viewGroup.getContext().getString(R$string.mtrl_picker_day_of_week_column_header), calendar.getDisplayName(7, 2, Locale.getDefault())));
        return textView;
    }
}
