package c0;

import android.opengl.EGL14;
import android.opengl.EGLConfig;
import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.opengl.EGLExt;
import android.opengl.EGLSurface;
import android.opengl.GLES20;
import android.util.Log;
import android.util.Size;
import android.view.Surface;
import androidx.camera.core.processing.util.GLUtils$InputFormat;
import com.google.android.gms.internal.mlkit_vision_barcode.pd;
import com.google.android.gms.internal.mlkit_vision_common.a0;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;
import t.t;

/* loaded from: classes.dex */
public class h {

    /* renamed from: c, reason: collision with root package name */
    public Thread f3305c;

    /* renamed from: g, reason: collision with root package name */
    public EGLConfig f3308g;

    /* renamed from: i, reason: collision with root package name */
    public Surface f3310i;

    /* renamed from: a, reason: collision with root package name */
    public final AtomicBoolean f3303a = new AtomicBoolean(false);

    /* renamed from: b, reason: collision with root package name */
    public final HashMap f3304b = new HashMap();

    /* renamed from: d, reason: collision with root package name */
    public EGLDisplay f3306d = EGL14.EGL_NO_DISPLAY;
    public EGLContext e = EGL14.EGL_NO_CONTEXT;

    /* renamed from: f, reason: collision with root package name */
    public int[] f3307f = e0.h.f12427a;

    /* renamed from: h, reason: collision with root package name */
    public EGLSurface f3309h = EGL14.EGL_NO_SURFACE;

    /* renamed from: j, reason: collision with root package name */
    public Map f3311j = Collections.EMPTY_MAP;

    /* renamed from: k, reason: collision with root package name */
    public e0.f f3312k = null;

    /* renamed from: l, reason: collision with root package name */
    public GLUtils$InputFormat f3313l = GLUtils$InputFormat.UNKNOWN;

    /* renamed from: m, reason: collision with root package name */
    public int f3314m = -1;

    public final void a(t tVar, v2.h hVar) {
        EGLDisplay eglGetDisplay = EGL14.eglGetDisplay(0);
        this.f3306d = eglGetDisplay;
        if (Objects.equals(eglGetDisplay, EGL14.EGL_NO_DISPLAY)) {
            throw new IllegalStateException("Unable to get EGL14 display");
        }
        int[] iArr = new int[2];
        if (!EGL14.eglInitialize(this.f3306d, iArr, 0, iArr, 1)) {
            this.f3306d = EGL14.EGL_NO_DISPLAY;
            throw new IllegalStateException("Unable to initialize EGL14");
        }
        if (hVar != null) {
            String str = iArr[0] + "." + iArr[1];
            if (str == null) {
                throw new NullPointerException("Null eglVersion");
            }
            hVar.f19147b = str;
        }
        int i3 = tVar.a() ? 10 : 8;
        EGLConfig[] eGLConfigArr = new EGLConfig[1];
        if (!EGL14.eglChooseConfig(this.f3306d, new int[]{12324, i3, 12323, i3, 12322, i3, 12321, tVar.a() ? 2 : 8, 12325, 0, 12326, 0, 12352, tVar.a() ? 64 : 4, 12610, tVar.a() ? -1 : 1, 12339, 5, 12344}, 0, eGLConfigArr, 0, 1, new int[1], 0)) {
            throw new IllegalStateException("Unable to find a suitable EGLConfig");
        }
        EGLConfig eGLConfig = eGLConfigArr[0];
        EGLContext eglCreateContext = EGL14.eglCreateContext(this.f3306d, eGLConfig, EGL14.EGL_NO_CONTEXT, new int[]{12440, tVar.a() ? 3 : 2, 12344}, 0);
        e0.h.a("eglCreateContext");
        this.f3308g = eGLConfig;
        this.e = eglCreateContext;
        int[] iArr2 = new int[1];
        EGL14.eglQueryContext(this.f3306d, eglCreateContext, 12440, iArr2, 0);
        Log.d("OpenGlRenderer", "EGLContext created, client version " + iArr2[0]);
    }

    public final e0.c b(Surface surface) {
        try {
            EGLDisplay eGLDisplay = this.f3306d;
            EGLConfig eGLConfig = this.f3308g;
            Objects.requireNonNull(eGLConfig);
            EGLSurface i3 = e0.h.i(eGLDisplay, eGLConfig, surface, this.f3307f);
            EGLDisplay eGLDisplay2 = this.f3306d;
            int[] iArr = new int[1];
            EGL14.eglQuerySurface(eGLDisplay2, i3, 12375, iArr, 0);
            int i10 = iArr[0];
            int[] iArr2 = new int[1];
            EGL14.eglQuerySurface(eGLDisplay2, i3, 12374, iArr2, 0);
            Size size = new Size(i10, iArr2[0]);
            return new e0.c(i3, size.getWidth(), size.getHeight());
        } catch (IllegalArgumentException | IllegalStateException e) {
            a0.f("OpenGlRenderer", "Failed to create EGL surface: " + e.getMessage(), e);
            return null;
        }
    }

    public final void c() {
        EGLDisplay eGLDisplay = this.f3306d;
        EGLConfig eGLConfig = this.f3308g;
        Objects.requireNonNull(eGLConfig);
        int[] iArr = e0.h.f12427a;
        EGLSurface eglCreatePbufferSurface = EGL14.eglCreatePbufferSurface(eGLDisplay, eGLConfig, new int[]{12375, 1, 12374, 1, 12344}, 0);
        e0.h.a("eglCreatePbufferSurface");
        if (eglCreatePbufferSurface == null) {
            throw new IllegalStateException("surface was null");
        }
        this.f3309h = eglCreatePbufferSurface;
    }

    public final k1.c d(t tVar) {
        e0.h.d(this.f3303a, false);
        try {
            a(tVar, null);
            c();
            f(this.f3309h);
            String glGetString = GLES20.glGetString(7939);
            String eglQueryString = EGL14.eglQueryString(this.f3306d, 12373);
            if (glGetString == null) {
                glGetString = "";
            }
            if (eglQueryString == null) {
                eglQueryString = "";
            }
            return new k1.c(glGetString, eglQueryString);
        } catch (IllegalStateException e) {
            a0.f("OpenGlRenderer", "Failed to get GL or EGL extensions: " + e.getMessage(), e);
            return new k1.c("", "");
        } finally {
            h();
        }
    }

    public e0.a e(t tVar) {
        Map map = Collections.EMPTY_MAP;
        AtomicBoolean atomicBoolean = this.f3303a;
        e0.h.d(atomicBoolean, false);
        v2.h hVar = new v2.h();
        hVar.f19146a = "0.0";
        hVar.f19147b = "0.0";
        hVar.f19148c = "";
        hVar.f19149d = "";
        try {
            if (tVar.a()) {
                k1.c d5 = d(tVar);
                String str = (String) d5.f15450a;
                str.getClass();
                String str2 = (String) d5.f15451b;
                str2.getClass();
                if (!str.contains("GL_EXT_YUV_target")) {
                    a0.e("OpenGlRenderer", "Device does not support GL_EXT_YUV_target. Fallback to SDR.");
                    tVar = t.f18406d;
                }
                this.f3307f = e0.h.f(str2, tVar);
                hVar.f19148c = str;
                hVar.f19149d = str2;
            }
            a(tVar, hVar);
            c();
            f(this.f3309h);
            String j4 = e0.h.j();
            if (j4 == null) {
                throw new NullPointerException("Null glVersion");
            }
            hVar.f19146a = j4;
            this.f3311j = e0.h.g(tVar);
            int h4 = e0.h.h();
            this.f3314m = h4;
            k(h4);
            this.f3305c = Thread.currentThread();
            atomicBoolean.set(true);
            String str3 = ((String) hVar.f19146a) == null ? " glVersion" : "";
            if (((String) hVar.f19147b) == null) {
                str3 = str3.concat(" eglVersion");
            }
            if (((String) hVar.f19148c) == null) {
                str3 = android.support.v4.media.session.e.l(str3, " glExtensions");
            }
            if (((String) hVar.f19149d) == null) {
                str3 = android.support.v4.media.session.e.l(str3, " eglExtensions");
            }
            if (str3.isEmpty()) {
                return new e0.a((String) hVar.f19146a, (String) hVar.f19147b, (String) hVar.f19148c, (String) hVar.f19149d);
            }
            throw new IllegalStateException("Missing required properties:".concat(str3));
        } catch (IllegalArgumentException e) {
            e = e;
            h();
            throw e;
        } catch (IllegalStateException e10) {
            e = e10;
            h();
            throw e;
        }
    }

    public final void f(EGLSurface eGLSurface) {
        this.f3306d.getClass();
        this.e.getClass();
        if (!EGL14.eglMakeCurrent(this.f3306d, eGLSurface, eGLSurface, this.e)) {
            throw new IllegalStateException("eglMakeCurrent failed");
        }
    }

    public final void g(Surface surface) {
        e0.h.d(this.f3303a, true);
        e0.h.c(this.f3305c);
        HashMap hashMap = this.f3304b;
        if (hashMap.containsKey(surface)) {
            return;
        }
        hashMap.put(surface, e0.h.f12435j);
    }

    public final void h() {
        Iterator it = this.f3311j.values().iterator();
        while (it.hasNext()) {
            GLES20.glDeleteProgram(((e0.f) it.next()).f12421a);
        }
        this.f3311j = Collections.EMPTY_MAP;
        this.f3312k = null;
        if (!Objects.equals(this.f3306d, EGL14.EGL_NO_DISPLAY)) {
            EGLDisplay eGLDisplay = this.f3306d;
            EGLSurface eGLSurface = EGL14.EGL_NO_SURFACE;
            EGL14.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface, EGL14.EGL_NO_CONTEXT);
            HashMap hashMap = this.f3304b;
            for (e0.c cVar : hashMap.values()) {
                if (!Objects.equals(cVar.f12417a, EGL14.EGL_NO_SURFACE) && !EGL14.eglDestroySurface(this.f3306d, cVar.f12417a)) {
                    try {
                        e0.h.a("eglDestroySurface");
                    } catch (IllegalStateException e) {
                        a0.c("GLUtils", e.toString(), e);
                    }
                }
            }
            hashMap.clear();
            if (!Objects.equals(this.f3309h, EGL14.EGL_NO_SURFACE)) {
                EGL14.eglDestroySurface(this.f3306d, this.f3309h);
                this.f3309h = EGL14.EGL_NO_SURFACE;
            }
            if (!Objects.equals(this.e, EGL14.EGL_NO_CONTEXT)) {
                EGL14.eglDestroyContext(this.f3306d, this.e);
                this.e = EGL14.EGL_NO_CONTEXT;
            }
            EGL14.eglReleaseThread();
            EGL14.eglTerminate(this.f3306d);
            this.f3306d = EGL14.EGL_NO_DISPLAY;
        }
        this.f3308g = null;
        this.f3314m = -1;
        this.f3313l = GLUtils$InputFormat.UNKNOWN;
        this.f3310i = null;
        this.f3305c = null;
    }

    public final void i(Surface surface, boolean z5) {
        if (this.f3310i == surface) {
            this.f3310i = null;
            f(this.f3309h);
        }
        HashMap hashMap = this.f3304b;
        e0.c cVar = z5 ? (e0.c) hashMap.remove(surface) : (e0.c) hashMap.put(surface, e0.h.f12435j);
        if (cVar == null || cVar == e0.h.f12435j) {
            return;
        }
        try {
            EGL14.eglDestroySurface(this.f3306d, cVar.f12417a);
        } catch (RuntimeException e) {
            a0.f("OpenGlRenderer", "Failed to destroy EGL surface: " + e.getMessage(), e);
        }
    }

    public final void j(long j4, float[] fArr, Surface surface) {
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
        Surface surface2 = this.f3310i;
        EGLSurface eGLSurface = cVar.f12417a;
        if (surface != surface2) {
            f(eGLSurface);
            this.f3310i = surface;
            int i3 = cVar.f12418b;
            int i10 = cVar.f12419c;
            GLES20.glViewport(0, 0, i3, i10);
            GLES20.glScissor(0, 0, i3, i10);
        }
        e0.f fVar = this.f3312k;
        fVar.getClass();
        if (fVar instanceof e0.g) {
            GLES20.glUniformMatrix4fv(((e0.g) fVar).f12425f, 1, false, fArr, 0);
            e0.h.b("glUniformMatrix4fv");
        }
        GLES20.glDrawArrays(5, 0, 4);
        e0.h.b("glDrawArrays");
        EGLExt.eglPresentationTimeANDROID(this.f3306d, eGLSurface, j4);
        if (EGL14.eglSwapBuffers(this.f3306d, eGLSurface)) {
            return;
        }
        a0.e("OpenGlRenderer", "Failed to swap buffers with EGL error: 0x" + Integer.toHexString(EGL14.eglGetError()));
        i(surface, false);
    }

    public final void k(int i3) {
        e0.f fVar = (e0.f) this.f3311j.get(this.f3313l);
        if (fVar == null) {
            throw new IllegalStateException("Unable to configure program for input format: " + this.f3313l);
        }
        if (this.f3312k != fVar) {
            this.f3312k = fVar;
            fVar.b();
            Log.d("OpenGlRenderer", "Using program for input format " + this.f3313l + ": " + this.f3312k);
        }
        GLES20.glActiveTexture(33984);
        e0.h.b("glActiveTexture");
        GLES20.glBindTexture(36197, i3);
        e0.h.b("glBindTexture");
    }
}
