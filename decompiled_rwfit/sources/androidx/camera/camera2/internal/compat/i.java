package androidx.camera.camera2.internal.compat;

import android.hardware.camera2.CameraCaptureSession;
import android.view.Surface;
import com.otaliastudios.cameraview.CameraException;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public final class i extends CameraCaptureSession.StateCallback {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1173a = 1;

    /* renamed from: b, reason: collision with root package name */
    public final Object f1174b;

    /* renamed from: c, reason: collision with root package name */
    public final Object f1175c;

    public i(Executor executor, CameraCaptureSession.StateCallback stateCallback) {
        this.f1175c = executor;
        this.f1174b = stateCallback;
    }

    @Override // android.hardware.camera2.CameraCaptureSession.StateCallback
    public void onActive(CameraCaptureSession cameraCaptureSession) {
        switch (this.f1173a) {
            case 0:
                ((Executor) this.f1175c).execute(new g(this, cameraCaptureSession, 0));
                break;
            default:
                super.onActive(cameraCaptureSession);
                break;
        }
    }

    @Override // android.hardware.camera2.CameraCaptureSession.StateCallback
    public void onCaptureQueueEmpty(CameraCaptureSession cameraCaptureSession) {
        switch (this.f1173a) {
            case 0:
                ((Executor) this.f1175c).execute(new g(this, cameraCaptureSession, 2));
                break;
            default:
                super.onCaptureQueueEmpty(cameraCaptureSession);
                break;
        }
    }

    @Override // android.hardware.camera2.CameraCaptureSession.StateCallback
    public void onClosed(CameraCaptureSession cameraCaptureSession) {
        switch (this.f1173a) {
            case 0:
                ((Executor) this.f1175c).execute(new g(this, cameraCaptureSession, 1));
                break;
            default:
                super.onClosed(cameraCaptureSession);
                break;
        }
    }

    @Override // android.hardware.camera2.CameraCaptureSession.StateCallback
    public final void onConfigureFailed(CameraCaptureSession cameraCaptureSession) {
        switch (this.f1173a) {
            case 0:
                ((Executor) this.f1175c).execute(new g(this, cameraCaptureSession, 5));
                return;
            default:
                RuntimeException runtimeException = new RuntimeException(ff.q.T.b(3, "onConfigureFailed! Session", cameraCaptureSession));
                ia.g gVar = (ia.g) this.f1174b;
                if (gVar.f14382a.e()) {
                    throw new CameraException(3);
                }
                gVar.b(new CameraException(runtimeException, 2));
                return;
        }
    }

    @Override // android.hardware.camera2.CameraCaptureSession.StateCallback
    public final void onConfigured(CameraCaptureSession cameraCaptureSession) {
        switch (this.f1173a) {
            case 0:
                ((Executor) this.f1175c).execute(new g(this, cameraCaptureSession, 3));
                break;
            default:
                ((ff.n) this.f1175c).Y = cameraCaptureSession;
                ff.q.T.b(1, "onStartBind:", "Completed");
                ((ia.g) this.f1174b).f14382a.j(null);
                break;
        }
    }

    @Override // android.hardware.camera2.CameraCaptureSession.StateCallback
    public final void onReady(CameraCaptureSession cameraCaptureSession) {
        switch (this.f1173a) {
            case 0:
                ((Executor) this.f1175c).execute(new g(this, cameraCaptureSession, 4));
                break;
            default:
                super.onReady(cameraCaptureSession);
                ff.q.T.b(1, "CameraCaptureSession.StateCallback reported onReady.");
                break;
        }
    }

    @Override // android.hardware.camera2.CameraCaptureSession.StateCallback
    public void onSurfacePrepared(CameraCaptureSession cameraCaptureSession, Surface surface) {
        switch (this.f1173a) {
            case 0:
                ((Executor) this.f1175c).execute(new h(this, 0, cameraCaptureSession, surface));
                break;
            default:
                super.onSurfacePrepared(cameraCaptureSession, surface);
                break;
        }
    }

    public i(ff.n nVar, ia.g gVar) {
        this.f1175c = nVar;
        this.f1174b = gVar;
    }
}
