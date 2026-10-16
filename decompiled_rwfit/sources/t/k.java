package t;

import android.view.Surface;

/* loaded from: classes.dex */
public final class k {

    /* renamed from: a, reason: collision with root package name */
    public final int f18352a;

    /* renamed from: b, reason: collision with root package name */
    public final Surface f18353b;

    public k(int i3, Surface surface) {
        this.f18352a = i3;
        if (surface == null) {
            throw new NullPointerException("Null surface");
        }
        this.f18353b = surface;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof k)) {
            return false;
        }
        k kVar = (k) obj;
        return this.f18352a == kVar.f18352a && this.f18353b.equals(kVar.f18353b);
    }

    public final int hashCode() {
        return this.f18353b.hashCode() ^ ((this.f18352a ^ 1000003) * 1000003);
    }

    public final String toString() {
        return "Result{resultCode=" + this.f18352a + ", surface=" + this.f18353b + "}";
    }
}
