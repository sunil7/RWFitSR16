package vf;

import android.opengl.GLSurfaceView;
import android.view.SurfaceHolder;
import ff.q;
import pe.o;

/* loaded from: classes2.dex */
public final class c implements SurfaceHolder.Callback {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ GLSurfaceView f19243a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ e f19244b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ f f19245c;

    public c(f fVar, GLSurfaceView gLSurfaceView, e eVar) {
        this.f19245c = fVar;
        this.f19243a = gLSurfaceView;
        this.f19244b = eVar;
    }

    @Override // android.view.SurfaceHolder.Callback
    public final void surfaceChanged(SurfaceHolder surfaceHolder, int i3, int i10, int i11) {
    }

    @Override // android.view.SurfaceHolder.Callback
    public final void surfaceCreated(SurfaceHolder surfaceHolder) {
    }

    @Override // android.view.SurfaceHolder.Callback
    public final void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        f fVar = this.f19245c;
        fVar.f19239d = 0;
        fVar.e = 0;
        q qVar = fVar.f19236a;
        if (qVar != null) {
            q.T.b(1, "onSurfaceDestroyed");
            qVar.R(false);
            qVar.Q(false);
        }
        this.f19243a.queueEvent(new o(this, 8));
        fVar.f19248j = false;
    }
}
