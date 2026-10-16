package uf;

import android.hardware.Camera;
import androidx.camera.core.impl.y0;
import com.otaliastudios.cameraview.engine.offset.Reference;

/* loaded from: classes2.dex */
public final class h implements Camera.PreviewCallback {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ i f19080a;

    public h(i iVar) {
        this.f19080a = iVar;
    }

    @Override // android.hardware.Camera.PreviewCallback
    public final void onPreviewFrame(byte[] bArr, Camera camera) {
        i iVar = this.f19080a;
        iVar.m(false);
        y0 y0Var = (y0) iVar.f194a;
        int i3 = y0Var.f1525b;
        wf.b bVar = (wf.b) y0Var.f1527d;
        wf.b j4 = iVar.e.j(Reference.SENSOR);
        if (j4 == null) {
            throw new IllegalStateException("Preview stream size should never be null here.");
        }
        qf.i.a("FallbackCameraThread").f17956c.post(new a2.b(this, bArr, j4, i3, bVar, 2));
        camera.setPreviewCallbackWithBuffer(null);
        camera.setPreviewCallbackWithBuffer(iVar.e);
        ((pf.a) iVar.e.g()).d(iVar.f19083h, j4, iVar.e.B);
    }
}
