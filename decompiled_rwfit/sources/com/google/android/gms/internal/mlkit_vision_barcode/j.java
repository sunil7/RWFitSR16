package com.google.android.gms.internal.mlkit_vision_barcode;

import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;

/* loaded from: classes.dex */
public class j implements Iterator {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f9356a = 0;

    /* renamed from: b, reason: collision with root package name */
    public final Iterator f9357b;

    /* renamed from: c, reason: collision with root package name */
    public Object f9358c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Object f9359d;

    public j(l lVar, Iterator it) {
        this.f9357b = it;
        this.f9359d = lVar;
    }

    public void a() {
        n nVar = (n) this.f9359d;
        nVar.c();
        if (nVar.f9437b != ((Collection) this.f9358c)) {
            throw new ConcurrentModificationException();
        }
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        switch (this.f9356a) {
            case 0:
                break;
            case 1:
                break;
            default:
                a();
                break;
        }
        return this.f9357b.hasNext();
    }

    @Override // java.util.Iterator
    public final Object next() {
        switch (this.f9356a) {
            case 0:
                Map.Entry entry = (Map.Entry) this.f9357b.next();
                this.f9358c = (Collection) entry.getValue();
                Object key = entry.getKey();
                return new zzco(key, ((k) this.f9359d).f9372d.zzd(key, (Collection) entry.getValue()));
            case 1:
                Map.Entry entry2 = (Map.Entry) this.f9357b.next();
                this.f9358c = entry2;
                return entry2.getKey();
            default:
                a();
                return this.f9357b.next();
        }
    }

    @Override // java.util.Iterator
    public final void remove() {
        int i3;
        int i10;
        int i11;
        switch (this.f9356a) {
            case 0:
                oa.c("no calls to next() since the last call to remove()", ((Collection) this.f9358c) != null);
                this.f9357b.remove();
                zzbr zzbrVar = ((k) this.f9359d).f9372d;
                i3 = zzbrVar.e;
                zzbrVar.e = i3 - ((Collection) this.f9358c).size();
                ((Collection) this.f9358c).clear();
                this.f9358c = null;
                break;
            case 1:
                oa.c("no calls to next() since the last call to remove()", ((Map.Entry) this.f9358c) != null);
                Collection collection = (Collection) ((Map.Entry) this.f9358c).getValue();
                this.f9357b.remove();
                zzbr zzbrVar2 = ((l) this.f9359d).f9386b;
                i10 = zzbrVar2.e;
                zzbrVar2.e = i10 - collection.size();
                collection.clear();
                this.f9358c = null;
                break;
            default:
                this.f9357b.remove();
                n nVar = (n) this.f9359d;
                zzbr zzbrVar3 = nVar.e;
                i11 = zzbrVar3.e;
                zzbrVar3.e = i11 - 1;
                nVar.d();
                break;
        }
    }

    public j(p pVar, ListIterator listIterator) {
        this.f9359d = pVar;
        this.f9358c = pVar.f9437b;
        this.f9357b = listIterator;
    }

    public j(k kVar) {
        this.f9359d = kVar;
        this.f9357b = kVar.f9371c.entrySet().iterator();
    }

    public j(n nVar) {
        Iterator it;
        this.f9359d = nVar;
        Collection collection = nVar.f9437b;
        this.f9358c = collection;
        if (collection instanceof List) {
            it = ((List) collection).listIterator();
        } else {
            it = collection.iterator();
        }
        this.f9357b = it;
    }
}
