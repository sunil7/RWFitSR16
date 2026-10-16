package com.google.gson.internal;

import java.util.List;

/* loaded from: classes.dex */
public final class b extends com.google.gson.k {

    /* renamed from: a, reason: collision with root package name */
    public com.google.gson.k f11171a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ boolean f11172b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ boolean f11173c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ com.google.gson.e f11174d;
    public final /* synthetic */ bc.a e;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ c f11175f;

    public b(c cVar, boolean z5, boolean z6, com.google.gson.e eVar, bc.a aVar) {
        this.f11175f = cVar;
        this.f11172b = z5;
        this.f11173c = z6;
        this.f11174d = eVar;
        this.e = aVar;
    }

    @Override // com.google.gson.k
    public final Object a(cc.a aVar) {
        if (this.f11172b) {
            aVar.g0();
            return null;
        }
        com.google.gson.k kVar = this.f11171a;
        if (kVar == null) {
            bc.a aVar2 = this.e;
            com.google.gson.e eVar = this.f11174d;
            List<com.google.gson.l> list = eVar.e;
            com.google.gson.l lVar = this.f11175f;
            if (!list.contains(lVar)) {
                lVar = eVar.f11164d;
            }
            boolean z5 = false;
            for (com.google.gson.l lVar2 : list) {
                if (z5) {
                    com.google.gson.k a3 = lVar2.a(eVar, aVar2);
                    if (a3 != null) {
                        this.f11171a = a3;
                        kVar = a3;
                    }
                } else if (lVar2 == lVar) {
                    z5 = true;
                }
            }
            throw new IllegalArgumentException("GSON cannot serialize " + aVar2);
        }
        return kVar.a(aVar);
    }

    @Override // com.google.gson.k
    public final void b(cc.b bVar, Object obj) {
        if (this.f11173c) {
            bVar.k();
            return;
        }
        com.google.gson.k kVar = this.f11171a;
        if (kVar == null) {
            bc.a aVar = this.e;
            com.google.gson.e eVar = this.f11174d;
            List<com.google.gson.l> list = eVar.e;
            com.google.gson.l lVar = this.f11175f;
            if (!list.contains(lVar)) {
                lVar = eVar.f11164d;
            }
            boolean z5 = false;
            for (com.google.gson.l lVar2 : list) {
                if (z5) {
                    com.google.gson.k a3 = lVar2.a(eVar, aVar);
                    if (a3 != null) {
                        this.f11171a = a3;
                        kVar = a3;
                    }
                } else if (lVar2 == lVar) {
                    z5 = true;
                }
            }
            throw new IllegalArgumentException("GSON cannot serialize " + aVar);
        }
        kVar.b(bVar, obj);
    }
}
