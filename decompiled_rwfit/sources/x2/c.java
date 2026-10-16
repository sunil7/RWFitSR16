package x2;

/* loaded from: classes.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public final String f19739a;

    /* renamed from: b, reason: collision with root package name */
    public final Long f19740b;

    public c(String str, long j4) {
        this.f19739a = str;
        this.f19740b = Long.valueOf(j4);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        if (!this.f19739a.equals(cVar.f19739a)) {
            return false;
        }
        Long l3 = cVar.f19740b;
        Long l5 = this.f19740b;
        return l5 != null ? l5.equals(l3) : l3 == null;
    }

    public final int hashCode() {
        int hashCode = this.f19739a.hashCode() * 31;
        Long l3 = this.f19740b;
        return hashCode + (l3 != null ? l3.hashCode() : 0);
    }
}
