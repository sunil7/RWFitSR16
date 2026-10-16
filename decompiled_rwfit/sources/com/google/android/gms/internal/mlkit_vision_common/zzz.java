package com.google.android.gms.internal.mlkit_vision_common;

/* loaded from: classes.dex */
final class zzz extends zzr {
    static final zzr zza = new zzz(new Object[0], 0);

    /* renamed from: d, reason: collision with root package name */
    public final transient int f10159d;
    final transient Object[] zzb;

    public zzz(Object[] objArr, int i3) {
        this.zzb = objArr;
        this.f10159d = i3;
    }

    public static zzz zzg(int i3, Object[] objArr, pa paVar) {
        objArr[0].getClass();
        objArr[1].getClass();
        return new zzz(objArr, 1);
    }

    /* JADX WARN: Removed duplicated region for block: B:5:0x001f A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0020 A[RETURN] */
    @Override // com.google.android.gms.internal.mlkit_vision_common.zzr, java.util.Map
    @javax.annotation.CheckForNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object get(@javax.annotation.CheckForNull java.lang.Object r5) {
        /*
            r4 = this;
            java.lang.Object[] r0 = r4.zzb
            r1 = 0
            if (r5 != 0) goto L7
        L5:
            r5 = r1
            goto L1d
        L7:
            int r2 = r4.f10159d
            r3 = 1
            if (r2 != r3) goto L5
            r2 = 0
            r2 = r0[r2]
            r2.getClass()
            boolean r5 = r2.equals(r5)
            if (r5 == 0) goto L5
            r5 = r0[r3]
            r5.getClass()
        L1d:
            if (r5 != 0) goto L20
            return r1
        L20:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_vision_common.zzz.get(java.lang.Object):java.lang.Object");
    }

    @Override // java.util.Map
    public final int size() {
        return this.f10159d;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_common.zzr
    public final zzl zza() {
        return new zzy(this.zzb, 1, this.f10159d);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_common.zzr
    public final zzs zzd() {
        return new zzw(this, this.zzb, 0, this.f10159d);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_common.zzr
    public final zzs zze() {
        return new zzx(this, new zzy(this.zzb, 0, this.f10159d));
    }
}
