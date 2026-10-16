package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

import java.util.Iterator;
import java.util.Map;

/* loaded from: classes.dex */
public final class q1 implements Iterator {

    /* renamed from: a, reason: collision with root package name */
    public int f9817a = -1;

    /* renamed from: b, reason: collision with root package name */
    public boolean f9818b;

    /* renamed from: c, reason: collision with root package name */
    public Iterator f9819c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ o1 f9820d;

    public final Iterator a() {
        if (this.f9819c == null) {
            this.f9819c = this.f9820d.f9810c.entrySet().iterator();
        }
        return this.f9819c;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        int i3 = this.f9817a + 1;
        o1 o1Var = this.f9820d;
        if (i3 >= o1Var.f9809b) {
            return !o1Var.f9810c.isEmpty() && a().hasNext();
        }
        return true;
    }

    @Override // java.util.Iterator
    public final /* bridge */ /* synthetic */ Object next() {
        this.f9818b = true;
        int i3 = this.f9817a + 1;
        this.f9817a = i3;
        o1 o1Var = this.f9820d;
        return i3 < o1Var.f9809b ? (p1) o1Var.f9808a[i3] : (Map.Entry) a().next();
    }

    @Override // java.util.Iterator
    public final void remove() {
        if (!this.f9818b) {
            throw new IllegalStateException("remove() was called before next()");
        }
        this.f9818b = false;
        int i3 = o1.f9807g;
        o1 o1Var = this.f9820d;
        o1Var.g();
        int i10 = this.f9817a;
        if (i10 >= o1Var.f9809b) {
            a().remove();
        } else {
            this.f9817a = i10 - 1;
            o1Var.e(i10);
        }
    }
}
