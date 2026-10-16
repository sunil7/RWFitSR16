package t;

/* loaded from: classes.dex */
public final class j {

    /* renamed from: a, reason: collision with root package name */
    public final c0.o f18350a;

    public j(c0.o oVar) {
        if (oVar == null) {
            throw new NullPointerException("Null surfaceOutput");
        }
        this.f18350a = oVar;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof j)) {
            return false;
        }
        j jVar = (j) obj;
        jVar.getClass();
        return this.f18350a.equals(jVar.f18350a);
    }

    public final int hashCode() {
        return this.f18350a.hashCode() ^ (-721379959);
    }

    public final String toString() {
        return "Event{eventCode=0, surfaceOutput=" + this.f18350a + "}";
    }
}
