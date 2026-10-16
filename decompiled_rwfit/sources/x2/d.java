package x2;

/* loaded from: classes.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public final String f19741a;

    /* renamed from: b, reason: collision with root package name */
    public final int f19742b;

    public d(String str, int i3) {
        this.f19741a = str;
        this.f19742b = i3;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        if (this.f19742b != dVar.f19742b) {
            return false;
        }
        return this.f19741a.equals(dVar.f19741a);
    }

    public final int hashCode() {
        return (this.f19741a.hashCode() * 31) + this.f19742b;
    }
}
