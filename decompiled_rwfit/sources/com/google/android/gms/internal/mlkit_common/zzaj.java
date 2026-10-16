package com.google.android.gms.internal.mlkit_common;

import java.util.Iterator;
import java.util.Set;
import javax.annotation.CheckForNull;

/* loaded from: classes.dex */
public abstract class zzaj extends zzab implements Set {

    /* renamed from: b, reason: collision with root package name */
    public transient zzaf f9190b;

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

    @Override // com.google.android.gms.internal.mlkit_common.zzab, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    /* renamed from: zzd */
    public abstract d iterator();

    public final zzaf zzf() {
        zzaf zzafVar = this.f9190b;
        if (zzafVar != null) {
            return zzafVar;
        }
        zzaf zzg = zzg();
        this.f9190b = zzg;
        return zzg;
    }

    public zzaf zzg() {
        Object[] array = toArray();
        a aVar = zzaf.f9186b;
        return zzaf.zzg(array, array.length);
    }
}
