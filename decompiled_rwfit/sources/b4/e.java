package b4;

import n.m;
import z3.s;

/* loaded from: classes.dex */
public final class e extends m {

    /* renamed from: d, reason: collision with root package name */
    public com.bumptech.glide.load.engine.c f3153d;

    @Override // n.m
    public final int d(Object obj) {
        s sVar = (s) obj;
        if (sVar == null) {
            return 1;
        }
        return sVar.c();
    }

    @Override // n.m
    public final void e(Object obj, Object obj2) {
        s sVar = (s) obj2;
        com.bumptech.glide.load.engine.c cVar = this.f3153d;
        if (cVar == null || sVar == null) {
            return;
        }
        cVar.e.g(sVar, true);
    }
}
