package e0;

import android.graphics.Rect;
import android.util.Size;
import java.util.UUID;

/* loaded from: classes.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public final UUID f12411a;

    /* renamed from: b, reason: collision with root package name */
    public final int f12412b;

    /* renamed from: c, reason: collision with root package name */
    public final int f12413c;

    /* renamed from: d, reason: collision with root package name */
    public final Rect f12414d;
    public final Size e;

    /* renamed from: f, reason: collision with root package name */
    public final int f12415f;

    /* renamed from: g, reason: collision with root package name */
    public final boolean f12416g;

    public b(UUID uuid, int i3, int i10, Rect rect, Size size, int i11, boolean z5) {
        if (uuid == null) {
            throw new NullPointerException("Null getUuid");
        }
        this.f12411a = uuid;
        this.f12412b = i3;
        this.f12413c = i10;
        if (rect == null) {
            throw new NullPointerException("Null getCropRect");
        }
        this.f12414d = rect;
        if (size == null) {
            throw new NullPointerException("Null getSize");
        }
        this.e = size;
        this.f12415f = i11;
        this.f12416g = z5;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return this.f12411a.equals(bVar.f12411a) && this.f12412b == bVar.f12412b && this.f12413c == bVar.f12413c && this.f12414d.equals(bVar.f12414d) && this.e.equals(bVar.e) && this.f12415f == bVar.f12415f && this.f12416g == bVar.f12416g;
    }

    public final int hashCode() {
        return ((((((((((((((this.f12411a.hashCode() ^ 1000003) * 1000003) ^ this.f12412b) * 1000003) ^ this.f12413c) * 1000003) ^ this.f12414d.hashCode()) * 1000003) ^ this.e.hashCode()) * 1000003) ^ this.f12415f) * 1000003) ^ (this.f12416g ? 1231 : 1237)) * 1000003) ^ 1237;
    }

    public final String toString() {
        return "OutConfig{getUuid=" + this.f12411a + ", getTargets=" + this.f12412b + ", getFormat=" + this.f12413c + ", getCropRect=" + this.f12414d + ", getSize=" + this.e + ", getRotationDegrees=" + this.f12415f + ", isMirroring=" + this.f12416g + ", shouldRespectInputCropRect=false}";
    }
}
