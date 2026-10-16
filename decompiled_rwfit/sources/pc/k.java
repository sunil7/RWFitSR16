package pc;

import com.google.android.gms.internal.mlkit_vision_barcode_bundled.b1;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.h1;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.i1;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.l0;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.m0;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.q0;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.r0;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzdf;

/* loaded from: classes.dex */
public final class k extends l0 implements b1 {
    private static final k zzb;
    private byte zzA = 2;
    private int zzd;
    private int zze;
    private zzdf zzf;
    private String zzg;
    private c zzh;
    private int zzi;
    private o zzj;
    private q zzk;
    private com.google.android.gms.internal.mlkit_vision_barcode_bundled.o zzl;
    private f zzm;
    private i zzn;
    private h zzo;
    private s zzp;
    private n zzq;
    private p zzr;
    private l zzs;
    private r0 zzt;
    private q0 zzu;
    private String zzv;
    private r0 zzw;
    private boolean zzx;
    private double zzy;
    private zzdf zzz;

    static {
        k kVar = new k();
        zzb = kVar;
        l0.h(k.class, kVar);
    }

    public k() {
        zzdf zzdfVar = zzdf.zzb;
        this.zzf = zzdfVar;
        this.zzg = "";
        h1 h1Var = h1.f9791d;
        this.zzt = h1Var;
        this.zzu = m0.f9803d;
        this.zzv = "";
        this.zzw = h1Var;
        this.zzx = true;
        this.zzz = zzdfVar;
    }

    public static void B(k kVar, int i3, e eVar) {
        r0 r0Var = kVar.zzt;
        if (!((com.google.android.gms.internal.mlkit_vision_barcode_bundled.q) r0Var).f9816a) {
            int size = r0Var.size();
            kVar.zzt = r0Var.b(size == 0 ? 10 : size + size);
        }
        kVar.zzt.set(i3, eVar);
    }

    public final r0 A() {
        return this.zzt;
    }

    public final boolean C() {
        return (this.zzd & 4096) != 0;
    }

    public final boolean D() {
        return (this.zzd & 32) != 0;
    }

    public final boolean E() {
        return (this.zzd & 8192) != 0;
    }

    public final boolean F() {
        return (this.zzd & 64) != 0;
    }

    public final boolean G() {
        return (this.zzd & 2048) != 0;
    }

    public final boolean H() {
        return (this.zzd & 128) != 0;
    }

    public final boolean I() {
        return (this.zzd & 256) != 0;
    }

    public final boolean J() {
        return (this.zzd & 1024) != 0;
    }

    public final boolean K() {
        return (this.zzd & 512) != 0;
    }

    public final int L() {
        int a3 = com.google.android.gms.internal.mlkit_vision_common.k.a(this.zze);
        if (a3 == 0) {
            return 1;
        }
        return a3;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.l0
    public final Object m(int i3, l0 l0Var) {
        int i10 = i3 - 1;
        if (i10 == 0) {
            return Byte.valueOf(this.zzA);
        }
        if (i10 == 2) {
            return new i1(zzb, "\u0004\u0016\u0000\u0001\u0001\u0017\u0016\u0000\u0003\u000b\u0001ᴌ\u0000\u0002ᔊ\u0001\u0003ᔈ\u0002\u0004ᴌ\u0004\u0005ᐉ\u0005\u0006ဉ\u0006\u0007ဉ\u0007\bᐉ\b\tᐉ\t\nᐉ\n\u000bЛ\fဈ\u000f\rЛ\u000eည\u0012\u000fᐉ\u000b\u0010ဉ\f\u0011ဉ\r\u0012\u0016\u0013ဉ\u000e\u0014ဇ\u0010\u0015က\u0011\u0017ဉ\u0003", new Object[]{"zzd", "zze", g.f17534d, "zzf", "zzg", "zzi", g.e, "zzj", "zzk", "zzl", "zzm", "zzn", "zzo", "zzt", e.class, "zzv", "zzw", e.class, "zzz", "zzp", "zzq", "zzr", "zzu", "zzs", "zzx", "zzy", "zzh"});
        }
        if (i10 == 3) {
            return new k();
        }
        if (i10 == 4) {
            return new j(zzb);
        }
        if (i10 == 5) {
            return zzb;
        }
        this.zzA = l0Var == null ? (byte) 0 : (byte) 1;
        return null;
    }

    public final int n() {
        int a3 = com.google.android.gms.internal.mlkit_vision_common.l.a(this.zzi);
        if (a3 == 0) {
            return 1;
        }
        return a3;
    }

    public final int o() {
        return this.zzt.size();
    }

    public final com.google.android.gms.internal.mlkit_vision_barcode_bundled.o p() {
        com.google.android.gms.internal.mlkit_vision_barcode_bundled.o oVar = this.zzl;
        return oVar == null ? com.google.android.gms.internal.mlkit_vision_barcode_bundled.o.n() : oVar;
    }

    public final n q() {
        n nVar = this.zzq;
        return nVar == null ? n.p() : nVar;
    }

    public final o r() {
        o oVar = this.zzj;
        return oVar == null ? o.o() : oVar;
    }

    public final p s() {
        p pVar = this.zzr;
        return pVar == null ? p.n() : pVar;
    }

    public final q t() {
        q qVar = this.zzk;
        return qVar == null ? q.n() : qVar;
    }

    public final s u() {
        s sVar = this.zzp;
        return sVar == null ? s.p() : sVar;
    }

    public final f v() {
        f fVar = this.zzm;
        return fVar == null ? f.n() : fVar;
    }

    public final h w() {
        h hVar = this.zzo;
        return hVar == null ? h.n() : hVar;
    }

    public final i x() {
        i iVar = this.zzn;
        return iVar == null ? i.n() : iVar;
    }

    public final zzdf y() {
        return this.zzf;
    }

    public final String z() {
        return this.zzg;
    }
}
