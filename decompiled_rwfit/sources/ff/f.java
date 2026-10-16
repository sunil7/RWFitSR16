package ff;

import android.hardware.camera2.CaptureRequest;
import android.location.Location;
import java.util.Arrays;

/* loaded from: classes2.dex */
public final class f implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f13609a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ n f13610b;

    public /* synthetic */ f(n nVar, int i3) {
        this.f13609a = i3;
        this.f13610b = nVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i3 = 0;
        n nVar = this.f13610b;
        switch (this.f13609a) {
            case 0:
                CaptureRequest.Builder builder = nVar.Z;
                Location location = nVar.f13661s;
                if (location != null) {
                    builder.set(CaptureRequest.JPEG_GPS_LOCATION, location);
                }
                nVar.Y();
                break;
            case 1:
                nVar.z();
                break;
            default:
                nVar.getClass();
                new gf.h(Arrays.asList(new j(nVar, i3), new hf.c(1))).l(nVar);
                break;
        }
    }

    public f(n nVar, Location location) {
        this.f13609a = 0;
        this.f13610b = nVar;
    }
}
