package uf;

import android.hardware.Camera;
import androidx.camera.core.impl.y0;

/* loaded from: classes2.dex */
public final class c extends f {
    public final Camera e;

    /* renamed from: f, reason: collision with root package name */
    public final ff.e f19073f;

    public c(y0 y0Var, ff.e eVar, Camera camera) {
        super(y0Var, eVar);
        this.f19073f = eVar;
        this.e = camera;
        Camera.Parameters parameters = camera.getParameters();
        parameters.setRotation(((y0) this.f194a).f1525b);
        camera.setParameters(parameters);
    }

    @Override // ab.n
    public final void n() {
        f.f19079d.b(1, "dispatching result. Thread:", Thread.currentThread());
        super.n();
    }

    @Override // ab.n
    public final void u() {
        ef.b bVar = f.f19079d;
        bVar.b(1, "take() called.");
        Camera camera = this.e;
        camera.setPreviewCallbackWithBuffer(null);
        ((pf.a) this.f19073f.g()).c();
        try {
            camera.takePicture(new a(this), null, null, new b(this));
            bVar.b(1, "take() returned.");
        } catch (Exception e) {
            this.f196c = e;
            n();
        }
    }
}
