package com.google.android.gms.internal.mlkit_vision_common;

import java.util.Iterator;
import javax.annotation.CheckForNull;

/* loaded from: classes.dex */
final class zzx extends zzs {

    /* renamed from: c, reason: collision with root package name */
    public final transient zzr f10155c;

    /* renamed from: d, reason: collision with root package name */
    public final transient zzp f10156d;

    public zzx(zzr zzrVar, zzp zzpVar) {
        this.f10155c = zzrVar;
        this.f10156d = zzpVar;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_common.zzl, java.util.AbstractCollection, java.util.Collection
    public final boolean contains(@CheckForNull Object obj) {
        return this.f10155c.get(obj) != null;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_common.zzs, com.google.android.gms.internal.mlkit_vision_common.zzl, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public final /* synthetic */ Iterator iterator() {
        return this.f10156d.listIterator(0);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return this.f10155c.size();
    }

    @Override // com.google.android.gms.internal.mlkit_vision_common.zzl
    public final int zza(Object[] objArr, int i3) {
        return this.f10156d.zza(objArr, 0);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_common.zzs, com.google.android.gms.internal.mlkit_vision_common.zzl
    /* renamed from: zzd */
    public final a iterator() {
        return this.f10156d.listIterator(0);
    }
}
