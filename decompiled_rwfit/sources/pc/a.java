package pc;

import com.google.android.gms.internal.mlkit_vision_barcode_bundled.b1;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.c0;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.g1;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.h1;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.i1;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.l0;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.r0;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzdf;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzer;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzgr;
import java.io.IOException;

/* loaded from: classes.dex */
public final class a extends l0 implements b1 {
    private static final a zzb;
    private int zzd;
    private int zzf;
    private byte zzi = 2;
    private r0 zze = h1.f9791d;
    private String zzg = "";
    private zzdf zzh = zzdf.zzb;

    static {
        a aVar = new a();
        zzb = aVar;
        l0.h(a.class, aVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v2, types: [com.google.android.gms.internal.mlkit_vision_barcode_bundled.m1] */
    /* JADX WARN: Type inference failed for: r2v2, types: [com.google.android.gms.internal.mlkit_vision_barcode_bundled.l0, java.lang.Object] */
    public static a n(byte[] bArr, c0 c0Var) {
        a aVar = zzb;
        int length = bArr.length;
        if (length != 0) {
            ?? r22 = (l0) aVar.m(4, null);
            try {
                ?? a3 = g1.f9786c.a(r22.getClass());
                a3.b(r22, bArr, 0, length, new com.google.android.gms.internal.mlkit_vision_barcode_bundled.s(c0Var));
                a3.a(r22);
                aVar = r22;
            } catch (zzer e) {
                throw e;
            } catch (zzgr e10) {
                throw e10.zza();
            } catch (IOException e11) {
                if (e11.getCause() instanceof zzer) {
                    throw ((zzer) e11.getCause());
                }
                throw new zzer(e11);
            } catch (IndexOutOfBoundsException unused) {
                throw new zzer("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
            }
        }
        if (aVar == null || l0.j(aVar, true)) {
            return aVar;
        }
        throw new zzgr(aVar).zza();
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.l0
    public final Object m(int i3, l0 l0Var) {
        int i10 = i3 - 1;
        if (i10 == 0) {
            return Byte.valueOf(this.zzi);
        }
        if (i10 == 2) {
            return new i1(zzb, "\u0004\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0001\u0002\u0001Л\u0002ᴌ\u0000\u0003ဈ\u0001\u0004ည\u0002", new Object[]{"zzd", "zze", k.class, "zzf", g.f17532b, "zzg", "zzh"});
        }
        if (i10 == 3) {
            return new a();
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

    public final r0 o() {
        return this.zze;
    }
}
