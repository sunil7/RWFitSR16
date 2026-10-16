package androidx.lifecycle;

import java.lang.reflect.Method;

/* loaded from: classes.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public final int f2343a;

    /* renamed from: b, reason: collision with root package name */
    public final Method f2344b;

    public c(int i3, Method method) {
        this.f2343a = i3;
        this.f2344b = method;
        method.setAccessible(true);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        return this.f2343a == cVar.f2343a && this.f2344b.getName().equals(cVar.f2344b.getName());
    }

    public final int hashCode() {
        return this.f2344b.getName().hashCode() + (this.f2343a * 31);
    }
}
