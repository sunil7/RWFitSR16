package cd;

import java.util.ArrayList;

/* loaded from: classes.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList f3453a;

    /* renamed from: b, reason: collision with root package name */
    public final int f3454b;

    public b(int i3, ArrayList arrayList) {
        this.f3453a = new ArrayList(arrayList);
        this.f3454b = i3;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof b) {
            return this.f3453a.equals(((b) obj).f3453a);
        }
        return false;
    }

    public final int hashCode() {
        return this.f3453a.hashCode();
    }

    public final String toString() {
        return "{ " + this.f3453a + " }";
    }
}
