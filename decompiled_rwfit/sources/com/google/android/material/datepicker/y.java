package com.google.android.material.datepicker;

import android.R;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import androidx.recyclerview.widget.j1;
import androidx.recyclerview.widget.z0;
import androidx.recyclerview.widget.z1;
import com.google.android.material.R$dimen;
import com.google.android.material.R$id;
import com.google.android.material.R$layout;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes.dex */
public final class y extends z0 {

    /* renamed from: a, reason: collision with root package name */
    public final ContextThemeWrapper f10480a;

    /* renamed from: b, reason: collision with root package name */
    public final CalendarConstraints f10481b;

    /* renamed from: c, reason: collision with root package name */
    public final DateSelector f10482c;

    /* renamed from: d, reason: collision with root package name */
    public final m f10483d;
    public final int e;

    public y(ContextThemeWrapper contextThemeWrapper, DateSelector dateSelector, CalendarConstraints calendarConstraints, m mVar) {
        Month n4 = calendarConstraints.n();
        Month k10 = calendarConstraints.k();
        Month m10 = calendarConstraints.m();
        if (n4.compareTo(m10) > 0) {
            throw new IllegalArgumentException("firstPage cannot be after currentPage");
        }
        if (m10.compareTo(k10) > 0) {
            throw new IllegalArgumentException("currentPage cannot be after lastPage");
        }
        int dimensionPixelSize = contextThemeWrapper.getResources().getDimensionPixelSize(R$dimen.mtrl_calendar_day_height) * v.f10471f;
        int dimensionPixelSize2 = s.Z(contextThemeWrapper, R.attr.windowFullscreen) ? contextThemeWrapper.getResources().getDimensionPixelSize(R$dimen.mtrl_calendar_day_height) : 0;
        this.f10480a = contextThemeWrapper;
        this.e = dimensionPixelSize + dimensionPixelSize2;
        this.f10481b = calendarConstraints;
        this.f10482c = dateSelector;
        this.f10483d = mVar;
        setHasStableIds(true);
    }

    @Override // androidx.recyclerview.widget.z0
    public final int getItemCount() {
        return this.f10481b.l();
    }

    @Override // androidx.recyclerview.widget.z0
    public final long getItemId(int i3) {
        return this.f10481b.n().m(i3).l();
    }

    @Override // androidx.recyclerview.widget.z0
    public final void onBindViewHolder(z1 z1Var, int i3) {
        x xVar = (x) z1Var;
        CalendarConstraints calendarConstraints = this.f10481b;
        Month m10 = calendarConstraints.n().m(i3);
        xVar.f10478a.setText(m10.k(xVar.itemView.getContext()));
        MaterialCalendarGridView materialCalendarGridView = (MaterialCalendarGridView) xVar.f10479b.findViewById(R$id.month_grid);
        if (materialCalendarGridView.a() == null || !m10.equals(materialCalendarGridView.a().f10472a)) {
            v vVar = new v(m10, this.f10482c, calendarConstraints);
            materialCalendarGridView.setNumColumns(m10.f10407c);
            materialCalendarGridView.setAdapter((ListAdapter) vVar);
        } else {
            materialCalendarGridView.invalidate();
            v a3 = materialCalendarGridView.a();
            Iterator it = a3.f10474c.iterator();
            while (it.hasNext()) {
                a3.d(materialCalendarGridView, ((Long) it.next()).longValue());
            }
            DateSelector dateSelector = a3.f10473b;
            if (dateSelector != null) {
                ArrayList F = dateSelector.F();
                int size = F.size();
                int i10 = 0;
                while (i10 < size) {
                    Object obj = F.get(i10);
                    i10++;
                    a3.d(materialCalendarGridView, ((Long) obj).longValue());
                }
                a3.f10474c = dateSelector.F();
            }
        }
        materialCalendarGridView.setOnItemClickListener(new w(this, materialCalendarGridView));
    }

    @Override // androidx.recyclerview.widget.z0
    public final z1 onCreateViewHolder(ViewGroup viewGroup, int i3) {
        LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(viewGroup.getContext()).inflate(R$layout.mtrl_calendar_month_labeled, viewGroup, false);
        if (!s.Z(viewGroup.getContext(), R.attr.windowFullscreen)) {
            return new x(linearLayout, false);
        }
        linearLayout.setLayoutParams(new j1(-1, this.e));
        return new x(linearLayout, true);
    }
}
