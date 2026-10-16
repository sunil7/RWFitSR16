package wf;

/* loaded from: classes2.dex */
public final class b implements Comparable {

    /* renamed from: a, reason: collision with root package name */
    public final int f19627a;

    /* renamed from: b, reason: collision with root package name */
    public final int f19628b;

    public b(int i3, int i10) {
        this.f19627a = i3;
        this.f19628b = i10;
    }

    public final b a() {
        return new b(this.f19628b, this.f19627a);
    }

    @Override // java.lang.Comparable
    public final int compareTo(Object obj) {
        b bVar = (b) obj;
        return (this.f19627a * this.f19628b) - (bVar.f19627a * bVar.f19628b);
    }

    public final boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (obj instanceof b) {
            b bVar = (b) obj;
            if (this.f19627a == bVar.f19627a && this.f19628b == bVar.f19628b) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int i3 = this.f19627a;
        return ((i3 >>> 16) | (i3 << 16)) ^ this.f19628b;
    }

    public final String toString() {
        return this.f19627a + "x" + this.f19628b;
    }
}
