package l1;

import android.view.DisplayCutout;

/* loaded from: classes.dex */
public final class j {

    /* renamed from: a, reason: collision with root package name */
    public final DisplayCutout f15700a;

    public j(DisplayCutout displayCutout) {
        this.f15700a = displayCutout;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || j.class != obj.getClass()) {
            return false;
        }
        return k1.b.a(this.f15700a, ((j) obj).f15700a);
    }

    public final int hashCode() {
        int hashCode;
        hashCode = this.f15700a.hashCode();
        return hashCode;
    }

    public final String toString() {
        return "DisplayCutoutCompat{" + this.f15700a + "}";
    }
}
