package n;

import android.hardware.camera2.CameraCharacteristics;
import android.media.ImageWriter;
import androidx.camera.camera2.internal.compat.quirk.ZslDisablerQuirk;

/* loaded from: classes.dex */
public final class z0 {

    /* renamed from: a, reason: collision with root package name */
    public final androidx.camera.camera2.internal.compat.n f16328a;

    /* renamed from: b, reason: collision with root package name */
    public final de.o f16329b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f16330c = false;

    /* renamed from: d, reason: collision with root package name */
    public final boolean f16331d;
    public final boolean e;

    /* renamed from: f, reason: collision with root package name */
    public t.z0 f16332f;

    /* renamed from: g, reason: collision with root package name */
    public g0.g f16333g;

    /* renamed from: h, reason: collision with root package name */
    public androidx.camera.core.impl.s0 f16334h;

    /* renamed from: i, reason: collision with root package name */
    public ImageWriter f16335i;

    public z0(androidx.camera.camera2.internal.compat.n nVar) {
        boolean z5;
        this.f16331d = false;
        this.e = false;
        this.f16328a = nVar;
        int[] iArr = (int[]) nVar.a(CameraCharacteristics.REQUEST_AVAILABLE_CAPABILITIES);
        if (iArr != null) {
            for (int i3 : iArr) {
                if (i3 == 4) {
                    z5 = true;
                    break;
                }
            }
        }
        z5 = false;
        this.f16331d = z5;
        this.e = p.a.f17285a.f(ZslDisablerQuirk.class) != null;
        this.f16329b = new de.o(new x0(0));
    }
}
