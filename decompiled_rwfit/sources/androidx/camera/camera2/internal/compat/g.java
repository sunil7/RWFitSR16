package androidx.camera.camera2.internal.compat;

import android.hardware.camera2.CameraCaptureSession;

/* loaded from: classes.dex */
public final /* synthetic */ class g implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1166a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ i f1167b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ CameraCaptureSession f1168c;

    public /* synthetic */ g(i iVar, CameraCaptureSession cameraCaptureSession, int i3) {
        this.f1166a = i3;
        this.f1167b = iVar;
        this.f1168c = cameraCaptureSession;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f1166a) {
            case 0:
                ((CameraCaptureSession.StateCallback) this.f1167b.f1174b).onActive(this.f1168c);
                break;
            case 1:
                ((CameraCaptureSession.StateCallback) this.f1167b.f1174b).onClosed(this.f1168c);
                break;
            case 2:
                ((CameraCaptureSession.StateCallback) this.f1167b.f1174b).onCaptureQueueEmpty(this.f1168c);
                break;
            case 3:
                ((CameraCaptureSession.StateCallback) this.f1167b.f1174b).onConfigured(this.f1168c);
                break;
            case 4:
                ((CameraCaptureSession.StateCallback) this.f1167b.f1174b).onReady(this.f1168c);
                break;
            default:
                ((CameraCaptureSession.StateCallback) this.f1167b.f1174b).onConfigureFailed(this.f1168c);
                break;
        }
    }
}
