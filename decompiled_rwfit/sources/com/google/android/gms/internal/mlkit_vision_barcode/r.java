package com.google.android.gms.internal.mlkit_vision_barcode;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import javax.annotation.CheckForNull;

/* loaded from: classes.dex */
public abstract class r implements b0 {

    /* renamed from: a, reason: collision with root package name */
    public transient Collection f9495a;

    /* renamed from: b, reason: collision with root package name */
    public transient Set f9496b;

    /* renamed from: c, reason: collision with root package name */
    public transient Map f9497c;

    public final boolean equals(@CheckForNull Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof b0) {
            return zzv().equals(((b0) obj).zzv());
        }
        return false;
    }

    public final int hashCode() {
        return zzv().hashCode();
    }

    public final String toString() {
        return zzv().toString();
    }

    public abstract Collection zzi();

    public abstract Iterator zzl();

    public abstract Map zzo();

    public abstract Set zzp();

    public final Collection zzu() {
        Collection collection = this.f9495a;
        if (collection != null) {
            return collection;
        }
        Collection zzi = zzi();
        this.f9495a = zzi;
        return zzi;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.b0
    public final Map zzv() {
        Map map = this.f9497c;
        if (map != null) {
            return map;
        }
        Map zzo = zzo();
        this.f9497c = zzo;
        return zzo;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.b0
    public final Set zzw() {
        Set set = this.f9496b;
        if (set != null) {
            return set;
        }
        Set zzp = zzp();
        this.f9496b = zzp;
        return zzp;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.b0
    public final boolean zzx(@CheckForNull Object obj, @CheckForNull Object obj2) {
        Collection collection = ((k) zzv()).get(obj);
        return collection != null && collection.contains(obj2);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.b0
    public final boolean zzy(@CheckForNull Object obj, @CheckForNull Object obj2) {
        Collection collection = ((k) zzv()).get(obj);
        return collection != null && collection.remove(obj2);
    }
}
