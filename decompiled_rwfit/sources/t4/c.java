package t4;

/* loaded from: classes.dex */
public final class c extends m0.b {

    /* renamed from: i, reason: collision with root package name */
    public int f18506i;

    @Override // m0.k, java.util.Map
    public final void clear() {
        this.f18506i = 0;
        super.clear();
    }

    @Override // m0.k, java.util.Map
    public final int hashCode() {
        if (this.f18506i == 0) {
            this.f18506i = super.hashCode();
        }
        return this.f18506i;
    }

    @Override // m0.k
    public final void i(m0.b bVar) {
        this.f18506i = 0;
        super.i(bVar);
    }

    @Override // m0.k
    public final Object j(int i3) {
        this.f18506i = 0;
        return super.j(i3);
    }

    @Override // m0.k
    public final Object k(int i3, Object obj) {
        this.f18506i = 0;
        return super.k(i3, obj);
    }

    @Override // m0.k, java.util.Map
    public final Object put(Object obj, Object obj2) {
        this.f18506i = 0;
        return super.put(obj, obj2);
    }
}
