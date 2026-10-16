package d0;

import android.graphics.SurfaceTexture;
import android.opengl.EGL14;
import android.opengl.EGLExt;
import android.opengl.EGLSurface;
import android.opengl.GLES20;
import android.opengl.Matrix;
import android.util.Size;
import android.view.Surface;
import c0.h;
import c0.o;
import com.google.android.gms.internal.mlkit_vision_barcode.pd;
import com.google.android.gms.internal.mlkit_vision_common.a0;
import e0.f;
import e0.g;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import okhttp3.internal.http2.Http2;
import t.r0;
import t.t;

/* loaded from: classes.dex */
public final class c extends h {

    /* renamed from: n, reason: collision with root package name */
    public int f12181n = -1;

    /* renamed from: o, reason: collision with root package name */
    public int f12182o = -1;

    /* renamed from: p, reason: collision with root package name */
    public final r0 f12183p;

    /* renamed from: q, reason: collision with root package name */
    public final r0 f12184q;

    public c(r0 r0Var, r0 r0Var2) {
        this.f12183p = r0Var;
        this.f12184q = r0Var2;
    }

    @Override // c0.h
    public final e0.a e(t tVar) {
        Map map = Collections.EMPTY_MAP;
        e0.a e = super.e(tVar);
        this.f12181n = e0.h.h();
        this.f12182o = e0.h.h();
        return e;
    }

    public final void l(long j4, Surface surface, o oVar, SurfaceTexture surfaceTexture, SurfaceTexture surfaceTexture2) {
        e0.h.d(this.f3303a, true);
        e0.h.c(this.f3305c);
        HashMap hashMap = this.f3304b;
        pd.f("The surface is not registered.", hashMap.containsKey(surface));
        e0.c cVar = (e0.c) hashMap.get(surface);
        Objects.requireNonNull(cVar);
        if (cVar == e0.h.f12435j) {
            cVar = b(surface);
            if (cVar == null) {
                return;
            } else {
                hashMap.put(surface, cVar);
            }
        }
        e0.c cVar2 = cVar;
        Surface surface2 = this.f3310i;
        EGLSurface eGLSurface = cVar2.f12417a;
        if (surface != surface2) {
            f(eGLSurface);
            this.f3310i = surface;
        }
        GLES20.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
        GLES20.glClear(Http2.INITIAL_MAX_FRAME_SIZE);
        m(cVar2, oVar, surfaceTexture, this.f12183p, this.f12181n);
        m(cVar2, oVar, surfaceTexture2, this.f12184q, this.f12182o);
        EGLExt.eglPresentationTimeANDROID(this.f3306d, eGLSurface, j4);
        if (EGL14.eglSwapBuffers(this.f3306d, eGLSurface)) {
            return;
        }
        a0.e("DualOpenGlRenderer", "Failed to swap buffers with EGL error: 0x" + Integer.toHexString(EGL14.eglGetError()));
        i(surface, false);
    }

    public final void m(e0.c cVar, o oVar, SurfaceTexture surfaceTexture, r0 r0Var, int i3) {
        k(i3);
        int i10 = cVar.f12418b;
        int i11 = cVar.f12419c;
        GLES20.glViewport(0, 0, i10, i11);
        GLES20.glScissor(0, 0, i10, i11);
        float[] fArr = new float[16];
        surfaceTexture.getTransformMatrix(fArr);
        float[] fArr2 = new float[16];
        Matrix.multiplyMM(fArr2, 0, fArr, 0, oVar.e, 0);
        f fVar = this.f3312k;
        fVar.getClass();
        if (fVar instanceof g) {
            GLES20.glUniformMatrix4fv(((g) fVar).f12425f, 1, false, fArr2, 0);
            e0.h.b("glUniformMatrix4fv");
        }
        r0Var.getClass();
        Size size = new Size((int) (i10 * 1.0f), (int) (i11 * 1.0f));
        Size size2 = new Size(i10, i11);
        float[] fArr3 = new float[16];
        Matrix.setIdentityM(fArr3, 0);
        float[] fArr4 = new float[16];
        Matrix.setIdentityM(fArr4, 0);
        float[] fArr5 = new float[16];
        Matrix.setIdentityM(fArr5, 0);
        Matrix.scaleM(fArr3, 0, size.getWidth() / size2.getWidth(), size.getHeight() / size2.getHeight(), 1.0f);
        Matrix.translateM(fArr4, 0, 0.0f, 0.0f, 0.0f);
        Matrix.multiplyMM(fArr5, 0, fArr3, 0, fArr4, 0);
        GLES20.glUniformMatrix4fv(fVar.f12422b, 1, false, fArr5, 0);
        e0.h.b("glUniformMatrix4fv");
        GLES20.glUniform1f(fVar.f12423c, 1.0f);
        e0.h.b("glUniform1f");
        GLES20.glEnable(3042);
        GLES20.glBlendFuncSeparate(770, 771, 1, 771);
        GLES20.glDrawArrays(5, 0, 4);
        e0.h.b("glDrawArrays");
        GLES20.glDisable(3042);
    }
}
