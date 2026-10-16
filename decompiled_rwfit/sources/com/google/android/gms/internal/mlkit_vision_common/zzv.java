package com.google.android.gms.internal.mlkit_vision_common;

import com.google.android.gms.internal.mlkit_vision_barcode.ya;
import java.util.AbstractMap;

/* loaded from: classes.dex */
final class zzv extends zzp {
    final /* synthetic */ zzw zza;

    public zzv(zzw zzwVar) {
        this.zza = zzwVar;
    }

    @Override // java.util.List
    public final /* bridge */ /* synthetic */ Object get(int i3) {
        int i10;
        Object[] objArr;
        Object[] objArr2;
        i10 = this.zza.e;
        ya.a(i3, i10);
        zzw zzwVar = this.zza;
        objArr = zzwVar.f10154d;
        int i11 = i3 + i3;
        Object obj = objArr[i11];
        obj.getClass();
        objArr2 = zzwVar.f10154d;
        Object obj2 = objArr2[i11 + 1];
        obj2.getClass();
        return new AbstractMap.SimpleImmutableEntry(obj, obj2);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        int i3;
        i3 = this.zza.e;
        return i3;
    }
}
