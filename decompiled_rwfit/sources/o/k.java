package o;

import android.hardware.camera2.params.OutputConfiguration;
import java.util.Objects;

/* loaded from: classes.dex */
public final class k {

    /* renamed from: a, reason: collision with root package name */
    public final OutputConfiguration f16628a;

    /* renamed from: b, reason: collision with root package name */
    public long f16629b = 1;

    public k(OutputConfiguration outputConfiguration) {
        this.f16628a = outputConfiguration;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof k)) {
            return false;
        }
        k kVar = (k) obj;
        return Objects.equals(this.f16628a, kVar.f16628a) && this.f16629b == kVar.f16629b;
    }

    public final int hashCode() {
        int hashCode = this.f16628a.hashCode() ^ 31;
        return Long.hashCode(this.f16629b) ^ ((hashCode << 5) - hashCode);
    }
}
