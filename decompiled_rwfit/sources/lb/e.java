package lb;

import com.google.android.gms.internal.mlkit_vision_barcode_bundled.b1;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.f0;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.i1;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.l0;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.p0;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.q;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes.dex */
public final class e extends l0 implements b1 {
    private static final e zzb;
    private int zzd;
    private p0 zze;
    private p0 zzf;
    private int zzg;
    private int zzh;
    private int zzi;
    private int zzj;

    static {
        e eVar = new e();
        zzb = eVar;
        l0.h(e.class, eVar);
    }

    public e() {
        f0 f0Var = f0.f9780d;
        this.zze = f0Var;
        this.zzf = f0Var;
    }

    public static d n() {
        return (d) zzb.d();
    }

    public static /* synthetic */ void o(e eVar, int i3) {
        eVar.zzd |= 2;
        eVar.zzh = i3;
    }

    public static void p(e eVar, float f2) {
        List list = eVar.zze;
        if (!((q) list).f9816a) {
            int size = list.size();
            int i3 = size == 0 ? 10 : size + size;
            f0 f0Var = (f0) list;
            if (i3 < f0Var.f9782c) {
                throw new IllegalArgumentException();
            }
            eVar.zze = new f0(Arrays.copyOf(f0Var.f9781b, i3), f0Var.f9782c, true);
        }
        ((f0) eVar.zze).c(f2);
    }

    public static void q(e eVar, float f2) {
        List list = eVar.zzf;
        if (!((q) list).f9816a) {
            int size = list.size();
            int i3 = size == 0 ? 10 : size + size;
            f0 f0Var = (f0) list;
            if (i3 < f0Var.f9782c) {
                throw new IllegalArgumentException();
            }
            eVar.zzf = new f0(Arrays.copyOf(f0Var.f9781b, i3), f0Var.f9782c, true);
        }
        ((f0) eVar.zzf).c(f2);
    }

    public static /* synthetic */ void r(e eVar, int i3) {
        eVar.zzd |= 1;
        eVar.zzg = i3;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.l0
    public final Object m(int i3, l0 l0Var) {
        int i10 = i3 - 1;
        if (i10 == 0) {
            return (byte) 1;
        }
        if (i10 == 2) {
            return new i1(zzb, "\u0004\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0002\u0000\u0001\u0013\u0002\u0013\u0003ဋ\u0000\u0004ဋ\u0001\u0005ဋ\u0002\u0006ဋ\u0003", new Object[]{"zzd", "zze", "zzf", "zzg", "zzh", "zzi", "zzj"});
        }
        if (i10 == 3) {
            return new e();
        }
        if (i10 == 4) {
            return new d(zzb);
        }
        if (i10 != 5) {
            return null;
        }
        return zzb;
    }
}
