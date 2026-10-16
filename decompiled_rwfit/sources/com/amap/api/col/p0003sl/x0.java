package com.amap.api.col.p0003sl;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.SurfaceTexture;
import android.opengl.GLSurfaceView;
import android.util.AttributeSet;
import android.util.Log;
import android.view.TextureView;
import com.amap.api.maps.MapsInitializer;
import com.google.android.gms.internal.mlkit_vision_barcode.l0;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;
import javax.microedition.khronos.opengles.GL;
import javax.microedition.khronos.opengles.GL10;

@SuppressLint({"NewApi"})
/* loaded from: classes.dex */
public class x0 extends TextureView implements TextureView.SurfaceTextureListener {

    /* renamed from: h, reason: collision with root package name */
    private static final k f5246h = new k();

    /* renamed from: i, reason: collision with root package name */
    public static final /* synthetic */ int f5247i = 0;

    /* renamed from: a, reason: collision with root package name */
    private final WeakReference<x0> f5248a;

    /* renamed from: b, reason: collision with root package name */
    private j f5249b;

    /* renamed from: c, reason: collision with root package name */
    private GLSurfaceView.Renderer f5250c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f5251d;
    private f e;

    /* renamed from: f, reason: collision with root package name */
    private g f5252f;

    /* renamed from: g, reason: collision with root package name */
    private h f5253g;

    public abstract class b implements f {

        /* renamed from: a, reason: collision with root package name */
        protected int[] f5254a;

        public b(int[] iArr) {
            this.f5254a = a(iArr);
        }

        private int[] a(int[] iArr) {
            x0 x0Var = x0.this;
            int i3 = x0.f5247i;
            x0Var.getClass();
            x0.this.getClass();
            return iArr;
        }

        public abstract EGLConfig a(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig[] eGLConfigArr);

        @Override // com.amap.api.col.3sl.x0.f
        public EGLConfig chooseConfig(EGL10 egl10, EGLDisplay eGLDisplay) {
            int[] iArr = new int[1];
            if (!egl10.eglChooseConfig(eGLDisplay, this.f5254a, null, 0, iArr)) {
                throw new IllegalArgumentException("eglChooseConfig failed");
            }
            int i3 = iArr[0];
            if (i3 <= 0) {
                throw new IllegalArgumentException("No configs match configSpec");
            }
            EGLConfig[] eGLConfigArr = new EGLConfig[i3];
            if (!egl10.eglChooseConfig(eGLDisplay, this.f5254a, eGLConfigArr, i3, iArr)) {
                throw new IllegalArgumentException("eglChooseConfig#2 failed");
            }
            EGLConfig a3 = a(egl10, eGLDisplay, eGLConfigArr);
            if (a3 != null) {
                return a3;
            }
            throw new IllegalArgumentException("No config chosen");
        }
    }

    public class c extends b {

        /* renamed from: c, reason: collision with root package name */
        private int[] f5256c;

        /* renamed from: d, reason: collision with root package name */
        protected int f5257d;
        protected int e;

        /* renamed from: f, reason: collision with root package name */
        protected int f5258f;

        /* renamed from: g, reason: collision with root package name */
        protected int f5259g;

        /* renamed from: h, reason: collision with root package name */
        protected int f5260h;

        /* renamed from: i, reason: collision with root package name */
        protected int f5261i;

        public c(int i3, int i10, int i11, int i12, int i13, int i14) {
            super(new int[]{12324, i3, 12323, i10, 12322, i11, 12321, i12, 12325, i13, 12326, i14, 12344});
            this.f5256c = new int[1];
            this.f5257d = i3;
            this.e = i10;
            this.f5258f = i11;
            this.f5259g = i12;
            this.f5260h = i13;
            this.f5261i = i14;
        }

        @Override // com.amap.api.col.3sl.x0.b
        public EGLConfig a(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig[] eGLConfigArr) {
            for (EGLConfig eGLConfig : eGLConfigArr) {
                int i3 = egl10.eglGetConfigAttrib(eGLDisplay, eGLConfig, 12325, this.f5256c) ? this.f5256c[0] : 0;
                int i10 = egl10.eglGetConfigAttrib(eGLDisplay, eGLConfig, 12326, this.f5256c) ? this.f5256c[0] : 0;
                if (i3 >= this.f5260h && i10 >= this.f5261i) {
                    int i11 = egl10.eglGetConfigAttrib(eGLDisplay, eGLConfig, 12324, this.f5256c) ? this.f5256c[0] : 0;
                    int i12 = egl10.eglGetConfigAttrib(eGLDisplay, eGLConfig, 12323, this.f5256c) ? this.f5256c[0] : 0;
                    int i13 = egl10.eglGetConfigAttrib(eGLDisplay, eGLConfig, 12322, this.f5256c) ? this.f5256c[0] : 0;
                    int i14 = egl10.eglGetConfigAttrib(eGLDisplay, eGLConfig, 12321, this.f5256c) ? this.f5256c[0] : 0;
                    if (i11 == this.f5257d && i12 == this.e && i13 == this.f5258f && i14 == this.f5259g) {
                        return eGLConfig;
                    }
                }
            }
            return null;
        }
    }

    public class d implements g {
        private d() {
        }

        @Override // com.amap.api.col.3sl.x0.g
        public EGLContext createContext(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig) {
            x0.this.getClass();
            x0.this.getClass();
            return egl10.eglCreateContext(eGLDisplay, eGLConfig, EGL10.EGL_NO_CONTEXT, null);
        }

        @Override // com.amap.api.col.3sl.x0.g
        public void destroyContext(EGL10 egl10, EGLDisplay eGLDisplay, EGLContext eGLContext) {
            if (egl10.eglDestroyContext(eGLDisplay, eGLContext)) {
                return;
            }
            Log.e("DefaultContextFactory", "display:" + eGLDisplay + " context: " + eGLContext);
            throw new RuntimeException(l0.j(egl10.eglGetError(), "eglDestroyContex failed: "));
        }
    }

    public static class e implements h {
        private e() {
        }
    }

    public interface f {
        EGLConfig chooseConfig(EGL10 egl10, EGLDisplay eGLDisplay);
    }

    public interface g {
        EGLContext createContext(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig);

        void destroyContext(EGL10 egl10, EGLDisplay eGLDisplay, EGLContext eGLContext);
    }

    public interface h {
    }

    public static class i {

        /* renamed from: a, reason: collision with root package name */
        private WeakReference<x0> f5264a;

        /* renamed from: b, reason: collision with root package name */
        EGL10 f5265b;

        /* renamed from: c, reason: collision with root package name */
        EGLDisplay f5266c;

        /* renamed from: d, reason: collision with root package name */
        EGLSurface f5267d;
        EGLConfig e;

        /* renamed from: f, reason: collision with root package name */
        EGLContext f5268f;

        public i(WeakReference<x0> weakReference) {
            this.f5264a = weakReference;
        }

        private void d() {
            EGLSurface eGLSurface;
            EGLSurface eGLSurface2 = this.f5267d;
            if (eGLSurface2 == null || eGLSurface2 == (eGLSurface = EGL10.EGL_NO_SURFACE)) {
                return;
            }
            this.f5265b.eglMakeCurrent(this.f5266c, eGLSurface, eGLSurface, EGL10.EGL_NO_CONTEXT);
            x0 x0Var = this.f5264a.get();
            if (x0Var != null) {
                h hVar = x0Var.f5253g;
                EGL10 egl10 = this.f5265b;
                EGLDisplay eGLDisplay = this.f5266c;
                EGLSurface eGLSurface3 = this.f5267d;
                ((e) hVar).getClass();
                egl10.eglDestroySurface(eGLDisplay, eGLSurface3);
            }
            this.f5267d = null;
        }

        public GL a() {
            GL gl = this.f5268f.getGL();
            if (this.f5264a.get() != null) {
                int i3 = x0.f5247i;
            }
            return gl;
        }

        public boolean b() {
            if (this.f5265b == null) {
                throw new RuntimeException("egl not initialized");
            }
            if (this.f5266c == null) {
                throw new RuntimeException("eglDisplay not initialized");
            }
            if (this.e == null) {
                throw new RuntimeException("mEglConfig not initialized");
            }
            d();
            x0 x0Var = this.f5264a.get();
            EGLSurface eGLSurface = null;
            if (x0Var != null) {
                h hVar = x0Var.f5253g;
                EGL10 egl10 = this.f5265b;
                EGLDisplay eGLDisplay = this.f5266c;
                EGLConfig eGLConfig = this.e;
                SurfaceTexture surfaceTexture = x0Var.getSurfaceTexture();
                ((e) hVar).getClass();
                try {
                    eGLSurface = egl10.eglCreateWindowSurface(eGLDisplay, eGLConfig, surfaceTexture, null);
                } catch (IllegalArgumentException e) {
                    Log.e("GLSurfaceView", "eglCreateWindowSurface", e);
                }
                this.f5267d = eGLSurface;
            } else {
                this.f5267d = null;
            }
            EGLSurface eGLSurface2 = this.f5267d;
            if (eGLSurface2 == null || eGLSurface2 == EGL10.EGL_NO_SURFACE) {
                if (this.f5265b.eglGetError() == 12299) {
                    Log.e("EglHelper", "createWindowSurface returned EGL_BAD_NATIVE_WINDOW.");
                }
                return false;
            }
            if (this.f5265b.eglMakeCurrent(this.f5266c, eGLSurface2, eGLSurface2, this.f5268f)) {
                return true;
            }
            Log.w("EGLHelper", "eglMakeCurrent failed: " + this.f5265b.eglGetError());
            return false;
        }

        public void c() {
            d();
        }

        public void e() {
            if (this.f5268f != null) {
                x0 x0Var = this.f5264a.get();
                if (x0Var != null) {
                    x0Var.f5252f.destroyContext(this.f5265b, this.f5266c, this.f5268f);
                }
                this.f5268f = null;
            }
            EGLDisplay eGLDisplay = this.f5266c;
            if (eGLDisplay != null) {
                this.f5265b.eglTerminate(eGLDisplay);
                this.f5266c = null;
            }
        }

        public void f() {
            EGL10 egl10 = (EGL10) EGLContext.getEGL();
            this.f5265b = egl10;
            EGLDisplay eglGetDisplay = egl10.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
            this.f5266c = eglGetDisplay;
            if (eglGetDisplay == EGL10.EGL_NO_DISPLAY) {
                throw new RuntimeException("eglGetDisplay failed");
            }
            if (!this.f5265b.eglInitialize(eglGetDisplay, new int[2])) {
                throw new RuntimeException("eglInitialize failed");
            }
            x0 x0Var = this.f5264a.get();
            if (x0Var == null) {
                this.e = null;
                this.f5268f = null;
            } else {
                this.e = x0Var.e.chooseConfig(this.f5265b, this.f5266c);
                this.f5268f = x0Var.f5252f.createContext(this.f5265b, this.f5266c, this.e);
            }
            EGLContext eGLContext = this.f5268f;
            if (eGLContext == null || eGLContext == EGL10.EGL_NO_CONTEXT) {
                this.f5268f = null;
                throw new RuntimeException(l0.j(this.f5265b.eglGetError(), "createContext failed: "));
            }
            this.f5267d = null;
        }
    }

    public static class j extends Thread {

        /* renamed from: a, reason: collision with root package name */
        private boolean f5269a;

        /* renamed from: b, reason: collision with root package name */
        private boolean f5270b;

        /* renamed from: c, reason: collision with root package name */
        private boolean f5271c;

        /* renamed from: d, reason: collision with root package name */
        private boolean f5272d;
        private boolean e;

        /* renamed from: f, reason: collision with root package name */
        private boolean f5273f;

        /* renamed from: g, reason: collision with root package name */
        private boolean f5274g;

        /* renamed from: h, reason: collision with root package name */
        private boolean f5275h;

        /* renamed from: i, reason: collision with root package name */
        private boolean f5276i;

        /* renamed from: j, reason: collision with root package name */
        private boolean f5277j;

        /* renamed from: k, reason: collision with root package name */
        private boolean f5278k;

        /* renamed from: p, reason: collision with root package name */
        private boolean f5283p;

        /* renamed from: s, reason: collision with root package name */
        private i f5285s;

        /* renamed from: t, reason: collision with root package name */
        private WeakReference<x0> f5286t;

        /* renamed from: q, reason: collision with root package name */
        private ArrayList<Runnable> f5284q = new ArrayList<>();
        private boolean r = true;

        /* renamed from: l, reason: collision with root package name */
        private int f5279l = 0;

        /* renamed from: m, reason: collision with root package name */
        private int f5280m = 0;

        /* renamed from: o, reason: collision with root package name */
        private boolean f5282o = true;

        /* renamed from: n, reason: collision with root package name */
        private int f5281n = 1;

        public j(WeakReference<x0> weakReference) {
            this.f5286t = weakReference;
        }

        /* JADX WARN: Removed duplicated region for block: B:119:0x0224  */
        /* JADX WARN: Removed duplicated region for block: B:176:0x0239 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        private void d() throws java.lang.InterruptedException {
            /*
                Method dump skipped, instructions count: 580
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.3sl.x0.j.d():void");
        }

        private boolean g() {
            if (this.f5272d || !this.e || this.f5273f || this.f5279l <= 0 || this.f5280m <= 0) {
                return false;
            }
            return this.f5282o || this.f5281n == 1;
        }

        private void k() {
            if (this.f5275h) {
                this.f5285s.e();
                this.f5275h = false;
                x0.f5246h.a(this);
            }
        }

        private void l() {
            if (this.f5276i) {
                this.f5276i = false;
                this.f5285s.c();
            }
        }

        public int b() {
            int i3;
            synchronized (x0.f5246h) {
                i3 = this.f5281n;
            }
            return i3;
        }

        public int c() {
            int i3;
            synchronized (x0.f5246h) {
                i3 = this.f5279l;
            }
            return i3;
        }

        public void e() {
            synchronized (x0.f5246h) {
                try {
                    this.f5271c = true;
                    x0.f5246h.notifyAll();
                    while (!this.f5270b && !this.f5272d) {
                        try {
                            if (MapsInitializer.getTextureViewDestorySync()) {
                                x0.f5246h.wait();
                            } else {
                                x0.f5246h.wait(2000L);
                            }
                        } catch (InterruptedException unused) {
                            Thread.currentThread().interrupt();
                        }
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }

        public void f() {
            synchronized (x0.f5246h) {
                this.f5271c = false;
                this.f5282o = true;
                this.f5283p = false;
                x0.f5246h.notifyAll();
                while (!this.f5270b && this.f5272d && !this.f5283p) {
                    try {
                        x0.f5246h.wait();
                    } catch (InterruptedException unused) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void h() {
            synchronized (x0.f5246h) {
                this.f5269a = true;
                x0.f5246h.notifyAll();
                while (!this.f5270b) {
                    try {
                        x0.f5246h.wait();
                    } catch (InterruptedException unused) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void i() {
            this.f5278k = true;
            x0.f5246h.notifyAll();
        }

        public void j() {
            synchronized (x0.f5246h) {
                this.f5282o = true;
                x0.f5246h.notifyAll();
            }
        }

        public void m() {
            synchronized (x0.f5246h) {
                this.e = true;
                this.f5277j = false;
                x0.f5246h.notifyAll();
                while (this.f5274g && !this.f5277j && !this.f5270b) {
                    try {
                        x0.f5246h.wait();
                    } catch (InterruptedException unused) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void n() {
            synchronized (x0.f5246h) {
                try {
                    this.e = false;
                    x0.f5246h.notifyAll();
                    while (!this.f5274g && !this.f5270b) {
                        try {
                            if (MapsInitializer.getTextureViewDestorySync()) {
                                x0.f5246h.wait();
                            } else {
                                x0.f5246h.wait(2000L);
                            }
                        } catch (InterruptedException unused) {
                            Thread.currentThread().interrupt();
                        }
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            setName("GLThread " + getId());
            try {
                d();
            } catch (InterruptedException unused) {
            } catch (Throwable th2) {
                x0.f5246h.b(this);
                throw th2;
            }
            x0.f5246h.b(this);
        }

        public void a(int i3) {
            if (i3 < 0 || i3 > 1) {
                throw new IllegalArgumentException("renderMode");
            }
            synchronized (x0.f5246h) {
                this.f5281n = i3;
                x0.f5246h.notifyAll();
            }
        }

        public void a(int i3, int i10) {
            synchronized (x0.f5246h) {
                this.f5279l = i3;
                this.f5280m = i10;
                this.r = true;
                this.f5282o = true;
                this.f5283p = false;
                x0.f5246h.notifyAll();
                while (!this.f5270b && !this.f5272d && !this.f5283p && this.f5275h && this.f5276i && g()) {
                    try {
                        x0.f5246h.wait();
                    } catch (InterruptedException unused) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void a(Runnable runnable) {
            if (runnable != null) {
                synchronized (x0.f5246h) {
                    this.f5284q.add(runnable);
                    x0.f5246h.notifyAll();
                }
                return;
            }
            throw new IllegalArgumentException("r must not be null");
        }

        public int a() {
            int i3;
            synchronized (x0.f5246h) {
                i3 = this.f5280m;
            }
            return i3;
        }
    }

    public class l extends c {
        public l(boolean z5) {
            super(8, 8, 8, 0, z5 ? 16 : 0, 0);
        }
    }

    public x0(Context context, AttributeSet attributeSet) {
        super(context, null);
        this.f5248a = new WeakReference<>(this);
        c();
    }

    public void e() {
        this.f5249b.f();
    }

    public void finalize() throws Throwable {
        try {
            j jVar = this.f5249b;
            if (jVar != null) {
                jVar.h();
            }
        } finally {
            super.finalize();
        }
    }

    public int getRenderMode() {
        return this.f5249b.b();
    }

    @Override // android.view.TextureView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.f5251d && this.f5250c != null) {
            j jVar = this.f5249b;
            int b3 = jVar != null ? jVar.b() : 1;
            j jVar2 = new j(this.f5248a);
            this.f5249b = jVar2;
            if (b3 != 1) {
                jVar2.a(b3);
            }
            this.f5249b.start();
        }
        this.f5251d = false;
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        j jVar = this.f5249b;
        if (jVar != null) {
            jVar.h();
        }
        this.f5251d = true;
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    public void onLayout(boolean z5, int i3, int i10, int i11, int i12) {
        getSurfaceTexture();
        this.f5249b.a(i11 - i3, i12 - i10);
        super.onLayout(z5, i3, i10, i11, i12);
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i3, int i10) {
        this.f5249b.m();
        if (MapsInitializer.getTextureSizeChangedInvoked()) {
            this.f5249b.a(i3, i10);
        } else {
            if (this.f5249b.c() == i3 && this.f5249b.a() == i10) {
                return;
            }
            this.f5249b.a(i3, i10);
        }
    }

    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        this.f5249b.n();
        return true;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i3, int i10) {
        this.f5249b.a(i3, i10);
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
    }

    public void queueEvent(Runnable runnable) {
        this.f5249b.a(runnable);
    }

    public void requestRender() {
        this.f5249b.j();
    }

    public void setRenderMode(int i3) {
        this.f5249b.a(i3);
    }

    public void setRenderer(GLSurfaceView.Renderer renderer) {
        b();
        if (this.e == null) {
            this.e = new l(true);
        }
        if (this.f5252f == null) {
            this.f5252f = new d();
        }
        if (this.f5253g == null) {
            this.f5253g = new e();
        }
        this.f5250c = renderer;
        j jVar = new j(this.f5248a);
        this.f5249b = jVar;
        jVar.start();
    }

    private void b() {
        if (this.f5249b != null) {
            throw new IllegalStateException("setRenderer has already been called for this instance.");
        }
    }

    private void c() {
        setSurfaceTextureListener(this);
    }

    public void d() {
        this.f5249b.e();
    }

    public static class k {

        /* renamed from: a, reason: collision with root package name */
        private boolean f5287a;

        /* renamed from: b, reason: collision with root package name */
        private int f5288b;

        /* renamed from: c, reason: collision with root package name */
        private boolean f5289c;

        /* renamed from: d, reason: collision with root package name */
        private boolean f5290d;
        private boolean e;

        /* renamed from: f, reason: collision with root package name */
        private j f5291f;

        private k() {
        }

        public void a(j jVar) {
            if (this.f5291f == jVar) {
                this.f5291f = null;
            }
            notifyAll();
        }

        public synchronized void b(j jVar) {
            try {
                jVar.f5270b = true;
                if (this.f5291f == jVar) {
                    this.f5291f = null;
                }
                notifyAll();
            } catch (Throwable th2) {
                throw th2;
            }
        }

        public boolean c(j jVar) {
            j jVar2 = this.f5291f;
            if (jVar2 == jVar || jVar2 == null) {
                this.f5291f = jVar;
                notifyAll();
                return true;
            }
            a();
            if (this.f5290d) {
                return true;
            }
            j jVar3 = this.f5291f;
            if (jVar3 == null) {
                return false;
            }
            jVar3.i();
            return false;
        }

        public synchronized void a(GL10 gl10) {
            try {
                if (!this.f5289c && gl10 != null) {
                    a();
                    String glGetString = gl10.glGetString(7937);
                    if (this.f5288b < 131072) {
                        this.f5290d = !glGetString.startsWith("Q3Dimension MSM7500 ");
                        notifyAll();
                    }
                    this.e = !this.f5290d;
                    this.f5289c = true;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }

        public synchronized boolean b() {
            a();
            return !this.f5290d;
        }

        private void a() {
            if (this.f5287a) {
                return;
            }
            this.f5288b = WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT;
            this.f5290d = true;
            this.f5287a = true;
        }
    }

    public void a(g gVar) {
        b();
        this.f5252f = gVar;
    }

    public void a(f fVar) {
        b();
        this.e = fVar;
    }
}
