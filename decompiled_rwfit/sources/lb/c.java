package lb;

import com.google.android.gms.internal.mlkit_vision_barcode_bundled.b1;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.i1;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.l0;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzdf;

/* loaded from: classes.dex */
public final class c extends l0 implements b1 {
    private static final c zzb;
    private int zzd;
    private String zze = "";
    private zzdf zzf;
    private String zzg;
    private zzdf zzh;
    private float zzi;
    private float zzj;
    private float zzk;
    private float zzl;
    private int zzm;

    static {
        c cVar = new c();
        zzb = cVar;
        l0.h(c.class, cVar);
    }

    public c() {
        zzdf zzdfVar = zzdf.zzb;
        this.zzf = zzdfVar;
        this.zzg = "";
        this.zzh = zzdfVar;
        this.zzi = 0.25f;
        this.zzj = 0.25f;
        this.zzk = 0.5f;
        this.zzl = 0.85f;
        this.zzm = 1;
    }

    public static b n() {
        return (b) zzb.d();
    }

    public static /* synthetic */ void o(c cVar, zzdf zzdfVar) {
        zzdfVar.getClass();
        cVar.zzd |= 2;
        cVar.zzf = zzdfVar;
    }

    public static /* synthetic */ void p(c cVar, zzdf zzdfVar) {
        zzdfVar.getClass();
        cVar.zzd |= 8;
        cVar.zzh = zzdfVar;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.l0
    public final Object m(int i3, l0 l0Var) {
        int i10 = i3 - 1;
        if (i10 == 0) {
            return (byte) 1;
        }
        if (i10 == 2) {
            return new i1(zzb, "\u0004\t\u0000\u0001\u0001\t\t\u0000\u0000\u0000\u0001ဈ\u0000\u0002ည\u0001\u0003ဈ\u0002\u0004ည\u0003\u0005ခ\u0004\u0006ခ\u0005\u0007ခ\u0006\bခ\u0007\tင\b", new Object[]{"zzd", "zze", "zzf", "zzg", "zzh", "zzi", "zzj", "zzk", "zzl", "zzm"});
        }
        if (i10 == 3) {
            return new c();
        }
        if (i10 == 4) {
            return new b(zzb);
        }
        if (i10 != 5) {
            return null;
        }
        return zzb;
    }
}
