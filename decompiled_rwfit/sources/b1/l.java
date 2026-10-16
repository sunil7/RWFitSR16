package b1;

import android.content.res.Resources;

/* loaded from: classes.dex */
public final class l {

    /* renamed from: a, reason: collision with root package name */
    public final Resources f3071a;

    /* renamed from: b, reason: collision with root package name */
    public final Resources.Theme f3072b;

    public l(Resources resources, Resources.Theme theme) {
        this.f3071a = resources;
        this.f3072b = theme;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && l.class == obj.getClass()) {
            l lVar = (l) obj;
            if (this.f3071a.equals(lVar.f3071a) && k1.b.a(this.f3072b, lVar.f3072b)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return k1.b.b(this.f3071a, this.f3072b);
    }
}
