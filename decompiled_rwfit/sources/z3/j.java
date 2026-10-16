package z3;

import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public final class j {

    /* renamed from: a, reason: collision with root package name */
    public final com.bumptech.glide.request.a f20245a;

    /* renamed from: b, reason: collision with root package name */
    public final Executor f20246b;

    public j(com.bumptech.glide.request.a aVar, Executor executor) {
        this.f20245a = aVar;
        this.f20246b = executor;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof j) {
            return this.f20245a.equals(((j) obj).f20245a);
        }
        return false;
    }

    public final int hashCode() {
        return this.f20245a.hashCode();
    }
}
