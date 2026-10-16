package com.google.mlkit.vision.barcode.internal;

import com.google.android.gms.internal.mlkit_vision_barcode.zzcs;
import f8.f;
import gc.b;
import gc.d;
import gc.e;
import java.util.List;
import pb.a;
import pb.c;
import pb.i;

/* loaded from: classes.dex */
public class BarcodeRegistrar implements c {
    @Override // pb.c
    public final List a() {
        f a3 = a.a(mc.c.class);
        a3.a(new i(1, 0, e.class));
        a3.e = new b(15);
        a b3 = a3.b();
        f a10 = a.a(mc.b.class);
        a10.a(new i(1, 0, mc.c.class));
        a10.a(new i(1, 0, d.class));
        a10.a(new i(1, 0, e.class));
        a10.e = new hc.a(15);
        return zzcs.zzh(b3, a10.b());
    }
}
