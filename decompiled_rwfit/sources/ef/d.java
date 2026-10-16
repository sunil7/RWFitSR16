package ef;

import android.hardware.Camera;
import com.otaliastudios.cameraview.controls.Facing;

/* loaded from: classes2.dex */
public abstract class d {
    static {
        b.a(d.class.getSimpleName());
    }

    public static boolean a(Facing facing) {
        if (p001if.a.f14421a == null) {
            p001if.a.f14421a = new p001if.a();
        }
        p001if.a.f14421a.getClass();
        int intValue = ((Integer) p001if.a.f14424d.get(facing)).intValue();
        Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
        int numberOfCameras = Camera.getNumberOfCameras();
        for (int i3 = 0; i3 < numberOfCameras; i3++) {
            Camera.getCameraInfo(i3, cameraInfo);
            if (cameraInfo.facing == intValue) {
                return true;
            }
        }
        return false;
    }
}
