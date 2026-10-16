package ic;

import java.util.Arrays;
import q9.n;

/* loaded from: classes.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public final int f14405a;

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof b) {
            return this.f14405a == ((b) obj).f14405a && n.h(null, null) && n.h(null, null);
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.f14405a), Boolean.FALSE, null, null});
    }
}
