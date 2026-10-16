package o;

import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CaptureRequest;
import java.util.List;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public interface p {
    Object a();

    void b(g gVar);

    int c();

    CameraCaptureSession.StateCallback d();

    List e();

    g f();

    Executor g();

    void h(CaptureRequest captureRequest);
}
