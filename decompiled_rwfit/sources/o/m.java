package o;

import android.hardware.camera2.params.OutputConfiguration;
import com.google.android.gms.internal.mlkit_vision_barcode.pd;

/* loaded from: classes.dex */
public final class m extends l {
    @Override // o.l, o.j
    public final Object a() {
        Object obj = this.f16627a;
        pd.b(obj instanceof OutputConfiguration);
        return obj;
    }

    @Override // o.l, o.j
    public final void d(long j4) {
        ((OutputConfiguration) a()).setDynamicRangeProfile(j4);
    }

    @Override // o.j
    public final void e(int i3) {
        ((OutputConfiguration) a()).setMirrorMode(i3);
    }

    @Override // o.j
    public final void g(long j4) {
        if (j4 == -1) {
            return;
        }
        ((OutputConfiguration) a()).setStreamUseCase(j4);
    }
}
