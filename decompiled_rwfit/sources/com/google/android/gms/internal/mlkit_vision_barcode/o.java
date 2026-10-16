package com.google.android.gms.internal.mlkit_vision_barcode;

import java.util.List;
import java.util.ListIterator;

/* loaded from: classes.dex */
public final class o extends j implements ListIterator {
    public final /* synthetic */ p e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o(p pVar) {
        super(pVar);
        this.e = pVar;
    }

    @Override // java.util.ListIterator
    public final void add(Object obj) {
        int i3;
        p pVar = this.e;
        boolean isEmpty = pVar.isEmpty();
        a();
        ((ListIterator) this.f9357b).add(obj);
        zzbr zzbrVar = pVar.f9478f;
        i3 = zzbrVar.e;
        zzbrVar.e = i3 + 1;
        if (isEmpty) {
            pVar.a();
        }
    }

    @Override // java.util.ListIterator
    public final boolean hasPrevious() {
        a();
        return ((ListIterator) this.f9357b).hasPrevious();
    }

    @Override // java.util.ListIterator
    public final int nextIndex() {
        a();
        return ((ListIterator) this.f9357b).nextIndex();
    }

    @Override // java.util.ListIterator
    public final Object previous() {
        a();
        return ((ListIterator) this.f9357b).previous();
    }

    @Override // java.util.ListIterator
    public final int previousIndex() {
        a();
        return ((ListIterator) this.f9357b).previousIndex();
    }

    @Override // java.util.ListIterator
    public final void set(Object obj) {
        a();
        ((ListIterator) this.f9357b).set(obj);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o(p pVar, int i3) {
        super(pVar, ((List) pVar.f9437b).listIterator(i3));
        this.e = pVar;
    }
}
