package com.google.android.gms.internal.mlkit_vision_barcode;

import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/* loaded from: classes.dex */
public final class i extends d0 {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ k f9339a;

    public i(k kVar) {
        this.f9339a = kVar;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final void clear() {
        this.f9339a.clear();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean contains(Object obj) {
        Set entrySet = this.f9339a.f9371c.entrySet();
        entrySet.getClass();
        try {
            return entrySet.contains(obj);
        } catch (ClassCastException | NullPointerException unused) {
            return false;
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean isEmpty() {
        return this.f9339a.isEmpty();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public final Iterator iterator() {
        return new j(this.f9339a);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean remove(Object obj) {
        if (!contains(obj)) {
            return false;
        }
        Map.Entry entry = (Map.Entry) obj;
        Objects.requireNonNull(entry);
        zzbr.zzr(this.f9339a.f9372d, entry.getKey());
        return true;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.d0, java.util.AbstractSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean removeAll(Collection collection) {
        try {
            if (collection != null) {
                return ta.b(this, collection);
            }
            throw null;
        } catch (UnsupportedOperationException unused) {
            Iterator it = collection.iterator();
            boolean z5 = false;
            while (it.hasNext()) {
                z5 |= remove(it.next());
            }
            return z5;
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.d0, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean retainAll(Collection collection) {
        int ceil;
        try {
            if (collection != null) {
                return super.retainAll(collection);
            }
            throw null;
        } catch (UnsupportedOperationException unused) {
            int size = collection.size();
            if (size >= 3) {
                ceil = size < 1073741824 ? (int) Math.ceil(size / 0.75d) : SubsamplingScaleImageView.TILE_SIZE_AUTO;
            } else {
                if (size < 0) {
                    throw new IllegalArgumentException(l0.j(size, "expectedSize cannot be negative but was: "));
                }
                ceil = size + 1;
            }
            HashSet hashSet = new HashSet(ceil);
            for (Object obj : collection) {
                if (contains(obj) && (obj instanceof Map.Entry)) {
                    hashSet.add(((Map.Entry) obj).getKey());
                }
            }
            return this.f9339a.f9372d.zzw().retainAll(hashSet);
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return this.f9339a.f9371c.size();
    }
}
