package com.google.android.gms.internal.mlkit_common;

import android.content.Context;
import com.google.android.gms.internal.mlkit_vision_barcode.ag;
import com.google.android.gms.internal.mlkit_vision_barcode.tf;
import com.google.android.gms.internal.mlkit_vision_barcode.vf;
import com.google.android.gms.internal.mlkit_vision_common.ga;
import com.google.android.gms.internal.mlkit_vision_common.ia;
import com.google.android.gms.internal.mlkit_vision_common.ja;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class l extends a4.a {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f9180b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ l(int i3) {
        super(4);
        this.f9180b = i3;
    }

    @Override // a4.a
    public final Object b(Object obj) {
        switch (this.f9180b) {
            case 0:
                gc.e c9 = gc.e.c();
                Context b3 = gc.e.c().b();
                ArrayList arrayList = new ArrayList();
                ec.a aVar = new ec.a(6);
                y7.a aVar2 = y7.a.e;
                a8.i.b(b3);
                a8.i.a().c(aVar2);
                y7.a.f20022d.contains(new x7.b("json"));
                arrayList.add(aVar);
                return new k(c9.b(), (gc.h) c9.a(gc.h.class));
            case 1:
                tf tfVar = (tf) obj;
                gc.e c10 = gc.e.c();
                return new ag(c10.b(), (gc.h) c10.a(gc.h.class), new vf(gc.e.c().b(), tfVar), tfVar.f9533a);
            default:
                gc.e c11 = gc.e.c();
                return new ja(c11.b(), (gc.h) c11.a(gc.h.class), new ia(gc.e.c().b(), (ga) obj));
        }
    }
}
