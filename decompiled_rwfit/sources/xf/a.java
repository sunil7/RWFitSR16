package xf;

import android.opengl.EGL14;
import android.opengl.GLES20;
import android.opengl.GLU;
import android.opengl.Matrix;
import android.support.v4.media.session.e;
import android.util.Log;
import zf.d;

/* loaded from: classes2.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    public static final float[] f19823a;

    static {
        float[] fArr = new float[16];
        Matrix.setIdentityM(fArr, 0);
        f19823a = fArr;
    }

    public static final void a(String str) {
        int eglGetError = EGL14.eglGetError();
        if (eglGetError == d.f20409d) {
            return;
        }
        StringBuilder r = e.r("Error during ", str, ": EGL error 0x");
        String hexString = Integer.toHexString(eglGetError);
        kotlin.jvm.internal.e.e(hexString, "toHexString(value)");
        r.append(hexString);
        String sb2 = r.toString();
        Log.e("Egloo", sb2);
        throw new RuntimeException(sb2);
    }

    public static final void b(String opName) {
        kotlin.jvm.internal.e.f(opName, "opName");
        int glGetError = GLES20.glGetError();
        if (glGetError == 0) {
            return;
        }
        StringBuilder r = e.r("Error during ", opName, ": glError 0x");
        String hexString = Integer.toHexString(glGetError);
        kotlin.jvm.internal.e.e(hexString, "toHexString(value)");
        r.append(hexString);
        r.append(": ");
        String gluErrorString = GLU.gluErrorString(glGetError);
        kotlin.jvm.internal.e.e(gluErrorString, "gluErrorString(value)");
        r.append(gluErrorString);
        String sb2 = r.toString();
        Log.e("Egloo", sb2);
        throw new RuntimeException(sb2);
    }
}
