package com.google.android.gms.internal.mlkit_vision_barcode;

import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes.dex */
public final class u extends AbstractSet {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f9535a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ zzci f9536b;

    public /* synthetic */ u(zzci zzciVar, int i3) {
        this.f9535a = i3;
        this.f9536b = zzciVar;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final void clear() {
        switch (this.f9535a) {
            case 0:
                this.f9536b.clear();
                break;
            default:
                this.f9536b.clear();
                break;
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean contains(Object obj) {
        int e;
        switch (this.f9535a) {
            case 0:
                zzci zzciVar = this.f9536b;
                Map zzl = zzciVar.zzl();
                if (zzl != null) {
                    return zzl.entrySet().contains(obj);
                }
                if (obj instanceof Map.Entry) {
                    Map.Entry entry = (Map.Entry) obj;
                    e = zzciVar.e(entry.getKey());
                    if (e != -1 && na.a(zzci.zzj(zzciVar, e), entry.getValue())) {
                        return true;
                    }
                }
                return false;
            default:
                return this.f9536b.containsKey(obj);
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public final Iterator iterator() {
        switch (this.f9535a) {
            case 0:
                zzci zzciVar = this.f9536b;
                Map zzl = zzciVar.zzl();
                return zzl != null ? zzl.entrySet().iterator() : new s(zzciVar, 1);
            default:
                zzci zzciVar2 = this.f9536b;
                Map zzl2 = zzciVar2.zzl();
                return zzl2 != null ? zzl2.keySet().iterator() : new s(zzciVar2, 0);
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean remove(Object obj) {
        int d5;
        int[] a3;
        Object[] b3;
        Object[] c9;
        int i3;
        Object g10;
        Object obj2;
        switch (this.f9535a) {
            case 0:
                zzci zzciVar = this.f9536b;
                Map zzl = zzciVar.zzl();
                if (zzl != null) {
                    return zzl.entrySet().remove(obj);
                }
                if (obj instanceof Map.Entry) {
                    Map.Entry entry = (Map.Entry) obj;
                    if (!zzciVar.zzr()) {
                        d5 = zzciVar.d();
                        Object key = entry.getKey();
                        Object value = entry.getValue();
                        Object zzi = zzci.zzi(zzciVar);
                        a3 = zzciVar.a();
                        b3 = zzciVar.b();
                        c9 = zzciVar.c();
                        int a10 = qa.a(key, value, d5, zzi, a3, b3, c9);
                        if (a10 != -1) {
                            zzciVar.zzq(a10, d5);
                            i3 = zzciVar.f9708c;
                            zzciVar.f9708c = i3 - 1;
                            zzciVar.zzo();
                            return true;
                        }
                    }
                }
                return false;
            default:
                zzci zzciVar2 = this.f9536b;
                Map zzl2 = zzciVar2.zzl();
                if (zzl2 != null) {
                    return zzl2.keySet().remove(obj);
                }
                g10 = zzciVar2.g(obj);
                obj2 = zzci.f9705g;
                return g10 != obj2;
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        switch (this.f9535a) {
        }
        return this.f9536b.size();
    }
}
