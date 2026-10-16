package com.google.gson.internal;

import java.lang.reflect.Method;

/* loaded from: classes.dex */
public final class j extends a {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Method f11193b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f11194c;

    public j(Method method, Object obj) {
        this.f11193b = method;
        this.f11194c = obj;
    }

    @Override // com.google.gson.internal.a
    public final Object h(Class cls) {
        a.a(cls);
        return this.f11193b.invoke(this.f11194c, cls);
    }
}
