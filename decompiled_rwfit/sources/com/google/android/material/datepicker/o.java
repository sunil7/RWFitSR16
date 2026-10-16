package com.google.android.material.datepicker;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.n1;
import com.google.android.material.button.MaterialButton;

/* loaded from: classes.dex */
public final class o extends n1 {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ y f10448a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ MaterialButton f10449b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ MaterialCalendar f10450c;

    public o(MaterialCalendar materialCalendar, y yVar, MaterialButton materialButton) {
        this.f10450c = materialCalendar;
        this.f10448a = yVar;
        this.f10449b = materialButton;
    }

    @Override // androidx.recyclerview.widget.n1
    public final void a(int i3, RecyclerView recyclerView) {
        if (i3 == 0) {
            recyclerView.announceForAccessibility(this.f10449b.getText());
        }
    }

    @Override // androidx.recyclerview.widget.n1
    public final void b(RecyclerView recyclerView, int i3, int i10) {
        MaterialCalendar materialCalendar = this.f10450c;
        int P0 = i3 < 0 ? ((LinearLayoutManager) materialCalendar.f10399i.getLayoutManager()).P0() : ((LinearLayoutManager) materialCalendar.f10399i.getLayoutManager()).Q0();
        y yVar = this.f10448a;
        CalendarConstraints calendarConstraints = yVar.f10481b;
        materialCalendar.e = calendarConstraints.n().m(P0);
        this.f10449b.setText(calendarConstraints.n().m(P0).k(yVar.f10480a));
    }
}
