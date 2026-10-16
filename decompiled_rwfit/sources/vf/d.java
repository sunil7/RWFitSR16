package vf;

import android.graphics.SurfaceTexture;
import android.opengl.GLSurfaceView;

/* loaded from: classes2.dex */
public final class d implements SurfaceTexture.OnFrameAvailableListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ e f19246a;

    public d(e eVar) {
        this.f19246a = eVar;
    }

    @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
    public final void onFrameAvailable(SurfaceTexture surfaceTexture) {
        ((GLSurfaceView) this.f19246a.f19247a.f19237b).requestRender();
    }
}
