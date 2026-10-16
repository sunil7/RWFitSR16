package lb;

import com.autonavi.amap.mapcore.tools.GlMapUtil;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.b1;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.i1;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.l0;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.z1;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzdf;

/* loaded from: classes.dex */
public final class i extends l0 implements b1 {
    private static final i zzb;
    private int zzd;
    private g zzj;
    private z1 zzl;
    private String zze = "";
    private zzdf zzf = zzdf.zzb;
    private int zzg = 10;
    private float zzh = 0.5f;
    private float zzi = 0.05f;
    private int zzk = 1;
    private int zzm = GlMapUtil.DEVICE_DISPLAY_DPI_HIGH;
    private int zzn = 4;
    private int zzo = 2;

    static {
        i iVar = new i();
        zzb = iVar;
        l0.h(i.class, iVar);
    }

    public static h n() {
        return (h) zzb.d();
    }

    public static /* synthetic */ void o(i iVar, g gVar) {
        iVar.zzj = gVar;
        iVar.zzd |= 32;
    }

    public static /* synthetic */ void p(i iVar, zzdf zzdfVar) {
        zzdfVar.getClass();
        iVar.zzd |= 2;
        iVar.zzf = zzdfVar;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.l0
    public final Object m(int i3, l0 l0Var) {
        int i10 = i3 - 1;
        if (i10 == 0) {
            return (byte) 1;
        }
        if (i10 == 2) {
            return new i1(zzb, "\u0004\u000b\u0000\u0001\u0001\f\u000b\u0000\u0000\u0000\u0001ဈ\u0000\u0002ည\u0001\u0003ဋ\u0002\u0004ခ\u0003\u0005ခ\u0004\u0006ဉ\u0005\bင\u0006\tဉ\u0007\nင\b\u000bင\t\fင\n", new Object[]{"zzd", "zze", "zzf", "zzg", "zzh", "zzi", "zzj", "zzk", "zzl", "zzm", "zzn", "zzo"});
        }
        if (i10 == 3) {
            return new i();
        }
        if (i10 == 4) {
            return new h(zzb);
        }
        if (i10 != 5) {
            return null;
        }
        return zzb;
    }
}
