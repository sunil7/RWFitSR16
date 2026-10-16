package u;

import android.util.Size;
import androidx.camera.core.impl.s0;
import c0.g;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public s0 f18649a;

    /* renamed from: b, reason: collision with root package name */
    public final s0 f18650b = null;

    /* renamed from: c, reason: collision with root package name */
    public final Size f18651c;

    /* renamed from: d, reason: collision with root package name */
    public final int f18652d;
    public final int e;

    /* renamed from: f, reason: collision with root package name */
    public final boolean f18653f;

    /* renamed from: g, reason: collision with root package name */
    public final g f18654g;

    /* renamed from: h, reason: collision with root package name */
    public final g f18655h;

    public a(Size size, int i3, int i10, boolean z5, g gVar, g gVar2) {
        if (size == null) {
            throw new NullPointerException("Null size");
        }
        this.f18651c = size;
        this.f18652d = i3;
        this.e = i10;
        this.f18653f = z5;
        this.f18654g = gVar;
        this.f18655h = gVar2;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return this.f18651c.equals(aVar.f18651c) && this.f18652d == aVar.f18652d && this.e == aVar.e && this.f18653f == aVar.f18653f && this.f18654g.equals(aVar.f18654g) && this.f18655h.equals(aVar.f18655h);
    }

    public final int hashCode() {
        return ((((((((((((this.f18651c.hashCode() ^ 1000003) * 1000003) ^ this.f18652d) * 1000003) ^ this.e) * 1000003) ^ (this.f18653f ? 1231 : 1237)) * 583896283) ^ 35) * 1000003) ^ this.f18654g.hashCode()) * 1000003) ^ this.f18655h.hashCode();
    }

    public final String toString() {
        return "In{size=" + this.f18651c + ", inputFormat=" + this.f18652d + ", outputFormat=" + this.e + ", virtualCamera=" + this.f18653f + ", imageReaderProxyProvider=null, postviewSize=null, postviewImageFormat=35, requestEdge=" + this.f18654g + ", errorEdge=" + this.f18655h + "}";
    }
}
