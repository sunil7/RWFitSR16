package bd;

/* loaded from: classes.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    public final int f3211a;

    /* renamed from: b, reason: collision with root package name */
    public final int f3212b;

    public b(int i3, int i10) {
        this.f3211a = i3;
        this.f3212b = i10;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return this.f3211a == bVar.f3211a && this.f3212b == bVar.f3212b;
    }

    public final int hashCode() {
        return this.f3211a ^ this.f3212b;
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(this.f3211a);
        sb2.append("(");
        return android.support.v4.media.session.e.m(sb2, this.f3212b, ')');
    }
}
