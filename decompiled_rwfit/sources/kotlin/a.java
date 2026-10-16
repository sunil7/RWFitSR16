package kotlin;

import eh.b;
import eh.c;
import kotlin.jvm.internal.e;

/* loaded from: classes2.dex */
public abstract class a {
    public static b a(LazyThreadSafetyMode mode, oh.a initializer) {
        e.f(mode, "mode");
        e.f(initializer, "initializer");
        int i3 = c.f12631a[mode.ordinal()];
        int i10 = 2;
        if (i3 == 1) {
            kotlin.jvm.internal.c cVar = null;
            return new SynchronizedLazyImpl(initializer, cVar, i10, cVar);
        }
        if (i3 == 2) {
            return new SafePublicationLazyImpl(initializer);
        }
        if (i3 == 3) {
            return new UnsafeLazyImpl(initializer);
        }
        throw new NoWhenBranchMatchedException();
    }

    public static b b(oh.a initializer) {
        e.f(initializer, "initializer");
        kotlin.jvm.internal.c cVar = null;
        return new SynchronizedLazyImpl(initializer, cVar, 2, cVar);
    }
}
