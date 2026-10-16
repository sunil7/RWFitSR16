package androidx.camera.core.impl;

import android.util.Size;
import android.view.Surface;

/* loaded from: classes.dex */
public final class s0 extends g0 {

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ int f1482o = 0;

    /* renamed from: p, reason: collision with root package name */
    public final Object f1483p;

    public s0(Surface surface, Size size, int i3) {
        super(size, i3);
        this.f1483p = surface;
    }

    @Override // androidx.camera.core.impl.g0
    public final ob.a f() {
        switch (this.f1482o) {
            case 0:
                return x.i.c((Surface) this.f1483p);
            default:
                return ((t.f1) this.f1483p).f18323f;
        }
    }

    public s0(Surface surface) {
        super(g0.f1388k, 0);
        this.f1483p = surface;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public s0(t.f1 f1Var, Size size) {
        super(size, 34);
        this.f1483p = f1Var;
    }
}
