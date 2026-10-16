package com.google.android.gms.internal.mlkit_vision_barcode;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;
import javax.annotation.CheckForNull;

/* loaded from: classes.dex */
public abstract class zzcs extends zzcn implements List, RandomAccess {

    /* renamed from: b, reason: collision with root package name */
    public static final x f9712b = new x(zzdk.zza, 0);
    public static final /* synthetic */ int zzd = 0;

    public static zzcs zzg(Object[] objArr, int i3) {
        return i3 == 0 ? zzdk.zza : new zzdk(objArr, i3);
    }

    public static zzcs zzh(Object obj, Object obj2) {
        Object[] objArr = {obj, obj2};
        sa.a(2, objArr);
        return zzg(objArr, 2);
    }

    public static zzcs zzi(Object obj, Object obj2, Object obj3, Object obj4) {
        Object[] objArr = {obj, obj2, obj3, obj4};
        sa.a(4, objArr);
        return zzg(objArr, 4);
    }

    @Override // java.util.List
    @Deprecated
    public final void add(int i3, Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List
    @Deprecated
    public final boolean addAll(int i3, Collection collection) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzcn, java.util.AbstractCollection, java.util.Collection
    public final boolean contains(@CheckForNull Object obj) {
        return indexOf(obj) >= 0;
    }

    @Override // java.util.Collection, java.util.List
    public final boolean equals(@CheckForNull Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof List)) {
            return false;
        }
        List list = (List) obj;
        int size = size();
        if (size != list.size()) {
            return false;
        }
        if (list instanceof RandomAccess) {
            for (int i3 = 0; i3 < size; i3++) {
                if (!na.a(get(i3), list.get(i3))) {
                    return false;
                }
            }
            return true;
        }
        Iterator it = iterator();
        Iterator it2 = list.iterator();
        while (it.hasNext()) {
            if (!it2.hasNext() || !na.a(it.next(), it2.next())) {
                return false;
            }
        }
        return !it2.hasNext();
    }

    @Override // java.util.Collection, java.util.List
    public final int hashCode() {
        int size = size();
        int i3 = 1;
        for (int i10 = 0; i10 < size; i10++) {
            i3 = (i3 * 31) + get(i10).hashCode();
        }
        return i3;
    }

    @Override // java.util.List
    public final int indexOf(@CheckForNull Object obj) {
        if (obj == null) {
            return -1;
        }
        int size = size();
        for (int i3 = 0; i3 < size; i3++) {
            if (obj.equals(get(i3))) {
                return i3;
            }
        }
        return -1;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzcn, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public final /* synthetic */ Iterator iterator() {
        return listIterator(0);
    }

    @Override // java.util.List
    public final int lastIndexOf(@CheckForNull Object obj) {
        if (obj == null) {
            return -1;
        }
        for (int size = size() - 1; size >= 0; size--) {
            if (obj.equals(get(size))) {
                return size;
            }
        }
        return -1;
    }

    @Override // java.util.List
    public final /* synthetic */ ListIterator listIterator() {
        return listIterator(0);
    }

    @Override // java.util.List
    @Deprecated
    public final Object remove(int i3) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List
    @Deprecated
    public final Object set(int i3, Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzcn
    public int zza(Object[] objArr, int i3) {
        int size = size();
        for (int i10 = 0; i10 < size; i10++) {
            objArr[i3 + i10] = get(i10);
        }
        return i3 + size;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzcn
    /* renamed from: zzd */
    public final e0 iterator() {
        return listIterator(0);
    }

    @Override // java.util.List
    /* renamed from: zzf */
    public zzcs subList(int i3, int i10) {
        oa.b(i3, i10, size());
        int i11 = i10 - i3;
        return i11 == size() ? this : i11 == 0 ? zzdk.zza : new zzcr(this, i3, i11);
    }

    @Override // java.util.List
    /* renamed from: zzj, reason: merged with bridge method [inline-methods] */
    public final f0 listIterator(int i3) {
        int size = size();
        if (i3 < 0 || i3 > size) {
            throw new IndexOutOfBoundsException(oa.d(i3, size, "index"));
        }
        return isEmpty() ? f9712b : new x(this, i3);
    }
}
