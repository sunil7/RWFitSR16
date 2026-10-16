package org.joda.time.tz;

import java.security.PrivilegedAction;

/* loaded from: classes2.dex */
public final class j implements PrivilegedAction {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f17279a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ k f17280b;

    public j(k kVar, String str) {
        this.f17280b = kVar;
        this.f17279a = str;
    }

    @Override // java.security.PrivilegedAction
    public final Object run() {
        ClassLoader classLoader = this.f17280b.f17283c;
        String str = this.f17279a;
        return classLoader != null ? classLoader.getResourceAsStream(str) : ClassLoader.getSystemResourceAsStream(str);
    }
}
