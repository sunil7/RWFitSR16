package lb;

import com.google.android.gms.internal.mlkit_vision_barcode_bundled.b1;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.h1;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.i1;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.l0;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.q;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.r0;

/* loaded from: classes.dex */
public final class g extends l0 implements b1 {
    private static final g zzb;
    private r0 zzd = h1.f9791d;

    static {
        g gVar = new g();
        zzb = gVar;
        l0.h(g.class, gVar);
    }

    public static f n() {
        return (f) zzb.d();
    }

    public static void o(g gVar, e eVar) {
        r0 r0Var = gVar.zzd;
        if (!((q) r0Var).f9816a) {
            int size = r0Var.size();
            gVar.zzd = r0Var.b(size == 0 ? 10 : size + size);
        }
        gVar.zzd.add(eVar);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.l0
    public final Object m(int i3, l0 l0Var) {
        int i10 = i3 - 1;
        if (i10 == 0) {
            return (byte) 1;
        }
        if (i10 == 2) {
            return new i1(zzb, "\u0004\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"zzd", e.class});
        }
        if (i10 == 3) {
            return new g();
        }
        if (i10 == 4) {
            return new f(zzb);
        }
        if (i10 != 5) {
            return null;
        }
        return zzb;
    }
}
