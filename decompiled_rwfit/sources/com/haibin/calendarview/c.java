package com.haibin.calendarview;

import android.view.View;
import androidx.viewpager.widget.ViewPager;
import java.util.ArrayList;
import md.t;
import md.y;

/* loaded from: classes.dex */
public final class c extends n2.a {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ YearViewPager f11378c;

    public c(YearViewPager yearViewPager) {
        this.f11378c = yearViewPager;
    }

    @Override // n2.a
    public final void a(ViewPager viewPager, int i3, Object obj) {
        viewPager.removeView((View) obj);
    }

    @Override // n2.a
    public final int c() {
        return this.f11378c.f11369c0;
    }

    @Override // n2.a
    public final int d(Object obj) {
        return this.f11378c.f11370d0 ? -2 : -1;
    }

    @Override // n2.a
    public final Object f(ViewPager viewPager, int i3) {
        YearViewPager yearViewPager = this.f11378c;
        YearRecyclerView yearRecyclerView = new YearRecyclerView(yearViewPager.getContext());
        viewPager.addView(yearRecyclerView);
        yearRecyclerView.setup(yearViewPager.f11371e0);
        yearRecyclerView.setOnMonthSelectedListener(yearViewPager.f11372f0);
        int i10 = i3 + yearViewPager.f11371e0.W;
        java.util.Calendar calendar = java.util.Calendar.getInstance();
        for (int i11 = 1; i11 <= 12; i11++) {
            calendar.set(i10, i11 - 1, 1);
            int j4 = t.j(i10, i11);
            Month month = new Month();
            month.setDiff(t.n(i10, i11, yearRecyclerView.f11349l1.f16044b));
            month.setCount(j4);
            month.setMonth(i11);
            month.setYear(i10);
            y yVar = yearRecyclerView.f11350m1;
            ArrayList arrayList = yVar.f11374a;
            arrayList.add(month);
            yVar.notifyItemChanged(arrayList.size());
        }
        return yearRecyclerView;
    }

    @Override // n2.a
    public final boolean g(View view, Object obj) {
        return view == obj;
    }
}
