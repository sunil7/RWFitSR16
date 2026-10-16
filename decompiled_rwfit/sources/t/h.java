package t;

import android.graphics.Rect;
import android.util.Size;

/* loaded from: classes.dex */
public final class h {

    /* renamed from: a, reason: collision with root package name */
    public final Size f18338a;

    /* renamed from: b, reason: collision with root package name */
    public final Rect f18339b;

    /* renamed from: c, reason: collision with root package name */
    public final int f18340c;

    public h(int i3, Rect rect, Size size) {
        this.f18338a = size;
        this.f18339b = rect;
        this.f18340c = i3;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof h) {
            h hVar = (h) obj;
            if (this.f18338a.equals(hVar.f18338a) && this.f18339b.equals(hVar.f18339b) && this.f18340c == hVar.f18340c) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return ((((this.f18338a.hashCode() ^ 1000003) * 1000003) ^ this.f18339b.hashCode()) * 1000003) ^ this.f18340c;
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder("ResolutionInfoInternal{resolution=");
        sb2.append(this.f18338a);
        sb2.append(", cropRect=");
        sb2.append(this.f18339b);
        sb2.append(", rotationDegrees=");
        return r5.a.e(sb2, this.f18340c, "}");
    }
}
