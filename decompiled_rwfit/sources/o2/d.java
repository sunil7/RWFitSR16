package o2;

import android.net.Uri;

/* loaded from: classes.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public final Uri f16706a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f16707b;

    public d(Uri uri, boolean z5) {
        this.f16706a = uri;
        this.f16707b = z5;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && d.class == obj.getClass()) {
            d dVar = (d) obj;
            if (this.f16707b == dVar.f16707b && this.f16706a.equals(dVar.f16706a)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return (this.f16706a.hashCode() * 31) + (this.f16707b ? 1 : 0);
    }
}
