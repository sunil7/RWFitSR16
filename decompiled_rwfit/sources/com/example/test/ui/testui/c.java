package com.example.test.ui.testui;

import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.z1;
import java.util.Collections;

/* loaded from: classes.dex */
public final class c extends androidx.recyclerview.widget.g0 {

    /* renamed from: a, reason: collision with root package name */
    public final q6.c f8265a;

    public c(q6.c cVar) {
        this.f8265a = cVar;
    }

    @Override // androidx.recyclerview.widget.g0
    public final int getMovementFlags(RecyclerView recyclerView, z1 z1Var) {
        return androidx.recyclerview.widget.g0.makeMovementFlags(3, 0);
    }

    @Override // androidx.recyclerview.widget.g0
    public final boolean onMove(RecyclerView recyclerView, z1 z1Var, z1 z1Var2) {
        int adapterPosition = z1Var.getAdapterPosition();
        int adapterPosition2 = z1Var2.getAdapterPosition();
        q6.c cVar = this.f8265a;
        Collections.swap(cVar.f17792a, adapterPosition, adapterPosition2);
        cVar.notifyItemMoved(adapterPosition, adapterPosition2);
        return true;
    }

    @Override // androidx.recyclerview.widget.g0
    public final void onSwiped(z1 z1Var, int i3) {
    }
}
