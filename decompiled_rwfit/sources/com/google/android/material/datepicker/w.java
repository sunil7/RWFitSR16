package com.google.android.material.datepicker;

import android.view.View;
import android.widget.AdapterView;
import androidx.recyclerview.widget.RecyclerView;
import java.util.Iterator;

/* loaded from: classes.dex */
public final class w implements AdapterView.OnItemClickListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ MaterialCalendarGridView f10476a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ y f10477b;

    public w(y yVar, MaterialCalendarGridView materialCalendarGridView) {
        this.f10477b = yVar;
        this.f10476a = materialCalendarGridView;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public final void onItemClick(AdapterView adapterView, View view, int i3, long j4) {
        MaterialCalendarGridView materialCalendarGridView = this.f10476a;
        v a3 = materialCalendarGridView.a();
        if (i3 < a3.f10472a.h() || i3 > a3.b()) {
            return;
        }
        m mVar = this.f10477b.f10483d;
        long longValue = materialCalendarGridView.a().getItem(i3).longValue();
        MaterialCalendar materialCalendar = mVar.f10444a;
        if (materialCalendar.f10395d.j().g(longValue)) {
            materialCalendar.f10394c.O(longValue);
            Iterator it = materialCalendar.f10484a.iterator();
            while (it.hasNext()) {
                ((r) it.next()).b(materialCalendar.f10394c.I());
            }
            materialCalendar.f10399i.getAdapter().notifyDataSetChanged();
            RecyclerView recyclerView = materialCalendar.f10398h;
            if (recyclerView != null) {
                recyclerView.getAdapter().notifyDataSetChanged();
            }
        }
    }
}
