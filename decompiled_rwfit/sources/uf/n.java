package uf;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.SurfaceTexture;
import android.opengl.EGL14;
import android.opengl.EGLConfig;
import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.opengl.EGLSurface;
import android.opengl.GLES20;
import android.opengl.Matrix;
import android.util.Log;
import android.view.Surface;
import androidx.camera.core.impl.y0;
import com.otaliastudios.cameraview.overlay.Overlay$Target;
import com.otaliastudios.cameraview.overlay.OverlayLayout;
import java.io.ByteArrayOutputStream;
import java.util.Iterator;

/* loaded from: classes2.dex */
public final class n implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ SurfaceTexture f19091a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f19092b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ float f19093c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ float f19094d;
    public final /* synthetic */ EGLContext e;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ o f19095f;

    public n(o oVar, SurfaceTexture surfaceTexture, int i3, float f2, float f10, EGLContext eGLContext) {
        this.f19095f = oVar;
        this.f19091a = surfaceTexture;
        this.f19092b = i3;
        this.f19093c = f2;
        this.f19094d = f10;
        this.e = eGLContext;
    }

    /* JADX WARN: Type inference failed for: r13v7 */
    /* JADX WARN: Type inference failed for: r13v8, types: [android.graphics.SurfaceTexture, android.view.Surface, qf.d] */
    /* JADX WARN: Type inference failed for: r13v9 */
    @Override // java.lang.Runnable
    public final void run() {
        ?? r13;
        zf.a aVar;
        o oVar = this.f19095f;
        SurfaceTexture surfaceTexture = this.f19091a;
        int i3 = this.f19092b;
        float f2 = this.f19093c;
        float f10 = this.f19094d;
        EGLContext eGLContext = this.e;
        oVar.getClass();
        SurfaceTexture surfaceTexture2 = new SurfaceTexture(9999);
        wf.b bVar = (wf.b) ((y0) oVar.f194a).f1527d;
        surfaceTexture2.setDefaultBufferSize(bVar.f19627a, bVar.f19628b);
        n.l lVar = new n.l(14);
        zf.c cVar = zf.d.f20407b;
        lVar.f16245b = cVar;
        zf.b bVar2 = zf.d.f20406a;
        lVar.f16246c = bVar2;
        int i10 = 0;
        EGLDisplay eglGetDisplay = EGL14.eglGetDisplay(0);
        zf.c cVar2 = new zf.c(eglGetDisplay);
        lVar.f16245b = cVar2;
        if (cVar2 == cVar) {
            throw new RuntimeException("unable to get EGL14 display");
        }
        if (!EGL14.eglInitialize(eglGetDisplay, new int[1], 0, new int[1], 0)) {
            throw new RuntimeException("unable to initialize EGL14");
        }
        if (((zf.b) lVar.f16246c) == bVar2) {
            zf.c display = (zf.c) lVar.f16245b;
            kotlin.jvm.internal.e.f(display, "display");
            zf.a[] aVarArr = new zf.a[1];
            EGLConfig[] eGLConfigArr = new EGLConfig[1];
            boolean eglChooseConfig = EGL14.eglChooseConfig(display.f20405a, new int[]{zf.d.f20415k, 8, zf.d.f20416l, 8, zf.d.f20417m, 8, zf.d.f20418n, 8, zf.d.f20419o, zf.d.f20420p | zf.d.f20421q, zf.d.r, zf.d.f20414j, 12610, 1, zf.d.e}, 0, eGLConfigArr, 0, 1, new int[1], 0);
            if (eglChooseConfig) {
                Iterator it = new th.c(0, 0, 1).iterator();
                while (((th.b) it).f18638c) {
                    int a3 = ((th.b) it).a();
                    EGLConfig eGLConfig = eGLConfigArr[a3];
                    int i11 = i10;
                    aVarArr[a3] = eGLConfig == null ? null : new zf.a(eGLConfig);
                    i10 = i11;
                }
            }
            int i12 = i10;
            if (eglChooseConfig) {
                aVar = aVarArr[i12];
            } else {
                Log.w("EglConfigChooser", "Unable to find RGB8888 / 2 EGLConfig");
                aVar = null;
            }
            if (aVar == null) {
                throw new RuntimeException("Unable to find a suitable EGLConfig");
            }
            zf.b bVar3 = new zf.b(EGL14.eglCreateContext(((zf.c) lVar.f16245b).f20405a, aVar.f20403a, eGLContext, new int[]{zf.d.f20413i, 2, zf.d.e}, i12));
            xf.a.a("eglCreateContext (2)");
            lVar.f16247d = aVar;
            lVar.f16246c = bVar3;
        }
        int[] iArr = {zf.d.e};
        zf.c cVar3 = (zf.c) lVar.f16245b;
        zf.a aVar2 = (zf.a) lVar.f16247d;
        kotlin.jvm.internal.e.c(aVar2);
        EGLSurface eglCreateWindowSurface = EGL14.eglCreateWindowSurface(cVar3.f20405a, aVar2.f20403a, surfaceTexture2, iArr, 0);
        zf.e eVar = new zf.e(eglCreateWindowSurface);
        xf.a.a("eglCreateWindowSurface");
        if (eVar == zf.d.f20408c) {
            throw new RuntimeException("surface was null");
        }
        bg.a aVar3 = new bg.a();
        aVar3.f3258a = lVar;
        aVar3.f3259b = eVar;
        aVar3.f3260c = -1;
        aVar3.f3261d = -1;
        if (((zf.c) lVar.f16245b) == cVar) {
            Log.v("EglCore", "NOTE: makeSurfaceCurrent w/o display");
        }
        if (!EGL14.eglMakeCurrent(((zf.c) lVar.f16245b).f20405a, eglCreateWindowSurface, eglCreateWindowSurface, ((zf.b) lVar.f16246c).f20404a)) {
            throw new RuntimeException("eglMakeCurrent failed");
        }
        float[] fArr = oVar.f19100j.f17941b;
        surfaceTexture.getTransformMatrix(fArr);
        Matrix.translateM(fArr, 0, (1.0f - f2) / 2.0f, (1.0f - f10) / 2.0f, 0.0f);
        Matrix.scaleM(fArr, 0, f2, f10, 1.0f);
        Matrix.translateM(fArr, 0, 0.5f, 0.5f, 0.0f);
        Matrix.rotateM(fArr, 0, i3 + ((y0) oVar.f194a).f1525b, 0.0f, 0.0f, 1.0f);
        Matrix.scaleM(fArr, 0, 1.0f, -1.0f, 1.0f);
        Matrix.translateM(fArr, 0, -0.5f, -0.5f, 0.0f);
        if (oVar.f19098h) {
            tf.b bVar4 = oVar.f19099i;
            Overlay$Target overlay$Target = Overlay$Target.PICTURE_SNAPSHOT;
            bVar4.getClass();
            try {
                Canvas lockHardwareCanvas = bVar4.f18619a.getHardwareCanvasEnabled() ? bVar4.f18621c.lockHardwareCanvas() : bVar4.f18621c.lockCanvas(null);
                lockHardwareCanvas.drawColor(0, PorterDuff.Mode.CLEAR);
                ((OverlayLayout) bVar4.f18619a).a(overlay$Target, lockHardwareCanvas);
                bVar4.f18621c.unlockCanvasAndPost(lockHardwareCanvas);
            } catch (Surface.OutOfResourcesException e) {
                tf.b.f18618g.b(2, "Got Surface.OutOfResourcesException while drawing video overlays", e);
            }
            synchronized (bVar4.f18623f) {
                GLES20.glBindTexture(36197, bVar4.e.f16720b);
                bVar4.f18620b.updateTexImage();
            }
            bVar4.f18620b.getTransformMatrix(bVar4.f18622d.f17941b);
            Matrix.translateM(oVar.f19099i.f18622d.f17941b, 0, 0.5f, 0.5f, 0.0f);
            Matrix.rotateM(oVar.f19099i.f18622d.f17941b, 0, ((y0) oVar.f194a).f1525b, 0.0f, 0.0f, 1.0f);
            Matrix.scaleM(oVar.f19099i.f18622d.f17941b, 0, 1.0f, -1.0f, 1.0f);
            Matrix.translateM(oVar.f19099i.f18622d.f17941b, 0, -0.5f, -0.5f, 0.0f);
        }
        ((y0) oVar.f194a).f1525b = 0;
        p.f19101d.b(1, "takeFrame:", "timestampUs:", Long.valueOf(surfaceTexture.getTimestamp() / 1000));
        oVar.f19100j.a();
        if (oVar.f19098h) {
            tf.b bVar5 = oVar.f19099i;
            bVar5.getClass();
            GLES20.glDisable(2884);
            GLES20.glDisable(2929);
            GLES20.glEnable(3042);
            GLES20.glBlendFunc(770, 771);
            synchronized (bVar5.f18623f) {
                bVar5.f18622d.a();
            }
        }
        y0 y0Var = (y0) oVar.f194a;
        Bitmap.CompressFormat format = Bitmap.CompressFormat.JPEG;
        kotlin.jvm.internal.e.f(format, "format");
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            aVar3.a(byteArrayOutputStream);
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            kotlin.jvm.internal.e.e(byteArray, "it.toByteArray()");
            byteArrayOutputStream.close();
            y0Var.e = byteArray;
            zf.e eglSurface = aVar3.f3259b;
            n.l lVar2 = aVar3.f3258a;
            lVar2.getClass();
            kotlin.jvm.internal.e.f(eglSurface, "eglSurface");
            EGL14.eglDestroySurface(((zf.c) lVar2.f16245b).f20405a, eglSurface.f20422a);
            aVar3.f3259b = zf.d.f20408c;
            aVar3.f3261d = -1;
            aVar3.f3260c = -1;
            oVar.f19100j.b();
            surfaceTexture2.release();
            if (oVar.f19098h) {
                tf.b bVar6 = oVar.f19099i;
                if (bVar6.e != null) {
                    GLES20.glBindTexture(36197, 0);
                    r13 = 0;
                    bVar6.e = null;
                } else {
                    r13 = 0;
                }
                SurfaceTexture surfaceTexture3 = bVar6.f18620b;
                if (surfaceTexture3 != null) {
                    surfaceTexture3.release();
                    bVar6.f18620b = r13;
                }
                Surface surface = bVar6.f18621c;
                if (surface != null) {
                    surface.release();
                    bVar6.f18621c = r13;
                }
                qf.d dVar = bVar6.f18622d;
                if (dVar != null) {
                    dVar.b();
                    bVar6.f18622d = r13;
                }
            }
            lVar.p();
            oVar.n();
        } finally {
        }
    }
}
