package androidx.recyclerview.widget;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public int f2509a;

    /* renamed from: b, reason: collision with root package name */
    public int f2510b;

    /* renamed from: c, reason: collision with root package name */
    public Object f2511c;

    /* renamed from: d, reason: collision with root package name */
    public int f2512d;

    public final boolean equals(Object obj) {
        if (this != obj) {
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            int i3 = this.f2509a;
            if (i3 != aVar.f2509a) {
                return false;
            }
            if (i3 != 8 || Math.abs(this.f2512d - this.f2510b) != 1 || this.f2512d != aVar.f2510b || this.f2510b != aVar.f2512d) {
                if (this.f2512d != aVar.f2512d || this.f2510b != aVar.f2510b) {
                    return false;
                }
                Object obj2 = this.f2511c;
                if (obj2 != null) {
                    if (!obj2.equals(aVar.f2511c)) {
                        return false;
                    }
                } else if (aVar.f2511c != null) {
                    return false;
                }
            }
        }
        return true;
    }

    public final int hashCode() {
        return (((this.f2509a * 31) + this.f2510b) * 31) + this.f2512d;
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(Integer.toHexString(System.identityHashCode(this)));
        sb2.append("[");
        int i3 = this.f2509a;
        sb2.append(i3 != 1 ? i3 != 2 ? i3 != 4 ? i3 != 8 ? "??" : "mv" : "up" : "rm" : "add");
        sb2.append(",s:");
        sb2.append(this.f2510b);
        sb2.append("c:");
        sb2.append(this.f2512d);
        sb2.append(",p:");
        sb2.append(this.f2511c);
        sb2.append("]");
        return sb2.toString();
    }
}
