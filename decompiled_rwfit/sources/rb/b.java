package rb;

import java.util.Collections;
import java.util.Map;

/* loaded from: classes.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public final String f18109a;

    /* renamed from: b, reason: collision with root package name */
    public final Map f18110b;

    public b(String str, Map map) {
        this.f18109a = str;
        this.f18110b = map;
    }

    public static o4.c a(String str) {
        o4.c cVar = new o4.c();
        cVar.f16733b = null;
        cVar.f16732a = str;
        return cVar;
    }

    public static b b(String str) {
        return new b(str, Collections.EMPTY_MAP);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return this.f18109a.equals(bVar.f18109a) && this.f18110b.equals(bVar.f18110b);
    }

    public final int hashCode() {
        return this.f18110b.hashCode() + (this.f18109a.hashCode() * 31);
    }

    public final String toString() {
        return "FieldDescriptor{name=" + this.f18109a + ", properties=" + this.f18110b.values() + "}";
    }
}
