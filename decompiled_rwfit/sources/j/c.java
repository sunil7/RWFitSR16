package j;

import java.util.Map;

/* loaded from: classes.dex */
public final class c implements Map.Entry {

    /* renamed from: a, reason: collision with root package name */
    public final Object f15151a;

    /* renamed from: b, reason: collision with root package name */
    public final Object f15152b;

    /* renamed from: c, reason: collision with root package name */
    public c f15153c;

    /* renamed from: d, reason: collision with root package name */
    public c f15154d;

    public c(Object obj, Object obj2) {
        this.f15151a = obj;
        this.f15152b = obj2;
    }

    @Override // java.util.Map.Entry
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        return this.f15151a.equals(cVar.f15151a) && this.f15152b.equals(cVar.f15152b);
    }

    @Override // java.util.Map.Entry
    public final Object getKey() {
        return this.f15151a;
    }

    @Override // java.util.Map.Entry
    public final Object getValue() {
        return this.f15152b;
    }

    @Override // java.util.Map.Entry
    public final int hashCode() {
        return this.f15151a.hashCode() ^ this.f15152b.hashCode();
    }

    @Override // java.util.Map.Entry
    public final Object setValue(Object obj) {
        throw new UnsupportedOperationException("An entry modification is not supported");
    }

    public final String toString() {
        return this.f15151a + "=" + this.f15152b;
    }
}
