package o2;

import com.google.android.gms.internal.mlkit_vision_barcode.gf;
import com.google.android.gms.internal.mlkit_vision_barcode.l0;

/* loaded from: classes.dex */
public final class p extends gf {

    /* renamed from: a, reason: collision with root package name */
    public final Throwable f16722a;

    public p(Throwable th2) {
        this.f16722a = th2;
    }

    public final String toString() {
        return l0.o("FAILURE (", this.f16722a.getMessage(), ")");
    }
}
