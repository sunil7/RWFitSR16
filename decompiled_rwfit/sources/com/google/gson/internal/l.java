package com.google.gson.internal;

import java.lang.reflect.Method;

/* loaded from: classes.dex */
public final class l extends a {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Method f11197b;

    public l(Method method) {
        this.f11197b = method;
    }

    @Override // com.google.gson.internal.a
    public final Object h(Class cls) {
        a.a(cls);
        return this.f11197b.invoke(null, cls, Object.class);
    }
}
