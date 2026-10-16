package androidx.camera.camera2.internal.compat;

import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CaptureRequest;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class j extends ef.i {
    @Override // ef.i
    public final int L(CaptureRequest captureRequest, androidx.camera.core.impl.utils.executor.b bVar, CameraCaptureSession.CaptureCallback captureCallback) {
        return ((CameraCaptureSession) this.f12629b).setSingleRepeatingRequest(captureRequest, bVar, captureCallback);
    }

    @Override // ef.i
    public final int j(ArrayList arrayList, androidx.camera.core.impl.utils.executor.b bVar, CameraCaptureSession.CaptureCallback captureCallback) {
        return ((CameraCaptureSession) this.f12629b).captureBurstRequests(arrayList, bVar, captureCallback);
    }
}
