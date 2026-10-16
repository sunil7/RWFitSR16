package com.google.android.material.datepicker;

import android.view.View;
import com.google.android.material.datepicker.MaterialCalendar;

/* loaded from: classes.dex */
public final class f0 implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f10427a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ h0 f10428b;

    public f0(h0 h0Var, int i3) {
        this.f10428b = h0Var;
        this.f10427a = i3;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        h0 h0Var = this.f10428b;
        Month b3 = Month.b(this.f10427a, h0Var.f10432a.e.f10405a);
        MaterialCalendar materialCalendar = h0Var.f10432a;
        materialCalendar.W(materialCalendar.f10395d.i(b3));
        materialCalendar.X(MaterialCalendar.CalendarSelector.DAY);
    }
}
