package androidx.camera.core.impl;

/* loaded from: classes.dex */
public final class x implements t.y0 {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f1515b;

    /* renamed from: c, reason: collision with root package name */
    public final t.y0 f1516c;

    public x(int i3, long j4) {
        this.f1515b = i3;
        switch (i3) {
            case 1:
                this.f1516c = new x1(j4, new w(j4));
                break;
            default:
                this.f1516c = new x(1, j4);
                break;
        }
    }

    @Override // t.y0
    public final long a() {
        switch (this.f1515b) {
            case 0:
                return ((x1) ((x) this.f1516c).f1516c).f1518b;
            default:
                return ((x1) this.f1516c).f1518b;
        }
    }

    @Override // t.y0
    public final t.x0 b(com.example.test.service.q0 q0Var) {
        switch (this.f1515b) {
            case 0:
                if (((x1) ((x) this.f1516c).f1516c).b(q0Var).f18428b) {
                    return t.x0.e;
                }
                Throwable th2 = (Throwable) q0Var.f7752c;
                if (th2 instanceof CameraValidator$CameraIdListIncorrectException) {
                    com.google.android.gms.internal.mlkit_vision_common.a0.b("CameraX", "The device might underreport the amount of the cameras. Finish the initialize task since we are already reaching the maximum number of retries.");
                    if (((CameraValidator$CameraIdListIncorrectException) th2).getAvailableCameraCount() > 0) {
                        return t.x0.f18426f;
                    }
                }
                return t.x0.f18425d;
            default:
                return ((x1) this.f1516c).b(q0Var);
        }
    }
}
