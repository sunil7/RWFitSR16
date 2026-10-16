package com.google.common.collect;

import com.google.android.gms.internal.mlkit_vision_barcode.jb;
import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes.dex */
public final class j extends AbstractSet {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f11081a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ CompactHashMap f11082b;

    public /* synthetic */ j(CompactHashMap compactHashMap, int i3) {
        this.f11081a = i3;
        this.f11082b = compactHashMap;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final void clear() {
        switch (this.f11081a) {
            case 0:
                this.f11082b.clear();
                break;
            default:
                this.f11082b.clear();
                break;
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean contains(Object obj) {
        int a3;
        switch (this.f11081a) {
            case 0:
                if (!(obj instanceof Map.Entry)) {
                    return false;
                }
                Map.Entry entry = (Map.Entry) obj;
                Object key = entry.getKey();
                CompactHashMap compactHashMap = this.f11082b;
                a3 = compactHashMap.a(key);
                return a3 != -1 && jb.a(compactHashMap.values[a3], entry.getValue());
            default:
                return this.f11082b.containsKey(obj);
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public final Iterator iterator() {
        switch (this.f11081a) {
            case 0:
                return this.f11082b.entrySetIterator();
            default:
                return this.f11082b.keySetIterator();
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean remove(Object obj) {
        int a3;
        int a10;
        switch (this.f11081a) {
            case 0:
                if (obj instanceof Map.Entry) {
                    Map.Entry entry = (Map.Entry) obj;
                    Object key = entry.getKey();
                    CompactHashMap compactHashMap = this.f11082b;
                    a3 = compactHashMap.a(key);
                    if (a3 != -1 && jb.a(compactHashMap.values[a3], entry.getValue())) {
                        compactHashMap.b(compactHashMap.keys[a3], (int) (compactHashMap.entries[a3] >>> 32));
                        break;
                    }
                }
                break;
            default:
                CompactHashMap compactHashMap2 = this.f11082b;
                a10 = compactHashMap2.a(obj);
                if (a10 != -1) {
                    compactHashMap2.b(compactHashMap2.keys[a10], (int) (compactHashMap2.entries[a10] >>> 32));
                    break;
                }
                break;
        }
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        int i3;
        int i10;
        switch (this.f11081a) {
            case 0:
                i3 = this.f11082b.f10999c;
                return i3;
            default:
                i10 = this.f11082b.f10999c;
                return i10;
        }
    }
}
