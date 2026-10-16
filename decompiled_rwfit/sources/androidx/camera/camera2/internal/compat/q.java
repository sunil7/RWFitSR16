package androidx.camera.camera2.internal.compat;

import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.params.InputConfiguration;
import android.os.Handler;
import com.google.android.gms.internal.mlkit_vision_barcode.l0;
import com.google.android.gms.internal.mlkit_vision_common.a0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public class q extends a2.h {
    public void D(o.q qVar) {
        CameraDevice cameraDevice = (CameraDevice) this.f36a;
        cameraDevice.getClass();
        o.p pVar = qVar.f16636a;
        pVar.d().getClass();
        List e = pVar.e();
        if (e == null) {
            throw new IllegalArgumentException("Invalid output configurations");
        }
        if (pVar.g() == null) {
            throw new IllegalArgumentException("Invalid executor");
        }
        String id2 = cameraDevice.getId();
        Iterator it = e.iterator();
        while (it.hasNext()) {
            String b3 = ((o.h) it.next()).f16623a.b();
            if (b3 != null && !b3.isEmpty()) {
                a0.e("CameraDeviceCompat", l0.q("Camera ", id2, ": Camera doesn't support physicalCameraId ", b3, ". Ignoring."));
            }
        }
        i iVar = new i(pVar.g(), pVar.d());
        List e10 = pVar.e();
        k kVar = (k) this.f37b;
        kVar.getClass();
        o.g f2 = pVar.f();
        Handler handler = kVar.f1176a;
        try {
            if (f2 != null) {
                InputConfiguration inputConfiguration = f2.f16622a.f16621a;
                inputConfiguration.getClass();
                cameraDevice.createReprocessableCaptureSessionByConfigurations(inputConfiguration, o.q.a(e10), iVar, handler);
            } else {
                if (pVar.c() != 1) {
                    cameraDevice.createCaptureSessionByOutputConfigurations(o.q.a(e10), iVar, handler);
                    return;
                }
                ArrayList arrayList = new ArrayList(e10.size());
                Iterator it2 = e10.iterator();
                while (it2.hasNext()) {
                    arrayList.add(((o.h) it2.next()).f16623a.c());
                }
                cameraDevice.createConstrainedHighSpeedCaptureSession(arrayList, iVar, handler);
            }
        } catch (CameraAccessException e11) {
            throw CameraAccessExceptionCompat.toCameraAccessExceptionCompat(e11);
        }
    }
}
