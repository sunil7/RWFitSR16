package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

import java.util.Map;

/* loaded from: classes.dex */
public final class g0 implements z0 {

    /* renamed from: b, reason: collision with root package name */
    public static final g0 f9784b = new g0(0);

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f9785a;

    public /* synthetic */ g0(int i3) {
        this.f9785a = i3;
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x001c, code lost:
    
        if (r12[r13] <= (-65)) goto L11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x001e, code lost:
    
        r13 = r11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0046, code lost:
    
        if (r12[r13] <= (-65)) goto L11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x008c, code lost:
    
        if (r12[r13] <= (-65)) goto L11;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static int c(int r11, byte[] r12, int r13, int r14) {
        /*
            Method dump skipped, instructions count: 249
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_vision_barcode_bundled.g0.c(int, byte[], int, int):int");
    }

    public static void d(x0 x0Var, Map.Entry entry) {
        j0 j0Var = (j0) entry.getKey();
        zzhf zzhfVar = zzhf.zza;
        j0Var.getClass();
        throw null;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.z0
    public i1 a(Class cls) {
        switch (this.f9785a) {
            case 0:
                if (!l0.class.isAssignableFrom(cls)) {
                    throw new IllegalArgumentException("Unsupported message type: ".concat(cls.getName()));
                }
                try {
                    return (i1) l0.e(cls.asSubclass(l0.class)).m(3, null);
                } catch (Exception e) {
                    throw new RuntimeException("Unable to get message info for ".concat(cls.getName()), e);
                }
            default:
                throw new IllegalStateException("This should never be called.");
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.z0
    public boolean b(Class cls) {
        switch (this.f9785a) {
            case 0:
                return l0.class.isAssignableFrom(cls);
            default:
                return false;
        }
    }
}
