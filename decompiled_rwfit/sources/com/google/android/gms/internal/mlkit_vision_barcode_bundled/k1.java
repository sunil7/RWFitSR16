package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* loaded from: classes.dex */
public final class k1 implements Iterator {

    /* renamed from: a, reason: collision with root package name */
    public final ArrayDeque f9801a;

    /* renamed from: b, reason: collision with root package name */
    public zzdd f9802b;

    public k1(zzdf zzdfVar) {
        zzdf zzdfVar2;
        if (!(zzdfVar instanceof zzgd)) {
            this.f9801a = null;
            this.f9802b = (zzdd) zzdfVar;
            return;
        }
        zzgd zzgdVar = (zzgd) zzdfVar;
        ArrayDeque arrayDeque = new ArrayDeque(zzgdVar.zzf());
        this.f9801a = arrayDeque;
        arrayDeque.push(zzgdVar);
        zzdfVar2 = zzgdVar.zzd;
        while (zzdfVar2 instanceof zzgd) {
            zzgd zzgdVar2 = (zzgd) zzdfVar2;
            this.f9801a.push(zzgdVar2);
            zzdfVar2 = zzgdVar2.zzd;
        }
        this.f9802b = (zzdd) zzdfVar2;
    }

    @Override // java.util.Iterator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public final zzdd next() {
        zzdd zzddVar;
        zzdf zzdfVar;
        zzdd zzddVar2 = this.f9802b;
        if (zzddVar2 == null) {
            throw new NoSuchElementException();
        }
        do {
            ArrayDeque arrayDeque = this.f9801a;
            zzddVar = null;
            if (arrayDeque == null || arrayDeque.isEmpty()) {
                break;
            }
            zzdfVar = ((zzgd) arrayDeque.pop()).zze;
            while (zzdfVar instanceof zzgd) {
                zzgd zzgdVar = (zzgd) zzdfVar;
                arrayDeque.push(zzgdVar);
                zzdfVar = zzgdVar.zzd;
            }
            zzddVar = (zzdd) zzdfVar;
        } while (zzddVar.zzd() == 0);
        this.f9802b = zzddVar;
        return zzddVar2;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f9802b != null;
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
