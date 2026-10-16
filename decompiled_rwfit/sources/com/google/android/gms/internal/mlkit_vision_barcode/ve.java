package com.google.android.gms.internal.mlkit_vision_barcode;

/* loaded from: classes.dex */
public abstract class ve {
    public static n0.i a(n0.g gVar) {
        androidx.concurrent.futures.b bVar = new androidx.concurrent.futures.b();
        bVar.f1607c = new n0.j();
        n0.i iVar = new n0.i(bVar);
        bVar.f1606b = iVar;
        bVar.f1605a = gVar.getClass();
        try {
            Object b3 = gVar.b(bVar);
            if (b3 != null) {
                bVar.f1605a = b3;
                return iVar;
            }
        } catch (Exception e) {
            iVar.f16358b.i(e);
        }
        return iVar;
    }
}
