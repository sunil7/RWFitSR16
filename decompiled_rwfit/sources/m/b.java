package m;

import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CaptureRequest;
import androidx.camera.core.impl.c;

/* loaded from: classes.dex */
public final class b extends n6.a {

    /* renamed from: c, reason: collision with root package name */
    public static final c f15877c = new c("camera2.captureRequest.templateType", Integer.TYPE, null);

    /* renamed from: d, reason: collision with root package name */
    public static final c f15878d = new c("camera2.cameraCaptureSession.streamUseCase", Long.TYPE, null);
    public static final c e = new c("camera2.cameraDevice.stateCallback", CameraDevice.StateCallback.class, null);

    /* renamed from: f, reason: collision with root package name */
    public static final c f15879f = new c("camera2.cameraCaptureSession.stateCallback", CameraCaptureSession.StateCallback.class, null);

    /* renamed from: g, reason: collision with root package name */
    public static final c f15880g = new c("camera2.cameraCaptureSession.captureCallback", CameraCaptureSession.CaptureCallback.class, null);

    /* renamed from: h, reason: collision with root package name */
    public static final c f15881h = new c("camera2.cameraCaptureSession.physicalCameraId", String.class, null);

    public static c Y(CaptureRequest.Key key) {
        return new c("camera2.captureRequest.option." + key.getName(), Object.class, key);
    }
}
