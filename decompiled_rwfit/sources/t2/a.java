package t2;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public boolean f18486a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f18487b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f18488c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f18489d;

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return this.f18486a == aVar.f18486a && this.f18487b == aVar.f18487b && this.f18488c == aVar.f18488c && this.f18489d == aVar.f18489d;
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [boolean, int] */
    public final int hashCode() {
        boolean z5 = this.f18487b;
        ?? r12 = this.f18486a;
        int i3 = r12;
        if (z5) {
            i3 = r12 + 16;
        }
        int i10 = i3;
        if (this.f18488c) {
            i10 = i3 + 256;
        }
        return this.f18489d ? i10 + 4096 : i10;
    }

    public final String toString() {
        return "[ Connected=" + this.f18486a + " Validated=" + this.f18487b + " Metered=" + this.f18488c + " NotRoaming=" + this.f18489d + " ]";
    }
}
