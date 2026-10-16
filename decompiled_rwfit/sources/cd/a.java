package cd;

import java.util.Objects;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public final bd.b f3450a;

    /* renamed from: b, reason: collision with root package name */
    public final bd.b f3451b;

    /* renamed from: c, reason: collision with root package name */
    public final bd.c f3452c;

    public a(bd.b bVar, bd.b bVar2, bd.c cVar) {
        this.f3450a = bVar;
        this.f3451b = bVar2;
        this.f3452c = cVar;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return Objects.equals(this.f3450a, aVar.f3450a) && Objects.equals(this.f3451b, aVar.f3451b) && Objects.equals(this.f3452c, aVar.f3452c);
    }

    public final int hashCode() {
        return (Objects.hashCode(this.f3450a) ^ Objects.hashCode(this.f3451b)) ^ Objects.hashCode(this.f3452c);
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder("[ ");
        sb2.append(this.f3450a);
        sb2.append(" , ");
        sb2.append(this.f3451b);
        sb2.append(" : ");
        bd.c cVar = this.f3452c;
        sb2.append(cVar == null ? "null" : Integer.valueOf(cVar.f3213a));
        sb2.append(" ]");
        return sb2.toString();
    }
}
