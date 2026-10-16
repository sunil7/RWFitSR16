package com.google.android.gms.internal.mlkit_vision_barcode;

import java.util.AbstractMap;
import java.util.Collection;
import java.util.Map;
import java.util.Set;

/* loaded from: classes.dex */
public final class k extends AbstractMap {

    /* renamed from: a, reason: collision with root package name */
    public transient i f9369a;

    /* renamed from: b, reason: collision with root package name */
    public transient w f9370b;

    /* renamed from: c, reason: collision with root package name */
    public final transient Map f9371c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ zzbr f9372d;

    public k(zzbr zzbrVar, Map map) {
        this.f9372d = zzbrVar;
        this.f9371c = map;
    }

    @Override // java.util.AbstractMap, java.util.Map
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public final Collection get(Object obj) {
        Object obj2;
        Map map = this.f9371c;
        map.getClass();
        try {
            obj2 = map.get(obj);
        } catch (ClassCastException | NullPointerException unused) {
            obj2 = null;
        }
        Collection collection = (Collection) obj2;
        if (collection == null) {
            return null;
        }
        return this.f9372d.zzd(obj, collection);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final void clear() {
        Map map;
        zzbr zzbrVar = this.f9372d;
        map = zzbrVar.f9704d;
        if (this.f9371c == map) {
            zzbrVar.zzs();
            return;
        }
        j jVar = new j(this);
        while (jVar.hasNext()) {
            jVar.next();
            jVar.remove();
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final boolean containsKey(Object obj) {
        Map map = this.f9371c;
        map.getClass();
        try {
            return map.containsKey(obj);
        } catch (ClassCastException | NullPointerException unused) {
            return false;
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Set entrySet() {
        i iVar = this.f9369a;
        if (iVar != null) {
            return iVar;
        }
        i iVar2 = new i(this);
        this.f9369a = iVar2;
        return iVar2;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final boolean equals(Object obj) {
        return this == obj || this.f9371c.equals(obj);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final int hashCode() {
        return this.f9371c.hashCode();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Set keySet() {
        return this.f9372d.zzw();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final /* bridge */ /* synthetic */ Object remove(Object obj) {
        int i3;
        Collection collection = (Collection) this.f9371c.remove(obj);
        if (collection == null) {
            return null;
        }
        zzbr zzbrVar = this.f9372d;
        Collection zza = zzbrVar.zza();
        zza.addAll(collection);
        i3 = zzbrVar.e;
        zzbrVar.e = i3 - collection.size();
        collection.clear();
        return zza;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final int size() {
        return this.f9371c.size();
    }

    @Override // java.util.AbstractMap
    public final String toString() {
        return this.f9371c.toString();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Collection values() {
        w wVar = this.f9370b;
        if (wVar != null) {
            return wVar;
        }
        w wVar2 = new w(this);
        this.f9370b = wVar2;
        return wVar2;
    }
}
