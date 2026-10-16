package o;

import android.hardware.camera2.params.OutputConfiguration;
import android.os.Build;
import android.view.Surface;

/* loaded from: classes.dex */
public final class h {

    /* renamed from: a, reason: collision with root package name */
    public final j f16623a;

    public h(int i3, Surface surface) {
        int i10 = Build.VERSION.SDK_INT;
        if (i10 >= 33) {
            this.f16623a = new m(new OutputConfiguration(i3, surface));
        } else if (i10 >= 28) {
            this.f16623a = new l(new k(new OutputConfiguration(i3, surface)));
        } else {
            this.f16623a = new j(new i(new OutputConfiguration(i3, surface)));
        }
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof h)) {
            return false;
        }
        return this.f16623a.equals(((h) obj).f16623a);
    }

    public final int hashCode() {
        return this.f16623a.f16627a.hashCode();
    }

    public h(j jVar) {
        this.f16623a = jVar;
    }
}
