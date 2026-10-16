package com.google.android.gms.internal.mlkit_vision_barcode;

import java.io.Serializable;
import java.util.Map;
import java.util.Set;
import javax.annotation.CheckForNull;

/* loaded from: classes.dex */
public abstract class zzcu implements Map, Serializable {

    /* renamed from: a, reason: collision with root package name */
    public transient zzcv f9713a;

    /* renamed from: b, reason: collision with root package name */
    public transient zzcv f9714b;

    /* renamed from: c, reason: collision with root package name */
    public transient zzcn f9715c;

    public static zzcu zzc(Object obj, Object obj2) {
        return zzdp.zzg(1, new Object[]{"optional-module-barcode", "com.google.android.gms.vision.barcode"}, null);
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
        return ta.a(entrySet());
    }

    @Override // java.util.Map
    public final boolean isEmpty() {
        return false;
    }

    @Override // java.util.Map
    public final /* bridge */ /* synthetic */ Set keySet() {
        zzcv zzcvVar = this.f9714b;
        if (zzcvVar != null) {
            return zzcvVar;
        }
        zzcv zze = zze();
        this.f9714b = zze;
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
            throw new IllegalArgumentException(l0.j(size, "size cannot be negative but was: "));
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

    public abstract zzcn zza();

    @Override // java.util.Map
    /* renamed from: zzb, reason: merged with bridge method [inline-methods] */
    public final zzcn values() {
        zzcn zzcnVar = this.f9715c;
        if (zzcnVar != null) {
            return zzcnVar;
        }
        zzcn zza = zza();
        this.f9715c = zza;
        return zza;
    }

    public abstract zzcv zzd();

    public abstract zzcv zze();

    @Override // java.util.Map
    /* renamed from: zzf, reason: merged with bridge method [inline-methods] */
    public final zzcv entrySet() {
        zzcv zzcvVar = this.f9713a;
        if (zzcvVar != null) {
            return zzcvVar;
        }
        zzcv zzd = zzd();
        this.f9713a = zzd;
        return zzd;
    }
}
