package androidx.camera.core.impl;

/* loaded from: classes.dex */
public interface o extends j1 {

    /* renamed from: l0, reason: collision with root package name */
    public static final c f1457l0 = new c("camerax.core.camera.useCaseConfigFactory", c2.class, null);

    /* renamed from: m0, reason: collision with root package name */
    public static final c f1458m0 = new c("camerax.core.camera.useCaseCombinationRequiredRule", Integer.class, null);

    /* renamed from: n0, reason: collision with root package name */
    public static final c f1459n0 = new c("camerax.core.camera.SessionProcessor", t1.class, null);

    /* renamed from: o0, reason: collision with root package name */
    public static final c f1460o0 = new c("camerax.core.camera.isPostviewSupported", Boolean.class, null);

    /* renamed from: p0, reason: collision with root package name */
    public static final c f1461p0 = new c("camerax.core.camera.isCaptureProcessProgressSupported", Boolean.class, null);

    default void q() {
        if (k(f1459n0, null) != null) {
            throw new ClassCastException();
        }
    }
}
