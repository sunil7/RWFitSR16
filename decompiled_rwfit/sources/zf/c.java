package zf;

import android.opengl.EGLDisplay;

/* loaded from: classes2.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public final EGLDisplay f20405a;

    public c(EGLDisplay eGLDisplay) {
        this.f20405a = eGLDisplay;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof c) && kotlin.jvm.internal.e.a(this.f20405a, ((c) obj).f20405a);
    }

    public final int hashCode() {
        EGLDisplay eGLDisplay = this.f20405a;
        if (eGLDisplay == null) {
            return 0;
        }
        return eGLDisplay.hashCode();
    }

    public final String toString() {
        return "EglDisplay(native=" + this.f20405a + ')';
    }
}
