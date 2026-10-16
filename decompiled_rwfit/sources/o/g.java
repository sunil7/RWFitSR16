package o;

import android.os.Build;

/* loaded from: classes.dex */
public final class g {

    /* renamed from: a, reason: collision with root package name */
    public final e f16622a;

    public g(e eVar) {
        this.f16622a = eVar;
    }

    public static g a(Object obj) {
        if (obj == null) {
            return null;
        }
        return Build.VERSION.SDK_INT >= 31 ? new g(new f(obj)) : new g(new e(obj));
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof g)) {
            return false;
        }
        return this.f16622a.equals(((g) obj).f16622a);
    }

    public final int hashCode() {
        return this.f16622a.hashCode();
    }

    public final String toString() {
        return this.f16622a.toString();
    }
}
