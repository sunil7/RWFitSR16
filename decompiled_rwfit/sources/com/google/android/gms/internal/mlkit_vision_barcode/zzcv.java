package com.google.android.gms.internal.mlkit_vision_barcode;

import java.util.Set;
import javax.annotation.CheckForNull;

/* loaded from: classes.dex */
public abstract class zzcv extends zzcn implements Set {

    /* renamed from: b, reason: collision with root package name */
    public transient zzcs f9716b;

    @Override // java.util.Collection, java.util.Set
    public final boolean equals(@CheckForNull Object obj) {
        if (obj != this && this != obj) {
            if (obj instanceof Set) {
                Set set = (Set) obj;
                try {
                    if (size() == set.size()) {
                        if (containsAll(set)) {
                        }
                    }
                } catch (ClassCastException | NullPointerException unused) {
                }
            }
            return false;
        }
        return true;
    }

    @Override // java.util.Collection, java.util.Set
    public final int hashCode() {
        return ta.a(this);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzcn, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    /* renamed from: zzd */
    public abstract e0 iterator();

    public final zzcs zzf() {
        zzcs zzcsVar = this.f9716b;
        if (zzcsVar != null) {
            return zzcsVar;
        }
        zzcs zzg = zzg();
        this.f9716b = zzg;
        return zzg;
    }

    public zzcs zzg() {
        Object[] array = toArray();
        x xVar = zzcs.f9712b;
        return zzcs.zzg(array, array.length);
    }
}
