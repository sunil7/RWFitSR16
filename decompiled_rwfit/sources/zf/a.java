package zf;

import android.opengl.EGLConfig;

/* loaded from: classes2.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public final EGLConfig f20403a;

    public a(EGLConfig eGLConfig) {
        this.f20403a = eGLConfig;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof a) && kotlin.jvm.internal.e.a(this.f20403a, ((a) obj).f20403a);
    }

    public final int hashCode() {
        return this.f20403a.hashCode();
    }

    public final String toString() {
        return "EglConfig(native=" + this.f20403a + ')';
    }
}
