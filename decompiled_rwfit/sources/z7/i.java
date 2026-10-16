package z7;

import java.util.ArrayList;

/* loaded from: classes.dex */
public final class i extends o {

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList f20366a;

    public i(ArrayList arrayList) {
        this.f20366a = arrayList;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof o)) {
            return false;
        }
        return this.f20366a.equals(((i) ((o) obj)).f20366a);
    }

    public final int hashCode() {
        return this.f20366a.hashCode() ^ 1000003;
    }

    public final String toString() {
        return "BatchedLogRequest{logRequests=" + this.f20366a + "}";
    }
}
