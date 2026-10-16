package x3;

import android.text.TextUtils;

/* loaded from: classes.dex */
public final class e {
    public static final hc.a e = new hc.a(22);

    /* renamed from: a, reason: collision with root package name */
    public final Object f19772a;

    /* renamed from: b, reason: collision with root package name */
    public final d f19773b;

    /* renamed from: c, reason: collision with root package name */
    public final String f19774c;

    /* renamed from: d, reason: collision with root package name */
    public volatile byte[] f19775d;

    public e(String str, Object obj, d dVar) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("Must not be null or empty");
        }
        this.f19774c = str;
        this.f19772a = obj;
        this.f19773b = dVar;
    }

    public static e a(Object obj, String str) {
        return new e(str, obj, e);
    }

    public final boolean equals(Object obj) {
        if (obj instanceof e) {
            return this.f19774c.equals(((e) obj).f19774c);
        }
        return false;
    }

    public final int hashCode() {
        return this.f19774c.hashCode();
    }

    public final String toString() {
        return r5.a.f(new StringBuilder("Option{key='"), this.f19774c, "'}");
    }
}
