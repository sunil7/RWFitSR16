package com.google.android.gms.internal.mlkit_vision_barcode;

import java.util.Iterator;
import javax.annotation.CheckForNull;

/* loaded from: classes.dex */
final class zzdn extends zzcv {

    /* renamed from: c, reason: collision with root package name */
    public final transient zzcu f9721c;

    /* renamed from: d, reason: collision with root package name */
    public final transient zzcs f9722d;

    public zzdn(zzcu zzcuVar, zzcs zzcsVar) {
        this.f9721c = zzcuVar;
        this.f9722d = zzcsVar;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzcn, java.util.AbstractCollection, java.util.Collection
    public final boolean contains(@CheckForNull Object obj) {
        return this.f9721c.get(obj) != null;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzcv, com.google.android.gms.internal.mlkit_vision_barcode.zzcn, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public final /* synthetic */ Iterator iterator() {
        return this.f9722d.listIterator(0);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return 1;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzcn
    public final int zza(Object[] objArr, int i3) {
        return this.f9722d.zza(objArr, i3);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzcv, com.google.android.gms.internal.mlkit_vision_barcode.zzcn
    /* renamed from: zzd */
    public final e0 iterator() {
        return this.f9722d.listIterator(0);
    }
}
