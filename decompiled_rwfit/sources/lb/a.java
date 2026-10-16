package lb;

import com.google.android.gms.internal.mlkit_vision_barcode_bundled.b1;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.i1;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.l0;

/* loaded from: classes.dex */
public final class a extends l0 implements b1 {
    private static final a zzb;
    private int zzd;
    private i zze;
    private c zzf;
    private m zzg;

    static {
        a aVar = new a();
        zzb = aVar;
        l0.h(a.class, aVar);
    }

    public static j n() {
        return (j) zzb.d();
    }

    public static /* synthetic */ void o(a aVar, i iVar) {
        aVar.zze = iVar;
        aVar.zzd |= 1;
    }

    public static /* synthetic */ void p(a aVar, c cVar) {
        aVar.zzf = cVar;
        aVar.zzd |= 2;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.l0
    public final Object m(int i3, l0 l0Var) {
        int i10 = i3 - 1;
        if (i10 == 0) {
            return (byte) 1;
        }
        if (i10 == 2) {
            return new i1(zzb, "\u0004\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဉ\u0001\u0003ဉ\u0002", new Object[]{"zzd", "zze", "zzf", "zzg"});
        }
        if (i10 == 3) {
            return new a();
        }
        if (i10 == 4) {
            return new j(zzb);
        }
        if (i10 != 5) {
            return null;
        }
        return zzb;
    }
}
