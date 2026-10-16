package com.google.gson.internal;

import java.lang.reflect.Method;

/* loaded from: classes.dex */
public final class k extends a {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Method f11195b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f11196c;

    public k(int i3, Method method) {
        this.f11195b = method;
        this.f11196c = i3;
    }

    @Override // com.google.gson.internal.a
    public final Object h(Class cls) {
        a.a(cls);
        return this.f11195b.invoke(null, cls, Integer.valueOf(this.f11196c));
    }
}
