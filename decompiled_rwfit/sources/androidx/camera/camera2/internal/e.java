package androidx.camera.camera2.internal;

import android.hardware.camera2.CameraManager;

/* loaded from: classes.dex */
public final class e extends CameraManager.AvailabilityCallback {

    /* renamed from: a, reason: collision with root package name */
    public final String f1227a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f1228b = true;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ i f1229c;

    public e(i iVar, String str) {
        this.f1229c = iVar;
        this.f1227a = str;
    }

    public final void a() {
        if (this.f1229c.e == Camera2CameraImpl$InternalState.PENDING_OPEN) {
            this.f1229c.I(false);
        }
    }

    @Override // android.hardware.camera2.CameraManager.AvailabilityCallback
    public final void onCameraAvailable(String str) {
        if (this.f1227a.equals(str)) {
            this.f1228b = true;
            if (this.f1229c.e == Camera2CameraImpl$InternalState.PENDING_OPEN) {
                this.f1229c.I(false);
            }
        }
    }

    @Override // android.hardware.camera2.CameraManager.AvailabilityCallback
    public final void onCameraUnavailable(String str) {
        if (this.f1227a.equals(str)) {
            this.f1228b = false;
        }
    }
}
