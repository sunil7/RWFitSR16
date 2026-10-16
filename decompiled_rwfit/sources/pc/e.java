package pc;

import com.google.android.gms.internal.mlkit_vision_barcode_bundled.b1;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.i1;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.l0;

/* loaded from: classes.dex */
public final class e extends l0 implements b1 {
    private static final e zzb;
    private int zzd;
    private int zze;
    private int zzf;
    private byte zzg = 2;

    static {
        e eVar = new e();
        zzb = eVar;
        l0.h(e.class, eVar);
    }

    public static d p() {
        return (d) zzb.d();
    }

    public static /* synthetic */ void q(e eVar, int i3) {
        eVar.zzd |= 1;
        eVar.zze = i3;
    }

    public static /* synthetic */ void r(e eVar, int i3) {
        eVar.zzd |= 2;
        eVar.zzf = i3;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.l0
    public final Object m(int i3, l0 l0Var) {
        int i10 = i3 - 1;
        if (i10 == 0) {
            return Byte.valueOf(this.zzg);
        }
        if (i10 == 2) {
            return new i1(zzb, "\u0004\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0002\u0001ᔄ\u0000\u0002ᔄ\u0001", new Object[]{"zzd", "zze", "zzf"});
        }
        if (i10 == 3) {
            return new e();
        }
        if (i10 == 4) {
            return new d(zzb);
        }
        if (i10 == 5) {
            return zzb;
        }
        this.zzg = l0Var == null ? (byte) 0 : (byte) 1;
        return null;
    }

    public final int n() {
        return this.zze;
    }

    public final int o() {
        return this.zzf;
    }
}
