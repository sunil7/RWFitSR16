package e0;

import android.opengl.EGLSurface;

/* loaded from: classes.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public final EGLSurface f12417a;

    /* renamed from: b, reason: collision with root package name */
    public final int f12418b;

    /* renamed from: c, reason: collision with root package name */
    public final int f12419c;

    public c(EGLSurface eGLSurface, int i3, int i10) {
        if (eGLSurface == null) {
            throw new NullPointerException("Null eglSurface");
        }
        this.f12417a = eGLSurface;
        this.f12418b = i3;
        this.f12419c = i10;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof c) {
            c cVar = (c) obj;
            if (this.f12417a.equals(cVar.f12417a) && this.f12418b == cVar.f12418b && this.f12419c == cVar.f12419c) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return ((((this.f12417a.hashCode() ^ 1000003) * 1000003) ^ this.f12418b) * 1000003) ^ this.f12419c;
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder("OutputSurface{eglSurface=");
        sb2.append(this.f12417a);
        sb2.append(", width=");
        sb2.append(this.f12418b);
        sb2.append(", height=");
        return r5.a.e(sb2, this.f12419c, "}");
    }
}
