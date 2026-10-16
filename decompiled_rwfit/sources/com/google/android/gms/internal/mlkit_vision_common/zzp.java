package com.google.android.gms.internal.mlkit_vision_common;

import com.google.android.gms.internal.mlkit_vision_barcode.bb;
import com.google.android.gms.internal.mlkit_vision_barcode.ya;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;
import javax.annotation.CheckForNull;

/* loaded from: classes.dex */
public abstract class zzp extends zzl implements List, RandomAccess {

    /* renamed from: b, reason: collision with root package name */
    public static final oa f10147b = new oa(zzu.zza, 0);

    public static zzp zzg(Object[] objArr) {
        return zzh(objArr, objArr.length);
    }

    public static zzp zzh(Object[] objArr, int i3) {
        return i3 == 0 ? zzu.zza : new zzu(objArr, i3);
    }

    public static zzp zzi(Object obj) {
        Object[] objArr = {obj};
        bb.a(1, objArr);
        return zzh(objArr, 1);
    }

    public static zzp zzj(Object obj, Object obj2, Object obj3) {
        Object[] objArr = {obj, obj2, obj3};
        bb.a(3, objArr);
        return zzh(objArr, 3);
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

    @Override // com.google.android.gms.internal.mlkit_vision_common.zzl, java.util.AbstractCollection, java.util.Collection
    public final boolean contains(@CheckForNull Object obj) {
        return indexOf(obj) >= 0;
    }

    @Override // java.util.Collection, java.util.List
    public final boolean equals(@CheckForNull Object obj) {
        Object next;
        Object next2;
        int i3;
        if (obj == this) {
            return true;
        }
        if (obj instanceof List) {
            List list = (List) obj;
            int size = size();
            if (size == list.size()) {
                if (list instanceof RandomAccess) {
                    for (0; i3 < size; i3 + 1) {
                        Object obj2 = get(i3);
                        Object obj3 = list.get(i3);
                        i3 = (obj2 == obj3 || (obj2 != null && obj2.equals(obj3))) ? i3 + 1 : 0;
                    }
                    return true;
                }
                Iterator it = iterator();
                Iterator it2 = list.iterator();
                while (true) {
                    if (it.hasNext()) {
                        if (!it2.hasNext() || ((next = it.next()) != (next2 = it2.next()) && (next == null || !next.equals(next2)))) {
                            break;
                        }
                    } else if (!it2.hasNext()) {
                        return true;
                    }
                }
            }
        }
        return false;
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

    @Override // com.google.android.gms.internal.mlkit_vision_common.zzl, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
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

    @Override // com.google.android.gms.internal.mlkit_vision_common.zzl
    public int zza(Object[] objArr, int i3) {
        int size = size();
        for (int i10 = 0; i10 < size; i10++) {
            objArr[i10] = get(i10);
        }
        return size;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_common.zzl
    /* renamed from: zzd */
    public final a iterator() {
        return listIterator(0);
    }

    @Override // java.util.List
    /* renamed from: zzf */
    public zzp subList(int i3, int i10) {
        ya.b(i3, i10, size());
        int i11 = i10 - i3;
        return i11 == size() ? this : i11 == 0 ? zzu.zza : new zzo(this, i3, i11);
    }

    @Override // java.util.List
    /* renamed from: zzk, reason: merged with bridge method [inline-methods] */
    public final b listIterator(int i3) {
        int size = size();
        if (i3 < 0 || i3 > size) {
            throw new IndexOutOfBoundsException(ya.c(i3, size, "index"));
        }
        return isEmpty() ? f10147b : new oa(this, i3);
    }
}
