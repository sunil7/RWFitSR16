package androidx.camera.camera2.internal.compat;

import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.params.StreamConfigurationMap;
import android.os.Build;
import androidx.camera.camera2.internal.compat.quirk.ExtraSupportedOutputSizeQuirk;
import java.util.HashMap;
import n.m0;

/* loaded from: classes.dex */
public final class n {

    /* renamed from: b, reason: collision with root package name */
    public final a2.d f1178b;

    /* renamed from: c, reason: collision with root package name */
    public final String f1179c;

    /* renamed from: a, reason: collision with root package name */
    public final HashMap f1177a = new HashMap();

    /* renamed from: d, reason: collision with root package name */
    public de.o f1180d = null;

    public n(CameraCharacteristics cameraCharacteristics, String str) {
        if (Build.VERSION.SDK_INT >= 28) {
            this.f1178b = new l(cameraCharacteristics, 3);
        } else {
            this.f1178b = new a2.d(cameraCharacteristics, 3);
        }
        this.f1179c = str;
    }

    public final Object a(CameraCharacteristics.Key key) {
        if (key.equals(CameraCharacteristics.SENSOR_ORIENTATION)) {
            return ((CameraCharacteristics) this.f1178b.f23b).get(key);
        }
        synchronized (this) {
            try {
                Object obj = this.f1177a.get(key);
                if (obj != null) {
                    return obj;
                }
                Object obj2 = ((CameraCharacteristics) this.f1178b.f23b).get(key);
                if (obj2 != null) {
                    this.f1177a.put(key, obj2);
                }
                return obj2;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public final de.o b() {
        if (this.f1180d == null) {
            try {
                StreamConfigurationMap streamConfigurationMap = (StreamConfigurationMap) a(CameraCharacteristics.SCALER_STREAM_CONFIGURATION_MAP);
                if (streamConfigurationMap == null) {
                    throw new IllegalArgumentException("StreamConfigurationMap is null!");
                }
                String str = this.f1179c;
                o4.e eVar = new o4.e();
                eVar.f16737a = (ExtraSupportedOutputSizeQuirk) p.a.f17285a.f(ExtraSupportedOutputSizeQuirk.class);
                eVar.f16738b = new m0(str, 10);
                this.f1180d = new de.o(streamConfigurationMap, eVar);
            } catch (AssertionError | NullPointerException e) {
                throw new IllegalArgumentException(e.getMessage());
            }
        }
        return this.f1180d;
    }
}
