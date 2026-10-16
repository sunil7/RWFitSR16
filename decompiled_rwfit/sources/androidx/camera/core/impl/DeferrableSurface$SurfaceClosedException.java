package androidx.camera.core.impl;

/* loaded from: classes.dex */
public final class DeferrableSurface$SurfaceClosedException extends Exception {
    g0 mDeferrableSurface;

    public DeferrableSurface$SurfaceClosedException(String str, g0 g0Var) {
        super(str);
        this.mDeferrableSurface = g0Var;
    }

    public g0 getDeferrableSurface() {
        return this.mDeferrableSurface;
    }
}
