package d0;

import c0.n;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public final n f12178a;

    /* renamed from: b, reason: collision with root package name */
    public final n f12179b;

    /* renamed from: c, reason: collision with root package name */
    public final ArrayList f12180c;

    public b(n nVar, n nVar2, ArrayList arrayList) {
        if (nVar == null) {
            throw new NullPointerException("Null primarySurfaceEdge");
        }
        this.f12178a = nVar;
        if (nVar2 == null) {
            throw new NullPointerException("Null secondarySurfaceEdge");
        }
        this.f12179b = nVar2;
        this.f12180c = arrayList;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return this.f12178a.equals(bVar.f12178a) && this.f12179b.equals(bVar.f12179b) && this.f12180c.equals(bVar.f12180c);
    }

    public final int hashCode() {
        return ((((this.f12178a.hashCode() ^ 1000003) * 1000003) ^ this.f12179b.hashCode()) * 1000003) ^ this.f12180c.hashCode();
    }

    public final String toString() {
        return "In{primarySurfaceEdge=" + this.f12178a + ", secondarySurfaceEdge=" + this.f12179b + ", outConfigs=" + this.f12180c + "}";
    }
}
