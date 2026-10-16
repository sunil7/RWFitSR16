package com.google.android.gms.internal.mlkit_vision_barcode;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* loaded from: classes.dex */
public final class s implements Iterator {

    /* renamed from: a, reason: collision with root package name */
    public int f9507a;

    /* renamed from: b, reason: collision with root package name */
    public int f9508b;

    /* renamed from: c, reason: collision with root package name */
    public int f9509c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ zzci f9510d;
    public final /* synthetic */ int e;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ zzci f9511f;

    public /* synthetic */ s(zzci zzciVar, int i3) {
        int i10;
        this.e = i3;
        this.f9511f = zzciVar;
        this.f9510d = zzciVar;
        i10 = zzciVar.f9707b;
        this.f9507a = i10;
        this.f9508b = zzciVar.zze();
        this.f9509c = -1;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f9508b >= 0;
    }

    @Override // java.util.Iterator
    public final Object next() {
        int i3;
        Object zzg;
        zzci zzciVar = this.f9510d;
        i3 = zzciVar.f9707b;
        if (i3 != this.f9507a) {
            throw new ConcurrentModificationException();
        }
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        int i10 = this.f9508b;
        this.f9509c = i10;
        switch (this.e) {
            case 0:
                zzg = zzci.zzg(this.f9511f, i10);
                break;
            case 1:
                zzg = new v(this.f9511f, i10);
                break;
            default:
                zzg = zzci.zzj(this.f9511f, i10);
                break;
        }
        this.f9508b = zzciVar.zzf(this.f9508b);
        return zzg;
    }

    @Override // java.util.Iterator
    public final void remove() {
        int i3;
        zzci zzciVar = this.f9510d;
        i3 = zzciVar.f9707b;
        if (i3 != this.f9507a) {
            throw new ConcurrentModificationException();
        }
        oa.c("no calls to next() since the last call to remove()", this.f9509c >= 0);
        this.f9507a += 32;
        zzciVar.remove(zzci.zzg(zzciVar, this.f9509c));
        this.f9508b--;
        this.f9509c = -1;
    }
}
