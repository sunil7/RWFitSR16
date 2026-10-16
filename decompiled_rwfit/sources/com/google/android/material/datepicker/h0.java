package com.google.android.material.datepicker;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.z0;
import androidx.recyclerview.widget.z1;
import com.google.android.material.R$layout;
import com.google.android.material.R$string;
import com.google.android.material.timepicker.TimeModel;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;

/* loaded from: classes.dex */
public final class h0 extends z0 {

    /* renamed from: a, reason: collision with root package name */
    public final MaterialCalendar f10432a;

    public h0(MaterialCalendar materialCalendar) {
        this.f10432a = materialCalendar;
    }

    @Override // androidx.recyclerview.widget.z0
    public final int getItemCount() {
        return this.f10432a.f10395d.o();
    }

    @Override // androidx.recyclerview.widget.z0
    public final void onBindViewHolder(z1 z1Var, int i3) {
        MaterialCalendar materialCalendar = this.f10432a;
        int i10 = materialCalendar.f10395d.n().f10406b + i3;
        TextView textView = ((g0) z1Var).f10429a;
        String string = textView.getContext().getString(R$string.mtrl_picker_navigate_to_year_description);
        textView.setText(String.format(Locale.getDefault(), TimeModel.NUMBER_FORMAT, Integer.valueOf(i10)));
        textView.setContentDescription(String.format(string, Integer.valueOf(i10)));
        c cVar = materialCalendar.f10397g;
        Calendar e = e0.e();
        androidx.appcompat.widget.w wVar = (androidx.appcompat.widget.w) (e.get(1) == i10 ? cVar.f10423f : cVar.f10422d);
        ArrayList F = materialCalendar.f10394c.F();
        int size = F.size();
        int i11 = 0;
        while (i11 < size) {
            Object obj = F.get(i11);
            i11++;
            e.setTimeInMillis(((Long) obj).longValue());
            if (e.get(1) == i10) {
                wVar = (androidx.appcompat.widget.w) cVar.e;
            }
        }
        wVar.v(textView);
        textView.setOnClickListener(new f0(this, i10));
    }

    @Override // androidx.recyclerview.widget.z0
    public final z1 onCreateViewHolder(ViewGroup viewGroup, int i3) {
        return new g0((TextView) LayoutInflater.from(viewGroup.getContext()).inflate(R$layout.mtrl_calendar_year, viewGroup, false));
    }
}
