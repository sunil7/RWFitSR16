package e0;

import android.opengl.EGL14;
import android.opengl.EGLConfig;
import android.opengl.EGLDisplay;
import android.opengl.EGLSurface;
import android.opengl.GLES20;
import android.util.Log;
import android.view.Surface;
import androidx.camera.core.processing.util.GLUtils$InputFormat;
import com.google.android.gms.internal.mlkit_vision_barcode.l0;
import com.google.android.gms.internal.mlkit_vision_barcode.pd;
import com.google.android.gms.internal.mlkit_vision_common.a0;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.util.Collections;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import t.t;

/* loaded from: classes.dex */
public abstract class h {

    /* renamed from: a, reason: collision with root package name */
    public static final int[] f12427a = {12344};

    /* renamed from: b, reason: collision with root package name */
    public static final int[] f12428b = {12445, 13632, 12344};

    /* renamed from: c, reason: collision with root package name */
    public static final String f12429c;

    /* renamed from: d, reason: collision with root package name */
    public static final String f12430d;
    public static final d e;

    /* renamed from: f, reason: collision with root package name */
    public static final d f12431f;

    /* renamed from: g, reason: collision with root package name */
    public static final d f12432g;

    /* renamed from: h, reason: collision with root package name */
    public static final FloatBuffer f12433h;

    /* renamed from: i, reason: collision with root package name */
    public static final FloatBuffer f12434i;

    /* renamed from: j, reason: collision with root package name */
    public static final c f12435j;

    static {
        Locale locale = Locale.US;
        f12429c = "uniform mat4 uTexMatrix;\nuniform mat4 uTransMatrix;\nattribute vec4 aPosition;\nattribute vec4 aTextureCoord;\nvarying vec2 vTextureCoord;\nvoid main() {\n    gl_Position = uTransMatrix * aPosition;\n    vTextureCoord = (uTexMatrix * aTextureCoord).xy;\n}\n";
        f12430d = "#version 300 es\nin vec4 aPosition;\nin vec4 aTextureCoord;\nuniform mat4 uTexMatrix;\nuniform mat4 uTransMatrix;\nout vec2 vTextureCoord;\nvoid main() {\n  gl_Position = uTransMatrix * aPosition;\n  vTextureCoord = (uTexMatrix * aTextureCoord).xy;\n}\n";
        e = new d(0);
        f12431f = new d(1);
        f12432g = new d(2);
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(32);
        allocateDirect.order(ByteOrder.nativeOrder());
        FloatBuffer asFloatBuffer = allocateDirect.asFloatBuffer();
        asFloatBuffer.put(new float[]{-1.0f, -1.0f, 1.0f, -1.0f, -1.0f, 1.0f, 1.0f, 1.0f});
        asFloatBuffer.position(0);
        f12433h = asFloatBuffer;
        ByteBuffer allocateDirect2 = ByteBuffer.allocateDirect(32);
        allocateDirect2.order(ByteOrder.nativeOrder());
        FloatBuffer asFloatBuffer2 = allocateDirect2.asFloatBuffer();
        asFloatBuffer2.put(new float[]{0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f});
        asFloatBuffer2.position(0);
        f12434i = asFloatBuffer2;
        f12435j = new c(EGL14.EGL_NO_SURFACE, 0, 0);
    }

    public static void a(String str) {
        int eglGetError = EGL14.eglGetError();
        if (eglGetError == 12288) {
            return;
        }
        StringBuilder u10 = l0.u(str, ": EGL error: 0x");
        u10.append(Integer.toHexString(eglGetError));
        throw new IllegalStateException(u10.toString());
    }

    public static void b(String str) {
        int glGetError = GLES20.glGetError();
        if (glGetError == 0) {
            return;
        }
        StringBuilder u10 = l0.u(str, ": GL error 0x");
        u10.append(Integer.toHexString(glGetError));
        throw new IllegalStateException(u10.toString());
    }

    public static void c(Thread thread) {
        pd.f("Method call must be called on the GL thread.", thread == Thread.currentThread());
    }

    public static void d(AtomicBoolean atomicBoolean, boolean z5) {
        pd.f(z5 ? "OpenGlRenderer is not initialized" : "OpenGlRenderer is already initialized", z5 == atomicBoolean.get());
    }

    public static void e(int i3, String str) {
        if (i3 < 0) {
            throw new IllegalStateException(l0.o("Unable to locate '", str, "' in program"));
        }
    }

    public static int[] f(String str, t tVar) {
        int[] iArr = f12427a;
        if (tVar.f18411a == 3) {
            if (str.contains("EGL_EXT_gl_colorspace_bt2020_hlg")) {
                return f12428b;
            }
            a0.e("GLUtils", "Dynamic range uses HLG encoding, but device does not support EGL_EXT_gl_colorspace_bt2020_hlg.Fallback to default colorspace.");
        }
        return iArr;
    }

    public static HashMap g(t tVar) {
        Object gVar;
        GLUtils$InputFormat gLUtils$InputFormat;
        Map map = Collections.EMPTY_MAP;
        HashMap hashMap = new HashMap();
        GLUtils$InputFormat[] values = GLUtils$InputFormat.values();
        int length = values.length;
        for (int i3 = 0; i3 < length; i3++) {
            GLUtils$InputFormat gLUtils$InputFormat2 = values[i3];
            d dVar = (d) map.get(gLUtils$InputFormat2);
            if (dVar != null) {
                gVar = new g(tVar, dVar);
            } else if (gLUtils$InputFormat2 == GLUtils$InputFormat.YUV || gLUtils$InputFormat2 == (gLUtils$InputFormat = GLUtils$InputFormat.DEFAULT)) {
                gVar = new g(tVar, gLUtils$InputFormat2);
            } else {
                pd.f("Unhandled input format: " + gLUtils$InputFormat2, gLUtils$InputFormat2 == GLUtils$InputFormat.UNKNOWN);
                if (tVar.a()) {
                    gVar = new e("uniform mat4 uTransMatrix;\nattribute vec4 aPosition;\nvoid main() {\n    gl_Position = uTransMatrix * aPosition;\n}\n", "precision mediump float;\nuniform float uAlphaScale;\nvoid main() {\n    gl_FragColor = vec4(0.0, 0.0, 0.0, uAlphaScale);\n}\n");
                } else {
                    d dVar2 = (d) map.get(gLUtils$InputFormat);
                    gVar = dVar2 != null ? new g(tVar, dVar2) : new g(tVar, gLUtils$InputFormat);
                }
            }
            Log.d("GLUtils", "Shader program for input format " + gLUtils$InputFormat2 + " created: " + gVar);
            hashMap.put(gLUtils$InputFormat2, gVar);
        }
        return hashMap;
    }

    public static int h() {
        int[] iArr = new int[1];
        GLES20.glGenTextures(1, iArr, 0);
        b("glGenTextures");
        int i3 = iArr[0];
        GLES20.glBindTexture(36197, i3);
        b("glBindTexture " + i3);
        GLES20.glTexParameteri(36197, 10241, 9728);
        GLES20.glTexParameteri(36197, 10240, 9729);
        GLES20.glTexParameteri(36197, 10242, 33071);
        GLES20.glTexParameteri(36197, 10243, 33071);
        b("glTexParameter");
        return i3;
    }

    public static EGLSurface i(EGLDisplay eGLDisplay, EGLConfig eGLConfig, Surface surface, int[] iArr) {
        EGLSurface eglCreateWindowSurface = EGL14.eglCreateWindowSurface(eGLDisplay, eGLConfig, surface, iArr, 0);
        a("eglCreateWindowSurface");
        if (eglCreateWindowSurface != null) {
            return eglCreateWindowSurface;
        }
        throw new IllegalStateException("surface was null");
    }

    public static String j() {
        Matcher matcher = Pattern.compile("OpenGL ES ([0-9]+)\\.([0-9]+).*").matcher(GLES20.glGetString(7938));
        if (!matcher.find()) {
            return "0.0";
        }
        String group = matcher.group(1);
        group.getClass();
        String group2 = matcher.group(2);
        group2.getClass();
        return r5.a.c(group, ".", group2);
    }

    public static int k(int i3, String str) {
        int glCreateShader = GLES20.glCreateShader(i3);
        b("glCreateShader type=" + i3);
        GLES20.glShaderSource(glCreateShader, str);
        GLES20.glCompileShader(glCreateShader);
        int[] iArr = new int[1];
        GLES20.glGetShaderiv(glCreateShader, 35713, iArr, 0);
        if (iArr[0] != 0) {
            return glCreateShader;
        }
        a0.e("GLUtils", "Could not compile shader: " + str);
        GLES20.glDeleteShader(glCreateShader);
        StringBuilder q5 = android.support.v4.media.session.e.q(i3, "Could not compile shader type ", ":");
        q5.append(GLES20.glGetShaderInfoLog(glCreateShader));
        throw new IllegalStateException(q5.toString());
    }
}
