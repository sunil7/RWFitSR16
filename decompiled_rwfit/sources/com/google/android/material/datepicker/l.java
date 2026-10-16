package com.google.android.material.datepicker;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.w1;

/* loaded from: classes.dex */
public final class l extends LinearLayoutManager {
    public final /* synthetic */ int E;
    public final /* synthetic */ MaterialCalendar F;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l(MaterialCalendar materialCalendar, int i3, int i10) {
        super(i3);
        this.F = materialCalendar;
        this.E = i10;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.i1
    public final void C0(int i3, RecyclerView recyclerView) {
        c0 c0Var = new c0(recyclerView.getContext());
        c0Var.f2721a = i3;
        D0(c0Var);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    public final void F0(w1 w1Var, int[] iArr) {
        int i3 = this.E;
        MaterialCalendar materialCalendar = this.F;
        if (i3 == 0) {
            iArr[0] = materialCalendar.f10399i.getWidth();
            iArr[1] = materialCalendar.f10399i.getWidth();
        } else {
            iArr[0] = materialCalendar.f10399i.getHeight();
            iArr[1] = materialCalendar.f10399i.getHeight();
        }
    }
}
