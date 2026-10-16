package pc;

import com.google.android.gms.internal.mlkit_vision_barcode_bundled.b1;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.h1;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.i1;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.l0;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.r0;

/* loaded from: classes.dex */
public final class l extends l0 implements b1 {
    private static final l zzb;
    private int zzd;
    private String zze = "";
    private r0 zzf = h1.f9791d;

    static {
        l lVar = new l();
        zzb = lVar;
        l0.h(l.class, lVar);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.l0
    public final Object m(int i3, l0 l0Var) {
        int i10 = i3 - 1;
        if (i10 == 0) {
            return (byte) 1;
        }
        if (i10 == 2) {
            return new i1(zzb, "\u0004\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0001\u0000\u0001ဈ\u0000\u0002\u001b", new Object[]{"zzd", "zze", "zzf", r.class});
        }
        if (i10 == 3) {
            return new l();
        }
        if (i10 == 4) {
            return new lb.k(zzb);
        }
        if (i10 != 5) {
            return null;
        }
        return zzb;
    }
}
