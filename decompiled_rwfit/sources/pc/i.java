package pc;

import com.google.android.gms.internal.mlkit_vision_barcode_bundled.b1;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.i1;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.l0;

/* loaded from: classes.dex */
public final class i extends l0 implements b1 {
    private static final i zzb;
    private int zzd;
    private int zzf;
    private boolean zzh;
    private byte zzi = 2;
    private String zze = "";
    private String zzg = "";

    static {
        i iVar = new i();
        zzb = iVar;
        l0.h(i.class, iVar);
    }

    public static i n() {
        return zzb;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.l0
    public final Object m(int i3, l0 l0Var) {
        int i10 = i3 - 1;
        if (i10 == 0) {
            return Byte.valueOf(this.zzi);
        }
        if (i10 == 2) {
            return new i1(zzb, "\u0004\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0001\u0001ᔈ\u0000\u0002᠌\u0001\u0003ဈ\u0002\u0004ဇ\u0003", new Object[]{"zzd", "zze", "zzf", g.f17533c, "zzg", "zzh"});
        }
        if (i10 == 3) {
            return new i();
        }
        if (i10 == 4) {
            return new lb.k(zzb);
        }
        if (i10 == 5) {
            return zzb;
        }
        this.zzi = l0Var == null ? (byte) 0 : (byte) 1;
        return null;
    }

    public final String o() {
        return this.zzg;
    }

    public final String p() {
        return this.zze;
    }

    public final int q() {
        int i3;
        int i10 = this.zzf;
        if (i10 != 0) {
            i3 = 2;
            if (i10 != 1) {
                if (i10 != 2) {
                    i3 = 4;
                    if (i10 != 3) {
                        i3 = i10 != 4 ? 0 : 5;
                    }
                } else {
                    i3 = 3;
                }
            }
        } else {
            i3 = 1;
        }
        if (i3 == 0) {
            return 1;
        }
        return i3;
    }
}
