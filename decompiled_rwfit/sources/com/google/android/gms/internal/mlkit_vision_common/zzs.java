package com.google.android.gms.internal.mlkit_vision_common;

import java.util.Iterator;
import java.util.Set;
import javax.annotation.CheckForNull;

/* loaded from: classes.dex */
public abstract class zzs extends zzl implements Set {

    /* renamed from: b, reason: collision with root package name */
    public transient zzp f10151b;

    @Override // java.util.Collection, java.util.Set
    public final boolean equals(@CheckForNull Object obj) {
        if (obj == this || obj == this) {
            return true;
        }
        if (obj instanceof Set) {
            Set set = (Set) obj;
            try {
                if (size() == set.size()) {
                    return containsAll(set);
                }
            } catch (ClassCastException | NullPointerException unused) {
            }
        }
        return false;
    }

    @Override // java.util.Collection, java.util.Set
    public final int hashCode() {
        Iterator it = iterator();
        int i3 = 0;
        while (it.hasNext()) {
            Object next = it.next();
            i3 += next != null ? next.hashCode() : 0;
        }
        return i3;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_common.zzl, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    /* renamed from: zzd */
    public abstract a iterator();

    public final zzp zzf() {
        zzp zzpVar = this.f10151b;
        if (zzpVar != null) {
            return zzpVar;
        }
        zzp zzg = zzg();
        this.f10151b = zzg;
        return zzg;
    }

    public zzp zzg() {
        return zzp.zzg(toArray());
    }
}
