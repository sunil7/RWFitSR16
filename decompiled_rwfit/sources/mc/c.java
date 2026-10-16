package mc;

import android.content.Context;
import com.google.android.gms.dynamite.descriptors.com.google.mlkit.dynamite.barcode.ModuleDescriptor;
import com.google.android.gms.internal.mlkit_vision_barcode.ag;
import com.google.android.gms.internal.mlkit_vision_barcode.dg;
import com.google.android.gms.internal.mlkit_vision_barcode.zzcs;

/* loaded from: classes.dex */
public final class c extends a4.a {

    /* renamed from: b, reason: collision with root package name */
    public final gc.e f16006b;

    public c(gc.e eVar) {
        super(4);
        this.f16006b = eVar;
    }

    @Override // a4.a
    public final Object b(Object obj) {
        f hVar;
        ic.b bVar = (ic.b) obj;
        gc.e eVar = this.f16006b;
        Context b3 = eVar.b();
        ag e = dg.e(true != a.c() ? "play-services-mlkit-barcode-scanning" : "barcode-scanning");
        zzcs zzcsVar = h.f16023h;
        if (ca.d.a(b3, ModuleDescriptor.MODULE_ID) <= 0) {
            n9.c.f16440b.getClass();
            if (n9.c.a(b3) < 204500000) {
                hVar = new i(b3, bVar, e);
                return new e(eVar, bVar, hVar, e);
            }
        }
        hVar = new h(b3, bVar, e);
        return new e(eVar, bVar, hVar, e);
    }
}
