package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

import java.util.NoSuchElementException;

/* loaded from: classes.dex */
public final class v extends w {

    /* renamed from: a, reason: collision with root package name */
    public int f9834a = 0;

    /* renamed from: b, reason: collision with root package name */
    public final int f9835b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ zzdf f9836c;

    public v(zzdf zzdfVar) {
        this.f9836c = zzdfVar;
        this.f9835b = zzdfVar.zzd();
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f9834a < this.f9835b;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.x
    public final byte zza() {
        int i3 = this.f9834a;
        if (i3 >= this.f9835b) {
            throw new NoSuchElementException();
        }
        this.f9834a = i3 + 1;
        return this.f9836c.zzb(i3);
    }
}
