package com.google.android.material.datepicker;

import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;

/* loaded from: classes.dex */
public final class p implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f10451a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ y f10452b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ MaterialCalendar f10453c;

    public /* synthetic */ p(MaterialCalendar materialCalendar, y yVar, int i3) {
        this.f10451a = i3;
        this.f10453c = materialCalendar;
        this.f10452b = yVar;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        switch (this.f10451a) {
            case 0:
                MaterialCalendar materialCalendar = this.f10453c;
                int P0 = ((LinearLayoutManager) materialCalendar.f10399i.getLayoutManager()).P0() + 1;
                if (P0 < materialCalendar.f10399i.getAdapter().getItemCount()) {
                    materialCalendar.W(this.f10452b.f10481b.n().m(P0));
                    break;
                }
                break;
            default:
                MaterialCalendar materialCalendar2 = this.f10453c;
                int Q0 = ((LinearLayoutManager) materialCalendar2.f10399i.getLayoutManager()).Q0() - 1;
                if (Q0 >= 0) {
                    materialCalendar2.W(this.f10452b.f10481b.n().m(Q0));
                    break;
                }
                break;
        }
    }
}
