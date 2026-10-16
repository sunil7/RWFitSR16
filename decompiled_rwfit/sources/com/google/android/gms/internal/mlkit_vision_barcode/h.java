package com.google.android.gms.internal.mlkit_vision_barcode;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;

/* loaded from: classes.dex */
public final class h implements Iterator {

    /* renamed from: a, reason: collision with root package name */
    public final Iterator f9320a;

    /* renamed from: b, reason: collision with root package name */
    public Object f9321b;

    /* renamed from: c, reason: collision with root package name */
    public Collection f9322c;

    /* renamed from: d, reason: collision with root package name */
    public Iterator f9323d;
    public final /* synthetic */ zzbr e;

    public h(zzbr zzbrVar) {
        Map map;
        this.e = zzbrVar;
        map = zzbrVar.f9704d;
        this.f9320a = map.entrySet().iterator();
        this.f9321b = null;
        this.f9322c = null;
        this.f9323d = zzcw.zza;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f9320a.hasNext() || this.f9323d.hasNext();
    }

    @Override // java.util.Iterator
    public final Object next() {
        if (!this.f9323d.hasNext()) {
            Map.Entry entry = (Map.Entry) this.f9320a.next();
            this.f9321b = entry.getKey();
            Collection collection = (Collection) entry.getValue();
            this.f9322c = collection;
            this.f9323d = collection.iterator();
        }
        return new zzco(this.f9321b, this.f9323d.next());
    }

    @Override // java.util.Iterator
    public final void remove() {
        int i3;
        this.f9323d.remove();
        Collection collection = this.f9322c;
        Objects.requireNonNull(collection);
        if (collection.isEmpty()) {
            this.f9320a.remove();
        }
        zzbr zzbrVar = this.e;
        i3 = zzbrVar.e;
        zzbrVar.e = i3 - 1;
    }
}
