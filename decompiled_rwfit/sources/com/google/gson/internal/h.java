package com.google.gson.internal;

import java.util.Map;

/* loaded from: classes.dex */
public final class h implements Map.Entry {

    /* renamed from: a, reason: collision with root package name */
    public h f11186a;

    /* renamed from: b, reason: collision with root package name */
    public h f11187b;

    /* renamed from: c, reason: collision with root package name */
    public h f11188c;

    /* renamed from: d, reason: collision with root package name */
    public h f11189d;
    public h e;

    /* renamed from: f, reason: collision with root package name */
    public final Object f11190f;

    /* renamed from: g, reason: collision with root package name */
    public Object f11191g;

    /* renamed from: h, reason: collision with root package name */
    public int f11192h;

    public h() {
        this.f11190f = null;
        this.e = this;
        this.f11189d = this;
    }

    @Override // java.util.Map.Entry
    public final boolean equals(Object obj) {
        if (obj instanceof Map.Entry) {
            Map.Entry entry = (Map.Entry) obj;
            Object obj2 = this.f11190f;
            if (obj2 != null ? obj2.equals(entry.getKey()) : entry.getKey() == null) {
                Object obj3 = this.f11191g;
                if (obj3 == null) {
                    if (entry.getValue() == null) {
                        return true;
                    }
                } else if (obj3.equals(entry.getValue())) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // java.util.Map.Entry
    public final Object getKey() {
        return this.f11190f;
    }

    @Override // java.util.Map.Entry
    public final Object getValue() {
        return this.f11191g;
    }

    @Override // java.util.Map.Entry
    public final int hashCode() {
        Object obj = this.f11190f;
        int hashCode = obj == null ? 0 : obj.hashCode();
        Object obj2 = this.f11191g;
        return (obj2 != null ? obj2.hashCode() : 0) ^ hashCode;
    }

    @Override // java.util.Map.Entry
    public final Object setValue(Object obj) {
        Object obj2 = this.f11191g;
        this.f11191g = obj;
        return obj2;
    }

    public final String toString() {
        return this.f11190f + "=" + this.f11191g;
    }

    public h(h hVar, Object obj, h hVar2, h hVar3) {
        this.f11186a = hVar;
        this.f11190f = obj;
        this.f11192h = 1;
        this.f11189d = hVar2;
        this.e = hVar3;
        hVar3.f11189d = this;
        hVar2.e = this;
    }
}
