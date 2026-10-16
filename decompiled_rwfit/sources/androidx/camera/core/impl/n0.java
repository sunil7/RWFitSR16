package androidx.camera.core.impl;

/* loaded from: classes.dex */
public final class n0 implements a2, p0, y.f {

    /* renamed from: b, reason: collision with root package name */
    public static final c f1448b;

    /* renamed from: c, reason: collision with root package name */
    public static final c f1449c;

    /* renamed from: d, reason: collision with root package name */
    public static final c f1450d;
    public static final c e;

    /* renamed from: f, reason: collision with root package name */
    public static final c f1451f;

    /* renamed from: g, reason: collision with root package name */
    public static final c f1452g;

    /* renamed from: h, reason: collision with root package name */
    public static final c f1453h;

    /* renamed from: i, reason: collision with root package name */
    public static final c f1454i;

    /* renamed from: j, reason: collision with root package name */
    public static final c f1455j;

    /* renamed from: a, reason: collision with root package name */
    public final d1 f1456a;

    static {
        Class cls = Integer.TYPE;
        f1448b = new c("camerax.core.imageCapture.captureMode", cls, null);
        f1449c = new c("camerax.core.imageCapture.flashMode", cls, null);
        f1450d = new c("camerax.core.imageCapture.bufferFormat", Integer.class, null);
        e = new c("camerax.core.imageCapture.outputFormat", Integer.class, null);
        f1451f = new c("camerax.core.imageCapture.imageReaderProxyProvider", t.q0.class, null);
        f1452g = new c("camerax.core.imageCapture.useSoftwareJpegEncoder", Boolean.TYPE, null);
        f1453h = new c("camerax.core.imageCapture.flashType", cls, null);
        f1454i = new c("camerax.core.imageCapture.screenFlash", t.k0.class, null);
        f1455j = new c("camerax.core.useCase.isPostviewEnabled", Boolean.class, null);
    }

    public n0(d1 d1Var) {
        this.f1456a = d1Var;
    }

    @Override // androidx.camera.core.impl.o0
    public final int A() {
        return ((Integer) e(o0.f1462q0)).intValue();
    }

    @Override // androidx.camera.core.impl.j1
    public final e0 y() {
        return this.f1456a;
    }
}
