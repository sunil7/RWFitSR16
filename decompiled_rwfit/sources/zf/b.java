package zf;

import android.opengl.EGLContext;

/* loaded from: classes2.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public final EGLContext f20404a;

    public b(EGLContext eGLContext) {
        this.f20404a = eGLContext;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof b) && kotlin.jvm.internal.e.a(this.f20404a, ((b) obj).f20404a);
    }

    public final int hashCode() {
        EGLContext eGLContext = this.f20404a;
        if (eGLContext == null) {
            return 0;
        }
        return eGLContext.hashCode();
    }

    public final String toString() {
        return "EglContext(native=" + this.f20404a + ')';
    }
}
