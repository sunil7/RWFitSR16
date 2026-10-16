package o;

import android.hardware.camera2.params.InputConfiguration;
import java.util.Objects;

/* loaded from: classes.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    public final InputConfiguration f16621a;

    public e(Object obj) {
        this.f16621a = (InputConfiguration) obj;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof e)) {
            return false;
        }
        return Objects.equals(this.f16621a, ((e) obj).f16621a);
    }

    public final int hashCode() {
        return this.f16621a.hashCode();
    }

    public final String toString() {
        return this.f16621a.toString();
    }
}
