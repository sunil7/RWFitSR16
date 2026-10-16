package com.amap.api.col.p0003sl;

import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLDisplay;

/* loaded from: classes.dex */
public class j4 extends g4 {

    /* renamed from: a, reason: collision with root package name */
    protected int f4314a;

    /* renamed from: b, reason: collision with root package name */
    protected int f4315b;

    /* renamed from: c, reason: collision with root package name */
    protected int f4316c;

    /* renamed from: d, reason: collision with root package name */
    protected int f4317d;
    protected int e;

    /* renamed from: f, reason: collision with root package name */
    protected int f4318f;

    /* renamed from: g, reason: collision with root package name */
    private int[] f4319g = new int[1];

    public j4(int i3, int i10, int i11, int i12, int i13, int i14) {
        this.f4314a = i3;
        this.f4315b = i10;
        this.f4316c = i11;
        this.f4317d = i12;
        this.e = i13;
        this.f4318f = i14;
    }

    private int[] a(int i3, boolean z5) {
        return i3 == 2 ? new int[]{12324, this.f4314a, 12323, this.f4315b, 12322, this.f4316c, 12321, this.f4317d, 12325, this.e, 12326, this.f4318f, 12338, z5 ? 1 : 0, 12352, 4, 12344} : z5 ? new int[]{12324, this.f4314a, 12323, this.f4315b, 12322, this.f4316c, 12338, 1, 12344} : new int[]{12324, this.f4314a, 12323, this.f4315b, 12322, this.f4316c, 12344};
    }

    @Override // android.opengl.GLSurfaceView.EGLConfigChooser, com.amap.api.col.3sl.x0.f
    public EGLConfig chooseConfig(EGL10 egl10, EGLDisplay eGLDisplay) {
        int[] iArr;
        int[] iArr2;
        l4 a3 = a(egl10, eGLDisplay);
        if (a3 == null || (iArr = a3.f4444a) == null) {
            return null;
        }
        int[] iArr3 = a3.f4445b;
        int i3 = iArr3[0];
        EGLConfig[] eGLConfigArr = new EGLConfig[i3];
        egl10.eglChooseConfig(eGLDisplay, iArr, eGLConfigArr, i3, iArr3);
        EGLConfig a10 = a(egl10, eGLDisplay, eGLConfigArr);
        if (a10 != null) {
            return a10;
        }
        this.f4314a = 8;
        this.f4315b = 8;
        this.f4316c = 8;
        l4 a11 = a(egl10, eGLDisplay);
        if (a11 == null || (iArr2 = a11.f4444a) == null) {
            return a10;
        }
        int[] iArr4 = a11.f4445b;
        int i10 = iArr4[0];
        EGLConfig[] eGLConfigArr2 = new EGLConfig[i10];
        egl10.eglChooseConfig(eGLDisplay, iArr2, eGLConfigArr2, i10, iArr4);
        return a(egl10, eGLDisplay, eGLConfigArr2);
    }

    private l4 a(EGL10 egl10, EGLDisplay eGLDisplay) {
        l4 l4Var = new l4();
        int[] a3 = a(2, true);
        l4Var.f4444a = a3;
        egl10.eglChooseConfig(eGLDisplay, a3, null, 0, l4Var.f4445b);
        if (l4Var.f4445b[0] <= 0) {
            int[] a10 = a(2, false);
            l4Var.f4444a = a10;
            egl10.eglChooseConfig(eGLDisplay, a10, null, 0, l4Var.f4445b);
            if (l4Var.f4445b[0] <= 0) {
                return null;
            }
        }
        return l4Var;
    }

    public EGLConfig a(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig[] eGLConfigArr) {
        for (EGLConfig eGLConfig : eGLConfigArr) {
            int i3 = egl10.eglGetConfigAttrib(eGLDisplay, eGLConfig, 12325, this.f4319g) ? this.f4319g[0] : 0;
            int i10 = egl10.eglGetConfigAttrib(eGLDisplay, eGLConfig, 12326, this.f4319g) ? this.f4319g[0] : 0;
            if (i3 >= this.e && i10 >= this.f4318f) {
                int i11 = egl10.eglGetConfigAttrib(eGLDisplay, eGLConfig, 12324, this.f4319g) ? this.f4319g[0] : 0;
                int i12 = egl10.eglGetConfigAttrib(eGLDisplay, eGLConfig, 12323, this.f4319g) ? this.f4319g[0] : 0;
                int i13 = egl10.eglGetConfigAttrib(eGLDisplay, eGLConfig, 12322, this.f4319g) ? this.f4319g[0] : 0;
                int i14 = egl10.eglGetConfigAttrib(eGLDisplay, eGLConfig, 12321, this.f4319g) ? this.f4319g[0] : 0;
                if (i11 == this.f4314a && i12 == this.f4315b && i13 == this.f4316c && i14 == this.f4317d) {
                    return eGLConfig;
                }
            }
        }
        return null;
    }
}
