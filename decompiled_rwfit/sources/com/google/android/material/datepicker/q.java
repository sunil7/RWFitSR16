package com.google.android.material.datepicker;

import android.view.View;
import androidx.fragment.app.Fragment;
import com.google.android.material.datepicker.MaterialCalendar;
import java.util.Iterator;

/* loaded from: classes.dex */
public final class q implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f10454a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Fragment f10455b;

    public /* synthetic */ q(Fragment fragment, int i3) {
        this.f10454a = i3;
        this.f10455b = fragment;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        switch (this.f10454a) {
            case 0:
                s sVar = (s) this.f10455b;
                Iterator it = sVar.f10458q.iterator();
                if (!it.hasNext()) {
                    sVar.I(false, false);
                    return;
                } else {
                    if (it.next() != null) {
                        throw new ClassCastException();
                    }
                    sVar.f10462v.getClass();
                    throw null;
                }
            case 1:
                s sVar2 = (s) this.f10455b;
                Iterator it2 = sVar2.r.iterator();
                while (it2.hasNext()) {
                    ((View.OnClickListener) it2.next()).onClick(view);
                }
                sVar2.I(false, false);
                return;
            case 2:
                s sVar3 = (s) this.f10455b;
                sVar3.G.setEnabled(sVar3.f10462v.A());
                sVar3.E.toggle();
                sVar3.m0(sVar3.E);
                sVar3.e0();
                return;
            default:
                MaterialCalendar materialCalendar = (MaterialCalendar) this.f10455b;
                MaterialCalendar.CalendarSelector calendarSelector = materialCalendar.f10396f;
                MaterialCalendar.CalendarSelector calendarSelector2 = MaterialCalendar.CalendarSelector.YEAR;
                if (calendarSelector == calendarSelector2) {
                    materialCalendar.X(MaterialCalendar.CalendarSelector.DAY);
                    return;
                } else {
                    if (calendarSelector == MaterialCalendar.CalendarSelector.DAY) {
                        materialCalendar.X(calendarSelector2);
                        return;
                    }
                    return;
                }
        }
    }
}
