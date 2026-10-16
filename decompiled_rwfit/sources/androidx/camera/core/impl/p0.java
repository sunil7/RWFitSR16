package androidx.camera.core.impl;

import android.util.Size;
import java.util.List;

/* loaded from: classes.dex */
public interface p0 extends j1 {
    public static final c A0;
    public static final c B0;

    /* renamed from: s0, reason: collision with root package name */
    public static final c f1466s0 = new c("camerax.core.imageOutput.targetAspectRatio", t.d.class, null);

    /* renamed from: t0, reason: collision with root package name */
    public static final c f1467t0;

    /* renamed from: u0, reason: collision with root package name */
    public static final c f1468u0;

    /* renamed from: v0, reason: collision with root package name */
    public static final c f1469v0;

    /* renamed from: w0, reason: collision with root package name */
    public static final c f1470w0;

    /* renamed from: x0, reason: collision with root package name */
    public static final c f1471x0;

    /* renamed from: y0, reason: collision with root package name */
    public static final c f1472y0;

    /* renamed from: z0, reason: collision with root package name */
    public static final c f1473z0;

    static {
        Class cls = Integer.TYPE;
        f1467t0 = new c("camerax.core.imageOutput.targetRotation", cls, null);
        f1468u0 = new c("camerax.core.imageOutput.appTargetRotation", cls, null);
        f1469v0 = new c("camerax.core.imageOutput.mirrorMode", cls, null);
        f1470w0 = new c("camerax.core.imageOutput.targetResolution", Size.class, null);
        f1471x0 = new c("camerax.core.imageOutput.defaultResolution", Size.class, null);
        f1472y0 = new c("camerax.core.imageOutput.maxResolution", Size.class, null);
        f1473z0 = new c("camerax.core.imageOutput.supportedResolutions", List.class, null);
        A0 = new c("camerax.core.imageOutput.resolutionSelector", f0.b.class, null);
        B0 = new c("camerax.core.imageOutput.customOrderedResolutions", List.class, null);
    }

    static void Q(p0 p0Var) {
        boolean b3 = p0Var.b(f1466s0);
        boolean z5 = ((Size) p0Var.k(f1470w0, null)) != null;
        if (b3 && z5) {
            throw new IllegalArgumentException("Cannot use both setTargetResolution and setTargetAspectRatio on the same config.");
        }
        if (((f0.b) p0Var.k(A0, null)) != null) {
            if (b3 || z5) {
                throw new IllegalArgumentException("Cannot use setTargetResolution or setTargetAspectRatio with setResolutionSelector on the same config.");
            }
        }
    }

    default int n() {
        return ((Integer) k(f1467t0, 0)).intValue();
    }
}
