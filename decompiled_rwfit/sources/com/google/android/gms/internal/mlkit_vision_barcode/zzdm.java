package com.google.android.gms.internal.mlkit_vision_barcode;

import java.util.Iterator;
import java.util.Map;
import javax.annotation.CheckForNull;

/* loaded from: classes.dex */
final class zzdm extends zzcv {

    /* renamed from: c, reason: collision with root package name */
    public final transient zzcu f9719c;

    /* renamed from: d, reason: collision with root package name */
    public final transient Object[] f9720d;
    public final transient int e = 1;

    public zzdm(zzcu zzcuVar, Object[] objArr, int i3, int i10) {
        this.f9719c = zzcuVar;
        this.f9720d = objArr;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzcn, java.util.AbstractCollection, java.util.Collection
    public final boolean contains(@CheckForNull Object obj) {
        if (obj instanceof Map.Entry) {
            Map.Entry entry = (Map.Entry) obj;
            Object key = entry.getKey();
            Object value = entry.getValue();
            if (value != null && value.equals(this.f9719c.get(key))) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzcv, com.google.android.gms.internal.mlkit_vision_barcode.zzcn, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public final /* synthetic */ Iterator iterator() {
        return zzf().listIterator(0);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return this.e;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzcn
    public final int zza(Object[] objArr, int i3) {
        return zzf().zza(objArr, i3);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzcv, com.google.android.gms.internal.mlkit_vision_barcode.zzcn
    /* renamed from: zzd */
    public final e0 iterator() {
        return zzf().listIterator(0);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzcv
    public final zzcs zzg() {
        return new zzdl(this);
    }
}
