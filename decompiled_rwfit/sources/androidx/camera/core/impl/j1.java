package androidx.camera.core.impl;

import java.util.Set;

/* loaded from: classes.dex */
public interface j1 extends e0 {
    @Override // androidx.camera.core.impl.e0
    default boolean b(c cVar) {
        return y().b(cVar);
    }

    @Override // androidx.camera.core.impl.e0
    default void c(c0.b bVar) {
        y().c(bVar);
    }

    @Override // androidx.camera.core.impl.e0
    default Object d(c cVar, Config$OptionPriority config$OptionPriority) {
        return y().d(cVar, config$OptionPriority);
    }

    @Override // androidx.camera.core.impl.e0
    default Object e(c cVar) {
        return y().e(cVar);
    }

    @Override // androidx.camera.core.impl.e0
    default Set g() {
        return y().g();
    }

    @Override // androidx.camera.core.impl.e0
    default Set h(c cVar) {
        return y().h(cVar);
    }

    @Override // androidx.camera.core.impl.e0
    default Config$OptionPriority j(c cVar) {
        return y().j(cVar);
    }

    @Override // androidx.camera.core.impl.e0
    default Object k(c cVar, Object obj) {
        return y().k(cVar, obj);
    }

    e0 y();
}
