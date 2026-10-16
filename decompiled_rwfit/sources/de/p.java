package de;

import androidx.camera.core.CameraControl$OperationCanceledException;
import n.s0;

/* loaded from: classes.dex */
public final /* synthetic */ class p implements l, n0.g {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ boolean f12380a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f12381b;

    public /* synthetic */ p(Object obj, boolean z5) {
        this.f12381b = obj;
        this.f12380a = z5;
    }

    @Override // n0.g
    public Object b(final androidx.concurrent.futures.b bVar) {
        final s0 s0Var = (s0) this.f12381b;
        s0Var.getClass();
        final boolean z5 = this.f12380a;
        s0Var.f16300d.execute(new Runnable() { // from class: n.r0
            @Override // java.lang.Runnable
            public final void run() {
                s0 s0Var2 = s0.this;
                androidx.concurrent.futures.b bVar2 = bVar;
                boolean z6 = z5;
                if (!s0Var2.f16299c) {
                    if (bVar2 != null) {
                        bVar2.b(new IllegalStateException("No flash unit"));
                        return;
                    }
                    return;
                }
                boolean z8 = s0Var2.e;
                androidx.lifecycle.b0 b0Var = s0Var2.f16298b;
                if (!z8) {
                    s0.a(b0Var, 0);
                    if (bVar2 != null) {
                        bVar2.b(new CameraControl$OperationCanceledException("Camera is not active."));
                        return;
                    }
                    return;
                }
                s0Var2.f16302g = z6;
                s0Var2.f16297a.m(z6);
                s0.a(b0Var, Integer.valueOf(z6 ? 1 : 0));
                androidx.concurrent.futures.b bVar3 = s0Var2.f16301f;
                if (bVar3 != null) {
                    bVar3.b(new CameraControl$OperationCanceledException("There is a new enableTorch being set"));
                }
                s0Var2.f16301f = bVar2;
            }
        });
        return "enableTorch: " + z5;
    }

    @Override // de.l
    public void k(Object obj) {
        ((rd.d) obj).t((String) this.f12381b, this.f12380a);
    }
}
