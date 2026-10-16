package androidx.camera.camera2.internal.compat;

import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CameraManager;
import android.os.Build;

/* loaded from: classes.dex */
public class v extends ef.i {
    public static boolean Q(RuntimeException runtimeException) {
        StackTraceElement[] stackTrace;
        if (Build.VERSION.SDK_INT == 28) {
            if ((!runtimeException.getClass().equals(RuntimeException.class) || (stackTrace = runtimeException.getStackTrace()) == null || stackTrace.length < 0) ? false : "_enableShutterSound".equals(stackTrace[0].getMethodName())) {
                return true;
            }
        }
        return false;
    }

    @Override // ef.i
    public void H(String str, androidx.camera.core.impl.utils.executor.b bVar, CameraDevice.StateCallback stateCallback) {
        try {
            ((CameraManager) this.f12629b).openCamera(str, bVar, stateCallback);
        } catch (CameraAccessException e) {
            throw CameraAccessExceptionCompat.toCameraAccessExceptionCompat(e);
        } catch (IllegalArgumentException e10) {
        } catch (SecurityException e11) {
            throw e11;
        } catch (RuntimeException e12) {
            if (!Q(e12)) {
                throw e12;
            }
            throw new CameraAccessExceptionCompat(10001, e12);
        }
    }

    @Override // ef.i
    public final void I(androidx.camera.core.impl.utils.executor.b bVar, androidx.camera.camera2.internal.e eVar) {
        ((CameraManager) this.f12629b).registerAvailabilityCallback(bVar, eVar);
    }

    @Override // ef.i
    public final void P(CameraManager.AvailabilityCallback availabilityCallback) {
        ((CameraManager) this.f12629b).unregisterAvailabilityCallback(availabilityCallback);
    }

    @Override // ef.i
    public CameraCharacteristics t(String str) {
        try {
            return super.t(str);
        } catch (RuntimeException e) {
            if (Q(e)) {
                throw new CameraAccessExceptionCompat(10001, e);
            }
            throw e;
        }
    }
}
