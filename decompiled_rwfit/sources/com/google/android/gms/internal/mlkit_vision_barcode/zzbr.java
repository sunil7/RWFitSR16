package com.google.android.gms.internal.mlkit_vision_barcode;

import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.RandomAccess;
import java.util.Set;
import javax.annotation.CheckForNull;

/* loaded from: classes.dex */
abstract class zzbr extends r implements Serializable {

    /* renamed from: d, reason: collision with root package name */
    public final transient Map f9704d;
    public transient int e;

    public zzbr(Map map) {
        if (!map.isEmpty()) {
            throw new IllegalArgumentException();
        }
        this.f9704d = map;
    }

    public static /* bridge */ /* synthetic */ void zzr(zzbr zzbrVar, Object obj) {
        Object obj2;
        try {
            obj2 = zzbrVar.f9704d.remove(obj);
        } catch (ClassCastException | NullPointerException unused) {
            obj2 = null;
        }
        Collection collection = (Collection) obj2;
        if (collection != null) {
            int size = collection.size();
            collection.clear();
            zzbrVar.e -= size;
        }
    }

    public abstract Collection zza();

    public Collection zzb() {
        throw null;
    }

    public Collection zzc(Collection collection) {
        throw null;
    }

    public Collection zzd(Object obj, Collection collection) {
        throw null;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.b0
    public final int zzh() {
        return this.e;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.r
    public final Collection zzi() {
        return new w(this, 2);
    }

    public final Collection zzj(Object obj) {
        Collection collection = (Collection) this.f9704d.get(obj);
        if (collection == null) {
            collection = zza();
        }
        return zzd(obj, collection);
    }

    public final Collection zzk(@CheckForNull Object obj) {
        Collection collection = (Collection) this.f9704d.remove(obj);
        if (collection == null) {
            return zzb();
        }
        Collection zza = zza();
        zza.addAll(collection);
        this.e -= collection.size();
        collection.clear();
        return zzc(zza);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.r
    public final Iterator zzl() {
        return new h(this);
    }

    public final List zzm(Object obj, List list, @CheckForNull n nVar) {
        return list instanceof RandomAccess ? new m(this, obj, list, nVar) : new p(this, obj, list, nVar);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.r
    public final Map zzo() {
        return new k(this, this.f9704d);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.r
    public final Set zzp() {
        return new l(this, this.f9704d);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.b0
    public final void zzs() {
        Map map = this.f9704d;
        Iterator it = map.values().iterator();
        while (it.hasNext()) {
            ((Collection) it.next()).clear();
        }
        map.clear();
        this.e = 0;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.b0
    public final boolean zzt(Object obj, Object obj2) {
        Map map = this.f9704d;
        Collection collection = (Collection) map.get(obj);
        if (collection != null) {
            if (!collection.add(obj2)) {
                return false;
            }
            this.e++;
            return true;
        }
        Collection zza = zza();
        if (!zza.add(obj2)) {
            throw new AssertionError("New Collection violated the Collection spec");
        }
        this.e++;
        map.put(obj, zza);
        return true;
    }
}
