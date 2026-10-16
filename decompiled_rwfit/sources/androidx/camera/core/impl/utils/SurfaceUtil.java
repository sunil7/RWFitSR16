package androidx.camera.core.impl.utils;

import android.view.Surface;
import n9.e;

/* loaded from: classes.dex */
public abstract class SurfaceUtil {
    static {
        System.loadLibrary("surface_util_jni");
    }

    public static e a(Surface surface) {
        int[] nativeGetSurfaceInfo = nativeGetSurfaceInfo(surface);
        e eVar = new e(21);
        int i3 = nativeGetSurfaceInfo[0];
        int i10 = nativeGetSurfaceInfo[1];
        int i11 = nativeGetSurfaceInfo[2];
        return eVar;
    }

    private static native int[] nativeGetSurfaceInfo(Surface surface);
}
