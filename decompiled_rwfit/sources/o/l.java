package o;

import android.hardware.camera2.params.OutputConfiguration;
import com.google.android.gms.internal.mlkit_vision_barcode.pd;

/* loaded from: classes.dex */
public class l extends j {
    @Override // o.j
    public Object a() {
        Object obj = this.f16627a;
        pd.b(obj instanceof k);
        return ((k) obj).f16628a;
    }

    @Override // o.j
    public final String b() {
        return null;
    }

    @Override // o.j
    public void d(long j4) {
        ((k) this.f16627a).f16629b = j4;
    }

    @Override // o.j
    public final void f(String str) {
        ((OutputConfiguration) a()).setPhysicalCameraId(str);
    }
}
