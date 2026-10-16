package o;

import android.hardware.camera2.params.OutputConfiguration;
import android.view.Surface;
import com.google.android.gms.internal.mlkit_vision_barcode.pd;
import java.util.Objects;

/* loaded from: classes.dex */
public class j {

    /* renamed from: a, reason: collision with root package name */
    public final Object f16627a;

    public j(Object obj) {
        this.f16627a = obj;
    }

    public Object a() {
        Object obj = this.f16627a;
        pd.b(obj instanceof i);
        return ((i) obj).f16624a;
    }

    public String b() {
        return ((i) this.f16627a).f16625b;
    }

    public final Surface c() {
        return ((OutputConfiguration) a()).getSurface();
    }

    public void d(long j4) {
        ((i) this.f16627a).f16626c = j4;
    }

    public void e(int i3) {
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof j)) {
            return false;
        }
        return Objects.equals(this.f16627a, ((j) obj).f16627a);
    }

    public void f(String str) {
        ((i) this.f16627a).f16625b = str;
    }

    public void g(long j4) {
    }

    public final int hashCode() {
        return this.f16627a.hashCode();
    }
}
