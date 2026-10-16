package lb;

import com.google.android.gms.internal.mlkit_vision_barcode_bundled.b1;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.h1;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.i1;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.l0;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.r0;

/* loaded from: classes.dex */
public final class m extends l0 implements b1 {
    private static final m zzb;
    private r0 zzd;
    private r0 zze;

    static {
        m mVar = new m();
        zzb = mVar;
        l0.h(m.class, mVar);
    }

    public m() {
        h1 h1Var = h1.f9791d;
        this.zzd = h1Var;
        this.zze = h1Var;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.l0
    public final Object m(int i3, l0 l0Var) {
        int i10 = i3 - 1;
        if (i10 == 0) {
            return (byte) 1;
        }
        if (i10 == 2) {
            return new i1(zzb, "\u0004\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0002\u0000\u0001\u001b\u0002\u001b", new Object[]{"zzd", l.class, "zze", l.class});
        }
        if (i10 == 3) {
            return new m();
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
