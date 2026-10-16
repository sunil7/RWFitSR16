package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

import java.util.NoSuchElementException;

/* loaded from: classes.dex */
public final class j1 extends w {

    /* renamed from: a, reason: collision with root package name */
    public final k1 f9799a;

    /* renamed from: b, reason: collision with root package name */
    public x f9800b;

    public j1(zzgd zzgdVar) {
        k1 k1Var = new k1(zzgdVar);
        this.f9799a = k1Var;
        this.f9800b = k1Var.hasNext() ? k1Var.next().iterator() : null;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f9800b != null;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.x
    public final byte zza() {
        x xVar = this.f9800b;
        if (xVar == null) {
            throw new NoSuchElementException();
        }
        byte zza = xVar.zza();
        if (!this.f9800b.hasNext()) {
            k1 k1Var = this.f9799a;
            this.f9800b = k1Var.hasNext() ? k1Var.next().iterator() : null;
        }
        return zza;
    }
}
