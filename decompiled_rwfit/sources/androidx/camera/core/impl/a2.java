package androidx.camera.core.impl;

import android.util.Range;

/* loaded from: classes.dex */
public interface a2 extends y.i, o0 {
    public static final c C0 = new c("camerax.core.useCase.defaultSessionConfig", s1.class, null);
    public static final c D0 = new c("camerax.core.useCase.defaultCaptureConfig", d0.class, null);
    public static final c E0 = new c("camerax.core.useCase.sessionConfigUnpacker", n.r.class, null);
    public static final c F0 = new c("camerax.core.useCase.captureConfigUnpacker", n.q.class, null);
    public static final c G0;
    public static final c H0;
    public static final c I0;
    public static final c J0;
    public static final c K0;
    public static final c L0;
    public static final c M0;

    static {
        Class cls = Integer.TYPE;
        G0 = new c("camerax.core.useCase.surfaceOccupancyPriority", cls, null);
        H0 = new c("camerax.core.useCase.targetFrameRate", Range.class, null);
        Class cls2 = Boolean.TYPE;
        I0 = new c("camerax.core.useCase.zslDisabled", cls2, null);
        J0 = new c("camerax.core.useCase.highResolutionDisabled", cls2, null);
        K0 = new c("camerax.core.useCase.captureType", UseCaseConfigFactory$CaptureType.class, null);
        L0 = new c("camerax.core.useCase.previewStabilizationMode", cls, null);
        M0 = new c("camerax.core.useCase.videoStabilizationMode", cls, null);
    }

    default int D() {
        return ((Integer) k(L0, 0)).intValue();
    }

    default UseCaseConfigFactory$CaptureType p() {
        return (UseCaseConfigFactory$CaptureType) e(K0);
    }
}
