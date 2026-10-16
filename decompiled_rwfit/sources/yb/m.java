package yb;

/* loaded from: classes.dex */
public final class m implements com.google.gson.l {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f20079a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Class f20080b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ com.google.gson.k f20081c;

    public /* synthetic */ m(Class cls, com.google.gson.k kVar, int i3) {
        this.f20079a = i3;
        this.f20080b = cls;
        this.f20081c = kVar;
    }

    @Override // com.google.gson.l
    public final com.google.gson.k a(com.google.gson.e eVar, bc.a aVar) {
        switch (this.f20079a) {
            case 0:
                if (aVar.f3203a == this.f20080b) {
                    return this.f20081c;
                }
                return null;
            default:
                Class cls = this.f20080b;
                Class<?> cls2 = aVar.f3203a;
                if (cls.isAssignableFrom(cls2)) {
                    return new b(this, cls2);
                }
                return null;
        }
    }

    public final String toString() {
        switch (this.f20079a) {
            case 0:
                return "Factory[type=" + this.f20080b.getName() + ",adapter=" + this.f20081c + "]";
            default:
                return "Factory[typeHierarchy=" + this.f20080b.getName() + ",adapter=" + this.f20081c + "]";
        }
    }
}
