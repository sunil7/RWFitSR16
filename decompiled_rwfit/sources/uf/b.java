package uf;

import android.hardware.Camera;
import androidx.camera.core.impl.y0;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import com.otaliastudios.cameraview.engine.offset.Reference;
import com.otaliastudios.cameraview.engine.orchestrator.CameraState;
import java.io.ByteArrayInputStream;
import java.io.IOException;

/* loaded from: classes2.dex */
public final class b implements Camera.PictureCallback {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ c f19072a;

    public b(c cVar) {
        this.f19072a = cVar;
    }

    @Override // android.hardware.Camera.PictureCallback
    public final void onPictureTaken(byte[] bArr, Camera camera) {
        f.f19079d.b(1, "take(): got picture callback.");
        int i3 = 0;
        try {
            switch (new u1.g(new ByteArrayInputStream(bArr)).c(1, "Orientation")) {
                case 3:
                case 4:
                    i3 = 180;
                    break;
                case 5:
                case 6:
                    i3 = 90;
                    break;
                case 7:
                case 8:
                    i3 = SubsamplingScaleImageView.ORIENTATION_270;
                    break;
            }
        } catch (IOException unused) {
        }
        c cVar = this.f19072a;
        y0 y0Var = (y0) cVar.f194a;
        y0Var.e = bArr;
        y0Var.f1525b = i3;
        f.f19079d.b(1, "take(): starting preview again. ", Thread.currentThread());
        ff.e eVar = cVar.f19073f;
        if (eVar.f13648d.e.isAtLeast(CameraState.PREVIEW)) {
            camera.setPreviewCallbackWithBuffer(eVar);
            wf.b j4 = eVar.j(Reference.SENSOR);
            if (j4 == null) {
                throw new IllegalStateException("Preview stream size should never be null here.");
            }
            ((pf.a) eVar.g()).d(eVar.f13654k, j4, eVar.B);
            camera.startPreview();
        }
        cVar.n();
    }
}
