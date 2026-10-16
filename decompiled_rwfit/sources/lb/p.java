package lb;

import com.google.android.gms.internal.mlkit_vision_barcode_bundled.b1;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.i1;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.l0;

/* loaded from: classes.dex */
public final class p extends l0 implements b1 {
    private static final p zzb;

    static {
        p pVar = new p();
        zzb = pVar;
        l0.h(p.class, pVar);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.l0
    public final Object m(int i3, l0 l0Var) {
        int i10 = i3 - 1;
        if (i10 == 0) {
            return (byte) 1;
        }
        if (i10 == 2) {
            return new i1(zzb, "\u0001\u0000", null);
        }
        if (i10 == 3) {
            return new p();
        }
        if (i10 == 4) {
            return new k(zzb);
        }
        if (i10 != 5) {
            return null;
        }
        return zzb;
    }
}
