package com.google.android.gms.internal.mlkit_common;

import com.google.android.gms.internal.mlkit_vision_barcode.ka;
import java.util.AbstractMap;
import java.util.Objects;

/* loaded from: classes.dex */
final class zzam extends zzaf {
    final /* synthetic */ zzan zza;

    public zzam(zzan zzanVar) {
        this.zza = zzanVar;
    }

    @Override // java.util.List
    public final /* bridge */ /* synthetic */ Object get(int i3) {
        int i10;
        Object[] objArr;
        Object[] objArr2;
        i10 = this.zza.e;
        ka.a(i3, i10);
        objArr = this.zza.f9193d;
        int i11 = i3 + i3;
        Object obj = objArr[i11];
        Objects.requireNonNull(obj);
        objArr2 = this.zza.f9193d;
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
