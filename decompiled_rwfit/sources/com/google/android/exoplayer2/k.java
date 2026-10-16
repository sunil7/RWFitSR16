package com.google.android.exoplayer2;

import java.util.Collections;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public final class k {

    /* renamed from: a, reason: collision with root package name */
    public final String f8867a;

    /* renamed from: b, reason: collision with root package name */
    public final j f8868b;

    /* renamed from: c, reason: collision with root package name */
    public final i f8869c;

    /* renamed from: d, reason: collision with root package name */
    public final m f8870d;
    public final h e;

    static {
        List list = Collections.EMPTY_LIST;
        Map map = Collections.EMPTY_MAP;
        m mVar = m.f8871s;
    }

    public k(String str, h hVar, j jVar, i iVar, m mVar) {
        this.f8867a = str;
        this.f8868b = jVar;
        this.f8869c = iVar;
        this.f8870d = mVar;
        this.e = hVar;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof k)) {
            return false;
        }
        k kVar = (k) obj;
        return i9.g.a(this.f8867a, kVar.f8867a) && this.e.equals(kVar.e) && i9.g.a(this.f8868b, kVar.f8868b) && i9.g.a(this.f8869c, kVar.f8869c) && i9.g.a(this.f8870d, kVar.f8870d);
    }

    public final int hashCode() {
        int hashCode = this.f8867a.hashCode() * 31;
        j jVar = this.f8868b;
        return this.f8870d.hashCode() + ((this.e.hashCode() + ((this.f8869c.hashCode() + ((hashCode + (jVar != null ? jVar.hashCode() : 0)) * 31)) * 31)) * 31);
    }
}
