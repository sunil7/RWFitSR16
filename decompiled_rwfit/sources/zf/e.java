package zf;

import android.opengl.EGLSurface;

/* loaded from: classes2.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    public final EGLSurface f20422a;

    public e(EGLSurface eGLSurface) {
        this.f20422a = eGLSurface;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof e) && kotlin.jvm.internal.e.a(this.f20422a, ((e) obj).f20422a);
    }

    public final int hashCode() {
        EGLSurface eGLSurface = this.f20422a;
        if (eGLSurface == null) {
            return 0;
        }
        return eGLSurface.hashCode();
    }

    public final String toString() {
        return "EglSurface(native=" + this.f20422a + ')';
    }
}
