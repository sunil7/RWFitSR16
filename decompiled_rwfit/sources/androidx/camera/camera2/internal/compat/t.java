package androidx.camera.camera2.internal.compat;

import android.hardware.camera2.CameraManager;

/* loaded from: classes.dex */
public final class t extends CameraManager.AvailabilityCallback {

    /* renamed from: a, reason: collision with root package name */
    public final androidx.camera.core.impl.utils.executor.b f1219a;

    /* renamed from: b, reason: collision with root package name */
    public final androidx.camera.camera2.internal.e f1220b;

    /* renamed from: c, reason: collision with root package name */
    public final Object f1221c = new Object();

    /* renamed from: d, reason: collision with root package name */
    public boolean f1222d = false;

    public t(androidx.camera.core.impl.utils.executor.b bVar, androidx.camera.camera2.internal.e eVar) {
        this.f1219a = bVar;
        this.f1220b = eVar;
    }

    @Override // android.hardware.camera2.CameraManager.AvailabilityCallback
    public final void onCameraAccessPrioritiesChanged() {
        synchronized (this.f1221c) {
            try {
                if (!this.f1222d) {
                    this.f1219a.execute(new androidx.activity.b(this, 4));
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // android.hardware.camera2.CameraManager.AvailabilityCallback
    public final void onCameraAvailable(String str) {
        synchronized (this.f1221c) {
            try {
                if (!this.f1222d) {
                    this.f1219a.execute(new s(this, str, 0));
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // android.hardware.camera2.CameraManager.AvailabilityCallback
    public final void onCameraUnavailable(String str) {
        synchronized (this.f1221c) {
            try {
                if (!this.f1222d) {
                    this.f1219a.execute(new s(this, str, 1));
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }
}
