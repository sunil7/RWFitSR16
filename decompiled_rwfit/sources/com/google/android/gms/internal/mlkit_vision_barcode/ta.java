package com.google.android.gms.internal.mlkit_vision_barcode;

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

/* loaded from: classes.dex */
public abstract class ta {
    public static int a(Set set) {
        Iterator it = set.iterator();
        int i3 = 0;
        while (it.hasNext()) {
            Object next = it.next();
            i3 += next != null ? next.hashCode() : 0;
        }
        return i3;
    }

    public static boolean b(d0 d0Var, Collection collection) {
        collection.getClass();
        if (collection instanceof c0) {
            collection = ((c0) collection).zza();
        }
        boolean z5 = false;
        if (!(collection instanceof Set) || collection.size() <= d0Var.size()) {
            Iterator it = collection.iterator();
            while (it.hasNext()) {
                z5 |= d0Var.remove(it.next());
            }
            return z5;
        }
        Iterator<E> it2 = d0Var.iterator();
        collection.getClass();
        while (it2.hasNext()) {
            if (collection.contains(it2.next())) {
                it2.remove();
                z5 = true;
            }
        }
        return z5;
    }
}
