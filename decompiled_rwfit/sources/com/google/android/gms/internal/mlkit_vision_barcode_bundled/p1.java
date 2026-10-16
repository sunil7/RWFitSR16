package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

import java.util.Map;

/* loaded from: classes.dex */
public final class p1 implements Map.Entry, Comparable {

    /* renamed from: a, reason: collision with root package name */
    public final Comparable f9813a;

    /* renamed from: b, reason: collision with root package name */
    public Object f9814b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ o1 f9815c;

    public p1(o1 o1Var, Comparable comparable, Object obj) {
        this.f9815c = o1Var;
        this.f9813a = comparable;
        this.f9814b = obj;
    }

    @Override // java.lang.Comparable
    public final /* bridge */ /* synthetic */ int compareTo(Object obj) {
        return this.f9813a.compareTo(((p1) obj).f9813a);
    }

    @Override // java.util.Map.Entry
    public final boolean equals(Object obj) {
        if (obj != this) {
            if (obj instanceof Map.Entry) {
                Map.Entry entry = (Map.Entry) obj;
                Object key = entry.getKey();
                Comparable comparable = this.f9813a;
                if (comparable == null ? key == null : comparable.equals(key)) {
                    Object obj2 = this.f9814b;
                    Object value = entry.getValue();
                    if (obj2 == null ? value == null : obj2.equals(value)) {
                    }
                }
            }
            return false;
        }
        return true;
    }

    @Override // java.util.Map.Entry
    public final /* synthetic */ Object getKey() {
        return this.f9813a;
    }

    @Override // java.util.Map.Entry
    public final Object getValue() {
        return this.f9814b;
    }

    @Override // java.util.Map.Entry
    public final int hashCode() {
        Comparable comparable = this.f9813a;
        int hashCode = comparable == null ? 0 : comparable.hashCode();
        Object obj = this.f9814b;
        return (obj != null ? obj.hashCode() : 0) ^ hashCode;
    }

    @Override // java.util.Map.Entry
    public final Object setValue(Object obj) {
        this.f9815c.g();
        Object obj2 = this.f9814b;
        this.f9814b = obj;
        return obj2;
    }

    public final String toString() {
        return r5.a.c(String.valueOf(this.f9813a), "=", String.valueOf(this.f9814b));
    }
}
