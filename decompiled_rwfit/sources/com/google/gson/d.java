package com.google.gson;

/* loaded from: classes.dex */
public final class d extends k {

    /* renamed from: a, reason: collision with root package name */
    public k f11160a;

    @Override // com.google.gson.k
    public final Object a(cc.a aVar) {
        k kVar = this.f11160a;
        if (kVar != null) {
            return kVar.a(aVar);
        }
        throw new IllegalStateException();
    }

    @Override // com.google.gson.k
    public final void b(cc.b bVar, Object obj) {
        k kVar = this.f11160a;
        if (kVar == null) {
            throw new IllegalStateException();
        }
        kVar.b(bVar, obj);
    }
}
