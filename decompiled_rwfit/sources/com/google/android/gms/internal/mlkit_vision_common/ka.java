package com.google.android.gms.internal.mlkit_vision_common;

import android.content.Context;
import com.google.android.datatransport.Priority;
import com.google.android.gms.internal.mlkit_vision_barcode.bg;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;

/* loaded from: classes.dex */
public final class ka implements ha {

    /* renamed from: a, reason: collision with root package name */
    public final pb.k f10025a;

    /* renamed from: b, reason: collision with root package name */
    public final ga f10026b;

    public ka(Context context, ga gaVar) {
        this.f10026b = gaVar;
        y7.a aVar = y7.a.e;
        a8.i.b(context);
        de.o c9 = a8.i.a().c(aVar);
        if (y7.a.f20022d.contains(new x7.b("json"))) {
            new pb.k(new bg(c9, 2));
        }
        this.f10025a = new pb.k(new bg(c9, 3));
    }

    @Override // com.google.android.gms.internal.mlkit_vision_common.ha
    public final void a(ef.i iVar) {
        a8.h hVar = (a8.h) this.f10025a.get();
        ((a2.i) iVar.f12630c).f45i = false;
        a2.i iVar2 = (a2.i) iVar.f12630c;
        iVar2.f43g = Boolean.FALSE;
        j9 j9Var = new j9(iVar2);
        de.o oVar = (de.o) iVar.f12629b;
        oVar.f12377b = j9Var;
        try {
            na.b();
            na naVar = na.f10049c;
            j7 j7Var = new j7(oVar);
            h hVar2 = new h();
            naVar.a(hVar2);
            hVar.a(new x7.a(new h(new HashMap(hVar2.f9930a), new HashMap(hVar2.f9931b), hVar2.f9932c).b(j7Var), Priority.VERY_LOW));
        } catch (UnsupportedEncodingException e) {
            throw new UnsupportedOperationException("Failed to covert logging to UTF-8 byte array", e);
        }
    }
}
