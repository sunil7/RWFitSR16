package com.google.android.gms.internal.mlkit_vision_barcode;

import java.util.AbstractCollection;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes.dex */
public class w extends AbstractCollection {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f9566a;

    /* renamed from: b, reason: collision with root package name */
    public final Object f9567b;

    public /* synthetic */ w(Object obj, int i3) {
        this.f9566a = i3;
        this.f9567b = obj;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final void clear() {
        switch (this.f9566a) {
            case 0:
                ((zzci) this.f9567b).clear();
                break;
            case 1:
                ((k) this.f9567b).clear();
                break;
            default:
                ((r) this.f9567b).zzs();
                break;
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean contains(Object obj) {
        switch (this.f9566a) {
            case 1:
                return ((k) this.f9567b).containsValue(obj);
            case 2:
                if (!(obj instanceof Map.Entry)) {
                    return false;
                }
                Map.Entry entry = (Map.Entry) obj;
                return ((r) this.f9567b).zzx(entry.getKey(), entry.getValue());
            default:
                return super.contains(obj);
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean isEmpty() {
        switch (this.f9566a) {
            case 1:
                return ((k) this.f9567b).isEmpty();
            default:
                return super.isEmpty();
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public final Iterator iterator() {
        switch (this.f9566a) {
            case 0:
                zzci zzciVar = (zzci) this.f9567b;
                Map zzl = zzciVar.zzl();
                return zzl != null ? zzl.values().iterator() : new s(zzciVar, 2);
            case 1:
                return new a0(((k) this.f9567b).entrySet().iterator());
            default:
                return ((r) this.f9567b).zzl();
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean remove(Object obj) {
        switch (this.f9566a) {
            case 1:
                try {
                    return super.remove(obj);
                } catch (UnsupportedOperationException unused) {
                    k kVar = (k) this.f9567b;
                    for (Map.Entry entry : kVar.entrySet()) {
                        if (na.a(obj, entry.getValue())) {
                            kVar.remove(entry.getKey());
                            return true;
                        }
                    }
                    return false;
                }
            case 2:
                if (!(obj instanceof Map.Entry)) {
                    return false;
                }
                Map.Entry entry2 = (Map.Entry) obj;
                return ((r) this.f9567b).zzy(entry2.getKey(), entry2.getValue());
            default:
                return super.remove(obj);
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean removeAll(Collection collection) {
        switch (this.f9566a) {
            case 1:
                try {
                    if (collection != null) {
                        return super.removeAll(collection);
                    }
                    throw null;
                } catch (UnsupportedOperationException unused) {
                    HashSet hashSet = new HashSet();
                    k kVar = (k) this.f9567b;
                    for (Map.Entry entry : kVar.entrySet()) {
                        if (collection.contains(entry.getValue())) {
                            hashSet.add(entry.getKey());
                        }
                    }
                    return kVar.f9372d.zzw().removeAll(hashSet);
                }
            default:
                return super.removeAll(collection);
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean retainAll(Collection collection) {
        switch (this.f9566a) {
            case 1:
                try {
                    if (collection != null) {
                        return super.retainAll(collection);
                    }
                    throw null;
                } catch (UnsupportedOperationException unused) {
                    HashSet hashSet = new HashSet();
                    k kVar = (k) this.f9567b;
                    for (Map.Entry entry : kVar.entrySet()) {
                        if (collection.contains(entry.getValue())) {
                            hashSet.add(entry.getKey());
                        }
                    }
                    return kVar.f9372d.zzw().retainAll(hashSet);
                }
            default:
                return super.retainAll(collection);
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final int size() {
        switch (this.f9566a) {
            case 0:
                return ((zzci) this.f9567b).size();
            case 1:
                return ((k) this.f9567b).f9371c.size();
            default:
                return ((r) this.f9567b).zzh();
        }
    }

    public w(k kVar) {
        this.f9566a = 1;
        this.f9567b = kVar;
    }
}
