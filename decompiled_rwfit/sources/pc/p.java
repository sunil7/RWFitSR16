package pc;

import com.google.android.gms.internal.mlkit_vision_barcode_bundled.b1;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.i1;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.l0;

/* loaded from: classes.dex */
public final class p extends l0 implements b1 {
    private static final p zzb;
    private int zzd;
    private String zze = "";
    private String zzf = "";
    private String zzg = "";
    private String zzh = "";
    private String zzi = "";
    private String zzj = "";
    private String zzk = "";
    private String zzl = "";
    private String zzm = "";
    private String zzn = "";
    private String zzo = "";
    private String zzp = "";
    private String zzq = "";
    private String zzr = "";

    static {
        p pVar = new p();
        zzb = pVar;
        l0.h(p.class, pVar);
    }

    public static p n() {
        return zzb;
    }

    public final String A() {
        return this.zzn;
    }

    public final String B() {
        return this.zzg;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.l0
    public final Object m(int i3, l0 l0Var) {
        int i10 = i3 - 1;
        if (i10 == 0) {
            return (byte) 1;
        }
        if (i10 == 2) {
            return new i1(zzb, "\u0004\u000e\u0000\u0001\u0001\u000e\u000e\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဈ\u0001\u0003ဈ\u0002\u0004ဈ\u0003\u0005ဈ\u0004\u0006ဈ\u0005\u0007ဈ\u0006\bဈ\u0007\tဈ\b\nဈ\t\u000bဈ\n\fဈ\u000b\rဈ\f\u000eဈ\r", new Object[]{"zzd", "zze", "zzf", "zzg", "zzh", "zzi", "zzj", "zzk", "zzl", "zzm", "zzn", "zzo", "zzp", "zzq", "zzr"});
        }
        if (i10 == 3) {
            return new p();
        }
        if (i10 == 4) {
            return new lb.k(zzb);
        }
        if (i10 != 5) {
            return null;
        }
        return zzb;
    }

    public final String o() {
        return this.zzk;
    }

    public final String p() {
        return this.zzl;
    }

    public final String q() {
        return this.zzj;
    }

    public final String r() {
        return this.zzm;
    }

    public final String s() {
        return this.zzq;
    }

    public final String t() {
        return this.zze;
    }

    public final String u() {
        return this.zzp;
    }

    public final String v() {
        return this.zzf;
    }

    public final String w() {
        return this.zzi;
    }

    public final String x() {
        return this.zzo;
    }

    public final String y() {
        return this.zzr;
    }

    public final String z() {
        return this.zzh;
    }
}
