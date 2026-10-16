package com.google.android.gms.internal.mlkit_vision_barcode;

import android.content.Context;
import com.google.android.datatransport.Priority;

/* loaded from: classes.dex */
public final class cg implements uf {

    /* renamed from: a, reason: collision with root package name */
    public final pb.k f9254a;

    /* renamed from: b, reason: collision with root package name */
    public final pb.k f9255b;

    /* renamed from: c, reason: collision with root package name */
    public final tf f9256c;

    public cg(Context context, tf tfVar) {
        this.f9256c = tfVar;
        y7.a aVar = y7.a.e;
        a8.i.b(context);
        de.o c9 = a8.i.a().c(aVar);
        if (y7.a.f20022d.contains(new x7.b("json"))) {
            this.f9254a = new pb.k(new bg(c9, 0));
        }
        this.f9255b = new pb.k(new bg(c9, 1));
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.uf
    public final void a(androidx.appcompat.widget.b0 b0Var) {
        int i3 = this.f9256c.f9534b;
        if (i3 != 0) {
            ((a8.h) this.f9255b.get()).a(b0Var.f872a != 0 ? new x7.a(b0Var.h(i3), Priority.DEFAULT) : new x7.a(b0Var.h(i3), Priority.VERY_LOW));
            return;
        }
        pb.k kVar = this.f9254a;
        if (kVar != null) {
            ((a8.h) kVar.get()).a(b0Var.f872a != 0 ? new x7.a(b0Var.h(i3), Priority.DEFAULT) : new x7.a(b0Var.h(i3), Priority.VERY_LOW));
        }
    }
}
