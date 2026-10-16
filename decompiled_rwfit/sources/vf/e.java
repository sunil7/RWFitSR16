package vf;

import android.graphics.SurfaceTexture;
import android.opengl.EGL14;
import android.opengl.GLSurfaceView;
import android.opengl.Matrix;
import java.util.Iterator;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;
import uf.m;
import uf.n;
import uf.o;

/* loaded from: classes2.dex */
public final class e implements GLSurfaceView.Renderer {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ f f19247a;

    public e(f fVar) {
        this.f19247a = fVar;
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public final void onDrawFrame(GL10 gl10) {
        f fVar = this.f19247a;
        SurfaceTexture surfaceTexture = fVar.f19249k;
        if (surfaceTexture != null && fVar.f19240f > 0 && fVar.f19241g > 0) {
            float[] fArr = fVar.f19250l.f17941b;
            surfaceTexture.updateTexImage();
            fVar.f19249k.getTransformMatrix(fArr);
            if (fVar.f19242h != 0) {
                Matrix.translateM(fArr, 0, 0.5f, 0.5f, 0.0f);
                Matrix.rotateM(fArr, 0, fVar.f19242h, 0.0f, 0.0f, 1.0f);
                Matrix.translateM(fArr, 0, -0.5f, -0.5f, 0.0f);
            }
            if (fVar.f19238c) {
                Matrix.translateM(fArr, 0, (1.0f - fVar.f19252n) / 2.0f, (1.0f - fVar.f19253o) / 2.0f, 0.0f);
                Matrix.scaleM(fArr, 0, fVar.f19252n, fVar.f19253o, 1.0f);
            }
            qf.d dVar = fVar.f19250l;
            fVar.f19249k.getTimestamp();
            dVar.a();
            Iterator it = fVar.f19251m.iterator();
            while (it.hasNext()) {
                m mVar = (m) it.next();
                SurfaceTexture surfaceTexture2 = fVar.f19249k;
                int i3 = fVar.f19242h;
                float f2 = fVar.f19252n;
                float f10 = fVar.f19253o;
                o oVar = mVar.f19090a;
                ((f) oVar.e).f19251m.remove(mVar);
                qf.i.a("FallbackCameraThread").f17956c.post(new n(oVar, surfaceTexture2, i3, f2, f10, EGL14.eglGetCurrentContext()));
            }
        }
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public final void onSurfaceChanged(GL10 gl10, int i3, int i10) {
        gl10.glViewport(0, 0, i3, i10);
        f fVar = this.f19247a;
        of.b bVar = (of.b) fVar.f19255q;
        bVar.getClass();
        bVar.f16926c = new wf.b(i3, i10);
        if (!fVar.f19248j) {
            fVar.b(i3, i10);
            fVar.f19248j = true;
        } else {
            if (i3 == fVar.f19239d && i10 == fVar.e) {
                return;
            }
            fVar.c(i3, i10);
        }
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public final void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) {
        f fVar = this.f19247a;
        if (fVar.f19255q == null) {
            fVar.f19255q = new of.b();
        }
        qf.d dVar = new qf.d();
        fVar.f19250l = dVar;
        dVar.f17943d = fVar.f19255q;
        int i3 = dVar.f17940a.f11633a;
        fVar.f19249k = new SurfaceTexture(i3);
        ((GLSurfaceView) fVar.f19237b).queueEvent(new androidx.emoji2.text.i(i3, 7, this));
        fVar.f19249k.setOnFrameAvailableListener(new d(this));
    }
}
