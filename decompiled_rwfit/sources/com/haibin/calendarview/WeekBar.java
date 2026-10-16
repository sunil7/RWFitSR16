package com.haibin.calendarview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.example.baselibrary.R$array;
import com.example.baselibrary.R$layout;
import md.r;
import md.t;

/* loaded from: classes.dex */
public class WeekBar extends LinearLayout {

    /* renamed from: a, reason: collision with root package name */
    public r f11343a;

    public WeekBar(Context context) {
        super(context);
        if ("com.haibin.calendarview.WeekBar".equals(getClass().getName())) {
            LayoutInflater.from(context).inflate(R$layout.cv_week_bar, (ViewGroup) this, true);
        }
    }

    public final String a(int i3, int i10) {
        String[] stringArray = getContext().getResources().getStringArray(R$array.week_string_array);
        if (i10 == 1) {
            return stringArray[i3];
        }
        if (i10 == 2) {
            return stringArray[i3 == 6 ? 0 : i3 + 1];
        }
        return stringArray[i3 != 0 ? i3 - 1 : 6];
    }

    public void b(Calendar calendar, int i3) {
    }

    public void c(int i3) {
        if ("com.haibin.calendarview.WeekBar".equalsIgnoreCase(getClass().getName())) {
            for (int i10 = 0; i10 < getChildCount(); i10++) {
                ((TextView) getChildAt(i10)).setText(a(i10, i3));
            }
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    public final void onMeasure(int i3, int i10) {
        r rVar = this.f11343a;
        super.onMeasure(i3, rVar != null ? View.MeasureSpec.makeMeasureSpec(rVar.f16054g0, 1073741824) : View.MeasureSpec.makeMeasureSpec(t.e(getContext(), 40.0f), 1073741824));
    }

    public void setTextColor(int i3) {
        for (int i10 = 0; i10 < getChildCount(); i10++) {
            ((TextView) getChildAt(i10)).setTextColor(i3);
        }
    }

    public void setTextSize(int i3) {
        for (int i10 = 0; i10 < getChildCount(); i10++) {
            ((TextView) getChildAt(i10)).setTextSize(0, i3);
        }
    }

    public void setup(r rVar) {
        this.f11343a = rVar;
        if ("com.haibin.calendarview.WeekBar".equalsIgnoreCase(getClass().getName())) {
            setTextSize(this.f11343a.N);
            setTextColor(rVar.f16053g);
            setBackgroundColor(rVar.L);
            setPadding(rVar.f16083w, 0, rVar.f16085x, 0);
        }
    }
}
