package androidx.camera.camera2.internal.compat;

import android.hardware.camera2.CameraDevice;

/* loaded from: classes.dex */
public final /* synthetic */ class o implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1181a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ p f1182b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ CameraDevice f1183c;

    public /* synthetic */ o(p pVar, CameraDevice cameraDevice, int i3) {
        this.f1181a = i3;
        this.f1182b = pVar;
        this.f1183c = cameraDevice;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f1181a) {
            case 0:
                ((CameraDevice.StateCallback) this.f1182b.f1185b).onClosed(this.f1183c);
                break;
            case 1:
                ((CameraDevice.StateCallback) this.f1182b.f1185b).onDisconnected(this.f1183c);
                break;
            default:
                ((CameraDevice.StateCallback) this.f1182b.f1185b).onOpened(this.f1183c);
                break;
        }
    }
}
