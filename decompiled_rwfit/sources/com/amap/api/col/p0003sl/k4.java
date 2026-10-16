package com.amap.api.col.p0003sl;

import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;

/* loaded from: classes.dex */
public class k4 extends h4 {
    @Override // android.opengl.GLSurfaceView.EGLContextFactory, com.amap.api.col.3sl.x0.g
    public EGLContext createContext(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig) {
        try {
            return egl10.eglCreateContext(eGLDisplay, eGLConfig, EGL10.EGL_NO_CONTEXT, new int[]{12440, 2, 12344});
        } catch (Throwable th2) {
            th2.printStackTrace();
            return null;
        }
    }

    @Override // android.opengl.GLSurfaceView.EGLContextFactory, com.amap.api.col.3sl.x0.g
    public void destroyContext(EGL10 egl10, EGLDisplay eGLDisplay, EGLContext eGLContext) {
        egl10.eglDestroyContext(eGLDisplay, eGLContext);
    }
}
