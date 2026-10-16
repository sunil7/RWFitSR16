package com.google.android.gms.internal.mlkit_common;

/* loaded from: classes.dex */
final class zzaq extends zzai {
    static final zzai zza = new zzaq(null, new Object[0], 0);

    /* renamed from: d, reason: collision with root package name */
    public final transient Object f9198d;
    public final transient int e;
    final transient Object[] zzb;

    public zzaq(Object obj, Object[] objArr, int i3) {
        this.f9198d = obj;
        this.zzb = objArr;
        this.e = i3;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:21:0x01bf  */
    /* JADX WARN: Type inference failed for: r17v10 */
    /* JADX WARN: Type inference failed for: r17v11 */
    /* JADX WARN: Type inference failed for: r17v12 */
    /* JADX WARN: Type inference failed for: r17v13 */
    /* JADX WARN: Type inference failed for: r17v4 */
    /* JADX WARN: Type inference failed for: r3v6 */
    /* JADX WARN: Type inference failed for: r3v8, types: [java.lang.Object[]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static com.google.android.gms.internal.mlkit_common.zzaq zzg(int r19, java.lang.Object[] r20, com.google.android.gms.internal.mlkit_common.c r21) {
        /*
            Method dump skipped, instructions count: 495
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_common.zzaq.zzg(int, java.lang.Object[], com.google.android.gms.internal.mlkit_common.c):com.google.android.gms.internal.mlkit_common.zzaq");
    }

    /* JADX WARN: Removed duplicated region for block: B:5:0x009e A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x009f A[RETURN] */
    @Override // com.google.android.gms.internal.mlkit_common.zzai, java.util.Map
    @javax.annotation.CheckForNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object get(@javax.annotation.CheckForNull java.lang.Object r10) {
        /*
            r9 = this;
            r0 = 0
            if (r10 != 0) goto L6
        L3:
            r10 = r0
            goto L9c
        L6:
            java.lang.Object[] r1 = r9.zzb
            r2 = 1
            int r3 = r9.e
            if (r3 != r2) goto L20
            r3 = 0
            r3 = r1[r3]
            java.util.Objects.requireNonNull(r3)
            boolean r10 = r3.equals(r10)
            if (r10 == 0) goto L3
            r10 = r1[r2]
            java.util.Objects.requireNonNull(r10)
            goto L9c
        L20:
            java.lang.Object r3 = r9.f9198d
            if (r3 != 0) goto L25
            goto L3
        L25:
            boolean r4 = r3 instanceof byte[]
            r5 = -1
            if (r4 == 0) goto L51
            r4 = r3
            byte[] r4 = (byte[]) r4
            int r3 = r4.length
            int r6 = r3 + (-1)
            int r3 = r10.hashCode()
            int r3 = com.google.android.gms.internal.mlkit_vision_barcode.ma.a(r3)
        L38:
            r3 = r3 & r6
            r5 = r4[r3]
            r7 = 255(0xff, float:3.57E-43)
            r5 = r5 & r7
            if (r5 != r7) goto L41
            goto L3
        L41:
            r7 = r1[r5]
            boolean r7 = r10.equals(r7)
            if (r7 == 0) goto L4e
            r10 = r5 ^ 1
            r10 = r1[r10]
            goto L9c
        L4e:
            int r3 = r3 + 1
            goto L38
        L51:
            boolean r4 = r3 instanceof short[]
            if (r4 == 0) goto L7d
            r4 = r3
            short[] r4 = (short[]) r4
            int r3 = r4.length
            int r6 = r3 + (-1)
            int r3 = r10.hashCode()
            int r3 = com.google.android.gms.internal.mlkit_vision_barcode.ma.a(r3)
        L63:
            r3 = r3 & r6
            short r5 = r4[r3]
            char r5 = (char) r5
            r7 = 65535(0xffff, float:9.1834E-41)
            if (r5 != r7) goto L6d
            goto L3
        L6d:
            r7 = r1[r5]
            boolean r7 = r10.equals(r7)
            if (r7 == 0) goto L7a
            r10 = r5 ^ 1
            r10 = r1[r10]
            goto L9c
        L7a:
            int r3 = r3 + 1
            goto L63
        L7d:
            int[] r3 = (int[]) r3
            int r4 = r3.length
            int r4 = r4 + r5
            int r6 = r10.hashCode()
            int r6 = com.google.android.gms.internal.mlkit_vision_barcode.ma.a(r6)
        L89:
            r6 = r6 & r4
            r7 = r3[r6]
            if (r7 != r5) goto L90
            goto L3
        L90:
            r8 = r1[r7]
            boolean r8 = r10.equals(r8)
            if (r8 == 0) goto La0
            r10 = r7 ^ 1
            r10 = r1[r10]
        L9c:
            if (r10 != 0) goto L9f
            return r0
        L9f:
            return r10
        La0:
            int r6 = r6 + 1
            goto L89
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_common.zzaq.get(java.lang.Object):java.lang.Object");
    }

    @Override // java.util.Map
    public final int size() {
        return this.e;
    }

    @Override // com.google.android.gms.internal.mlkit_common.zzai
    public final zzab zza() {
        return new zzap(this.zzb, 1, this.e);
    }

    @Override // com.google.android.gms.internal.mlkit_common.zzai
    public final zzaj zzd() {
        return new zzan(this, this.zzb, 0, this.e);
    }

    @Override // com.google.android.gms.internal.mlkit_common.zzai
    public final zzaj zze() {
        return new zzao(this, new zzap(this.zzb, 0, this.e));
    }
}
