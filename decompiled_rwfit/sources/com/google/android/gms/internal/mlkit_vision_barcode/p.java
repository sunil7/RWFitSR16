package com.google.android.gms.internal.mlkit_vision_barcode;

import java.util.Collection;
import java.util.List;
import java.util.ListIterator;

/* loaded from: classes.dex */
public class p extends n implements List {

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ zzbr f9478f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public p(zzbr zzbrVar, Object obj, List list, n nVar) {
        super(zzbrVar, obj, list, nVar);
        this.f9478f = zzbrVar;
    }

    @Override // java.util.List
    public final void add(int i3, Object obj) {
        int i10;
        c();
        boolean isEmpty = this.f9437b.isEmpty();
        ((List) this.f9437b).add(i3, obj);
        zzbr zzbrVar = this.f9478f;
        i10 = zzbrVar.e;
        zzbrVar.e = i10 + 1;
        if (isEmpty) {
            a();
        }
    }

    @Override // java.util.List
    public final boolean addAll(int i3, Collection collection) {
        int i10;
        if (collection.isEmpty()) {
            return false;
        }
        int size = size();
        boolean addAll = ((List) this.f9437b).addAll(i3, collection);
        if (!addAll) {
            return addAll;
        }
        int size2 = this.f9437b.size() - size;
        zzbr zzbrVar = this.f9478f;
        i10 = zzbrVar.e;
        zzbrVar.e = i10 + size2;
        if (size != 0) {
            return addAll;
        }
        a();
        return true;
    }

    @Override // java.util.List
    public final Object get(int i3) {
        c();
        return ((List) this.f9437b).get(i3);
    }

    @Override // java.util.List
    public final int indexOf(Object obj) {
        c();
        return ((List) this.f9437b).indexOf(obj);
    }

    @Override // java.util.List
    public final int lastIndexOf(Object obj) {
        c();
        return ((List) this.f9437b).lastIndexOf(obj);
    }

    @Override // java.util.List
    public final ListIterator listIterator() {
        c();
        return new o(this);
    }

    @Override // java.util.List
    public final Object remove(int i3) {
        int i10;
        c();
        Object remove = ((List) this.f9437b).remove(i3);
        zzbr zzbrVar = this.f9478f;
        i10 = zzbrVar.e;
        zzbrVar.e = i10 - 1;
        d();
        return remove;
    }

    @Override // java.util.List
    public final Object set(int i3, Object obj) {
        c();
        return ((List) this.f9437b).set(i3, obj);
    }

    @Override // java.util.List
    public final List subList(int i3, int i10) {
        c();
        List subList = ((List) this.f9437b).subList(i3, i10);
        n nVar = this.f9438c;
        if (nVar == null) {
            nVar = this;
        }
        return this.f9478f.zzm(this.f9436a, subList, nVar);
    }

    @Override // java.util.List
    public final ListIterator listIterator(int i3) {
        c();
        return new o(this, i3);
    }
}
