package com.google.android.gms.internal.mlkit_vision_barcode;

import java.util.AbstractMap;
import java.util.Objects;

/* loaded from: classes.dex */
final class zzdl extends zzcs {
    final /* synthetic */ zzdm zza;

    public zzdl(zzdm zzdmVar) {
        this.zza = zzdmVar;
    }

    @Override // java.util.List
    public final /* bridge */ /* synthetic */ Object get(int i3) {
        int i10;
        Object[] objArr;
        Object[] objArr2;
        i10 = this.zza.e;
        oa.a(i3, i10);
        objArr = this.zza.f9720d;
        int i11 = i3 + i3;
        Object obj = objArr[i11];
        Objects.requireNonNull(obj);
        objArr2 = this.zza.f9720d;
        Object obj2 = objArr2[i11 + 1];
        Objects.requireNonNull(obj2);
        return new AbstractMap.SimpleImmutableEntry(obj, obj2);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        int i3;
        i3 = this.zza.e;
        return i3;
    }
}
