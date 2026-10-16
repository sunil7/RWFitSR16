package com.google.android.gms.internal.mlkit_vision_common;

import java.io.Serializable;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import javax.annotation.CheckForNull;

/* loaded from: classes.dex */
public abstract class zzr implements Map, Serializable {

    /* renamed from: a, reason: collision with root package name */
    public transient zzs f10148a;

    /* renamed from: b, reason: collision with root package name */
    public transient zzs f10149b;

    /* renamed from: c, reason: collision with root package name */
    public transient zzl f10150c;

    public static zzr zzc(Object obj, Object obj2) {
        return zzz.zzg(1, new Object[]{"optional-module-barcode", "com.google.android.gms.vision.barcode"}, null);
    }

    @Override // java.util.Map
    @Deprecated
    public final void clear() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    public final boolean containsKey(@CheckForNull Object obj) {
        return get(obj) != null;
    }

    @Override // java.util.Map
    public final boolean containsValue(@CheckForNull Object obj) {
        return values().contains(obj);
    }

    @Override // java.util.Map
    public final boolean equals(@CheckForNull Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Map) {
            return entrySet().equals(((Map) obj).entrySet());
        }
        return false;
    }

    @Override // java.util.Map
    @CheckForNull
    public abstract Object get(@CheckForNull Object obj);

    @Override // java.util.Map
    @CheckForNull
    public final Object getOrDefault(@CheckForNull Object obj, @CheckForNull Object obj2) {
        Object obj3 = get(obj);
        return obj3 != null ? obj3 : obj2;
    }

    @Override // java.util.Map
    public final int hashCode() {
        Iterator it = entrySet().iterator();
        int i3 = 0;
        while (it.hasNext()) {
            Object next = it.next();
            i3 += next != null ? next.hashCode() : 0;
        }
        return i3;
    }

    @Override // java.util.Map
    public final boolean isEmpty() {
        return size() == 0;
    }

    @Override // java.util.Map
    public final /* bridge */ /* synthetic */ Set keySet() {
        zzs zzsVar = this.f10149b;
        if (zzsVar != null) {
            return zzsVar;
        }
        zzs zze = zze();
        this.f10149b = zze;
        return zze;
    }

    @Override // java.util.Map
    @CheckForNull
    @Deprecated
    public final Object put(Object obj, Object obj2) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    @Deprecated
    public final void putAll(Map map) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    @CheckForNull
    @Deprecated
    public final Object remove(@CheckForNull Object obj) {
        throw new UnsupportedOperationException();
    }

    public final String toString() {
        int size = size();
        if (size < 0) {
            throw new IllegalArgumentException(com.google.android.gms.internal.mlkit_vision_barcode.l0.j(size, "size cannot be negative but was: "));
        }
        StringBuilder sb2 = new StringBuilder((int) Math.min(size * 8, 1073741824L));
        sb2.append('{');
        boolean z5 = true;
        for (Map.Entry entry : entrySet()) {
            if (!z5) {
                sb2.append(", ");
            }
            sb2.append(entry.getKey());
            sb2.append('=');
            sb2.append(entry.getValue());
            z5 = false;
        }
        sb2.append('}');
        return sb2.toString();
    }

    public abstract zzl zza();

    @Override // java.util.Map
    /* renamed from: zzb, reason: merged with bridge method [inline-methods] */
    public final zzl values() {
        zzl zzlVar = this.f10150c;
        if (zzlVar != null) {
            return zzlVar;
        }
        zzl zza = zza();
        this.f10150c = zza;
        return zza;
    }

    public abstract zzs zzd();

    public abstract zzs zze();

    @Override // java.util.Map
    /* renamed from: zzf, reason: merged with bridge method [inline-methods] */
    public final zzs entrySet() {
        zzs zzsVar = this.f10148a;
        if (zzsVar != null) {
            return zzsVar;
        }
        zzs zzd = zzd();
        this.f10148a = zzd;
        return zzd;
    }
}
