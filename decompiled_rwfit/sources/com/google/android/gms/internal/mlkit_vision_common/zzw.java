package com.google.android.gms.internal.mlkit_vision_common;

import java.util.Iterator;
import java.util.Map;
import javax.annotation.CheckForNull;

/* loaded from: classes.dex */
final class zzw extends zzs {

    /* renamed from: c, reason: collision with root package name */
    public final transient zzr f10153c;

    /* renamed from: d, reason: collision with root package name */
    public final transient Object[] f10154d;
    public final transient int e;

    public zzw(zzr zzrVar, Object[] objArr, int i3, int i10) {
        this.f10153c = zzrVar;
        this.f10154d = objArr;
        this.e = i10;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_common.zzl, java.util.AbstractCollection, java.util.Collection
    public final boolean contains(@CheckForNull Object obj) {
        if (obj instanceof Map.Entry) {
            Map.Entry entry = (Map.Entry) obj;
            Object key = entry.getKey();
            Object value = entry.getValue();
            if (value != null && value.equals(this.f10153c.get(key))) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_common.zzs, com.google.android.gms.internal.mlkit_vision_common.zzl, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public final /* synthetic */ Iterator iterator() {
        return zzf().listIterator(0);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return this.e;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_common.zzl
    public final int zza(Object[] objArr, int i3) {
        return zzf().zza(objArr, 0);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_common.zzs, com.google.android.gms.internal.mlkit_vision_common.zzl
    /* renamed from: zzd */
    public final a iterator() {
        return zzf().listIterator(0);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_common.zzs
    public final zzp zzg() {
        return new zzv(this);
    }
}
