package o;

import android.hardware.camera2.params.OutputConfiguration;
import java.util.Objects;

/* loaded from: classes.dex */
public final class i {

    /* renamed from: a, reason: collision with root package name */
    public final OutputConfiguration f16624a;

    /* renamed from: b, reason: collision with root package name */
    public String f16625b;

    /* renamed from: c, reason: collision with root package name */
    public long f16626c = 1;

    public i(OutputConfiguration outputConfiguration) {
        this.f16624a = outputConfiguration;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof i)) {
            return false;
        }
        i iVar = (i) obj;
        return Objects.equals(this.f16624a, iVar.f16624a) && this.f16626c == iVar.f16626c && Objects.equals(this.f16625b, iVar.f16625b);
    }

    public final int hashCode() {
        int hashCode = this.f16624a.hashCode() ^ 31;
        int i3 = (hashCode << 5) - hashCode;
        String str = this.f16625b;
        int hashCode2 = (str == null ? 0 : str.hashCode()) ^ i3;
        return Long.hashCode(this.f16626c) ^ ((hashCode2 << 5) - hashCode2);
    }
}
