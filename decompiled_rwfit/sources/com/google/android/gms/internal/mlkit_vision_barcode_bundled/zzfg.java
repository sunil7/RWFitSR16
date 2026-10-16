package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/* loaded from: classes.dex */
public final class zzfg extends LinkedHashMap {

    /* renamed from: a, reason: collision with root package name */
    public static final zzfg f9858a;
    private boolean zzb = true;

    static {
        zzfg zzfgVar = new zzfg();
        f9858a = zzfgVar;
        zzfgVar.zzb = false;
    }

    private zzfg() {
    }

    public static int a(Object obj) {
        if (!(obj instanceof byte[])) {
            if (obj instanceof n0) {
                throw new UnsupportedOperationException();
            }
            return obj.hashCode();
        }
        byte[] bArr = (byte[]) obj;
        Charset charset = s0.f9827a;
        int length = bArr.length;
        for (byte b3 : bArr) {
            length = (length * 31) + b3;
        }
        if (length == 0) {
            return 1;
        }
        return length;
    }

    public static zzfg zza() {
        return f9858a;
    }

    public final void b() {
        if (!this.zzb) {
            throw new UnsupportedOperationException();
        }
    }

    @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final void clear() {
        b();
        super.clear();
    }

    @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final Set entrySet() {
        return isEmpty() ? Collections.EMPTY_SET : super.entrySet();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final boolean equals(Object obj) {
        if (!(obj instanceof Map)) {
            return false;
        }
        Map map = (Map) obj;
        if (this == map) {
            return true;
        }
        if (size() != map.size()) {
            return false;
        }
        Iterator it = entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            if (!map.containsKey(entry.getKey())) {
                return false;
            }
            Object value = entry.getValue();
            Object obj2 = map.get(entry.getKey());
            if (!(((value instanceof byte[]) && (obj2 instanceof byte[])) ? Arrays.equals((byte[]) value, (byte[]) obj2) : value.equals(obj2))) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final int hashCode() {
        Iterator it = entrySet().iterator();
        int i3 = 0;
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            i3 += a(entry.getValue()) ^ a(entry.getKey());
        }
        return i3;
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final Object put(Object obj, Object obj2) {
        b();
        Charset charset = s0.f9827a;
        obj.getClass();
        obj2.getClass();
        return super.put(obj, obj2);
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final void putAll(Map map) {
        b();
        for (Object obj : map.keySet()) {
            Charset charset = s0.f9827a;
            obj.getClass();
            map.get(obj).getClass();
        }
        super.putAll(map);
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final Object remove(Object obj) {
        b();
        return super.remove(obj);
    }

    public final zzfg zzb() {
        if (isEmpty()) {
            return new zzfg();
        }
        zzfg zzfgVar = new zzfg(this);
        zzfgVar.zzb = true;
        return zzfgVar;
    }

    public final void zzc() {
        this.zzb = false;
    }

    public final void zzd(zzfg zzfgVar) {
        b();
        if (zzfgVar.isEmpty()) {
            return;
        }
        putAll(zzfgVar);
    }

    public final boolean zze() {
        return this.zzb;
    }
}
