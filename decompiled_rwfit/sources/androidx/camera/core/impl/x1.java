package androidx.camera.core.impl;

import com.google.android.gms.internal.mlkit_vision_barcode.pd;

/* loaded from: classes.dex */
public final class x1 implements t.y0 {

    /* renamed from: b, reason: collision with root package name */
    public final long f1518b;

    /* renamed from: c, reason: collision with root package name */
    public final t.y0 f1519c;

    public x1(long j4, t.y0 y0Var) {
        pd.a("Timeout must be non-negative.", j4 >= 0);
        this.f1518b = j4;
        this.f1519c = y0Var;
    }

    @Override // t.y0
    public final long a() {
        return this.f1518b;
    }

    @Override // t.y0
    public final t.x0 b(com.example.test.service.q0 q0Var) {
        t.x0 b3 = this.f1519c.b(q0Var);
        long j4 = this.f1518b;
        if (j4 > 0) {
            if (q0Var.f7751b >= j4 - b3.f18427a) {
                return t.x0.f18425d;
            }
        }
        return b3;
    }
}
